package entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l ORDER BY l.idLog DESC")
@NamedQuery(name="Log.findSecurityBreach", query="SELECT l FROM Log l WHERE l.type LIKE 'Login error' ORDER BY l.idLog DESC")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_log")
	private int idLog;

	private Timestamp timestamp;

	private String type;

	private String value;

	public Log() {
	}
	
	public Log(String type, String value) {
		this.setType(type);
		this.setValue(value);
		this.setTimestamp(new Timestamp(System.currentTimeMillis()));
	}

	public int getIdLog() {
		return this.idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}