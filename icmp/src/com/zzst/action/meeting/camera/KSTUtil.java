/**
 * 
 */
package com.zzst.action.meeting.camera;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Attribute;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.camera.Presets.Node;
import com.zzst.model.meeting.kst.Camera;
import com.zzst.model.meeting.kst.GroupsOut;
import com.zzst.model.meeting.kst.GroupsOut.Group;
import com.zzst.util.tools.XMLProcessor;


/**
 * 可视通接口
 * @author zhangliang
 * Dec 22, 2011 9:53:04 AM
 */
public class KSTUtil {
	private static Logger logger = CjfLogger.getLogger(KSTUtil.class.getName());
	
	/**
	 * 调用电视墙
	 * @param url
	 * @return
	 */
	public static boolean exectWallPreset(String url)
	{ 
		String result = getresponse(url);
		logger.info("控制电视墙数据URL:"+url);
		logger.info("控制电视墙数据返回:"+result);
		if(result==null||result.length()==0) return false;
		
        try {
        	 if(result.indexOf("<return>1</return>")>0)
        		 return true;
        	 else
        		 return false;
		} catch (Exception e) {
			logger.error("解析电视墙返回数据异常:"+e.getMessage());
			return false;
		}
	}
	
	/**
	 * 提取电视墙数据
	 * @param url
	 * @return
	 */
	public static Presets getallWallPreset(String url)
	{ 
		Presets root = new Presets();
		String result = getresponse(url);
		logger.info("提取电视墙数据URL:"+url);
//		logger.info("提取电视墙数据返回:"+result);
//		result = "<?xml version='1.0' encoding='utf-8'?><presets><node presetid='1' presetname='河南油库'>111111</node><node presetid='2' presetname='郑州加油站' >22222</node></presets>";
		if(result==null||result.length()==0) return root;
		
        try {
        	Digester digester = new Digester();
		    digester.setValidating(false);
		    digester.addObjectCreate("presets",Presets.class);
		    digester.addSetProperties("presets");
		    
			digester.addObjectCreate("presets/node",Presets.Node.class);
			digester.addSetProperties("presets/node");
		    digester.addSetNext("presets/node", "setDataList");
		    
		    ByteArrayInputStream bis = new ByteArrayInputStream(result.getBytes("UTF-8"));
		
		    root =(Presets)digester.parse(bis);
		    logger.info("dateList : "+root.getDataList().size());
		} catch (Exception e) {
			logger.error("解析电视墙返回数据异常:"+e.getMessage());
		}
		return root;
	}
	
	/**
	 * 根据系统ID查询所有group 动态解析
	 * @param url
	 * @return ArrayList
	 */
	public static ArrayList<Group> getallgroups(String url)
	{ 
		ArrayList<Group> grouplist = new ArrayList<Group>();
		String result = getresponse(url);
		logger.info("提取省公司数据URL:"+url);
//		logger.info("提取省公司数据返回:"+result);
		
        try {
			Digester digester = new Digester();
	        digester.setValidating(false);
	        digester.addObjectCreate("groups",GroupsOut.class);
	
	    	digester.addObjectCreate("groups/group",GroupsOut.Group.class);
	        digester.addSetProperties("groups/group");
	       
	        
	        digester.addObjectCreate("groups/group/group", GroupsOut.Group.SubGroup.class);
	        digester.addSetProperties("groups/group/group");
	        
	
	        digester.addSetNext("groups/group/group", "addgroup");
	        digester.addSetNext("groups/group", "add");
	        
	        ByteArrayInputStream bis = new ByteArrayInputStream(result.getBytes("UTF-8"));
	
			GroupsOut root =(GroupsOut)digester.parse(bis);
			logger.info("dateList : "+root.getDataList().size());
			grouplist.addAll(root.getDataList());
		} catch (Exception e) {
			logger.error("解析省公司返回数据异常:"+e.getMessage());
		}
		return grouplist;
	}
	
	
    /**
     * 查询分组下所有摄像头
     * @param url
     * @return ArrayList<Camera>
     */
	public static ArrayList<Camera> getCamerasbyGroupID(String url,String groupid)
	{
		ArrayList<Camera> cameralist = new ArrayList<Camera>();
		String result = getresponse(url);
		
		logger.info("调用可视通接口提取本组摄像头："+url);
//		logger.info("调用可视通接口返回值："+result);
		Document d=  XMLProcessor.getDocumentForString(result);
		ArrayList<Map> reslist = getLeafElementValues(d, "/cameras");
		if(reslist !=null&& reslist.size() >0 )
		{
			for(int i=0; i<reslist.size(); i++)
			{
				Map tmp =  reslist.get(i);
				Camera camera = new Camera();
				
				camera.setCameraid((String) tmp.get("id"));
				camera.setCameraname((String) tmp.get("name"));
				camera.setGroupname((String) tmp.get("groupname"));
				camera.setDomainid((String) tmp.get("domainid"));
				camera.setGroupid(groupid);
				cameralist.add(camera);				
			}
		}
		return cameralist;
	}
	
	
	/**
	 * 可视通接口通用调用方式
	 * @param url
	 * @return xml
	 */
	private static String getresponse(String url)
	{
		StringBuffer result = new StringBuffer();
		URL U;
		try {
			U = new URL(url);
	
			URLConnection connection = U.openConnection();			
			connection.connect();
		  
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine())!= null)
		   {
		    result.append(line);
		   }
		   in.close(); 
		
		} catch (Exception e) {
			logger.error("error："+e.getMessage());
		}			
		
		return result.toString();		
	}	
	
	/**
	 * 提取节点下所有的值
	 * @param document
	 * @param xmlPath
	 * @param leafElementName
	 * @param leafElementValue
	 */
	public static ArrayList<Map> getLeafElementValues(Document document,String xmlPath){
		ArrayList<Map> list =new ArrayList<Map>();
		Iterator i = document.selectNodes(xmlPath).iterator();
	    while (i.hasNext()) {
	    	Element a = (Element) i.next();
	    	 Iterator iterator=a.elementIterator();
	    	 while(iterator.hasNext())
	    	  {
	    		 Element e = (Element)iterator.next();	   
	    		 Iterator attI =  e.attributeIterator();
	    		 Map<String,String> tmp = new HashMap<String,String>();
	    		 while(attI.hasNext())
	    		 {
	    			 Attribute attribute=(Attribute)attI.next();
	    			 tmp.put(attribute.getName(), attribute.getValue() );
	    		 }
	    	    list.add(tmp);
	    	 } 	    	
	    }
	    return list;
	}
	
	public static void main(String args[]) {
	
	//	ArrayList<CameraGroup> grouplist =   getallgroupsnew( "http://10.6.22.202/vci.aspx?op=getallgroups2&domainid=ef7dd932-9a0a-4051-ae2c-2e1057f9eb21");		
	//	System.out.println(grouplist.size());
		
//		ArrayList<Camera> cameralist = getCamerasbyGroupID("http://10.1.2.62/vci.aspx?op=getcamerasbygroupid&groupid=cfee2efd-8160-44ae-9030-cbe7edcc1676");
//		System.out.println(cameralist.size());
		
		String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?><presets><node presetid=\"1\" presetname=\"河南油库\"/><node presetid=\"2\" presetname=\"郑州加油站\" /></presets>";
				
		try {
//			   digester.addObjectCreate("foo/bar", "mypackage.Bar"); 
//			digester.addSetProperties("foo/bar"); 
//			   digester.addSetNext("foo/bar", "addBar", "mypackage.Bar"); 
//			   Foo foo = (Foo) digester.parse(); 
			   
//			Digester digester = new Digester();
//		    digester.setValidating(false);
//		    digester.addObjectCreate("presets",Presets.class);
//		    digester.addSetProperties("presets");
//		    
//			digester.addObjectCreate("presets/node",Presets.Node.class);
//			digester.addSetProperties("presets/node");
////		    digester.addCallParam("presets/node/presetid",0);
////		    digester.addBeanPropertySetter("presets/node/presetname", "setPresetname");
//		   
//		    digester.addSetNext("presets/node", "setDataList");
//		    
//		    ByteArrayInputStream bis = new ByteArrayInputStream(result.getBytes("UTF-8"));
//		
//		    Presets root =(Presets)digester.parse(bis);
//			logger.info("dateList : "+root.getDataList().size());
//			for(int i=0;i<root.getDataList().size();i++){
//				Node pre = root.getDataList().get(i);
//				System.out.println(pre.getPresetid()+"=="+pre.getPresetname());
//			}
			System.out.println(System.currentTimeMillis());
			System.out.println(KSTUtil.exectWallPreset("http://10.6.22.202/vci.aspx?op=exectvwallpreset&presetid=50"));
			System.out.println(System.currentTimeMillis());
		} catch (Exception e) {
			logger.error("解析省公司返回数据异常:"+e.getMessage());
		}
		//		System.out.println(getresponse("http://10.6.22.202/vci.aspx?op=getallgroups&domainid=53fe4ab2-37b6-40ab-8c9e-ffe567759177"));
	}

}
