package biz.ixxi.proxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Personnel;
import biz.ixxi.proxi.service.IGerantService;

@RestController
@RequestMapping("/gerant")
public class GerantController {
	
	@Autowired
	IGerantService gerantService;
	
	
	@RequestMapping(value = "/getConseillerByLogin", method = RequestMethod.GET,headers="Accept=application/json")
	public Personnel getConseillerByLogin() {
		Personnel personnel= new Conseiller("jmconseiller", "Jean-Michel","Conseiller");
		return personnel;
	}


	public IGerantService getGerantService() {
		return gerantService;
	}


	public void setGerantService(IGerantService gerantService) {
		this.gerantService = gerantService;
	}
	
	
	

}
