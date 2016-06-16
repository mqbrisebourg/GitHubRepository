package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.ixxi.proxi.domaine.Compte;


/**
 * Interface générale gérée par Spring Data Jpa pour permettre la prise en charge de l'héritage entre CompteCourant
 *  et CompteEpargne et Compte.
 * @author Stark Industries
 *
 */
public interface GeneralCompteDao<T extends Compte> extends JpaRepository<T, Long> {

	/**
	 * @param numCompte - Le numéro du compte recherché
	 * @return la liste des comptes ayant le numéro de compte donné
	 */
	public List<Compte> findByNumCompte(Long numCompte);
}