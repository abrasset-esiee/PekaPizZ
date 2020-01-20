INSERT INTO adresse (nom_rue, Numero_rue, code_postal, Ville)
VALUES
('Rue de la rue', '1', '60110', 'Meru'),
('Route de la route', '57', '93270', 'Pointe a Pitre'),
("Avenue de l'avenue", '3', '44530', 'Annecy');

INSERT INTO client (nom, prenom, solde, id_adresse)
VALUES
('JEAN', 'Jacques', '0', 1),
('CHEVESSIER', 'Yoann', '0', 2),
('BRASSET', 'Alexis', '0', 3);

INSERT INTO composition (id_pizza, id_ingredient)
VALUES
(1,5),
(1,3),
(1,2),
(1,8),

(2,9),
(2,7),
(2,5),
(2,3),

(3,1),
(3,2),
(3,6),
(3,7),

(4,3),
(4,8),
(4,9),
(4,2),

(5,4),
(5,3),
(5,2),
(5,5);

INSERT INTO ingredient (nom, provenance)
VALUES
('Patate', 'France'),
('Tomate', 'Espagne'),
('Oignons', 'Autriche'),
('Creme fraiche', 'Hongrie'),
('Poulet', 'Inde'),
('Boeuf', 'Amérique'),
('Reblochon', 'Jura'),
('Poivrons', 'Argentine'),
('Champignons', 'France');

INSERT INTO livraison(id_livreur, id_pizza, immatriculation, id_taille, id_client, date_livraison, date_reception)
VALUES
(1, 3, 'ABR65BX5T', 2, 3, '20/01/2020 18:12:32', '20/01/2020 20:00:00'),
(2, 1, '65QHNT56X', 3, 1, '14/01/2020 15:25:59', '15/01/2020 13:45:00'),
(3, 4, '10CFQ45MJ', 1, 2, '01/01/2020 00:00:01', '02/01/2020 07:30:00');

INSERT INTO livreur(nom, prenom)
VALUES
('JEAN-POL', 'Paul'),
('JAK', 'Jean-Jacques'),
('YO-ANNE', 'Ane');

INSERT INTO pizza (nom, prix_base)
VALUES
('La Speciale', '13.99'),
('La DrataPizZ', '15.01'),
('La Garbegienne', '5.90'),
('Pouet PizZ', '17.22'),
('Fababulistique', '20.24');

INSERT INTO taille (id_taille, ratio)
VALUES
(1, 0.66),
(2, 1),
(3, 1.33);

INSERT INTO vehicule (immatriculation, voiture, couleur, modele, annee)
VALUES
('ABR65BX5T', 1, 'Rouge', 'Fiat multiplat', '2009'),
('65QHNT56X', 1, 'Cyan', 'Bac a legume', '2014'),
('10CFQ45MJ', 0, 'Metal', 'Tricycle', '1903');