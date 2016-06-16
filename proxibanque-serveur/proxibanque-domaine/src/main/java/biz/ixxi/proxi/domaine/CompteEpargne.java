package biz.ixxi.proxi.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	private double tauxRemuneration=0.03;

	public CompteEpargne(Long numCompte, Long idClient, int solde, Date dateOuverture) {
		super(numCompte, idClient, solde, dateOuverture);
	}
	
	public CompteEpargne(Long idClient, int solde, Date dateOuverture) {
		super(idClient, solde, dateOuverture);
	}
	
	public CompteEpargne() {
		super();
	}
	
}
