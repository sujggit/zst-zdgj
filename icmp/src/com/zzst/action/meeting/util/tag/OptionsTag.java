package com.zzst.action.meeting.util.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.zzst.action.meeting.dictionary.DictionaryHelper;
import com.zzst.action.meeting.util.BaseInfoHelp;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.DataInterfaceEnum;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.EquipmentMaintainEnum;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.McuCtrlParameterEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;

/**
 * 
 * @author xiamj
 *
 */
public class OptionsTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//设备类型枚举相关 add by zhangdq on 20140121
	public static final	String	equipmentEnum 	= "equipmentEnum";

	public static final String  equipmentName_ = "equipmentName_";
	public static final String  equipmentModel_ = "equipmentModel_";
	
	public static final	String	meetingRoomStatus 	= "meetingRoomStatus";
	public static final	String	meetingRoomType 	= "meetingRoomType";
	public static final	String	userStatus 			= "userStatus";
	public static final	String	equipmentStatus 			= "equipmentStatus";
	public static final	String	equipmentType 			= "equipmentType";
	public static final	String	equipment_Mcu_Model 		= "equipment_Mcu_Model";
	public static final	String	equipment_Terminal_Model 	= "equipment_Terminal_Model";
	public static final	String	equipment_Centercontrol_Model 	= "equipment_Centercontrol_Model";
	public static final	String	equipment_Microphpne_Model 	= "equipment_Microphpne_Model";
	public static final	String	equipment_Audio_Model		= "equipment_Audio_Model";
	public static final	String	meetingControlMenu 	= "meetingControlMenu";
	public static final	String	dicType 	= "dicType";
	//换肤模板 add by liujf 20131126
//	public static final String  changeCSS = "changeCSS";
	
	//提取mcu控制参数
	public static final String mcuCtrlParameter    = "mcuCtrlParameter";
	public static final String dialingDirection    = "dialingDirection";
	public static final String dialingType         = "dialingType";
	public static final String maxPesolution       = "maxPesolution";
	public static final String aliasType           = "aliasType";
	public static final String videoTreaty         = "videoTreaty";
	public static final String speed               = "speed";
	public static final String cascadeRole         = "cascadeRole";
	public static final String radioTreaty         = "radioTreaty";
	
	///add by chenshuo
	public static final String confModel = "confModel";
	public static final String otherEquipment = "otherEquipment";
	public static final String equipmentMaintainStatus = "equipmentMaintainStatus";//设备维护信息状态
	public static final String otherModel = "otherModel";//其他设备型号
	public static final String importStatus = "importStatus";//数据导入操作状态
	
	
	
	//add by yangyi
	public static final	String	equipment_Enc_Model 	= "equipment_Enc_Model";
	public static final	String  equipment_QBox_Model    = "equipment_QBox_Model";
	
	public static final	String	meeting_Type 		= "meetingType";
	public static final	String	meeting_Status 		= "meetingStatus";
	public static final	String	mcu_Conferen_Profiles 	= "mcuConferenProfiles";
	public static final	String	log_type 		= "logType";
	public static final	String	conferenceControlMenu_type 		= "controlMenu";	
	
	
	//控制部分使用
	public static final	String	mcu_ConferenProfiles 	= "conferenProfiles";
	public static final	String	cc_screent_model 		= "screentModel";
	public static final	String	centerControl_equipment_type 		= "ccequipmentType";
	
	//基础配置部分 add by yangyi
	public static final	String baseInfo_type = "baseInfoType";
	public static final	String communicationConvention = "communicationConvention";
	
	//审批部分使用 addby chenshuo
	public static final String applyStatus = "applyStatus";
	public static final String createUser = "createUser";
	public static final String department = "department";
	public static final String applyFlowType = "applyFlowType";
	public static final String isEndFlow = "isEndFlow";
	public static final String parentApplyFlow = "parentApplyFlow";
	public static final String apply = "apply";
	public static final String flowType="flowType";
	public static final String natChange="natChange";
	
	//级联会部分使用 addby chenshuo
	public static final String linkMeetingModel = "linkMeetingModel";
	
		
	/**
	 *系统维护部分使用add by duting
	 *只限于中航工业项目使用，后期调整
	 *begin 
	 */
	public static final String equipmentOpenStatus = "equipmentOpenStatus";
	public static final String terminalLinkStatus = "terminalLinkStatus";
	public static final String bendiImage = "bendiImage";
	public static final String bendiVoice = "bendiVoice";
	public static final String yunduanImage = "yunduanImage";
	public static final String yuanduanVoice = "yuanduanVoice";
	public static final String shuangliuTest = "shuangliuTest";
	public static final String eqipmentCloseStatus = "eqipmentCloseStatus";
	public static final String netWorkLink = "netWorkLink";
	public static final String ipTel = "ipTel";
	
	/**
	 *系统维护部分使用add by duting  
	 * end
	 */
	/**
	 *add by tanzanlong
	 *数据字典部分
	 *begin 
	 */
	public static final String meetingTime = "meetingTime";
	public static final	String	infoType 	= "infoType";
	public static final String maintenanceStartTime = "maintenanceStartTime";//维保期限
	public static final String meetingServiceType = "meetingServiceType";
	public static final String pollTimeSpan = "pollTimeSpan";
	public static final String MEETING_DEBUG_DURATION = "meetingDebugDuration";
	public static final String CHANGECSS = "changeCSS";//换肤模板
	
	/**
	 * 会议控制页面，控制按钮的枚举：conferenceControlMenu_type
	 * 会议 室类型：meetingRoomType
	 * 会议室状态：meetingRoomStatus
	 * 用户状态：     userStatus
	 * 设备状态：equipmentStatus
	 * 设备类型：equipmentType
	 * mcu设备型号：equipment_Mcu_Model
	 * 终端设备型号：equipment_Terminal_Model
	 * 中控设备型号：equipment_Centercontrol_Model
	 * 话筒型号：equipment_Microphone_Model
	 * mcu会议模板：mcuConferenProfiles
	 * 会议类型：meetingType
	 * 会议状态：meetingStatus
	 * 日志类型：logType
	 * 中控设备大屏模式：screentModel
	 * 告示类型：equipment_Enc_Model
	 * QBox类型：equipment_QBox_Model
	 * 中控基础数据：ccequipmentType
	 * 基础配置类型：baseInfoType
	 * 审批流程状态:applyStatus
	 * 人员：createUser
	 * 部门：department
	 * 审批方式:applyFlowType
	 * 是否为末节点:isEndFlow
	 * 流程节点:parentApplyFlow
	 * 审批流程:apply
	 * 审批类别:flowType
	 * 设备开机：equipmentOpenStatus
	 * 终端连接：terminalLinkStatus
	 * 本地图像：bendiImage
	 * 本地声音：bendiVoice
	 * 远端图像：yunduanImage
	 * 远端声音：yuanduanVoice
	 * 双流测试：shuangliuTest
	 * 设备关机：eqipmentCloseStatus
	 * 网络连接：netWorkLink
	 * IP电话：ipTel
	 * nat转换:natChange
	 * 通信协议：communicationConvention
	 * 建会方式:confModel
	 * 其他设备名称:otherEquipment
	 * 其他设备型号 otherModel
	 * 设备维护状态 equipmentMaintainStatus
	 * 数据导入状态 importStatus
	 * 提取设备类型枚举信息	equipmentEnum
	 * 提取mcu控制参数   getMcuCtrlParameter
	 */
	private String  type;
	
	private String	value;
	/**
	 * "false"时，运行选择空
	 * "true"时，必选
	 */
	private	String	required	;

	


	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			if(this.getType()==null||this.getType().length()<=0){
				out.print("<option>optionType不能为空</option>");
				return TagSupport.EVAL_BODY_AGAIN;
			}
			out.print(getOptionsContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_PAGE;
	}
	
	
	private String	getOptionsContent(){
		String	htm = "";
		if("false".equalsIgnoreCase(this.getRequired())){
			 htm = "<option value='"+Integer.MIN_VALUE+"'>请选择</option>";
		}
//		String param = "";
//		switch(param){
//			case 'a' : htm += getMeetingRoom(); break;
//			//default : 
//		}
		htm +=getMeetingRoom();
		htm +=getUser();
		htm +=getEquipment();
		htm +=getMcuConferenProfiles();
		htm +=getMeetingType();
		htm +=getMeetingStatus();
		htm +=getLogType();
		htm +=getScreen_model();
		htm +=getCCEquipmentTypeType();
		htm +=getBaseInfoType();
		htm +=getApplyInfo();
		htm +=getApply();
		htm +=getFlowType();
		htm +=getCommunicationConvention();
		htm +=getLinkMeetingModel();
		htm +=getInfoType();
		htm +=getMeetingControlMenu();
		htm+=getDictionary();
		htm+=getConfModel();
		htm+=getOtherEquipment();
		htm+=getEquipmentMaintainStatus();
		htm+=getOtherModel();
		htm+=getImportStatus();
		htm+=getMeetingService();
		htm+=getDicType();
		
		htm+=getEquipmentEnum();
		htm+=getEquipmentName_();
		htm+=getEquipmentModel_();
		
		htm+=getMcuCtrlParameter();
		
		return htm;
	}
	
	 /**
	  * 提取mcu控制参数
	  * 
	  **/
	 private String getMcuCtrlParameter(){
			StringBuffer	htm = new StringBuffer();
			
			if(dialingDirection.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getDialingDirection()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(dialingType.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getDialingType()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(maxPesolution.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getMaxPesolution()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(aliasType.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getAliasType()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(videoTreaty.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getVideoTreaty()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(speed.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getSpeed()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(cascadeRole.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getCascadeRole()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			if(radioTreaty.equalsIgnoreCase(this.type)){
				for(String[] s : McuCtrlParameterEnum.getRadioTreaty()){
					if(s==null)	continue;
					htm.append(jointOption(s));
				}
			}
			return htm.toString();
		
		}
	
	
	/**
	 * 提取设备类型数据字典
	 * 
	 **/
	 private String getEquipmentEnum(){
		StringBuffer	htm = new StringBuffer();
		if(equipmentEnum.equalsIgnoreCase(this.type)){
			try {
				DictionaryEquipmentVO dictionaryEquipmentVO = new DictionaryEquipmentVO();
				dictionaryEquipmentVO.setParentID(DateBaseEnum.Default_ID);
				ArrayList<DictionaryEquipmentVO> list	=	ServiceFactory.getDictionaryEquipmentService().queryByPid(dictionaryEquipmentVO, null);
				for(DictionaryEquipmentVO s : list){
					htm.append( "<option style='width:auto'  value='"+s.getDicID()+"'");
					 if(s.getDicID()!=null&&s.getDicID().equalsIgnoreCase(this.value)){
						 htm.append( " selected ");	 
					 }
					 htm.append( ">"+s.getDicName()+"</option>");
				}
			} catch (Exception e) {
			}
		}
		return htm.toString();
	}
	
	 private String getEquipmentName_(){
			StringBuffer	htm = new StringBuffer();
			if(equipmentName_.equalsIgnoreCase(this.type)){
				try {
					DictionaryEquipmentVO dictionaryEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(this.value);
					DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
					dEquipmentVO.setParentID(dictionaryEquipmentVO.getParentID());
					ArrayList<DictionaryEquipmentVO> list	=	ServiceFactory.getDictionaryEquipmentService().queryByPid(dEquipmentVO, null);
					for(DictionaryEquipmentVO s : list){
						htm.append( "<option style='width:auto'  value='"+s.getDicID()+"'");
						 if(s.getDicID()!=null&&s.getDicID().equalsIgnoreCase(this.value)){
							 htm.append( " selected ");	 
						 }
						 htm.append( ">"+s.getDicName()+"</option>");
					}
				} catch (Exception e) {
				}
			}
			return htm.toString();
		}
	 
	 private String getEquipmentModel_(){
			StringBuffer	htm = new StringBuffer();
			if(equipmentModel_.equalsIgnoreCase(this.type)){
				try {
					ArrayList<DictionaryEquipmentVO> dList = ServiceFactory.getDictionaryEquipmentService().queryByDicValue(Integer.parseInt(value), null);
					DictionaryEquipmentVO dictionaryEquipmentVO = new DictionaryEquipmentVO();
					dictionaryEquipmentVO.setParentID(dList.get(0).getParentID());
					ArrayList<DictionaryEquipmentVO> list	=	ServiceFactory.getDictionaryEquipmentService().queryByPid(dictionaryEquipmentVO, null);
					for(DictionaryEquipmentVO s : list){
						htm.append( "<option style='width:auto'  value='"+s.getDicID()+"'");
						 if(s.getDicValue()==Integer.parseInt(value)){
							 htm.append( " selected ");	 
						 }
						 htm.append( ">"+s.getDicName()+"</option>");
					}
				} catch (Exception e) {
				}
			}
			return htm.toString();
		}
	
	/***
	 * 提取数据字典 ;
	 * 
	 * */
	 private String getDictionary(){
		StringBuffer	htm = new StringBuffer();
		
		if(meetingTime.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		if( maintenanceStartTime.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		if( pollTimeSpan.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		  
		if( MEETING_DEBUG_DURATION.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		
		if( CHANGECSS.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	
	}
	
	/***
	 * 提取基础配置类型
	 * 
	 */
	private String getBaseInfoType(){
		StringBuffer	htm = new StringBuffer();
		if(baseInfo_type.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoEnum.getBaseInfoType()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	
	private String getCommunicationConvention(){
		StringBuffer	htm = new StringBuffer();
		if(communicationConvention.equalsIgnoreCase(this.type)){
			for(String[] s : EquipmentEnum.getCommunicationConvention()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	/**
	 * 提取日志类型
	 * @return
	 */
	private String getCCEquipmentTypeType(){
		StringBuffer	htm = new StringBuffer();
		if(centerControl_equipment_type.equalsIgnoreCase(this.type)){
			for(String[] s : CenterControlEnum.getEquipmentType()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	/**
	 * 提取大屏模式列表
	 * @return
	 */
	private String getScreen_model(){
		StringBuffer	htm = new StringBuffer();
		if(cc_screent_model.equalsIgnoreCase(this.type)){
			String[] str = null;
			if(value!=null&&value.length()>0){
				str = value.split(",");
			}
			CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject(str[0]);
			ExcuteResultVO resultVO = obj.viewScreentModelList(MeetingAppConfig.CC_DEF_ID);
			if(resultVO != null && resultVO.isSuccess()){
				ViewScreentVO vsVO = (ViewScreentVO)resultVO.getObject();
				if(vsVO.getAllModel()!=null){
					for(int i=0;i<vsVO.getAllModel().length;i++){
						htm.append( "<option value='"+vsVO.getAllModel()[i][0]+"'");
						if(str.length==2&&str[1]!=null&&str[1].length()>0&&str[1].equalsIgnoreCase(vsVO.getAllModel()[i][0])){
							htm.append( " selected ");	 
						 }
						htm.append( ">"+vsVO.getAllModel()[i][1]+"</option>"); 
					}
				}
			}
		}
		return htm.toString();
	}
	
	/**
	 * 提取日志类型
	 * @return
	 */
	private String getLogType(){
		StringBuffer	htm = new StringBuffer();
		if(log_type.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoHelp.getLogType()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	/**modifyby chenshuo 2012 8-23
	 * 提取会议状态
	 * @return
	 */
	private String getMeetingStatus(){
		StringBuffer	htm = new StringBuffer();
		if(meeting_Status.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoHelp.getMeetingStatus()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		} 
		return htm.toString();
	}
	
	/***
	 * 提取huiyi配置按钮类型
	 * 
	 */
	private String getMeetingControlMenu(){
		StringBuffer	htm = new StringBuffer();
		if(meetingControlMenu.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoHelp.getMeetingControlMenu()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	/**
	 * 提取会议类型
	 * @return
	 */
	private String getMeetingType(){
		StringBuffer	htm = new StringBuffer();
		if(meeting_Type.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoHelp.getMeetingType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		} 
		return htm.toString();
	}
	
	
	/**
	 * 提取mcu建会模板
	 * @return
	 */
	private String getMcuConferenProfiles(){
		StringBuffer	htm = new StringBuffer();
		if(mcu_Conferen_Profiles.equalsIgnoreCase(this.type)){
			//for(String[] s : MeetingDetailEnum.getMcuConferenProfiles()){
			for(String[] s : MeetingAppConfig.getMcuProfiles()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		} 
		return htm.toString();
	}
	
	
	
	/**
	 * 提取设备相关信息
	 * @return
	 */
	private String getEquipment(){
		StringBuffer	htm = new StringBuffer();
		if(equipmentStatus.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getTerminalStatus()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(equipment_Mcu_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getMcuModel()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(equipment_Terminal_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getTerminalModel()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(equipment_Centercontrol_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getCenterControl()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
			 
			
		}else if(equipment_Microphpne_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getMicrophone()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
			 
			//modify by chenshuo
		}
		else if(equipmentType.equalsIgnoreCase(this.type)){
			 for(String[] s : BaseInfoHelp.getEquipmentTypeNew()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(equipment_Enc_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getEncType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(equipment_QBox_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getQBoxType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}
		else if(equipment_Audio_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getAudio()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
			 
		}

		
		return htm.toString();
	}
	
	/**
	 * 提取人员相关信息
	 * @return
	 */
	private String getUser(){
		StringBuffer	htm = new StringBuffer();
		if(userStatus.equalsIgnoreCase(this.type)){
			 for(String[] s : UserEnum.getUserStatus()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}
		return htm.toString();
	}
	
	/**
	 * 提取会议室相关信息
	 * @return
	 */
	private String getMeetingRoom(){
		StringBuffer	htm = new StringBuffer();
		if(meetingRoomStatus.equalsIgnoreCase(this.type)){
			 for(String[] s : MeetingRoomEnum.getMeetingRooomStatus()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}else if(meetingRoomType.equalsIgnoreCase(this.type)){
			 for(String[] s : BaseInfoHelp.getMeetingRoomType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			 }
		}
		return htm.toString();
	}
	
	private String getMeetingService(){
		StringBuffer	htm = new StringBuffer();
		
		if(meetingServiceType.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		
		                     
		return htm.toString();
	}
	
	private String getApplyInfo(){
		StringBuffer htm = new StringBuffer();
		if( applyStatus.equalsIgnoreCase(this.type)){
			for( String[] s : ApplyEnum.getApplyStatus()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	private String getApply(){
		StringBuffer htm = new StringBuffer();
		if( apply.equalsIgnoreCase(this.type)){
			for( String[] s : TagHelp.getApply()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	//addby chenshuo 提取审批流程类型
	private String getFlowType(){
		StringBuffer htm = new StringBuffer();
		if( flowType.equalsIgnoreCase(this.type)){
			for( String[] s : ApplyEnum.flowType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	//addby chenshuo 提取消息类型

	private String getInfoType(){
		 StringBuffer htm = new StringBuffer();
		if( infoType.equalsIgnoreCase(this.type)){
			for( final String[] s : InformationEnum.getInfoType()){
				 if(s==null)	continue;
				 htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	//addby chenshuo  提取级联会模板组
	private String getLinkMeetingModel(){
		StringBuffer htm = new StringBuffer();
		if( linkMeetingModel.equalsIgnoreCase(this.type)){
			if( MeetingAppConfig.getLinkMcuProfiles() != null ){
				for( String[] s : MeetingAppConfig.getLinkMcuProfiles()){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	//addby chenshuo 提取建会方式
	private String getConfModel(){
		StringBuffer htm = new StringBuffer();
		if( confModel.equalsIgnoreCase(this.type)){
			if( McuCascademodelEnum.getConfModel() != null ){
				for( String[] s : McuCascademodelEnum.getConfModel() ){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	private String getOtherEquipment(){
		StringBuffer htm = new StringBuffer();
		if( otherEquipment.equalsIgnoreCase(this.type)){
			if( EquipmentEnum.getOtherType() != null ){
				for( String[] s : EquipmentEnum.getOtherType()  ){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	private String getEquipmentMaintainStatus(){
		StringBuffer htm = new StringBuffer();
		if( equipmentMaintainStatus.equalsIgnoreCase(this.type)){
			if( EquipmentMaintainEnum.getEquipmentMaintainStatus() != null ){
				for( String[] s : EquipmentMaintainEnum.getEquipmentMaintainStatus()  ){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	private String getImportStatus(){
		StringBuffer htm = new StringBuffer();
		if( importStatus.equalsIgnoreCase(this.type)){
			if( DataInterfaceEnum.getDataInterfaceStatus()!= null ){
				for( String[] s : DataInterfaceEnum.getDataInterfaceStatus()  ){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	
	private String getOtherModel(){
		StringBuffer htm = new StringBuffer();
		if( otherModel.equalsIgnoreCase(this.type)){
			if( EquipmentEnum.getOtherModel() != null ){
				for( String[] s : EquipmentEnum.getOtherModel()  ){
					 if(s==null)	continue;
					 htm.append(jointOption(s));
				}
			}
		}
		return htm.toString();
	}
	
	
	private String jointOption(String[] s){
		StringBuffer sb = new StringBuffer();
		sb.append( "<option style='width:auto'  value='"+s[0]+"'");
		 if(s[0]!=null&&s[0].equalsIgnoreCase(this.value)){
			 sb.append( " selected ");	 
		 }
		 sb.append( ">"+s[1]+"</option>"); 
		 return sb.toString();
	}
	
	/**
	 * 提取数据字典类型
	 * @return
	 */
	private String getDicType(){
		StringBuffer	htm = new StringBuffer();
		if(dicType.equalsIgnoreCase(this.type)){
			for(String[] s : DictionaryEnum.getDicType()){
				if(s==null)	continue;
				htm.append(jointOption(s));
			}
		}
		return htm.toString();
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}
}