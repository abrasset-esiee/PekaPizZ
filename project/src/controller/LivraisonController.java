package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.*;
import dao.*;

public class LivraisonController implements LivraisonDAO {
	private static final String FINDALL_DELIVERY_REQ = "SELECT id_livraison, id_livreur, id_pizza, immatriculation, id_taille, id_client, date_commande, date_livraison FROM Livraison WHERE id_client = ?";
	private static final String FIND_DELIVERY_REQ = "SELECT id_livraison, id_livreur, id_pizza, immatriculation, id_taille, id_client, date_commande, date_livraison FROM Livraison WHERE id_livraison = ?";
	
	private static final String NB_COMMANDE_ALL_REQ = "SELECT id_client, COUNT(id_livraison) as nbCommande FROM Livraison GROUP BY id_client";
	
	private static final String CREATE_DELIVERY = "INSERT INTO Livraison (id_livraison, id_livreur, id_pizza, immatriculation, id_taille, id_client, date_commande, date_livraison) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_DELIVERY = "UPDATE Livraison SET id_livraison = ?, id_livreur = ?, id_pizza = ?, immatriculation = ?, id_taille = ?, id_client = ?, date_commande = ?, date_livraison = ? WHERE id_livraison = ?";
	private static final String DELETE_DELIVERY = "DELETE FROM Livraison WHERE id_livraison = ?";
	
	private static final String TIMEDIFF_DELIVERY_REQ = "SELECT TIMEDIFF(date_livraison, date_commande) as time_Diff FROM Livraison WHERE id_livraison = ?";
	
	private static final String AVG_PRICE_SIZE_PIZZA = "SELECT AVG(ratio * p.prix_base) as moyenne FROM Livraison l INNER JOIN Pizza p ON p.id_pizza = l.id_pizza INNER JOIN Taille t ON l.id_taille = t.id_taille";
	
	@Override
	public List<Livraison> findAllByID(int id) throws SQLException {
		Connection con = null;
		ArrayList<Livraison> l1 = new ArrayList<Livraison>();
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FINDALL_DELIVERY_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {
				// find for "Livreur"
				LivreurDAO daoLivreur = new LivreurController();
				Livreur livreur = daoLivreur.findByID(result.getInt("id_livreur"));
				
				// find for "Pizza"
				PizzaDAO daoPizza = new PizzaController();
				Pizza pizza = daoPizza.findByID(result.getInt("id_pizza"));
				
				// find for "Vehicule"
				VehiculeDAO daoVehicule = new VehiculeController();
				Vehicule vehicule = daoVehicule.findByID(result.getString("immatriculation"));
				
				// find for "Client"
				TailleDAO daoTaille = new TailleController();
				Taille taille = daoTaille.findByID(result.getInt("id_taille"));
							
				// find for "Client"
				ClientDAO daoClient = new ClientController();
				Client client = daoClient.findByID(result.getInt("id_client"));
				
				l1.add(
					new Livraison(
							result.getInt("id_livraison"),
							livreur,
							pizza,
							vehicule,
							taille,
							client, 
							result.getDate("date_commande"),
							result.getDate("date_livraison")
						)
					);
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}

	@Override
	public Livraison findByID(int id) throws SQLException {
		Connection con = null;
		Livraison l1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_DELIVERY_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			// find for "Livreur"
			LivreurDAO daoLivreur = new LivreurController();
			Livreur livreur = daoLivreur.findByID(result.getInt("id_livreur"));
			
			// find for "Pizza"
			PizzaDAO daoPizza = new PizzaController();
			Pizza pizza = daoPizza.findByID(result.getInt("id_pizza"));
			
			// find for "Vehicule"
			VehiculeDAO daoVehicule = new VehiculeController();
			Vehicule vehicule = daoVehicule.findByID(result.getString("immatriculation"));
			
			// find for "Client"
			TailleDAO daoTaille = new TailleController();
			Taille taille = daoTaille.findByID(result.getInt("id_taille"));
						
			// find for "Client"
			ClientDAO daoClient = new ClientController();
			Client client = daoClient.findByID(result.getInt("id_client"));
			
			l1 = new Livraison(
					result.getInt("id_livraison"),
					livreur,
					pizza,
					vehicule,
					taille,
					client, 
					result.getDate("date_commande"),
					result.getDate("date_livraison")
				);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}

	@Override
	public Livraison create(Livraison obj) throws SQLException {
		Connection con = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(CREATE_DELIVERY);
			
			// find for "Livreur"
			LivreurDAO daoLivreur = new LivreurController();
			obj.setLivreur(daoLivreur.findByID(obj.getLivreur().getId()));
						
			// find for "Pizza"
			PizzaDAO daoPizza = new PizzaController();
			obj.setPizza(daoPizza.findByID(obj.getPizza().getId()));
			// find for "Vehicule"
			VehiculeDAO daoVehicule = new VehiculeController();
			obj.setVehicule(daoVehicule.findByID(obj.getVehicule().getImmatriculation()));
			
			// find for "Client"
			TailleDAO daoTaille = new TailleController();
			obj.setTaille(daoTaille.findByID(obj.getTaille().getId()));
						
			// find for "Client"
			ClientDAO daoClient = new ClientController();
			obj.setClient(daoClient.findByID(obj.getClient().getId()));
			
			stmt.setInt(1, obj.getId());
			stmt.setInt(2, obj.getLivreur().getId());
			stmt.setInt(3, obj.getPizza().getId());
			stmt.setString(4, obj.getVehicule().getImmatriculation());
			stmt.setInt(5, obj.getTaille().getId());
			stmt.setInt(6, obj.getClient().getId());
			stmt.setDate(7, obj.getDate_commande());
			stmt.setDate(8, obj.getDate_livraison());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return obj;
	}

	@Override
	public Livraison update(Livraison obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Livraison obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
    public String timeByDelivery(Livraison livraison) throws SQLException {
    	Connection con = null;
		String time = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(TIMEDIFF_DELIVERY_REQ);
			
			stmt.setInt(1, livraison.getId());
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			time = result.getString("time_Diff");
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return time;
	}
	
	@Override
	public HashMap<Client, Integer> nbCommandeAll() throws SQLException {
		Connection con = null;
		HashMap<Client, Integer> l1 = new HashMap<Client, Integer>();
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(NB_COMMANDE_ALL_REQ);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {							
				// find for "Client"
				ClientDAO daoClient = new ClientController();
				Client client = daoClient.findByID(result.getInt("id_client"));
				
				l1.put(
					client,
					result.getInt("nbCommande")
				);
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}
	
	@Override
	public float averagePizzaSize() throws SQLException {
		Connection con = null;
		float average = 0.0F;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(AVG_PRICE_SIZE_PIZZA);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)	
			result.next();
			
			average = result.getFloat("moyenne");
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return average;
	}
}
