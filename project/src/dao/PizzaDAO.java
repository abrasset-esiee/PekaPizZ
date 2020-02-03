package dao;

import java.sql.SQLException;

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

}
