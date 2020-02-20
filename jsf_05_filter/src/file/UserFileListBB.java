package file;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.jsfcourse.login.ClientData;

import dao.DownloadListDAO;
import dao.FileListDAO;
import entities.DownloadList;
import entities.File;
import entities.FileList;
import entities.User;

@Named
@RequestScoped
public class UserFileListBB {
	private List<FileList> addedByClient;
	@Inject
	FileListDAO fListDAO;
	
	@Inject
	ClientData clientData;
	
	@Inject
	DownloadListDAO dListDAO;
	
	@PostConstruct
    public void init() {
        addedByClient = fListDAO.getAddedByClient(clientData.getClient().getIdUser());
    }
	

	public List<FileList> getAddedByClient() {
		return addedByClient;
	}

	public void setAddedByClient(List<FileList> addedByClient) {
		this.addedByClient = addedByClient;
	}
}