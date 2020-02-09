package controller;

import Model.Client;
import Model.Livraison;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    void initialize(){
        try {
            livreur_worst.setText(new LivreurController().findMoreLate().toString());
            vehicule_worst.setText(new VehiculeController().findMoreLate().toString());
            pizza_best.setText(new PizzaController().findBestSelling().toString());
            ingredient_best.setText((new IngredientController().findBest().toString()));
            client_best.setText((new ClientController().findBest().toString()));




            ObservableList<Client> ol = FXCollections.observableArrayList();

            ol.addAll( new ClientController().findAll());


            TableColumn idNameCol = new TableColumn("ID");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn soldeCol = new TableColumn("Solde");
            TableColumn commandeCol = new TableColumn("Nb Commande");
            TableColumn adrrCol = new TableColumn("Adresse");
            list_clients.getColumns().addAll(idNameCol, firstNameCol,lastNameCol,soldeCol,commandeCol,adrrCol);

            idNameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
            soldeCol.setCellValueFactory(new PropertyValueFactory<Client,String>("solde"));

            list_clients.setItems(ol);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
