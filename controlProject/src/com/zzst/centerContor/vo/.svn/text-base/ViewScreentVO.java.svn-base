package com.zzst.centerContor.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.centerContor.service.CenterControlObjectHelp;


/**
 *@Description	大屏对象
 *@date 2011-12-20下午04:52:20
 *@author ryan
 */
public class ViewScreentVO {
	
	//大屏信号切换方式
	public static final String model_SWITCH_MATRIX = "MATRIX";
	public static final String model_SWITCH_MODEL = "MODEL";
	
	//大屏信号格式
	public static final String model_type_AV = "AV";
	public static final String model_type_RGB = "RGB";
	
	public static final String status_on = "0";
	public static final String status_off = "1";
	public static final String status_def = "-1";
	 
	private String id; //中控能设备定义ID
	private String name;
	private String type ;//大屏当前支持的输入格式（）
	private String status = status_def;
	private String model;//大屏当前模式 如：300或者200
	private String modelNum = "";//大屏屏数  3*5
	private String[][] allModel;//大屏所有模式 如：10 全屏
	private String switchType = model_SWITCH_MATRIX;//大屏信号切换方式
	/**
	 * 13#AV,6#AV
	 */
	private Map<String,String> allModelSwitchOutPort		= new HashMap<String,String>();//模式对应的矩阵输出端口 ，key为模式ID+输入格式，逻辑是：从左到右，从上到下排序
	private Map<String,String> allModelSwitchOutPortType	= new HashMap<String,String>();//模式中对应矩阵输出的格式 ,key为模式ID+输入格式 如：2分屏中的左屏输入是AV
	
	
	private Map<String,String> allModelType	= new HashMap<String,String>();//模式对应的输入格式 key为模式ID+输入格式
	 
//	private ArrayList<ViewScreentViewVO> modelViewList = new ArrayList<ViewScreentViewVO>();//大屏模式显示集合 
//	private Map<String,String> modelInfoMap	= new HashMap<String,String>();//模式对应窗口详细信息
	private String[] modelInfo	= null;//模式对应窗口详细信息 0为句柄 1 为信号源名称

	/**
	 * 设备是否可用
	 */
	private boolean available = true;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String[] getModelInfo() {
		return modelInfo;
	}

	public void addModelInfo(String[] str) {
		modelInfo = str;
	}
	
	public void clearModelInfo() {
		modelInfo = null;
	}
	
	/**
	 * 大屏当前模式的显示样式
	 */
	public String getModelViewStr(int def_px) {
		String reStr="";
		ArrayList<ViewScreentViewVO> modelViewList = CenterControlObjectHelp.modelViewList;
		if(model!=null&&model.length()>0&&modelViewList!=null&&modelViewList.size()>0){
			for(ViewScreentViewVO vsv:modelViewList){
				String key = modelNum+"*"+model;
				if(key.equalsIgnoreCase(vsv.getModel())){
					reStr +=  vsv.getViewStr(def_px);
				}
			}
		}
		if(reStr==null||reStr.length()==0)
			reStr = "<img width='100%' height='100%' src='/icmp/images/blue/model_ing.png' alt='提取中..'/>";
		
		return reStr;
	}
	
//	public ArrayList<ViewScreentViewVO> getModelViewList() {
//		return modelViewList;
//	}
//
//	public void setModelViewList(ArrayList<ViewScreentViewVO> modelViewList) {
//		this.modelViewList = modelViewList;
//	}

	public Map<String, String> getAllModelType() {
		return allModelType;
	}

	public void setAllModelType(Map<String, String> allModelType) {
		this.allModelType = allModelType;
	}

	public Map<String, String> getAllModelSwitchOutPortType() {
		return allModelSwitchOutPortType;
	}

	public void setAllModelSwitchOutPortType(Map<String, String> allModelSwitchOutPortType) {
		this.allModelSwitchOutPortType = allModelSwitchOutPortType;
	}

	public String getSwitchType() {
		return switchType;
	}

	public void setSwitchType(String switchType) {
		this.switchType = switchType;
	}

	public String getModelSwitchOutPort(String modelNO) {
		if(modelNO!=null&&modelNO.length()>0){
			return allModelSwitchOutPort.get(modelNO);
		}
		return null;
	}
	
	public void setAllModelSwitchOutPort(Map<String, String> allModelSwitchOutPort) {
		this.allModelSwitchOutPort = allModelSwitchOutPort;
	}
	public String[][] getAllModel() {
		return allModel;
	}
	public void setAllModel(String[][] allModel) {
		this.allModel = allModel;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	
	
	
}
