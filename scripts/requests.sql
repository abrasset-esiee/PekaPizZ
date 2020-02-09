-- Nombre total de pizzas achetés par un client X
SELECT COUNT(id_livraison) FROM Livraison WHERE id_client=X;
-- Temps d'une livraison X
SELECT TIMEDIFF(date_livraison, date_commande) FROM Livraison WHERE id_livraison=X;
-- Meilleur client
SELECT *
FROM (
    SELECT l.id_client, COUNT(l.id_client) nbCommande
    FROM Livraison l
    GROUP BY l.id_client
) as x
WHERE x.nbCommande = (
    SELECT MAX(nbCommande)
    FROM (
        SELECT m.id_client, COUNT(m.id_client) nbCommande
        FROM Livraison m
        GROUP BY m.id_client
    ) as y
);
-- Livreur au plus grand nombre retard
SELECT *
FROM (
    SELECT l.id_livreur, COUNT(l.id_livreur) nbRetard
    FROM Livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) > "00:30:00"
    GROUP BY l.id_livreur
) as x
WHERE x.nbRetard = (
    SELECT MAX(nbRetard)
    FROM (
        SELECT m.id_livreur, COUNT(m.id_livreur) nbRetard
        FROM Livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) > "00:30:00"
        GROUP BY m.id_livreur
    ) as y
);
-- Livreur au plus grand nombre a l'heure
SELECT *
FROM (
    SELECT l.id_livreur, COUNT(l.id_livreur) nbAlheure
    FROM Livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) <= "00:30:00"
    GROUP BY l.id_livreur
) as x
WHERE x.nbAlheure = (
    SELECT MAX(nbAlheure)
    FROM (
        SELECT m.id_livreur, COUNT(m.id_livreur) nbAlheure
        FROM Livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) <= "00:30:00"
        GROUP BY m.id_livreur
    ) as y
);
-- Vehicule ayant le plus de retard
SELECT *
FROM (
    SELECT l.immatriculation, COUNT(l.immatriculation) nbRetard
    FROM Livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) > "00:30:00"
    GROUP BY l.immatriculation
) as x
WHERE x.nbRetard = (
    SELECT MAX(nbRetard)
    FROM (
        SELECT m.immatriculation, COUNT(m.immatriculation) nbRetard
        FROM Livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) > "00:30:00"
        GROUP BY m.immatriculation
    ) as y
);
-- Vehicule ayant le plus de livraison à l'heure
SELECT *
FROM (
    SELECT l.immatriculation, COUNT(l.immatriculation) nbAlheure
    FROM Livraison l
    WHERE TIMEDIFF(l.date_livraison, l.date_commande) <= "00:30:00"
    GROUP BY l.immatriculation
) as x
WHERE x.nbAlheure = (
    SELECT MAX(nbAlheure)
    FROM (
        SELECT m.immatriculation, COUNT(m.immatriculation) nbAlheure
        FROM Livraison m
        WHERE TIMEDIFF(m.date_livraison, m.date_commande) <= "00:30:00"
        GROUP BY m.immatriculation
    ) as y
);
-- Pizza la plus commandé
SELECT *
FROM (
    SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande
    FROM Livraison l
    GROUP BY l.id_pizza
) as x
WHERE x.nbCommande = (
    SELECT MAX(nbCommande)
    FROM (
        SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande
        FROM Livraison m
        GROUP BY m.id_pizza
    ) as y
);
-- Pizza la moins commandé
SELECT *
FROM (
    SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande
    FROM Livraison l
    GROUP BY l.id_pizza
) as x
WHERE x.nbCommande = (
    SELECT MIN(nbCommande)
    FROM (
        SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande
        FROM Livraison m
        GROUP BY m.id_pizza
    ) as y
);
-- Plus celles jamais commandées
SELECT id_pizza
FROM Pizza
WHERE id_pizza NOT IN (
    SELECT id_pizza
    FROM Livraison
);
-- Ingredient favori
SELECT *
FROM (
    SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient
    FROM Livraison l
    INNER JOIN composition c ON l.id_pizza = c.id_pizza
    GROUP BY c.id_ingredient
) as x
WHERE x.nbIngredient = (
    SELECT MAX(nbIngredient)
    FROM (
        SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient
        FROM Livraison l
        INNER JOIN composition c ON l.id_pizza = c.id_pizza
        GROUP BY c.id_ingredient
    ) as y
);
-- Vehicule jamais utilisé
SELECT immatriculation
FROM Vehicule
WHERE immatriculation NOT IN (
    SELECT immatriculation
    FROM Livraison
);
-- Nombre de commande par client
SELECT id_client, COUNT(id_livraison) FROM Livraison GROUP BY id_client;
-- Prix moyen des pizzas en fonction de leur taille
SELECT AVG(ratio * p.prix_base) as moyenne FROM Livraison l INNER JOIN Pizza p ON p.id_pizza = l.id_pizza INNER JOIN Taille t ON l.id_taille = t.id_taille;
