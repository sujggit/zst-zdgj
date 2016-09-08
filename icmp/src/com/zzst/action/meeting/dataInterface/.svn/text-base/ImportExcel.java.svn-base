package com.zzst.action.meeting.dataInterface;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.DataInterfaceEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceService;
import com.zzst.service.meeting.dataInterface.equipment.EquipmentInterfaceService;
import com.zzst.service.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceService;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceService;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceService;
import com.zzst.service.meeting.department.DepartmentService;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.user.UserService;

public class ImportExcel extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MeetingRoomService meetingRoomService = ServiceFactory.getMeetingRoomService();
	private static UserService userService = ServiceFactory.getUserService();
	private static DepartmentService departmentService = ServiceFactory.getDepartmentService();
	private static AddressService addressService = ServiceFactory.getAddressService();
	private static MeetingRoomInterfaceService mis = ServiceFactory.getMeetingRoomInterfaceService();
	private static RoleInterfaceService ris = ServiceFactory.getRoleInterfaceService();
	private static DepartmentInterfaceService dis = ServiceFactory.getDepartmentInterfaceService();
	private static UserInterfaceService uis = ServiceFactory.getUserInterfaceService();
	private static EquipmentInterfaceService eis = ServiceFactory.getEquipmentInterfaceService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}



	/**
	 * savePath:上传文件的路径；maxSize：上传文件的限制值；index上传文件的file的id的索引参数，也可以确认是此jsp页面属于单文件上传，还是多文件上传
	 */
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws IOException, ServletException {
    	
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       PrintWriter out = response.getWriter();
       String savePath = request.getParameter("savePath");
       String type = request.getParameter("type");
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
           String fileName = "";
           String realFileName = "";
           while (i.hasNext()) {
              FileItem fi = (FileItem) i.next();
              /**
              UploadFileVO uploadFileVO = new UploadFileVO();
              if(fi.isFormField()){//判断是文件还是文本信息
            	 System.out.println(fi.getFieldName()+"======="+fi.getString("UTF-8")); 
              }
              */
              if(!fi.isFormField()){//判断是文件还是文本信息
	              fileName = fi.getName();
	              if (fileName != null) {
	            	 File fullFile = new File(fi.getName());
	                 realFileName = fullFile.getName();//iE下获取真实路径
	            	     
		             File savedFile = new File(uploadPath, realFileName);
		             fi.write(savedFile);
	            	  
	                  
	                 //out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
	                 //out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='上传成功'</script>");
	                 String pathname = getServletContext().getRealPath("/")+savePath+realFileName;
	                 if( type.equalsIgnoreCase("meetingRoom")){
	                	 readExcel(pathname,request,response,index);//解析excel并插入数据库
	                 }else if( type.equalsIgnoreCase("terminal")){
	                	 readExcelTerminal(pathname,request,response,index);
	                 }else if( type.equalsIgnoreCase("role")){
	                	 readExcelRole(pathname,request,response,index);
	                 }else if( type.equalsIgnoreCase("department")){
	                	 readExcelDepartment(pathname,request,response,index);
	                 }else if( type.equalsIgnoreCase("user")){
	                	 readExcelUser(pathname,request,response,index);
	                 }
		      		 
		      		 
		      		 
	              }
		          //out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='上传成功'</script>");
		          //out.print("<script>window.parent.document.getElementById('fileUrl').value='"+savePath+"'</script>");
		          //out.print("<script>window.history.back(-1)</script>");
		          
	           }
              
           }
           
           
       } catch (Exception e) {
           // 可以跳转出错页面
    	   System.out.println("upload failure");
    	   //out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
    	   out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='上传失败（MaxSize="+maxSize+"Mb）'</script>");
    	   out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
           out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='上传失败'</script>");
    	   //out.print("<script>window.parent.document.getElementById('fileUrl').value=''</script>");
           e.printStackTrace();
       }finally{
    	   out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
    	   out.flush();
           out.close();
       }
    	
    }
    
    
    /**
     * 会议室导入
     * @param pathname
     * @param request
     * @param response
     * @param index
     */
    public  void readExcel(String pathname, HttpServletRequest request , HttpServletResponse response, String index)  {
     PrintWriter out = null;
     try {
    	 out = response.getWriter();
    	 //打开文件
    	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
    	 
    	 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
         out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入成功'</script>");
         out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入成功'</script>");
         
         mis.deleteAll();//删除接口表数据
         
    	 
    	 //取得第一个sheet
    	 Sheet sheet = book.getSheet(0);
    	 //取得行数
    	 int rows = sheet.getRows();
    	 for(int i = 1; i < rows; i++) {//第一行为表头可以忽略
    		 MeetingRoomInterfaceVO meetingRoomInterfaceVO = new MeetingRoomInterfaceVO();
	    	 Cell [] cell = sheet.getRow(i);
	    	 for(int j=1; j<cell.length; j++) {
		    	 //getCell(列，行)
	    		 if( j == 1){
	    			 meetingRoomInterfaceVO.setMeetingroomName(sheet.getCell(j, i).getContents());
	    			 
	    		 }else if( j == 2 ){
	    			 meetingRoomInterfaceVO.setRoomNO(sheet.getCell(j, i).getContents());
	    		 }else if( j == 3 ){
	    			 meetingRoomInterfaceVO.setMeetingRoomType(Integer.parseInt(sheet.getCell(j, i).getContents()));
	    		 }else if( j == 4 ){
	    			 meetingRoomInterfaceVO.setCapacity(Integer.parseInt(sheet.getCell(j, i).getContents()));
	    		 }else if( j == 5 ){
	    			 meetingRoomInterfaceVO.setAdminName(sheet.getCell(j, i).getContents());
	    		 }else if( j == 6 ){
	    			 meetingRoomInterfaceVO.setDepartmentName(sheet.getCell(j, i).getContents());
	    		 }else if( j == 7 ){
	    			 meetingRoomInterfaceVO.setAddressName(sheet.getCell(j, i).getContents());
	    		 }else if( j == 8 ){
	    			 meetingRoomInterfaceVO.setMeetingRoomStatus(Integer.parseInt(sheet.getCell(j, i).getContents()));
	    		 }
	    		 
	    	 }
	    	 meetingRoomInterfaceVO.setStatus(DataInterfaceEnum.NOT_IMPORT);//状态为未导入
	    	 mis.add(meetingRoomInterfaceVO);
    	 }
    	 
    	 insertLog("向会议室接口表导入数据",request);
    	 
    	 //关闭文件
    	 book.close();
    	 out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
    	 } catch (BiffException e) {
    		 e.printStackTrace();
    		 //TODO:页面提示
    		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
             out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
             out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
    		 out.print("<script>alert('导入失败,请检查上传文件是否为97-2003版本的xls文件');</script>");
    	 } catch (IOException e) {
    		 e.printStackTrace();
    		 //TODO:页面提示
    	 } catch( Exception e ){
    		 e.printStackTrace();
    		 //TODO:页面提示
    		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
             out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
             out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
    		 out.print("<script>alert('导入失败,请检查excel内容格式是否正确');</script>");
    	 }
    }
    
    
    public  void readExcelTerminal(String pathname, HttpServletRequest request , HttpServletResponse response, String index) {
    	PrintWriter out = null;
        try {
	        out = response.getWriter();
	       	 //打开文件
	       	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
	       	 
	       	 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
	         out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入成功'</script>");
	         out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入成功'</script>");
            
	         eis.deleteAll();//删除接口表数据
            
       	 
       	 //取得第一个sheet
       	 Sheet sheet = book.getSheet(0);
       	 //取得行数
       	 int rows = sheet.getRows();
       	 for(int i = 1; i < rows; i++) {//第一行为表头可以忽略
       		 EquipmentInterfaceVO equipmentInterfaceVO = new EquipmentInterfaceVO();
   	    	 Cell [] cell = sheet.getRow(i);
   	    	 //getCell(列，行)
   	    	 String equipType = sheet.getCell(0, i).getContents();//取得设备类型
   	    	 if( equipType.equals(EquipmentEnum.TYPE_ID_TERMINAL+"")){
   	    		equipmentInterfaceVO = toEquipment(EquipmentEnum.TYPE_ID_TERMINAL,i, sheet);
   	    	 }else if( equipType.equals(EquipmentEnum.TYPE_ID_MCU+"") ){
   	    		equipmentInterfaceVO = toEquipment(EquipmentEnum.TYPE_ID_MCU,i, sheet);
   	    	 }else if( equipType.equals(EquipmentEnum.TYPE_ID_CENTERCONTROL+"")){
   	    		equipmentInterfaceVO = toEquipment(EquipmentEnum.TYPE_ID_CENTERCONTROL,i, sheet);
   	    	 }else if( equipType.equals(EquipmentEnum.TYPE_ID_VIDEOCARD+"")){
   	    		equipmentInterfaceVO = toEquipment(EquipmentEnum.TYPE_ID_VIDEOCARD,i, sheet);
   	    	 }else if( equipType.equals(EquipmentEnum.TYPE_ID_OTHEREQUIPMENT+"")){
   	    		equipmentInterfaceVO = toEquipment(EquipmentEnum.TYPE_ID_OTHEREQUIPMENT,i, sheet);
   	    	 }
   	    	 
   	    	eis.add(equipmentInterfaceVO);
       	 }
       	 
       	insertLog("向设备接口表导入数据",request);
       	 
       	 //关闭文件
       	 book.close();
       	 out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
       	 } catch (BiffException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查上传文件是否为97-2003版本的xls文件');</script>");
       	 } catch (IOException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       	 } catch( Exception e ){
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查excel内容格式是否正确');</script>");
       	 }
       }
    
    
    public  void readExcelRole(String pathname, HttpServletRequest request , HttpServletResponse response, String index){
    	PrintWriter out = null;
    	try {
       	 //打开文件
         out = response.getWriter();
        	
       	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
       	 
       	 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
         out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入成功'</script>");
         out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入成功'</script>");
            
         ris.deleteAll();//删除接口表数据
            
       	 
       	 //取得第一个sheet
       	 Sheet sheet = book.getSheet(0);
       	 //取得行数
       	 int rows = sheet.getRows();
       	 for(int i = 1; i < rows; i++) {//第一行为表头可以忽略
       		 RoleInterfaceVO roleVO = new RoleInterfaceVO();
   	    	 Cell [] cell = sheet.getRow(i);
   	    	 for(int j=1; j<cell.length; j++) {
   		    	 //getCell(列，行)
   	    		 if( j == 1){
   	    			roleVO.setRolename(sheet.getCell(j, i).getContents());//角色名
   	    			 
   	    		 }
   	    	 }
   	    	roleVO.setImportstatus(DataInterfaceEnum.NOT_IMPORT);//状态为未导入
   	    	ris.add(roleVO);
       	 }
       	 
       	insertLog("向角色接口表导入数据",request);
       	 
       	 
       	 //关闭文件
       	 book.close();
       	 out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
       	 } catch (BiffException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查上传文件是否为97-2003版本的xls文件');</script>");
       	 } catch (IOException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       	 } catch( Exception e ){
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查excel内容格式是否正确');</script>");
       	 }
       }
    
    
    public  void readExcelDepartment(String pathname, HttpServletRequest request , HttpServletResponse response, String index){
    	PrintWriter out = null;
    	try {
       	 //打开文件
         out = response.getWriter();
        	
       	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
       	 
       	 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
         out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入成功'</script>");
         out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入成功'</script>");
            
         dis.deleteAll();//删除接口表数据
            
       	 
       	 //取得第一个sheet
       	 Sheet sheet = book.getSheet(0);
       	 //取得行数
       	 int rows = sheet.getRows();
       	 for(int i = 1; i < rows; i++) {//第一行为表头可以忽略
       		 boolean flag = true;
       		 DepartmentInterfaceVO dptVO = new DepartmentInterfaceVO();
   	    	 Cell [] cell = sheet.getRow(i);
   	    	 for(int j=0; j<cell.length; j++) {
   		    	 //getCell(列，行)
   	    		 if( j == 0){
   	    			if( StringUtils.isNullOrBlank(sheet.getCell(j, i).getContents())){
   	    				flag = false;
   	    			}
   	    			dptVO.setDepartmentid(sheet.getCell(j, i).getContents());//主键
   	    		 }
   	    		 if( j == 1 ){
   	    			dptVO.setDepartmentname(sheet.getCell(j, i).getContents());//部门名称 
   	    		 }
   	    		 if( j == 2 ){
   	    			dptVO.setParentid(sheet.getCell(j, i).getContents());//pid 
   	    		 }
   	    	 }
   	    	 if(flag){
   	    		dptVO.setImportstatus(DataInterfaceEnum.NOT_IMPORT);//状态为未导入
   	   	    	dis.add(dptVO,false);
   	    	 }
   	    	
       	 }
       	 
       	insertLog("向组织结构接口表导入数据",request);
       	 
       	 
       	 //关闭文件
       	 book.close();
       	 out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
       	 } catch (BiffException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查上传文件是否为97-2003版本的xls文件');</script>");
       	 } catch (IOException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       	 } catch( Exception e ){
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查excel内容格式是否正确');</script>");
       	 }
       }
    
    /**
     * 返回会议室list
     * @return
     */
    public static ArrayList<MeetingRoomVO> getMeetingRoomList() throws Exception{
    	
    	MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
    	ArrayList<MeetingRoomVO> list = meetingRoomService.query(meetingRoomVO, null);
    	
    	return list;
    	
    }
    
    /**
     * 返回人员list
     * @return
     */
    public static ArrayList<UserVO> getUserList() throws Exception{
    	
    	UserVO userVO = new UserVO();
    	userVO.setState(UserEnum.VALID);
    	ArrayList<UserVO> list = userService.getUserList(userVO, null);
    	
    	return list;
    	
    }
    
    /**
     * 返回单位list
     * @return
     */
    public static ArrayList<DepartmentVO> getDepartmentList() throws Exception{
    	
    	DepartmentVO departmentVO = new DepartmentVO();
    	ArrayList<DepartmentVO> list = departmentService.getAllFuncList(departmentVO, null);
    	
    	return list;
    	
    }
    
    
    /**
     * 返回区域list
     * @return
     */
    public static ArrayList<AddressVO> getAddressList() throws Exception{
    	
    	AddressVO addressVO = new AddressVO();
    	return addressService.query(addressVO, null);
    	
    	
    }
    
    private static void insertLog(String str, HttpServletRequest request) throws Exception{
	    HttpSession session =   request.getSession();
	    UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent(str);
				new LogServiceImpl().add(logVO);
		   }
    }
    
    
    public  void readExcelUser(String pathname, HttpServletRequest request , HttpServletResponse response, String index){
    	PrintWriter out = null;
    	try {
       	 //打开文件
         out = response.getWriter();
        	
       	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
       	 
       	 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/images/connected2.png'</script>");
         out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入成功'</script>");
         out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入成功'</script>");
            
         uis.deleteAll();//删除接口表数据
            
       	 
       	 //取得第一个sheet
       	 Sheet sheet = book.getSheet(0);
       	 //取得行数
       	 int rows = sheet.getRows();
       	 for(int i = 1; i < rows; i++) {//第一行为表头可以忽略
       		 UserInterfaceVO userVO = new UserInterfaceVO();
   	    	 Cell [] cell = sheet.getRow(i);
   	    	 for(int j=1; j<cell.length; j++) {
   		    	 //getCell(列，行)
   	    		 if( j == 1){
   	    			userVO.setLoginname(sheet.getCell(j, i).getContents());//用户名
   	    		 }
   	    		 
   	    		 if( j == 2 ){
   	    			userVO.setFullname(sheet.getCell(j, i).getContents());//姓名
   	    		 }
   	    		 
   	    		if( j == 3 ){
   	    			userVO.setEmail(sheet.getCell(j, i).getContents());//邮箱
   	    		 }
   	    		
   	    		if( j == 4 ){
   	    			userVO.setMobilephone(sheet.getCell(j, i).getContents());//手机
   	    		 }
   	    		if( j == 5 ){
   	    			userVO.setRolename(sheet.getCell(j, i).getContents());//角色名
   	    		}
   	    		if( j == 6 ){
   	    			userVO.setDepartmentid(sheet.getCell(j, i).getContents());//部门id
   	    		}
   	    	 }
   	    	userVO.setImportstatus(DataInterfaceEnum.NOT_IMPORT);//状态为未导入
   	    	uis.add(userVO,true);
       	 }
       	 
       	insertLog("向用户接口表导入数据",request);
       	 
       	 
       	 //关闭文件
       	 book.close();
       	 out.print("<script>window.parent.document.getElementById('isUploadFinished').click()</script>");
       	 } catch (BiffException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查上传文件是否为97-2003版本的xls文件');</script>");
       	 } catch (IOException e) {
       		 e.printStackTrace();
       		 //TODO:页面提示
       	 } catch( Exception e ){
       		 e.printStackTrace();
       		 //TODO:页面提示
       		 out.print("<script>window.parent.document.getElementById('fileIco"+index+"').src='/icmp/meeting/equipmentControl/image/hr.gif'</script>");
                out.print("<script>window.parent.document.getElementById('fileIco"+index+"').title='导入失败'</script>");
                out.print("<script>window.parent.document.getElementById('uploadSpan').innerHTML='导入失败'</script>");
       		 out.print("<script>alert('导入失败,请检查excel内容格式是否正确');</script>");
       	 }
       }
 
    private EquipmentInterfaceVO toEquipment( int equipType ,int i , Sheet sheet ){
    	EquipmentInterfaceVO ei = new EquipmentInterfaceVO();
    	
		    	 //getCell(列，行)
    			ei.setEquipmentType(equipType);
    			ei.setEquipmentModel(sheet.getCell(1, i).getContents());//设备型号
	    		ei.setEquipmentNO(sheet.getCell(2, i).getContents());//显示名称
	    		try{
	    			ei.setEquipmentStatus(Integer.parseInt(sheet.getCell(3, i).getContents()));//设备状态
	    		}catch( Exception e ){
	    			ei.setEquipmentStatus(EquipmentEnum.STATUS_VALID);
	    		}
	    		ei.setIp(sheet.getCell(4, i).getContents());
	    		ei.setCommandIP(sheet.getCell(5, i).getContents());
	    		try{
	    			ei.setPort(Integer.parseInt(sheet.getCell(6, i).getContents()));
	    		}catch( Exception e ){
	    			ei.setPort(DataInterfaceEnum.PORT_DEFAULT);
	    		}
	    		ei.setRoomNO(sheet.getCell(7, i).getContents());
	    		ei.setAdminName(sheet.getCell(8, i).getContents());
	    		ei.setLoginName(sheet.getCell(9, i).getContents());
	    		ei.setLoginPassword(sheet.getCell(10, i).getContents());
	    		ei.setMcuIp(sheet.getCell(11, i).getContents());
	    		ei.setAppraisalTaskNum(sheet.getCell(12, i).getContents());
	    		ei.setShowFormatFlag(sheet.getCell(13, i).getContents());
	    		ei.setInputModel(sheet.getCell(14, i).getContents());
	    		ei.setOutputModel(sheet.getCell(15, i).getContents());
	    		ei.setAppraisalModel(sheet.getCell(16, i).getContents());
	    		ei.setCollectModel(sheet.getCell(17, i).getContents());
	    		ei.setSerialNumber(sheet.getCell(18, i).getContents());
	    			
	    	    ei.setStatus(DataInterfaceEnum.NOT_IMPORT);//状态为未导入
	    	    ei.setDescription("未导入");
	    	    return ei;
    }
    
}