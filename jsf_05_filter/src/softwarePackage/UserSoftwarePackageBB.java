package softwarePackage;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.PackageFileDAO;
import dao.SoftwarePackageDAO;
import entities.PackageFile;
import entities.SoftwarePackage;

@Named
@RequestScoped
public class UserSoftwarePackageBB {
	private List<SoftwarePackage> softwarePackageList;

	@Inject
	SoftwarePackageDAO softPackDAO;
	
	@Inject
	PackageFileDAO pfDAO;
	
	@Inject
	ClientData clientData;
	
	
	@PostConstruct
    public void init() {
		softwarePackageList = softPackDAO.getAddedBy(clientData.getClient());

		if(!softwarePackageList.isEmpty()) {
			for(SoftwarePackage s : softwarePackageList) {
				List<PackageFile> packageFile = pfDAO.findWhere(s.getIdPackage());
				if(!packageFile.isEmpty()) {
					for(PackageFile p : packageFile) {
						s.getFilesInPackage().add(p.getFileList());
					}
				}
			}
		}
   
    }
	

	public List<SoftwarePackage> getSoftwarePackageList() {
		return softwarePackageList;
	}

	public void setSoftwarePackageList(List<SoftwarePackage> softwarePackageList) {
		this.softwarePackageList = softwarePackageList;
	}
	
	
	
	
}