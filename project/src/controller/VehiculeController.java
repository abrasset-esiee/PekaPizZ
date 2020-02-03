package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Vehicule;
import dao.JDBConnection;
import dao.VehiculeDAO;

public class VehiculeController implements VehiculeDAO {
	private static final String FIND_VEHICULE_REQ = "SELECT immatriculation, voiture, couleur, modele, annee FROM Vehicule WHERE immatriculation = ?";
	
	@Override
	public Vehicule findByID(String immatriculation) throws SQLException {
		Connection con = null;
		Vehicule v1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_VEHICULE_REQ);
			
			stmt.setString(1, immatriculation);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			v1 = new Vehicule(
					result.getString("immatriculation"), 
					result.getBoolean("voiture"), 
					result.getString("couleur"), 
					result.getString("modele"),
					result.getInt("annee")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return v1;
	}
}
