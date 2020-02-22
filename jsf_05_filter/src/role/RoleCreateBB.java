package role;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.LogDAO;
import dao.PermissionDAO;
import dao.RoleDAO;
import dao.UserDAO;
import entities.Log;
import entities.Permission;
import entities.Role;

@Named
@RequestScoped
public class RoleCreateBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/permissions.xhtml";
	private Role role = new Role();
	private Permission permission = new Permission();
	private String[] permissionList;
	
	@Inject
	RoleDAO roleDAO;
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	LogDAO logDAO;
	
	@Inject
	PermissionDAO permissionDAO;
	
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
	
	public boolean checkForDuplicates(Role role) {
		Role duplicate = roleDAO.getRoleByName(role.getName());
		if(duplicate == null) return false;
		else return true;
	}

	
	public String createRole() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		for(String perm : permissionList) {
			if(perm.equals("file_upload")) permission.setUploadFile((byte) 1);
			if(perm.equals("download_file")) permission.setDownloadFile((byte) 1);
			if(perm.equals("delete_file")) permission.setDeleteFile((byte) 1);
			if(perm.equals("create_package")) permission.setCreatePackage((byte) 1);
			if(perm.equals("delete_package")) permission.setDeletePackage((byte) 1);
			if(perm.equals("set_permission")) permission.setSetPermission((byte) 1);
			if(perm.equals("create_user")) permission.setCreateUser((byte) 1);
			if(perm.equals("view_logs")) permission.setViewLogs((byte) 1);
			if(perm.equals("add_licence")) permission.setAddLicence((byte) 1);
			if(perm.equals("get_licence")) permission.setGetLicence((byte) 1);
		}
		
		if(!checkForDuplicates(role)) {
			permissionDAO.create(permission);
			role.setPermission(permissionDAO.getLastAddedObject());
			roleDAO.create(role);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pomyślnie utworzono nową rolę", null));
			Log log = new Log("Role created", "Utworzono nową rolę: " + role.getName());
			logDAO.create(log);
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Rola o takiej nazwie już istnieje", null));
		}
		
		return PAGE_STAY_AT_THE_SAME;
	}

	public String[] getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(String[] permissionList) {
		this.permissionList = permissionList;
	}
	
}
