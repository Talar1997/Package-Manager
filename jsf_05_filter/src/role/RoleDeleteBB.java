package role;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.PermissionDAO;
import dao.RoleDAO;
import entities.Role;

@Named
@RequestScoped
public class RoleDeleteBB {
	private Role role = new Role();

	@Inject
	RoleDAO roleDAO;
	@Inject 
	PermissionDAO permissionDAO;
	
	public String delete(Role role) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(role == null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie wybrano roli z listy", null));
			return null;
		}
		
		if(role.getIdRole() == 1) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nie mozna usunąć roli sysadmina!", null));
			return null;
		}

		return null;
	}
	
}
