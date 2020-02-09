package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import dao.JDBConnection;
import dao.PizzaDAO;
import dao.VehiculeDAO;

public class PizzaController implements PizzaDAO {
	private static final String FINDALL_PIZZA_REQ = "SELECT id_pizza, nom, prix_base FROM Pizza";
	private static final String FIND_PIZZA_REQ = "SELECT id_pizza, nom, prix_base FROM Pizza WHERE id_pizza = ?";
	private static final String FIND_PIZZA_C_REQ = "SELECT id_pizza, nom, prix_base FROM Pizza WHERE nom = ? AND prix_base = ?";
	private static final String FIND_PIZZA_BEST_SELLING = "SELECT id_pizza FROM (SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande FROM Livraison l GROUP BY l.id_pizza) as x WHERE x.nbCommande = (SELECT MAX(nbCommande) FROM (SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande FROM Livraison m GROUP BY m.id_pizza) as y)";
	private static final String FIND_PIZZA_BAD_SELLING = "SELECT id_pizza FROM (SELECT l.id_pizza, COUNT(l.id_pizza) nbCommande FROM Livraison l GROUP BY l.id_pizza) as x WHERE x.nbCommande = (SELECT MIN(nbCommande) FROM (SELECT m.id_pizza, COUNT(m.id_pizza) nbCommande FROM Livraison m GROUP BY m.id_pizza) as y)";
	private static final String FIND_PIZZA_NEVER_SOLD = "SELECT id_pizza FROM Pizza WHERE id_pizza NOT IN (SELECT id_pizza FROM Livraison)";
	
	private static final String PIZZA_CLIENT_REQ = "SELECT COUNT(id_livraison) as Nb_Pizza FROM Livraison WHERE id_client = ?";
	
	@Override
	public List<Pizza> findAll() throws SQLException {
		Connection con = null;
		ArrayList<Pizza> a1 = new ArrayList<Pizza>();
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FINDALL_PIZZA_REQ);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
			IngredientController ingredientController = new IngredientController();
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {
				Pizza pizza = new Pizza(
					result.getInt("id_pizza"),
					result.getString("nom"),
					result.getDouble("prix_base")
				);
				for(Ingredient i : ingredientController.findByIDPizza(pizza.getId())) {
					pizza.setIngredient(i);
				}
				a1.add(pizza);
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return a1;		
	}
	@Override
	public Pizza findByID(int id) throws SQLException {
		Connection con = null;
		Pizza p1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_PIZZA_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			p1 = new Pizza(
					result.getInt("id_pizza"), 
					result.getString("nom"), 
					result.getDouble("prix_base")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return p1;
	}
	
	@Override
    public int pizzaByClient(Client client) throws SQLException {
    	Connection con = null;
		int count = 0;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(PIZZA_CLIENT_REQ);
			
			stmt.setInt(1, client.getId());
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			count = result.getInt("Nb_Pizza");
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return count;
	}

	@Override
	public Pizza findByCriterias(Pizza pizza) throws SQLException {
		Connection con = null;
		Pizza p1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_PIZZA_C_REQ);
			
			stmt.setString(1, pizza.getNom());
			stmt.setDouble(2, pizza.getPrix_base());
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			p1 = new Pizza(
					result.getInt("id_pizza"), 
					result.getString("nom"),
					result.getDouble("prix_base")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return p1;
	}
	
	@Override
	public Pizza findBestSelling() throws SQLException {
		Connection con = null;
		Pizza p1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_PIZZA_BEST_SELLING);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			PizzaDAO daoPizza = new PizzaController();	
			p1 = daoPizza.findByID(result.getInt("id_pizza"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return p1;
	}
	
	@Override
	public Pizza findBadSelling() throws SQLException {
		Connection con = null;
		Pizza p1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_PIZZA_BAD_SELLING);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			PizzaDAO daoPizza = new PizzaController();	
			p1 = daoPizza.findByID(result.getInt("id_pizza"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return p1;
	}
	
	@Override
	public Pizza findNeverSold() throws SQLException {
		Connection con = null;
		Pizza p1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_PIZZA_NEVER_SOLD);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			PizzaDAO daoPizza = new PizzaController();	
			p1 = daoPizza.findByID(result.getInt("id_pizza"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return p1;
	}
}
