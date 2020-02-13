package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.DownloadList;
import entities.Role;

@Stateless
public class DownloadListDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(DownloadList dList) {
		em.persist(dList);
	}
	
	public long countInDate(int month, int year){
		Query query = em.createQuery("SELECT COUNT(d) FROM DownloadList d WHERE "
				+ "YEAR(d.timestamp) = :year AND MONTH(d.timestamp) = :month GROUP BY "
				+ "MONTH(d.timestamp)");
		query.setParameter("month", month);
		query.setParameter("year", year);
		
		try {
			return (Long) query.getResultList().get(0);
		}catch(Exception e) {}
		
		return 0;
	}
}
