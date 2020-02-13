package softwarePackage;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SoftwarePackageDAO;
import entities.SoftwarePackage;

@Named
@RequestScoped
public class SoftwarePackageBB {
	private List<SoftwarePackage> softwarePackageList;

	@Inject
	SoftwarePackageDAO softPackDAO;
	
	
	@PostConstruct
    public void init() {
        
    }
	
	public int countPackages() {
		return softPackDAO.countPackages();
	}
}