package com.zzst.action.meeting.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DownUtil 
{
	public static void download(String urlString,String type) throws Exception
	{
		String filename ="";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = simpledateformat.format(calendar.getTime());
//		String type ="";
//		 if(urlString!=null)
//	   	  {
//	   	  	int i=0;
//	   	  	urlString = urlString.trim();
//	   	  	if((i= urlString.lastIndexOf("."))!= -1)
//	   	  	    type= urlString.substring(i);
//	   	  }
		 filename = "F:\\"+currentTime+"."+type;
	    // 构造URL
	    URL url = new URL(urlString);
	    // 打开连接
	    URLConnection con = url.openConnection();
	    // 输入流
	    InputStream is = con.getInputStream();
	    // 1K的数据缓冲
	    byte[] bs = new byte[1024];
	    // 读取到的数据长度
	    int len;
	    // 输出的文件流
	    OutputStream os = new FileOutputStream(filename);
	    // 开始读取
	    while ((len = is.read(bs)) != -1) {
	      os.write(bs, 0, len);
	    }
	    // 完毕，关闭所有链接
	    os.close();
	    is.close();
	}   
    
	public static void main(String[] args)
	{
		try {
			download("http://10.1.6.201/a_importdirectoryascsv.cgi","xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
