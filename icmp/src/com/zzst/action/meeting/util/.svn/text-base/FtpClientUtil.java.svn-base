package com.zzst.action.meeting.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.net.ftp.FTP;  
  
import org.apache.commons.net.ftp.FTPClient;  
  
  
import org.apache.commons.net.ftp.FTPFile;  
  

public class FtpClientUtil {
	 private FTPClient ftpClient;  
	    public static final int BINARY_FILE_TYPE = FTP.BINARY_FILE_TYPE;  
	    public static final int ASCII_FILE_TYPE = FTP.ASCII_FILE_TYPE;  
	    private String fileLocation = MeetingAppConfig.FILE_LOCATION;
	    // path should not the path from root index  
	    // or some FTP server would go to root as '/'.  
	    public void connectServer() throws SocketException,  
	            IOException {  
	        String server = MeetingAppConfig.FTP_SERVER;  
	        int port = 21;  
	        String user = MeetingAppConfig.FTP_USER;  
	        String password = MeetingAppConfig.FTP_PSW;  
	        String location = MeetingAppConfig.FTP_LOCATION;  
	        connectServer(server, port, user, password, location);  
	    }  
	      
	      
	    public void connectServer(String server, int port, String user,  
	            String password, String path) throws SocketException, IOException {  
	        ftpClient = new FTPClient();  
	        ftpClient.connect(server, port);  
	        System.out.println("Connected to " + server + ".");  
	        System.out.println(ftpClient.getReplyCode());  
	        ftpClient.enterLocalPassiveMode();
	        ftpClient.login(user, password);  
	        // Path is the sub-path of the FTP path  
	        if (path.length() != 0) {  
	            ftpClient.changeWorkingDirectory(path);  
	        }  
	    }  
	    //FTP.BINARY_FILE_TYPE | FTP.ASCII_FILE_TYPE  
	    // Set transform type  
	    public void setFileType(int fileType) throws IOException {  
	        ftpClient.setFileType(fileType);  
	    }  
	  
	    public void closeServer() throws IOException {  
	        if (ftpClient.isConnected()) {  
	            ftpClient.disconnect();  
	        }  
	    }  
	    //=======================================================================  
	    //==         About directory       =====  
	    // The following method using relative path better.  
	    //=======================================================================  
	      
	    public boolean changeDirectory(String path) throws IOException {  
	        return ftpClient.changeWorkingDirectory(path);  
	    }  
	    public boolean createDirectory(String pathName) throws IOException {  
	        return ftpClient.makeDirectory(pathName);  
	    }  
	    public boolean removeDirectory(String path) throws IOException {  
	        return ftpClient.removeDirectory(path);  
	    }  
	      
	    // delete all subDirectory and files.  
	    public boolean removeDirectory(String path, boolean isAll)  
	            throws IOException {  
	          
	        if (!isAll) {  
	            return removeDirectory(path);  
	        }  
	  
	        FTPFile[] ftpFileArr = ftpClient.listFiles(path);  
	        if (ftpFileArr == null || ftpFileArr.length == 0) {  
	            return removeDirectory(path);  
	        }  
	        //   
	        for (FTPFile ftpFile : ftpFileArr) {  
	            String name = ftpFile.getName();  
	            if (ftpFile.isDirectory()) {  
	System.out.println("* [sD]Delete subPath ["+path + "/" + name+"]");               
	                removeDirectory(path + "/" + name, true);  
	            } else if (ftpFile.isFile()) {  
	System.out.println("* [sF]Delete file ["+path + "/" + name+"]");                          
	                deleteFile(path + "/" + name);  
	            } else if (ftpFile.isSymbolicLink()) {  
	  
	            } else if (ftpFile.isUnknown()) {  
	  
	            }  
	        }  
	        return ftpClient.removeDirectory(path);  
	    }  
	      
	    // Check the path is exist; exist return true, else false.  
	    public boolean existDirectory(String path) throws IOException {  
	        boolean flag = false;  
	        FTPFile[] ftpFileArr = ftpClient.listFiles(path);  
	        for (FTPFile ftpFile : ftpFileArr) {  
	            if (ftpFile.isDirectory()  
	                    && ftpFile.getName().equalsIgnoreCase(path)) {  
	                flag = true;  
	                break;  
	            }  
	        }  
	        return flag;  
	    }  
	  
	    //=======================================================================  
	    //==         About file        =====  
	    // Download and Upload file using  
	    // ftpUtil.setFileType(FtpUtil.BINARY_FILE_TYPE) better!  
	    //=======================================================================  
	  
	    // #1. list & delete operation  
	    // Not contains directory  
	    Map<String,String> fileMap = new HashMap<String,String>();
	    /**
	     * 
	     * @param path
	     * @return map(url,name)
	     * @throws IOException
	     */
	    public Map<String,String> getFileList(String path) throws IOException {  
	        // listFiles return contains directory and file, it's FTPFile instance  
	        // listNames() contains directory, so using following to filer directory.  
	        //String[] fileNameArr = ftpClient.listNames(path);  
	        FTPFile[] ftpFiles= ftpClient.listFiles(path);  
	          
	        
	        if (ftpFiles == null || ftpFiles.length == 0) {  
	            return fileMap;  
	        }  
	        for (FTPFile ftpFile : ftpFiles) { 
	        	try{
	        	String fileName =new String( ftpFile.getName().getBytes("iso-8859-1"),"utf-8");
	        
	            if (ftpFile.isFile()) { 
	            	String filePath = fileLocation+path+fileName;
	            	filePath =URLEncoder.encode(URLEncoder.encode(filePath,"gbk"),"iso-8859-1");
	            	
	            	fileMap.put(filePath, fileName);
	                //retList.add(fileName);  
	            }else if(ftpFile.isDirectory()){
	            	//if(!fileName.equals(".")&&!fileName.equals("..")){
	            	//	getFileList(path+fileName+"/");
	            	//}
	            	
	            }
	        	}catch(Exception e){
	        		e.printStackTrace();
	        		continue;
	        	}
	        }  
	        return fileMap;  
	    }  
	  
	    public boolean deleteFile(String pathName) throws IOException {  
	        return ftpClient.deleteFile(pathName);  
	    }  
	  
	    // #2. upload to ftp server  
	    // InputStream <------> byte[]  simple and See API  
	  
	    public boolean uploadFile(String fileName, String newName)  
	            throws IOException {  
	        boolean flag = false;  
	        InputStream iStream = null;  
	        try {  
	            iStream = new FileInputStream(fileName);  
	            flag = ftpClient.storeFile(newName, iStream);  
	        } catch (IOException e) {  
	            flag = false;  
	            return flag;  
	        } finally {  
	            if (iStream != null) {  
	                iStream.close();  
	            }  
	        }  
	        return flag;  
	    }  
	  
	    public boolean uploadFile(String fileName) throws IOException {  
	        return uploadFile(fileName, fileName);  
	    }  
	  
	    public boolean uploadFile(InputStream iStream, String newName)  
	            throws IOException {  
	        boolean flag = false;  
	        try {  
	            // can execute [OutputStream storeFileStream(String remote)]  
	            // Above method return's value is the local file stream.  
	            flag = ftpClient.storeFile(newName, iStream);  
	        } catch (IOException e) {  
	            flag = false;  
	            return flag;  
	        } finally {  
	            if (iStream != null) {  
	                iStream.close();  
	            }  
	        }  
	        return flag;  
	    }  
	  
	    // #3. Down load   
	  
	    public boolean download(String remoteFileName, String localFileName)  
	            throws IOException {  
	        boolean flag = false;  
	        File outfile = new File(localFileName);  
	        OutputStream oStream = null;  
	        try {  
	            oStream = new FileOutputStream(outfile);  
	            flag = ftpClient.retrieveFile(remoteFileName, oStream);  
	        } catch (IOException e) {  
	            flag = false;  
	            return flag;  
	        } finally {  
	            oStream.close();  
	        }  
	        return flag;  
	    }  
	      
	    public InputStream downFile(String sourceFileName) throws IOException {  
	        return ftpClient.retrieveFileStream(sourceFileName);  
	    }  
	    
	    public static void main(String[] args){
	    	FtpClientUtil fcu = new FtpClientUtil();
	    	try {
				fcu.connectServer();
			Map<String,String> files =	fcu.getFileList("/rss/");
			//for(int i=0 ;i<files.size();i++){
				//String file = new String(files.get(i).getBytes("iso-8859-1"),"utf-8");
			//	System.out.println(files.get(i));
			//}
			Set<String> keyset = files.keySet();
			for(Iterator it = keyset.iterator();it.hasNext();){
				System.out.println(it.next());
			}
				fcu.closeServer();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
}