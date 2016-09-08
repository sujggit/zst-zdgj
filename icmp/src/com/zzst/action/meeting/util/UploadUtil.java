package com.zzst.action.meeting.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.authorization.AuthorHelper;
import com.zzst.action.meeting.util.tools.SoftWareUtils;

public class UploadUtil extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(UploadUtil.class.getName());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * savePath:上传文件的路径；maxSize：上传文件的限制值；index上传文件的file的id的索引参数，也可以确认是此jsp页面属于单文件上传，还是多文件上传
	 */
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=gb2312");
    	PrintWriter out = response.getWriter();
    	String savePath = request.getParameter("savePath");
 	   int maxSize = Integer.parseInt(request.getParameter("maxSize"));
 	   String index = request.getParameter("index");
       try {
//    	   String savePath = "/file/upload/";前臺可以指定保存路徑
    	   String uploadPath = getServletContext().getRealPath("/")+savePath;
    	   String tempPath = getServletContext().getRealPath("/")+savePath;
    	   
    	   File uploadFile = new File(uploadPath);
           if (!uploadFile.exists()) {
               uploadFile.mkdirs();
           }
           File tempPathFile = new File(tempPath);
            if (!tempPathFile.exists()) {
               tempPathFile.mkdirs();
           }
    	   
           // Create a factory for disk-based file items
           DiskFileItemFactory factory = new DiskFileItemFactory();
 
           // Set factory constraints
           factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
           factory.setRepository(tempPathFile);// 设置缓冲区目录
 
           // Create a new file upload handler
           ServletFileUpload upload = new ServletFileUpload(factory);
 
           // Set overall request size constraint
           upload.setSizeMax(maxSize*1024*1024); // 设置最大文件尺寸，这里是4MB
 
           List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
           Iterator<FileItem> i = items.iterator();
           while (i.hasNext()) {
              FileItem fi = (FileItem) i.next();
              /**
              UploadFileVO uploadFileVO = new UploadFileVO();
              if(fi.isFormField()){//判断是文件还是文本信息
            	 System.out.println(fi.getFieldName()+"======="+fi.getString("UTF-8")); 
              }
              */
              if(!fi.isFormField()){//判断是文件还是文本信息
	              String fileName = fi.getName();
	              String savePathTemp = "";
	              if (fileName != null) {
	            	  if("logoUpload".endsWith(index)){
	            		  File savedFile = new File(uploadPath, "zst.png");
	            		  fi.write(savedFile);
	            		  index = "1";
	            	  }else{
	            		  File fullFile = new File(fi.getName());
		                  String realFileName = fullFile.getName();
		                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		            	  StringBuffer sb = new StringBuffer();
		            	  sb.append(realFileName.substring(0,realFileName.lastIndexOf(".")));
		            	  sb.append(dateFormat.format(new Date()));
		            	  sb.append(realFileName.substring(realFileName.lastIndexOf(".")));
		                  String saveFileName = sb.toString();
		                  //savePath += saveFileName;
		                  savePathTemp = savePath+saveFileName;
//		            	  File savedFile = new File(uploadPath, SoftWareUtils.getCode()+".lic");
//		            	  fi.write(savedFile);
		                  
		                  String[] saveFileNameOper = saveFileName.split("\\.");
		                  int length = saveFileNameOper.length;
		                  if("lic".equals(saveFileNameOper[length-1])){
		                	  File savedFile = new File(uploadPath, SoftWareUtils.getCode()+".lic");//产品发布~软件授权：上传的是.lic的文件
		                	  fi.write(savedFile);
		                  }else{
		                	  File savedFile = new File(uploadPath, saveFileName);//资料管理：资料上传、会议室资料上传、设备资料上传
		                	  fi.write(savedFile);
		                  }
	            	  }
	                  //out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
	                  out.print("<script>window.parent.document.getElementById('fileUrl"+index+"').value='"+savePathTemp+"'</script>");
	                  out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/File/img/ok.png'</script>");
	                  out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='上传成功'</script>");
	                  
	                  AuthorHelper.configInit();//更新授权信息
	              }
	              logger.info("upload succeed");
		          out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='上传成功'</script>");
		          //out.print("<script>window.parent.document.getElementById('fileUrl').value='"+savePath+"'</script>");
		          //out.print("<script>window.history.back(-1)</script>");
	           }
           }
       } catch (Exception e) {
           // 可以跳转出错页面
    	   logger.error("upload failure");
    	   //out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
    	   out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='上传失败（MaxSize="+maxSize+"MB）'</script>");
    	   out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/File/img/error.gif'</script>");
           out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='上传失败'</script>");
    	   //out.print("<script>window.parent.document.getElementById('fileUrl').value=''</script>");
           e.printStackTrace();
       }finally{
    	   out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
    	   out.flush();
           out.close();
       }
    }
 
}