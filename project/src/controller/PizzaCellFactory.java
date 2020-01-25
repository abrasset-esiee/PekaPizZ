package controller;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import model.Pizza;


public class PizzaCellFactory implements Callback<ListView<Pizza>, ListCell<Pizza>> {


    @Override
    public ListCell<Pizza> call(ListView<Pizza> param) {
        return new PizzaCell();
    }
}