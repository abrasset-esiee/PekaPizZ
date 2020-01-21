ALTER TABLE client ADD CONSTRAINT chk_client CHECK (solde >= 0);
ALTER TABLE ingredient ADD CONSTRAINT uni_ingredien UNIQUE (nom);
ALTER TABLE livraison ADD CONSTRAINT chk_livraison TIMEDIFF(date_livraison, date_commande) > "00:00";
ALTER TABLE pizza ADD CONSTRAINT uni_pizza UNIQUE (nom);
ALTER TABLE pizza ADD CONSTRAINT chk_pizza CHECK (prix_base > 0);
ALTER TABLE taille ADD CONSTRAINT chk_taille CHECK (ratio > 0);
