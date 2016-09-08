package com.zzst.centerContor.service;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.centerContor.service.impl.communication.ReturnValueThread;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.DvdVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.TvVO;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.VedioTerminalVO;
import com.zzst.centerContor.vo.VideomVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.centerContor.vo.ViewScreentViewVO;


/**
 *@Description
 *@date 2011-12-19上午11:16:43
 *@author ryan
 */
public class CenterControlObjectHelp {

	
	/**
	 * 矩阵切换时，最小间隔时间 xxx毫秒
	 */
	public static final	long DEF_MIN = 100;
	//矩阵类型
	public static final String matrix_type_RGB = "1";
	public static final String matrix_type_DVI = "2";
	public static final String matrix_type_AV = "3";
	public static final String matrix_type_HDSDI = "4";
	public static final String matrix_type_VGA = "5";
	
	public static final String control_type_matrix	 = "matrix";//矩阵
	public static final String control_type_audio	 = "audio";//音频
	public static final String control_type_sysPower = "sysPower";//系统电源
	public static final String control_type_screent  = "screent";//大屏
	public static final String control_type_screent_view  = "screent_view";//大屏模式的显示样式
	public static final String control_type_vedioTerminal = "vedioTerminal";//终端
	public static final String control_type_camera = "camera";//摄像头
	public static final String control_type_pla = "pla";//等离子
	public static final String control_type_upDownScreen = "upDownScreen";//升降屏
	public static final String control_type_light = "light";//灯光
	public static final String control_type_dvd = "dvd";//DVD
	public static final String control_type_proj = "proj";//投影机
	public static final String control_type_curtain = "curtain";//窗帘
	public static final String control_type_tv = "tv";//机顶盒
	public static final String control_type_videom = "videom";//画面分割器
	public static final String control_type_roomModel = "roomModel";//会议室组合键
	
	public static Map<String,Boolean> flagMap = new HashMap<String,Boolean>();//长连接线程跳出循环标示
	public static Map<String,Socket> socketMap = new HashMap<String,Socket>();//通讯长连接
	public static Map<String,ReturnValueThread> threadMap = new HashMap<String,ReturnValueThread>();
	
	/**
	 * 中控下的设备类型列表
	 * 0ID
	 */
	public static Map<String,String>  equipmentMap = new HashMap<String,String>();
	
	//会议室组合键
	public static Map<String,HashMap<String,RoomModelVO>>  RoomModelVOMap = new HashMap<String,HashMap<String,RoomModelVO>>();
	
	//画面分割器设备
	public static Map<String,HashMap<String,VideomVO>>  videomVOMap = new HashMap<String,HashMap<String,VideomVO>>();
	
	//摄像头设备
	public static Map<String,HashMap<String,CameraVO>>  cameraVoMap = new HashMap<String,HashMap<String,CameraVO>>();// matrixVOList = new ArrayList<MatrixSwitchVO>();
	
	//缓存矩阵个数
	public static Map<String,HashMap<String,MatrixSwitchVO>>  matrixVoMap = new HashMap<String,HashMap<String,MatrixSwitchVO>>();// matrixVOList = new ArrayList<MatrixSwitchVO>();
	
	//音频设备
	public static Map<String,HashMap<String,AudioControlVO>>  audioMap = new HashMap<String,HashMap<String,AudioControlVO>>();
	
	//视频终端
	public static Map<String,HashMap<String,VedioTerminalVO>>  vedioTerminalMap = new HashMap<String,HashMap<String,VedioTerminalVO>>();
	
	//系统电源
	public static Map<String,HashMap<String,SysPowerVO>>  sysPowerMap = new HashMap<String,HashMap<String,SysPowerVO>>();
	
	//显示屏
	public static Map<String,HashMap<String,ViewScreentVO>>  viewScreentMap = new HashMap<String,HashMap<String,ViewScreentVO>>();

	//大屏模式的显示样式
	public static ArrayList<ViewScreentViewVO> modelViewList = new ArrayList<ViewScreentViewVO>();//大屏显示样式的集合
	
	//等离子
	public static Map<String,HashMap<String,PlaVO>>  plaMap = new HashMap<String,HashMap<String,PlaVO>>();
	
	//升降屏
	public static Map<String,HashMap<String,UpDownScreenVO>>  upDownScreenMap = new HashMap<String,HashMap<String,UpDownScreenVO>>();
	
	//灯光
	public static Map<String,HashMap<String,LightVO>>  lightMap = new HashMap<String,HashMap<String,LightVO>>();
	
	//	DVD设备
	public static Map<String,HashMap<String,DvdVO>>  dvdVoMap = new HashMap<String,HashMap<String,DvdVO>>();
	
	//	投影机设备
	public static Map<String,HashMap<String,ProjVO>>  projVoMap = new HashMap<String,HashMap<String,ProjVO>>();
	 
	//	窗帘控制
	public static Map<String,HashMap<String, CurtainVO>> curtainMap = new HashMap<String, HashMap<String, CurtainVO>>();
	
	//机顶盒控制
	public static Map<String,HashMap<String, TvVO>> tvMap = new HashMap<String, HashMap<String,  TvVO>>();
	
	/**
	 * 会议室组合键
	 * @param list
	 * @return boolean
	 */
	public static boolean initRoomModelDate (String ccIP,ArrayList<RoomModelVO> list){
		HashMap<String, RoomModelVO> hm = new HashMap<String, RoomModelVO>();
		for(RoomModelVO sv : list){
			hm.put(sv.getId(), sv);
		}
		RoomModelVOMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化画面分割器设备
	 * @param list
	 * @return boolean
	 */
	public static boolean initVideomDate (String ccIP,ArrayList<VideomVO> list){
		HashMap<String, VideomVO> hm = new HashMap<String, VideomVO>();
		for(VideomVO sv : list){
			hm.put(sv.getId(), sv);
		}
		videomVOMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化机顶盒数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initTvDate (String ccIP,ArrayList<TvVO> list){
		HashMap<String, TvVO> hm = new HashMap<String, TvVO>();
		for(TvVO sv : list){
			hm.put(sv.getId(), sv);
		}
		tvMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化窗帘数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initCurtainDate (String ccIP,ArrayList<CurtainVO> list){
		HashMap<String, CurtainVO> hm = new HashMap<String, CurtainVO>();
		for(CurtainVO sv : list){
			hm.put(sv.getId(), sv);
		}
		curtainMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 返回窗帘设备列表
	 * @return HashMap<String,CurtainVO>
	 */
	public static HashMap<String,CurtainVO> getCurtainList (String ccIP){
		return curtainMap.get(ccIP);
	}
	
	/**
	 * 初始化投影机设备数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initProjDate (String ccIP,ArrayList<ProjVO> list){
		HashMap<String,ProjVO> hm = new HashMap<String,ProjVO>();
		for(ProjVO sv : list){
			hm.put(sv.getId(), sv);
		}
		projVoMap.put(ccIP, hm);
		return true;
	}
	/**
	 * 初始化dvd设备数据
	 * @param list
	 * @return
	 */
	public static boolean initDVDDate (String ccIP,ArrayList<DvdVO> list){
		HashMap<String,DvdVO> hm = new HashMap<String,DvdVO>();
		for(DvdVO sv : list){
			hm.put(sv.getId(), sv);
		}
		dvdVoMap.put(ccIP, hm);
		return true;
	}
	/**
	 * 初始化灯光设备数据
	 * @param list
	 * @return
	 */
	public static boolean initLightDate (String ccIP,ArrayList<LightVO> list){
		HashMap<String,LightVO> hm = new HashMap<String,LightVO>();
		for(LightVO sv : list){
			hm.put(sv.getId(), sv);
		}
		lightMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化升降屏设备数据
	 * @param list
	 * @return
	 */
	public static boolean initUpDownScreenDate (String ccIP,ArrayList<UpDownScreenVO> list){
		HashMap<String,UpDownScreenVO> hm = new HashMap<String,UpDownScreenVO>();
		for(UpDownScreenVO sv : list){
			hm.put(sv.getId(), sv);
		}
		upDownScreenMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化等离子设备数据
	 * @param list
	 * @return
	 */
	public static boolean initPlaDate (String ccIP,ArrayList<PlaVO> list){
		HashMap<String,PlaVO> hm = new HashMap<String,PlaVO>();
		for(PlaVO sv : list){
			hm.put(sv.getId(), sv);
		}
		plaMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化摄像头设备数据
	 * @param ccIP
	 * @param ArrayList<CameraVO>
	 * @return boolean
	 */
	public static boolean initCameraDate (String ccIP,ArrayList<CameraVO> list){
		HashMap<String,CameraVO> hm = new HashMap<String,CameraVO>();
		for(CameraVO sv : list){
			hm.put(sv.getId(), sv);
		}
		cameraVoMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化视频终端设备数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initVedioTerminalDate (String ccIP,ArrayList<VedioTerminalVO> list){
		HashMap<String,VedioTerminalVO> hm = new HashMap<String,VedioTerminalVO>();
		for(VedioTerminalVO vv : list){
			hm.put(vv.getId(), vv);
		}
		vedioTerminalMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化系统电源设备数据
	 * @param list
	 * @return
	 */
	public static boolean initSysPowerDate (String ccIP,ArrayList<SysPowerVO> list){
		HashMap<String,SysPowerVO> hm = new HashMap<String,SysPowerVO>();
		for(SysPowerVO sv : list){
			hm.put(sv.getId(), sv);
		}
		sysPowerMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化大屏设备数据
	 * @param list
	 * @return
	 */
	public static boolean initViewScreentDate (String ccIP,ArrayList<ViewScreentVO> list){
		HashMap<String,ViewScreentVO> hm = new HashMap<String,ViewScreentVO>();
		for(ViewScreentVO sv : list){
			hm.put(sv.getId(), sv);
		}
		viewScreentMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化大屏设备显示模式数据
	 * @param list
	 * @return
	 */
//	public static boolean initViewScreentViewDate (String ccIP,HashMap<String,String> map){
//		viewScreentViewMap.put(ccIP, map);
//		return true;
//	}
	/**
	 * 初始化大屏不同模式的显示样式
	 * @param list
	 * @return
	 */
	public static boolean initViewScreentViewDate(ArrayList<ViewScreentViewVO> list) {
		modelViewList = list;
		return true;
	}
	
	/**
	 * 初始化音频设备数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initAudioDate (String ccIP,ArrayList<AudioControlVO> list){
		HashMap<String,AudioControlVO> hm = new HashMap<String,AudioControlVO>();
		for(AudioControlVO av : list){
			hm.put(av.getId(), av);
		}
		audioMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 初始化矩阵数据
	 * @param list
	 * @return boolean
	 */
	public static boolean initMatrixDate (String ccIP,ArrayList<MatrixSwitchVO> list){
		HashMap<String,MatrixSwitchVO> hm = new HashMap<String,MatrixSwitchVO>();
		for(MatrixSwitchVO av : list){
			hm.put(av.getId(), av);
		}
		matrixVoMap.put(ccIP, hm);
		return true;
	}
	
	/**
	 * 返回机顶盒设备列表
	 * @return HashMap<String,ProjVO>
	 * @author ryan
	 * @date 2012-10-20
	 */
	public static HashMap<String,TvVO> getTvList (String ccIP){
		return tvMap.get(ccIP);
	}
	
	/**
	 * 返回投影机设备列表
	 * @return HashMap<String,ProjVO>
	 * @author ryan
	 * @date 2012-10-16下午01:01:50
	 */
	public static HashMap<String,ProjVO> getProjList (String ccIP){
		return projVoMap.get(ccIP);
	}
	
	
	/**
	 * 返回DVD设备列表
	 * @return
	 */
	public static HashMap<String,DvdVO> getDvdList (String ccIP){
		return dvdVoMap.get(ccIP);
	}
	
	/**
	 * 返回灯光设备列表
	 * @return
	 */
	public static HashMap<String,LightVO> getLightList (String ccIP){
		return lightMap.get(ccIP);
	}
	
	/**
	 * 返回会议室组合键列表
	 * @return
	 */
	public static HashMap<String,RoomModelVO> getRoomModelVOList (String ccIP){
		return RoomModelVOMap.get(ccIP);
	}
	
	/**
	 * 返回等离子设备列表
	 * @return
	 */
	public static HashMap<String,PlaVO> getPlaList (String ccIP){
		return plaMap.get(ccIP);
	}
	
	/**
	 * 返回升降屏设备列表
	 * @return
	 */
	public static HashMap<String,UpDownScreenVO> getUpDownScreenList (String ccIP){
		return upDownScreenMap.get(ccIP);
	}
	
	/**
	 * 返回音频设备列表
	 * @return
	 */
	public static HashMap<String,AudioControlVO> getAudioList (String ccIP){
		return audioMap.get(ccIP);
	}
	
	/**
	 * 返回矩阵列表
	 * @return ArrayList<MatrixSwitchVO>
	 */
	public static HashMap<String,MatrixSwitchVO> getMatrixList (String ccIP){
		return matrixVoMap.get(ccIP);
	}
	
	/**
	 * 返回视频终端列表
	 * @return
	 */
	public static HashMap<String,VedioTerminalVO> getVedioTerminalList (String ccIP){
		return vedioTerminalMap.get(ccIP);
	}
	
	/**
	 * 返回系统电源设备列表
	 * @return
	 */
	public static HashMap<String,SysPowerVO> getSysPowerList (String ccIP){
		return sysPowerMap.get(ccIP);
	}
	
	/**
	 * 返回大屏设备列表
	 * @param ccIP
	 * @return
	 */
	public static HashMap<String,ViewScreentVO> getViewScreentList (String ccIP){
		return viewScreentMap.get(ccIP);
	}
	
	/**
	 * 返回摄像头设备列表
	 * @return
	 */
	public static HashMap<String,CameraVO> getCameraList (String ccIP){
		return cameraVoMap.get(ccIP);
	}
	
	
	/**
	 * 返回画面分割器设备列表
	 * @return
	 */
	public static HashMap<String,VideomVO> getVideomList (String ccIP){
		return videomVOMap.get(ccIP);
	}
	
	/**
	 * 注册---中控下可以控制的设备
	 * @param equipmentType
	 * @param name
	 * @return
	 */
	public static boolean addEquipment (String equipmentType){
		if(equipmentType!=null&&equipmentType.length()!=0)
			if(equipmentMap.get(equipmentType)==null)
				equipmentMap.put(equipmentType, equipmentType);
		return true;
	}
	
	/**
	 * 删除---中控下可以控制的设备
	 * @param equipmentType
	 * @param name
	 * @return
	 */
	public static boolean removeEquipment (String equipmentType){
 
		return true;
	}
}
