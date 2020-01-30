package controller;

import java.util.HashSet;

import Model.Ingredient;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class CellDisplayController {
	
	@FXML
    private Group pizz_icon;

    @FXML
    private Group pizz_olive;
    
    @FXML
    private Group pizz_back;
    
    @FXML
    private Group pizz_egg;
    
    @FXML
    private Label pizz_prix;
    
    @FXML
    private Group pizz_poivron;
    
    @FXML
    private Group pizz_mozarella;
    
    @FXML
    private Text pizz_name;

    @FXML
    private Text pizz_ingredients;

    @FXML
    private Group pizz_patate;

    @FXML
    private Group pizz_tomatoes;

    @FXML
    private Group pizz_creme;

    @FXML
    private Group pizz_oignons;

    @FXML
    private Group pizz_chicken;

    @FXML
    private Group pizz_reblo;

    @FXML
    private Group pizz_champi;

    @FXML
    private Group pizz_boeuf;

    @FXML
    private Group pizz_reblo;

    @FXML
    private Group pizz_champi;

    @FXML
    private Group pizz_ananas;

    @FXML
    private Group pizz_basilic;
    @FXML
    private Group pizz_artichaut;
    @FXML
    private Group pizz_chevre;
    @FXML
    private Group pizz_chorizo;
    @FXML
    private Group pizz_peperonni;
    @FXML
    private Group pizz_hache;
    @FXML
    private Group pizz_romarin;
    @FXML
    private Group pizz_ail;
    @FXML
    private Group pizz_origan;
    @FXML
    private Group pizz_anchois;
    @FXML
    private Group pizz_jambon;
    @FXML
    private Group pizz_piment;
    @FXML
    private Group pizz_emmental;
    @FXML
    private Group pizz_saumon;
    @FXML
    private Group pizz_lardon;
    @FXML
    private Group pizz_merguez;
    @FXML
    private Group pizz_kangourou;
    @FXML
    private Group pizz_thon;
    @FXML
    private Group pizz_roquefort;

    @FXML
    private Group pizz_gruyere;

    @FXML
    private Group pizz_capres;

    @FXML
    private Group pizz_grison;

    @FXML
    private Group pizz_parmesan;





    public void setPizzaComponents(HashSet<String> list) {

		
		pizz_back.setVisible(true);

        pizz_patate.setVisible((list.contains("Patate")));
        pizz_tomatoes.setVisible(list.contains("Tomate"));
        pizz_oignons.setVisible(list.contains("Oignons"));
        pizz_creme.setVisible(list.contains("Crème fraiche"));
        pizz_chicken.setVisible(list.contains("Poulet"));
        pizz_boeuf.setVisible(list.contains("Boeuf"));
        pizz_reblo.setVisible(list.contains("Reblochon"));
        pizz_poivron.setVisible(list.contains("Poivrons"));
        pizz_champi.setVisible(list.contains("Champignons"));

        pizz_mozarella.setVisible(list.contains("mozarella"));


        pizz_egg.setVisible(list.contains("oeuf"));

        pizz_olive.setVisible(list.contains("olive"));




    }
    
    void setName(String s){
    	
    	pizz_name.setText(s);
    }

    void setIngredients(HashSet<String> list){
        StringBuilder s = new StringBuilder();

        for (String ingredient : list) {
            s.append(ingredient + ", ");

        }
        s.delete(s.length() - 2, s.length());

        pizz_ingredients.setText(s.toString());
    }

    void setPrix(double prix){

        pizz_prix.setText(prix + " €");

    }

}
