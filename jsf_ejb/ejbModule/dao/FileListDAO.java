package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.FileList;

@Stateless
public class FileListDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public Long countFileLists() {
		return (Long) em.createNamedQuery("FileList.countFileList").getResultList().get(0);
	}

	public void create(FileList fileList) {
		em.persist(fileList);
	}

	public FileList merge(FileList fileList) {
		return em.merge(fileList);
	}

	public void remove(FileList fileList) {
		em.remove(em.merge(fileList));
	}

	public FileList find(Object id) {
		return em.find(FileList.class, id);
	}
	
	public FileList findOne(int id) {
		Query query = em.createQuery("SELECT new FileList(f.idListFile, f.addedTime, f.description, f.downloadCounter, f.user, f.name, f.version)"
				+ " FROM FileList f WHERE f.idListFile = :id");
		query.setParameter("id", id);
		return (FileList) query.getResultList().get(0);
	}
	
	public List<FileList> getAddedByClient(int id){
		Query query = em.createQuery("SELECT new FileList(f.idListFile, f.addedTime, f.description, f.downloadCounter, f.user, f.name, f.version) FROM FileList f WHERE f.user.idUser = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public List<FileList> findAll(){
		return em.createNamedQuery("FileList.findAll").getResultList();
	}
	
	public List<FileList> getLastAdded(){
		Query query = em.createNamedQuery("FileList.getLastAdded");
		query.setMaxResults(4);
		return query.getResultList();
	}
	
	public List<FileList> getMostPopular(){
		Query query = em.createNamedQuery("FileList.showMostPopular");
		query.setMaxResults(4);
		return query.getResultList();
	}
	
	public List<FileList> search(String fileName, String description, String version, String addedBy){

		// 1. Build query string with parameters
		String select = "SELECT f ";
		String from = "FROM FileList f ";
		String where = "";

		// search for surname
		if (fileName != null) {
			if (where.isEmpty()) {
				where = "WHERE ";
			} else {
				where += "AND ";
			}
			where += "f.name LIKE :fileName ";
		}
		
		if (version != null) {
			if (where.isEmpty()) {
				where = "WHERE ";
			} else {
				where += "AND ";
			}
			where += "f.version LIKE :version ";
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
		if (fileName != null) {
			query.setParameter("fileName", fileName+"%");
		}
		
		if (description != null) {
			query.setParameter("description", description+"%");
		}
		
		if (version != null) {
			query.setParameter("version", version+"%");
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
