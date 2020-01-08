package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
@NamedQuery(name="Package.findAll", query="SELECT p FROM Package p")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_package")
	private int idPackage;

	@Column(name="cretion_time")
	private Timestamp cretionTime;

	private String description;

	@Column(name="id_file_list")
	private int idFileList;

	@Column(name="id_user")
	private int idUser;

	private String name;

	public Package() {
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

	public int getIdFileList() {
		return this.idFileList;
	}

	public void setIdFileList(int idFileList) {
		this.idFileList = idFileList;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}