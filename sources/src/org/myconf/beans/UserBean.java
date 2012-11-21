package org.myconf.beans;

import java.sql.Timestamp;
import java.util.List;

import jxl.Cell;

import org.myconf.SessionUserObject;
import org.myconf.beans.base.NameInfo;
import org.myconf.util.StringUtils;

/**
 * ע���û�����
 * @author libin
 */
public class UserBean extends SessionUserObject {	

	public final static int CELL_EMAIL = 0;	  //email
	public final static int CELL_PASSWORD = 1;	//����
	public final static int CELL_TITLE = 2;	//�ƺ�
	public final static int CELL_FIRSTNAME = 3;	//��
	public final static int CELL_LASTNAME = 4;	  //��
	public final static int CELL_WORKSTATION = 5;	//������λ
	public final static int CELL_RESEARCH = 6;	//�о�����
	public final static int CELL_PHONE = 7;	//�绰
	public final static int CELL_FAX = 8;	  //����
	public final static int CELL_ADDRESS = 9;	//��ϸ��ַ
	public final static int CELL_STATE = 10;	//����ʡ��
	public final static int CELL_COUNTRY = 11;	//���ڹ���
	public final static int CELL_POSTCODE = 12;	  //��������

	public final static int ROLE_ADMIN = 1;	  //ϵͳ����Ա
	public final static int ROLE_AUTHOR = 2;	//����
	public final static int ROLE_EXPERT = 3;	//ר��
	public final static int ROLE_CONTENT = 4;	//��վ����Ա

	protected transient String password;	//��¼����
	protected int onlineStatus;
	
	protected List papers;	//�û��ύ�ĸ��
	protected List reviews;	//�û�����ĸ��
	
	public UserBean(){}
	
	public UserBean(int userid){
		super.setId(userid);
	}
	
	/**
	 * ��excel�������е�����ת����UserBean
	 * @param cells һ������
	 * @return
	 */
	public static UserBean convertToBean(Cell[] cells){
		if(cells==null || cells.length<=0){
			return null;
		}
		UserBean user=new UserBean();
		NameInfo name=new NameInfo();
		if(cells.length>UserBean.CELL_EMAIL)
			user.setEmail(cells[UserBean.CELL_EMAIL].getContents());
			
		if(cells.length>UserBean.CELL_PASSWORD)
			user.setPassword(cells[UserBean.CELL_PASSWORD].getContents());
			
		if(cells.length>UserBean.CELL_TITLE)
			name.setTitle(cells[UserBean.CELL_TITLE].getContents());
		
		if(cells.length>UserBean.CELL_FIRSTNAME)
			name.setFirstName(cells[UserBean.CELL_FIRSTNAME].getContents());
		
		if(cells.length>UserBean.CELL_LASTNAME)
			name.setLastName(cells[UserBean.CELL_LASTNAME].getContents());
		
		user.setName(name);
		
		if(cells.length>UserBean.CELL_WORKSTATION)
			user.setWorkLocation(cells[UserBean.CELL_WORKSTATION].getContents());
		
		if(cells.length>UserBean.CELL_RESEARCH)
			user.setResearch(cells[UserBean.CELL_RESEARCH].getContents());
		
		if(cells.length>UserBean.CELL_PHONE)
			user.setPhone(cells[UserBean.CELL_PHONE].getContents());
		
		if(cells.length>UserBean.CELL_FAX)
			user.setFax(cells[UserBean.CELL_FAX].getContents());
		
		if(cells.length>UserBean.CELL_ADDRESS)
			user.setAddress(cells[UserBean.CELL_ADDRESS].getContents());
		
		if(cells.length>UserBean.CELL_STATE)
			user.setState(cells[UserBean.CELL_STATE].getContents());
		
		if(cells.length>UserBean.CELL_COUNTRY)
			user.setCountry(cells[UserBean.CELL_COUNTRY].getContents());
		
		if(cells.length>UserBean.CELL_POSTCODE)
			user.setPostcode(cells[UserBean.CELL_POSTCODE].getContents());
		
		return user;
	}

	/**
	 * ��VO�����и���һ�����ݣ���¡
	 * @param bean
	 * @return
	 */
	public static UserBean copyFrom(SessionUserObject bean){
		if(bean==null)
			return null;
		
		UserBean user = new UserBean();

		user.setId(bean.getId());
		
		user.setEmail(bean.getEmail());
		
		if(bean.getName()!=null)
			user.setName((NameInfo)bean.getName().clone());
		
		user.setWorkLocation(bean.getWorkLocation());
		user.setResearch(bean.getResearch());
		user.setPhone(bean.getPhone());
		user.setFax(bean.getFax());
		user.setAddress(bean.getAddress());
		user.setPostcode(bean.getPostcode());
		user.setState(bean.getState());
		user.setCountry(bean.getCountry());
		
		user.setIsAdmin(bean.getIsAdmin());
		user.setIsAuthor(bean.getIsAuthor());
		user.setIsContent(bean.getIsContent());
		user.setIsExpert(bean.getIsExpert());
		
		user.setRole(bean.getRole());
		user.setStatus(bean.getStatus());
		
		user.setLoginCount(bean.getLoginCount());
		if(bean.getRegTime()!=null)
			user.setRegTime(new Timestamp(bean.getRegTime().getTime()));
		if(bean.getLastTime()!=null)
			user.setLastTime(new Timestamp(bean.getLastTime().getTime()));
		user.setLastAddr(bean.getLastAddr());

		return user;
	}
	
	public List getPapers() {
		return papers;
	}

	public void setPapers(List papers) {
		this.papers = papers;
	}
	
	public List getReviews() {
		return reviews;
	}

	public void setReviews(List rws) {
		this.reviews = rws;
	}

	public String getCryptPassword() {
		if(password == null)
			return null;
	    return StringUtils.encryptPassword(password);
	}
	
	public void setCryptPassword(String pwd) {
		if(pwd!=null)
			password = StringUtils.decryptPassword(pwd);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

}
