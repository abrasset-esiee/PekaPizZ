package controller;

import java.util.HashMap;
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
    
    @FXML
    private Group pizz_salami;






    public void setPizzaComponents(HashSet<Ingredient> list_ingredients) {

    	HashSet<String> list = new HashSet<>();

        HashMap<String,Group> dict = new HashMap<>();
        dict.put("Patate",pizz_patate);
        dict.put("Oignons",pizz_oignons);
        dict.put("Creme fraiche",pizz_creme);
        dict.put("Poulet",pizz_chicken);
        dict.put("Boeuf",pizz_boeuf);
        dict.put("pizz_reblo",pizz_patate);
        dict.put("Reblochon",pizz_reblo);
        dict.put("Poivrons",pizz_poivron);
        dict.put("Champignons",pizz_champi);
        dict.put("Mozarella",pizz_mozarella);
        dict.put("Oeuf",pizz_egg);
        dict.put("Ananas",pizz_ananas);
        dict.put("Basilic",pizz_ananas);
        dict.put("Ananas",pizz_ananas);
        dict.put("Ananas",pizz_basilic);
        dict.put("Olive",pizz_olive);
        dict.put("Artichaud",pizz_artichaut);
        dict.put("Chorizo",pizz_chorizo);
        dict.put("Peperonni",pizz_peperonni);
        dict.put("Viande haché",pizz_hache);
        dict.put("Romarins",pizz_romarin);
        dict.put("Ail",pizz_ail);
        dict.put("Origan",pizz_origan);
        dict.put("Anchois",pizz_anchois);
        dict.put("Jambon",pizz_jambon);
        dict.put("Parmesan",pizz_parmesan);
        dict.put("Chèvres",pizz_chevre);
        dict.put("Piment",pizz_piment);
        dict.put("Emental",pizz_emmental);
        dict.put("Saumons",pizz_saumon);
        dict.put("Lardons",pizz_lardon);
        dict.put("Merguez",pizz_merguez);
        dict.put("Salami",pizz_salami);
        dict.put("Kangourou",pizz_kangourou);
        dict.put("Thon",pizz_thon);
        dict.put("Roquefort",pizz_roquefort);
        dict.put("Gruyère",pizz_gruyere);
        dict.put("Gruyère",pizz_gruyere);
        dict.put("Câpres",pizz_capres);
        dict.put("Viande de grison",pizz_grison);


    	for(Ingredient ing : list_ingredients){
    		list.add(ing.getNom());
    		
    	}
		
		pizz_back.setVisible(true);

        for(String key : dict.keySet()){
            Group ingredient = dict.get(key);
            if(list.contains(key))
                ingredient.setVisible(true);
            else{
                ingredient.setVisible(false);
                pizz_icon.getChildren().remove(ingredient);
            }

        }

        //salade
        //gorgonzolla

    }
    
    void setName(String s){
    	
    	pizz_name.setText(s);
    }

    void setIngredients(HashSet<Ingredient> list){
        StringBuilder s = new StringBuilder();

        for (Ingredient ingredient : list) {
            s.append(ingredient.getNom() + "(" + ingredient.getProvenance() +")" +  ", ");

        }
        //s.delete(s.length() - 2, s.length());

        pizz_ingredients.setText(s.toString());
    }

    void setPrix(double prix){

        pizz_prix.setText(prix + " €");

    }

}
