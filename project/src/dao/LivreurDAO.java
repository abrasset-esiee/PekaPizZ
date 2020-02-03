package dao;

import java.sql.SQLException;

import Model.Livreur;

public interface LivreurDAO {
	/**
	 * Permet de récupérer une Livreur via son objet
	 * @param id
	 * @return obj
	 */
	public abstract Livreur findByCriterias(Livreur livreur) throws SQLException;
	
	/**
	 * Permet de récupérer un Livreur via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Livreur findByID(int id) throws SQLException;
}
