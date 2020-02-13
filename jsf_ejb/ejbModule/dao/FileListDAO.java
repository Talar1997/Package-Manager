package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.File;
import entities.FileList;

@Stateless
public class FileListDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public int countFileLists() {
		return em.createNamedQuery("FileList.countFileList").getResultList().size();
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
	
	public List<FileList> findAll(){
		return em.createNamedQuery("FileList.findAll").getResultList();
	}
	
	public List<FileList> getLastAdded(){
		return em.createNamedQuery("FileList.getLastAdded").getResultList();
	}
	
	public List<FileList> getMostPopular(){
		Query query = em.createNamedQuery("FileList.showMostPopular");
		query.setMaxResults(5);
		return query.getResultList();
	}
	
	public List<FileList> search(String fileName, String description, String version, String addedBy){
		Query query = em.createQuery("SELECT f FROM FileList f WHERE f.name LIKE :fileName OR "
				+ "f.description LIKE :description OR f.version LIKE :version OR f.user.username LIKE :addedBy");
		query.setParameter("fileName", fileName);
		query.setParameter("description", description);
		query.setParameter("version", version);
		query.setParameter("addedBy", addedBy);
		
		return query.getResultList();
	}

}
