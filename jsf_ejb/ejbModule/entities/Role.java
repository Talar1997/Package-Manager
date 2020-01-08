package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permission_list database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_role")
	private int idRole;

	private String description;

	@Column(name="id_permission")
	private int idPermission;

	private String name;

	public Role() {
	}

	public int getIdPermList() {
		return this.idRole;
	}

	public void setIdPermList(int idRole) {
		this.idRole = idRole;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}