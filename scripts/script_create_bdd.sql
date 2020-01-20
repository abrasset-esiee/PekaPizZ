CREATE DATABASE Pekapizz;
USE Pekapizz;

CREATE TABLE IF NOT EXISTS Taille(
   id_taille INT,
   ratio DECIMAL(15,2),
   PRIMARY KEY(id_taille)
);


CREATE TABLE IF NOT EXISTS Ingredient(
   id_ingredient INT,
   nom VARCHAR(50),
   provenance VARCHAR(50),
   PRIMARY KEY(id_ingredient)
);


CREATE TABLE  IF NOT EXISTS Vehicule(
   immatriculation CHAR(9),
   voiture tinyint(1),
   couleur VARCHAR(50),
   modele VARCHAR(50),
   annee VARCHAR(50),
   PRIMARY KEY(immatriculation)
);


CREATE TABLE  IF NOT EXISTS Pizza(
   id_pizza VARCHAR(50),
   nom VARCHAR(50),
   prix_base DECIMAL(2,2),
   PRIMARY KEY(id_pizza)
);


CREATE TABLE  IF NOT EXISTS Livreur(
   id_livreur VARCHAR(50),
   nom VARCHAR(50),
   prenom VARCHAR(50),
   PRIMARY KEY(id_livreur)
);


CREATE TABLE  IF NOT EXISTS Adresse(
   id_adresse INT,
   Numero_rue VARCHAR(5),
   nom_rue VARCHAR(50),
   code_postal CHAR(5),
   ville VARCHAR(50),
   PRIMARY KEY(id_adresse)
);


CREATE TABLE IF NOT EXISTS  Client(
   id_client INT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   solde DECIMAL(5,2),
   id_adresse INT NOT NULL,
   PRIMARY KEY(id_client),
   FOREIGN KEY(id_adresse) REFERENCES Adresse(id_adresse)
);


CREATE TABLE  IF NOT EXISTS Livraison(
   id_client INT,
   id_taille INT,
   immatriculation CHAR(9),
   id_pizza VARCHAR(50),
   id_livreur VARCHAR(50),
   date_livraison DATETIME,
   date_reception DATETIME,
   PRIMARY KEY(id_client, id_taille, immatriculation, id_pizza, id_livreur),
   FOREIGN KEY(id_client) REFERENCES Client(id_client),
   FOREIGN KEY(id_taille) REFERENCES Taille(id_taille),
   FOREIGN KEY(immatriculation) REFERENCES Véhicule(immatriculation),
   FOREIGN KEY(id_pizza) REFERENCES Pizza(id_pizza),
   FOREIGN KEY(id_livreur) REFERENCES Livreur(id_livreur)
);


CREATE TABLE  IF NOT EXISTS Composition(
   id_ingredient INT,
   id_pizza VARCHAR(50),
   PRIMARY KEY(id_ingredient, id_pizza),
   FOREIGN KEY(id_ingredient) REFERENCES Ingredient(id_ingredient),
   FOREIGN KEY(id_pizza) REFERENCES Pizza(id_pizza)
);