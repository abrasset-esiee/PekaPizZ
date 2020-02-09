package dao;

import java.sql.SQLException;
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
	
	/**
	 * Permet de récupérer un objet Client ayant le plus grand nombre de commande
	 * @param obj
	 */
	public abstract Client findBest() throws SQLException;
}