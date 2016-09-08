package com.zzst.centerContor.vo;


/**
 *@Description
 *@date 2011-12-31上午09:50:55
 *@author ryan
 */
public class CameraVO {

	public static final String autoStack_on = "0";
	public static final String autoStack_off = "1";
	
	public static final String speed_1 = "1";
	public static final String speed_2 = "2";
	public static final String speed_3 = "3";
	
	
	private String id;
	private String name;
	
	//0是ID 1是显示名称
	private String[][] storeAll = null; //所有预置位
	//是ID
	private String store = null; //当前调用的预置位
	
	private String speed = speed_2;//移动速度
	private String autoTrack = autoStack_off;
	private boolean statusAutoTrack = false;//是否支持自动跟踪
	
	//ADD BY RYAN ON 2013-7-16
	private boolean backLight = true;//是否为自动背光
	
	private boolean exposureManual = true;//是否为自动曝光
	private int exposureManuaGain = Integer.MIN_VALUE;//增益
	private String exposureManuaIris ;//光圈
	private String exposureManuaSpeed ;//快门
	
	private boolean whiteBalanceManual = true;//是否为自动白平衡
	private int whiteBalanceManualB = Integer.MIN_VALUE;//白平衡-蓝
	private int whiteBalanceManualR = Integer.MIN_VALUE;//白平衡-红 
	
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

	public boolean isWhiteBalanceManual() {
		return whiteBalanceManual;
	}

	public void setWhiteBalanceManual(boolean whiteBalanceManual) {
		this.whiteBalanceManual = whiteBalanceManual;
	}

	public int getWhiteBalanceManualB() {
		return whiteBalanceManualB;
	}

	public void setWhiteBalanceManualB(int whiteBalanceManualB) {
		this.whiteBalanceManualB = whiteBalanceManualB;
	}

	public int getWhiteBalanceManualR() {
		return whiteBalanceManualR;
	}

	public void setWhiteBalanceManualR(int whiteBalanceManualR) {
		this.whiteBalanceManualR = whiteBalanceManualR;
	}

	public int getExposureManuaGain() {
		return exposureManuaGain;
	}

	public void setExposureManuaGain(int exposureManuaGain) {
		this.exposureManuaGain = exposureManuaGain;
	}

	public boolean isExposureManual() {
		return exposureManual;
	}

	public void setExposureManual(boolean exposureManual) {
		this.exposureManual = exposureManual;
	}

	public String getExposureManuaIris() {
		return exposureManuaIris;
	}

	public void setExposureManuaIris(String exposureManuaIris) {
		this.exposureManuaIris = exposureManuaIris;
	}

	public String getExposureManuaSpeed() {
		return exposureManuaSpeed;
	}

	public void setExposureManuaSpeed(String exposureManuaSpeed) {
		this.exposureManuaSpeed = exposureManuaSpeed;
	}

	public boolean getStatusAutoTrack() {
		return statusAutoTrack;
	}

	public void setStatusAutoTrack(boolean statusAutoTrack) {
		this.statusAutoTrack = statusAutoTrack;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	/**
	 * 提取摄像头所有转速
	 * @return String[][] 0是ID 1是显示名称
	 */
	public String[][] getAllSpeed(){
		String[][] speed = new String[2][];
		speed[0][0] = speed_1;
		speed[0][1] = "慢";
		speed[1][0] = speed_2;
		speed[1][1] = "中";
		speed[2][0] = speed_3;
		speed[2][1] = "快";
		return speed;
	}
	
	/**
	 * 提取摄像头所有预置位
	 * @return String[][]
	 */
	public String[][] getStoreAll() {
		if(storeAll==null) return new String[0][];
		return storeAll;
	}
	
	public void setStoreAll(String[][] storeAll) {
		this.storeAll = storeAll;
	}
	
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAutoTrack() {
		return autoTrack;
	}

	public void setAutoTrack(String autoTrack) {
		this.autoTrack = autoTrack;
	}

	public boolean isBackLight() {
		return backLight;
	}

	public void setBackLight(boolean backLight) {
		this.backLight = backLight;
	}
	
	
	
}
