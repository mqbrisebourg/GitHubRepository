package biz.ixxi.proxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import biz.ixxi.proxi.domaine.Client;
import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Personnel;
import biz.ixxi.proxi.service.IConseillerService;


@RestController
@RequestMapping("/conseiller")
public class ConseillerController {
	
	@Autowired
	IConseillerService conseillerService;
	
	

	@RequestMapping(value = "/getPersonnelByLogin/{login}", method = RequestMethod.GET,headers="Accept=application/json")
	public Personnel getPersonnelByLogin(@PathVariable("login") String login) {
		Personnel personnel=conseillerService.getPersonnelByLogin(login);
		return personnel;
	}
	
	
	@RequestMapping(value = "/getClientByConseiller/{idConseiller}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Client> getClientByConseiller(@PathVariable("idConseiller") Long idConseiller) {
		List<Client> listeClient;
		listeClient=conseillerService.getClientByConseiller(idConseiller);
		return listeClient;
	}
	
	
	@RequestMapping(value = "/getCompteByClient/{idClient}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Compte> getCompteByClient(@PathVariable("idClient") Long idClient) {
		List<Compte> listeCompte;
		listeCompte= conseillerService.getCompteByClient(idClient);
		return listeCompte;
	}
	
	
	@RequestMapping(value = "/virement/{numCompteDeb}/{numCompteCred}/{montant}", method = RequestMethod.POST,headers="Accept=application/json")
	public boolean virement(@PathVariable("numCompteDeb") Long numCompteDeb, @PathVariable("numCompteCred") Long numCompteCred,@PathVariable("numCompteCred") double montant) {
		
		return conseillerService.virement(numCompteCred, numCompteDeb, montant);
	}
	
	
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST,headers="Accept=application/json")
	public void saveClient(Client client) {
		
		
		conseillerService.saveClient(client);
	}
	
	
//	@RequestMapping(value = "/saveClient", method = RequestMethod.POST,headers="Accept=application/json")
//	public Client saveClient(@RequestBody Client client) {
//		
//		return client;
////		conseillerService.saveClient(client);
//	}


	public IConseillerService getConseillerService() {
		return conseillerService;
	}


	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}
	
	

}