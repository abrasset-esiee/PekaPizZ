package controller;

import javafx.fxml.FXML;
import Model.Pizza;

public class CommandController {

    static Pizza commande;
    


    @FXML
    public void initialize() {

    		
    	System.out.println(commande.getNom());


    }


}
