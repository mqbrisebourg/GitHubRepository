package biz.ixxi.proxi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import biz.ixxi.proxi.dao.PersonnelDao;

import biz.ixxi.proxi.domaine.Conseiller;
import biz.ixxi.proxi.domaine.Personnel;

@Service("gerantService")
public class GerantService implements IGerantService {
	
	
	
	@Autowired
	private PersonnelDao personnelDao;
	
	
	
	public Personnel getConseillerByLogin(String login){
		List<Personnel> liste;
		Personnel conseiller;
		liste = personnelDao.findByLogin(login);
		conseiller=liste.get(0);
		return conseiller;
		
	}



	public PersonnelDao getPersonnelDao() {
		return personnelDao;
	}


	
	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = (PersonnelDao) personnelDao;
	}
	
}
