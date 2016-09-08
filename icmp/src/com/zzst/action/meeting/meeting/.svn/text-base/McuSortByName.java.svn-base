package com.zzst.action.meeting.meeting;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.Comparator;

import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;

public class McuSortByName implements Comparator<ZZOMainStatusVO> {
	Collator ctor = Collator.getInstance(java.util.Locale.CHINA);
	@Override
	public int compare(ZZOMainStatusVO v1, ZZOMainStatusVO v2) {
		
		if(ctor.compare(v1.getMcu_participant_name(), v2.getMcu_participant_name()) > 0){
			return 1;
		}else if(ctor.compare(v1.getMcu_participant_name(), v2.getMcu_participant_name()) <0){
			return -1;
		}   
		return 0;
		 
	}

	

}

