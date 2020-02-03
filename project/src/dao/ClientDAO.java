package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Model.Client;

public interface ClientDAO {
	/**
	 * Permet de récupérer tous les objets Client dans la base de données
	 * @param id
	 * @return la collection des objets Personne
	 */
	public abstract List<Client> findAll() throws SQLException;
	
	/**
	 * Permet de récupérer un objet Client via son ID
	 * @param id
	 * @return
	 */
	public abstract Client findByID(int id) throws SQLException;
	
	/**
	 * Permet de créer un Client dans la base de données
	 * @param obj
	 */
	public abstract Client create(Client obj) throws SQLException;
	
	/**
	 * Permet de mettre à jour les données d'un Client dans la base
	 * @param obj
	 */
	public abstract Client update(Client obj) throws SQLException;
	
	/**
	 * Permet la suppression d'un Client de la base
	 * @param obj
	 */
	public abstract boolean delete(Client obj) throws SQLException;
	
//	// Retourne le meilleur Client (nombre commande)
//    public static int meilleurClient(Statement stmt) throws SQLException {
//		// requête sql
//		String req = "SELECT * " + 
//				"FROM (" + 
//				" SELECT l.id_client nbCommande" + 
//				" FROM Livraison l" + 
//				" GROUP BY l.id_client" + 
//				") as x " + 
//				"WHERE x.nbCommande = (" + 
//				" SELECT MAX(nbCommande)" + 
//				" FROM (" + 
//				" SELECT m.id_client, COUNT(m.id_client) nbCommande" + 
//				" FROM Livraison m" + 
//				" GROUP BY m.id_client" + 
//				" ) as y" + 
//				")";
//
//		// émet une requête de type Select
//		ResultSet result = stmt.executeQuery(req);
//
//		// obtient le nombre de colonnes en résultat
//		ResultSetMetaData rsmd = result.getMetaData();
//		int n = rsmd.getColumnCount();
//
//		// affiche les lignes/colonnes du résultat
//		// (result.next() permet de passer à la ligne de résultat suivant)
//		result.next();
//		
//		return result.getInt(n);
//    }
}