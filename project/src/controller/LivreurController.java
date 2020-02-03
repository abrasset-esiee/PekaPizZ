package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Adresse;
import Model.Livreur;
import dao.JDBConnection;
import dao.LivreurDAO;

public class LivreurController implements LivreurDAO {
	private static final String FIND_LIVREUR_REQ = "SELECT id_livreur, nom, prenom FROM Livreur WHERE id_livreur = ?";
	private static final String FIND_LIVREUR_C_REQ = "SELECT id_livreur, nom, prenom FROM Livreur WHERE nom = ? AND prenom = ?";
	
	@Override
	public Livreur findByID(int id) throws SQLException {
		Connection con = null;
		Livreur l1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_LIVREUR_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			l1 = new Livreur(
					result.getInt("id_livreur"), 
					result.getString("nom"),
					result.getString("prenom") 
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}

	@Override
	public Livreur findByCriterias(Livreur livreur) throws SQLException {
		Connection con = null;
		Livreur l1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_LIVREUR_C_REQ);
			
			stmt.setString(1, livreur.getNom());
			stmt.setString(2, livreur.getPrenom());
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			l1 = new Livreur(
					result.getInt("id_livreur"), 
					result.getString("nom"),
					result.getString("prenom")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}
}
