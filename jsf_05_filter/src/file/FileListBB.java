package file;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.DownloadListDAO;
import dao.FileListDAO;
import entities.FileList;
import entities.User;

@Named
@RequestScoped
public class FileListBB {
	private List<FileList> allFiles;
	private List<FileList> lastAdded;
	private List<FileList> mostPopular;
	private FileList selectedFile;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/files/list.xhtml";

	@Inject
	FileListDAO fListDAO;
	
	@Inject
	ClientData clientData;
	
	@Inject
	DownloadListDAO dListDAO;
	
	@PostConstruct
    public void init() {
        allFiles = fListDAO.findAll();
    }
	
	public int countFileLists() {
		return fListDAO.countFileLists();
	}
	
	public List<FileList> getAllFiles() {
		return allFiles;
	}

	public void setAllFiles(List<FileList> allFiles) {
		this.allFiles = allFiles;
	}
	
	public List<FileList> getLastAdded() {
		lastAdded = fListDAO.getLastAdded();
		return lastAdded;
	}

	public void setLastAdded(List<FileList> lastAdded) {
		this.lastAdded = lastAdded;
	}

	public List<FileList> getMostPopular() {
		mostPopular = fListDAO.getMostPopular();
		return mostPopular;
	}

	public void setMostPopular(List<FileList> mostPopular) {
		this.mostPopular = mostPopular;
	}

	public FileList getSelectedFile() {
		if(selectedFile != null && selectedFile.getUser() == null) {
			User newUser = new User();
			newUser.setUsername("N/A");
			selectedFile.setUser(newUser);
		}
		
		return selectedFile;
	}

	public void setSelectedFile(FileList selectedFile) {
		this.selectedFile = selectedFile;
	}

	
	
}