package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Client;


/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Clients.
 * @author Stark Industries
 *
 */

@Repository("clientDao")
public interface ClientDao extends JpaRepository<Client, Long> {
	
	
	/**
	 * @param idPersonnel - l'id du Personnel
	 * @return la liste des clients du Personnel donné.
	 */
	public List<Client> findByIdPersonnel(Long idPersonnel);
	/**
	 * @param idClient - l'id du Client recherché
	 * @return l'object Client correspondant à l'id donné.
	 */
	public List<Client> findByIdClient(Long idClient);
}
