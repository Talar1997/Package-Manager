package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the file database table.
 * 
 */
@Entity
@Table(name="file")
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_file")
	private int idFile;

	@Column(name="file_binary")
	private byte[] fileBinary;

	private String filename;

	//bi-directional many-to-one association to FileList
	@OneToMany(mappedBy="file")
	private List<FileList> fileLists;

	public File() {
	}

	public int getIdFile() {
		return this.idFile;
	}

	public void setIdFile(int idFile) {
		this.idFile = idFile;
	}


	public byte[] getFileBinary() {
		return this.fileBinary;
	}

	public void setFileBinary(byte[] fileBinary) {
		this.fileBinary = fileBinary;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<FileList> getFileLists() {
		return this.fileLists;
	}

	public void setFileLists(List<FileList> fileLists) {
		this.fileLists = fileLists;
	}

	public FileList addFileList(FileList fileList) {
		getFileLists().add(fileList);
		fileList.setFile(this);

		return fileList;
	}

	public FileList removeFileList(FileList fileList) {
		getFileLists().remove(fileList);
		fileList.setFile(null);

		return fileList;
	}

}