package dao;

import java.sql.SQLException;

import Model.Ingredient;

public interface IngredientDAO {
	/**
	 * Permet de récupérer un Ingredient via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Ingredient findByID(int id) throws SQLException;
}
