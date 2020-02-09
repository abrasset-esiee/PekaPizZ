package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Livreur;
import Model.Pizza;
import Model.Vehicule;
import dao.JDBConnection;
import dao.LivreurDAO;
import dao.PizzaDAO;
import dao.VehiculeDAO;

public class VehiculeController implements VehiculeDAO {
	private static final String FIND_VEHICULE_REQ = "SELECT immatriculation, voiture, couleur, modele, annee FROM Vehicule WHERE immatriculation = ?";
	private static final String FIND_VEHICULE_MORE_LATE = "SELECT immatriculation FROM (SELECT l.immatriculation, COUNT(l.immatriculation) nbRetard FROM Livraison l WHERE TIMEDIFF(l.date_livraison, l.date_commande) > \"00:30:00\" GROUP BY l.immatriculation) as x WHERE x.nbRetard = (SELECT MAX(nbRetard) FROM (SELECT m.immatriculation, COUNT(m.immatriculation) nbRetard FROM Livraison m WHERE TIMEDIFF(m.date_livraison, m.date_commande) > \"00:30:00\" GROUP BY m.immatriculation) as y)";
	private static final String FIND_BEST_VEHICULE = "SELECT * FROM (SELECT l.immatriculation, COUNT(l.immatriculation) nbAlheure FROM Livraison l WHERE TIMEDIFF(l.date_livraison, l.date_commande) <= \"00:30:00\" GROUP BY l.immatriculation) as x WHERE x.nbAlheure = (SELECT MAX(nbAlheure) FROM (SELECT m.immatriculation, COUNT(m.immatriculation) nbAlheure FROM Livraison m WHERE TIMEDIFF(m.date_livraison, m.date_commande) <= \"00:30:00\" GROUP BY m.immatriculation) as y)";
	private static final String FIND_VEHICULE_NEVER_USED = "SELECT immatriculation FROM Vehicule WHERE immatriculation NOT IN (SELECT immatriculation FROM Livraison)";
	
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

	@Override
	public Vehicule findMoreLate() throws SQLException {
		Connection con = null;
		Vehicule v1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_VEHICULE_MORE_LATE);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();

			VehiculeDAO daoVehicule = new VehiculeController();	
			v1 = daoVehicule.findByID(result.getString("immatriculation"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return v1;
	}
	
	@Override
	public Vehicule findBest() throws SQLException {
		Connection con = null;
		Vehicule v1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_BEST_VEHICULE);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();

			VehiculeDAO daoVehicule = new VehiculeController();	
			v1 = daoVehicule.findByID(result.getString("immatriculation"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return v1;
	}
	
	@Override
	public Vehicule findNeverUsed() throws SQLException {
		Connection con = null;
		Vehicule v1 = null;
		
		try {
			con = JDBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(FIND_VEHICULE_NEVER_USED);
			
			// émet une requête de type Select
			ResultSet result = stmt.executeQuery();
		
			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			result.next();
			
			VehiculeDAO daoVehicule = new VehiculeController();	
			v1 = daoVehicule.findByID(result.getString("immatriculation"));
				
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
		
		return v1;
	}
}
