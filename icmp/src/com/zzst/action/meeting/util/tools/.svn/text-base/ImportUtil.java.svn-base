/**
 * 
 */
package com.zzst.action.meeting.util.tools;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * 自适应解析excel
 * @author zhangliang
 * Nov 23, 2011 11:44:24 AM
 */
public class ImportUtil {
	
	@SuppressWarnings("unchecked")
	public static ArrayList getExcelContent(String path)
	{
		
		//存放excel 字段属性
		HashMap excelmap = new HashMap();
		//存放object 字段属性
		HashMap fmap = new HashMap();
		//存放解析结果
	 	ArrayList reslist = new ArrayList(); 		
	
	
		try {
			//判断属于哪个类型
			Class clazz = Class.forName("com.zzst.model.meeting.meetingRoom.MeetingRoomVO");
			//获得属性
			Field[] fields = clazz.getDeclaredFields();
			for (int i=0;i< fields.length; i++ ) 
			{
				Field  field = fields[i];							
				  
			   PropertyDescriptor pd = new PropertyDescriptor(field.getName(),clazz);
			 
			   //获得set方法
			   Method setMethod = pd.getWriteMethod();
			         
			   Class b[] =setMethod.getParameterTypes();
			   String type = b[0].getName();
			   if(!type.contains("com.zzst"))
			   {
				   fmap.put(field.getName() , setMethod); 
			   }
			   else
			   {
				   //子类属性
				   Class subclass = Class.forName(type);
				   Field[] subfields = subclass.getDeclaredFields();
				   for (int a=0;a< subfields.length;a++)
				   {
					   fmap.put(subfields[a].getName() , setMethod); 
				   }
			   }
			   System.out.print("参数的类型是"+type+":");
			   
			}  
			
			//读取excel
			String filePathAndName =path;
			FileInputStream fs = new FileInputStream(filePathAndName);
			Workbook wb =  Workbook.getWorkbook(fs);
			//get sheet object
			Sheet sheet = wb.getSheet(0);
			int totalrow = sheet.getRows();
			int rsColumns = sheet.getColumns(); 
			if (totalrow > 0) 
			{
				//首行，属性名称
				for (int s = 0; s < rsColumns; s++)
				{
					Cell c00 = sheet.getCell(s, 0);
					String d0 = c00.getContents().trim();
					excelmap.put(s, d0);
					System.out.println(d0);
				}
				//取行值
				for(int j=1;j<totalrow;j++)
				{
					//每行数据对应一个obj
					MeetingRoomVO obj= (MeetingRoomVO) clazz.newInstance();
					reslist.add(obj);
					
					//取列值
					for(int k=0;k<rsColumns;k++)
					{
						Cell c00 = sheet.getCell(k, j);
						String d0 = c00.getContents();
						String excecltype =(String) excelmap.get(k);
						System.out.println(excecltype+":"+d0);																	
						   	   
						if(fmap.containsKey(excecltype))
						{	
						   //获得set方法
						   Method setMethod =(Method) fmap.get(excelmap.get(k));								         
						   Class b[] =setMethod.getParameterTypes();
						   String type = b[0].getName();
						   System.out.print("参数的类型是"+type);
						   //基本类型属性
						   if(type.equalsIgnoreCase("java.lang.String"))
						   {  
						        setMethod.invoke(obj,d0);
						   }
						   else  if(type.equalsIgnoreCase("int")||type.equalsIgnoreCase("java.lang.Integer"))
						   {
							   setMethod.invoke(obj, Integer.parseInt(d0));
						   }
						   //子类特殊处理
						   else if(type.contains("com.zzst"))
						   {
							   Class subclass = Class.forName(type);
							   Object sub1 =  subclass.newInstance();
							   setMethod.invoke(obj, sub1);
							   
							   //判断引用类
							   if(type.equals("com.zzst.model.meeting.user.UserVO"))
							   {							
								   //根据实际需求
								   PropertyDescriptor pd1 = new PropertyDescriptor("userID",subclass);							
								   Method subsetMethod = pd1.getWriteMethod();
								   if(excecltype.equals("userID") )
								   {   
									   subsetMethod.invoke(sub1, d0);
								   }   
							   }
							   else if(type.equals("com.zzst.model.meeting.department.DepartmentVO"))
							   {
								   //根据实际需求
								   PropertyDescriptor pd1 = new PropertyDescriptor("id",subclass);							
								   Method subsetMethod = pd1.getWriteMethod();
								   if(excecltype.equals("id") )
								   {
									   subsetMethod.invoke(sub1, d0);
								   }
								   
							   }							   
						   }
						   
						} 						
					}
				}
			}					
	
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return reslist;		
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		
		String filePathAndName ="E://in.xls";
		ArrayList list = getExcelContent(filePathAndName);
		System.out.println(list.size());
	}
	
}
