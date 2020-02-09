package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the file_list database table.
 * 
 */
@Entity
@Table(name="file_list")
@NamedQuery(name="FileList.findAll", query="SELECT f FROM FileList f")
public class FileList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_list_file")
	private int idListFile;

	@Column(name="added_time")
	private Timestamp addedTime;

	private String description;

	@Column(name="download_counter")
	private int downloadCounter;

	@Column(name="id_uploader")
	private int idUploader;

	private String name;

	private String version;

	//bi-directional many-to-one association to File
	@ManyToOne
	@JoinColumn(name="id_file")
	private File file;

	//bi-directional many-to-one association to Licence
	@ManyToOne
	@JoinColumn(name="id_licence")
	private Licence licence;

	//bi-directional many-to-one association to Licence
	@OneToMany(mappedBy="fileList")
	private List<Licence> licences;

	//bi-directional many-to-one association to SoftwarePackage
	@OneToMany(mappedBy="fileList")
	private List<SoftwarePackage> softwarePackages;

	public FileList() {
	}

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

	public int getIdUploader() {
		return this.idUploader;
	}

	public void setIdUploader(int idUploader) {
		this.idUploader = idUploader;
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

	public Licence getLicence() {
		return this.licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	public List<Licence> getLicences() {
		return this.licences;
	}

	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}

	public Licence addLicence(Licence licence) {
		getLicences().add(licence);
		licence.setFileList(this);

		return licence;
	}

	public Licence removeLicence(Licence licence) {
		getLicences().remove(licence);
		licence.setFileList(null);

		return licence;
	}

	public List<SoftwarePackage> getSoftwarePackages() {
		return this.softwarePackages;
	}

	public void setSoftwarePackages(List<SoftwarePackage> softwarePackages) {
		this.softwarePackages = softwarePackages;
	}

	public SoftwarePackage addSoftwarePackage(SoftwarePackage softwarePackage) {
		getSoftwarePackages().add(softwarePackage);
		softwarePackage.setFileList(this);

		return softwarePackage;
	}

	public SoftwarePackage removeSoftwarePackage(SoftwarePackage softwarePackage) {
		getSoftwarePackages().remove(softwarePackage);
		softwarePackage.setFileList(null);

		return softwarePackage;
	}

}