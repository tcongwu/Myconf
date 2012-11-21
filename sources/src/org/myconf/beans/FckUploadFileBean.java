
package org.myconf.beans;
import java.util.Date;
/**
 * 通过FCKEditor编辑器文件的上传信息
 *
 * 
 */
public class FckUploadFileBean  {
	
		public final static int FILE_TYPE_UNKNOWN = 0x00;
		public final static int FILE_TYPE_IMAGE = 0x01;
		public final static int FILE_TYPE_FLASH = 0x02;
		public final static int FILE_TYPE_FILE = 0x03;
		private String sessionId;
		private String savePath;
		private String uri;
		private int fileType;
		private int fileSize;
		private Date uploadTime;
		private UserBean user;

		public UserBean getUser() {
		return user;
		}

		public void setUser(UserBean user) {
		this.user = user;
		}

		public int getUserId() {
			return user.getId();
		}
	
		public int getFileType() {
			return fileType;
		}
		public void setFileType(int fileType) {
			this.fileType = fileType;
		}
		public String getSavePath() {
			return savePath;
		}
		public void setSavePath(String savePath) {
			this.savePath = savePath;
		}
		public String getSessionId() {
			return sessionId;
		}
		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
		public Date getUploadTime() {
			return uploadTime;
		}
		public void setUploadTime(Date uploadTime) {
			this.uploadTime = uploadTime;
		}
		public int getFileSize() {
			return fileSize;
		}
		public void setFileSize(int fileSize) {
			this.fileSize = fileSize;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
	/**
	 * 对象所属的某一网站内容
	 */
	private ContentBean siteContent;

	public ContentBean getSiteContent() {
		return siteContent;
	}

	public void setSiteContent(ContentBean siteContent) {
		this.siteContent = siteContent;
	}
	
}
