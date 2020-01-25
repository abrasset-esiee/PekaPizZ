package dma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// Copier coller cette classe, la renommer JDBConnection et compléter les informations suivantes
public class JDBConnectionExample {
	// Package de connexion et type de base de données
	private static final String URL = "jdbc:mysql://";
	// Adresse locale ou distante (192.168.1.1)
	private static final String IP = "localhost";
	// Port d'accès à la base
	private static final String PORT = "3306";
	// Nom de la base de données à accéder
	private static final String BASENAME = "";
	// Obligatoire en MySQL 8
	private static final String END = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	// Informations User BDD
	private static final String USER = "";
	private static final String PASSWORD = "";

	private static Connection getConnection(String ip, String base) throws SQLException {
		String url = URL + IP + ":" + PORT + "/" + BASENAME + END;
		System.out.println("connexion à l'URL: " + url);
		return DriverManager.getConnection(url, USER, PASSWORD);
	}

	public static void main(String[] args) {
		try (Connection con = getConnection(IP, BASENAME);
				Statement stmt = con.createStatement();)
		{
			// requête sql
			String req = "";

			// émet une requête de type Select
			ResultSet result = stmt.executeQuery(req);

			// obtient le nombre de colonnes en résultat
			ResultSetMetaData rsmd = result.getMetaData();
			int n = rsmd.getColumnCount();

			// affiche les lignes/colonnes du résultat
			// (result.next() permet de passer à la ligne de résultat suivant)
			while (result.next()) {
				if (n > 1) {
					// le for est utilisé pour afficher chaque colonne de la ligne result
					for (int col = 1; col <= n; col++) {
						System.out.print(result.getString(col) + " ");
					}
					System.out.println();
				} else {
					System.out.print(result.getString(n));
					System.out.println();
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur d'exécution: " + e.getMessage());
		}
	}
}
