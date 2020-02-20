package file;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.FileListDAO;
import entities.FileList;

@Named
@SessionScoped
public class SearchFileListBB implements Serializable {
	private static final String PAGE_SEARCH = "/pages/files/search_file_list.xhtml?faces-redirect=true";
	private List<FileList> allFiles;
	String fileName;
	String description;
	String version;
	String addedBy;

	@Inject
	FileListDAO fListDAO;
	
	@PostConstruct
    public void init() {
    }
	
	
	public List<FileList> getAllFiles() {
		return allFiles;
	}

	public void setAllFiles(List<FileList> allFiles) {
		this.allFiles = allFiles;
	}
	
	public String sortFiles() {
		allFiles = fListDAO.search(fileName, description, version, addedBy);
		
		if(fileName.isBlank() && description.isBlank() && version.isBlank() && addedBy.isBlank()) {
			clearSearch();
		}
		
		return PAGE_SEARCH;
	}
	
	public String clearSearch() {
		allFiles = fListDAO.findAll();
		fileName = "";
		description = "";
		version = "";
		addedBy = "";
		return PAGE_SEARCH;
	}
	
	public void getUserFiles() {
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
}