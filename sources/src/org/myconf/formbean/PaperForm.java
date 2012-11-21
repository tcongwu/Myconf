package org.myconf.formbean;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.myconf.beans.AuthorBean;
import org.myconf.beans.PaperBean;
import org.myconf.beans.SubjectBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.SubjectDAO;
import org.myconf.util.CharsetChecker;
import org.myconf.util.StringUtils;

/**
 * �����
 * @author libin
 */
public class PaperForm extends FormBean {
	
	final static Log log = LogFactory.getLog(PaperForm.class);
	
	protected String title;	//����
	protected int subject;	//��������
	protected String abstr;	//ժҪ
	protected int status;		//����¼��״̬
	
	protected int asum;		//��������
	protected String authorFirstName1;	//��һ���ߵ���
	protected String authorLastName1;	//��һ���ߵ���
	protected String authorEmail1;		//��һ���ߵ�email
	protected String authorInstitute1;	//��һ���ߵĵ�λ
	protected String authorFirstName2;	//�ڶ����ߵ���
	protected String authorLastName2;	//�ڶ����ߵ���
	protected String authorEmail2;		//�ڶ����ߵ�email
	protected String authorInstitute2;	//�ڶ����ߵĵ�λ
	protected String authorFirstName3;	//�������ߵ���
	protected String authorLastName3;	//�������ߵ���
	protected String authorEmail3;		//�������ߵ�email
	protected String authorInstitute3;	//�������ߵĵ�λ
	protected String authorFirstName4;	//�������ߵ���
	protected String authorLastName4;	//�������ߵ���
	protected String authorEmail4;		//�������ߵ�email
	protected String authorInstitute4;	//�������ߵĵ�λ
	protected String authorFirstName5;	//�������ߵ���
	protected String authorLastName5;	//�������ߵ���
	protected String authorEmail5;		//�������ߵ�email
	protected String authorInstitute5;	//�������ߵĵ�λ
	protected String authorFirstName6;	//�������ߵ���
	protected String authorLastName6;	//�������ߵ���
	protected String authorEmail6;		//�������ߵ�email
	protected String authorInstitute6;	//�������ߵĵ�λ
	protected String authorFirstName7;	//�������ߵ���
	protected String authorLastName7;	//�������ߵ���
	protected String authorEmail7;		//�������ߵ�email
	protected String authorInstitute7;	//�������ߵĵ�λ
	protected String authorFirstName8;	//�ڰ����ߵ���
	protected String authorLastName8;	//�ڰ����ߵ���
	protected String authorEmail8;		//�ڰ����ߵ�email
	protected String authorInstitute8;	//�ڰ����ߵĵ�λ
	protected String authorFirstName9;	//�ھ����ߵ���
	protected String authorLastName9;	//�ھ����ߵ���
	protected String authorEmail9;		//�ھ����ߵ�email
	protected String authorInstitute9;	//�ھ����ߵĵ�λ
	protected String authorFirstName10;	//��ʮ���ߵ���
	protected String authorLastName10;	//��ʮ���ߵ���
	protected String authorEmail10;		//��ʮ���ߵ�email
	protected String authorInstitute10;	//��ʮ���ߵĵ�λ
	protected String authorFirstName11;	//��ʮһ���ߵ���
	protected String authorLastName11;	//��ʮһ���ߵ���
	protected String authorEmail11;		//��ʮһ���ߵ�email
	protected String authorInstitute11;	//��ʮһ���ߵĵ�λ
	protected String authorFirstName12;	//��ʮ�����ߵ���
	protected String authorLastName12;	//��ʮ�����ߵ���
	protected String authorEmail12;		//��ʮ�����ߵ�email
	protected String authorInstitute12;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName13;	//��ʮ�����ߵ���
	protected String authorLastName13;	//��ʮ�����ߵ���
	protected String authorEmail13;		//��ʮ�����ߵ�email
	protected String authorInstitute13;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName14;	//��ʮ�����ߵ���
	protected String authorLastName14;	//��ʮ�����ߵ���
	protected String authorEmail14;		//��ʮ�����ߵ�email
	protected String authorInstitute14;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName15;	//��ʮ�����ߵ���
	protected String authorLastName15;	//��ʮ�����ߵ���
	protected String authorEmail15;		//��ʮ�����ߵ�email
	protected String authorInstitute15;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName16;	//��ʮ�����ߵ���
	protected String authorLastName16;	//��ʮ�����ߵ���
	protected String authorEmail16;		//��ʮ�����ߵ�email
	protected String authorInstitute16;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName17;	//��ʮ�����ߵ���
	protected String authorLastName17;	//��ʮ�����ߵ���
	protected String authorEmail17;		//��ʮ�����ߵ�email
	protected String authorInstitute17;	//��ʮ�����ߵĵ�λ
	protected String authorFirstName18;	//��ʮ�����ߵ���
	protected String authorLastName18;	//��ʮ�����ߵ���
	protected String authorEmail18;		//��ʮ�����ߵ�email
	protected String authorInstitute18;	//��ʮ�����ߵĵ�λ
	
	protected String ctitle;	//�ƺ�
	protected String firstName;	//��
	protected String lastName;	//��
	protected String workLocation;	//������λ
	protected String research;	//�о�����
	protected String phone;		//�绰
	protected String fax;		//����
	protected String address;	//��ϸ��ַ
	protected String state;	//�����ݻ�ʡ��
	protected String country;	//���ڹ���
	protected String postcode;	//��������
	
	protected int[] expertId;		//ר��ID�б�
	
	protected FormFile pfile;	//����ļ�

	public String getTitle() {
		return title;
	}

	public void setTitle(String str) {
		this.title = str;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int it) {
		this.subject = it;
	}

	public String getAbstr() {
		return abstr;
	}

	public void setAbstr(String str) {
		this.abstr = str;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public int getAsum() {
		return asum;
	}

	public void setAsum(int it) {
		this.asum = it;
	}

	public String getAuthorFirstName1() {
		return authorFirstName1;
	}

	public void setAuthorFirstName1(String str) {
		this.authorFirstName1 = str;
	}

	public String getAuthorLastName1() {
		return authorLastName1;
	}

	public void setAuthorLastName1(String str) {
		this.authorLastName1 = str;
	}

	public String getAuthorEmail1() {
		return authorEmail1;
	}

	public void setAuthorEmail1(String str) {
		this.authorEmail1 = str;
	}

	public String getAuthorInstitute1() {
		return authorInstitute1;
	}

	public void setAuthorInstitute1(String str) {
		this.authorInstitute1 = str;
	}

	public String getAuthorFirstName2() {
		return authorFirstName2;
	}

	public void setAuthorFirstName2(String str) {
		this.authorFirstName2 = str;
	}

	public String getAuthorLastName2() {
		return authorLastName2;
	}

	public void setAuthorLastName2(String str) {
		this.authorLastName2 = str;
	}

	public String getAuthorEmail2() {
		return authorEmail2;
	}

	public void setAuthorEmail2(String str) {
		this.authorEmail2 = str;
	}

	public String getAuthorInstitute2() {
		return authorInstitute2;
	}

	public void setAuthorInstitute2(String str) {
		this.authorInstitute2 = str;
	}

	public String getAuthorFirstName3() {
		return authorFirstName3;
	}

	public void setAuthorFirstName3(String str) {
		this.authorFirstName3 = str;
	}

	public String getAuthorLastName3() {
		return authorLastName3;
	}

	public void setAuthorLastName3(String str) {
		this.authorLastName3 = str;
	}

	public String getAuthorEmail3() {
		return authorEmail3;
	}

	public void setAuthorEmail3(String str) {
		this.authorEmail3 = str;
	}

	public String getAuthorInstitute3() {
		return authorInstitute3;
	}

	public void setAuthorInstitute3(String str) {
		this.authorInstitute3 = str;
	}

	public String getAuthorFirstName4() {
		return authorFirstName4;
	}

	public void setAuthorFirstName4(String str) {
		this.authorFirstName4 = str;
	}

	public String getAuthorLastName4() {
		return authorLastName4;
	}

	public void setAuthorLastName4(String str) {
		this.authorLastName4 = str;
	}

	public String getAuthorEmail4() {
		return authorEmail4;
	}

	public void setAuthorEmail4(String str) {
		this.authorEmail4 = str;
	}

	public String getAuthorInstitute4() {
		return authorInstitute4;
	}

	public void setAuthorInstitute4(String str) {
		this.authorInstitute4 = str;
	}

	public String getAuthorFirstName5() {
		return authorFirstName5;
	}

	public void setAuthorFirstName5(String str) {
		this.authorFirstName5 = str;
	}

	public String getAuthorLastName5() {
		return authorLastName5;
	}

	public void setAuthorLastName5(String str) {
		this.authorLastName5 = str;
	}

	public String getAuthorEmail5() {
		return authorEmail5;
	}

	public void setAuthorEmail5(String str) {
		this.authorEmail5 = str;
	}

	public String getAuthorInstitute5() {
		return authorInstitute5;
	}

	public void setAuthorInstitute5(String str) {
		this.authorInstitute5 = str;
	}

	public String getAuthorFirstName6() {
		return authorFirstName6;
	}

	public void setAuthorFirstName6(String str) {
		this.authorFirstName6 = str;
	}

	public String getAuthorLastName6() {
		return authorLastName6;
	}

	public void setAuthorLastName6(String str) {
		this.authorLastName6 = str;
	}

	public String getAuthorEmail6() {
		return authorEmail6;
	}

	public void setAuthorEmail6(String str) {
		this.authorEmail6 = str;
	}

	public String getAuthorInstitute6() {
		return authorInstitute6;
	}

	public void setAuthorInstitute6(String str) {
		this.authorInstitute6 = str;
	}

	public String getAuthorFirstName7() {
		return authorFirstName7;
	}

	public void setAuthorFirstName7(String str) {
		this.authorFirstName7 = str;
	}

	public String getAuthorLastName7() {
		return authorLastName7;
	}

	public void setAuthorLastName7(String str) {
		this.authorLastName7 = str;
	}

	public String getAuthorEmail7() {
		return authorEmail7;
	}

	public void setAuthorEmail7(String str) {
		this.authorEmail7 = str;
	}

	public String getAuthorInstitute7() {
		return authorInstitute7;
	}

	public void setAuthorInstitute7(String str) {
		this.authorInstitute7 = str;
	}

	public String getAuthorFirstName8() {
		return authorFirstName8;
	}

	public void setAuthorFirstName8(String str) {
		this.authorFirstName8 = str;
	}

	public String getAuthorLastName8() {
		return authorLastName8;
	}

	public void setAuthorLastName8(String str) {
		this.authorLastName8 = str;
	}

	public String getAuthorEmail8() {
		return authorEmail8;
	}

	public void setAuthorEmail8(String str) {
		this.authorEmail8 = str;
	}

	public String getAuthorInstitute8() {
		return authorInstitute8;
	}

	public void setAuthorInstitute8(String str) {
		this.authorInstitute8 = str;
	}

	public String getAuthorFirstName9() {
		return authorFirstName9;
	}

	public void setAuthorFirstName9(String str) {
		this.authorFirstName9 = str;
	}

	public String getAuthorLastName9() {
		return authorLastName9;
	}

	public void setAuthorLastName9(String str) {
		this.authorLastName9 = str;
	}

	public String getAuthorEmail9() {
		return authorEmail9;
	}

	public void setAuthorEmail9(String str) {
		this.authorEmail9 = str;
	}

	public String getAuthorInstitute9() {
		return authorInstitute9;
	}

	public void setAuthorInstitute9(String str) {
		this.authorInstitute9 = str;
	}

	public String getAuthorFirstName10() {
		return authorFirstName10;
	}

	public void setAuthorFirstName10(String str) {
		this.authorFirstName10 = str;
	}

	public String getAuthorLastName10() {
		return authorLastName10;
	}

	public void setAuthorLastName10(String str) {
		this.authorLastName10 = str;
	}

	public String getAuthorEmail10() {
		return authorEmail10;
	}

	public void setAuthorEmail10(String str) {
		this.authorEmail10 = str;
	}

	public String getAuthorInstitute10() {
		return authorInstitute10;
	}

	public void setAuthorInstitute10(String str) {
		this.authorInstitute10 = str;
	}

	public String getAuthorFirstName11() {
		return authorFirstName11;
	}

	public void setAuthorFirstName11(String str) {
		this.authorFirstName11 = str;
	}

	public String getAuthorLastName11() {
		return authorLastName11;
	}

	public void setAuthorLastName11(String str) {
		this.authorLastName11 = str;
	}

	public String getAuthorEmail11() {
		return authorEmail11;
	}

	public void setAuthorEmail11(String str) {
		this.authorEmail11 = str;
	}

	public String getAuthorInstitute11() {
		return authorInstitute11;
	}

	public void setAuthorInstitute11(String str) {
		this.authorInstitute11 = str;
	}

	public String getAuthorFirstName12() {
		return authorFirstName12;
	}

	public void setAuthorFirstName12(String str) {
		this.authorFirstName12 = str;
	}

	public String getAuthorLastName12() {
		return authorLastName12;
	}

	public void setAuthorLastName12(String str) {
		this.authorLastName12 = str;
	}

	public String getAuthorEmail12() {
		return authorEmail12;
	}

	public void setAuthorEmail12(String str) {
		this.authorEmail12 = str;
	}

	public String getAuthorInstitute12() {
		return authorInstitute12;
	}

	public void setAuthorInstitute12(String str) {
		this.authorInstitute12 = str;
	}

	public String getAuthorFirstName13() {
		return authorFirstName13;
	}

	public void setAuthorFirstName13(String str) {
		this.authorFirstName13 = str;
	}

	public String getAuthorLastName13() {
		return authorLastName13;
	}

	public void setAuthorLastName13(String str) {
		this.authorLastName13 = str;
	}

	public String getAuthorEmail13() {
		return authorEmail13;
	}

	public void setAuthorEmail13(String str) {
		this.authorEmail13 = str;
	}

	public String getAuthorInstitute13() {
		return authorInstitute13;
	}

	public void setAuthorInstitute13(String str) {
		this.authorInstitute13 = str;
	}

	public String getAuthorFirstName14() {
		return authorFirstName14;
	}

	public void setAuthorFirstName14(String str) {
		this.authorFirstName14 = str;
	}

	public String getAuthorLastName14() {
		return authorLastName14;
	}

	public void setAuthorLastName14(String str) {
		this.authorLastName14 = str;
	}

	public String getAuthorEmail14() {
		return authorEmail14;
	}

	public void setAuthorEmail14(String str) {
		this.authorEmail14 = str;
	}

	public String getAuthorInstitute14() {
		return authorInstitute14;
	}

	public void setAuthorInstitute14(String str) {
		this.authorInstitute14 = str;
	}

	public String getAuthorFirstName15() {
		return authorFirstName15;
	}

	public void setAuthorFirstName15(String str) {
		this.authorFirstName15 = str;
	}

	public String getAuthorLastName15() {
		return authorLastName15;
	}

	public void setAuthorLastName15(String str) {
		this.authorLastName15 = str;
	}

	public String getAuthorEmail15() {
		return authorEmail15;
	}

	public void setAuthorEmail15(String str) {
		this.authorEmail15 = str;
	}

	public String getAuthorInstitute15() {
		return authorInstitute15;
	}

	public void setAuthorInstitute15(String str) {
		this.authorInstitute15 = str;
	}

	public String getAuthorFirstName16() {
		return authorFirstName16;
	}

	public void setAuthorFirstName16(String str) {
		this.authorFirstName16 = str;
	}

	public String getAuthorLastName16() {
		return authorLastName16;
	}

	public void setAuthorLastName16(String str) {
		this.authorLastName16 = str;
	}

	public String getAuthorEmail16() {
		return authorEmail16;
	}

	public void setAuthorEmail16(String str) {
		this.authorEmail16 = str;
	}

	public String getAuthorInstitute16() {
		return authorInstitute16;
	}

	public void setAuthorInstitute16(String str) {
		this.authorInstitute16 = str;
	}

	public String getAuthorFirstName17() {
		return authorFirstName17;
	}

	public void setAuthorFirstName17(String str) {
		this.authorFirstName17 = str;
	}

	public String getAuthorLastName17() {
		return authorLastName17;
	}

	public void setAuthorLastName17(String str) {
		this.authorLastName17 = str;
	}

	public String getAuthorEmail17() {
		return authorEmail17;
	}

	public void setAuthorEmail17(String str) {
		this.authorEmail17 = str;
	}

	public String getAuthorInstitute17() {
		return authorInstitute17;
	}

	public void setAuthorInstitute17(String str) {
		this.authorInstitute17 = str;
	}

	public String getAuthorFirstName18() {
		return authorFirstName18;
	}

	public void setAuthorFirstName18(String str) {
		this.authorFirstName18 = str;
	}

	public String getAuthorLastName18() {
		return authorLastName18;
	}

	public void setAuthorLastName18(String str) {
		this.authorLastName18 = str;
	}

	public String getAuthorEmail18() {
		return authorEmail18;
	}

	public void setAuthorEmail18(String str) {
		this.authorEmail18 = str;
	}

	public String getAuthorInstitute18() {
		return authorInstitute18;
	}

	public void setAuthorInstitute18(String str) {
		this.authorInstitute18 = str;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String str) {
		this.ctitle = str;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String str) {
		this.firstName = str;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String str) {
		this.lastName = str;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String str) {
		this.workLocation = str;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String str) {
		this.research = str;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String str) {
		this.phone = str;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String str) {
		this.fax = str;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String str) {
		this.address = str;
	}

	public String getState() {
		return state;
	}

	public void setState(String str) {
		this.state = str;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String str) {
		this.country = str;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String str) {
		this.postcode = str;
	}

	public int[] getExpertId() {
		return expertId;
	}
	
	public Hashtable getExpertHash(){
		Hashtable ehash=new Hashtable();
		if(expertId!=null && expertId.length>0){
			for(int i=0;i<expertId.length;i++){
				ehash.put(new Integer(expertId[i]), "true");
			}
		}
		return ehash;
	}

	public void setExpertId(int[] exs) {
		this.expertId = exs;
	}
	
	public FormFile getPfile() {
		return pfile;
	}
	
	public void setPfile(FormFile ff) {
		this.pfile = ff;
	}
	
	/**
	 * ��֤��
	 * 
	 * @return �Ƿ���Ч
	 */
	public boolean validateForm(){
		if(StringUtils.isEmpty(this.title)||(this.subject<1)||StringUtils.isEmpty(this.abstr))
			return false;
			
		if(this.asum<1)
			return false;
		try{
			String first=null;
			String last=null;
			for(int i=1;i<=this.asum;i++){
				first=(String)PropertyUtils.getSimpleProperty(this, "authorFirstName"+i);
				last=(String)PropertyUtils.getSimpleProperty(this, "authorLastName"+i);
				if(StringUtils.isEmpty(first)||StringUtils.isEmpty(last))
					return false;
			}
		}catch(Exception e){
			log.error("get property exception, NoSuchMethodException!", e);
			return false;
		}
		
		if(StringUtils.isEmpty(this.firstName)||StringUtils.isEmpty(this.lastName)||StringUtils.isEmpty(this.workLocation)||StringUtils.isEmpty(this.phone)||StringUtils.isEmpty(this.address)||StringUtils.isEmpty(this.country)||StringUtils.isEmpty(this.postcode))
			return false;
		
		return true;
	}
	
	public PaperBean getPaper(boolean isNew){
		PaperBean paper = new PaperBean();
		
		if(!isNew)
			paper.setId(this.getId());
		paper.setTitle(this.title);
		SubjectBean sub = SubjectDAO.getSubject(this.subject);
		if(sub==null)
			return null;
		paper.setSubject(sub);
		paper.setAbstr(this.abstr);
		paper.setAuthorNames(this.getAuthorNames());
		
		return paper;
	}
	
	public List getAuthors(){
		if(this.asum<1)
			return null;
		
		AuthorBean author=null;
		ArrayList authors = new ArrayList();
		try{
			String first=null;
			String last=null;
			for(int i=1;i<=this.asum;i++){
				author = new AuthorBean();
				author.setOrderNo(i);
				author.setFirstName((String)PropertyUtils.getSimpleProperty(this, "authorFirstName"+i));
				author.setLastName((String)PropertyUtils.getSimpleProperty(this, "authorLastName"+i));
				author.setEmail((String)PropertyUtils.getSimpleProperty(this, "authorEmail"+i));
				author.setInstitute((String)PropertyUtils.getSimpleProperty(this, "authorInstitute"+i));
				
				authors.add(author);
			}
		}catch(Exception e){
			log.error("get property exception, NoSuchMethodException!", e);
			return null;
		}
		
		return authors;
	}
	
	public String getAuthorNames(){
		if(this.asum<1)
			return null;
		
		StringBuffer authors = new StringBuffer();
		try{
			String first=null;
			String last=null;
			for(int i=1;i<=this.asum;i++){
				first=(String)PropertyUtils.getSimpleProperty(this, "authorFirstName"+i);
				last=(String)PropertyUtils.getSimpleProperty(this, "authorLastName"+i);
				if(StringUtils.isNotEmpty(first)){
					if(CharsetChecker.isZH(firstName.substring(0,1))){
						authors.append(',');
						authors.append(StringUtils.exportString(last));
						authors.append(first);
					}else{
						authors.append(',');
						authors.append(first);
						authors.append(' ');
						authors.append(StringUtils.exportString(last));
					}
				}
			}
		}catch(Exception e){
			log.error("get property exception, NoSuchMethodException!", e);
			return null;
		}
		
		return authors.toString();
	}
	
	public UserBean getUserInfo(){
		UserBean user = new UserBean();
		
		user.getName().setTitle(this.ctitle);
		user.getName().setFirstName(this.firstName);
		user.getName().setLastName(this.lastName);
		user.setWorkLocation(this.workLocation);
		user.setResearch(this.research);
		user.setPhone(this.phone);
		user.setFax(this.fax);
		user.setAddress(this.address);
		user.setState(this.state);
		user.setCountry(this.country);
		user.setPostcode(this.postcode);
		
		return user;
	}
}
