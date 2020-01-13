package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Log;
import entities.Role;

@Stateless
public class LogDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(Log log) {
		em.persist(log);
	}
	
	public List<Log> getAllLogs(){
		return em.createNamedQuery("Log.findAll").getResultList();
	}
	
	public List<Log> getSecurityBreachLogs(){
		Query query = em.createNamedQuery("Log.findSecurityBreach");
		query.setMaxResults(5);
		return query.getResultList();
	}

}
