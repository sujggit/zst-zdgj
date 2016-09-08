package com.zzst.action.meeting.autocompare;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.autocompare.histogram.HistogramUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.user.UserVO;

public class VideoCardCompareAction extends CjfAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = CjfLogger.getLogger(VideoCardCompareAction.class.getName());
	private ComparisonCriteriaVO comparisonCriteriaVO;
	private ArrayList<ComparisonCriteriaVO>  comparisonCriteriaVOList =new ArrayList<ComparisonCriteriaVO>();
	private ComparisonReferenceVO comparisonReferenceVO;
	private ArrayList<ComparisonReferenceVO>  comparisonReferenceVOList =new ArrayList<ComparisonReferenceVO>();
	
	
	
	public String compareCriteria(){
		logger.info("VideoCardCompareAction	compareCriteria	begin");		
		try{
			//考虑第一次登陆表为空时 添加日志 前台数据 验证
			comparisonCriteriaVOList=ServiceFactory.getConparisonCriteriaService().query(comparisonCriteriaVO, null);
		   //System.out.println("......."+comparisonCriteriaVOList.size());
			//if(comparisonCriteriaVOList.size()>0){
			if(comparisonCriteriaVOList.size()==0){
				comparisonCriteriaVO=new ComparisonCriteriaVO();
				comparisonCriteriaVO.setX_min(30);
				comparisonCriteriaVO.setX_max(235);
				ServiceFactory.getConparisonCriteriaService().add(comparisonCriteriaVO);
			}else{
				comparisonCriteriaVO=comparisonCriteriaVOList.get(0);
				}
				
			//}
			//comparisonCriteriaVO=new ComparisonCriteriaVO();
			//this.getCurHttpServletRequest().setAttribute("comparisonCriteriaVO", comparisonCriteriaVO);
		}catch(Exception e){
			logger.error("VideoCardCompareAction	compareCriteria	error:"+e.getMessage());
		}
		logger.info("VideoCardCompareAction	compareCriteria	end");
		return SUCCESS;
	}

	
	

	public String compareCriteriaModify(){
		logger.info("VideoCardCompareAction	compareCriteriaModify	begin");		
		try{
			//x_min和x_max改了同步标准表里面的面积
			comparisonReferenceVOList=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO, null);			
			
			for (int i=0;i<comparisonReferenceVOList.size();i++) {
				ComparisonReferenceVO v=new ComparisonReferenceVO();
				v=comparisonReferenceVOList.get(i);
				HistogramUtil hu=new HistogramUtil();
				String r[]=v.getR_Pr().split(",");
				
				int  []sred=new int [256];
				sred=hu.getRGBInt(r);
				
				String g[]=v.getG_Y().split(",");
				
				int[] sgr=new int [256];
				sgr=hu.getRGBInt(g);
				
				String b[]=v.getB_Pb().split(",");
				int[] sbl=new int [256];
				sbl=hu.getRGBInt(b);
				
				
				int sr=hu.getArea(sred, comparisonCriteriaVO.getX_min(), comparisonCriteriaVO.getX_max());
				int sg=hu.getArea(sgr, comparisonCriteriaVO.getX_min(), comparisonCriteriaVO.getX_max());
				int sb=hu.getArea(sbl, comparisonCriteriaVO.getX_min(), comparisonCriteriaVO.getX_max());
				
				v.setS_R(sr);
				v.setS_G(sg);
				v.setS_B(sb);
				
				ServiceFactory.getConparisonReferenceService().modify(v);
				
				
				}
			
			
			 
			comparisonCriteriaVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			  UserVO vo = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			comparisonCriteriaVO.setUpdateUserID(vo.getUserID());
			ServiceFactory.getConparisonCriteriaService().modify(comparisonCriteriaVO);
			
		}catch(Exception e){
			logger.error("VideoCardCompareAction	compareCriteriaModify	error:"+e.getMessage());
		}
		logger.info("VideoCardCompareAction	compareCriteriaModify	end");
		return SUCCESS;
	}
	
	
	public ComparisonCriteriaVO getComparisonCriteriaVO() {
		return comparisonCriteriaVO;
	}


	public void setComparisonCriteriaVO(ComparisonCriteriaVO comparisonCriteriaVO) {
		this.comparisonCriteriaVO = comparisonCriteriaVO;
	}


	public ArrayList<ComparisonCriteriaVO> getComparisonCriteriaVOList() {
		return comparisonCriteriaVOList;
	}


	public void setComparisonCriteriaVOList(
			ArrayList<ComparisonCriteriaVO> comparisonCriteriaVOList) {
		this.comparisonCriteriaVOList = comparisonCriteriaVOList;
	}




	public ComparisonReferenceVO getComparisonReferenceVO() {
		return comparisonReferenceVO;
	}




	public void setComparisonReferenceVO(ComparisonReferenceVO comparisonReferenceVO) {
		this.comparisonReferenceVO = comparisonReferenceVO;
	}




	public ArrayList<ComparisonReferenceVO> getComparisonReferenceVOList() {
		return comparisonReferenceVOList;
	}




	public void setComparisonReferenceVOList(
			ArrayList<ComparisonReferenceVO> comparisonReferenceVOList) {
		this.comparisonReferenceVOList = comparisonReferenceVOList;
	}
	
	
}
