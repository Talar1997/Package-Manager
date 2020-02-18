package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.FileList;
import entities.SoftwarePackage;

@Stateless
public class SoftwarePackageDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public int countPackages() {
		return em.createNamedQuery("SoftwarePackage.countSoftwarePackages").getResultList().size();
	}

	public void create(SoftwarePackage softwarePackage) {
		em.persist(softwarePackage);
	}

	public SoftwarePackage merge(SoftwarePackage softwarePackage) {
		return em.merge(softwarePackage);
	}

	public void remove(SoftwarePackage softwarePackage) {
		em.remove(em.merge(softwarePackage));
	}

	public SoftwarePackage find(Object id) {
		return em.find(SoftwarePackage.class, id);
	}
	
	public List<SoftwarePackage> getLastAdded(){
		return em.createNamedQuery("SoftwarePackage.getLastAdded").getResultList();
	}

}
