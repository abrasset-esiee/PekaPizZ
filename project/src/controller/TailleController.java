package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Taille;
import dao.JDBConnection;
import dao.TailleDAO;

public class TailleController implements TailleDAO {
	private static final String FIND_TAILLE_REQ = "SELECT id_taille, ratio FROM Taille WHERE id_taille = ?";
	
	@Override
	public Taille findByID(int id) throws SQLException {
		Connection con = null;
		Taille t1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_TAILLE_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			t1 = new Taille(
					result.getInt("id_taille"), 
					result.getDouble("ratio")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return t1;
	}
}
