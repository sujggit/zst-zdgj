package com.zzst.action.project.webservices.examinepush;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
/**
 * 解析xml文件，按要求提取指定节点value
 * @author chenlu
 *
 */
public class TranslateXml {
	private static final Logger log = LogManager.getLogger(TranslateXml.class);
	@SuppressWarnings("unchecked")
	public static String getValue(String xmlString,String nodeName){
		Document doc = null;		//xml文件
		Element root = null;		//根节点
		String namespace = null;	//命名空间
		Element nameEle =null ;
		try {
			doc = DocumentHelper.parseText(xmlString);  //从xmlString读取xml信息
			root = doc.getRootElement();				//获取根节点
			namespace = root.getNamespaceURI();			//获取根节点命名空间
		} catch (DocumentException e) {
			log.error("xml解析异常,请核查传入xml是否规范！！！");
			return null;
		}
		Map map = new HashMap(); 					
		map.put("TJ", namespace);
		XPath x = doc.createXPath("//TJ:"+nodeName);
		x.setNamespaceURIs(map);
		List nodelist = x.selectNodes(doc);
		if (nodelist == null || nodelist.size() == 0) {
			return null;
		}
		nameEle = (Element) nodelist.get(0);
		String name = nameEle.getTextTrim();
		return name ;
	}
	
	
	public static String getValue(String xmlString,String nodeName,int index){
		Document doc = null;		//xml文件
		Element root = null;		//根节点
		String namespace = null;	//命名空间
		Element nameEle =null ;
		try {
			doc = DocumentHelper.parseText(xmlString);  //从xmlString读取xml信息
			root = doc.getRootElement();				//获取根节点
			namespace = root.getNamespaceURI();			//获取根节点命名空间
		} catch (DocumentException e) {
			log.error("xml解析异常,请核查传入xml是否规范！！！");
			return null;
		}
		Map map = new HashMap(); 					
		map.put("TJ", namespace);
		XPath x = doc.createXPath("//TJ:"+nodeName);
		x.setNamespaceURIs(map);
		List nodelist = x.selectNodes(doc);
		if (nodelist == null || nodelist.size() == 0) {
			return null;
		}
		nameEle = (Element) nodelist.get(index);
		String name = nameEle.getTextTrim();
		return name ;
	}
	
	/**
	 * 获得指定节点的值的集合
	 * @param xmlString
	 * @param node
	 * @param nodeNext
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getElementList(String xmlString ,String node,String nodeNext){
		
		List list = new ArrayList();
		Element ele = null;
		try{
			Document doc = DocumentHelper.parseText(xmlString);//字符串转换成xml
			Element root = doc.getRootElement();//获取根节点
			Iterator nodeIter = root.elementIterator(node);//获得指定的节点
			while(nodeIter.hasNext()){
				Element element = (Element)nodeIter.next();
				Iterator item = element.elementIterator(nodeNext); //获得nodeNext节点集合
				
				List modelList = null;
				while(item.hasNext()){
					Element itemElement = (Element)item.next();
					List eleList = itemElement.elements();
					
					modelList = new ArrayList();
					for(int i=0;i<eleList.size();i++){			//遍历并把值存储到map中
						ele =(Element) eleList.get(i);
						modelList.add(ele.getTextTrim());
					}
					list.add(modelList);
				}
			}
		}catch (DocumentException e){
			log.error("xml解析异常,请核查传入xml是否规范！！！", e);
		}
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<?> getElementList(String xml ,String node,String node2,String node3){
		Document doc = null;
		Element root = null;
		List list = new ArrayList();
		
		try {
			doc = DocumentHelper.parseText(xml);
			System.out.println(doc.asXML()) ;
			root = doc.getRootElement();
		} catch (DocumentException e) {
			return null;
		}
		
		//node指定节点  一级几点
		Iterator rows = root.elementIterator(node);
		while(rows.hasNext()){
			Element row = (Element)rows.next();
			//node2指定的节点  二级几点
			Iterator resultUnits = row.elementIterator(node2);
			if(resultUnits!=null){
				while(resultUnits.hasNext()){
					Element resultUnit = (Element)resultUnits.next();
					//node3 指定的节点  终节点
					Iterator metas = resultUnit.elementIterator(node3);
					if(metas!=null){
						while(metas.hasNext()){
							Element meta = (Element)metas.next();
							List eleList = meta.elements();
							List modelList = new ArrayList();
							for(int i=0;i<eleList.size();i++){			//遍历并把值存储到map中
								Element ele =(Element) eleList.get(i);
								modelList.add(ele.getTextTrim());
							}
							list.add(modelList);
						}
					}
				}
			}
		}
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<?> getElementList(String xml ,String node,String node2,String node3,String node4){
		Document doc = null;
		Element root = null;
		List list = new ArrayList();
		
		try {
			System.out.println(xml) ;
			
			doc = DocumentHelper.parseText(xml);
			//root = doc.getRootElement();
		} catch (DocumentException e) {
			return null;
		}
		
		//node指定节点  一级几点
		Iterator rows = doc.selectNodes(node).iterator();
		while(rows.hasNext()){
			Element row = (Element)rows.next();
			//node2指定的节点  二级几点
			Iterator resultUnits = doc.selectNodes(node2).iterator();
			if(resultUnits!=null){
				while(resultUnits.hasNext()){
					Element resultUnit = (Element)resultUnits.next();
					//node3 指定的节点  终节点
					Iterator  nodeResults = doc.selectNodes(node3).iterator();
					if(nodeResults!=null){
						while(nodeResults.hasNext()){
							Element nodeResult = (Element)nodeResults.next();
							Iterator metas = doc.selectNodes(node4).iterator();
							if(metas!=null){
								while(metas.hasNext()){
									Element meta = (Element)metas.next();
									List eleList = meta.elements();
									List modelList = new ArrayList();
									for(int i=0;i<eleList.size();i++){			//遍历并把值存储到map中
										Element ele =(Element) eleList.get(i);
										if(ele.getTextTrim().length()==0) continue;
										modelList.add(ele.getTextTrim());
									}
									if(modelList.size()!=0)
									list.add(modelList);
								}
							}
							
						}
					}
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		StringBuffer  xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<publishData>");
		
		xml.append("<head>");
		xml.append("<DictDataIdentification>").append("LHLMMDM001").append("</DictDataIdentification>");
		xml.append("</head>");
		
		xml.append("<orgRegisterSet>");
		xml.append("<orgRegister>");
		
		xml.append("<orgCode>").append("1111").append("</orgCode>");
		xml.append("<orgName>").append("2222").append("</orgName>");
		xml.append("<orgRepInfo>");
		xml.append("<orgCode>").append("1").append("</orgCode>");
		xml.append("<repDate>").append("2").append("</repDate>");
		xml.append("</orgRepInfo>");
		
		xml.append("</orgRegister>");
		xml.append("</orgRegisterSet>");
		xml.append("</publishData>");
		
		String node = "orgRegisterSet";
		String node2 = "orgRegister";
		String node3 = "orgRepInfo";
		
		System.out.println(xml.toString());
		
		String flag = TranslateXml.getValue(xml.toString(), "111");
		
		System.out.println(flag);
		
//		
//		List list = TranslateXml.getElementMap(xml.toString(), node, node2, node3);
//		List list2 = TranslateXml.getElementMap(xml.toString(),node,node2);
//		
//		System.out.println(list2);
		
//		if(list!=null){
//			Map<String,String> map = (Map<String,String> ) list.get(0);
//			
//			System.out.println(map.isEmpty());
//			System.out.println(map.get("orgCode"));
//		}
//		if(list2!=null){
//			System.out.println("-------------------------------------");
//			Map<String,String> map = (Map<String,String> ) list2.get(0);
//			System.out.println(map.isEmpty());
//			System.out.println(map.get("orgCode"));
//		}
	}
	
	
	
	
	/**
	 * 获得指定节点的值的集合
	 * @param xmlString
	 * @param node
	 * @param nodeNext
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List getElementMap(String xmlString ,String node,String nodeNext){
		
		List list = new ArrayList();
		Element ele = null;
		try{
			Document doc = DocumentHelper.parseText(xmlString);//字符串转换成xml
			Element root = doc.getRootElement();//获取根节点
			Iterator nodeIter = root.elementIterator(node);//获得指定的节点
			while(nodeIter.hasNext()){
				Element element = (Element)nodeIter.next();
				Iterator item = element.elementIterator(nodeNext); //获得nodeNext节点集合
				
				while(item.hasNext()){
					Element itemElement = (Element)item.next();
					List eleList = itemElement.elements();
					
					Map<String,String> map = new HashMap<String,String>();
					for(int i=0;i<eleList.size();i++){			//遍历并把值存储到map中
						ele =(Element) eleList.get(i);
						map.put(ele.getName(), ele.getTextTrim());
					}
					list.add(map);
				}
			}
		}catch (DocumentException e){
			log.error("xml解析异常,请核查传入xml是否规范！！！", e);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<?> getElementMap(String xml ,String node,String node2,String node3){
		Document doc = null;
		Element root = null;
		List list = new ArrayList();

		try {
			System.out.println(xml) ;
			
			doc = DocumentHelper.parseText(xml);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			return null;
		}
		
		//node指定节点  一级几点
		Iterator rows = root.elementIterator(node);
		while(rows.hasNext()){
			Element row = (Element)rows.next();
			//node2指定的节点  二级几点
			Iterator resultUnits = row.elementIterator(node2);
			if(resultUnits!=null){
				while(resultUnits.hasNext()){
					Element resultUnit = (Element)resultUnits.next();
					//node3 指定的节点  终节点
					Iterator  metas = resultUnit.elementIterator(node3);
					if(metas!=null){
						while(metas.hasNext()){
							Element meta = (Element)metas.next();
							List eleList = meta.elements();
							//List modelList = new ArrayList();
							Map<String,String> map = new HashMap<String,String>();
							for(int i=0;i<eleList.size();i++){			//遍历并把值存储到map中
								Element ele =(Element) eleList.get(i);
								//modelList.add(ele.getTextTrim());
								map.put(ele.getName(), ele.getTextTrim());
							}
							list.add(map);
						}
					}
				}
			}
		}
		return list;
	}
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void xmlToBean(Object bean,Map<String,String> map){
		
		if(map!=null && bean!=null){
			Method beanMethod = null;
			Object obj = null;
			try {
				Field field[] = bean.getClass().getDeclaredFields();
				for(int i=0;i<field.length;i++){
					Field property = field[i];
					if(!property.getName().equals("serialVersionUID")){
						beanMethod = bean.getClass().getMethod("set"+upperString(property.getName()), new Class[] {property.getType()});
						String value = map.get(property.getName());
						if(value!=null && !"".equals(value)){
							if(property.getType().getName().equals("java.util.Date")){
								obj  = format.parse(value.toString().length()<=10? value.toString()+" 00:00:00":value.toString());
							}else if(property.getType().getName().equals("java.lang.Long")){
								obj = new Long(value.toString());
							}else if(property.getType().getName().equals("java.lang.Integer")){
								obj = new Integer(value.toString());
							}else if(property.getType().getName().equals("java.lang.Double")){
								obj = new Double(value.toString());
							}else{
								obj = value.toString();
							}
							beanMethod.invoke(bean,new Object[]{obj});
						}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String upperString(String str){
		String temp = str;
		return String.valueOf(temp.charAt(0)).toUpperCase()+str.substring(1,str.length());

	}
}
