package user;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.UserDAO;
import dao.LogDAO;
import entities.Log;
import entities.User;

@Named
@RequestScoped
public class UserDeleteBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/users.xhtml";
	private User user = new User();
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
	
	public String delete(User user) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(user == null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie wybrano uzytkownika z listy", null));
			return null;
		}
		
		//Requesting user permission check. User need to have create_user permission to remove another user
		//{...}
		
		//Role check, cannot delete user with role id 1 (sysadmin)
		if(!userDAO.isSysadmin(user)) {
			userDAO.remove(user);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pomyślnie usunięto uzytkownika", null));
			Log log = new Log("User deleted", "Usunieto uzytkownika: " + user.getUsername() + " przez: " + clientData.getClient().getUsername() + " (" + clientData.getClient().getIdUser() + ")");
			logDAO.create(log);
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie posiadasz uprawnień do usunięcia tego uzytkownika", null));
		}
		
		
		return null;
	}
}
