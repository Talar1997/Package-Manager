package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import dao.RoleDAO;
import entities.Role;

@Named
@RequestScoped
public class RolesBB {
	private List<String> roleList = new ArrayList<String>();
	
	@Inject
	RoleDAO roleDAO;
	@PostConstruct
	public void init() {
		List<Role> roles = roleDAO.getAllRoles();
		
		for(Role r : roles) {
			roleList.add(r.getName());
		}
	}
	
	public List<String> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}
	
	
}
