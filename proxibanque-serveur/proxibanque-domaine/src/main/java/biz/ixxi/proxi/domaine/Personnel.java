package biz.ixxi.proxi.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERSONNEL")
@DiscriminatorValue("GENERAL")
@NamedQuery(name="Personnel.findByLogin",query="select p from Personnel p where p.login=?1")
public abstract class Personnel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPersonnel;
	private String login;
	private String nom;
	private String prenom;
	public Personnel(Long idPersonnel,String login, String nom, String prenom) {
		super();
		this.idPersonnel = idPersonnel;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
	}
	
	
	public Personnel(String login, String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
	}




	public Personnel() {
		super();
	}
	public Long getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
