package com.zzst.kst.org.tempuri;




public interface VciSoap {
    
	public String getCamerasByGroupName(String groupName);
	public String getCamerasByGroupID(String groupGUID);
	public String getCamerasByDomainID();
	public String getGroupsByDomainID(String domainGUID);
	public String getGroupsByDomainID2(String domainGUID);
	public String getUserCameraTreeNodes( int userId);
	public String checkUser(String username,String password);
	public String getTvWallPreset();
	public int execTvWallPreset(int presetid);
	public String getTvWallStatus();
	public String getCameraPresets( int cameraId);
	public int deletePreset( int cameraId,int presetIndex);
	public int startRecordDownload(int cameraId,String startTimeString,String stopTimeString);
	public String queryVodUrl( int cameraId, String startTimeString,String stopTimeString);
	public String getDevicemesg();
	public String querySnapshotByCamera( int cameraId, String beginTime, String endTime);
	public String querySnapshotByCar( String plateNum,String beginTime,String endTime);

}
