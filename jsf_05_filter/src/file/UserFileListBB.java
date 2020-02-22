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