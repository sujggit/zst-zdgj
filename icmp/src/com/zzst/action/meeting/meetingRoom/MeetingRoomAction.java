package com.zzst.action.meeting.meetingRoom;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;


import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.level.LevelConfigAction;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.tools.ImportUtil;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;




public class MeetingRoomAction extends CjfAction {
    private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(MeetingRoomAction.class.getName());
	
	private	MeetingRoomVO	meetingRoomVO = new MeetingRoomVO();
	private DepartmentVO departmentVO=new DepartmentVO();
	private AddressVO addressVO=new AddressVO();
	private UserVO userVO = new UserVO();
	private InputStream  excelStream;
	private ArrayList<MeetingRoomVO> meetingRoomVOList = new ArrayList<MeetingRoomVO>();
	private ArrayList<AddressVO> addressVOList=new ArrayList<AddressVO>();
	private MeetingRoomInterfaceVO mrVO = new MeetingRoomInterfaceVO();
	
	
	
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery(){
		logger.info("LoginAction	exportQuery	begin");
		try{
			meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
			
			String fileName = "meetingRoom.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(meetingRoomVOList!=null&&meetingRoomVOList.size()>0){	
				for (int i = 0; i < meetingRoomVOList.size(); i++) {
					MeetingRoomVO lVO = meetingRoomVOList.get(i);
					CellVO[] cell = new CellVO[9];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getMeetingRoomName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(lVO.getRoomNO());
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getMeetingRoomType()+"");
					/*for(String[] s : MeetingRoomEnum.getMeetingRooomType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getMeetingRoomType()+"")){
							 ex3.setValue(s[1]);
							 continue;
						 }
					 }*/
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getCapacity()+"");
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getUserVO().getLoginName());
					cell[5] = ex5;
					
					CellVO ex6 = new CellVO();
					ex6.setValue(lVO.getDepartmentVO().getTitle());
					cell[6] = ex6;
					
					CellVO ex7 = new CellVO();
					ex7.setValue(lVO.getAddressVO().getName());
					cell[7] = ex7;
					
					CellVO ex8 = new CellVO();
					ex8.setValue(lVO.getStatus()+"");
					/*for(String[] s : MeetingRoomEnum.getMeetingRooomStatus()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
							 ex8.setValue(s[1]);
							 continue;
						 }
					 }*/
					cell[8] = ex8;
					list.add(cell);
					
				}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("LoginAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	exportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[9];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议室名称");
		cellTitle[1] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议室编号");
		cellTitle[2] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议室类型(1-本地 2-视频)");
		cellTitle[3] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("容纳人数");
		cellTitle[4] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议室管理员(登录名)");
		cellTitle[5] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("所属单位");
		cellTitle[6] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("所属区域");
		cellTitle[7] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议室状态（0-有效 1-无效 2-维修）");
		cellTitle[8] = ex0;
		
		list.add(cellTitle);
	}
	
	/**
	 * 查询会议室列表
	 * @return
	 */
	public String query(){
		logger.info("MeetingRoomAction	query	begin");
		try{
			///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
	            	meetingRoomVO.setLevel(true);
	            	meetingRoomVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
		meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, getPageControler());
		
		}catch(Exception e){
			logger.error("MeetingRoomAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	query	end");
		return SUCCESS;
	}
	
	/**
	 * 根据ID查询会议室
	 * @return
	 */
	public	String	detail(){
		logger.info("MeetingRoomAction	detail	begin");
		try{
			meetingRoomVO	=	ServiceFactory.getMeetingRoomService().queryByID(meetingRoomVO.getMeetingRoomID());
			
		}catch(Exception e){
			logger.error("MeetingRoomAction	queryByID	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	detail	end");
		return SUCCESS;
	}
	
	
	/**
	 * 添加会议室
	 * @return
	 */
	public String	add(){
		
		logger.info("MeetingRoomAction	add	begin");
		try {
			addressVOList=ServiceFactory.getAddressService().query(addressVO,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("MeetingRoomAction	add	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存会议室
	 * @return
	 */
	public	String	addSave(){
		logger.info("MeetingRoomAction	addSave	begin");
		try{
		//	meetingRoomVO.setAdminID(this.getCjfUserVO().getUserID());

			meetingRoomVO	=	ServiceFactory.getMeetingRoomService().add(meetingRoomVO);	
			
			//默认分级的添加
			if(MeetingAppConfig.LEVEL_IS_POEN){
				LevelConfigVO levelConfigVO = new LevelConfigVO();
				UserVO usersessionVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
				if(!(usersessionVO.getUserID().equals(DateBaseEnum.Default_ID))){
				if(usersessionVO.getLevelConfigVO()!=null){
					levelConfigVO.setLevelID(usersessionVO.getLevelConfigVO().getLevelID());
					levelConfigVO.setLevelKey(meetingRoomVO.getMeetingRoomID());
					levelConfigVO.setLevelType(LevelEnum.LEVEL_ROOM);
					levelConfigVO.setCreateUserId(usersessionVO.getUserID());
					levelConfigVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					LevelConfigAction.levelConfigDefaultAdd(levelConfigVO);
				}
				}
			}
		}catch(Exception e){
			logger.error("MeetingRoomAction	addSave	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("MeetingRoomAction	addSave	end");
		return SUCCESS;
	}

	/**
	 * 根据ID提取会议室信息
	 * @return
	 */
	public	String	modify(){
		logger.info("MeetingRoomAction	modify	begin");
		try{
			addressVOList=ServiceFactory.getAddressService().query(addressVO,null);
			meetingRoomVO	=	ServiceFactory.getMeetingRoomService().queryByID(meetingRoomVO.getMeetingRoomID());
		}catch(Exception e){
			logger.error("MeetingRoomAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	modify	end");
		return SUCCESS;
	}
	

	/**
	 * 根据ID提取会议室信息(复制)
	 * @return
	 */
	public	String	copy(){
		logger.info("MeetingRoomAction	modify	begin");
		try{
			addressVOList=ServiceFactory.getAddressService().query(addressVO,null);
			meetingRoomVO	=	ServiceFactory.getMeetingRoomService().queryByID(meetingRoomVO.getMeetingRoomID());
		}catch(Exception e){
			logger.error("MeetingRoomAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	modify	end");
		return SUCCESS;
	}
	
	/**
	 * 根据id修改会议室信息
	 * @return
	 */
	public	String	modifySave(){
		logger.info("MeetingRoomAction	modifySave	begin");
		try{
			ServiceFactory.getMeetingRoomService().modify(meetingRoomVO);
		}catch(Exception e){
			logger.error("MeetingRoomAction	modifySave	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("MeetingRoomAction	modifySave	end");
		return SUCCESS;
	}

	/**
	 * 根据id修改会议室信息
	 * @return
	 */
	public	String	delete(){
		logger.info("MeetingRoomAction	delete	begin");
	
		try {
			meetingRoomVO	=	ServiceFactory.getMeetingRoomService().queryByID(meetingRoomVO.getMeetingRoomID());
			ServiceFactory.getMeetingRoomService().deleteByID(meetingRoomVO);
		} catch (Exception e) {
			logger.error("MeetingRoomAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	delete	end");
		return	SUCCESS;
	}
	/**
	 * 获取会议室地址目录
	 * @return
	 */
	public ArrayList<AddressVO> getRoomAdressList(){
		ArrayList<AddressVO>  list_address = new ArrayList<AddressVO>();
		try {
			list_address = ServiceFactory.getAddressService().query(new AddressVO(),null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_address;
	}
	public ArrayList<MeetingRoomVO>  getMeetingRoomByAddress(String addressID,Object uvo){
		ArrayList<MeetingRoomVO>  list_room = new ArrayList<MeetingRoomVO>();
		AddressVO advo = new AddressVO();
		MeetingRoomVO mrvo = new MeetingRoomVO();
        ///////////////会议室分级分权 @author:zhangjy///////////////////////////
		UserVO suv = (UserVO)uvo;
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				mrvo.setLevel(true);
				mrvo.setLsql(suv.getLvoids());
			}
		}
        /////////////////////////////////end/////////////////////////////////////
		advo.setAddressID(addressID);
		try {
			mrvo.setAddressVO(advo);
			list_room =	ServiceFactory.getMeetingRoomService().query(mrvo, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_room;
	}
	
	/**
	 * 获取有终端的会议室
	 */
	public ArrayList<MeetingRoomVO> getHaveTerminalMeetingRoomByAddress(String addressID,Object uvo){
		ArrayList<MeetingRoomVO>  list_room = new ArrayList<MeetingRoomVO>();
		AddressVO advo = new AddressVO();
		MeetingRoomVO mrvo = new MeetingRoomVO();
///////////////会议室分级分权 @author:xiongshun///////////////////////////
		UserVO suv = (UserVO)uvo;
		if(MeetingAppConfig.LEVEL_IS_POEN){
			if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
				mrvo.setLevel(true);
				mrvo.setLsql(suv.getLvoids());
			}
		}
        /////////////////////////////////end/////////////////////////////////////
		advo.setAddressID(addressID);
		try {
			mrvo.setAddressVO(advo);
			list_room =	ServiceFactory.getMeetingRoomService().query(mrvo, null);
			
			if(list_room.size()>0)
			{
				for(int i=0;i<list_room.size();i++)
				{
					MeetingRoomVO mro = list_room.get(i);
					
					EquipmentVO ev = new EquipmentVO();
					ev.setMeetingRoomVO(mro);
					ev.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					ArrayList<EquipmentVO> listEqu = ServiceFactory.getEquipmentService().query(ev, null);
					if(listEqu != null && listEqu.size()==0){
						list_room.remove(i);
						i--;
					}
						
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_room;
	}
	
	public ArrayList<MeetingRoomVO> getMeetingRoomWithCenterControl(String addressID){
		ArrayList<MeetingRoomVO>  list_room = new ArrayList<MeetingRoomVO>();
		ArrayList<MeetingRoomVO>  listRoom = new ArrayList<MeetingRoomVO>();
		try {
			ArrayList<EquipmentVO> centerControlList = new ArrayList<EquipmentVO>();
			EquipmentVO centerControlVO = new EquipmentVO();
			centerControlVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);//中控设备类型为2
			centerControlList = new EquipmentServiceImpl().query(centerControlVO,null);

			AddressVO advo = new AddressVO();
			MeetingRoomVO mrvo = new MeetingRoomVO();
			advo.setAddressID(addressID);
			mrvo.setAddressVO(advo);
			list_room =	ServiceFactory.getMeetingRoomService().query(mrvo, null);
			System.out.println(centerControlList.size());
			System.out.println(list_room.size());
			for(int i=0;i<centerControlList.size();i++){
				System.out.println(centerControlList.get(i).getMeetingRoomVO().getMeetingRoomName());
				for(int j=0;j<list_room.size();j++){
					if(centerControlList.get(i).getMeetingRoomVO().getMeetingRoomID().equals(list_room.get(j).getMeetingRoomID())){
						listRoom.add(centerControlList.get(i).getMeetingRoomVO());
					}else{
						//list_room.remove(j);
						//j--;
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRoom;
	}
	
	/*public String importExcel(){
		logger.info("MeetingRoomAction	importExcel	begin");
		
		try {
			    //TODO:上传
			    String savePath = "/file/upload/ceshi.xls";
	    		String pathname = ServletActionContext.getServletContext().getRealPath("/")+savePath;
	    		
	    		PrintWriter out = ServletActionContext.getResponse().getWriter();
	    		readExcel(pathname,out);
		} catch (Exception e) {
			logger.error("MeetingRoomAction	importExcel	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomAction	importExcel	end");
		return	SUCCESS;
	}
	
	public void readExcel(String pathname, PrintWriter out) {
	     try {
	    	 
	    	 //打开文件
	    	 Workbook book = Workbook.getWorkbook(new File(pathname)) ;
	    	 //取得第一个sheet
	    	 Sheet sheet = book.getSheet(0);
	    	 //取得行数
	    	 int rows = sheet.getRows();
	    	 for(int i = 1; i < rows; i++) {//第一行是表头略过
	    	 Cell [] cell = sheet.getRow(i);
	    	 for(int j=0; j<cell.length; j++) {
	    		 //getCell(列，行)
	    		 out.print(sheet.getCell(j, i).getContents());
	    	   }
	    	 }
	    	 	//关闭文件
	    	 	book.close();
	    	 } catch (BiffException e) {
	    		 e.printStackTrace();
	    	 } catch (IOException e) {
	    		 e.printStackTrace();
	    	 } 
	    }*/
	
	
	
	public static void getexcle(String filePathAndName){
		
	        ImportUtil.getExcelContent(filePathAndName);
		
	}
	
	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}



	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}



	public ArrayList<MeetingRoomVO> getMeetingRoomVOList() {
		return meetingRoomVOList;
	}



	public void setMeetingRoomVOList(ArrayList<MeetingRoomVO> meetingRoomVOList) {
		this.meetingRoomVOList = meetingRoomVOList;
	}
	
	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public ArrayList<AddressVO> getAddressVOList() {
		return addressVOList;
	}

	public void setAddressVOList(ArrayList<AddressVO> addressVOList) {
		this.addressVOList = addressVOList;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public MeetingRoomInterfaceVO getMrVO() {
		return mrVO;
	}

	public void setMrVO(MeetingRoomInterfaceVO mrVO) {
		this.mrVO = mrVO;
	}
	
	
	
}
