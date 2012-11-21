package org.myconf.beans.base;

import java.io.Serializable;

import org.myconf.util.CharsetChecker;
import org.myconf.util.StringUtils;

/**
 * �û���������Ϣ
 * @author libin
 */
public class NameInfo implements Serializable {

	protected String title;		//�ƺ�
	protected String firstName;	//��
	protected String lastName;		//��
	
	public Object clone(){
		NameInfo obj = new NameInfo();
		obj.setTitle(title);
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		return obj;
	}
	
	public String toString(){
		if(StringUtils.isEmpty(firstName)){
			return "----";
		}else if(CharsetChecker.isZH(firstName.substring(0,1))){
			return StringUtils.exportString(lastName)+firstName;
		}else{
			return firstName+' '+StringUtils.exportString(lastName);
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String str) {
		this.title = str;
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
}
