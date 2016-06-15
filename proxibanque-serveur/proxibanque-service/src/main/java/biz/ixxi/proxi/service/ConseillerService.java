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
	
	public void saveClient(Client client)
	{
		clientDao.saveAndFlush(client);
	}
	
	



	public PersonnelDao getPersonnelDao() {
		return personnelDao;
	}


	
	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = (PersonnelDao) personnelDao;
	}
	
	
}
