package com.zzst.action.meeting.dictionary;

import java.util.ArrayList;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.dictionary.DictionaryVO;

public class DictionaryHelper {
	 private static ArrayList<DictionaryVO> list=new ArrayList<DictionaryVO>();
	public static String[][] getDictionary(DictionaryVO dictionaryVO){
		try {
			list=ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			
		} catch (Exception e) {
		 	e.printStackTrace();
		}
		String[][] s = new String[list.size()][2];
		for(int i=0;i<list.size();i++){
			DictionaryVO dvo=list.get(i);
			s[i][0]=dvo.getDicValue();
			s[i][1]=dvo.getDicViewName();
			
		}
		
		
		return s;
	}
	public static ArrayList<DictionaryVO> getList() {
		return list;
	}
	public static void setList(ArrayList<DictionaryVO> list) {
		DictionaryHelper.list = list;
	}
	
}
