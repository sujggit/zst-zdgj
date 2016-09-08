package com.zzst.util.tools.export;

import java.io.File;
import java.util.ArrayList;

import com.zzst.util.ExcuteResultVO;
import com.zzst.util.tools.export.ecxel.CellVO;
import com.zzst.util.tools.export.ecxel.ExcelUtil;
import com.zzst.util.tools.export.ecxel.PngVO;


/**
 *@Description	导出帮助类
 *@date 2012-6-26下午06:23:09
 *@author ryan
 */
public class ExportObjectHelp {
	
	
	/**
	 * 导出excel文件
	 * @param fileObj
	 * @param list
	 * @return ExcuteResultVO object可以强转为File
	 */
	public static ExcuteResultVO  exportExcel(ExportFileObject fileObj,ArrayList<CellVO[]> list){
		ExcuteResultVO excuteResultVO = new ExcuteResultVO();
		ArrayList<CellVO[]> lstAllLogVOs=new ArrayList<CellVO[]>();
		for (int i = 0; i < list.size(); i++) {
			CellVO[] cell = list.get(i);
			lstAllLogVOs.add(cell);
		}
        File file=new File(fileObj.getExportFilePath()+fileObj.getExportFileName() );
      
        file = ExcelUtil.writeExcell(file, lstAllLogVOs);	
		excuteResultVO.setSuccess(true);
		excuteResultVO.setObject(file);
		return excuteResultVO;
	}
	
	
	/**
	 * 导出world文件
	 * 没有实现
	 * @return
	 */
	public static ExcuteResultVO  exportWorld(){
		
		return null;
	}
	
	public static void main(String[] aaa){
		ExportFileObject o = new ExportFileObject();
		o.setExportFileName("test2.xls");
		o.setExportFilePath("d:/");
		CellVO[] c = new CellVO[2];
		ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
		CellVO ex = new CellVO();
		ex.setValue("33333");
		c[0] = ex;
		
		ex = new CellVO();
		ex.setValue("444");
		ex.setValuetype(CellVO.TYPE_PNG);
		File f = new File("h:QQ截图20120117182730.png");
		PngVO p = new PngVO();
		p.setHeight(10);
		p.setWidth(10);
		p.setFile(f);
		ex.setPngFile(p);
		c[1] = ex;
		list.add(c);
		ExportObjectHelp.exportExcel(o,list);
	}
}
