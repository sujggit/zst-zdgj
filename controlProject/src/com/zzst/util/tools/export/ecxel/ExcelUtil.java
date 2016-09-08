package com.zzst.util.tools.export.ecxel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;


public class ExcelUtil {
	
	public static void main(String[] args){
		//		ArrayList<String[]> list =ExcelUtil.getExcellContent("D:\\22.xls");
		//		for(int j=0;j<list.size();j++){
		//			String[] s =list.get(j);
		//			for(int i=0;i<s.length;i++){
		//				//System.out.println(s[i]+"=============----==========");
		//			}
		//		}
		//	ArrayList lstdata=new ArrayList();
		//	CellVO v = new CellVO();
		//	v.setDemo("1");
		//	v.setValue("1");
		//	v.setValuetype(CellVO.TYPE_STRING);
		//	
		//	CellVO v2 = new CellVO();
		//	v2.setDemo("2");
		//	v2.setValue("2");
		//	v2.setValuetype(CellVO.TYPE_STRING);
		//	
		//	CellVO[] abc={v,v2};
		//	lstdata.add(abc);
	}

	public static ArrayList<String[]> getExcellContent(String file,int sheetNO,int startRow,int endRow) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		jxl.Workbook rwb = null;
		try {
			InputStream is = new FileInputStream(file);
			rwb = Workbook.getWorkbook(is);
			Sheet[] s=rwb.getSheets();//工作表集合
			for(int i=0;i<s.length;i++){
				Sheet rs=s[i];
				int rowNumber = rs.getRows();
				for (int j = 0; j < rowNumber; j++) {
					Cell[] c=rs.getRow(j);
					String[] sheet= new String[c.length];
					for(int k=0;k<c.length;k++){
						sheet[k]=c[k].getContents();
					}
					list.add(sheet);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwb.close();
		}
		return null;
	
	}

	/**
	 * 读取整个excel表
	 * @param path
	 * @return
	 */
	public static ArrayList<String[]> getExcellContent(String file) {
		return getExcellContent(file,1,1,-1);
	}
	
	public static File writeExcell(File file,ArrayList<CellVO[]> list){
		return writeExcell(file,file,list,false);
	}
	
	/**
	 * file 文件，ArrayList的长度是行，Object[] 该行的列集合
	 * @param filePath
	 * @param ArrayList<Object[]>
	 * @return String filePath
	 */
	public static File writeExcell(File srcFile,File dstFile,ArrayList<CellVO[]> list,boolean hasSourceFile){
		 jxl.write.WritableWorkbook wwb= null;
		try
		{
			jxl.write.WritableSheet ws=null;
			if(hasSourceFile){
				Workbook rwb = Workbook.getWorkbook(srcFile);
				wwb = Workbook.createWorkbook(dstFile,rwb);//copy
				ws = wwb.getSheet(0);
			}else{
				wwb = Workbook.createWorkbook(srcFile);
				ws = wwb.createSheet("sheet1", 0);
			}
		   
		    // 1.添加Label对象
		    for(int j=0;j<list.size();j++){
		    	CellVO[] cellVOs=list.get(j);
		    	if(cellVOs==null)continue;
		    	for(int i=0;i<cellVOs.length;i++){
		    		if(cellVOs[i]==null)continue;
		    		Label labelValue = null;
		    		CellVO cellVO=cellVOs[i];
		    		
		    		if(cellVO.getValuetype()==CellVO.TYPE_STRING){
		    			String value = cellVO.getValue();
		    			labelValue = new jxl.write.Label(i,j,value);//设置单元格内容j为行、i为列
		    			 ws.addCell(labelValue);
		    		}else if(cellVO.getValuetype()==CellVO.TYPE_PNG){
		    			jxl.write.WritableImage   wi=new   jxl.write.WritableImage(i,j,cellVO.getPngFile().getHeight(),cellVO.getPngFile().getWidth(),cellVO.getPngFile().getFile()); 
						ws.addImage(wi); 
		    		}
			    }
		    }
		    wwb.write();
		    return dstFile;
		}catch (Exception e){
			System.out.println(e.toString());
		}finally{
			if(wwb!=null){
				try {
					wwb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
