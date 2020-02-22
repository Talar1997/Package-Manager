package statistics;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.FileListDAO;
import entities.FileList;

@Named
@RequestScoped
public class FileStatisticsBB {
	private List<FileList> lastAdded;
	private List<FileList> mostPopular;

	@Inject
	FileListDAO fListDAO;
	
	public List<FileList> getLastAdded() {
		lastAdded = fListDAO.getLastAdded();
		return lastAdded;
	}

	public void setLastAdded(List<FileList> lastAdded) {
		this.lastAdded = lastAdded;
	}

	public List<FileList> getMostPopular() {
		mostPopular = fListDAO.getMostPopular();
		return mostPopular;
	}

	public void setMostPopular(List<FileList> mostPopular) {
		this.mostPopular = mostPopular;
	}
	
	public Long countFileLists() {
		return fListDAO.countFileLists();
	}
}
