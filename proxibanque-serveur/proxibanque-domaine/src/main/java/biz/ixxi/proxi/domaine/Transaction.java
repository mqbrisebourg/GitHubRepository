package biz.ixxi.proxi.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numTransaction;
	private Long idPersonnel;
	@OneToOne
	private Client clientDebiteur;
	@OneToOne
	private Client clientCrediteur;
	@OneToOne
	private Compte compteDebiteur;
	@OneToOne
	private Compte compteCrediteur;
	private double montant;
	
	public Transaction(Long numTransaction, Long idPersonnel, Client clientDebiteur, Client clientCrediteur,
			Compte compteDebiteur, Compte compteCrediteur, double montant) {
		super();
		this.numTransaction = numTransaction;
		this.idPersonnel = idPersonnel;
		this.clientDebiteur = clientDebiteur;
		this.clientCrediteur = clientCrediteur;
		this.compteDebiteur = compteDebiteur;
		this.compteCrediteur = compteCrediteur;
		this.montant = montant;
	}
	
	public Transaction() {
		super();
	}
	public Long getNumTransaction() {
		return numTransaction;
	}
	public void setNumTransaction(Long numTransaction) {
		this.numTransaction = numTransaction;
	}
	public Long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public Client getClientDebiteur() {
		return clientDebiteur;
	}
	public void setClientDebiteur(Client clientDebiteur) {
		this.clientDebiteur = clientDebiteur;
	}
	public Client getClientCrediteur() {
		return clientCrediteur;
	}
	public void setClientCrediteur(Client clientCrediteur) {
		this.clientCrediteur = clientCrediteur;
	}
	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}
	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}
	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}
	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	

}
