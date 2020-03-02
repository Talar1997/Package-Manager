package softwarePackage;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SoftwarePackageDAO;
import entities.SoftwarePackage;

@Named("searchSoftwarePackagesBB")
@SessionScoped
public class SearchSoftwarePackagesBB implements Serializable {
	private static final String PAGE_SEARCH = "/pages/packages/search_packages.xhtml?faces-redirect=true";
	private List<SoftwarePackage> allFiles;
	String name;
	String description;
	String addedBy;

	@Inject
	SoftwarePackageDAO softPackDAO;
	
	@PostConstruct
    public void init() {
    }
	
	public String sortFiles() {
		allFiles = softPackDAO.search(name, description, addedBy);
		
		if(name.isBlank() && description.isBlank() && addedBy.isBlank()) {
			clearSearch();
		}
		
		return PAGE_SEARCH;
	}
	
	public String clearSearch() {
		allFiles = softPackDAO.findAll();
		name = "";
		description = "";
		addedBy = "";
		return PAGE_SEARCH;
	}

	public List<SoftwarePackage> getAllFiles() {
		return allFiles;
	}

	public void setAllFiles(List<SoftwarePackage> allFiles) {
		this.allFiles = allFiles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	
	
	
}