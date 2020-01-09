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
public class UserCreateBB {
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
	
	public void createUser() throws IOException {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		int roleId = roleDAO.getRoleByName(this.roleOption).getIdPermission();
		this.user.setIdPermission(roleId);
		
		if(validateUser(user)) {
			userDAO.create(user);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pomyślnie utworzono konto nowego uzytkownika", null));
			Log log = new Log("User created", "Utworzono nowego uzytkownika: " + user.getUsername());
			logDAO.create(log);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie udało się utworzyć uzytkownika: login lub email występują w systemie", null));
		}
	}
	
}
