package biz.ixxi.proxi.dao;


import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Personnel;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Personnels.
 * @author Stark Industries
 *
 */
@Repository("personnelDao")
public interface PersonnelDao extends GeneralUserDao<Personnel>{
	
	
}
