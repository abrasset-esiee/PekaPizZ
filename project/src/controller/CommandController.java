package controller;

import javafx.fxml.FXML;
import Model.Pizza;

public class CommandController {

    static Pizza commande;
    
    // controller of counter.fxml injected here
    @FXML
    private PizzaCell countController;

    @FXML
    public void initialize() {

    		
    	System.out.println(commande.getNom());


    }


}
