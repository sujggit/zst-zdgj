package com.zzst.zdgj.messageUtil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author  libo
 * @date Jul 4, 2013
 * @version 
 */
public class NoteSendUtil {

	private static final String MSG_CODE="code";
	private static final String MSG_LIST_NODE="message";
	private static final String MSG_SEND_MOBILE="desmobile";
	private static final String MSG_ID="msgid";
	private static final String MSG_CONTENT="content";
	private static final Map<String,Object> codeStateMap=new HashMap<String, Object>();
	
	static{
		codeStateMap.put("00", "批量短信提交成功（批量短信待审批）");
		codeStateMap.put("01", "批量短信提交成功（批量短信跳过审批环节）");
		codeStateMap.put("03", "单条短信提交成功");
		codeStateMap.put("04", "用户名错误");
		codeStateMap.put("05", "密码错误或用户名注销");
		codeStateMap.put("06", "剩余条数不足");
		codeStateMap.put("07", "信息内容中含有限制词(违禁词)");
		codeStateMap.put("08", "信息内容为黑内容");
		codeStateMap.put("09", "该用户的该内容 受同天内内容不能重复发 限制");
		codeStateMap.put("10", "批量下限不足");
		codeStateMap.put("97", "短信参数有误");
		codeStateMap.put("98", "防火墙无法处理这种短信");
		
	}
	/**
	 * 短信发送测试【群发】
	 * @param sendMobile接收者电话
	 * @param sendContent接收者内容
	 * @return
	 */    
	public static String sendNote(List<String> mobileList,String sendContent) throws ConnectException
	{
		//String sendMobile=DataUtil.converListToStr(mobileList);//短信list处理类，用逗号隔开
		StringBuffer sendMobile = new StringBuffer();
		int num=0;
		for(String str:mobileList){
			if(++num<mobileList.size()){//mun++ 先使用mun的值，然后再给num加1
				sendMobile.append(str+",");
			}else {
				sendMobile.append(str);
			}
			
		}
		return sendNote(sendMobile.toString(),sendContent);
	}
	
	/**
	 * 短信发送测试【单发】	 * @param sendMobile接收者电话	 * @param sendContent接收者内容	 * @return
	 */    
	public static String sendNote(String sendMobile,String sendContent) throws ConnectException
	{
		String rs="";
		try{
			StringBuffer strBuffer=new StringBuffer("http://172.28.100.9/ZdgjSms/QxtFirewall?OperID=hgpt&OperPass=hgpt&AppendID=");
			strBuffer.append("&DesMobile=").append(sendMobile)
					 .append("&ContentType=8")
					 .append("&Content=").append(URLEncoder.encode(sendContent,"GBK"));
            URL url=new URL(strBuffer.toString());  
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setRequestMethod("GET");
            InputStream is = connect.getInputStream();  
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
            byte[] buff = new byte[256];  
            int rc = 0;  
            while ( (rc = is.read(buff, 0, 256)) > 0) {  
                outStream.write(buff, 0, rc);  
            }  
            byte[] b = outStream.toByteArray();
            //关闭  
            outStream.close();  
            is.close();  
            connect.disconnect();
            Map<String,Object> map =readStringXmlOut(new String(b));
            rs=codeStateMap.get(map.get("code")).toString();
            
        }catch(Exception e){
        	 throw new ConnectException();
        } 
        return rs;
	}
	
	/**
	 * 将xml转换为Map
	 * @param xml
	 * @return
	 */
	private static Map<String,Object> readStringXmlOut(String xml) {
        Map<String,Object> map = new HashMap<String,Object>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String code = rootElt.elementTextTrim("code");
            map.put(MSG_CODE, code);
            @SuppressWarnings("rawtypes")
			Iterator iter = rootElt.elementIterator(MSG_LIST_NODE);
            List<Map<String, Object>> temList=new ArrayList<Map<String,Object>>();
            Map<String, Object> temMap=new HashMap<String, Object>();
            while (iter.hasNext()) {
            	temMap=new HashMap<String, Object>();
                Element recordEle = (Element) iter.next();
                String desmobile = recordEle.elementTextTrim(MSG_SEND_MOBILE);
                temMap.put(MSG_SEND_MOBILE, desmobile);
                String msgid = recordEle.elementTextTrim(MSG_ID);
                temMap.put(MSG_ID, msgid);
	            temList.add(temMap);
            }
            map.put(MSG_CONTENT, temList);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

	
	public static void main(String[] args) {
		List<String> mobileList=new ArrayList<String>();
		mobileList.add("15701574020");
		String sendContent=MessageFormat.format("{0},{1}", new String[]{"张三","测试"});
		try {
			String stateDesc=NoteSendUtil.sendNote(mobileList,sendContent);
			System.out.println("===="+stateDesc);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}