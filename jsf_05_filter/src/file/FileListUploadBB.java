package file;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.jsfcourse.login.ClientData;

import dao.FileDAO;
import dao.FileListDAO;
import entities.File;
import entities.FileList;

@Named
@RequestScoped
public class FileListUploadBB {
	private FileList fileList = new FileList();
	private UploadedFile file;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/files/upload.xhtml";
	
	@Inject
	FileListDAO fListDAO;
	
	@Inject
	FileDAO fileDAO;
	
	@Inject
	ClientData clientData;
	
	@PostConstruct
    public void init() {
        
    }
	
	public boolean validate() {
		return true;
	}
	
	public String upload() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(file == null || file.getFileName() == null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie wybrałeś pliku", null));
		}
		else {
			if(validate()) {
				File fileToUpload = new File();
				fileToUpload.setFileBinary(file.getContents());
				fileToUpload.setFilename(file.getFileName());
				fileDAO.create(fileToUpload);
				
				File f = fileDAO.getLastAddedObject();
				fileList.setFile(f);
				fileList.setAddedTime(new Timestamp(System.currentTimeMillis()));
				fileList.setUser(clientData.getClient());
				fListDAO.create(fileList);
				
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Utworzono plik!", null));
				
				fileList = null;
				file = null;
				return PAGE_STAY_AT_THE_SAME;
			}
		}
		
		return null;
	}
	
	public FileList getFileList() {
		return fileList;
	}

	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
}