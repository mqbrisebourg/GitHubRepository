package biz.ixxi.proxi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Personnel {

	private Long idGerant;

	
	
	
	
	public Long getIdGerant() {
		return idGerant;
	}

	public void setIdGerant(Long idGerant) {
		this.idGerant = idGerant;
	}

	public Conseiller(Long idPersonnel, String login,  String nom, String prenom, Long idGerant) {
		super(idPersonnel,login, nom, prenom);
		this.idGerant = idGerant;
	}

	public Conseiller(Long idPersonnel, String login,String nom, String prenom) {
		super(idPersonnel, login, nom, prenom);
	}
	
	public Conseiller( String login, String nom, String prenom) {
		super(login, nom, prenom);
		
	}

	public Conseiller(String login, String nom, String prenom, Long idGerant) {
		super(login, nom, prenom);
		this.idGerant = idGerant;
	}
	
	public Conseiller() {
		super();
		
	}
	
	
}
