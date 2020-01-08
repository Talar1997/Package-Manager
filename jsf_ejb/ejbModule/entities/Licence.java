package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the licence database table.
 * 
 */
@Entity
@NamedQuery(name="Licence.findAll", query="SELECT l FROM Licence l")
public class Licence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_licence")
	private int idLicence;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="added_date")
	private Date addedDate;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_date")
	private Date expirationDate;

	@Column(name="id_added_by")
	private int idAddedBy;

	@Column(name="id_file_list")
	private int idFileList;

	@Column(name="in_use")
	private byte inUse;

	@Column(name="licence_key")
	private String licenceKey;

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

	public int getIdAddedBy() {
		return this.idAddedBy;
	}

	public void setIdAddedBy(int idAddedBy) {
		this.idAddedBy = idAddedBy;
	}

	public int getIdFileList() {
		return this.idFileList;
	}

	public void setIdFileList(int idFileList) {
		this.idFileList = idFileList;
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

}