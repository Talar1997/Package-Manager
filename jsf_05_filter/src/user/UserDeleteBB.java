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

import dao.UserDAO;
import dao.RoleDAO;
import dao.LogDAO;
import entities.Log;
import entities.User;

@Named
@RequestScoped
public class UserDeleteBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/users.xhtml";
	private User user = new User();
	private String roleOption;
	
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
	
	public void delete(User user) {
		
	}

	
}
