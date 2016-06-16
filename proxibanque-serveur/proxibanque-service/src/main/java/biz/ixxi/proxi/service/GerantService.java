package biz.ixxi.proxi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import biz.ixxi.proxi.dao.ClientDao;
import biz.ixxi.proxi.dao.CompteCourantDao;
import biz.ixxi.proxi.dao.CompteEpargneDao;
import biz.ixxi.proxi.dao.ConseillerDao;

import biz.ixxi.proxi.dao.TransactionDao;
import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.CompteCourant;
import biz.ixxi.proxi.domaine.CompteEpargne;
import biz.ixxi.proxi.domaine.Conseiller;

import biz.ixxi.proxi.domaine.Transaction;

/**
 * Classe de Service implémentant les méthodes relatives aux cas d'utilisation
 * des Gérants.
 * 
 * @author Stark Industries
 *
 */
@Service("gerantService")
public class GerantService implements IGerantService {

	@Autowired
	private ConseillerDao conseillerDao;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private CompteCourantDao compteCourantDao;

	@Autowired
	private CompteEpargneDao compteEpargneDao;

	/**
	 * Méthode permettant de retourner la liste des conseillers gérés par un
	 * gérant en fonction de son Id.
	 */
	public List<Conseiller> getConseillerByGerant(Long idGerant) {
		return conseillerDao.findByIdGerant(idGerant);
	}

	/**
	 * Méthode permettant de retourner la liste des transactions effectuées par
	 * les conseillers de l'agence.
	 */
	public List<Transaction> getAllTransaction() {
		return transactionDao.findAll();
	}

	/**
	 * Méthode permettant de charger tous les comptes et de les trier pour retourner
	 * les comptes qui ne respectent pas leur autorisation de découvert.
	 */
	public List<Compte> getComptesADecouvert() {
		List<Compte> listeComptes = new ArrayList<Compte>();
		List<Client> listeClients = clientDao.findAll();
		for (int i = 0; i < listeClients.size(); i++) {
			Client client = listeClients.get(i);
			Long idClient = client.getIdClient();
			List<CompteEpargne> listeEpargne = compteEpargneDao.findByIdClient(idClient);
			if (listeEpargne.isEmpty()==false) {
				CompteEpargne compteEpargne = listeEpargne.get(0);
				if (compteEpargne.getSolde() < 0)
					listeComptes.add(compteEpargne);
			}
			List<CompteCourant> listeCourant = compteCourantDao.findByIdClient(idClient);
			if (listeCourant.isEmpty()==false) {
				CompteCourant compteCourant = listeCourant.get(0);
				
				if (compteCourant.getSolde() < (-compteCourant.getAutorisationDecouvert()))
					listeComptes.add(compteCourant);
			}

		}

		return listeComptes;

	}

	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	public ConseillerDao getConseillerDao() {
		return conseillerDao;
	}

	public void setConseillerDao(ConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
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

	
	
}
