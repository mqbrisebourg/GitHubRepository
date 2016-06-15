package biz.ixxi.proxi.domaine.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.CompteCourant;
import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Gerant;
import biz.ixxi.proxi.domaine.Personnel;

public class DemoJpa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("test-pu");
		EntityManager em=emf.createEntityManager();	
		EntityTransaction tx = em.getTransaction();

		tx.begin();
	
		Personnel gerant=new Gerant("Lenormand","Gerard","gege");
		Conseiller cons =new Conseiller("Bonhomme","Damien","dbonh",gerant.getIdPersonnel());
		Client client=new Client(cons.getIdPersonnel(),"Laffon","Helene","rue Ariane",33700,"Merignac","");
		Date date = null;
		Compte compte=new CompteCourant(client.getId(),1000,date);
		em.persist(gerant);
		em.persist(cons);
		em.persist(client);
		em.persist(compte);
		tx.commit();
		em.close();
	}

}
