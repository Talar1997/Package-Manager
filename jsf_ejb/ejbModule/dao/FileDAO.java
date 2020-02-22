package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.File;

@Stateless
public class FileDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public int countFileLists() {
		return em.createNamedQuery("FileList.countFileList").getResultList().size();
	}

	public void create(File file) {
		em.persist(file);
	}
	
	public List<File> findAll(){
		return em.createNamedQuery("File.findAll").getResultList();
	}

	public File merge(File file) {
		return em.merge(file);
	}

	public void remove(File file) {
		em.remove(em.merge(file));
	}

	public File find(Object id) {
		return em.find(File.class, id);
	}
	
	public File getLastAddedObject() {
		Query query = em.createQuery("SELECT MAX(f.idFile) FROM File f");
		try {
			int lastId = (Integer) query.getResultList().get(0);
			return this.find(lastId);
		}catch(Exception e) {}
		return null;
	}

}
