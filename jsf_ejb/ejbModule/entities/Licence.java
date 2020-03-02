package entities;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the licence database table.
 * 
 */
@Entity
@Table(name="licence")
@NamedQuery(name="Licence.findAll", query="SELECT l FROM Licence l")
public class Licence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_licence")
	private int idLicence;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="added_date")
	private Date addedDate;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Column(name="in_use")
	private byte inUse;

	@Column(name="licence_key")
	private String licenceKey;

	//bi-directional many-to-one association to FileList
	@ManyToOne
	@JoinColumn(name="id_file_list")
	private FileList fileList;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_added_by")
	private User user;

	public Licence() {
	}

	public int getIdLicence() {
		return this.idLicence;
	}

	public void setIdLicence(int idLicence) {
		this.idLicence = idLicence;
	}

	public Date getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public byte getInUse() {
		return this.inUse;
	}

	public void setInUse(byte inUse) {
		this.inUse = inUse;
	}

	public String getLicenceKey() {
		return this.licenceKey;
	}

	public void setLicenceKey(String licenceKey) {
		this.licenceKey = licenceKey;
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