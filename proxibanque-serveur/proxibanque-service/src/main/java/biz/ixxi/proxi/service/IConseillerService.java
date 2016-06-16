package biz.ixxi.proxi.service;

import java.util.List;

import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Personnel;

public interface IConseillerService {

	public Personnel getPersonnelByLogin(String login);
	public List<Client> getClientByConseiller(Long idConseiller);
	public List<Compte> getCompteByClient(Long idClient);
	public boolean virement(Long numCompteCred,Long numCompteDeb,double montant);
	public void saveClient(Client client);
}
