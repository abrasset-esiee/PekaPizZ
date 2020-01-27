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
