package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Adresse;
import Model.Client;
import Model.Pizza;
import dao.AdresseDAO;
import dao.ClientDAO;
import dao.JDBConnection;
import dao.LivraisonDAO;
import dao.LivreurDAO;
import dao.PizzaDAO;

public class ClientController implements ClientDAO {
	private static final String FINDALL_CLIENT_REQ = "SELECT id_client, nom, prenom, solde, id_adresse FROM Client";
	private static final String FIND_CLIENT_REQ = "SELECT id_client, nom, prenom, solde, id_adresse FROM Client WHERE id_client = ?";
	private static final String FIND_BEST_CLIENT_REQ = "SELECT id_client FROM (SELECT l.id_client, COUNT(l.id_client) nbCommande FROM Livraison l GROUP BY l.id_client) as x WHERE x.nbCommande = (SELECT MAX(nbCommande) FROM (SELECT m.id_client, COUNT(m.id_client) nbCommande FROM Livraison m GROUP BY m.id_client) as y)";
	
	private static final String CLIENT_MORE_AVG = "SELECT DISTINCT(l.id_client) FROM Livraison l INNER JOIN Pizza p ON p.id_pizza = l.id_pizza INNER JOIN Taille t ON t.id_taille = l.id_taille WHERE (p.prix_base * t.ratio) > ?";
	
	private static final String CREATE_CLIENT = "INSERT INTO Client (nom, prenom, solde, id_adresse) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_CLIENT = "UPDATE Client SET nom = ?, prenom = ?, solde = ?, id_adresse = ? WHERE id_client = ?";
	private static final String DELETE_CLIENT = "DELETE FROM Client WHERE id_client = ?";

	@Override
	public List<Client> findAll() throws SQLException {
		Connection con = null;
		ArrayList<Client> a1 = new ArrayList<Client>();
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FINDALL_CLIENT_REQ);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();

			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {
				// find for "Adresse"
				AdresseDAO daoAdresse = new AdresseController();	
				Adresse adresse = daoAdresse.findByID(result.getInt("id_adresse"));
				
				a1.add(
					new Client(
							result.getInt("id_client"),
							result.getString("nom"),
							result.getString("prenom"), 
							result.getDouble("solde"),
							adresse
						)
					);
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return a1;		
	}
	
	@Override
	public Client findByID(int id) throws SQLException {
		Connection con = null;
		Client c1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_CLIENT_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			// find for "Adresse"
			AdresseDAO daoAdresse = new AdresseController();	
			Adresse adresse = daoAdresse.findByID(result.getInt("id_adresse"));
			
			c1 = new Client(
					result.getInt("id_client"), 
					result.getString("nom"), 
					result.getString("prenom"), 
					result.getDouble("solde"),
					adresse
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return c1;
	}

	@Override
	public Client create(Client obj) {
		Connection con = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(CREATE_CLIENT);
			
			AdresseDAO daoAdresse = new AdresseController();
			Adresse new_adresse = daoAdresse.create(obj.getAdresse());
			
			obj.setAdresse(daoAdresse.findByCriterias(new_adresse));
				
			stmt.setString(1, obj.getNom());
			stmt.setString(2, obj.getPrenom());
			stmt.setDouble(3, obj.getSolde());
			stmt.setInt(4, obj.getAdresse().getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return obj;
	}
	 	
	@Override
	public Client update(Client obj) {
		Connection con = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_CLIENT);
			
			System.out.println(obj.getId());
			
			stmt.setString(1, obj.getNom());
			stmt.setString(2, obj.getPrenom());
			stmt.setDouble(3, obj.getSolde());
			stmt.setInt(4, obj.getAdresse().getId());
			stmt.setInt(5, obj.getId());
		
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return obj;
	}

	@Override
	public boolean delete(Client obj) {
		Connection con = null;
		boolean result = false;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_CLIENT);
			
			stmt.setLong(1, obj.getId());
		
			int result_int = stmt.executeUpdate();
			
			if (result_int == 1) {
				result = true;
			} else {
				result = false;
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return result;
	}

	@Override
	public Client findBest() throws SQLException {
		Connection con = null;
		Client c1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_BEST_CLIENT_REQ);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			ClientDAO daoClient = new ClientController();	
			c1 = daoClient.findByID(result.getInt("id_client"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return c1;
	}

	@Override
	public List<Client> moreAVG() throws SQLException {
		Connection con = null;
		ArrayList<Client> l1 = new ArrayList<Client>();
		float avg = 0.0F;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(CLIENT_MORE_AVG);
			
			LivraisonDAO daoLivraison = new LivraisonController();
			avg = daoLivraison.averagePizzaSize();
			
			stmt.setFloat(1, avg);
			System.out.println(avg);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();

			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {
				
				ClientDAO daoClient = new ClientController();	
				Client client = daoClient.findByID(result.getInt("id_client"));
				
				l1.add(
					client
				);
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;		
	}
}
