package com.zzst.action.meeting.util.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfConfig;
import com.zzst.action.meeting.util.tools.Eryptogram;

public class ConfigurationAction  extends CjfAction{
	
	private Map<String,String> map = new HashMap<String,String>();
	private Map<String,String> map1 = new HashMap<String,String>();
	private Map<String,String> mapBak = new HashMap<String,String>();
	public static Logger logger = Logger.getLogger(ConfigurationAction.class.getName());
	public String getConfiguration(){
		logger.info("ConfigurationAction getConfiguration begin");
		try {
			SAXReader reader = new SAXReader();
		    Class runClass = Class.forName("com.zzst.action.meeting.util.configuration.ConfigurationAction");
		    //取到appConfig.xml的Document
			Document p_document = reader.read(runClass.getResourceAsStream("/appConfig.xml"));
			List<Element> initparams = p_document.selectNodes("root/init-param");
			String unEry = "";
			for(int i=0;i<initparams.size();i++){
				Element node = (Element)initparams.get(i);
				String value=node.attributeValue("value");
				if(value.equals("")){
					value=" ";
				}
				String descr=node.attributeValue("descr");
				map.put(node.attributeValue("key"), value+","+descr); //将init-param放入map
			}
			
			List<Element> db_initparams = p_document.selectNodes("root/datasources/datasource");
			
			for(int i=0;i<db_initparams.size();i++){								//将datasource放入map1
				Element node = (Element)db_initparams.get(i);
				map1.put("DB_URL", node.elementText("DB_URL"));
				map1.put("DB_USER", node.elementText("DB_USER"));
				map1.put("DB_PASSWD", node.elementText("DB_PASSWD"));
				map1.put("DB_JNDI", node.elementText("DB_JNDI"));
			}
			
          List<Element> db_initparamsBAK = p_document.selectNodes("root/datasources/datasourceBAK");
			
			for(int i=0;i<db_initparamsBAK.size();i++){								//将datasource放入map1
				Element node = (Element)db_initparamsBAK.get(i);
				mapBak.put("BAK_DB_URL", node.elementText("BAK_DB_URL"));
				mapBak.put("BAK_DB_USER", node.elementText("BAK_DB_USER"));
				mapBak.put("BAK_DB_PASSWD", node.elementText("BAK_DB_PASSWD"));
				mapBak.put("BAK_DB_JNDI", node.elementText("BAK_DB_JNDI"));
				mapBak.put("BAK_IS_OPEN", node.elementText("BAK_IS_OPEN"));
			}
			
			
		} catch (ClassNotFoundException e) {
			logger.error("ConfigurationAction getConfiguration error:ClassNotFoundException");
			e.printStackTrace();
		} catch (DocumentException e) {
			logger.error("ConfigurationAction getConfiguration error:DocumentException");
			e.printStackTrace();
		}
	     logger.info("ConfigurationAction getConfiguration end");
		return SUCCESS;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, String> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}
	
	private void enEry(Element node){
		Eryptogram etg = new Eryptogram();
		String unEry = "";
		if(node.attributeValue("key").equals("ftpUser")){
			unEry = etg.decryptData(node.attributeValue("value"));
			map.put(node.attributeValue("key"), unEry);
		}else if(node.attributeValue("key").equals("ftpPsw")){
			unEry = etg.decryptData(node.attributeValue("value"));
			map.put(node.attributeValue("key"), unEry);
		}else if(node.attributeValue("key").equals("pwdInit")){
			unEry = etg.decryptData(node.attributeValue("value"));
			map.put(node.attributeValue("key"), unEry);
		}else if(node.attributeValue("key").equals("pwdInitAdmin")){
			unEry = etg.decryptData(node.attributeValue("value"));
			map.put(node.attributeValue("key"), unEry);
		}else{
			map.put(node.attributeValue("key"), node.attributeValue("value"));
		}
		if(node.getName().equals("datasource")){
			map1.put("DB_URL", node.elementText("DB_URL"));
			map1.put("DB_USER", node.elementText("DB_USER"));
			map1.put("DB_PASSWD", node.elementText("DB_PASSWD"));
			map1.put("DB_JNDI", node.elementText("DB_JNDI"));
		}
	}

	public void setMapBak(Map<String,String> mapBak) {
		this.mapBak = mapBak;
	}

	public Map<String,String> getMapBak() {
		return mapBak;
	}
}
