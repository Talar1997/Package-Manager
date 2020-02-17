package user;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.simplesecurity.PasswordHash;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.LogDAO;
import dao.RoleDAO;
import dao.UserDAO;
import entities.Log;
import entities.User;

@Named
@SessionScoped
public class UserEditBB implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/userEdit.xhtml";
	private static final String PAGE_USER_EDIT = "/pages/admin/userEdit.xhtml?faces-redirect=true";
	private static final String PAGE_USERS = "/pages/admin/users.xhtml?faces-redirect=true";
	private String roleOption;
	private User user;
	private User selectedUser;
	
	public User getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	@Inject
	RoleDAO roleDAO;
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	LogDAO logDAO;
	
	@Inject
	ClientData clientData;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRoleOption() {
		return roleOption;
	}
	public void setRoleOption(String roleOption) {
		this.roleOption = roleOption;
	}
	
	public boolean validateUser(User user) {
		List<User> duplicates = userDAO.searchForDuplicate(user.getUsername(), user.getEmail());
		if(duplicates.isEmpty() || duplicates == null) return true;
		else return false;
	}
	
	
	public String getHashedPassword(String passToHash) {
		PasswordHash hash = new PasswordHash();
		return hash.hashPassword(passToHash);
	}
	
	public String goToEditPage(User user) {
		this.selectedUser = user;
		return PAGE_USER_EDIT;
	}
	
	public String backToUsersPage() {
		return PAGE_USERS;
	}
	
	public String editUser() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(selectedUser == null) {
			return null;
		}
		
		if(selectedUser.getRole().getIdRole() == 1 && !clientData.getClient().getRole().getName().equals("sysadmin")) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Tylko system admin może ustawić rolę sysadmin", null));
			return null;
		}
		
		User oldUser = userDAO.find(selectedUser.getIdUser());
		
		if(oldUser.getRole().getIdRole() == 1 && !clientData.getClient().getRole().getName().equals("sysadmin")) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Tylko system admin może edytować tego użytkownika", null));
			return null;
		}
		
		if(selectedUser.getPassword().length() != 0) {
			oldUser.setPassword(getHashedPassword(selectedUser.getPassword()));
		}
		
		
		selectedUser.setRole(roleDAO.getRoleByName(selectedUser.getRole().getName()));
		if(selectedUser.getRole().getIdRole() != oldUser.getRole().getIdRole()) {
			oldUser.setRole(selectedUser.getRole());
		}
		
		if(selectedUser.getUsername() != oldUser.getUsername()) {
			List<User> duplicates = userDAO.searchForDuplicateByName(selectedUser.getUsername());
			if(duplicates.size() > 1) {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Podany login występuje już w bazie danych", null));
				return null;
			}
			else {
				oldUser.setUsername(selectedUser.getUsername());
			}
		}
		
		if(selectedUser.getEmail() != oldUser.getEmail()) {
			List<User> duplicates = userDAO.searchForDuplicateByMail(selectedUser.getEmail());
			if(duplicates.size() > 1) {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Podany mail występuje już w bazie danych", null));
				return null;
			}
			else {
				oldUser.setEmail(selectedUser.getEmail());
			}
		}
		
		if(selectedUser.getName() != oldUser.getName()) {
			oldUser.setName(selectedUser.getName());
		}
		
		if(selectedUser.getSurname() != oldUser.getSurname()) {
			oldUser.setSurname(selectedUser.getSurname());
		}
		
		userDAO.merge(oldUser);
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Użytkownik został edytowany", null));
		Log log = new Log("User edited", "Edytowano uzytkownika id: " + oldUser.getIdUser() + " przez: " + clientData.getClient().getUsername() + " (" + clientData.getClient().getIdUser() + ")");
		logDAO.create(log);
		return PAGE_STAY_AT_THE_SAME;
	}
	
}
