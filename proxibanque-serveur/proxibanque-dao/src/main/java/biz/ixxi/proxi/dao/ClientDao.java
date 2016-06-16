package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Client;

@Repository("clientDao")
public interface ClientDao extends JpaRepository<Client, Long> {

	public List<Client> findByIdConseiller(Long idConseiller);
	public List<Client> findByIdClient(Long idClient);
}
