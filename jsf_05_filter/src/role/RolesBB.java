package role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.PermissionDAO;
import dao.RoleDAO;
import entities.Permission;
import entities.Role;

@Named
@RequestScoped
public class RolesBB {
	private List<String> roleList = new ArrayList<String>();
	private List<Role> roleListAll;
	private Role selectedRole;
	private HashMap<String, String> permissionSet = new HashMap<String, String>();

	@Inject
	RoleDAO roleDAO;
	@Inject 
	PermissionDAO permissionDAO;
	
	@PostConstruct
	public void init() {
		List<Role> roles = roleDAO.getAllRoles();
		this.roleListAll = roles;
		
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
	
	public List<Role> getRoleListAll() {
		return roleListAll;
	}

	public void setRoleListAll(List<Role> roleListAll) {
		this.roleListAll = roleListAll;
	}

	public Role getSelectedRole() {
		this.findPermissionSet(selectedRole);
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}
	
	public void findPermissionSet(Role role) {
		try {
			Permission p = permissionDAO.find(role.getIdPermission());
			if(p.getUploadFile() > 0) permissionSet.put("upload_file", "Tak");
			else { permissionSet.put("upload_file", "Nie"); } 
			
			if(p.getDownloadFile() > 0) permissionSet.put("download_file", "Tak");
			else { permissionSet.put("download_file", "Nie"); } 
			
			if(p.getDeleteFile() > 0) permissionSet.put("delete_file", "Tak");
			else { permissionSet.put("delete_file", "Nie"); } 
			
			if(p.getCreatePackage()> 0) permissionSet.put("create_package", "Tak");
			else { permissionSet.put("create_package", "Nie"); } 
			
			if(p.getDeletePackage() > 0) permissionSet.put("delete_package", "Tak");
			else { permissionSet.put("delete_package", "Nie"); } 
			
			if(p.getSetPermission() > 0) permissionSet.put("set_permission", "Tak");
			else { permissionSet.put("set_permission", "Nie"); } 
			
			if(p.getCreateUser() > 0) permissionSet.put("create_user", "Tak");
			else { permissionSet.put("create_user", "Nie"); } 
			
			if(p.getViewLogs() > 0) permissionSet.put("view_logs", "Tak");
			else { permissionSet.put("view_logs", "Nie"); } 
			
			if(p.getGetLicence() > 0) permissionSet.put("get_licence", "Tak");
			else { permissionSet.put("get_licence", "Nie"); } 
			
			if(p.getAddLicence() > 0) permissionSet.put("add_licence", "Tak");
			else { permissionSet.put("add_licence", "Nie"); } 
			
		}catch(NullPointerException e) {}
	}
	
	public HashMap<String, String> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(HashMap<String, String> permissionSet) {
		this.permissionSet = permissionSet;
	}
	
}
