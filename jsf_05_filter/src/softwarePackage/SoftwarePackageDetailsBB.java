package softwarePackage;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.PackageFileDAO;
import dao.SoftwarePackageDAO;
import entities.PackageFile;
import entities.SoftwarePackage;

@Named("softwarePackageDetailsBB")
@SessionScoped
public class SoftwarePackageDetailsBB implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE_PROFILE = "/public/package_profile.xhtml?faces-redirect=true";
	private SoftwarePackage profile;
	
	@Inject
	SoftwarePackageDAO softPackDAO;
	
	@Inject
	PackageFileDAO pfDAO;
	
	public String show(SoftwarePackage softwarePackage) {
		
		if(softwarePackage != null) {
			profile = softwarePackage;
			List<PackageFile> packageFile = pfDAO.findWhere(profile.getIdPackage());
			if(!packageFile.isEmpty()) {
				for(PackageFile p : packageFile) {
					profile.getFilesInPackage().add(p.getFileList());
				}
			}
			
			return PACKAGE_PROFILE;
		}
		return null;
	}

	public SoftwarePackage getProfile() {
		return profile;
	}

	public void setProfile(SoftwarePackage profile) {
		this.profile = profile;
	}
	
}