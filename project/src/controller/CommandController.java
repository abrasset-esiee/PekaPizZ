package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    public void initialize() {
    	
    	

        double trunc_inf = ((int)(commande.getPrix_base()* 1.33 * 100)) / 100.0;
        double trunc_sup = ((int)(commande.getPrix_base()* 0.66 * 100)) / 100.0;

    	
    	pizzController.setName(commande.getNom());
    	pizzController.setIngredients(commande.getIngredients());
    	pizzController.setPrix(commande.getPrix_base());
    	pizzController.setPizzaComponents(commande.getIngredients());
    	prix_inf.setText(String.valueOf(trunc_inf + " €"));
    	prix_sup.setText(trunc_sup + " €");
    	


    }


}
