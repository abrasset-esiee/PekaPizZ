package dao;

import java.sql.SQLException;

import Model.Taille;

public interface TailleDAO {
	/**
	 * Permet de récupérer une Taille via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Taille findByID(int id) throws SQLException;
}
