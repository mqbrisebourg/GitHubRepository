package biz.ixxi.proxi.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import biz.ixxi.proxi.dao.TransactionDao;
import biz.ixxi.proxi.domaine.Transaction;




/**
 * Classe de Logger pour Spring AOP, permet l'interception des appels à la méthode de virement de
 * ConseillerService et leur persistence sous forme de Transaction
 * @author Stark Industries
 *
 */
public class Logger {
	
	@Autowired
	private TransactionDao transactionDao;
	
	/**
	 * Méthode d'interception des appels à la méthode de virement
	 * @param joinPoint - Le JoinPoint défini dans la configuration Spring AOP
	 */
	public void logMethodTransaction(JoinPoint joinPoint){
		
		Object[] args = joinPoint.getArgs();
		

		Long numCompteDeb=(Long)args[0];
		Long numCompteCred=(Long) args[1];
		int montant=(int) args[2];
		Date date=new Date();
		Transaction t=new Transaction(numCompteDeb,numCompteCred,date,montant);
		transactionDao.saveAndFlush(t);
		
	}

	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
}
