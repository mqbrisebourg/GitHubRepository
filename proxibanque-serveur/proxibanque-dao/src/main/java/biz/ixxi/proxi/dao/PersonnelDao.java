package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
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
