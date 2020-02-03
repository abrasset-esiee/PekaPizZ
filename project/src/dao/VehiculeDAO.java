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
}
