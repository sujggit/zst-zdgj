package com.zzst.action.meeting.autocompare.histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.meeting.dwr.VideoCardDwrMethod;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;

public class HistogramUtil {
	private static Logger logger = CbfLogger.getLogger(HistogramUtil.class.getName());	
	
	public static int A8 = 0xA8;
	public static int A6 = 0xA6;
	//分辨率
	public static int B0 = 0xB0;
	public static int B1 = 0xB1;
	public static int B2 = 0xB2;
	public static int B3 = 0xB3;
	public static int B4 = 0xB4;
	public static int B5 = 0xB5;
	public static int B6 = 0xB6;
	public static int B7 = 0xB7;
	public static int B8 = 0xB8;
	public static int BA = 0xBA;
	public static int BB = 0xBB;
	
	public static int C1 = 0xC1;
	public static int C2 = 0xC2;
	public static int D1 = 0xD1;
	public static int D2 = 0xD2;
	public static int E0 = 0xE0;
	public static int E1 = 0xE1;
	public static int E2 = 0xE2;
	public static int E3 = 0xE3;
	public static int E4 = 0xE4;
	public static int E5 = 0xE5;
	//图像采集方式
	public static int F0 = 0xF0;
	public static int F1 = 0xF1;
	
	public static int ISNOTAPPRAISAL_RESULT = 100;
	public static int ISNOTCONNECTED_RESULT = 8;
	//手工确认
	public static int MANUAL_GOOD_RESULT = 6;
	public static int MANUAL_OK_RESULT =5;
	public static int MANUAL_BAD_RESULT = 4;	
	//设备自动比对结果
	public static int GOOD_RESULT = 3; //video good, audio good
	public static int OK_RESULT =2;   //video ok
	public static int BAD_RESULT = 1; //video bad, audio bad.
	public static int INIT_RESULT = 0;
	
	public static int RED_VALUE = 1;
	public static int GREEN_VALUE = 2;
	public static int BLUE_VALUE =3;
	
	//声音采集结果 ；
	public static int NONEVOICE_VALUE = 0;
	public static int ONVOICE_VALUE =1;
	//终端声音状态
	public static int TERMINALNONEVOICE_VALUE = -20;
	public static int TERMINALONVOICE_VALUE =4;
	
	//点名方式
	public static int AUDIO_VIDEO_AUTOCOMPARE_STATUS = 1;
	public static int VIDEO_AUTOCOMPARE_STATUS =2;
	
	public static int GET_HISTOGRAM_SLEEP_TIME = 5000;
	
	//标准分辨率定义, 分辨率-像素注册: wangle 2013-9-3
	public static String STANDARD_RESOLUTION = "B0";
	public static Map<String, Integer> resolutionPixelMap = new HashMap<String, Integer>();
	static{
		resolutionPixelMap.put("B0", 2073600);
		resolutionPixelMap.put("B1", 2073600);
		resolutionPixelMap.put("B2", 2073600);
		resolutionPixelMap.put("B3", 2073600);
		resolutionPixelMap.put("B4", 2073600);
		resolutionPixelMap.put("B5", 1036800);
		resolutionPixelMap.put("B6", 1036800);
		resolutionPixelMap.put("B7", 921600);
		resolutionPixelMap.put("B8", 921600);
		resolutionPixelMap.put("BA", 1310720);
		resolutionPixelMap.put("BB", 786432);
	}
	
	//面积
	public int getArea(int[] dataArray, int x_min, int x_max){
		int s = 0;
		if(dataArray == null || dataArray.length == 0){
			return s;
		}
		if(x_min < 0){
			x_min = 0;
		}
		if(x_max > dataArray.length){
			x_max = dataArray.length;
		}
		for(int i=x_min; i <= x_max; i++){
			s += dataArray[i] * i;
			//s += dataArray[i];
		}
		
		return s;
	}
	
	//面积差值
	public float getAreaGap(int detailS, int referenceS){
		if(referenceS == 0){
			return (detailS - referenceS) * 100;
		}
		float gap = ((((float)detailS)-((float)referenceS))/((float)referenceS)) * 100;
		gap = (float)(Math.round(gap * 10))/10;
		return gap;
	}
	
	//得到单个R或G或B的好、中、差
	public int getEvaluateResult(float areaGap, int color){
		int result = BAD_RESULT;
		try {
			List<ComparisonCriteriaVO> criteriaList = ServiceFactory.getConparisonCriteriaService().query(null, null);
			if(criteriaList == null || criteriaList.size() <= 0){
				return result;
			}
			ComparisonCriteriaVO  criteriaVO = criteriaList.get(0);
			if(color == RED_VALUE){
				if(areaGap >= criteriaVO.getRsGap_Good_lower() && areaGap <= criteriaVO.getRsGap_Good_upper()){
					return GOOD_RESULT;
				}
				if((areaGap >= criteriaVO.getRsGap_Ok_lower() && areaGap < criteriaVO.getRsGap_Good_lower()) || 
						(areaGap > criteriaVO.getRsGap_Good_upper() && areaGap <= criteriaVO.getRsGap_Ok_upper())){
							return OK_RESULT;
						}
				return BAD_RESULT;
			}
			if(color == GREEN_VALUE){
				if(areaGap >= criteriaVO.getGsGap_Good_lower() && areaGap <= criteriaVO.getGsGap_Good_upper()){
					return GOOD_RESULT;
				}
				if((areaGap >= criteriaVO.getGsGap_Ok_lower() && areaGap < criteriaVO.getGsGap_Good_lower()) || 
						(areaGap > criteriaVO.getGsGap_Good_upper() && areaGap <= criteriaVO.getGsGap_Ok_upper())){
							return OK_RESULT;
						}
				return BAD_RESULT;
			}
			
			if(color == BLUE_VALUE){
				if(areaGap >= criteriaVO.getBsGap_Good_lower() && areaGap <= criteriaVO.getBsGap_Good_upper()){
					return GOOD_RESULT;
				}
				if((areaGap >= criteriaVO.getBsGap_Ok_lower() && areaGap < criteriaVO.getBsGap_Good_lower()) || 
						(areaGap > criteriaVO.getBsGap_Good_upper() && areaGap <= criteriaVO.getBsGap_Ok_upper())){
							return OK_RESULT;
						}
				return BAD_RESULT;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//get a 从R、G、B的area result
	public int getComprehensiveResult(int rResult, int gResult, int bResult){
		if(rResult == BAD_RESULT || gResult == BAD_RESULT || bResult == BAD_RESULT){
			return BAD_RESULT;
		}
		
		if(rResult == GOOD_RESULT && gResult == GOOD_RESULT && bResult == GOOD_RESULT){
			return GOOD_RESULT;
		}
		
		return OK_RESULT;
	}
	/**
	 * get final result
	 * @param videoQuality
	 * @param audioQuality
	 * @return
	 */
	public int getResult(int[] videoQuality, int[] audioQuality){
		if((videoQuality == null || videoQuality.length == 0) && (audioQuality == null || audioQuality.length == 0)){
			return ISNOTAPPRAISAL_RESULT;
		}
		boolean isGood = true;
		//video auto compare
		if(audioQuality == null || audioQuality.length == 0){
			for(int quality : videoQuality){
				if(quality == BAD_RESULT || quality == ISNOTCONNECTED_RESULT){
					return BAD_RESULT;
				}
				if(quality == OK_RESULT){
					isGood = false;
				}
			}
			if(isGood){
				return GOOD_RESULT;
			}else{
				return OK_RESULT;
			}
		}
		
		//audio auto compare
		if(videoQuality == null || videoQuality.length == 0){
			return ISNOTAPPRAISAL_RESULT;
		}
		//audio and video auto compare
		for(int quality : videoQuality){
			if(quality == BAD_RESULT  || quality == ISNOTCONNECTED_RESULT){
				return BAD_RESULT;
			}
			if(quality == OK_RESULT){
				isGood = false;
			}
		}
		for(int quality : audioQuality){
			if(quality == BAD_RESULT || quality == ISNOTCONNECTED_RESULT){
				return BAD_RESULT;
			}
		}
		if(isGood){
			return GOOD_RESULT;
		}else{
			return OK_RESULT;
		}
	}
	
	/**
	 * get final result by audio/video/equipment status from center control/ping C8.
	 * @param equipStatus : all equipment status description. is null ,will return bad.
	 * @param videoQuality
	 * @param audioQuality
	 * @return
	 */
	public int getAVCResult(String equipStatus, int[] videoQuality, int[] audioQuality){
		if(equipStatus == null || equipStatus.contains("false")){
			return BAD_RESULT;
		}
		if((videoQuality == null || videoQuality.length == 0) && (audioQuality == null || audioQuality.length == 0)){
			return ISNOTAPPRAISAL_RESULT;
		}
		boolean isGood = true;
		//video auto compare
		if(audioQuality == null || audioQuality.length == 0){
			for(int quality : videoQuality){
				if(quality == BAD_RESULT || quality == ISNOTCONNECTED_RESULT){
					return BAD_RESULT;
				}
				if(quality == OK_RESULT){
					isGood = false;
				}
			}
			if(isGood){
				return GOOD_RESULT;
			}else{
				return OK_RESULT;
			}
		}
		
		//audio auto compare
		if(videoQuality == null || videoQuality.length == 0){
			return ISNOTAPPRAISAL_RESULT;
		}
		//audio and video auto compare
		for(int quality : videoQuality){
			if(quality == BAD_RESULT  || quality == ISNOTCONNECTED_RESULT){
				return BAD_RESULT;
			}
			if(quality == OK_RESULT){
				isGood = false;
			}
		}
		for(int quality : audioQuality){
			if(quality == BAD_RESULT || quality == ISNOTCONNECTED_RESULT){
				return BAD_RESULT;
			}
		}
		if(isGood){
			return GOOD_RESULT;
		}else{
			return OK_RESULT;
		}
	}
	
	/**
	 * get hex byte to be used in command to video card.
	 * @param hexString
	 * @return
	 */
	public byte getHexByte(String hexString){
		if(Integer.toHexString(A8).equalsIgnoreCase(hexString)){
			return (byte)A8;
		}
		if(Integer.toHexString(A6).equalsIgnoreCase(hexString)){
			return (byte)A6;
		}
		if(Integer.toHexString(B0).equalsIgnoreCase(hexString)){
			return (byte)B0;
		}
		if(Integer.toHexString(B1).equalsIgnoreCase(hexString)){
			return (byte)B1;
		}
		if(Integer.toHexString(B2).equalsIgnoreCase(hexString)){
			return (byte)B2;
		}
		if(Integer.toHexString(B3).equalsIgnoreCase(hexString)){
			return (byte)B3;
		}
		if(Integer.toHexString(B4).equalsIgnoreCase(hexString)){
			return (byte)B4;
		}
		if(Integer.toHexString(B5).equalsIgnoreCase(hexString)){
			return (byte)B5;
		}
		if(Integer.toHexString(B6).equalsIgnoreCase(hexString)){
			return (byte)B6;
		}
		if(Integer.toHexString(B7).equalsIgnoreCase(hexString)){
			return (byte)B7;
		}
		if(Integer.toHexString(B8).equalsIgnoreCase(hexString)){
			return (byte)B8;
		}
		if(Integer.toHexString(BA).equalsIgnoreCase(hexString)){
			return (byte)BA;
		}
		if(Integer.toHexString(BB).equalsIgnoreCase(hexString)){
			return (byte)BB;
		}
		if(Integer.toHexString(C1).equalsIgnoreCase(hexString)){
			return (byte)C1;
		}
		if(Integer.toHexString(C2).equalsIgnoreCase(hexString)){
			return (byte)C2;
		}
		if(Integer.toHexString(D1).equalsIgnoreCase(hexString)){
			return (byte)D1;
		}
		if(Integer.toHexString(D2).equalsIgnoreCase(hexString)){
			return (byte)D2;
		}
		if(Integer.toHexString(E0).equalsIgnoreCase(hexString)){
			return (byte)E0;
		}
		if(Integer.toHexString(E0).equalsIgnoreCase(hexString)){
			return (byte)E0;
		}
		if(Integer.toHexString(E1).equalsIgnoreCase(hexString)){
			return (byte)E1;
		}
		if(Integer.toHexString(E2).equalsIgnoreCase(hexString)){
			return (byte)E2;
		}
		if(Integer.toHexString(E3).equalsIgnoreCase(hexString)){
			return (byte)E3;
		}
		if(Integer.toHexString(E4).equalsIgnoreCase(hexString)){
			return (byte)E4;
		}
		if(Integer.toHexString(E5).equalsIgnoreCase(hexString)){
			return (byte)E5;
		}
		if(Integer.toHexString(F0).equalsIgnoreCase(hexString)){
			return (byte)F0;
		}
		if(Integer.toHexString(F1).equalsIgnoreCase(hexString)){
			return (byte)F1;
		}
		
		return (byte)E5;
	}
	
	/**
	 * get RGB AREA VALUE
	 * @param videoCardIp
	 * @param videoCardVO
	 * @return
	 * @throws Exception 
	 */
	public int[][] getRGBArea(String videoCardIp, VideoCardVO videoCardVO) throws Exception{
		int[][] rgbArray = null;
		VideoCardController  videoCardController = new VideoCardController(videoCardIp);
		/*modified by wangle 2013-05-14*/
		byte[] setCommand = new byte[9];
		setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
		setCommand[1]=0x55;	//fixed byte
		setCommand[2]=getHexByte(videoCardVO.getAppraisalTaskNum()); //A6: colorful bar A8:frame mode
		setCommand[3]=getHexByte(videoCardVO.getShowFormatFlag()); //B0: 1080P60 B1:1080P50 B7:720P60
		setCommand[4]=getHexByte(videoCardVO.getOutputModel()); //C0:DVI C1:VGA C2:YPbPr  out
		setCommand[5]=getHexByte(videoCardVO.getInputModel()); //D0:DVI D1:VGA D2:YPbPr  in
		setCommand[6]=getHexByte(videoCardVO.getAppraisalModel()); //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
		setCommand[7]=(byte)0xF1;// F1 多帧；F0：单帧;
		setCommand[8]=0x00;
			
		videoCardController.setCommand(setCommand);
		//等待4秒接受数据tanzl
		Thread.sleep(4000);
		
		//计算不同分辨率的倍数:
		int multiple = getPixelMultiple(videoCardVO.getShowFormatFlag());
		//视频评价结果请求
		byte getByte = 0x00;
		rgbArray = videoCardController.getCommand(getByte, multiple);
		
		return rgbArray;
	}
	
	
	/**
	 * get RGB assembly.
	 * @param RGBArray
	 * @return
	 */
	public String getRGBAssembly(int[] RGBArray){
		StringBuffer buffer = new StringBuffer();
		for(int i=0 ;i<RGBArray.length; i++){
			buffer.append(RGBArray[i]);
			if(i < RGBArray.length-1){
				buffer.append(",");
			}
		}
		return buffer.toString();
	}
	
	public int[] getRGBInt(String s[]){
		int []RGB=new int[s.length];
		for(int i=0;i<s.length;i++){
			RGB[i]=Integer.parseInt(s[i]);
		}
		//System.out.println("它的长度为 。。。。。。。。。。。。。。。。。。。。。。。"+RGB.length);
		return RGB;
		
	}
	
	public int getPercent(int comparisonedCount ,int totalCount){
		if(comparisonedCount>=0&&comparisonedCount<=totalCount&&totalCount!=0){
			
            float s=(float)comparisonedCount;		
			float c=(float)totalCount;
			System.out.println((float)(s/c)*100);		
				float result=(s/c)*100;
				
				
			
			return (int)result;
		}else{
			return 0;
		}
		
	}
	
	/**
	 * make noise.
	 * @param epIp
	 */
	public void makeNoise(String epIp){
		TerminalObject setVoiceobj = ControlFactory.getTerminalObject(epIp);
		if(setVoiceobj == null){
			return;
		}
		setVoiceobj.testToneOn();
	}
	
	public void disableNoise(String epIp){
		TerminalObject setVoiceobj = ControlFactory.getTerminalObject(epIp);
		if(setVoiceobj == null){
			return;
		}
		setVoiceobj.testToneOff();
	}
	
	//声音接收检测
	public int  getVoiceResult(String setVoiceIp,String getvoiceIp){
		logger.info("音频检测："+setVoiceIp+"的"+AudiometerVO.lineoutleft+"发声。。。。。。");
//		setVoiceobj.setAudiometerOn(AudiometerVO.lineoutleft);
		//setVoiceobj.setAudiometerOn(AudiometerVO.lineoutright);
		
		TerminalObject getVoiceobj = ControlFactory.getTerminalObject(getvoiceIp);
		if(getVoiceobj==null) return  NONEVOICE_VALUE; 
		getVoiceobj.setAudiometerOn(AudiometerVO.lineoutleft);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExcuteResultVO resultVO = getVoiceobj.getAudiometerVO();
		if(!resultVO.isSuccess()){
			logger.info("执行失败:"+resultVO.getDes());
			return  NONEVOICE_VALUE;
		}
		Map<String,AudiometerVO> map = (Map<String,AudiometerVO>)resultVO.getObject();
		
		if(map==null){
			logger.info("map为空");
			return NONEVOICE_VALUE;
		}
		//取音量值
		AudiometerVO fvo = map.get(AudiometerVO.lineoutleft);
		String num=fvo.getNum();
		logger.info(getvoiceIp +"音量值：" + num);
		getVoiceobj.setAudiometerOff(AudiometerVO.lineoutleft);
		
	    return Integer.parseInt(num);
	}
	
	
	
	
	public int getVoiceEvalutResult(int voiceResult){
		if(voiceResult > TERMINALNONEVOICE_VALUE){
			return  ONVOICE_VALUE;
		}else{
			return NONEVOICE_VALUE;
		}
	}
	

	/**
	 * get Pixel Multiple
	 * @param resolution
	 * @return
	 */
	public int getPixelMultiple(String resolution){
		Integer pixel = resolutionPixelMap.get(resolution);
		Integer standardPixel = resolutionPixelMap.get(STANDARD_RESOLUTION);
		if(pixel != null && standardPixel != null){
			return standardPixel/pixel;
		}
		return 1;
	}
	
	/**   
     * 能否ping通IP地址     wangle 2013-10-16
     * @param server IP地址    
     * @param timeout 超时时长    
     * @return true能ping通    
     */    

	public static boolean getEquipmentStatus(String server, int timeout) {
		long startTime = System.currentTimeMillis();
		
        BufferedReader in = null;   
        Runtime r = Runtime.getRuntime();   
  
        String pingCommand = "ping " + server + " -n 1 -w " + timeout;   
        try {   
            Process p = r.exec(pingCommand);   
            if (p == null) {   
                return false;   
            }   
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String line = null;   
            while ((line = in.readLine()) != null) {   
            	logger.info(new String(line.getBytes("utf-8"), "gb2312"));
                if (line.contains("ms")) {   
                    return true;   
                }   
            }   
  
        } catch (Exception ex) {   
        	logger.error(ex.getMessage());
            return false;   
        } finally {   
            try {   
                in.close();   
            } catch (IOException e) {   
            	logger.error(e.getMessage());   
            }   
        }
        logger.debug("ping "+server+"	时长："+(System.currentTimeMillis()-startTime));
        return false;   
    }  
	
	public static void main(String[] args){
		HistogramUtil util = new HistogramUtil();
//		System.out.println(util.getAreaGap(105, 100));
//		StringBuffer buffer = new StringBuffer();
//		buffer.append(A8);
//		
//		System.out.println(Integer.toHexString(A8));
//		
//		
//		String []s="38,4,0,5,85,0,303,169,0,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,2,5,7,3,6,3,7,10,6,15,10,9,16,28,15,38,51,44,78,45,77,66,48,64,51,31,46,29,31,31,14,29,26,12,23,19,17,17,22,13,19,16,6,7,4,5,8,4,5,3,2,2,2,2,2,2,1,2,3,1,2,1,2,2,1,2,2,1,3,2,1,1,1,1,1,0,1,1,1,2,1,0,1,1,0,1,1,1,1,1,0,1,1,1,2,1,1,1,0,1,1,0,2,1,1,1,0,1,1,1,0,1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,19591,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,2,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,2,2,3,6,6,9,10,9,15,16,27,32,30,50,34,45,39,76,64,63,75,55,80,49,44,33,27,31,17,19,22,22,22,16,18,14,16,14,9,7,5,5,3,3,2,1,2,2,2,1,1,2,1,2,2,2,2,1,2,1,9,1,2,2,1,1,1,9,1,1,1,0,1,1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,2,1,1,0,1,1,0,1,1,2,1,0,1,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,8,1,0,0,0".split(",");
//	    String []sr="1337,112,14,245,998,13,341,27,14,13,16,14,14,16,11,16,15,12,15,12,12,15,12,12,13,12,12,14,11,11,10,9,11,8,9,10,6,10,9,7,8,6,6,6,7,4,7,7,5,5,4,6,4,5,5,5,4,5,6,3,5,4,3,4,4,3,3,4,3,3,3,4,4,2,4,4,4,4,4,3,4,4,3,5,4,4,5,5,4,5,4,4,5,4,5,5,4,7,6,7,9,7,11,11,11,12,13,12,13,13,11,17,13,16,18,13,16,14,15,12,17,17,16,13,13,12,11,9,11,9,8,11,7,9,9,8,8,10,8,10,11,8,9,8,10,10,11,10,12,9,10,11,10,11,12,11,14,17,12,19,17,13,15,16,16,22,16,20,20,12,15,12,12,13,13,12,13,17,11,17,11,16,12,10,13,9,9,10,9,9,8,8,8,8,4,9,7,7,8,10,9,12,13,11,14,14,11,15,12,14,17,10,19,17,15,18,17,13,16,15,10,15,12,12,19,10,15,13,15,16,17,19,17,25,14,27,16,29,28,16,41,11,40,39,4,40,28,1,5,0,2,1,0,2,1,7".split(",");
//		HistogramUtil util = new HistogramUtil();
//		float a = util.getAreaGap(100, 85);
//		System.out.println(a);
		
		System.out.println(util.getEquipmentStatus("10.6.243.210", 2000));
	}
}
