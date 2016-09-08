package com.zzst.action.meeting.schedule.util;

import java.util.ArrayList;
import java.util.Calendar;

public class WeekUtil {
	public static ArrayList<String> getWeekList(){
		String[] strs = {"一","二","三","四","五","六","日"};
		ArrayList<String> strList = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		//得到了下周一的时间
        while (c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            c.add(Calendar.DAY_OF_WEEK, 1);
        }
        for(int i=1;i<=7;i++){
        	strList.add(((c.get(Calendar.MONTH)+1)<10?"0"+(c.get(Calendar.MONTH)+1):(c.get(Calendar.MONTH)+1))+"月"+(c.get(Calendar.DAY_OF_MONTH)<10?"0"+c.get(Calendar.DAY_OF_MONTH):c.get(Calendar.DAY_OF_MONTH))+"日 周"+strs[i-1]);
        	c.add(Calendar.DAY_OF_WEEK, 1);
        }
		return strList;
	}
	public static String getMonthAndWeek(){
		Calendar c = Calendar.getInstance();
		//得到了下周一的时间
        while (c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            c.add(Calendar.DAY_OF_WEEK, 1);
        }
        String time = c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月第"+c.get(Calendar.WEEK_OF_MONTH)+"周";
		return time;
	}
	public static void main(String[] args) {
		ArrayList<String> strList = getWeekList();
		for(String s:strList){
	    	System.out.println(s);
	    }
	}
}
