package softwarePackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.jsfcourse.login.ClientData;

import dao.FileListDAO;
import dao.PackageFileDAO;
import dao.SoftwarePackageDAO;
import entities.FileList;
import entities.SoftwarePackage;
import entities.PackageFile;

@Named("softwarePackageCreateBB")
@ViewScoped
public class SoftwarePackageCreateBB implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/packages/create.xhtml";
	private List<FileList> source = new ArrayList<FileList>();;
	private List<FileList> target = new ArrayList<FileList>();
	private DualListModel<FileList> files;
	private SoftwarePackage softPackage;
	
	@Inject
	FileListDAO fListDAO;
	
	@Inject
	SoftwarePackageDAO spDAO;
	
	@Inject
	PackageFileDAO pfDAO;
	
	@Inject 
	ClientData clientData;
	
	@PostConstruct
	public void init() {
		softPackage = new SoftwarePackage();
		source = fListDAO.findAll();
		
		for(FileList f : source) {
			f.setFile(null);
		}
		
		files = new DualListModel<FileList>(source, target);
	}
	
	public String create() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		target = files.getTarget();
		if(target.isEmpty()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Paczka musi zawierać conajmniej jeden plik!", null));
		}
		
		softPackage.setUser(clientData.getClient());
		spDAO.create(softPackage);
		softPackage = spDAO.getLastAddedObject();

		for(Object o : files.getTarget()) {
			PackageFile packageFile = new PackageFile();
			packageFile.setSoftwarePackage(softPackage);
			FileList fileList = fListDAO.find(Integer.parseInt(o.toString()));
			packageFile.setFileList(fileList);
			pfDAO.create(packageFile);
		}
		
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Pomyślnie utworzono nową paczkę", null));
		
		return PAGE_STAY_AT_THE_SAME;
	}

	public List<FileList> getSource() {
		return source;
	}

	public void setSource(List<FileList> source) {
		this.source = source;
	}

	public List<FileList> getTarget() {
		return target;
	}

	public void setTarget(List<FileList> target) {
		this.target = target;
	}

	public DualListModel<FileList> getFiles() {
		return files;
	}

	public void setFiles(DualListModel<FileList> files) {
		this.files = files;
	}

	public SoftwarePackage getSoftPackage() {
		return softPackage;
	}

	public void setSoftPackage(SoftwarePackage softPackage) {
		this.softPackage = softPackage;
	}
	
	
}