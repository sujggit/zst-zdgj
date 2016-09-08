package com.zzst.model.meeting.levelConfig;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.enums.LevelEnum;
import com.zzst.model.meeting.level.LevelVO;

/**
 * class description: LevelConfig Object
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public class LevelConfigVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String levelID;
	private String levelKey;
	private String levelType;
	private int superPower = Integer.MIN_VALUE;
	private String createUserId;
	private Timestamp createTime;
	private int status = Integer.MIN_VALUE;
	private String description;
	private long revision = Long.MIN_VALUE;
	private String levelKeyName;
	private String lid;
	
	private LevelVO levelVO = new LevelVO();
	private Object object;//userVO,meetingroomVO...

	public void setLevelID(String levelID) {
		this.levelID = levelID;
	}

	public String getLevelID() {
		return levelID;
	}

	public void setLevelKey(String levelKey) {
		this.levelKey = levelKey;
	}

	public String getLevelKey() {
		return levelKey;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getLevelType() {
		return levelType;
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

	public String getLevelKeyName() {
		return levelKeyName;
	}

	public void setLevelKeyName(String levelKeyName) {
		this.levelKeyName = levelKeyName;
	}

	public LevelVO getLevelVO() {
		return levelVO;
	}

	public void setLevelVO(LevelVO levelVO) {
		this.levelVO = levelVO;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getSuperPower() {
		return superPower;
	}

	public void setSuperPower(int superPower) {
		this.superPower = superPower;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

}
