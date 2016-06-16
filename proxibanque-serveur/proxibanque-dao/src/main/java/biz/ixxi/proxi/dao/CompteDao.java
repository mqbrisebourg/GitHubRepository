package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import biz.ixxi.proxi.domaine.Compte;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Comptes.
 * @author Stark Industries
 *
 */
@Repository("compteDao")
public interface CompteDao extends JpaRepository<Compte, Long> {


	/**
	 * @param idClient - l'id du Client dont les comptes sont recherchés
	 * @return la liste des comptes du client donné.
	 */
	public List<Compte> findByIdClient(Long idClient);
	/**
	 * @param numCompte - Le numéro du compte recherché
	 * @return la liste des comptes ayant le numéro de compte donné
	 */
	public List<Compte> findByNumCompte(Long numCompte);
}