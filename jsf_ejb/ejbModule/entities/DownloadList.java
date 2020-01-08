package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the download_list database table.
 * 
 */
@Entity
@Table(name="download_list")
@NamedQuery(name="DownloadList.findAll", query="SELECT d FROM DownloadList d")
public class DownloadList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_download")
	private int idDownload;

	private Timestamp timestamp;

	public DownloadList() {
	}

	public int getIdDownload() {
		return this.idDownload;
	}

	public void setIdDownload(int idDownload) {
		this.idDownload = idDownload;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}