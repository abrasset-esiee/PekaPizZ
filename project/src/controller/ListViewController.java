package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import Model.Pizza;

import java.io.IOException;


public class ListViewController {

    @FXML
    private ListView<Pizza> pizz_list;
    private ObservableList<Pizza> listViewData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {


        pizz_list.setCellFactory(new PizzaCellFactory());


        /*Pizza p = new Pizza();
        p.setNom("Pizza1");
        p.setIngredient("olive");
        p.setPrix_base(15.32);

        Pizza p2 = new Pizza();
        p2.setNom("Pizza2");
        p2.setIngredient("olive");
        p2.setIngredient("oeuf");
        p2.setIngredient("poivrons");
        p2.setPrix_base(15.32);

        Pizza p3 = new Pizza();
        p3.setNom("Pizza3");
        p3.setIngredient("olive");
        p3.setIngredient("oeuf");
        p3.setPrix_base(15.32);

        Pizza p4 = new Pizza();
        p4.setNom("Pizza4");
        p4.setIngredient("olive");
        p4.setIngredient("oeuf");
        p4.setPrix_base(15.32);

        Pizza p5 = new Pizza();
        p5.setNom("Pizza5");
        p5.setIngredient("olive");
        p5.setIngredient("oeuf");
        p5.setPrix_base(15.32);

        listViewData.add(p);
        listViewData.add(p2);
        listViewData.add(p3);
        listViewData.add(p4);
        listViewData.add(p5);*/


        pizz_list.setItems(listViewData);
        //pizz_list.getSelectionModel().getSelectedItem();
       
    }

    @FXML
    public void setScene_menu() throws IOException {
        Controller.changeScene(pizz_list.getScene(),"/View/menu.fxml");


    }


}


