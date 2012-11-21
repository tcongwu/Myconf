package org.myconf.dao;

import org.myconf.Globals;
import org.myconf.beans.ConfigBean;
import org.myconf.util.StringUtils;

/**
 * ϵͳ���ö�Ӧ�����ݿ�ӿ�
 * ���õ�id������ֹ�ά��
 * @author libin
 */
public class ConfigDAO extends DAO {
	
	private static ConfigBean curConf = null; //��ǰ��վ��ϵͳ����

	/**
	 * ����ϵͳ����
	 * @param conf
	 */
	public static void createConfig(ConfigBean conf){
		if(conf==null)
			return;
		save(conf);
	}
	
	/**
	 * ����ϵͳ����
	 * @param conf
	 */
	public static void updateConfig(ConfigBean conf){
		flush();
	}
	
	/**
	 * ���ݱ�Ż�ȡϵͳ������Ϣ
	 * @param sid
	 * @return
	 */
	public static ConfigBean getConfigByID(int sid){
		if(sid<1)
			return null;
		return (ConfigBean)getBean(ConfigBean.class, sid);
	}
	
	/**
	 * ���ݱ�Ż�ȡ��ǰϵͳ������Ϣ
	 * @param sid
	 * @return
	 */
	public static ConfigBean getCurrentConfig(int sid){
		if(curConf == null)
			curConf = getConfigByID(sid);
		return curConf;
	}
	
	public static void setCurrentConfig(ConfigBean conf){
		curConf=conf;
	}
	
	/**
	 * ������ϴ��ĸ���ļ���ʽ�б�
	 * @param sid
	 * @return
	 */
	public static String[] getFileTypes(int sid){
		if(curConf == null)
			curConf = getConfigByID(sid);
			
		if((curConf==null)||StringUtils.isEmpty(curConf.getSubFormat())){
			return new String[]{"doc", "pdf"};
		}else{
			return curConf.getSubFormat().split(Globals.SPLIT);
		}
	}

}
