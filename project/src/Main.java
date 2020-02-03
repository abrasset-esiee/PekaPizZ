import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import Model.*;
import controller.*;
import dao.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/main.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("PekaPizZ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) throws SQLException {
        launch(args);
        
//        Ingredient ingredient1 = new Ingredient(1, "test", "test1");
//        Pizza pizza1 = new Pizza(1, "test", 15.00);
//        pizza1.setIngredient(ingredient1);
//        
        ClientDAO dao = new ClientController();
//        System.out.println("\npersonnes presentes:");
//		//lecture de toutes les Personnes
//		List<Client> col=dao.findAll();
//		for(Client p: col){
//			System.out.println(p);
//		}
		
//		Adresse a1 = new Adresse("100", "belec", "37390", "Tours");
//		Client joe = new Client("Malusoui", "Joe", 20.0, a1);
//		dao.create(joe);
//		List<Client> col1=dao.findAll();
//		for(Client p: col1) {
//			System.out.println(p);
//		}
		
//		System.out.println(dao.findByID(7));
//		
		Client client7 = dao.findByID(7);
//		client7.setSolde(20.0);
//		dao.update(client7);
//		
//		Client Malusoui = dao.findByID(39);
//		dao.delete(Malusoui);
//		PizzaDAO daoPizza = new PizzaController();
//		
//		System.out.println(daoPizza.pizzaByClient(client7));
		
		//lecture de toutes les Personnes
		LivraisonDAO daoLivraison = new LivraisonController();
//		List<Livraison> col2=daoLivraison.findAllByID(7);
//		for(Livraison p: col2){
//			System.out.println(p);
//		}
//		
//		Livraison l2 = daoLivraison.findByID(10);
//		System.out.println(l2);
		LivreurDAO daoLivreur = new LivreurController();
		Livreur livreur = daoLivreur.findByID(1);
		
		PizzaDAO daoPizza = new PizzaController();
		Pizza pizza = daoPizza.findByID(1);
		
		VehiculeDAO daoVehicule = new VehiculeController();
		Vehicule vehicule = daoVehicule.findByID("10CFQ45MJ");
		
		TailleDAO daoTaille = new TailleController();
		Taille taille = daoTaille.findByID(2);
		
		Livraison l1 = new Livraison(livreur, pizza, vehicule, taille, client7, new Date(2019, 11, 01) , new Date(2019, 11, 01));
		daoLivraison.create(l1);
    }
}
