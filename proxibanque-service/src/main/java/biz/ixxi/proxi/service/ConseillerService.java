package biz.ixxi.proxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.ixxi.proxi.dao.ClientDao;
import biz.ixxi.proxi.dao.CompteDao;
import biz.ixxi.proxi.dao.PersonnelDao;
import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Personnel;

@Service("conseillerService")
public class ConseillerService implements IConseillerService {

	@Autowired
	private PersonnelDao personnelDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private CompteDao compteDao;
	
	
	
	public Personnel getPersonnelByLogin(String login){
		List<Personnel> liste;
		Personnel conseiller;
		liste = personnelDao.findByLogin(login);
		if (liste.isEmpty()) return null;
		else {conseiller=liste.get(0);
		return conseiller;}
		
	}
	
	public List<Client> getClientByConseiller(Long idConseiller){
		List<Client> listeClient;
		listeClient = clientDao.findByIdConseiller(idConseiller);
		return listeClient;
		
	}
	
	public List<Compte> getCompteByClient(Long idClient){
		List<Compte> listeCompte;
		listeCompte= compteDao.findByIdClient(idClient);
		return listeCompte;
		
	}
	
//	public void saveClient(Client client)
//	{
//		clientDao.saveAndFlush(client);
//	}
	
	public void saveClient(Client client)
	{
		if (client.getIdClient()==null) clientDao.saveAndFlush(client);
		else 
		{
			Long idClient=client.getIdClient();
			List<Client> listeClientDB = clientDao.findByIdClient(idClient);
			if (listeClientDB.isEmpty()) clientDao.saveAndFlush(client);
			else 
			{
				Client clientDB=listeClientDB.get(0);
				copyClient(clientDB,client);
				clientDao.saveAndFlush(clientDB);
			}
			
		}
	}
	
	public boolean virement(Long numCompteCred,Long numCompteDeb,int montant)
	{
		List<Compte> listeCred;
		List<Compte> listeDeb;
		Compte compteCred;
		Compte compteDeb;
		
		listeCred=compteDao.findByNumCompte(numCompteCred);
		listeDeb=compteDao.findByNumCompte(numCompteDeb);
		
		if ((listeCred.isEmpty())||(listeDeb.isEmpty())) return false;
		
		compteCred=listeCred.get(0);
		compteDeb=listeDeb.get(0);
		
		double soldeDeb=compteDeb.getSolde()-montant;
		double soldeCred=compteCred.getSolde()+montant;
		
		compteDeb.setSolde(soldeDeb);
		compteCred.setSolde(soldeCred);
		
		compteDao.saveAndFlush(compteDeb);
		compteDao.saveAndFlush(compteCred);
		return true;
			
	}
	
	
	public void copyClient(Client clientCopieur,Client clientCopie)
	{
		clientCopieur.setAdresse(clientCopie.getAdresse());
		clientCopieur.setCodePostal(clientCopie.getCodePostal());
		clientCopieur.setNom(clientCopie.getNom());
		clientCopieur.setPrenom(clientCopie.getPrenom());
		clientCopieur.setTelephone(clientCopie.getTelephone());
		clientCopieur.setVille(clientCopie.getVille());
	}
	





	public PersonnelDao getPersonnelDao() {
		return personnelDao;
	}


	
	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = (PersonnelDao) personnelDao;
	}

	@Override
	public boolean virement(Long numCompteCred, Long numCompteDeb, double montant) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
