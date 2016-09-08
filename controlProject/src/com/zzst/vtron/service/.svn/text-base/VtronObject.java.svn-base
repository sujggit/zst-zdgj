package com.zzst.vtron.service;


import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;
import com.zzst.vtron.service.impl.vo.VtronVO;


/**
 *@Description	威创--大屏控制相关
 *@date 2012-8-12上午11:42:06
 *@author ryan
 */
public abstract	class VtronObject extends EquipmentObject{

	public static final String VTRON_TYPE_1215		=	"VTRON_TYPE_1215";

	protected String ip;
	protected int port;
	
	public VtronObject(){}
	public VtronObject(VtronVO vtronVO){
		this.ip = vtronVO.getIp();
		this.port = vtronVO.getPort();
	}
	
	/**
	 * 模式预览
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO modelPieview() ;
	
	/**
	 * 提取模式列表
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO getModelList() ;
	
	
	/**
	 * 提取当前模式详细信息
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO getModel() ;
	
	/**
	 * 调用模式
	 * @param modelID
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO setModel(String modelID) ;
	
	/**
	 * 给模式内窗口切信号
	 * @param modelID
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO setSourse(String sourseName) ;
	
	/**
	 * 枚举指定显示墙窗口
	 * @param modelID
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO getWallInfo(String wallName) ;
}
