package softwarePackage;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SoftwarePackageDAO;
import entities.SoftwarePackage;

@Named("softwarePackageLastAddedBB")
@RequestScoped
public class SoftwarePackageLastAddedBB implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<SoftwarePackage> lastAdded;
	
	@Inject
	SoftwarePackageDAO softPackDAO;
	
	@PostConstruct
    public void init() {
		lastAdded = softPackDAO.getLastAdded();
	}
	
	public List<SoftwarePackage> getLastAdded() {
		return lastAdded;
	}

	public void setLastAdded(List<SoftwarePackage> lastAdded) {
		this.lastAdded = lastAdded;
	}
	
}