package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the package_file database table.
 * 
 */
@Entity
@Table(name="package_file")
@NamedQuery(name="PackageFile.findAll", query="SELECT p FROM PackageFile p")
public class PackageFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_package_file")
	private int idPackageFile;

	//bi-directional many-to-one association to SoftwarePackage
	@ManyToOne
	@JoinColumn(name="id_package")
	private SoftwarePackage softwarePackage;

	//bi-directional many-to-one association to FileList
	@ManyToOne
	@JoinColumn(name="id_file_list")
	private FileList fileList;

	public PackageFile() {
	}

	public int getIdPackageFile() {
		return this.idPackageFile;
	}

	public void setIdPackageFile(int idPackageFile) {
		this.idPackageFile = idPackageFile;
	}

	public SoftwarePackage getSoftwarePackage() {
		return this.softwarePackage;
	}

	public void setSoftwarePackage(SoftwarePackage softwarePackage) {
		this.softwarePackage = softwarePackage;
	}

	public FileList getFileList() {
		return this.fileList;
	}

	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}

}