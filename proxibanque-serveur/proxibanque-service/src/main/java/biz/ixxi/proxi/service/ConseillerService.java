package biz.ixxi.proxi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.ixxi.proxi.dao.ClientDao;
import biz.ixxi.proxi.dao.CompteCourantDao;
import biz.ixxi.proxi.dao.CompteDao;
import biz.ixxi.proxi.dao.CompteEpargneDao;
import biz.ixxi.proxi.dao.PersonnelDao;
import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.CompteCourant;
import biz.ixxi.proxi.domaine.CompteEpargne;
import biz.ixxi.proxi.domaine.Personnel;

/**
 * Classe de Service implémentant les méthodes relatives aux cas d'utilisation
 * des Conseillers
 * 
 * @author Stark Industries
 *
 */


@Service("conseillerService")
public class ConseillerService implements IConseillerService {

	
	
	
	@Autowired
	private PersonnelDao personnelDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private CompteCourantDao compteCourantDao;

	@Autowired
	private CompteEpargneDao compteEpargneDao;

	/**
	 * Méthode retournant un objet Personnel en fonction de son login; et "null" si le conseiller n'est pas dans la base de données.
	 */
	public Personnel getPersonnelByLogin(String login) {
		List<Personnel> liste;
		Personnel conseiller;
		liste = personnelDao.findByLogin(login);
		if (liste.isEmpty())
			return null;
		else {
			conseiller = liste.get(0);
			return conseiller;
		}

	}

	/** 
	 * Methode retournant la liste des clients d'un conseiller en fonction de son id.
	 */
	public List<Client> getClientByConseiller(Long idPersonnel) {
		List<Client> listeClient;
		listeClient = clientDao.findByIdPersonnel(idPersonnel);
		return listeClient;

	}

	/** 
	 * Methode retournant la liste des comptes d'un client en fonction de son id.
	 * La nouvelle implémentation permet de différencier les comptes Epargne et les comptes Courants
	 */
	public List<Compte> getCompteByClient(Long idClient) {
		List<Compte> listeCompte = new ArrayList<Compte>();
		List<CompteCourant> listeCompteCourant= compteCourantDao.findByIdClient(idClient);
		List<CompteEpargne> listeCompteEpargne= compteEpargneDao.findByIdClient(idClient);
		listeCompte.addAll(listeCompteCourant);
		listeCompte.addAll(listeCompteEpargne);
		
		return listeCompte;

	}

	
	/** 
	 * Methode retournant la liste des comptes de la totalité de l'agence.
	 */
	public List<Compte> getAllCompte() {
		List<Compte> listeCompte;
		listeCompte = compteDao.findAll();
		return listeCompte;

	}


	/** 
	 * Methode permettant la mise à jour d'un client dans la base de données s'il y existe déjà;
	 * et sa création si ce n'est pas le cas.
	 */
	public void saveClient(Client client) {
		if (client.getIdClient() == null)
			clientDao.saveAndFlush(client);
		else {
			Long idClient = client.getIdClient();
			List<Client> listeClientDB = clientDao.findByIdClient(idClient);
			if (listeClientDB.isEmpty())
				clientDao.saveAndFlush(client);
			else {
				Client clientDB = listeClientDB.get(0);
				copyClient(clientDB, client);
				clientDao.saveAndFlush(clientDB);
			}

		}
	}

	/** 
	 * Methode permettant d'opérer un virement entre un compte débiteur et un compte créditeur, en 
	 * fonction de leurs numéros, et du montant entier.
	 */
	public boolean virement(Long numCompteCred, Long numCompteDeb, int montant) {
		List<Compte> listeCred;
		List<Compte> listeDeb;
		Compte compteCred;
		Compte compteDeb;

		listeCred = compteDao.findByNumCompte(numCompteCred);
		listeDeb = compteDao.findByNumCompte(numCompteDeb);

		if ((listeCred.isEmpty()) || (listeDeb.isEmpty()))
			return false;

		compteCred = listeCred.get(0);
		compteDeb = listeDeb.get(0);

		int soldeDeb = compteDeb.getSolde() - montant;
		int soldeCred = compteCred.getSolde() + montant;

		compteDeb.setSolde(soldeDeb);
		compteCred.setSolde(soldeCred);

		compteDao.saveAndFlush(compteDeb);
		compteDao.saveAndFlush(compteCred);
		return true;

	}

	/** 
	 * Methode permettant de transférer les proprités d'un client issu de la couche présentation
	 * à un objet client issu de la base de données, afin de faciliter les opérations de mise à jour.
	 */
	public void copyClient(Client clientCopieur, Client clientCopie) {
		clientCopieur.setAdresse(clientCopie.getAdresse());
		clientCopieur.setCodePostal(clientCopie.getCodePostal());
		clientCopieur.setNom(clientCopie.getNom());
		clientCopieur.setPrenom(clientCopie.getPrenom());
		clientCopieur.setTelephone(clientCopie.getTelephone());
		clientCopieur.setVille(clientCopie.getVille());
	}
	
	
	

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public CompteDao getCompteDao() {
		return compteDao;
	}

	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

	public CompteCourantDao getCompteCourantDao() {
		return compteCourantDao;
	}

	public void setCompteCourantDao(CompteCourantDao compteCourantDao) {
		this.compteCourantDao = compteCourantDao;
	}

	public CompteEpargneDao getCompteEpargneDao() {
		return compteEpargneDao;
	}

	public void setCompteEpargneDao(CompteEpargneDao compteEpargneDao) {
		this.compteEpargneDao = compteEpargneDao;
	}

	public PersonnelDao getPersonnelDao() {
		return personnelDao;
	}

	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = (PersonnelDao) personnelDao;
	}

}
