package softwarePackage;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfcourse.login.ClientData;

import dao.SoftwarePackageDAO;
import entities.SoftwarePackage;

@Named
@RequestScoped
public class SoftwarePackageDeleteBB {
	
	@Inject
	SoftwarePackageDAO softPackDAO;
	
	@Inject
	ClientData clientData;
	
	public void delete(SoftwarePackage softwarePackage) {
		softwarePackage = softPackDAO.find(softwarePackage.getIdPackage());
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(clientData.getClient().getRole().getPermission().getDeletePackage() >= 1) {
			softPackDAO.remove(softwarePackage);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Pomyślnie usunięto paczkę.", null));
		}
		else {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie posiadasz uprawnień do tej operacji.", null));
		}
	}
}