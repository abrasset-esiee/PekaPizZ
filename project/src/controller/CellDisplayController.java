package controller;

import java.util.HashSet;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class CellDisplayController {
	
	public CellDisplayController(){
		
		//System.out.println("test");
		
		
	}
	
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


    void initialize(){
    	
    	System.out.println("test");
    	
    	
    }
    
    public void setPizzaComponents(HashSet<String> list) {

		
		pizz_back.setVisible(true);
   
    	pizz_olive.setVisible(list.contains("olive"));

		pizz_egg.setVisible(list.contains("oeuf"));

		pizz_poivron.setVisible(list.contains("poivrons"));

		pizz_mozarella.setVisible(list.contains("mozarella"));

    }
    
    void setName(String s){
    	
    	pizz_name.setText(s);
    }

}
