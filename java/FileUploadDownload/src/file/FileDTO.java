package file;

public class FileDTO {

	String fileName; //���ε�(�ٿ�ε�)�� ������ �����̸�
	String fileRealName; //���ε�(�ٿ�ε�)�� ������ �����̸�
	int downloadCount;//�ٿ�ε��� Ƚ��
	
	
	public FileDTO() {
	}
	
	public FileDTO(String fileName, String fileRealName, int downloadCount) {
		this.fileName = fileName;
		this.fileRealName = fileRealName;
		this.downloadCount = downloadCount;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRealName() {
		return fileRealName;
	}
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

		
}
