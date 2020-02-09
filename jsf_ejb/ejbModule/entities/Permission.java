package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permission")
	private int idPermission;

	@Column(name="add_licence")
	private byte addLicence;

	@Column(name="create_package")
	private byte createPackage;

	@Column(name="create_user")
	private byte createUser;

	@Column(name="delete_file")
	private byte deleteFile;

	@Column(name="delete_package")
	private byte deletePackage;

	@Column(name="download_file")
	private byte downloadFile;

	@Column(name="get_licence")
	private byte getLicence;

	@Column(name="set_permission")
	private byte setPermission;

	@Column(name="upload_file")
	private byte uploadFile;

	@Column(name="view_logs")
	private byte viewLogs;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="permission")
	private List<Role> roles;

	public Permission() {
	}

	public int getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(byte idPermission) {
		this.idPermission = idPermission;
	}

	public byte getAddLicence() {
		return this.addLicence;
	}

	public void setAddLicence(byte addLicence) {
		this.addLicence = addLicence;
	}

	public byte getCreatePackage() {
		return this.createPackage;
	}

	public void setCreatePackage(byte createPackage) {
		this.createPackage = createPackage;
	}

	public byte getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(byte createUser) {
		this.createUser = createUser;
	}

	public byte getDeleteFile() {
		return this.deleteFile;
	}

	public void setDeleteFile(byte deleteFile) {
		this.deleteFile = deleteFile;
	}

	public byte getDeletePackage() {
		return this.deletePackage;
	}

	public void setDeletePackage(byte deletePackage) {
		this.deletePackage = deletePackage;
	}

	public byte getDownloadFile() {
		return this.downloadFile;
	}

	public void setDownloadFile(byte downloadFile) {
		this.downloadFile = downloadFile;
	}

	public byte getGetLicence() {
		return this.getLicence;
	}

	public void setGetLicence(byte getLicence) {
		this.getLicence = getLicence;
	}

	public byte getSetPermission() {
		return this.setPermission;
	}

	public void setSetPermission(byte setPermission) {
		this.setPermission = setPermission;
	}

	public byte getUploadFile() {
		return this.uploadFile;
	}

	public void setUploadFile(byte uploadFile) {
		this.uploadFile = uploadFile;
	}

	public byte getViewLogs() {
		return this.viewLogs;
	}

	public void setViewLogs(byte viewLogs) {
		this.viewLogs = viewLogs;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setPermission(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setPermission(null);

		return role;
	}

}