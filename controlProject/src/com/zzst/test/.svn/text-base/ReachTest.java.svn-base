package com.zzst.test;

import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	锐取录播服务器测试类
 *@date 2013-1-28下午05:35:40
 *@author ryan
 */
public class ReachTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("E:/develop_C/6dev/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
			new ReachTest().initDate();
			ControlFactory.setEquipmentParam(1,3);
			ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_REACH);
			Thread.sleep(10*1000);
			ReachObject obj = (ReachObject)ControlFactory.getReachObject("10.1.6.11");
			if(obj==null)
				System.out.println("=======空========");
			
			String[] ips = new String[2];
			ips[0] = "10.1.6.12";
			ips[1] = "10.1.6.13";
			ExcuteResultVO rVO = new ExcuteResultVO ();
			
//			ChannelVO.recordEX_pausePlay
//			
//			obj.getChannelVO().getRecordEX_status();
			
			
			//通道状态
//			 rVO = obj.channelStatus(0);
//			 if(rVO.isSuccess()){
//				 System.out.println("成功");
//			 }else
//				 System.out.println("失败："+rVO.getDes());
			 
			//链接
//			 rVO = obj.connect(0, 0, ips);
//			 if(rVO.isSuccess())
//				 System.out.println("链接成功");
//			 else
//				 System.out.println("失败："+rVO.getDes());
//			 Thread.sleep(10*1000);
			 
//			 //开始录制
//			rVO = obj.play("t123abc0711", 0);
//			if(rVO.isSuccess())
//				System.out.println("录制成功");
//			else
//				System.out.println("失败："+rVO.getDes());
//			Thread.sleep(10*1000);
//			rVO = obj.getRecordStatus(0);
//			if(rVO.isSuccess())
//				System.out.println("录制状态：：：：：：：："+rVO.getObject());
//			else
//				System.out.println("失败："+rVO.getDes());
			
//			 //暂停录制
//			rVO = obj.pausePlay(0);
//			if(rVO.isSuccess())
//				System.out.println("暂停成功");
//			else
//				System.out.println("失败："+rVO.getDes());
//			Thread.sleep(10*1000);
			rVO = obj.getRecordStatus(0);
			if(rVO.isSuccess())
				System.out.println("暂停录制状态：：：：：：：："+rVO.getObject());
			else
				System.out.println("失败："+rVO.getDes());
//			//继续录制
//			rVO = obj.continuePlay(0);
//			if(rVO.isSuccess())
//				System.out.println("成功");
//			else
//				System.out.println("失败："+rVO.getDes());

//			//停止录制
//			rVO = obj.stopPlay(0);
//			if(rVO.isSuccess())
//				System.out.println("停止成功");
//			else
//				System.out.println("失败："+rVO.getDes());
//			Thread.sleep(2000);
//			rVO = obj.getRecordStatus(0);
//			if(rVO.isSuccess())
//				System.out.println("停止录制状态：：：：：：：："+rVO.getObject());
//			else
//				System.out.println("失败："+rVO.getDes());
			
//			//挂断
//			rVO = obj.unConnect(0);
//			if(rVO.isSuccess())
//				System.out.println("挂断成功");
//			else
//				System.out.println("失败："+rVO.getDes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDate(){
		ArrayList<ReachVO> list = new ArrayList<ReachVO>();
		ReachVO vo = new ReachVO();
		vo.setServerIP("10.1.6.11");
		vo.setServerPort(23);
		vo.setServerType(ReachVO.cm200);
		list.add(vo);
		ControlFactory.ReachInitDate(list);
	}
}
