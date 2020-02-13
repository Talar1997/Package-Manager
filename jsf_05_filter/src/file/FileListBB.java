package file;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import dao.DownloadListDAO;
import dao.FileListDAO;
import entities.DownloadList;
import entities.File;
import entities.FileList;

@Named
@RequestScoped
public class FileListBB {
	private List<FileList> allFiles;
	private List<FileList> lastAdded;
	private List<FileList> mostPopular;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/files/list.xhtml";
	private StreamedContent fileToDownload;
	String fileName;
	String description;
	String version;
	String addedBy;

	@Inject
	FileListDAO fListDAO;
	
	@Inject
	DownloadListDAO dListDAO;
	
	@PostConstruct
    public void init() {
		mostPopular = fListDAO.getMostPopular();
		lastAdded = fListDAO.getLastAdded();
        allFiles = fListDAO.findAll();
    }
	
	public int countFileLists() {
		return fListDAO.countFileLists();
	}
	
	public void download(FileList fileList) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		InputStream stream = new ByteArrayInputStream(fileList.getFile().getFileBinary());
		fileToDownload = new DefaultStreamedContent(stream, "application/x-msdownload", fileList.getFile().getFilename());
		int currentDownloads = fileList.getDownloadCounter();
		fileList.setDownloadCounter(++currentDownloads);
		fListDAO.merge(fileList);
		
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Rozpoczynam pobieranie pliku...", null));
		
		DownloadList dList = new DownloadList();
		dList.setTimestamp(java.time.LocalDate.now());
		
		dListDAO.create(dList);
	}
	
	public StreamedContent getFileToDownload() {
		return fileToDownload;
	}

	public void setFileToDownload(StreamedContent fileToDownload) {
		this.fileToDownload = fileToDownload;
	}
	
	public List<FileList> getAllFiles() {
		return allFiles;
	}

	public void setAllFiles(List<FileList> allFiles) {
		this.allFiles = allFiles;
	}
	
	public void sortFiles() {
		allFiles = fListDAO.search(fileName, description, version, addedBy);
		if(fileName.isBlank() && description.isBlank() && version.isBlank() && addedBy.isBlank()) {
			clearSearch();
		}
	}
	
	public void clearSearch() {
		allFiles = fListDAO.findAll();
	}
	
	public void getUserFiles() {
		
	}

	public List<FileList> getLastAdded() {
		return lastAdded;
	}

	public void setLastAdded(List<FileList> lastAdded) {
		this.lastAdded = lastAdded;
	}

	public List<FileList> getMostPopular() {
		return mostPopular;
	}

	public void setMostPopular(List<FileList> mostPopular) {
		this.mostPopular = mostPopular;
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