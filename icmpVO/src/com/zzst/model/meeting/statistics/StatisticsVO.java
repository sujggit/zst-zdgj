package com.zzst.model.meeting.statistics;

import java.sql.Timestamp;

/**
 * @author ryan
 * @date 2009-8-31
 */
public class StatisticsVO {

	private static final long serialVersionUID = -7604294165736958663L;
	
	private Timestamp startTime;
	
	private Timestamp endTime;
	
	private Integer statisticsType=Integer.MIN_VALUE;

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Integer getStatisticsType() {
		return statisticsType;
	}

	public void setStatisticsType(Integer statisticsType) {
		this.statisticsType = statisticsType;
	}
}
