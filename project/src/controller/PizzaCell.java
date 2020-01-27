package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Model.Pizza;
import controller.Controller;

import java.io.IOException;
import java.util.HashSet;

public class PizzaCell extends ListCell<Pizza> {

    @FXML
     pizza_elem;

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
    private ListCell pizz_cell;
    
    @FXML
    private CellDisplayController displayController;



    @FXML
    private Text pizz_name;

    @FXML
    private Text pizz_ingredients;

    Pizza pizza;

    public PizzaCell() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/pizz_element.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void updateItem(Pizza item, boolean empty) {
        super.updateItem(item, empty);
        pizza = item;
        if (empty) {

            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
        	
        	System.out.print(displayController);
        	//displayController.setPizzaComponents(item.getIngredients());
        	System.out.print(displayController);
        	//displayController.setName(item.getNom());
            //getCellController
            
            
            //A changer apres modele
            pizz_name.setText(item.getNom());
            pizz_ingredients.setText(getIngredientsString());
            pizz_prix.setText(String.valueOf(item.getPrix_base()) + " €");
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }


    
    @FXML
    public void onClickCell() throws IOException {
        //CommandController.commande = pizza;

        pizz_cell.getScene().setRoot(new FXMLLoader(getClass().getResource("/View/commande.fxml")).load());
        pizza_elem
        System.out.println(pizza_elem.getId());
        System.out.println("test click : " + pizza.getNom());
        System.out.println(this.isSelected());

    }
    
    String getIngredientsString(){
    	
    	
    	StringBuilder s = new StringBuilder();

        for (String ingredient : pizza.getIngredients()) {
            s.append(ingredient + ", ");

        }
        s.delete(s.length() - 2, s.length());

        return s.toString(); 
    	
    }
    
    public Pizza getPizza(){
    	
    	
    	
    	return pizza;
    }
}
