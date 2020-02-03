package controller;

import Model.Ingredient;
import Model.Pizza;
import dao.IngredientDAO;
import dao.JDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class IngredientController implements IngredientDAO {
    private static final String FIND_ING_PIZZA = "SELECT i.* FROM Ingredient AS i INNER JOIN Composition AS c ON c.id_ingredient = i.id_ingredient WHERE c.id_pizza = ?";

    @Override
    public Ingredient findByID(int id) throws SQLException {
        return null;
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
}
