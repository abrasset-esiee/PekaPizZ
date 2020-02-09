package controller;

import Model.Adresse;
import Model.Client;
import Model.Ingredient;
import Model.Pizza;
import dao.AdresseDAO;
import dao.ClientDAO;
import dao.IngredientDAO;
import dao.JDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class IngredientController implements IngredientDAO {
	private static final String FIND_ING_REQ = "SELECT id_ingredient, nom, provenance FROM Ingredient WHERE id_ingredient = ?";
    private static final String FIND_ING_PIZZA = "SELECT i.* FROM Ingredient AS i INNER JOIN Composition AS c ON c.id_ingredient = i.id_ingredient WHERE c.id_pizza = ?";
    private static final String FIND_BEST_INGREDIENT = "SELECT id_ingredient FROM (SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient FROM Livraison l INNER JOIN Composition c ON l.id_pizza = c.id_pizza GROUP BY c.id_ingredient) as x WHERE x.nbIngredient = (SELECT MAX(nbIngredient) FROM (SELECT c.id_ingredient, COUNT(c.id_ingredient) nbIngredient FROM Livraison l INNER JOIN Composition c ON l.id_pizza = c.id_pizza GROUP BY c.id_ingredient) as y)";
    
    @Override
    public Ingredient findByID(int id) throws SQLException {
    	Connection con = null;
		Ingredient i1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_ING_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			i1 = new Ingredient(
					result.getInt("id_ingredient"), 
					result.getString("nom"), 
					result.getString("provenance")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return i1;
    }

    @Override
    public HashSet<Ingredient> findByIDPizza(int id) throws SQLException {
        Connection con = null;
        HashSet<Ingredient> ingredients = new HashSet<>();

        try {
            con = JDBConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(FIND_ING_PIZZA);
            stmt.setInt(1, id);
            // émet une requête de type Select
            ResultSet result = stmt.executeQuery();

            // affiche les lignes/colonnes du résultat
            // (result.next() permet de passer à la ligne de résultat suivant)
            while (result.next()) {

                ingredients.add(
                        new Ingredient(
                                result.getInt("id_ingredient"),
                                result.getString("nom"),
                                result.getString("provenance")
                        )
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur d'exécution: " + e.getMessage());
        }

        return ingredients;
    }

	@Override
	public Ingredient findBest() throws SQLException {
		Connection con = null;
		Ingredient i1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_BEST_INGREDIENT);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			IngredientDAO daoIngredient = new IngredientController();	
			i1 = daoIngredient.findByID(result.getInt("id_ingredient"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return i1;
	}
}
