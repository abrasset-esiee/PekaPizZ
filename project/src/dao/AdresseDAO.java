package dao;

import java.sql.SQLException;

import Model.Adresse;

public interface AdresseDAO {
	/**
	 * Permet de récupérer une Adresse via son objet
	 * @param id
	 * @return obj
	 */
	public abstract Adresse findByCriterias(Adresse adresse) throws SQLException;
	
	/**
	 * Permet de récupérer une Adresse via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Adresse findByID(int id) throws SQLException;

	/**
	 * Créer un objet Adresse dans la base
	 * @param obj
	 * @return obj
	 */
	public abstract Adresse create(Adresse obj) throws SQLException;
}
