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


/**
 * 
 * Classe de Web Services REST (Spring REST/WebMVC) prenant en charge les cas d'utilisation Conseiller.
 * @author Stark Industries
 *
 */
@RestController
@RequestMapping("/conseiller")
public class ConseillerController {
	
	@Autowired
	IConseillerService conseillerService;
	
	

	/**
	 * Méthode retournant l'objet Personnel en fonction du login du Personnel recherché
	 * @param login - le login de l'utilisateur se connectant
	 * @return l'objet relatif à l'utilisateur se connectant
	 */
	@RequestMapping(value = "/getPersonnelByLogin/{login}", method = RequestMethod.GET,headers="Accept=application/json")
	public Personnel getPersonnelByLogin(@PathVariable("login") String login) {
		Personnel personnel=conseillerService.getPersonnelByLogin(login);
		return personnel;
	}
	
	
	/**
	 * Méthode retournant la liste des clients d'un conseillers en fonction de son id
	 * @param idConseiller - l'id du conseiller concerné
	 * @return la liste des clients du conseiller
	 */
	@RequestMapping(value = "/getClientByConseiller/{idConseiller}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Client> getClientByConseiller(@PathVariable("idConseiller") Long idConseiller) {
		List<Client> listeClient;
		listeClient=conseillerService.getClientByConseiller(idConseiller);
		return listeClient;
	}
	
	
	/**
	 * Méthode permettant de retournant la liste des comptes d'un client donné
	 * @param idClient - l'id du client concerné
	 * @return la liste des comptes du client
	 */
	@RequestMapping(value = "/getCompteByClient/{idClient}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Compte> getCompteByClient(@PathVariable("idClient") Long idClient) {
		List<Compte> listeCompte;
		listeCompte= conseillerService.getCompteByClient(idClient);
		return listeCompte;
	}
	
	
	/**
	 * Methode permettant de retournant la liste de tous les comptes en base de données
	 * @return lq liste de tous les comptes en base de données
	 */
	@RequestMapping(value = "/getAllCompte", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Compte> getAllCompte() {
		List<Compte> listeCompte;
		listeCompte= conseillerService.getAllCompte();
		return listeCompte;
	}
	
	
	/**
	 * Méthode permettant de traiter les opérations de virement
	 * @param numCompteDeb - le numéro du compte débiteur
	 * @param numCompteCred - le numéro du compte créditeur
	 * @param montant - le montant du virement
	 * @return un booleen vrai si le virement a été un succès
	 */
	@RequestMapping(value = "/virement/{numCompteDeb}/{numCompteCred}/{montant}", method = RequestMethod.POST,headers="Accept=application/json")
	public boolean virement(@PathVariable("numCompteDeb") Long numCompteDeb, @PathVariable("numCompteCred") Long numCompteCred,@PathVariable("montant") int montant) {
		
		return conseillerService.virement(numCompteCred, numCompteDeb, montant);

	}
	
	
	/**
	 * Methode permettant la sauvegarde ou l'édition d'un client envoyé dans une requête HTTP
	 * @param client - le client a sauvegarder ou éditer
	 */
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST,headers="Accept=application/json")
	public void saveClient(@RequestBody Client client) {
		
		
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