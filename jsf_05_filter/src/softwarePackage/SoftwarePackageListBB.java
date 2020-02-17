package softwarePackage;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SoftwarePackageDAO;
import entities.FileList;
import entities.SoftwarePackage;

@Named
@RequestScoped
public class SoftwarePackageListBB {
	private List<SoftwarePackage> softwarePackageList;
	private List<SoftwarePackage> lastAdded;

	@Inject
	SoftwarePackageDAO softPackDAO;
	
	
	@PostConstruct
    public void init() {
		lastAdded = softPackDAO.getLastAdded();
        
    }
	
	public int countPackages() {
		return softPackDAO.countPackages();
	}
	
	public List<SoftwarePackage> getLastAdded() {
		return lastAdded;
	}

	public void setLastAdded(List<SoftwarePackage> lastAdded) {
		this.lastAdded = lastAdded;
	}
	
	
}