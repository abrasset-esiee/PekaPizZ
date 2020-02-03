
INSERT INTO Adresse(nom_rue, Numero_rue, code_postal, Ville)
VALUES
('Mondes du Noyau',             '1',    '60110', 'Alderaan'),
('Bordure extérieure',          '38',   '69552', 'Bastion'),
('Bordure intérieure',          '66',   '92937', 'Bespin'),
('Noyau profond',               '3',    '84500', 'Corellia'),
('Capitale nouvel République',  '13',   '64632', 'Coruscant'),
('Régions inconnues',           '54',   '81454', 'Dagobah'),
('Localisation inconnue	',      '42',   '34579', 'Dantooine'),
('Colonies',                    '11',   '36024', 'Dathomir'),
('Bras de Tingel',              '63',   '67755', 'Dromund Kaas'),
("Zone d'expansion",            '49',   '34495', 'Endor'),
('Capitale Fédération',         '33',   '22887', 'Géonosis'),
('Monde rebelle',               '9',    '52709', 'Hoth'),
('Planète des Clones',          '18',   '30263', 'Kamino'),
('Bordure médiane',             '6',    '45674', 'Kashyyyk'),
('Capitale nouvel Empire',      '42',   '20915', 'Kessel'),
('Planète des Quarren',         '57',   '56800', 'Mon Calamari'),
('Forteresse Vador',            '30',   '63374', 'Mustafar'),
('Capitale Humaine',            '46',   '32053', 'Naboo'),
('Planète des Hutts',           '69',   '30677', 'Tatooine'),
("Base de l'Alliance Rebelle",  '30',   '97949', 'Yavin IV');

INSERT INTO Client(nom, prenom, solde, id_adresse)
VALUES
('DARK',    'Vador',    '0', 1),
('DARTH',   'Sidious',  '0', 2),
('MARKO',   'Ragnos',   '0', 3),
('AJUNTA',  'Pall',     '0', 4),
('EXAR',    'Kun',      '0', 5),
('FREEDON', 'Nadd',     '0', 6),
('NAGA',    'Sadow',    '0', 7),
('QEL',     'Droma',    '0', 8),
('BAN',     'Yutura',   '0', 9),
('DARK',    'Andeddu',  '0', 10),
('DARK',    'Krayt',    '0', 11),
('DARK',    'Acharon',  '0', 12),
('DARTH',   'Angral',   '0', 13),
('DARTH',   'Nihilus',  '0', 14),
('LORD',    'Revan',    '0', 15),
('ALEX',    'Malak',    '0', 16),
('COUNT',   'Dooku',    '0', 17),
('JORI',    'Daragon',  '0', 18),
('DARK',    'Maul',     '0', 19),
('HETT',    "A'Sharad", '0', 20);

INSERT INTO Ingredient(nom, provenance)
VALUES
('Patate',              'France'),
('Tomate',              'Espagne'),
('Oignons',             'Autriche'),
('Creme fraiche',       'Hongrie'),
('Poulet',              'Inde'),
('Boeuf',               'Amérique'),
('Reblochon',           'Jura'),
('Poivrons',            'Argentine'),
('Champignons',         'France'),
('Salade',              'Felucia'),
('Mozzarella',          'Italie'),
('Oeuf',                'Italie'),
('Ananas',              'Quebec'),
('Basilic',             'Kamino'),
('Olive',               'Tatooine'),
('Artichaud',           'Endor'),
('Chorizo',             'Hot'),
('Peperonni',           'Italie'),
('Viande haché',        'Pologne'),
('Romarins',            'Espagne'),
('Ail',                 'France'),
('Origan',              'Portugal'),
('Anchois',             'Pays-Bas'),
('Jambon',              'Allemagne'),
('Parmesan',            'Italie'),
('Chèvres',             'Ecosse'),
('Piment',              'Mustafar'),
('Gorgonzolla',         'Italie'),
('Emental',             'France'),
('Saumons',             'Norvège'),
('Lardons',             'Etat-Unis'),
('Merguez',             'Andorre'),
('Salami',              'Saint-marin'),
('Kangourou',           'Lichtenstein'),
('Thon',                'Vatican'),
('Roquefort',           'Japon'),
('Gruyère',             'France'),
('Câpres',              'Bretagne'),
('Viande de grison',    'Grison');

INSERT INTO Pizza(nom, prix_base)
VALUES
('La Speciale',         '13.99'),
('La DrataPizZ',        '15.00'),
('La Garbegienne',      '5.90'),
('Pouet PizZ',          '17.50'),
('La PekapizZ',         '38.99'),
("L'orbitale",          '13.00'),
("L'étoile de la mort", '11.50'),
('La Tusken',           '29.75'),
('La Double Sabre',     '26.99'),
('La Sénatrice',        '11.99'),
("L'empereur",          '17.80'),
('La Sith',             '23.99'),
('Hello There',         '15.00'),
('General Kenobi',      '16.00'),
('Do or do not',        '13.50'),
('There is no try',     '14.75'),
('Felucienne',          '25.80'),
('La Dagobah',          '12.99'),
('La mandalorienne',    '23.00'),
('Le nouvel empire',    '10.99'),
('La résistance',       '28.00'),
("L'ancien empire",     '16.50'),
('La scission Jedi',    '22.50'),
('La forge Stellaire',  '12.75'),
('Korriban',            '27.00');

INSERT INTO Composition (id_pizza, id_ingredient)
VALUES
(1,4),
(1,29),
(1,7),
(1,17),
(1,25),

(2,36),
(2,2),
(2,33),
(2,9),
(2,35),

(3,18),
(3,34),
(3,19),
(3,23),
(3,20),

(4,3),
(4,11),
(4,27),
(4,12),
(4,33),

(5,25),
(5,4),
(5,1),
(5,39),
(5,19),

(6,31),
(6,28),
(6,12),
(6,16),
(6,13),

(7,12),
(7,20),
(7,21),
(7,19),
(7,18),

(8,32),
(8,27),
(8,25),
(8,12),
(8,3),

(9,7),
(9,8),
(9,27),
(9,32),
(9,37),

(10,20),
(10,12),
(10,21),
(10,29),
(10,33),

(11,26),
(11,29),
(11,4),
(11,23),
(11,20),

(12,26),
(12,30),
(12,1),
(12,19),
(12,29),

(13,23),
(13,28),
(13,27),
(13,17),
(13,4),

(14,34),
(14,11),
(14,5),
(14,21),
(14,27),

(15,14),
(15,3),
(15,9),
(15,10),
(15,11),

(16,6),
(16,2),
(16,1),
(16,34),
(16,8),

(17,33),
(17,26),
(17,22),
(17,19),
(17,8),

(18,11),
(18,24),
(18,13),
(18,31),
(18,39),

(19,11),
(19,6),
(19,10),
(19,24),
(19,28),

(20,16),
(20,13),
(20,27),
(20,21),
(20,7),

(21,9),
(21,15),
(21,32),
(21,37),
(21,28),

(22,26),
(22,35),
(22,31),
(22,24),
(22,18),

(23,13),
(23,5),
(23,23),
(23,2),
(23,7),

(24,5),
(24,32),
(24,20),
(24,10),
(24,13),

(25,39),
(25,38),
(25,37),
(25,36),
(25,35);

INSERT INTO Taille(id_taille, ratio)
VALUES
(1, 0.66),
(2, 1),
(3, 1.33);

INSERT INTO Livreur(nom, prenom)
VALUES
('KENOBI',      'Obi-Wan'),
('SHAN',        'BASTILA'),
('MASTER',      'Yoda'),
('SKYWALKER',   'Anakin'),
('SKYWALKER',   'Luke'),
('SOLO',        'Han'),
('PLO',         'Koon'),
('KIT',         'Fisto'),
('SECURA',      'Aayala'),
('MACE',        'Windu'),
('AHSOKA',      'Tano'),
('MASTER',      'Yoda'),
('QI-GON',      'Jinn'),
('BINKS',       'JAR-JAR'),
('AMIDALA',     'Padmé'),
('KIADI',       'Mundi'),
('CHEWIE',      'Chewbacca'),
('ORGANA',      'Leia'),
('CALRISSIA',   'Lando');

INSERT INTO Vehicule(immatriculation, voiture, couleur, modele, annee)
VALUES
('ABR65BX5T', 1, 'Rouge', 'Fiat multiplat', '2009'),
('65QHNT56X', 1, 'Cyan', 'Bac a legume', '2014'),
('84HRO10BK', 0, 'Blouge', 'Panier a salade', '2003'),
('LOL2G4USK', 1, 'Magenta', 'Poubelle', '2010'),
('10CFQ45MJ', 0, 'Metal', 'Tricycle', '1903');

INSERT INTO Livraison(id_livreur, id_pizza, immatriculation, id_taille, id_client, date_commande, date_livraison)
VALUES
(1,  1, '84HRO10BK', 1, 1,  '2020-01-01 11:00:32',  '2020-01-20 11:25:00'),
(15, 2, '10CFQ45MJ', 2, 2,  '2020-01-02 12:00:59',  '2020-01-02 12:45:00'),
(13, 22, 'LOL2G4USK', 3, 3,  '2020-01-03 13:15:40',  '2020-01-03 13:45:00'),
(9,  4, 'ABR65BX5T', 1, 4,  '2020-01-04 18:30:00',  '2020-01-04 18:45:00'),
(7,  5, '10CFQ45MJ', 2, 5,  '2020-01-05 19:45:10',  '2020-01-05 20:12:00'),
(14, 6, '10CFQ45MJ', 3, 6,  '2020-01-06 20:00:59',  '2020-01-06 20:45:00'),
(2,  7, '84HRO10BK', 1, 7,  '2020-01-07 21:15:02',  '2020-01-07 21:45:00'),
(1,  8, '65QHNT56X', 2, 8,  '2020-01-08 22:25:00',  '2020-01-08 22:40:00'),
(4,  9, '84HRO10BK', 3, 9,  '2020-01-09 23:30:36',  '2020-01-09 00:00:00'),
(12, 10, 'LOL2G4USK', 1, 10,  '2020-01-10 11:35:59',  '2020-01-10 12:25:00'),
(5,  11, 'LOL2G4USK', 2, 11,  '2020-01-11 12:55:49',  '2020-01-11 13:05:00'),
(11, 12, '65QHNT56X', 3, 12,  '2020-01-12 13:45:59',  '2020-01-12 14:00:00'),
(19, 13, 'ABR65BX5T', 1, 13,  '2020-01-13 18:25:23',  '2020-01-13 18:45:00'),
(6,  14, '10CFQ45MJ', 2, 14,  '2020-01-14 19:30:59',  '2020-01-14 20:20:00'),
(17, 15, '65QHNT56X', 3, 15,  '2019-12-15 20:00:59',  '2020-01-15 20:30:00'),
(2,  16, 'ABR65BX5T', 1, 16,  '2020-01-16 21:12:10',  '2020-01-16 21:22:00'),
(3,  17, '84HRO10BK', 2, 17,  '2020-01-17 22:10:59',  '2020-01-17 22:31:00'),
(16, 18, 'LOL2G4USK', 3, 18,  '2020-01-18 23:00:45',  '2020-01-18 23:17:00'),
(18, 19, 'LOL2G4USK', 1, 19,  '2020-01-19 11:30:59',  '2020-01-19 11:52:00'),
(5,  20, '65QHNT56X', 2, 20,  '2020-01-20 12:25:17',  '2020-01-20 12:37:00'),
(9,  21, '65QHNT56X', 3, 3,  '2020-01-21 13:25:59',  '2020-01-21 13:48:00'),
(1,  22, '84HRO10BK', 1, 7,  '2020-01-22 18:27:00',  '2020-01-22 19:02:00'),
(2,  23, '10CFQ45MJ', 2, 8,  '2020-01-23 19:34:25',  '2020-01-23 19:45:00'),
(3,  24, '65QHNT56X', 3, 12,  '2020-01-24 20:25:30',  '2020-01-24 20:46:00'),
(4,  25, '65QHNT56X', 1, 19,  '2020-01-25 21:54:59',  '2020-01-25 22:17:00'),
(5,  12, 'ABR65BX5T', 2, 1,  '2020-01-26 22:25:58',  '2020-01-26 22:59:00'),
(6,  13, '10CFQ45MJ', 3, 2,  '2020-01-27 11:17:45',  '2020-01-27 11:33:00'),
(7,  4, '65QHNT56X', 1, 3,  '2019-12-01 12:25:49',  '2019-12-01 12:41:00'),
(8,  21, 'ABR65BX5T', 2, 4,  '2019-12-02 13:56:59',  '2019-12-02 14:32:00'),
(9,  14, '65QHNT56X', 3, 5,  '2019-12-03 18:25:37',  '2019-12-03 18:54:00'),
(10, 17, '84HRO10BK', 1, 6,  '2019-12-04 19:25:59',  '2019-12-04 19:43:00'),
(11, 2, 'ABR65BX5T', 2, 7,  '2019-12-05 20:24:25',  '2019-12-05 20:47:00'),
(12, 2, 'LOL2G4USK', 3, 8,  '2019-12-06 21:25:59',  '2019-12-06 21:39:00'),
(13, 2, '65QHNT56X', 1, 9,  '2019-12-07 22:44:59',  '2019-12-07 23:12:00'),
(14, 22, '10CFQ45MJ', 2, 10,  '2019-12-08 23:25:14',  '2019-12-08 23:39:00'),
(15, 18, '65QHNT56X', 3, 11,  '2019-12-09 11:46:59',  '2019-12-09 12:27:00'),
(16, 25, '84HRO10BK', 1, 12,  '2019-12-10 12:37:59',  '2019-12-10 13:03:00'),
(17, 25, 'ABR65BX5T', 2, 13,  '2019-12-11 13:25:59',  '2019-12-11 13:45:00'),
(18, 24, 'LOL2G4USK', 3, 14,  '2019-12-12 20:30:20',  '2019-12-12 20:52:00'),
(19, 25, 'ABR65BX5T', 1, 15,  '2019-12-13 21:25:10',  '2019-12-13 22:00:00'),
(1,  4, '84HRO10BK', 2, 16,  '2019-12-14 18:23:00',  '2019-12-14 18:51:00'),
(3,  22, 'ABR65BX5T', 3, 18,  '2019-12-15 19:25:59',  '2019-12-15 19:42:00'),
(4,  2, 'LOL2G4USK', 1, 19,  '2019-12-16 23:25:59',  '2019-12-16 23:47:00'),
(5,  1, '65QHNT56X', 2, 20,  '2019-12-17 11:18:30',  '2019-12-17 11:34:00'),
(6,  1, 'ABR65BX5T', 3, 15,  '2019-12-18 12:25:59',  '2019-12-18 12:43:00'),
(7,  4, '10CFQ45MJ', 1, 10,  '2020-12-19 13:00:01',  '2019-12-19 13:22:00'),
(8,  12, 'LOL2G4USK', 2, 11,  '2019-12-20 18:37:59',  '2019-12-20 19:01:00'),
(9,  11, '65QHNT56X', 3, 13,  '2019-12-21 19:04:59',  '2019-12-21 19:32:00'),
(10, 10, '10CFQ45MJ', 1, 19,  '2019-12-22 20:25:59',  '2019-12-22 20:50:00'),
(11, 9, '65QHNT56X', 2, 1,  '2019-12-23 21:43:59',  '2019-12-23 22:11:00'),
(12, 8, '10CFQ45MJ', 3, 2,  '2019-12-24 22:25:25',  '2019-12-24 22:49:00'),
(13, 9, '10CFQ45MJ', 1, 3,  '2019-12-25 23:30:59',  '2019-12-25 23:57:00'),
(14, 8, 'LOL2G4USK', 2, 4,  '2019-12-26 11:19:59',  '2019-12-26 11:39:00'),
(15, 4, '65QHNT56X', 3, 5,  '2019-12-27 12:25:22',  '2019-12-27 12:53:00'),
(16, 4, '84HRO10BK', 1, 6,  '2019-12-28 13:25:00',  '2019-12-28 13:46:00'),
(17, 7, '84HRO10BK', 2, 7,  '2019-12-29 18:24:59',  '2019-12-29 18:50:00'),
(18, 4, 'ABR65BX5T', 3, 8,  '2019-12-30 19:12:18',  '2019-12-30 19:32:00'),
(19, 23, '65QHNT56X', 1, 9,  '2019-12-31 20:25:14',  '2019-12-31 20:50:00'),
(1,  21, '10CFQ45MJ', 2, 10,  '2019-11-01 21:01:00',  '2019-11-01 21:25:00');
