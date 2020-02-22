package role;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.LogDAO;
import dao.RoleDAO;
import entities.Log;
import entities.Permission;
import entities.Role;
import dao.PermissionDAO;

@Named
@SessionScoped
public class RoleEditBB implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/admin/permissionEdit.xhtml";
	private static final String PAGE_ROLE_EDIT = "/pages/admin/permissionEdit.xhtml?faces-redirect=true";
	private static final String PAGE_ROLES = "/pages/admin/permissions.xhtml?faces-redirect=true";
	private Role selectedRole;
	private String[] permissionList;


	@Inject
	PermissionDAO permissionDAO;

	@Inject
	RoleDAO roleDAO;

	@Inject
	LogDAO logDAO;
	
	@Inject
	ClientData clientData;
	
	public Role getSelectedRole() {
		return selectedRole;
	}


	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}


	public String[] getPermissionList() {
		return permissionList;
	}


	public void setPermissionList(String[] permissionList) {
		this.permissionList = permissionList;
	}
	
	public boolean validateRole(Role role) {
		return false;
	}
	
	public String[] listToArray(List<String> list) {
		String[] arr = new String[list.size()]; 
		  
        for (int i =0; i < list.size(); i++) 
            arr[i] = list.get(i); 
  
        return arr;
	}	
	
	public String goToEditPage(Role role) {
		if(role == null) {
			return PAGE_ROLES;
		}
		else {
			this.selectedRole = role;
			List<String> permList = permissionDAO.permissionList(role.getPermission().getIdPermission());
			permissionList = listToArray(permList);
			
			return PAGE_ROLE_EDIT;
		}
	}
	
	public String backToRolesPage() {
		return PAGE_ROLES;
	}
	
	public boolean checkForDuplicates(String roleName) {
		Role duplicate = roleDAO.getRoleByName(roleName);
		if(duplicate != null) return true;
		else return false;
	}
	
	public String editRole() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(selectedRole.getIdRole() == 1) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie można edytować roli sysadmina", null));
			
			return null;
		}
		
		if(clientData.getClient().getRole().getPermission().getSetPermission() != 1) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie posiadasz uprawnień do wykonania tej operacji", null));
			return null;
		}
	
		Role oldRole = roleDAO.find(selectedRole.getIdRole());
		
		if(!oldRole.getName().equals(selectedRole.getName())) {
			if(!checkForDuplicates(selectedRole.getName())) {
				oldRole.setName(selectedRole.getName());
			}
			else {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Rola o podanej nazwie występuje już w systemie", null));
				return null;
			}
		}
		
		if(!oldRole.getDescription().equals(selectedRole.getDescription())) {
			oldRole.setDescription(selectedRole.getDescription());
		}
		
		Permission permission = selectedRole.getPermission();
		//Set all permission to 0
		permission.setUploadFile((byte) 0);
		permission.setDownloadFile((byte) 0);
		permission.setDeleteFile((byte) 0);
		permission.setCreatePackage((byte) 0);	
		permission.setDeletePackage((byte) 0);
		permission.setSetPermission((byte) 0);
		permission.setCreateUser((byte) 0);
		permission.setViewLogs((byte) 0);
		permission.setAddLicence((byte) 0);
		permission.setGetLicence((byte) 0);
		
		for(String perm : permissionList) {
			if(perm.equals("upload_file")) permission.setUploadFile((byte) 1);
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
		
		oldRole.setPermission(permission);
		permissionDAO.merge(permission);
		roleDAO.merge(oldRole);
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Pomyślnie edytowano role", null));
		
		Log log = new Log("Role edited", "Edytowano role id: " + oldRole.getIdRole() + " przez: " + clientData.getClient().getUsername() + " (" + clientData.getClient().getIdUser() + ")");
		logDAO.create(log);
		
		return PAGE_STAY_AT_THE_SAME;
	}
	
	
	
	
}
