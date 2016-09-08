package com.zzst.model.meeting.level;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: LevelGrade Object
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public class LevelVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String levelID;
	private String levelName;
	private String pId;
	private String levelPath;
	private String createUserId;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private String description;
	private long revision = Long.MIN_VALUE;
	private int nodeServer = Integer.MIN_VALUE;//是否节点服务器标识。0是，1不是
	private String nodeIP;//节点服务器信息~~IP
	private int nodePort = Integer.MIN_VALUE;//节点服务器信息~~端口号
	
	
	private String levelKeyNames1;//分级配置的集合
	private String levelKeyNames2;
	private String levelKeyIds1;;//分级配置的id集合
	private String levelKeyIds2;;//分级配置的id集合
	
	private String className;

	
	
	public String getNodeIP() {
		return nodeIP;
	}

	public void setNodeIP(String nodeIP) {
		this.nodeIP = nodeIP;
	}

	
	public int getNodePort() {
		return nodePort;
	}

	public void setNodePort(int nodePort) {
		this.nodePort = nodePort;
	}

	public int getNodeServer() {
		return nodeServer;
	}

	public void setNodeServer(int nodeServer) {
		this.nodeServer = nodeServer;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}

	public String getLevelID() {
		return levelID;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public String getPId() {
		return pId;
	}

	public void setLevelPath(String levelPath) {
		this.levelPath = levelPath;
	}

	public String getLevelPath() {
		return levelPath;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}
	
	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getLevelKeyNames1() {
		return levelKeyNames1;
	}

	public void setLevelKeyNames1(String levelKeyNames1) {
		this.levelKeyNames1 = levelKeyNames1;
	}

	public String getLevelKeyNames2() {
		return levelKeyNames2;
	}

	public void setLevelKeyNames2(String levelKeyNames2) {
		this.levelKeyNames2 = levelKeyNames2;
	}

	public String getLevelKeyIds1() {
		return levelKeyIds1;
	}

	public void setLevelKeyIds1(String levelKeyIds1) {
		this.levelKeyIds1 = levelKeyIds1;
	}

	public String getLevelKeyIds2() {
		return levelKeyIds2;
	}

	public void setLevelKeyIds2(String levelKeyIds2) {
		this.levelKeyIds2 = levelKeyIds2;
	}

}
