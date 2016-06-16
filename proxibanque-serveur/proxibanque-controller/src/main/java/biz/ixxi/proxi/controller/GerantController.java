package biz.ixxi.proxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biz.ixxi.proxi.domaine.Compte;
import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Transaction;
import biz.ixxi.proxi.service.IGerantService;



/**
 * 
 * Classe de Web Services REST (Spring REST/WebMVC) prenant en charge les cas d'utilisation Gerant.
 * 
 * @author Stark industries
 *
 */
@RestController
@RequestMapping("/gerant")
public class GerantController {
	
	@Autowired
	IGerantService gerantService;
	
	
//	@RequestMapping(value = "/getConseillerByLogin", method = RequestMethod.GET,headers="Accept=application/json")
//	public Personnel getConseillerByLogin() {
//		Personnel personnel= new Conseiller("jmconseiller", "Jean-Michel","Conseiller");
//		return personnel;
//	}
	
	
	/**
	 * Méthode retournant la liste des conseillers d'un gérant en fonction de son id.
	 * @param idGerant - l'id du gérant
	 * @return la liste des conseillers gérés par le gérant
	 */
	@RequestMapping(value = "/getConseillerByGerant/{idGerant}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Conseiller> getConseillerByGerant(@PathVariable("idGerant") Long idGerant) {
		return gerantService.getConseillerByGerant(idGerant);
	}

	/**
	 * Méthode retournant la liste de toutes les transactions financières effectuées dans l'agence.
	 * @return la liste de toutes les transactions financières effectuées par les conseillers de l'agence
	 */
	@RequestMapping(value = "/getAllTransaction", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Transaction> getAllTransaction() {
		return gerantService.getAllTransaction();
	}
	
	
	/**
	 * Méthode retournant la liste de tous les comptes ne respectant pas leurs autorisations de découverts.
	 * @return la liste de tous les comptes bancaires ne respectant pas leur autorisation de découvert
	 */
	@RequestMapping(value = "/getCompteADecouvert", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Compte> getCompteADecouvert() {
		return gerantService.getComptesADecouvert();
	}



	public IGerantService getGerantService() {
		return gerantService;
	}


	public void setGerantService(IGerantService gerantService) {
		this.gerantService = gerantService;
	}
	
	
	

}
