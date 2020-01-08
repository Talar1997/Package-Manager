package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the file database table.
 * 
 */
@Entity
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_file")
	private int idFile;

	@Column(name="added_time")
	private Timestamp addedTime;

	private String description;

	@Column(name="download_couter")
	private int downloadCouter;

	@Lob
	@Column(name="file_binary")
	private byte[] fileBinary;

	private String filename;

	private String icon;

	private String version;

	public File() {
	}

	public int getIdFile() {
		return this.idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
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

	public int getDownloadCouter() {
		return this.downloadCouter;
	}

	public void setDownloadCouter(int downloadCouter) {
		this.downloadCouter = downloadCouter;
	}

	public byte[] getFileBinary() {
		return this.fileBinary;
	}

	public void setFileBinary(byte[] fileBinary) {
		this.fileBinary = fileBinary;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}