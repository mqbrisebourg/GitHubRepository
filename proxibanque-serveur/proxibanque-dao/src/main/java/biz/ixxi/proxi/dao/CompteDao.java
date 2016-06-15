package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import biz.ixxi.proxi.domaine.Compte;

@Repository("compteDao")
public interface CompteDao extends JpaRepository<Compte, Long> {

	public List<Compte> findByIdClient(Long idClient);
}