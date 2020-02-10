package dao;

import java.util.List;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Permission;
import entities.Role;
import entities.User;

@Stateless
public class PermissionDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public Permission find(Object id) {
		return em.find(Permission.class, id);
	}
	
	public void create(Permission permission) {
		em.persist(permission);
	}
	
	public void remove(Permission permission) {
		em.remove(em.merge(permission));
	}
	
	public Permission merge(Permission permission) {
		return em.merge(permission);
	}
	
	public List<String> permissionList(Object id){
		Permission p = find(id);
		List<String> pList = new ArrayList<String>();
		
		if(p.getUploadFile() == 1) pList.add("upload_file");
		if(p.getDownloadFile() == 1) pList.add("download_file");
		if(p.getDeleteFile() == 1) pList.add("delete_file");
		if(p.getDeletePackage() == 1) pList.add("delete_package");
		if(p.getCreatePackage() == 1) pList.add("create_package");
		if(p.getSetPermission() == 1) pList.add("set_permission");
		if(p.getCreateUser() == 1) pList.add("create_user");
		if(p.getViewLogs() == 1) pList.add("view_logs");
		if(p.getGetLicence() == 1) pList.add("get_licence");
		if(p.getAddLicence() == 1) pList.add("add_licence");
		
		return pList;
	}
	
	public Permission getLastAddedObject() {
		Query query = em.createQuery("SELECT MAX(p.idPermission) FROM Permission p");
		try {
			int lastId = (Integer) query.getResultList().get(0);
			return this.find(lastId);
		}catch(Exception e) {}
		return null;
	}

}
