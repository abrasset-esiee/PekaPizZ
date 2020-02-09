package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class StatsController {
    @FXML
    private Label livreur_worst;
    @FXML
    private Label livreur_best;
    @FXML
    private Label pizza_best;
    @FXML
    private Label ingredient_best;
    @FXML
    private Label client_best;
    @FXML
    private Label pizza_avg;
    @FXML
    private Label vehicule_best;
    @FXML
    private Label vehicule_worst;
    @FXML
    private TableView list_livraisons;
    @FXML
    private TableView list_clients;
    @FXML
    private TableView list_livreurs;
    @FXML
    private TableView list_vehicules;
    @FXML
    private Button back;

    public void back() throws Exception{
        Controller.changeScene(back.getScene(), "/View/main.fxml");
    }


}
