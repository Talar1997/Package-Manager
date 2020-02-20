package user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.FileListDAO;
import entities.FileList;
import entities.Permission;
import entities.Role;
import entities.User;

@Named
@SessionScoped
public class UserProfileBB implements Serializable{
	private static final String PAGE_USER_PROFILE = "/public/user_profile.xhtml?faces-redirect=true";
	private HashMap<String, String> permissionSet = new HashMap<String, String>();
	User profile;
	List<FileList> fileList;
	
	@Inject
	FileListDAO fListDAO;
	
	public String show(User user) {
		if(user==null) {
			return null;
		}
		
		profile = user;
		findPermissionSet(user.getRole());
		fileList = fListDAO.getAddedByClient(user.getIdUser());
		
		return PAGE_USER_PROFILE;
	}

	public User getProfile() {
		return profile;
	}

	public void setProfile(User profile) {
		this.profile = profile;
	}
	
	public void findPermissionSet(Role role) {
		try {
			Permission p = role.getPermission();
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

	public List<FileList> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileList> fileList) {
		this.fileList = fileList;
	}
	
	
	
	
}
