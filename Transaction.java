package biz.ixxi.proxi.domaine;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numeroTransaction;
	private Long numeroCompteDebiteur;
	private Long numeroCompteCrediteur;
	private Date date;
	private int montant;
	
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public Long getNumeroTransaction() {
		return numeroTransaction;
	}
	public void setNumeroTransaction(Long numeroTransaction) {
		this.numeroTransaction = numeroTransaction;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getNumeroCompteDebiteur() {
		return numeroCompteDebiteur;
	}
	public void setNumeroCompteDebiteur(Long numeroCompteDebiteur) {
		this.numeroCompteDebiteur = numeroCompteDebiteur;
	}
	public Long getNumeroCompteCrediteur() {
		return numeroCompteCrediteur;
	}
	public void setNumeroCompteCrediteur(Long numeroCompteCrediteur) {
		this.numeroCompteCrediteur = numeroCompteCrediteur;
	}
	
	
	public Transaction(Long numeroTransaction, Long numeroCompteDebiteur, Long numeroCompteCrediteur, Date date,
			int montant) {
		super();
		this.numeroTransaction = numeroTransaction;
		this.numeroCompteDebiteur = numeroCompteDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.date = date;
		this.montant = montant;
	}
	
	public Transaction(Long numeroCompteDebiteur, Long numeroCompteCrediteur, Date date, int montant) {
		super();
		this.numeroCompteDebiteur = numeroCompteDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.date = date;
		this.montant = montant;
	}
	
	
	public Transaction(Long numeroCompteDebiteur, Long numeroCompteCrediteur, int montant) {
		super();
		this.numeroCompteDebiteur = numeroCompteDebiteur;
		this.numeroCompteCrediteur = numeroCompteCrediteur;
		this.montant = montant;
	}
	public Transaction() {
		super();
		
	}

}
