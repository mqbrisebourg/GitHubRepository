package biz.ixxi.proxi.domaine;



import java.util.Date;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("GENERAL")
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numCompte;	
	private Long idClient;
	private double solde;
	private Date dateOuverture;
	
	public Compte(Long numCompte, Long idClient, double solde, Date dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.idClient = idClient;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}
	
	public Compte(Long idClient, double solde, Date dateOuverture) {
		super();
		this.idClient = idClient;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Compte() {
		super();
	}
	public Long getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	
	
}
