package biz.ixxi.proxi.service;

import java.util.List;

import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Personnel;



/**
 * Interface spécifiant les méthodes de la couche service liée aux cas d'utilisation Conseiller. 
 * Utilisée pour l'injection de dépendances.
 * @author Stark industries
 *
 */
public interface IConseillerService {

	public Personnel getPersonnelByLogin(String login);
	public List<Client> getClientByConseiller(Long idPersonnel);
	public List<Compte> getCompteByClient(Long idClient);
	public List<Compte> getAllCompte();
	public boolean virement(Long numCompteCred,Long numCompteDeb,int montant);
	public void saveClient(Client client);
}
