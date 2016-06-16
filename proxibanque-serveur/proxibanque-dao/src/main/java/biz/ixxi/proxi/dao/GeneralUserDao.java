package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import biz.ixxi.proxi.domaine.Personnel;

/**
 * Interface générale gérée par Spring Data Jpa pour permettre la prise en charge de l'héritage entre Gérant et Conseiller et Personnel.
 * @author Stark Industries
 *
 */
public interface GeneralUserDao<T extends Personnel> extends JpaRepository<T, Long> {
	/**
	 * @param login - le login du Personnel donné
	 * @return la liste des Personnels ayant ce login.
	 */
	public List<Personnel> findByLogin(String login);
}
