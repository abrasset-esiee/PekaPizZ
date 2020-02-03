package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import Model.Pizza;

public class CommandController {

    static Pizza commande;
    
    @FXML
    private CellDisplayController pizzController;

    @FXML
    private Label prix_inf;
    
    @FXML
    private Label prix_sup;
    
    @FXML
    private Button pizz_back;


    @FXML
    public void initialize() {
    	
    	

        double trunc_sup = ((int)(commande.getPrix_base()* 1.33 * 100)) / 100.0;
        double trunc_inf = ((int)(commande.getPrix_base()* 0.66 * 100)) / 100.0;

    	
    	pizzController.setName(commande.getNom());
    	pizzController.setIngredients(commande.getIngredients());
    	pizzController.setPrix(commande.getPrix_base());
    	pizzController.setPizzaComponents(commande.getIngredients());
    	prix_inf.setText(String.valueOf(trunc_inf + " €"));
    	prix_sup.setText(trunc_sup + " €");
    	


    }
    
    
    @FXML
    public void back() throws IOException{
    	Controller.changeScene(pizz_back.getScene(),"/View/pizz_display.fxml");
    	
    	
    }


}
