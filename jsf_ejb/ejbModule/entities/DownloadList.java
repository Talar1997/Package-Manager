package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;


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

	private LocalDate timestamp;

	public DownloadList() {
	}

	public int getIdDownload() {
		return this.idDownload;
	}

	public void setIdDownload(int idDownload) {
		this.idDownload = idDownload;
	}

	public LocalDate getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

}