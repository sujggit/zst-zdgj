package com.zzst.action.meeting.util.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.zzst.action.meeting.dictionary.DictionaryHelper;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.DataInterfaceEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.EquipmentMaintainEnum;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.McuCtrlParameterEnum;
import com.zzst.model.enums.MeetingControlMenuEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;


/**
 *@Description
 *@date 2011-6-21下午05:17:54
 *@author ryan
 */
public class LableTag extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	/**
	 * 会议室类型：meetingRoomType
	 * 会议室状态：meetingRoomStatus
	 * 用户状态：     userStatus
	 * 设备状态：equipmentStatus
	 * 设备类型：equipmentType
	 * mcu设备型号：equipment_Mcu_Model
	 * 终端设备型号：equipment_Terminal_Model
	 * 中控设备型号：equipment_Centercontrol_Model
	 * mcu会议模板：mcuConferenProfiles
	 * 会议类型：meetingType
	 * 会议状态：meetingStatus
	 * 日志类型：logType
	 * 告示类型：equipment_Enc_Model
	 * QBox类型：equipment_QBox_Model
	 * 中控基础数据：ccequipmentType
	 * 审批流程状态:applyStatus
	 * 人员：createUser
	 * 部门：department
	 * 审批方式:applyFlowType
	 * 是否为末节点:isEndFlow
	 * 流程节点:parentApplyFlow
	 * 流程类别:flowType
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
	 * 设备维护状态:equipmentMaintainStatus
	 * 其他设备名称 otherEquipment
	 * 其他设备型号otherModel
	 * 数据导入状态 importStatus
	 * 数据字典中数据状态dicType
	 * 会议模式：linkMeetingModel
	 */
	private String  type;
	private String	value;
	
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			if(this.getType()==null||this.getType().length()<=0){
				out.print("type属性不能为空");
				return TagSupport.EVAL_BODY_AGAIN;
			}
			out.print(getLableContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}
	
	private String	getLableContent(){
		if(OptionsTag.equipmentEnum.equalsIgnoreCase(this.type)){
			try {
				ArrayList<DictionaryEquipmentVO> list = new ArrayList<DictionaryEquipmentVO>();
				if(this.value!=null&&this.value.length()>0)
					list	=ServiceFactory.getDictionaryEquipmentService().queryByDicValue(Integer.parseInt(value), null);
				if(list.size()==0) return "&nbsp;";
				return list.get(0).getDicName();
			} catch (Exception e) {
				
			}
		}else if(OptionsTag.linkMeetingModel.equalsIgnoreCase(this.type)){
				if( MeetingAppConfig.getLinkMcuProfiles() != null ){
					for( String[] s : MeetingAppConfig.getLinkMcuProfiles()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(value)){
							 return s[1];
						 }
					}
				}
		}else if(OptionsTag.centerControl_equipment_type.equalsIgnoreCase(this.type)){
			for(String[] s : CenterControlEnum.getEquipmentType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.dicType.equalsIgnoreCase(this.type)){
			for(String[] s : DictionaryEnum.getDicType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.log_type.equalsIgnoreCase(this.type)){
			for(String[] s : LogEnum.getLogType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		} else if(OptionsTag.meetingTime.equalsIgnoreCase(this.type)){//add by tanzanlong
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(DictionaryEnum.meetingTime);				
		for(String[] s :DictionaryHelper.getDictionary(dictionaryVO) ){
			 if(s==null)	continue;
			 if(s[0].equalsIgnoreCase(value)){
				 return s[1];
			 }
		 }
	}else if(OptionsTag.meeting_Status.equalsIgnoreCase(this.type)){
			for(String[] s : MeetingDetailEnum.getMeetingStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.meeting_Type.equalsIgnoreCase(this.type)){
			for(String[] s : MeetingDetailEnum.getMeetingType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.mcu_Conferen_Profiles.equalsIgnoreCase(this.type)){
			for(String[] s : MeetingAppConfig.getMcuProfiles()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
			
		}else if(OptionsTag.userStatus.equalsIgnoreCase(this.type)){
			for(String[] s : UserEnum.getUserStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.meetingRoomStatus.equalsIgnoreCase(this.type)){
			 for(String[] s : MeetingRoomEnum.getMeetingRooomStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.meetingRoomType.equalsIgnoreCase(this.type)){
			 for(String[] s : MeetingRoomEnum.getMeetingRooomType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipmentStatus.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getTerminalStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipmentType.equalsIgnoreCase(this.type)){
//			 for(String[] s : EquipmentEnum.getEquipmentType()){
//				 if(s==null)	continue;
//				 if(s[0].equalsIgnoreCase(value)){
//					 return s[1];
//				 }
//			 }
			try {
				ArrayList<DictionaryEquipmentVO> list = new ArrayList<DictionaryEquipmentVO>();
				if(this.value!=null&&this.value.length()>0)
					list	=ServiceFactory.getDictionaryEquipmentService().queryByDicValue(Integer.parseInt(value), null);
				if(list.size()==0) return "&nbsp;";
				return list.get(0).getDicName();
			} catch (Exception e) {
			}
		}else if(OptionsTag.equipment_Mcu_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getMcuModel()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipment_Terminal_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getTerminalModel()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipment_Terminal_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getTerminalModel()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipment_Enc_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getEncType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipment_QBox_Model.equalsIgnoreCase(this.type)){
			 for(String[] s : EquipmentEnum.getQBoxType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.baseInfo_type.equalsIgnoreCase(this.type)){
			for(String[] s : BaseInfoEnum.getBaseInfoType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.equipment_Centercontrol_Model.equalsIgnoreCase(this.type)){
			for(String[] s : EquipmentEnum.getCenterControl()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.createUser.equalsIgnoreCase(this.type)){
			for(String[] s :  TagHelp.getUsers()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.department.equalsIgnoreCase(this.type)){
			for(String[] s :  TagHelp.getDepartments()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.applyFlowType.equalsIgnoreCase(this.type)){
			for(String[] s :  ApplyEnum.getApplyFlowType()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.isEndFlow.equalsIgnoreCase(this.type)){
			for(String[] s :  ApplyEnum.isEndFlow()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.parentApplyFlow.equalsIgnoreCase(this.type)){
			for(String[] s :  TagHelp.getApplyFlowByID()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
			return "开始";
			
		}else if(OptionsTag.flowType.equalsIgnoreCase(this.type)){
			for(String[] s :  ApplyEnum.flowType()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.equipmentOpenStatus.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getEquipmentStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}
		else if(OptionsTag.terminalLinkStatus.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getTerminalLinkStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.bendiImage.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getBendiImageStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.bendiVoice.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getBendiVoiceStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.yunduanImage.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getYuanduanImageStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.yuanduanVoice.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getYuanduanVoiceStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}
		else if(OptionsTag.shuangliuTest.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getShuangliuTestStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.eqipmentCloseStatus.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getEquipmentCloseStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.netWorkLink.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getNetWorkLinkStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.ipTel.equalsIgnoreCase(this.type)){
			for(String[] s :  MeetingRoomMaintain.getIpTelStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.natChange.equalsIgnoreCase(this.type)){
			for(String[] s :  ApplyEnum.natStatus()){
				if(s==null) continue;
				if(s[0].equalsIgnoreCase(value)){
					return s[1];
				}
			}
		}else if(OptionsTag.communicationConvention.equalsIgnoreCase(this.type)){
			for(String[] s : EquipmentEnum.getCommunicationConvention()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.meetingControlMenu.equalsIgnoreCase(this.type)){
			for(String[] s : MeetingControlMenuEnum.getPubMenuList()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.infoType.equalsIgnoreCase(this.type)){
			for(String[] s :InformationEnum.getInfoType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if(OptionsTag.confModel.equalsIgnoreCase(this.type)){
			for(String[] s :McuCascademodelEnum.getConfModel()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.maintenanceStartTime.equalsIgnoreCase(this.type)){
			DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(this.type);
			for(String[] s : DictionaryHelper.getDictionary(dictionaryVO)){
				if(s==null)	continue;
				if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			}
		}else if( OptionsTag.equipmentMaintainStatus.equalsIgnoreCase(this.type)){
			for(String[] s :EquipmentMaintainEnum.getEquipmentMaintainStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.otherEquipment.equalsIgnoreCase(this.type)){
			for(String[] s :EquipmentEnum.getOtherType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.otherModel.equalsIgnoreCase(this.type)){
			for(String[] s :EquipmentEnum.getOtherModel()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.importStatus.equalsIgnoreCase(this.type)){
			for(String[] s :DataInterfaceEnum.getDataInterfaceStatus()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.dialingDirection.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getDialingDirection()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.dialingType.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getDialingType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.maxPesolution.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getMaxPesolution()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.aliasType.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getAliasType()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.videoTreaty.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getVideoTreaty()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.speed.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getSpeed()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.cascadeRole.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getCascadeRole()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}else if( OptionsTag.radioTreaty.equalsIgnoreCase(this.type)){
			for(String[] s :McuCtrlParameterEnum.getRadioTreaty()){
				 if(s==null)	continue;
				 if(s[0].equalsIgnoreCase(value)){
					 return s[1];
				 }
			 }
		}
		
		
		
		
		return "&nbsp;";
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
}