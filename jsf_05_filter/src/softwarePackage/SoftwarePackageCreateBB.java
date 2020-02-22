package softwarePackage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

import dao.FileListDAO;
import entities.FileList;

@Named
@RequestScoped
public class SoftwarePackageCreateBB {
	private static final String PAGE_STAY_AT_THE_SAME = "/pages/packages/create.xhtml";
	private List<FileList> source;
	private List<FileList> target = new ArrayList<FileList>();
	private DualListModel<FileList> files;
	
	@Inject
	FileListDAO fListDAO;
	
	@PostConstruct
	public void init() {
		source = fListDAO.findAll();
		files = new DualListModel<FileList>(source, target);
	}
	
	public String create() {
		
		
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
}