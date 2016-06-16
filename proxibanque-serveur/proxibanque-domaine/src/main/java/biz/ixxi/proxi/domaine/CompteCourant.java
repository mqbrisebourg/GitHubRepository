package biz.ixxi.proxi.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	
	private int autorisationDecouvert=1000;
	
	
	

	

	public int getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public void setAutorisationDecouvert(int autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	public CompteCourant(Long numCompte, Long idClient, int solde, Date dateOuverture) {
		super(numCompte, idClient, solde, dateOuverture);
	}

	public CompteCourant(Long idClient, int solde, Date dateOuverture) {
		super(idClient, solde, dateOuverture);
	}
	
	public CompteCourant() {
		super();
	}

	
}
