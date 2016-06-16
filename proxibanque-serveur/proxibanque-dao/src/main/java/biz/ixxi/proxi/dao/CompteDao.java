package biz.ixxi.proxi.dao;

import java.util.List;


import org.springframework.stereotype.Repository;


import biz.ixxi.proxi.domaine.Compte;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Comptes.
 * @author Stark Industries
 *
 */
@Repository("compteDao")
public interface CompteDao extends GeneralCompteDao<Compte> {
	/**
	 * @param idClient - l'id du Client dont les comptes sont recherchés
	 * @return la liste des comptes du client donné.
	 */
	public List<Compte> findByIdClient(Long idClient);


}