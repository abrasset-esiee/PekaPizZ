package controller;

import Model.Adresse;
import Model.Client;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            livreur_best.setText(new LivreurController().findBest().toString());
            vehicule_worst.setText(new VehiculeController().findMoreLate().toString());
            vehicule_best.setWrapText(true);
            vehicule_worst.setWrapText(true);
            vehicule_best.setText(new VehiculeController().findBest().toString());
            pizza_best.setText(new PizzaController().findBestSelling().toString());
            ingredient_best.setText((new IngredientController().findBest().toString()));
            client_best.setText((new ClientController().findBest().toString()));
            pizza_avg.setText(String.valueOf(new LivraisonController().averagePizzaSize()).substring(0,5) + " €");




            ObservableList<ClientTable> ol = FXCollections.observableArrayList();
            HashMap<Client,Integer> nb = new LivraisonController().nbCommandeAll();

            for(Map.Entry<Client,Integer> res : nb.entrySet()){


                ol.add(new ClientTable(res.getKey(), res.getValue()));
            }



            TableColumn idNameCol = new TableColumn("ID");
            TableColumn firstNameCol = new TableColumn("First Name");
            TableColumn lastNameCol = new TableColumn("Last Name");
            TableColumn soldeCol = new TableColumn("Solde");
            TableColumn commandeCol = new TableColumn("Nb Commande");
            TableColumn adrrCol = new TableColumn("Adresse");

            list_clients.getColumns().addAll(idNameCol, firstNameCol,lastNameCol,soldeCol,commandeCol,adrrCol);

            idNameCol.setCellValueFactory(new PropertyValueFactory<ClientTable,Integer>("id"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("nom"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("prenom"));
            soldeCol.setCellValueFactory(new PropertyValueFactory<ClientTable,Double>("solde"));
            commandeCol.setCellValueFactory(new PropertyValueFactory<ClientTable,Integer>("nbCommande"));
            adrrCol.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("adresseTable"));

            list_clients.setItems(ol);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected class ClientTable extends Client{

        private IntegerProperty nbCommande;
        private StringProperty adresseTable;

        private ClientTable(Client client,int nbCommande){
            super(client.getId(),client.getNom(),client.getPrenom(),client.getSolde(),client.getAdresse());
            this.nbCommande = new SimpleIntegerProperty(nbCommande);
            this.adresseTable = new SimpleStringProperty(getAdresse().toString());

        }
        IntegerProperty nbCommandeProperty(){
            return nbCommande;
        }

        public int getNbCommande() {
            return nbCommande.get();
        }

        public String getAdresseTable() {
            return adresseTable.get();
        }

        StringProperty adresseTable(){
            return adresseTable;
        }
    }
}




