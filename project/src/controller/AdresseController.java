package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Adresse;
import Model.Client;
import dao.JDBConnection;
import dao.AdresseDAO;

public class AdresseController implements AdresseDAO {
	private static final String FIND_ADDRESS_REQ = "SELECT id_adresse, Numero_rue, nom_rue, code_postal, ville FROM Adresse WHERE id_adresse = ?";
	private static final String FIND_ADDRESS_C_REQ = "SELECT id_adresse, Numero_rue, nom_rue, code_postal, ville FROM Adresse WHERE Numero_rue = ? AND nom_rue = ? AND code_postal = ? AND ville = ?";
	
	private static final String CREATE_ADRESSE = "INSERT INTO Adresse (Numero_rue, nom_rue, code_postal, ville) VALUES (?, ?, ?, ?)";
	
	@Override
	public Adresse findByCriterias(Adresse adresse) throws SQLException {
		Connection con = null;
		Adresse a1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_ADDRESS_C_REQ);
			
			stmt.setString(1, adresse.getNumero_rue());
			stmt.setString(2, adresse.getNom_rue());
			stmt.setString(3, adresse.getCode_postal());
			stmt.setString(4, adresse.getVille());
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			a1 = new Adresse(
					result.getInt("id_adresse"), 
					result.getString("Numero_rue"),
					result.getString("nom_rue"),
					result.getString("code_postal"),
					result.getString("ville")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return a1;
	}
	
	@Override
	public Adresse findByID(int id) throws SQLException {
		Connection con = null;
		Adresse a1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_ADDRESS_REQ);
			
			stmt.setInt(1, id);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			a1 = new Adresse(
					result.getInt("id_adresse"), 
					result.getString("Numero_rue"),
					result.getString("nom_rue"),
					result.getString("code_postal"),
					result.getString("ville")
			);
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return a1;
	}
	
	@Override
	public Adresse create(Adresse obj) {
		Connection con = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(CREATE_ADRESSE);
			
			stmt.setString(1, obj.getNumero_rue());
			stmt.setString(2, obj.getNom_rue());
			stmt.setString(3, obj.getCode_postal());
			stmt.setString(4, obj.getVille());
		
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return obj;
	}
}
