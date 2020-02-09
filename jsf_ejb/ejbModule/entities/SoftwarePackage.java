package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the software_package database table.
 * 
 */
@Entity
@Table(name="software_package")
@NamedQuery(name="SoftwarePackage.findAll", query="SELECT s FROM SoftwarePackage s")
public class SoftwarePackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_package")
	private int idPackage;

	@Column(name="cretion_time")
	private Timestamp cretionTime;

	private String description;

	private String name;

	//bi-directional many-to-one association to FileList
	@ManyToOne
	@JoinColumn(name="id_file_list")
	private FileList fileList;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public SoftwarePackage() {
	}

	public int getIdPackage() {
		return this.idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public Timestamp getCretionTime() {
		return this.cretionTime;
	}

	public void setCretionTime(Timestamp cretionTime) {
		this.cretionTime = cretionTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileList getFileList() {
		return this.fileList;
	}

	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}