ALTER TABLE Client ADD CONSTRAINT chk_client CHECK (solde >= 0);
ALTER TABLE Ingredient ADD CONSTRAINT uni_ingredien UNIQUE (nom);
-- ALTER TABLE livraison ADD CONSTRAINT chk_livraison TIMEDIFF(date_livraison, date_commande) > "00:00";
ALTER TABLE Pizza ADD CONSTRAINT uni_pizza UNIQUE (nom);
ALTER TABLE Pizza ADD CONSTRAINT chk_pizza CHECK (prix_base > 0);
ALTER TABLE Taille ADD CONSTRAINT chk_taille CHECK (ratio > 0);
