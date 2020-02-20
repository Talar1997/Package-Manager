package file;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
import entities.FileList;

@Named
@RequestScoped
public class FileDownloadBB {
	private StreamedContent fileToDownload;
	
	@Inject
	FileListDAO fListDAO;
	
	@Inject
	DownloadListDAO dListDAO;
	
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
}