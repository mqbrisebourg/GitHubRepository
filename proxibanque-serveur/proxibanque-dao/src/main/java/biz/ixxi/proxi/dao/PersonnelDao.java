package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Personnel;



@Repository("personnelDao")
public interface PersonnelDao extends JpaRepository<Personnel,Long>{
	public List<Personnel> findByLogin(String login);
}
