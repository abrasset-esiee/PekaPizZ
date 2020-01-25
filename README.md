# PekaPizZ
Projet de Base de Données : Gestion d’une entreprise de pizzas à domicile

PekaPizZ > DrataPiZ

# Base de données
## Connexion à la base de données

1- Accéder au chemin /src/dma et copier le fichier de configuration JDBConnectionExample.java vers JDBConnection.java
2- Dans les attributs en haut de la fonction JDBConnection, changez les paramètres suivants (dans JDBConnection.java):
  - URL (si autre que MySQL en base de données)
  - BASENAME
  - USER 
  - PASSWORD
  
## Requêtage

- Pour faire des requêtes, utilisez le code exemple suivante (permet de faire des SELECT en base de données seulement !!) :
  ```
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
    ```
