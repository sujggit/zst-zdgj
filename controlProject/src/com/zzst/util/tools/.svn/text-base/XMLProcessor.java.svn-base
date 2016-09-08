package com.zzst.util.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 *@Description
 *@date 2011-3-17下午04:45:28
 *@author ryan
 */
public class XMLProcessor {
	
	
	/**
	 * 设置节点值
	 * @param document
	 * @param xmlPath
	 * @param leafElementName
	 * @param leafElementValue
	 */
	public static Document setLeafElementValue(Document document,String xmlPath,String leafElementValue){
	    Iterator i = document.selectNodes(xmlPath).iterator();
	    while (i.hasNext()) {
	      Element element = (Element)i.next();
	      element.setText(leafElementValue);
	    }
	    return document;
	}
	
	/**
	 * 提取单个节点值
	 * @param xmlInfo	xml字符串
	 * @param xmlPath	路径
	 */
	public static String getLeafElementValue(String xmlInfo,String xmlPath){
		Document document = getDocumentForString(xmlInfo);
		if(document==null) return null;
		
		Iterator i = document.selectNodes(xmlPath).iterator();
	    while (i.hasNext()) {
	      return ((Element)i.next()).getText();
	    }
	    return null;
	}
	
	/**
	 * 提取单个节点值
	 * @param document	
	 * @param xmlPath
	 * @param leafElementName
	 * @param leafElementValue
	 */
	public static String getLeafElementValue(Document document,String xmlPath){
	    Iterator i = document.selectNodes(xmlPath).iterator();
	    while (i.hasNext()) {
	      return ((Element)i.next()).getText();
	    }
	    return null;
	}
	
	/**
	 * 提取节点下所有的值
	 * @param document
	 * @param xmlPath
	 * @param leafElementName
	 * @param leafElementValue
	 */
	public static ArrayList<String> getLeafElementValues(Document document,String xmlPath){
		ArrayList<String> list =new ArrayList<String>();
		Iterator i = document.selectNodes(xmlPath).iterator();
	    while (i.hasNext()) {
	    	list.add(((Element)i.next()).getText());
	    }
	    return list;
	}
	
	/**
	 * xml文件转为Document对象
	 * @param path
	 * @return
	 */
	public static Document getDocumentForURL(String url){
		 try {
			return new SAXReader().read(new File(url));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转为Document对象
	 * @param xmlContent
	 * @return	String
	 */
	public static	Document	getDocumentForString(String	xmlContent){
		Document document = null;
		try{
			document = DocumentHelper.parseText(xmlContent);
		}catch(Exception e){
			e.printStackTrace();
		}
		return document;
	}
}