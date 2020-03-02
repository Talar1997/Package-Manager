package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.File;
import entities.PackageFile;

@Stateless
public class PackageFileDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(PackageFile packageFile) {
		em.persist(packageFile);
	}
	
	public List<PackageFile> findAll(){
		return em.createNamedQuery("PackageFile.findAll").getResultList();
	}

	public PackageFile merge(PackageFile packageFile) {
		return em.merge(packageFile);
	}

	public void remove(File file) {
		em.remove(em.merge(file));
	}

	public PackageFile find(Object id) {
		return em.find(PackageFile.class, id);
	}

	public List<PackageFile> findWhere(int idPackage){
		Query query = em.createQuery("SELECT p FROM PackageFile p WHERE p.softwarePackage.idPackage = :id");
		query.setParameter("id", idPackage);
		
		return query.getResultList();
	}
	
}
