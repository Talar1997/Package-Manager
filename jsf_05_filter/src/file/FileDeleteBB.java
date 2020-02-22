package file;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import com.jsfcourse.login.ClientData;

import dao.FileDAO;
import dao.FileListDAO;
import entities.File;
import entities.FileList;

@Named
@RequestScoped
public class FileDeleteBB {
	private List<FileList> allFiles;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/files/list.xhtml";
	private StreamedContent fileToDownload;

	@Inject
	FileListDAO fListDAO;
	
	@Inject
	FileDAO fileDAO;
	
	@Inject
	ClientData clientData;
	
	@PostConstruct
    public void init() {
        
    }
	
	public void delete(FileList fileList) {
		fileList = fListDAO.find(fileList.getIdListFile());
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(clientData.getClient().getRole().getPermission().getDeleteFile() >= 1) {
			File fileToRemove = fileList.getFile();
			fListDAO.remove(fileList);
			fileDAO.remove(fileToRemove);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pomyślnie usunięto plik.", null));
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie posiadasz uprawnień do tej operacji.", null));
		}
	}
	
	

}