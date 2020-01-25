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
import model.Pizza;
import controller.Controller;

import java.io.IOException;
import java.util.HashSet;

public class PizzaCell extends ListCell<Pizza> {

    @FXML
    Parent pizza_elem;

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
            setPizzaComponents(item.getIngredientsList());
            //A changer apres modele
            pizz_name.setText(item.getNom());
            pizz_ingredients.setText(item.getIngredients());
            pizz_prix.setText(String.valueOf(item.getPrix_base()) + " €");
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }


    private void setPizzaComponents(HashSet<String> list) {

    		
    		pizz_back.setVisible(true);
       
        	pizz_olive.setVisible(list.contains("olive"));

    		pizz_egg.setVisible(list.contains("oeuf"));
 
    		pizz_poivron.setVisible(list.contains("poivrons"));

    		pizz_mozarella.setVisible(list.contains("mozarella"));

    }
    @FXML
    public void onClickCell() throws IOException {
        CommandController.commande = pizza;

        pizz_cell.getScene().setRoot(new FXMLLoader(getClass().getResource("/View/commande.fxml")).load());
        System.out.println(this.isSelected());
        System.out.println("test click : " + pizza.getNom());
        System.out.println(this.isSelected());

    }
}
