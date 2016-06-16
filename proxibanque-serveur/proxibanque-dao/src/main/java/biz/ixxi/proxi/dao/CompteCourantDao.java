package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import biz.ixxi.proxi.domaine.CompteCourant;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Comptes Courant.
 * @author Stark Industries
 *
 */
@Repository("compteCourantDao")
public interface CompteCourantDao extends GeneralCompteDao<CompteCourant> {

	
	/**
	 * @param idClient - l'id du Client dont les comptes sont recherchés
	 * @return la liste des comptes du client donné.
	 */
	public List<CompteCourant> findByIdClient(Long idClient);
}
