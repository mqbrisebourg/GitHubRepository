package biz.ixxi.proxi.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import biz.ixxi.proxi.dao.TransactionDao;
import biz.ixxi.proxi.domaine.Transaction;

public class Logger {
	
	@Autowired
	private TransactionDao transactionDao;
	
	public void logMethodTransaction(JoinPoint joinPoint){
		
		Object[] args = joinPoint.getArgs();
		
//		// Nom de la méthode interceptée
//		String name = joinPoint.getSignature().toLongString();
//		StringBuffer sb = new StringBuffer(name + " appellé avec: [");
//
//		// Liste des valeurs des arguments reçus par la méthode
//		for (int i = 0; i < args.length; i++) {
//			Object o = args[i];
//			sb.append("'" + o + "'");
//			sb.append((i == args.length - 1) ? "" : ", ");
//		}
//		sb.append("]");
//		System.out.println(sb);
		
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
