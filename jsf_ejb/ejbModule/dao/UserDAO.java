package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.User;
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
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username like :login AND u.password LIKE MD5(:pass)");
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
				int idPermission = u.getIdPermission();
				Role role = (Role) roleDAO.find(idPermission);

				return permissionDAO.permissionList(role.getIdPermission());
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
}
