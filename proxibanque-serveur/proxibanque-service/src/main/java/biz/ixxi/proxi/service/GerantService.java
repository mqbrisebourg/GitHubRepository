package biz.ixxi.proxi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import biz.ixxi.proxi.dao.ConseillerDao;
import biz.ixxi.proxi.dao.PersonnelDao;
import biz.ixxi.proxi.dao.TransactionDao;
import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Personnel;
import biz.ixxi.proxi.domaine.Transaction;



/**
 * Classe de Service implémentant les méthodes relatives aux cas d'utilisation
 * des Gérants.
 * @author Stark Industries
 *
 */
@Service("gerantService")
public class GerantService implements IGerantService {
	
	
	
	@Autowired
	private ConseillerDao conseillerDao;

	
	@Autowired
	private TransactionDao transactionDao;
	
	
	/** 
	 * Méthode permettant de retourner la liste des conseillers gérés par un gérant en fonction de son Id.
	 */
	public List<Conseiller> getConseillerByGerant(Long idGerant)
	{
		return conseillerDao.findByIdGerant(idGerant);
	}
	
	
	/** 
	 * Méthode permettant de retourner la liste des transactions effectuées par les conseillers de l'agence.
	 */
	public List<Transaction> getAllTransaction()
	{
		return transactionDao.findAll();
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
	
	

}
