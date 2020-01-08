package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Log;

@Stateless
public class LogDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(Log log) {
		em.persist(log);
	}

}
