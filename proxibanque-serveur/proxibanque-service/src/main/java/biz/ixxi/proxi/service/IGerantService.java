package biz.ixxi.proxi.service;

import java.util.List;

import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Transaction;


/**
 * Interface spécifiant les méthodes de la couche service liée aux cas d'utilisation Gerant. 
 * Utilisée pour l'injection de dépendances.
 * @author Stark industries
 *
 */
public interface IGerantService {
	public List<Conseiller> getConseillerByGerant(Long idGerant);
	public List<Transaction> getAllTransaction();
	public List<Compte> getComptesADecouvert();
}
