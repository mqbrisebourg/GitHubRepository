package biz.ixxi.proxi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Transaction;



/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Transactions.
 * @author Stark Industries
 *
 */
@Repository("transactionDao")
public interface TransactionDao extends JpaRepository<Transaction, Long> {
	
}
