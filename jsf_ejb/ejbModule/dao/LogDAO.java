package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Log;

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
	
	public List<Log> getLazyLogs(int first, int pageSize){
		Query query = em.createNamedQuery("Log.findAll");
		query.setFirstResult(first);
		//query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	public List<Log> getSecurityBreachLogs(){
		Query query = em.createNamedQuery("Log.findSecurityBreach");
		query.setMaxResults(5);
		return query.getResultList();
	}
	
	public int countLogs() {
		Query query = em.createNamedQuery("Log.findAll");
		return query.getResultList().size();
	}

}
