package dao;

import Model.Vehicule;

import java.sql.SQLException;

public interface VehiculeDAO {
	/**
	 * Permet de récupérer l'objet Vehicule via son Immatriculation
	 * @param immatriculation
	 * @return obj
	 */
	public abstract Vehicule findByID(String immatriculation) throws SQLException;
	
	/**
	 * Permet de récupérer un Vehicule via son nombre de retards cumulés
	 * @param 
	 * @return obj
	 */
	public abstract Vehicule findMoreLate() throws SQLException;
	
	/**
	 * Permet de récupérer un objet Vehicule qui n'a jamais servi
	 * @return obj
	 * @throws SQLException
	 */
	public abstract Vehicule findNeverUsed() throws SQLException;
}
