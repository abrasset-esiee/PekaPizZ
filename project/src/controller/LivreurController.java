package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Adresse;
import Model.Livreur;
import dao.ClientDAO;
import dao.JDBConnection;
import dao.LivreurDAO;

public class LivreurController implements LivreurDAO {
	private static final String FIND_LIVREUR_REQ = "SELECT id_livreur, nom, prenom FROM Livreur WHERE id_livreur = ?";
	private static final String FIND_LIVREUR_C_REQ = "SELECT id_livreur, nom, prenom FROM Livreur WHERE nom = ? AND prenom = ?";
	private static final String FIND_LIVREUR_MORE_LATE = "SELECT id_livreur FROM (SELECT l.id_livreur, COUNT(l.id_livreur) nbRetard FROM Livraison l WHERE TIMEDIFF(l.date_livraison, l.date_commande) > '00:30:00' GROUP BY l.id_livreur) as x WHERE x.nbRetard = (SELECT MAX(nbRetard) FROM (SELECT m.id_livreur, COUNT(m.id_livreur) nbRetard FROM Livraison m WHERE TIMEDIFF(m.date_livraison, m.date_commande) > '00:30:00' GROUP BY m.id_livreur) as y)";
	
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
	
	@Override
	public Livreur findMoreLate() throws SQLException {
		Connection con = null;
		Livreur l1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_LIVREUR_MORE_LATE);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();

			LivreurDAO daoLivreur = new LivreurController();	
			l1 = daoLivreur.findByID(result.getInt("id_livreur"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return l1;
	}
}
