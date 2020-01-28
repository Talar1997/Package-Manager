package log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import entities.Log;
import dao.LogDAO;

@Named
@ViewScoped
public class LogsBB extends LazyDataModel<Log> implements Serializable {
	private static final long serialVersionUID = 1L;
	private LazyDataModel<Log> model;
	private List<Log> securityBreachLogs;

	@Inject
	LogDAO logDAO;
	
	@PostConstruct
    public void init() {
        this.setSecurityBreachLogs(logDAO.getSecurityBreachLogs());
        model = new LazyDataModel<Log>() {
			@Override
		    public List<Log> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filterMeta){
		        List<Log> data = new ArrayList<Log>();
		        data = logDAO.getLazyLogs(first, pageSize);
		 
		        //rowCount - could be outside the load function
		        int dataSize = logDAO.countLogs();
		        this.setRowCount(dataSize);
		        
		        return data;
			}
		};
    }
	
	
    public LazyDataModel<Log> getModel() {
        return model;
    }

	public List<Log> getSecurityBreachLogs() {
		return securityBreachLogs;
	}

	public void setSecurityBreachLogs(List<Log> securityBreachLogs) {
		this.securityBreachLogs = securityBreachLogs;
	}
	
	
}
