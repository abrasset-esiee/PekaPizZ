-- Nombre total de pizzas achetés par un client X
SELECT COUNT(id_livraison) FROM livraison WHERE id_client=X;
-- Temps d'une livraison X
SELECT TIMEDIFF(date_livraison, date_commande) FROM livraison WHERE id_livraison=X;
-- Meilleur client
SELECT *
FROM (
    SELECT l.id_client, COUNT(l.id_client) nbCommande 
    FROM livraison l 
    GROUP BY l.id_client
) as x
WHERE x.nbCommande = (	
    SELECT MAX(nbCommande)
    FROM (
        SELECT m.id_client, COUNT(m.id_client) nbCommande
        FROM livraison m 
        GROUP BY m.id_client
    ) as y
);
-- Livreur au plus grand nombre retard
SELECT *
FROM (
    SELECT l.id_livreur, COUNT(l.id_livreur) nbRetard
    FROM livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) > "00:30:00"
    GROUP BY l.id_livreur
) as x
WHERE x.nbRetard = (
    SELECT MAX(nbRetard)
    FROM (
        SELECT m.id_livreur, COUNT(m.id_livreur) nbRetard
        FROM livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) > "00:30:00"
        GROUP BY m.id_livreur
    ) as y
);
-- Vehicule ayant le plus de retard
SELECT *
FROM (
    SELECT l.immatriculation, COUNT(l.immatriculation) nbRetard
    FROM livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) > "00:30:00"
    GROUP BY l.immatriculation
) as x
WHERE x.nbRetard = (
    SELECT MAX(nbRetard)
    FROM (
        SELECT m.immatriculation, COUNT(m.immatriculation) nbRetard
        FROM livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) > "00:30:00"
        GROUP BY m.immatriculation
    ) as y
);
-- Pizza la plus commandé
SELECT *
FROM (
    SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande
    FROM livraison l
    GROUP BY l.id_pizza
) as x
WHERE x.nbCommande = (
    SELECT MAX(nbCommande)
    FROM (
        SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande
        FROM livraison m
        GROUP BY m.id_pizza
    ) as y
);
-- Pizza la moins commandé
SELECT *
FROM (
    SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande
    FROM livraison l
    GROUP BY l.id_pizza
) as x
WHERE x.nbCommande = (
    SELECT MIN(nbCommande)
    FROM (
        SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande
        FROM livraison m
        GROUP BY m.id_pizza
    ) as y
);
-- Plus celles jamais commandées
SELECT id_pizza
FROM pizza
WHERE id_pizza NOT IN (
    SELECT id_pizza
    FROM livraison
);
-- Ingredient favori
SELECT *
FROM (
    SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient
    FROM livraison l
    INNER JOIN composition c ON l.id_pizza = c.id_pizza
    GROUP BY c.id_ingredient
) as x
WHERE x.nbIngredient = (
    SELECT MAX(nbIngredient)
    FROM (
        SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient
        FROM livraison l
        INNER JOIN composition c ON l.id_pizza = c.id_pizza
        GROUP BY c.id_ingredient
    ) as y
);
-- Vehicule jamais utilisé
SELECT immatriculation
FROM Vehicule
WHERE immatriculation NOT IN (
    SELECT immatriculation
    FROM livraison
);
-- Nombre de commande par client
SELECT id_client, COUNT(id_livraison) FROM livraison GROUP BY id_client;