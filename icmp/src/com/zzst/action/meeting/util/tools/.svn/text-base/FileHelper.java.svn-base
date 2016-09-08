package com.zzst.action.meeting.util.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;

/**
 * 操作文件的帮助类
 * @author zhangdq
 * @since 2013-10-24
 */
public class FileHelper {
	private static Logger logger = CbfLogger.getLogger(FileHelper.class.getName());
	
	    /**
	     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	     */
	    public static String readFileByBytes(String fileName) {
	    	StringBuffer sb = new StringBuffer();
	        File file = new File(fileName);
	        InputStream in = null;
	        try {
//	            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
	            // 一次读一个字节
	            in = new FileInputStream(file);
	            int tempbyte;
	            while ((tempbyte = in.read()) != -1) {
	            	sb.append((char)tempbyte);
	            }
	            in.close();
	        } catch (Exception e) {
	        	logger.error("读取文件异常："+e.getMessage());
	        	return sb.toString();
	        }
//	        String s =  new String(sb.toString().getBytes("utf-8"),"utf-8");
	        return sb.toString();
	    }

	    /**
	     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	     */
	    public static String readFileByChars(String fileName) {
	    	StringBuffer sb = new StringBuffer();
	        File file = new File(fileName);
	        Reader reader = null;
	        try {
//	            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
	            // 一次读一个字符
	            reader = new InputStreamReader(new FileInputStream(file));
	            int tempchar;
	            while ((tempchar = reader.read()) != -1) {
	                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
	                // 但如果这两个字符分开显示时，会换两次行。
	                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
	                if (((char) tempchar) != '\r') {
	                   sb.append((char)tempchar);
	                }
	            }
	            reader.close();
	        } catch (Exception e) {
	        	logger.error("读取文件异常："+e.getMessage());
	        	return null;
	        }
	        return sb.toString();
	    }

	    /**
	     * 以行为单位读取文件，常用于读面向行的格式化文件
	     */
	    public static ArrayList<String> readFileByLines(String fileName) {
	    	ArrayList<String> list = new ArrayList<String>();
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	        	//以行为单位读取文件内容，一次读一整行
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	            	list.add(tempString);
	            }
	            reader.close();
	        } catch (Exception e) {
//	        	logger.error("读取文件异常："+e.getMessage());
	            return null;
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                	return null;
	                }
	            }
	        }
	        return list;
	    }
	    
	    /**
	     * 生成新文件,文件已经存在返回false
	     * @param fileName
	     * @param content
	     * @return	boolean
	     */
	    public static boolean createFile(String fileName,String content) {
	    	try{
	    		File file=new File(fileName);
		    	if(!file.exists()){
		    		BufferedWriter out = new BufferedWriter(new FileWriter(file));
			    	out.write(content);
			    	out.close();
		    	}
	    	}catch(Exception e){
	    		logger.error(e.getMessage());
	    	}
	    	
	    	return true;
	    }
 
	    public static void main(String[] args) {
	    	String classPath = FileHelper.class.getResource("/").getPath()+"lic.lic";
//	        System.out.println(FileHelper.readFileByBytes(classPath));
//	        System.out.println(FileHelper.readFileByChars(classPath));
	        System.out.println(FileHelper.readFileByLines(classPath));
	        System.out.println(FileHelper.createFile(FileHelper.class.getResource("/").getPath()+"lic.t","dddddddd"));
	        
	    }
	}
