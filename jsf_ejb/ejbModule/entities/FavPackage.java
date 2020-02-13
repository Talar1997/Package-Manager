package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fav_package database table.
 * 
 */
@Entity
@Table(name="fav_package")
@NamedQuery(name="FavPackage.findAll", query="SELECT f FROM FavPackage f")
public class FavPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fav")
	private int idFav;

	//bi-directional many-to-one association to SoftwarePackage
	@ManyToOne
	@JoinColumn(name="id_package")
	private SoftwarePackage softwarePackage;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public FavPackage() {
	}

	public int getIdFav() {
		return this.idFav;
	}

	public void setIdFav(int idFav) {
		this.idFav = idFav;
	}

	public SoftwarePackage getSoftwarePackage() {
		return this.softwarePackage;
	}

	public void setSoftwarePackage(SoftwarePackage softwarePackage) {
		this.softwarePackage = softwarePackage;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}