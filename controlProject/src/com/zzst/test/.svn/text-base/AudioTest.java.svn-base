package com.zzst.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.audio.service.AudioObject;
import com.zzst.audio.service.vo.AudioVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description
 *@date 2012-10-27下午09:25:41
 *@author ryan
 */
public class AudioTest { 

	private static String ip = "11.63.50.150";
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件 
//		try {
			new AudioTest().initDate();

			AudioObject obj = ControlFactory.getAudioObject(ip);
			while(true){
				System.out.println("############"+obj.getStatus());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
//			if(obj==null){
//				System.out.println("对象为空，异常");
//				return;
//			}
//			ExcuteResultVO reVO = obj.c16GetMuteStatus("test");//提取静音状态
//			if(reVO.isSuccess()){
//				 AudioVO audioVO = (AudioVO)reVO.getObject();
//				 System.out.println("=="+audioVO.getMuteStatus());
//			}
//			reVO = obj.c16GetOutLevelNum("test");//提取输出的level值
//			if(reVO.isSuccess()){
//				 AudioVO audioVO = (AudioVO)reVO.getObject();
//				 System.out.println("=="+audioVO.getOutLevelNum());
//			}
//			
//			reVO = obj.c16SetInLevelNum("sdfs","54");//设置输入的level值
//			if(reVO.isSuccess()){
//				 AudioVO audioVO = (AudioVO)reVO.getObject();
//				 System.out.println("=="+audioVO.getInLevelNum());
//			}
//			
//			reVO = obj.c16GetInLevelNum("sdfs");//提取输入的level值
//			if(reVO.isSuccess()){
//				 AudioVO audioVO = (AudioVO)reVO.getObject();
//				 System.out.println("=="+audioVO.getInLevelNum());
//			}
//			
//			
//			
////			obj.c16SetMuteON("terr");
////			Thread.sleep(5000);
////			obj.c16SetMuteOFF("terr");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	public void initDate(){ 
		Map<String,String[]> map = new HashMap<String,String[]>();
		String[] audio = new String[3];
		audio[0]=ip;
		audio[1]="52774";
		audio[2]="c16";
		
		map.put(ip, audio);
		ControlFactory.audioInitDate(map);
	}

}
