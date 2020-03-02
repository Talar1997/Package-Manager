package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the file_list database table.
 * 
 */
@Entity
@Table(name="file_list")
@NamedQuery(name="FileList.findAll", query="SELECT new FileList(f.idListFile, f.addedTime, f.description, f.downloadCounter, f.user, f.name, f.version"
		+ ") FROM FileList f")
@NamedQuery(name="FileList.countFileList", query="SELECT COUNT(f.idListFile) FROM FileList f")
@NamedQuery(name="FileList.getLastAdded", 
	query="SELECT new FileList(f.idListFile, f.addedTime, f.description, f.downloadCounter, f.user, f.name, f.version"
			+ ") FROM FileList f ORDER BY f.addedTime DESC")
@NamedQuery(name="FileList.showMostPopular", query="SELECT new FileList(f.idListFile, f.addedTime, f.description, f.downloadCounter, f.user, f.name, f.version"
		+ ") FROM FileList f ORDER BY f.downloadCounter DESC")
public class FileList implements Serializable {
	private static final long serialVersionUID = 1L;

	public FileList() {
	}
	
	public FileList(int idListFile, Timestamp addedTime, String description, int downloadCounter, User user,
			String name, String version, File file) {
		this.idListFile = idListFile;
		this.addedTime =  new Timestamp(addedTime.getTime());
		this.description = description;
		this.downloadCounter = downloadCounter;
		if(user != null || user.getUsername() != null) {
			this.user = user;
		}
		else {
			User newUser = new User();
			newUser.setName("N/A");
			this.user = newUser;
		}
		this.name = name;
		this.version = version;
		this.file = file;
	}

	public FileList(int idListFile, Date addedTime, String description, int downloadCounter, User user,
			String name, String version) {
		this.idListFile = idListFile;
		this.addedTime =  new Timestamp(addedTime.getTime());
		this.description = description;
		this.downloadCounter = downloadCounter;
		
		if(user != null || user.getUsername() != null) {
			this.user = user;
		}
		else {
			User newUser = new User();
			newUser.setName("N/A");
			this.user = newUser;
		}
		
		this.name = name;
		this.version = version;
	}


	@Id
	@Column(name="id_list_file")
	private int idListFile;

	@Column(name="added_time")
	private Timestamp addedTime;

	private String description;

	@Column(name="download_counter")
	private int downloadCounter;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_uploader")
	private User user;

	private String name;

	private String version;

	//bi-directional many-to-one association to File
	@ManyToOne
	@JoinColumn(name="id_file")
	private File file;

	public int getIdListFile() {
		return this.idListFile;
	}

	public void setIdListFile(int idListFile) {
		this.idListFile = idListFile;
	}

	public Timestamp getAddedTime() {
		return this.addedTime;
	}

	public void setAddedTime(Timestamp addedTime) {
		this.addedTime = addedTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDownloadCounter() {
		return this.downloadCounter;
	}

	public void setDownloadCounter(int downloadCounter) {
		this.downloadCounter = downloadCounter;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}