package role;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.LogDAO;
import dao.RoleDAO;
import dao.UserDAO;
import entities.Permission;
import entities.Role;

@Named
@RequestScoped
public class RoleCreateBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/roles.xhtml";
	private Role role = new Role();
	private Permission permission = new Permission();
	
	@Inject
	RoleDAO roleDAO;
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	LogDAO logDAO;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}


	public boolean validateRole() {
		
		return false;
	}
	
	public boolean checkForDuplicates() {
		
		return false;
	}
	
	public Permission findSimilarPermission(Permission permission) {
		
		return null;
	}
	
	public String createRole() {
		System.out.println("Dupa");
		System.out.println(role.getName() + role.getDescription());
		System.out.println(permission.getCreatePackage());
		return PAGE_STAY_AT_THE_SAME;
	}
	
}
