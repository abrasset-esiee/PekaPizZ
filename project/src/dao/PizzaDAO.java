package dao;

import java.sql.SQLException;
import java.util.List;

import Model.Client;
import Model.Pizza;

public interface PizzaDAO {
	/**
	 * Permet de récupérer une Livreur via son objet
	 * @param id
	 * @return obj
	 */
	public abstract Pizza findByCriterias(Pizza pizza) throws SQLException;
	
	/**
	 * Permet de récupérer une Pizza via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Pizza findByID(int id) throws SQLException;
	
	/**
	 * Permet de récupérer le nombre de Pizza commandées par un Client via son ID
	 * @param obj
	 * @return
	 */
	public abstract int pizzaByClient(Client client) throws SQLException;

	/**
	 * Permet de récupérer toutes les pizzas
	 * @return List<obj>
	 * @throws SQLException
	 */
	public abstract List<Pizza> findAll() throws SQLException;

	/**
	 * Permet de récupérer un objet Pizza via son nombre de commandes maximum
	 * @return obj
	 * @throws SQLException
	 */
	public abstract Pizza findBestSelling() throws SQLException;
	
	/**
	 * Permet de récupérer un objet Pizza via son nombre de commandes minimum
	 * @return obj
	 * @throws SQLException
	 */
	public abstract Pizza findBadSelling() throws SQLException;
	
	/**
	 * Permet de récupérer un objet Pizza qui n'a jamais eu de commande
	 * @return obj
	 * @throws SQLException
	 */
	public abstract Pizza findNeverSold() throws SQLException;
}
