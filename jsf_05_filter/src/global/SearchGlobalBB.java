package global;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.FileListDAO;
import dao.SoftwarePackageDAO;
import dao.UserDAO;
import entities.FileList;
import entities.Licence;
import entities.SoftwarePackage;
import entities.User;

@Named
@SessionScoped
public class SearchGlobalBB implements Serializable {
	private static final String PAGE_SEARCH = "/public/global_search.xhtml?faces-redirect=true";
	private List<FileList> files;
	private List<User> users;
	private List<SoftwarePackage> packages; //need to be added
	private String searchField;
	
	@Inject
	FileListDAO fListDAO;
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	SoftwarePackageDAO softPackDAO;
	
	
	public String search() {
		searchFiles();
		searchUsers();
		searchPackages();
		return PAGE_SEARCH;
	}
	
	public void searchFiles() {
		this.files = fListDAO.search(searchField, null, null, null);
	}
	
	public void searchUsers() {
		this.users = userDAO.searchByName(searchField);
	}
	
	
	public void searchPackages() {
		this.packages = softPackDAO.search(searchField, null, null);
	}
	
	
	public List<FileList> getFiles() {
		return files;
	}
	
	public void setFiles(List<FileList> files) {
		this.files = files;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<SoftwarePackage> getPackages() {
		return packages;
	}
	
	public void setPackages(List<SoftwarePackage> packages) {
		this.packages = packages;
	}
	
	public String getSearchField() {
		return searchField;
	}
	
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
}