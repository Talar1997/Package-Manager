package entities;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(name="id_file")
	private int idFile;

	@Column(name="id_package")
	private int idPackage;

	public FileList() {
	}

	public int getIdListFile() {
		return this.idListFile;
	}

	public void setIdListFile(int idListFile) {
		this.idListFile = idListFile;
	}

	public int getIdFile() {
		return this.idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}

	public int getIdPackage() {
		return this.idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

}