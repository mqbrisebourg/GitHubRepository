package biz.ixxi.proxi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Personnel {

	
	public Gerant(Long idPersonnel, String login, String nom, String prenom) {
		super(idPersonnel, login, nom, prenom);
	}
	
	public Gerant(String login, String nom, String prenom) {
		super(login, nom, prenom);
	}
	
	public Gerant() {
		super();
	}
}
