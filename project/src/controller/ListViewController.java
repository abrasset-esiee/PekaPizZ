package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import Model.Pizza;

import java.io.IOException;
import java.sql.SQLException;


public class ListViewController {

    @FXML
    private ListView<Pizza> pizz_list;
    private ObservableList<Pizza> listViewData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        pizz_list.setCellFactory(new PizzaCellFactory());

        //Initialize pizzas
        try {
			listViewData.addAll(new PizzaController().findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        pizz_list.setItems(listViewData);

       
    }

    @FXML
    public void setScene_menu() throws IOException {
        Controller.changeScene(pizz_list.getScene(),"/View/menu.fxml");


    }


}


