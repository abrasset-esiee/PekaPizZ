package dao;

import java.sql.SQLException;
import java.util.HashSet;

import Model.Client;
import Model.Ingredient;

public interface IngredientDAO {
	/**
	 * Permet de récupérer un Ingredient via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Ingredient findByID(int id) throws SQLException;

	public abstract HashSet<Ingredient> findByIDPizza(int id) throws SQLException;
	
	/**
	 * Permet de récupérer un objet Ingredient appartenant aux plus grand nombres de Pizza
	 * @return obj
	 */
	public abstract Ingredient findBest() throws SQLException;
}
