package org.myconf.dao;

import org.myconf.Globals;
import org.myconf.beans.ConfigBean;
import org.myconf.util.StringUtils;

/**
 * 系统设置对应的数据库接口
 * 设置的id需进行手工维护
 * @author libin
 */
public class ConfigDAO extends DAO {
	
	private static ConfigBean curConf = null; //当前网站的系统设置

	/**
	 * 创建系统设置
	 * @param conf
	 */
	public static void createConfig(ConfigBean conf){
		if(conf==null)
			return;
		save(conf);
	}
	
	/**
	 * 更新系统设置
	 * @param conf
	 */
	public static void updateConfig(ConfigBean conf){
		flush();
	}
	
	/**
	 * 根据编号获取系统设置信息
	 * @param sid
	 * @return
	 */
	public static ConfigBean getConfigByID(int sid){
		if(sid<1)
			return null;
		return (ConfigBean)getBean(ConfigBean.class, sid);
	}
	
	/**
	 * 根据编号获取当前系统设置信息
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
	 * 获得能上传的稿件文件格式列表
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
