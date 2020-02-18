package entities;

import java.io.Serializable;
import javax.persistence.*;

import entities.FavPackage;
import entities.FileList;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQuery(name="User.countUsers", query="SELECT count(u) FROM User u")
@NamedQuery(name="User.getLastRegistered", 
	query="SELECT u FROM User u ORDER BY u.timestampCreated DESC")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	private String email;

	private String name;

	private String password;

	private String surname;

	@Column(name="timestamp_created")
	private Timestamp timestampCreated;

	private String username;

	//bi-directional many-to-one association to Licence
	@OneToMany(mappedBy="user")
	private List<Licence> licences;

	//bi-directional many-to-one association to SoftwarePackage
	@OneToMany(mappedBy="user")
	private List<SoftwarePackage> softwarePackages;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_permission")
	private Role role;
	
	//bi-directional many-to-one association to FavPackage
	@OneToMany(mappedBy="user")
	private List<FavPackage> favPackages;

	//bi-directional many-to-one association to FileList
	@OneToMany(mappedBy="user")
	private List<FileList> fileLists;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Timestamp getTimestampCreated() {
		return this.timestampCreated;
	}

	public void setTimestampCreated(Timestamp timestampCreated) {
		this.timestampCreated = timestampCreated;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Licence> getLicences() {
		return this.licences;
	}

	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}

	public Licence addLicence(Licence licence) {
		getLicences().add(licence);
		licence.setUser(this);

		return licence;
	}

	public Licence removeLicence(Licence licence) {
		getLicences().remove(licence);
		licence.setUser(null);

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
		softwarePackage.setUser(this);

		return softwarePackage;
	}

	public SoftwarePackage removeSoftwarePackage(SoftwarePackage softwarePackage) {
		getSoftwarePackages().remove(softwarePackage);
		softwarePackage.setUser(null);

		return softwarePackage;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<FavPackage> getFavPackages() {
		return this.favPackages;
	}

	public void setFavPackages(List<FavPackage> favPackages) {
		this.favPackages = favPackages;
	}

	public FavPackage addFavPackage(FavPackage favPackage) {
		getFavPackages().add(favPackage);
		favPackage.setUser(this);

		return favPackage;
	}

	public FavPackage removeFavPackage(FavPackage favPackage) {
		getFavPackages().remove(favPackage);
		favPackage.setUser(null);

		return favPackage;
	}

}