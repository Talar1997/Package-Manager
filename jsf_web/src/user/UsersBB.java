package user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import dao.UserDAO;
import dao.RoleDAO;
import entities.User;

@Named
@RequestScoped
public class UsersBB {
	private List<User> allUsers;
	private List<User> lastRegisteredUsers;
	@Inject
	UserDAO userDAO;
	
	@PostConstruct
    public void init() {
        this.allUsers = userDAO.getAllUsers();
        this.lastRegisteredUsers = userDAO.getLastRegisteredUsers();
    }

	public int amountOfUsers() {
		return userDAO.countUsers();
	}
	
	public List<User> getLastRegisteredUsers(){
		return this.lastRegisteredUsers;
	}
	
	public List<User> getAllUsers(){
		return this.allUsers;
	}

}
