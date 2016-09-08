package com.zzst.action.meeting.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import com.gsiec.cbf.system.CbfConfig;
import com.zzst.action.meeting.util.authorization.AuthorHelper;
import com.zzst.action.meeting.util.task.ScanDateState;
import com.zzst.action.meeting.util.tools.Eryptogram;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.meeting.dwr.CallPollThread1;
import com.zzst.model.datebase.DatebaseVO;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
 
/**
 * 
 * package：com.zzst.swh.util
 * desc：
 * date：	Sep 14, 2010
 * user：	
 */
public class MeetingAppConfig extends CbfConfig {
	public static	boolean db_normal = false;//数据库是否正常连接，没有正常连接不执行业务部分的加载工作。
	
	//服务器信息
	public	static	String	SYS_NAME="";//应用服务器操作系统
	public	static	String	webservice_ip		=	""; //应用服务器IP地址
	public	static	String		PROJECT_SRC		=	"";//工程跟目录 如：D:/..../deploy/icmp.war/
	
    public static int SysMeetTime=30;//管理立即召开时间时间段。检测此时间段内的会议室是否被占用。
	public		static		boolean			SynchroStatus		= false;//是否启动接口同步线程
	public		static		long			SynchroDBDataTime		= 30;//标准接口--数据周期（秒）
	
	/**
	 * 日志保存时长
	 */
	public		static		int				CLEAR_LOG_PERIOD = 360		;//日志存放时长，单位天
	
	/**
	 * 配置检测设备状态的线程参数
	 */
	public	static	int		EQUIPMENTPARAM_NUM 	 = -1		;//不大于0即为使用默认
	public	static	int		EQUIPMENTPARAM_SLEEP = -1		;//以秒为单位	不大于0即使用默认
	
	/**
	 * 授权相关--------开始
	 */
	public		static		boolean			authorizatione		= true;//是否有授权。时间与用户数都为false，则为false。在登录时提醒。
	public		static		Timestamp		authorization_date  		;//授权时长
	public		static		int				authorization_mcu_num	=1		;//授权mcu数
	public		static		int				authorization_ter_num	=1		;//授权终端数
	public		static		int				authorization_cc_num	=1		;//授权中控数
	public		static		int				authorization_room_num	=1		;//授权会议室数
	public		static		int				authorization_user_num	=1		;//授权用户数量
	/**
	 * 授权相关--------结束
	 */
	
	public		static		String		EXPORT_SRC		=	"file/export/";//导出文件目录
	public		static		String		STATISTICS_SRC		=	"file/statistic/";//统计图片
	public		static		String		STATISTICS_COUNT_NAME = "count";//生成使用次数统计的文件名称
 	public		static		String		STATISTICS_TIME_NAME = "time";//生成使用时长统计的文件名称
 	public		static		int			STATISTICS_IMAGE_WIDTH = 1000;//生成统计图片的宽
 	public		static		int			STATISTICS_IMAGE_HEIGTH = 600;//生成统计图片的高
 	public		static		long		meeting_ent_time         =   5*60*1000;//会议结束前，告警提示。最长支持提前60分钟提醒
 	/**
 	 * 
 	 * 
 	 * desc：
 	 * date：	2013 -3-1
 	 * user：	tanzanlong
 	 * 用于放置帮助文件的目录；
 	 */
 	public      static      String      HELPER_SRC           ="file/helper";
 	
 	//本地中控IP
 	public		static		String 		LOCAL_CCIP 	= 	"10.255.255.19";//本地中控IP
 	
 	//E.164——IP参数
 	public		static		String 		E164_IP 	= 	"0.0.0.0";//E.164模式下IP的值
 	
 	//轮询线程缓存
 	public  static Map<String, CallPollThread1> pollMap = new HashMap<String, CallPollThread1>();
 	
 	//会议控制菜单状态缓存
 	public	static Map<String, MeetingControlStatus> meetingControlStatusMap = new HashMap<String, MeetingControlStatus>();
 	
 	//轮询状态
 	public	static String POLL_START = "poll_start";
 	public  static String POLL_SUSPEND = "poll_suspend";
 	public  static String POLL_STOP = "poll_stop";
 	
 	private  	Document p_document = null; //
 	public		static		int 		QUERY_VIEW_START_HOUR 		= 	9;//会议预约开始时间
	public		static		int 		QUERY_VIEW_END_HOUR	 		= 	18;//会议预约结束时间
	public		static		long		MeetingBook_NextDelays	=	10 *60*1000l ;
 	public		static		String		CONTENT_PATH = "/icmp";
 	public		static		String		CC_DEF_ID = "1";//中控默认ID
 	public		static		String		TASK_PERIOD_HOUR = "2";//每天执行时间--小时 0-23
 	public		static		String		refresh_time		=	"10000"; //页面刷新频率
 	public		static		String		meeting_space_time		=	"30"; //预订会议最小时间段 单位：分钟
 	public		static		String		meeting_start_time		=	"0"; //会议开始时间比实际会议的开始时间默认提前时间段。 单位：分钟
 	public		static		String		COPYRIGHT;
 	public		static		boolean		conference_approved_status		=	false; //预订会议是否需要审批
 	
 	public		static		int			def_px = 100;//大屏监控显示尺寸--默认基数
 	
 	public		static		String		webSkinStyle	=	"def"; //缓存用户选择皮肤
 	
 	public      static      boolean      ifCallInOrNot = true;//是否允许终端主动呼MCU false-不允许  true-允许
 	
 	
 	//告示设备相关配置===========begin
 	public		static		String		enc_db_url	=	"jdbc:mysql://10.19.249.2:3306/MediaDB?auotReconnect=true&useUnicode=true&characterEncoding=GB2312"; 
 	public		static		String		enc_db_name	=	"root"; 
 	public		static		String		enc_db_password	=	"1234"; 
 	public		static		String		enc_db_type	=	"mysql"; 
 	public		static		String		enc_serverIP	=	"10.19.249.2"; 
 	public		static		String		enc_serverPort	=	"1234"; 
 	public		static		String		enc_serverName	=	"admin"; 
 	public		static		String		enc_serverPas	=	"1234";
	//告示设备相关配置===========end
 		
 	public		static		String		kst_server_IP	=	"10.116.106.45";// 可视通服务器IP
 	public 		static 		String  	kst_mcu_IP = "10.116.106.48";
 	public 		static 		String 		kst_vlc_IP = "10.116.106.47";
 	
 	//完善短信号码、邮件基本信息
 	public		static		boolean		mail_status		=	true; //系统是否发送mail
 	public		static  	String  	MAIL_SUBNAME = "会议通知";//邮件标题
 	public		static  	String  	MAIL_ADDRESS = "emailAddress";
	public 		static  	String  	MAIL_SMTP = "smtp";
	public 		static  	String  	MAIL_SMTP_PORT = "smtpPort";
	public 		static  	String  	MAIL_USERNAME = "userName";//如xxx@163.com
	public 		static  	String  	MAIL_PASSWORD = "passWord";
	public 		static  	String  	MAIL_FORMAT  =  "$1会议，将于$2到$3在$4召开，请准时参加！";//$1会议，将于$2在$3会议室召开，请相关人士准时参加！
 	
	public		static		Boolean		MEETINGBOOK_EMAIL =	false;
	public		static		Boolean		MEETINGBOOK_SMS	=	false;
	public		static		Boolean		MEETINGBOOK_SERVICE = false;
	public		static		Boolean		MEETING_MANAGE	=	true;
	public		static		Boolean		EQUIPMENT_WANRRANTY = true;
	
	public		static		boolean		sms_status		=	true; //系统是否发送短信
	public		static		boolean		record_status	=	true;
	public		static		boolean		billboard_status	=	true;
	public		static		boolean		meetingservice_status	=	true;
	
	public		static		String		NOTICE_TITLE	=	"设备维护通知";
	public		static 		String		MESSAGE_TYPE_BOOKMEETING = "MESSAGE_TYPE_BOOKMEETING";
	public		static		String		MESSAGE_TYPE_DELBOOKMEETING = "MESSAGE_TYPE_DELBOOKMEETING";
	public 		static		String		MESSAGE_TYPE_MODIFYBOOKMEETING = "MESSAGE_TYPE_MODIFYBOOKMEETING";
	public		static		String		MESSAGE_TYPE_MEETINGEND = "MESSAGE_TYPE_MEETINGEND";
	public		static		String		MESSAGE_TYPE_TEROFFLINE = "MESSAGE_TYPE_TEROFFLINE";
	public		static		String		MESSAGE_TYPE_EQWANRRANTY = "MESSAGE_TYPE_EQWANRRANTY";
	public		static		String		MESSAGE_TYPE_MEETINGDEBUG = "MESSAGE_TYPE_MEETINGDEBUG";

	public		static		String		MESSAGE_TYPE_MEETINGBILLBOARD = "MESSAGE_TYPE_MEETINGBILLBOARD";
	
	public		static		int			billboard_time	=	30;
	//级联会相关常量-start
	//public static String ALIAS_NAME                 =	"子MCU";
 	public static String CONFER_NUMBER              =   "123456";//主会会议ID
 	public static String CASCADEROLE_MASTER         =   "master";//主会
 	public static String CASCADEROLE_SLAVE          =   "slave";//从会
 	public static String ALIAS_TYPE                 =   "323_id";//传输类型
 	public static String ALIAS_TYPE_E164			=	"e164";
 	public static String CALLDIRECTION_OUT          =   "dial_out";//呼出
 	public static String CALLDIRECTION_IN           =	"dial_in";//呼入
 	public static String CALLSITEBEFORE             =   "";//记录上一次被点名者，点名下一个会场时需要对其静音
 	//级联会相关常量-end
	
 	public static String[] profileNames = {};
 	public static String[] profileIds = {};
 	//the key is our profile id, the value is map(key is MCU IP, value is profile id in a MCU) 
 	public  static Map<String, Map<String, String>> profileMap = new HashMap<String, Map<String, String>>();

 	public	static	int	cache_hour = 24;//每天定时提取多少小时的会议信息到内存
 	
 	//系统配置需要常量
 	public static final int AUTO_MUTE = 1;
 	
 	//ldap configuration
 	public static String LDAP_VALID = "0";
 	public static String LDAP_IP = "";
 	public static String LDAP_PORT = "";
 	public static String LDAP_VALID_TEXT = "1";
 	
 	//用户初始密码和重置密码的默认值
 	public static String PWDINIT = "123456";//初始默认密码
 	public static String PWDAUTH = "false";//是否启用密码重视程度 true或false;（涉及密码长度10位及复杂性；登录错误次数）
 	public static int PWDUNLOCKTIMES = 10;//单位：分钟
 	
 	//消息推送间隔时间
 	public static long MessageTime = 60;//消息推送的间隔时间--单位：秒
 	//告警信息开关
 	public static boolean  DataPoll = false;
 	
 	//ftp信息
 	public static String FTP_SERVER="";
 	public static String FTP_USER="";
 	public static String FTP_PSW="";
 	public static String FTP_LOCATION="";
 	public static int	 FTP_PORT ;
 	public static String FILE_LOCATION ="";
 	
 	//是否开启分级分权
 	public static boolean LEVEL_IS_POEN=false;
 	public static String  HOST_LEVEL_ID="-1";
 	//是否分布部署
 	public static boolean LEVEL_DISTRIBUTED_POEN=false;
 	public static String  LEVEL_PARENT_IP="";
 	public static int LEVEL_DISTRIBUTED_TIME = 60;//单位：秒
 	//分布式部署数据库信息
 	public static String FDB_IP="";
 	public static String FDB_USERNAME = "";
 	public static String FDB_PWD = "";
 	public static String FDB_NAME = "";
 	public static String FDB_PORT = "";
 	
 	//是否启用snmp监听终端/MCU信息
 	public static boolean SNMP_POEN=false;
 	
 	public static DatebaseVO dbvo=new DatebaseVO();//备份数据库信息
 	
 	//会议调试时长
 	public static String  MEETING_DEBUG_DURATION = "3";//单位小时，只能是整点
 	
 	public static boolean  CONFERENCE_AUTO_TASK = true;//预约时是否自动建会、自动结束会议（同时删除MCU上的会议）。
 	public static boolean  MCU_POOL = false;//是否启用MCU资源池
 	
 	//administrator密码配置（加密）
 	public static String PWDINITADMIN = "7c5EGIN5";
 	
 	//分屏信息
 public static Map<String,String> layoutMap = new HashMap<String,String>(){
	{
		 put("split_right1_1", MCUConfig.LAYOUT_MODE_1X1);
		 put("split_right2_1", MCUConfig.LAYOUT_MODE_1X2);
		 put("split_right2_2", MCUConfig.LAYOUT_MODE_2X1);
		 put("split_right2_3", MCUConfig.LAYOUT_MODE_1X2HOR);
		 put("split_right2_4", MCUConfig.LAYOUT_MODE_1X2VER);
		 put("split_right2_5", MCUConfig.LAYOUT_MODE_1X2FLEX);
		 put("split_right3_1", MCUConfig.LAYOUT_MODE_1AND2HORUPPER);
		 put("split_right3_2", MCUConfig.LAYOUT_MODE_1AND2HOR);
		 put("split_right3_3", MCUConfig.LAYOUT_MODE_1AND2VER);
		 put("split_right3_4", MCUConfig.LAYOUT_MODE_1AND2HORLFLEX);
		 put("split_right3_5", MCUConfig.LAYOUT_MODE_1AND2HORRFLEX);
		 put("split_right3_6", MCUConfig.LAYOUT_MODE_1AND2HORUPPERRFLEX);
		 put("split_right3_7", MCUConfig.LAYOUT_MODE_1AND2HORUPPERLFLEX);
		 put("split_right4_1", MCUConfig.LAYOUT_MODE_2X2);
		 put("split_right4_2", MCUConfig.LAYOUT_MODE_1AND3HORUPPER);
		 put("split_right4_3", MCUConfig.LAYOUT_MODE_1AND3HOR);
		 put("split_right4_4", MCUConfig.LAYOUT_MODE_1AND3VER);
		 put("split_right4_6", MCUConfig.LAYOUT_MODE_2X2UPPERRFLEX);
		 put("split_right4_7", MCUConfig.LAYOUT_MODE_2X2UPPERLFLEX);
		 put("split_right4_8", MCUConfig.LAYOUT_MODE_2X2DOWNLFLEX);
		 put("split_right4_9", MCUConfig.LAYOUT_MODE_2X2DOWNRFLEX);
		 put("split_right4_10", MCUConfig.LAYOUT_MODE_2X2RFLEX);
		 put("split_right4_11", MCUConfig.LAYOUT_MODE_2X2LFLEX);
		 put("split_right5_1", MCUConfig.LAYOUT_MODE_1AND4HORUPPER);
		 put("split_right5_2", MCUConfig.LAYOUT_MODE_1AND4HOR);
		 put("split_right5_3", MCUConfig.LAYOUT_MODE_1AND4VER);
		 put("split_right6_1", MCUConfig.LAYOUT_MODE_1AND5);
		 put("split_right8_1", MCUConfig.LAYOUT_MODE_1AND7);
		 put("split_right9_1", MCUConfig.LAYOUT_MODE_3X3);
		 put("split_right9_2", MCUConfig.LAYOUT_MODE_1AND8CENTRAL);
		 put("split_right9_3", MCUConfig.LAYOUT_MODE_1AND8LOWER);
		 put("split_right9_4", MCUConfig.LAYOUT_MODE_1AND8UPPER);
		 put("split_right16_1", MCUConfig.LAYOUT_MODE_4X4);
		 put("split_right10_1", MCUConfig.LAYOUT_MODE_2AND8);
		 put("split_right13_1", MCUConfig.LAYOUT_MODE_1AND12);
		
		 put("split_right1_1_1000", MCUConfig.LAYOUT_MODE_101);
		 put("split_right2_1_1000", MCUConfig.LAYOUT_MODE_201);
		 put("split_right2_2_1000", MCUConfig.LAYOUT_MODE_202);
		 put("split_right2_3_1000", MCUConfig.LAYOUT_MODE_203);
		 put("split_right2_4_1000", MCUConfig.LAYOUT_MODE_204);
		 put("split_right2_5_1000", MCUConfig.LAYOUT_MODE_205);
		 put("split_right3_1_1000", MCUConfig.LAYOUT_MODE_301);
		 put("split_right3_2_1000", MCUConfig.LAYOUT_MODE_302);
		 put("split_right3_3_1000", MCUConfig.LAYOUT_MODE_303);
		 put("split_right3_4_1000", MCUConfig.LAYOUT_MODE_304);
		 put("split_right3_5_1000", MCUConfig.LAYOUT_MODE_305);
		// put("split_right3_6_1000", MCUConfig);
		// put("split_right3_7_1000", MCUConfig);
		 put("split_right4_1_1000", MCUConfig.LAYOUT_MODE_401);
		 put("split_right4_2_1000", MCUConfig.LAYOUT_MODE_404);
		 put("split_right4_3_1000", MCUConfig.LAYOUT_MODE_402);
		 put("split_right4_4_1000", MCUConfig.LAYOUT_MODE_403);
		// put("split_right4_6_1000", MCUConfig.LAYOUT_MODE_405);
		// put("split_right4_7_1000", MCUConfig.);
		// put("split_right4_8_1000", MCUConfig);
		// put("split_right4_9_1000", MCUConfig);
		// put("split_right4_10_1000", MCUConfig);
		// put("split_right4_11_1000", MCUConfig);
		 put("split_right5_1_1000", MCUConfig.LAYOUT_MODE_503);
		 put("split_right5_2_1000", MCUConfig.LAYOUT_MODE_502);
		 put("split_right5_3_1000", MCUConfig.LAYOUT_MODE_501);
		 put("split_right6_1_1000", MCUConfig.LAYOUT_MODE_601);
		 put("split_right8_1_1000", MCUConfig.LAYOUT_MODE_801);
		 put("split_right9_1_1000", MCUConfig.LAYOUT_MODE_901);
		 put("split_right9_2_1000", MCUConfig.LAYOUT_MODE_902);
		 put("split_right9_3_1000", MCUConfig.LAYOUT_MODE_904);
		 put("split_right9_4_1000", MCUConfig.LAYOUT_MODE_903);
		// put("split_right9_5_1000", MCUConfig);
		 put("split_right10_1_1000", MCUConfig.LAYOUT_MODE_1001);
		 put("split_right13_1_1000", MCUConfig.LAYOUT_MODE_1301);
		 put("split_right16_1_1000", MCUConfig.LAYOUT_MODE_1601);
	}
};

 	
	public boolean loadAppConfig(Document document) {
		this.p_document=document;
		initBaseInfo();
		initDataBase();
		AuthorHelper.configInit();//检查授权
		getProjectPath();
		
		if(serverProperties.get("EQUIPMENTPARAM_NUM")!=null){
			try{
				String s  =	serverProperties.get("EQUIPMENTPARAM_NUM").toString();
				EQUIPMENTPARAM_NUM = Integer.valueOf(s);
			}catch(Exception e){
				EQUIPMENTPARAM_NUM = -1;
			}
		}
		
		if(serverProperties.get("EQUIPMENTPARAM_SLEEP")!=null){
			try{
				String s  =	serverProperties.get("EQUIPMENTPARAM_SLEEP").toString();
				EQUIPMENTPARAM_SLEEP = Integer.valueOf(s);
			}catch(Exception e){
				EQUIPMENTPARAM_SLEEP = -1;
			}
		}
		
	 	if(serverProperties.get("LEVEL_DISTRIBUTED_POEN")!=null){
			try{
				String task =	serverProperties.get("LEVEL_DISTRIBUTED_POEN").toString();
				LEVEL_DISTRIBUTED_POEN = Boolean.valueOf(task).booleanValue();
			}catch(Exception e){
				LEVEL_DISTRIBUTED_POEN = false;
			}
		}
	 	
	 	if(serverProperties.get("LEVEL_PARENT_IP")!=null){
			try{
				LEVEL_PARENT_IP =	serverProperties.get("LEVEL_PARENT_IP").toString();
			}catch(Exception e){
				LEVEL_PARENT_IP = "";
			}
		}
	 	
		if(serverProperties.get("MCU_POOL")!=null){
			try{
				String task =	serverProperties.get("MCU_POOL").toString();
				MCU_POOL = Boolean.valueOf(task).booleanValue();
			}catch(Exception e){
				MCU_POOL = false;
			}
		}
		if(serverProperties.get("CONFERENCE_AUTO_TASK")!=null){
			try{
				String task =	serverProperties.get("CONFERENCE_AUTO_TASK").toString();
				CONFERENCE_AUTO_TASK = Boolean.valueOf(task).booleanValue();
			}catch(Exception e){
				CONFERENCE_AUTO_TASK = true;
			}
		}
		
		if(serverProperties.get("meeting_space_time")!=null){
			try{
				meeting_space_time =	serverProperties.get("meeting_space_time").toString();
				Integer.valueOf(meeting_space_time);
			}catch(Exception e){
				meeting_space_time = "30";
			}
		}
		if(serverProperties.get("meeting_start_time")!=null){
			try{
				meeting_start_time =	serverProperties.get("meeting_start_time").toString();
				Integer.valueOf(meeting_start_time);
			}catch(Exception e){
				meeting_start_time = "0";
			}
		}
		
		if(serverProperties.get("SynchroStatus")!=null){
			try{
				SynchroStatus =	Boolean.parseBoolean(serverProperties.get("SynchroStatus").toString());
			}catch(Exception e){
					
			}
		}
		
		if(serverProperties.get("CLEAR_LOG_PERIOD")!=null){
			try{
				CLEAR_LOG_PERIOD			=	Integer.parseInt(serverProperties.get("CLEAR_LOG_PERIOD").toString());
			}catch(Exception e){
					
			}
		}
		
		if(serverProperties.get("SynchroDBDataTime")!=null){
			try{
				SynchroDBDataTime			=	Long.parseLong(serverProperties.get("SynchroDBDataTime").toString());
			}catch(Exception e){
					
			}
		}
		
		if(serverProperties.get("cache_hour")!=null){
			try{
				cache_hour			=	Integer.parseInt(serverProperties.get("cache_hour").toString());
			}catch(Exception e){
					
			}
		}
		
		if(serverProperties.get("LDAP_VALID")!=null){
			try{
				LDAP_VALID			=	serverProperties.get("LDAP_VALID").toString();
				LDAP_IP			=	serverProperties.get("LDAP_IP").toString();
				LDAP_PORT			=	serverProperties.get("LDAP_PORT").toString();
			}catch(Exception e){
					
			}
		}
		Eryptogram etg = new Eryptogram();
		if(serverProperties.get("ftpServer")!=null){
			try{
				FTP_SERVER			=	serverProperties.get("ftpServer").toString();
				FTP_USER			=	etg.decryptData(serverProperties.get("ftpUser").toString());
				FTP_PSW			=	etg.decryptData(serverProperties.get("ftpPsw").toString());
				FTP_LOCATION			=	serverProperties.get("ftpLocation").toString();
				FTP_PORT			=	Integer.parseInt(serverProperties.get("ftpPort").toString());
				FILE_LOCATION		=	serverProperties.get("fileLocation").toString();
			}catch(Exception e){
					e.printStackTrace();
			}
		}
		
		if(serverProperties.get("pwdInit")!=null){
			try{
				PWDINIT		=	etg.decryptData(serverProperties.get("pwdInit").toString());
			}catch(Exception e){
				PWDINIT="7D15AB4E86BE3769";
			}
		}
		
		if(serverProperties.get("pwdAuth")!=null){
			try{
				PWDAUTH		=	serverProperties.get("pwdAuth").toString();
			}catch(Exception e){
				PWDAUTH="false";
			}
		}
		if(serverProperties.get("pwdUnLockTimes")!=null){
			try{
				PWDUNLOCKTIMES		=	Integer.parseInt(serverProperties.get("pwdUnLockTimes").toString());
			}catch(Exception e){
				PWDUNLOCKTIMES =10;
			}
		}
		
		if(serverProperties.get("messageTime")!=null){//告警消息推送间隔，单位：秒
			try{
				MessageTime		=	Integer.parseInt(serverProperties.get("messageTime").toString());
			}catch(Exception e){
				MessageTime =60;
			}
		}
		
		if(serverProperties.get("levelIsOpen")!=null){//开启分级分权检测
			try{
					String isopen	=	serverProperties.get("levelIsOpen").toString();
					if(isopen.equalsIgnoreCase("true")){
						LEVEL_IS_POEN=true;
					}else{
						LEVEL_IS_POEN=false;
					}
			}catch(Exception e){
				LEVEL_IS_POEN=false;
			}
		}
		
		if(serverProperties.get("dataPoll")!=null){//开启告警提示
			try{
					String dataPoll	=	serverProperties.get("dataPoll").toString();
					if(dataPoll.equalsIgnoreCase("true")){
						DataPoll=true;
					}else{
						DataPoll=false;
					}
			}catch(Exception e){
				DataPoll=false;
			}
		}
		
		if(serverProperties.get("hostLevel")!=null){
			try{
				HOST_LEVEL_ID=	serverProperties.get("hostLevel").toString();
			}catch(Exception e){
				HOST_LEVEL_ID="-1";
			}
		}
		
		if(serverProperties.get("pwdInitAdmin")!=null){
			try{
				PWDINITADMIN		=	etg.decryptData(serverProperties.get("pwdInitAdmin").toString());
			}catch(Exception e){
				PWDINITADMIN="1C79A8D6FC065E6D816E4D63FC8BF2D0";
			}
		}
		
		if(serverProperties.get("FDB_IP")!=null){
			try{
				FDB_IP =	serverProperties.get("FDB_IP").toString();
			}catch(Exception e){
				FDB_IP = "";
			}
		}
	 	if(serverProperties.get("FDB_USERNAME")!=null){
			try{
				FDB_USERNAME =	serverProperties.get("FDB_USERNAME").toString();
			}catch(Exception e){
				FDB_USERNAME = "";
			}
		}
	 	if(serverProperties.get("FDB_PWD")!=null){
			try{
				FDB_PWD =	serverProperties.get("FDB_PWD").toString();
			}catch(Exception e){
				FDB_PWD = "";
			}
		}
	 	if(serverProperties.get("FDB_NAME")!=null){
			try{
				FDB_NAME =	serverProperties.get("FDB_NAME").toString();
			}catch(Exception e){
				FDB_NAME = "";
			}
		}
	 	if(serverProperties.get("FDB_PORT")!=null){
			try{
				FDB_PORT =	serverProperties.get("FDB_PORT").toString();
			}catch(Exception e){
				FDB_PORT = "";
			}
		}
		
		if(serverProperties.get("LEVEL_DISTRIBUTED_TIME")!=null){
			try{
				LEVEL_DISTRIBUTED_TIME		=	Integer.parseInt(serverProperties.get("LEVEL_DISTRIBUTED_TIME").toString());
			}catch(Exception e){
				LEVEL_DISTRIBUTED_TIME =60;
			}
		}
		
		if(db_normal){
			//加载配置信息-第一个加载顺序
			BaseInfoHelp.getConfigInfo();
			
			/**
			 * 系统启动是加载项
			 * modify by ryan 0n 20140214
			 */
			InitMeetingTaskDate.init();
			if(LEVEL_DISTRIBUTED_POEN){//开启分布式部署
				//启动更新本地节点的ip。。。
				
//				try {
//					Thread.sleep(10*1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				String[] localDBinfo = new String[3];
				String[] farDBinfo = new String[3];
				localDBinfo[0] = DB_USER;
				localDBinfo[1] = DB_PASSWD;
				localDBinfo[2] = DB_URL.split("\\?")[0];
				farDBinfo[0] = FDB_USERNAME;
				farDBinfo[1] = FDB_PWD;
				farDBinfo[2] = "jdbc:mysql://"+FDB_IP+":"+FDB_PORT+"/"+FDB_NAME;
//				com.zzst.icmp.ControlFactory.initNodeDBInfo(farDBinfo, localDBinfo);
//				try {
//					Thread.sleep(5*1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				//String tt = DB_URL.split("//")[1];
				
				
				//com.zzst.icmp.ControlFactory.updateDistributed(FDB_IP,webservice_ip,tt.split(":")[0]);
//				com.zzst.icmp.ControlFactory.setLevelID(HOST_LEVEL_ID);
				System.out.println("=====HOST_LEVEL_ID====:"+HOST_LEVEL_ID);
//				try {
//					Thread.sleep(5*1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
//				com.zzst.icmp.ControlFactory.startTimerTask(LEVEL_DISTRIBUTED_TIME);//数据同步线程
			}
		}
		
		return true;
	}
	
	/**
	 * 初始化数据库
	 * 
	 * date：Mar 24, 2010
	 * add by xiamaojian on 2010-3-24
	 */
	@SuppressWarnings("unchecked")
	private	  void initDataBase() {
		if (p_document == null) {
			return;
		}
		List<Element> initparams = p_document.selectNodes("root/datasources/datasource");
 		if (initparams != null) {
 			for(int i=0;i<initparams.size();i++){
 				Eryptogram etg = new Eryptogram();
 				Element node = (Element)initparams.get(i);
 				DB_URL= node.elementText("DB_URL");
				DB_USER= etg.decryptData(node.elementText("DB_USER"));
				DB_PASSWD=  etg.decryptData(node.elementText("DB_PASSWD"));
				DB_JNDI= node.elementText("DB_JNDI");
				if(DB_URL.indexOf("oracle")!=-1){
					CbfConfig.DB_TYPE = CbfConfig.DB_TYPE_ORACLE;
				}
 			}
 			try{
 				if(DB_URL.indexOf("mysql")>=0){
 					DriverManager.registerDriver (new com.mysql.jdbc.Driver());
 					DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
 					db_normal = true;
 				}else if(DB_URL.indexOf("oracle")>=0){
 					
 				}
 			}catch(Exception e){
 				System.out.println("数据库链接异常，请使用后台管理员账号配置数据库信息");
 			}
 		}
 		
 	////////////////////////////bak database@author:zhangjy ////////////////////////////	
 		String bak_DB_URL="",bak_DB_USER="",bak_DB_PASSWD="",bak_DB_JNDI="",bak_IS_OPEN="";
		List<Element> initparamsBak = p_document.selectNodes("root/datasources/datasourceBAK");
 		if (initparamsBak != null) {
 			for(int i=0;i<initparamsBak.size();i++){
 				Eryptogram etg = new Eryptogram();
 				Element node = (Element)initparamsBak.get(i);
				 bak_DB_URL= node.elementText("BAK_DB_URL");
				 bak_DB_USER= etg.decryptData(node.elementText("BAK_DB_USER"));
				 bak_DB_PASSWD=  etg.decryptData(node.elementText("BAK_DB_PASSWD"));
				 bak_DB_JNDI= node.elementText("BAK_DB_JNDI");
				 bak_IS_OPEN=node.elementText("BAK_IS_OPEN");
				
 			}
		}
 	////////////////////////////////end//////////////////////////////////////
 		dbvo.setDb_url(DB_URL);
 		dbvo.setDb_name(DB_USER);
		dbvo.setPass(DB_PASSWD);
		dbvo.setDb_jndi(DB_JNDI);
		
		dbvo.setBak_db_url(bak_DB_URL);
		dbvo.setBak_db_name(bak_DB_USER);
		dbvo.setBak_pass(bak_DB_PASSWD);
		dbvo.setDb_url(DB_URL);
		
		if(bak_IS_OPEN.equals("true")){
		dbvo.setOpenbak(true);	
		}else{
		dbvo.setOpenbak(false);
		return;
		}
 		ScanDateState sds=new ScanDateState();
 		sds.start();
 		
	}	
	
	
	/**
	 * 设置循环任务,每天24点执行的任务
	 */
	public	void	setLoopTasker(){
		 
		//CbfTimer.addLoopTask(new CbfTimerTest1() );
	}
	
 
	/**
	 * 初始化基本参数
	 * 
	 * date：Mar 24, 2010
	 * add by xiamaojian on 2010-3-24
	 */
	private  void initBaseInfo() {
		if (p_document == null) {
			return;
		}

 		try {
 			List<Element> initparams = p_document.selectNodes("root/init-param");
			if (initparams != null) {
				for (int i = 0; i < initparams.size(); i++) {
					Element node = (Element)initparams.get(i);
					String str_key 		=	node.attributeValue("key");
					String str_value 	=	node.attributeValue("value");
					//String str_descr 	=	node.attributeValue("descr");
					serverProperties.put(str_key, str_value); 				// 在系统属性中加入!!
				}
 			}
 		} catch (Throwable tr) {
			tr.printStackTrace();
		}
 	}

	/**
	 * initialize MCU data.
	 */
	public static String[][] getMcuProfiles(){
		String[][] s  = new String[profileIds.length][2];
		for(int i=0;i<s.length;i++){
			s[i][0] =profileIds[i];
			s[i][1] =profileNames[i];
		}
		return s;
	}
	
	private void getProjectPath(){
 		String file_src = MeetingAppConfig.class.getResource("/").getPath();
 		if(file_src.indexOf("WEB-INF/")>0)
 			file_src = file_src.substring(0,file_src.indexOf("WEB-INF/"));
 		PROJECT_SRC = file_src.substring(1, file_src.length());
 		
 		try {
 			SYS_NAME = System.getProperty("os.name").toLowerCase(); 
 			webservice_ip = InetAddress.getLocalHost().getHostAddress();//优先取有线IP
 			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
 	}
	
	/**
	 * 提取级联MCU模板组
	 * @return
	 */
	public static String[][] getLinkMcuProfiles(){
		McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
		mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
		try{
			ArrayList<McuCascadeModelVO> mcuCascadeModelList =  ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO, null);
			if(mcuCascadeModelList.size()>0){
				String[][] s = new String[mcuCascadeModelList.size()][2];
				for( int i=0; i<mcuCascadeModelList.size(); i++ ){
					s[i][0] = mcuCascadeModelList.get(i).getCascadeID();
					s[i][1] = mcuCascadeModelList.get(i).getCascadeName();
				}
				return s;
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
		return null;
	}
}
