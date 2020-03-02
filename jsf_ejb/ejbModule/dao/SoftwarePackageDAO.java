package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.FileList;
import entities.SoftwarePackage;
import entities.User;

@Stateless
public class SoftwarePackageDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public long countPackages() {
		return (Long) em.createNamedQuery("SoftwarePackage.countSoftwarePackages").getResultList().get(0);
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
	
	public SoftwarePackage getLastAddedObject() {
		return (SoftwarePackage) em.createNamedQuery("SoftwarePackage.getLastAddedObject").getResultList().get(0);
	}
	
	public List<SoftwarePackage> getFullList(){
		return em.createNamedQuery("SoftwarePackage.findAll").getResultList();
	}
	
	public List<SoftwarePackage> getAddedBy(User user){
		Query query = em.createQuery("SELECT s FROM SoftwarePackage s WHERE s.user.idUser = :id");
		query.setParameter("id", user.getIdUser());
		return query.getResultList();
	}
	
	public List<SoftwarePackage> findAll(){
		return em.createQuery("SELECT s FROM SoftwarePackage s").getResultList();
	}
	
	public List<SoftwarePackage> search(String name, String description, String addedBy){

		// 1. Build query string with parameters
		String select = "SELECT f ";
		String from = "FROM SoftwarePackage f ";
		String where = "";

		// search for surname
		if (name != null) {
			if (where.isEmpty()) {
				where = "WHERE ";
			} else {
				where += "AND ";
			}
			where += "f.name LIKE :name ";
		}
	
		
		if (description != null) {
			if (where.isEmpty()) {
				where = "WHERE ";
			} else {
				where += "AND ";
			}
			where += "f.description LIKE :description ";
		}
		
		if (addedBy != null) {
			if (where.isEmpty()) {
				where = "WHERE ";
			} else {
				where += "AND ";
			}
			where += "f.user.username LIKE :addedBy ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where);

		// 3. Set configured parameters
		if (name != null) {
			query.setParameter("name", name+"%");
		}
		
		if (description != null) {
			query.setParameter("description", description+"%");
		}
		
	
		if (addedBy != null) {
			query.setParameter("addedBy", addedBy+"%");
		}
	


		// 4. Execute query and retrieve list of Person objects
		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
