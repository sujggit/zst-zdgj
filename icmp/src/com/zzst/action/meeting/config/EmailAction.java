package com.zzst.action.meeting.config;

import java.util.ArrayList;

import com.gsiec.cjf.system.CjfAction;
import com.zzst.action.meeting.util.BaseInfoHelp;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.config.EmailVO;
import com.zzst.service.meeting.baseinfo.BaseInfoService;
import com.zzst.service.meeting.baseinfo.BaseInfoServiceImpl;

public class EmailAction extends CjfAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmailVO emailVO =new EmailVO();

	//添加邮件信息
	public String addEmailBefore(){
		BaseInfoService biService = new BaseInfoServiceImpl();
		
		emailVO.setFormat(MeetingAppConfig.MAIL_FORMAT);
		//emailVO.setFormat("$1会议，将于$2到$3在$4召开，请准时参加！");
		emailVO.setIsEffective("1");
		
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_EMAIL);
		
		ArrayList<BaseInfoVO> baseInfoVOList = new ArrayList<BaseInfoVO>();
		
		try {
			baseInfoVOList = biService.query(baseInfoVO, getPageControler());
			
			for (BaseInfoVO baseInfo : baseInfoVOList) {
				if(BaseInfoEnum.EMAIL_ISEFFECT.equals(baseInfo.getDescription())){
					emailVO.setIsEffective(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_ADDRESS.equals(baseInfo.getDescription())){
					emailVO.setEmailAddress(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_SMTP.equals(baseInfo.getDescription())){
					emailVO.setSmtp(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_SMTP_PORT.equals(baseInfo.getDescription())){
					emailVO.setSmtpPort(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_USERNAME.equals(baseInfo.getDescription())){
					emailVO.setUserName(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_PASSWORD.equals(baseInfo.getDescription())){
					emailVO.setPassWord(baseInfo.getInfoValue());
				}else if(BaseInfoEnum.EMAIL_FORMAT.equals(baseInfo.getDescription())){
					emailVO.setFormat(baseInfo.getInfoValue());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	private BaseInfoVO creatBaseInfoVO(String type,String name,String value,String description){
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		
		baseInfoVO.setInfoType(type);
		baseInfoVO.setInfoName(name);
		baseInfoVO.setInfoValue(value);
		baseInfoVO.setDescription(description);
		
		return baseInfoVO;
	}
	
	public String addEmail(){
		ArrayList<BaseInfoVO> baseInfoVOs = new ArrayList<BaseInfoVO>();
		
		BaseInfoService baseInfoService = new BaseInfoServiceImpl();
		
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_EMAIL);
		
		if("0".equals(emailVO.getIsEffective())){
			baseInfoVO.setDescription(BaseInfoEnum.EMAIL_ISEFFECT);
		}
		
		try {
			baseInfoService.delete(baseInfoVO);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//TODO 定义邮件type
		baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "是否有效", emailVO.getIsEffective(),BaseInfoEnum.EMAIL_ISEFFECT));
		if("1".equals(emailVO.getIsEffective())){
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "电子邮箱地址", emailVO.getEmailAddress(),BaseInfoEnum.EMAIL_ADDRESS));
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "发信服务器地址", emailVO.getSmtp(),BaseInfoEnum.EMAIL_SMTP));
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "发信服务器端口", emailVO.getSmtpPort(),BaseInfoEnum.EMAIL_SMTP_PORT));
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "邮箱用户名", emailVO.getUserName(),BaseInfoEnum.EMAIL_USERNAME));
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "邮箱密码" ,emailVO.getPassWord(),BaseInfoEnum.EMAIL_PASSWORD));
			baseInfoVOs.add(creatBaseInfoVO(BaseInfoEnum.TYPE_BASEINFO_EMAIL, "邮件格式" ,emailVO.getFormat(),BaseInfoEnum.EMAIL_FORMAT));
		}
		
		try {
			for (BaseInfoVO baseInfo : baseInfoVOs) {
				baseInfoService.add(baseInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		BaseInfoHelp.getEmailCon();//更新缓存
		
		return "success";
	}

	public void setEmailVO(EmailVO emailVO) {
		this.emailVO = emailVO;
	}

	public EmailVO getEmailVO() {
		return emailVO;
	}
}
