package com.zzst.action.meeting.autocompare.histogram;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.meeting.service.comparison.ComparisonReferenceServiceImpl;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.service.meeting.videoCard.VideoCardServiceImpl;

public class TestThread  extends Thread{
	private String ip;
	public TestThread(String vdeoCardip){
		ip = vdeoCardip;
	}
	public void run(){
		while(true){
			
		try {
			
			
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setIp(ip);
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			List<EquipmentVO> equipList = new EquipmentServiceImpl().query(equipmentVO, null);
			if(equipList == null || equipList.size() <= 0){
				return ;
			}
			equipmentVO = equipList.get(equipList.size() - 1);
			
			
			VideoCardVO videoCardVO = new VideoCardVO();
			videoCardVO.setEquipmentID(equipmentVO.getEquipmentID());
			List<VideoCardVO> videoCardList = new VideoCardServiceImpl().query(videoCardVO, null);
			if(videoCardList == null || videoCardList.size() <= 0){
				return ;
			}
			videoCardVO = videoCardList.get(0);
			HistogramUtil histogramUtil = new HistogramUtil();
			VideoCardController  videoCardController = new VideoCardController(equipmentVO.getIp());
			byte[] setCommand = new byte[9];
			setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
			setCommand[1]=0x55;	//fixed byte
			setCommand[2]=histogramUtil.getHexByte(videoCardVO.getAppraisalTaskNum()); //A6: colorful bar A8:frame mode
			setCommand[3]=histogramUtil.getHexByte(videoCardVO.getShowFormatFlag()); //B0: 1080P60 B1:1080P50 B7:720P60 
			setCommand[4]=histogramUtil.getHexByte(videoCardVO.getOutputModel()); //C0:DVI C1:VGA C2:YPbPr  out
			setCommand[5]=histogramUtil.getHexByte(videoCardVO.getInputModel()); //D0:DVI D1:VGA D2:YPbPr  in
			setCommand[6]=histogramUtil.getHexByte(videoCardVO.getAppraisalModel()); //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
			setCommand[7]=(byte)0xF1;// F1 多帧；F0：单帧;
			setCommand[8]=0x00;
			videoCardController.setCommand(setCommand);
			Thread.sleep(HistogramUtil.GET_HISTOGRAM_SLEEP_TIME);
			//视频评价结果请求
			
			byte getByte = 0x00;
			//
			int multiple = histogramUtil.getPixelMultiple(videoCardVO.getShowFormatFlag());
			int[][] rgbArray = videoCardController.getCommand(getByte, multiple);
			ComparisonReferenceVO comparisonReferenceVO = new ComparisonReferenceVO();
			comparisonReferenceVO.setDescription(ip);
			StringBuffer buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[0].length; i++){
				buffer.append(rgbArray[0][i]);
				if(i < rgbArray[0].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setR_Pr(buffer.toString());
			buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[1].length; i++){
				buffer.append(rgbArray[1][i]);
				if(i < rgbArray[1].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setG_Y(buffer.toString());
			buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[2].length; i++){
				buffer.append(rgbArray[2][i]);
				if(i < rgbArray[0].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setB_Pb(buffer.toString());
			
			List<ComparisonCriteriaVO> criteriaList = ServiceFactory.getConparisonCriteriaService().query(null, null);
			if(criteriaList == null || criteriaList.size() <= 0){
				return ;
			}
			ComparisonCriteriaVO  criteriaVO = criteriaList.get(0);
			
			comparisonReferenceVO.setS_R(getArea(rgbArray[0], criteriaVO.getX_min(), criteriaVO.getX_max()));
			comparisonReferenceVO.setS_G(getArea(rgbArray[1], criteriaVO.getX_min(), criteriaVO.getX_max()));
			comparisonReferenceVO.setS_B(getArea(rgbArray[2], criteriaVO.getX_min(), criteriaVO.getX_max()));
			
			comparisonReferenceVO.setX_min(criteriaVO.getX_min());
			comparisonReferenceVO.setX_max(criteriaVO.getX_max());
			
			Calendar now = Calendar.getInstance();
			comparisonReferenceVO.setUpdateTime(new Timestamp(now.getTimeInMillis()));
			
			new ComparisonReferenceServiceImpl().add(comparisonReferenceVO);
			
			Thread.sleep(60 * 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ;
		}
	
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
			//s += dataArray[i] * i;
			s += dataArray[i];
		}
		
		return s;
	}
	
}
