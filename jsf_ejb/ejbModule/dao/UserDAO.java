package dao;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.User;
import entities.Permission;
import entities.Role;

@Stateless
public class UserDAO {
	
	@Inject
	RoleDAO roleDAO;
	
	@Inject
	PermissionDAO permissionDAO;
	
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}
	
	public User getUserFromDB(String login, String pass) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username like :login AND u.password LIKE :pass");
		query.setParameter("login", login);
		query.setParameter("pass", pass);
		
		try {
			return (User) query.getResultList().get(0);
		} catch (Exception e) {	}
		
		return null;
	}
	
	
	public List<String> getUserRolesFromDB(User user){
		Query query = em.createQuery("SELECT u FROM User u WHERE u.idUser = :id_user");
		query.setParameter("id_user", user.getIdUser());
		
		try {
			User u = (User) query.getResultList().get(0);
			
			if(u != null) {
				int idPermission = user.getRole().getPermission().getIdPermission();
				Role role = (Role) roleDAO.find(idPermission);

				return permissionDAO.permissionList(role.getPermission().getIdPermission());
			}
		} catch (Exception e) {	}
	
		return null;
	}
	
	public int countUsers() {
		return em.createNamedQuery("User.findAll").getResultList().size();
	}
	
	public List<User> getLastRegisteredUsers(){
		Query query = em.createNamedQuery("User.getLastRegistered");
		query.setMaxResults(5);
		return query.getResultList();
	}
	
	public List<User> getAllUsers(){
		return em.createNamedQuery("User.findAll").getResultList();
	}
	
	public List<User> searchForDuplicate(String username, String email) {
		Query query =  em.createQuery("SELECT u FROM User u WHERE u.username LIKE :username OR u.email LIKE :email");
		query.setParameter("username", username);
		query.setParameter("email", email);
		return query.getResultList();
	}
	
	public boolean isSysadmin(User user) {
		return user.getRole().getIdRole() == 1 ? true : false;
	}
	
	public boolean hasPermission(User user, String permissionName) {
		HashMap<String, Boolean> permissionSet = new HashMap<>();
		Permission p = user.getRole().getPermission();
		
		if(p.getUploadFile() > 0) permissionSet.put("upload_file", true);
		else { permissionSet.put("upload_file", false); } 
		
		if(p.getDownloadFile() > 0) permissionSet.put("download_file", true);
		else { permissionSet.put("download_file", false); } 
		
		if(p.getDeleteFile() > 0) permissionSet.put("delete_file", true);
		else { permissionSet.put("delete_file", false); } 
		
		if(p.getCreatePackage()> 0) permissionSet.put("create_package", true);
		else { permissionSet.put("create_package", false); } 
		
		if(p.getDeletePackage() > 0) permissionSet.put("delete_package", true);
		else { permissionSet.put("delete_package", false); } 
		
		if(p.getSetPermission() > 0) permissionSet.put("set_permission", true);
		else { permissionSet.put("set_permission", false); } 
		
		if(p.getCreateUser() > 0) permissionSet.put("create_user", true);
		else { permissionSet.put("create_user", false); } 
		
		if(p.getViewLogs() > 0) permissionSet.put("view_logs", true);
		else { permissionSet.put("view_logs", false); } 
		
		if(p.getGetLicence() > 0) permissionSet.put("get_licence", true);
		else { permissionSet.put("get_licence", false); } 
		
		if(p.getAddLicence() > 0) permissionSet.put("add_licence", true);
		else { permissionSet.put("add_licence", false); } 
		
		return permissionSet.get(permissionName);
	}
}
