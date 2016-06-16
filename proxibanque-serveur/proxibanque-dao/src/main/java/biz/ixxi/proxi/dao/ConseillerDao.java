package biz.ixxi.proxi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import biz.ixxi.proxi.domaine.Conseiller;

/**
 * Interface gérée par Spring Data Jpa pour l'accès aux données des Conseillers.
 * @author Stark Industries
 *
 */
@Repository("conseillerDao")
public interface ConseillerDao extends GeneralUserDao<Conseiller> {
	/**
	 * @param idGerant - l'Id du Gérant
	 * @return la liste des conseillers gérés par le gérant.
	 */
	public List<Conseiller> findByIdGerant(Long idGerant);
}
