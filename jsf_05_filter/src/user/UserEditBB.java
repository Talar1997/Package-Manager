package user;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.faces.simplesecurity.PasswordHash;

import dao.UserDAO;
import dao.RoleDAO;
import dao.LogDAO;
import entities.Log;
import entities.User;

@Named
@RequestScoped
public class UserEditBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/users.xhtml";
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
	
	public void setUserRole() {
		//Set Role ID
		//int roleId = roleDAO.getRoleByName(this.roleOption).getIdPermission();
		//this.user.setIdPermission(roleId);
	}
	
	public void setHashedPassword() {
		//Hash Password
		String hashPassword = null;
		PasswordHash hash = new PasswordHash();
		hashPassword = hash.hashPassword(this.user.getPassword());
		this.user.setPassword(hashPassword);
	}
	
	public String editUser() {
		System.out.println("Edycja: " + selectedUser.getUsername());
		if(selectedUser == null) {
			return null;
		}
		
		
		return "";
	}
	
}
