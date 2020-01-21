-- Nombre total de pizzas achetés par un client X
SELECT COUNT(id_livraison) FROM livraison WHERE id_client=X;
-- Temps d'une livraison X
SELECT TIMEDIFF(date_livraison, date_commande) FROM livraison WHERE id_livraison=X;
-- Meilleur client
SELECT COUNT(id_livraison)
FROM livraison 
HAVING COUNT(id_livraison) = (
    SELECT MAX(COUNT(id_livraison)) 
    FROM livraison 
    GROUP BY id_client
)
GROUP BY id_client;
-- Livreur au plus grand nombre retard
SELECT id_livreur
FROM livraison
HAVING COUNT(id_livraison) = (
    SELECT MAX(COUNT(id_livraison))
    FROM livraison
    HAVING TIMEDIFF(date_livraison, date_commande) > "00:30"
    GROUP BY id_livreur
)
GROUP BY id_livreur;
-- Vehicule ayant le plus de retard
SELECT immatriculation
FROM livraison
HAVING COUNT(id_livraison) = (
    SELECT MAX(COUNT(id_livraison))
    FROM livraison
    HAVING TIMEDIFF(date_livraison, date_commande) > "00:30"
    GROUP BY immatriculation
)
GROUP BY immatriculation;
-- Pizza la plus commandé
SELECT id_pizza
FROM livraison
HAVING COUNT(id_livraison) = (
    SELECT MAX(COUNT(id_livraison))
    FROM livraison
    GROUP BY id_pizza
)
GROUP BY id_pizza;
-- Pizza la moins commandé
SELECT id_pizza
FROM livraison
HAVING COUNT(id_livraison) = (
    SELECT MIN(COUNT(id_livraison))
    FROM livraison
    GROUP BY id_pizza
)
GROUP BY id_pizza;
-- Ingredient favori
SELECT id_ingredient
FROM composition
HAVING COUNT(id_ingredient) = (
    SELECT MAX(COUNT(id_ingredient))
    FROM composition
    HAVING id_pizza IN (
        SELECT id_pizza
        FROM livraison
        GROUP BY id_pizza
    )
    GROUP BY id_ingredient
)
GROUP BY id_ingredient;
-- Vehicule jamais utilisé
SELECT immatriculation
FROM Vehicule
WHERE immatriculation NOT IN (
    SELECT immatriculation
    FROM livraison
);
-- Nombre de commande par client
SELECT id_client, COUNT(id_livraison) FROM livraison GROUP BY id_client;
