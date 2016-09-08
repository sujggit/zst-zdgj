package com.zzst.util.initDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.centerContor.service.impl.AudioControlImpl;
import com.zzst.centerContor.vo.CenterControlVO;


/**
 *@Description
 *@date 2011-12-31下午03:56:32
 *@author ryan
 */
public class CCEquipmentDAO {
	private static Logger logger = Logger.getLogger(AudioControlImpl.class
			.getName());
	public static ArrayList<CenterControlVO> getCCequipmentList(String ccIP){
		ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
		try{
			if(ccIP==null||ccIP.length()==0) return null;
				
			StringBuffer sb = new StringBuffer();
			sb.append( "select id,ccIP,ccNO,equipmentIP,equipmentType,euipmentName,controlInitDate ");
			sb.append(" from z_t_pub_centercontrol ");
			sb.append(" where ccIP =  '"+ccIP+"'");
			sb.append(" order by equipmentType,euipmentName ASC ");
			logger.info("sql："+sb.toString());
			Connection conn = ConnnectDB.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs   = stmt.executeQuery(sb.toString());
			  
			  if( rs!= null)
			  {
				  while(rs.next()){
					  CenterControlVO ccVO = new CenterControlVO();
						ccVO.setId(rs.getString("id"));
						ccVO.setIp(rs.getString("ccIP"));
						ccVO.setCcNO(rs.getString("ccNO"));
						ccVO.setEquipmentIP(rs.getString("equipmentIP"));
						ccVO.setEquipmentType(rs.getString("equipmentType"));
						ccVO.setEuipmentName(rs.getString("euipmentName"));
						ccVO.setControlInitDate(rs.getString("controlInitDate"));
						ccList.add(ccVO);
				  }
				 
			  }
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			logger.error("加载中控--控制设备提取异常："+e.getMessage());
		}
		return ccList;
	}
	
	/**
	 * 根据中控IP提取大屏模式显示样式
	 * @param ccIP
	 * @return
	 */
	public static ArrayList<CenterControlVO> getScreenViewList(String ccIP){
		ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
		try{
			if(ccIP==null||ccIP.length()==0) return null;
				
			StringBuffer sb = new StringBuffer();
			sb.append( "select id,ccIP,ccNO,equipmentIP,equipmentType,euipmentName,controlInitDate ");
			sb.append(" from z_t_pub_centercontrol ");
			sb.append(" where ccIP =  '"+ccIP+"'");
			sb.append(" and equipmentType =  '"+CenterControlObjectHelp.control_type_screent_view+"'");
			
			logger.info("sql："+sb.toString());
			Connection conn = ConnnectDB.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs   = stmt.executeQuery(sb.toString());
			  
			  if( rs!= null)
			  {
				  while(rs.next()){
					  CenterControlVO ccVO = new CenterControlVO();
						ccVO.setId(rs.getString("id"));
						ccVO.setId(rs.getString("ccIP"));
						ccVO.setCcNO(rs.getString("ccNO"));
						ccVO.setEquipmentIP(rs.getString("equipmentIP"));
						ccVO.setEquipmentType(rs.getString("equipmentType"));
						ccVO.setEuipmentName(rs.getString("euipmentName"));
						ccVO.setControlInitDate(rs.getString("controlInitDate"));
						ccList.add(ccVO);
				  }
			  }
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			logger.error("加载中控--大屏设备显示模式提取异常："+e.getMessage());
		}
		return ccList;
	}
	
	/**
	 * 提取大屏模式显示样式
	 * @return
	 */
	public static ArrayList<CenterControlVO> getScreenViewList(){
		ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
		try{
				
			StringBuffer sb = new StringBuffer();
			sb.append( "select id,ccIP,ccNO,equipmentIP,equipmentType,euipmentName,controlInitDate ");
			sb.append(" from z_t_pub_centercontrol ");
			sb.append(" where equipmentType =  '"+CenterControlObjectHelp.control_type_screent_view+"'");
			
			logger.info("sql："+sb.toString());
			Connection conn = ConnnectDB.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs   = stmt.executeQuery(sb.toString());
			  
			  if( rs!= null)
			  {
				  while(rs.next()){
					  CenterControlVO ccVO = new CenterControlVO();
						ccVO.setId(rs.getString("id"));
						ccVO.setId(rs.getString("ccIP"));
						ccVO.setCcNO(rs.getString("ccNO"));
						ccVO.setEquipmentIP(rs.getString("equipmentIP"));
						ccVO.setEquipmentType(rs.getString("equipmentType"));
						ccVO.setEuipmentName(rs.getString("euipmentName"));
						ccVO.setControlInitDate(rs.getString("controlInitDate"));
						ccList.add(ccVO);
				  }
			  }
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			logger.error("加载中控--大屏设备显示模式提取异常："+e.getMessage());
		}
		return ccList;
	}
}
