package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import biz.ixxi.proxi.domaine.CompteEpargne;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Comptes Epargnes.
 * @author Stark Industries
 *
 */
@Repository("compteEpargneDao")
public interface CompteEpargneDao extends GeneralCompteDao<CompteEpargne> {

	/**
	 * @param idClient - l'id du Client dont les comptes sont recherchés
	 * @return la liste des comptes du client donné.
	 */
	public List<CompteEpargne> findByIdClient(Long idClient);
	
}