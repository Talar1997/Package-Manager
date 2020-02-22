package statistics;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.UserDAO;
import entities.User;

@Named
@RequestScoped
public class UsersStatisticsBB {
	private List<User> lastRegisteredUsers;
	
	@Inject
	UserDAO userDAO;
	
	@PostConstruct
    public void init() {
        this.lastRegisteredUsers = userDAO.getLastRegisteredUsers();
    }
	
	public List<User> getLastRegisteredUsers(){
		return this.lastRegisteredUsers;
	}
	
	public int amountOfUsers() {
		return userDAO.countUsers();
	}
}
