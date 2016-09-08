package com.zzst.kst.org.tempuri.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class XmlParser {
	
	private static List<GroupsModel> glist=new ArrayList<GroupsModel>();;
	
	 public static void main(String args[])
     throws DocumentException
 {
     XmlParser test = new XmlParser();
     String path = "d:/a.xml";
     // 读取XML文件
     SAXReader reader = new SAXReader();
     Document doc = reader.read(path);
     // 获取XML根元素
     Element root = doc.getRootElement();
     getElementList(root);
     for(GroupsModel g:glist){
    	 System.out.println(g.getName()+"===="+g.getType());
     }
 }
	public static String parseXml(String text,String key){
	
			try {
				String keyvalue="";
				Document document = DocumentHelper.parseText(text);;
				Element root = document.getRootElement();
				  for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
				  Element element = (Element) i.next();
				  if(key.equals(element.getName())){keyvalue=element.getData().toString();}
				 }
				return keyvalue;
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			return "";
		
	}
	public static List<GroupsModel> getgoups(String text){
		List<GroupsModel> list=new ArrayList<GroupsModel>();
		try {
			Document document = DocumentHelper.parseText(text);
			Element root = document.getRootElement();
			getElementList(root);
			list=glist;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	
	  public static void getElementList(Element e)
	    {
	        List elements = e.elements();
	        if(e.attributeValue("id")!=null){
	        GroupsModel g=new GroupsModel(e.attributeValue("id"),e.attributeValue("name"),e.attributeValue("type"),e.getParent().attributeValue("id"));
            glist.add(g);
	        }
	        if (!elements.isEmpty())	        
	        {
	            // 有子元素
	            Iterator it = elements.iterator();
	            while (it.hasNext())
	            {
	                Element elem = (Element)it.next();
	                // 递归遍历 
	                getElementList(elem);
	            }
	        }
	    }
	  
	
	public static List<CamerasModel> getcameras(String text){
		List<CamerasModel> list=new ArrayList<CamerasModel>();
		try {
			Document document = DocumentHelper.parseText(text);
			Element root = document.getRootElement();
			Iterator i = root.elementIterator();
			while(i.hasNext()){
			Element e = (Element) i.next();
			CamerasModel c=new CamerasModel(e.attributeValue("id"),e.attributeValue("name"),e.attributeValue("groupname"),e.attributeValue("domainid"));
			list.add(c);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}