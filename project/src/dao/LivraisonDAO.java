package dao;

import java.sql.SQLException;
import java.util.List;

import Model.Livraison;

public interface LivraisonDAO {
	/**
	 * Permet de récupérer tous les objets Livraison dans la base de données
	 * @param id
	 * @return la collection des objets Livraison
	 */
	public abstract List<Livraison> findAllByID(int id) throws SQLException;
	
	/**
	 * Permet de récupérer un objet Livraison via son ID
	 * @param id
	 * @return obj
	 */
	public abstract Livraison findByID(int id) throws SQLException;
	
	/**
	 * Permet de créer une Livraison dans la base de données
	 * @param obj
	 */
	public abstract Livraison create(Livraison obj) throws SQLException;
	
	/**
	 * Permet de mettre à jour les données d'une Livraison dans la base
	 * @param obj
	 */
	public abstract Livraison update(Livraison obj) throws SQLException;
	
	/**
	 * Permet la suppression d'une Livraison de la base
	 * @param obj
	 */
	public abstract boolean delete(Livraison obj) throws SQLException;
	
	/**
	 * Permet de récupérer la différence de temps entre la commande et la livraison d'une commande grâce à l'ID livraison
	 * @param obj
	 * @return
	 */
	public abstract String timeByDelivery(Livraison livraison) throws SQLException;
}
