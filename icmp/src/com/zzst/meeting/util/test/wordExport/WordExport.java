package com.zzst.meeting.util.test.wordExport;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordExport {
	public static boolean exportWord(String str,String file) throws Exception{
		String[] strs = str.split(",");
		
		XWPFDocument doc = new XWPFDocument();
		//时间_备注,时间_备注,时间_备注（大事记）
		XWPFParagraph p1 = doc.createParagraph();
		p1.setAlignment(ParagraphAlignment.LEFT);
		p1.setSpacingLineRule(LineSpacingRule.EXACT);
		//p1.setIndentationFirstLine(600);
		XWPFRun r1 = p1.createRun();
		String[] tem;
		for(int i=0;i<strs.length;i++){
			tem=strs[i].split("_");
			r1.setText(tem[0]);
			r1.addBreak();
			r1.setText(tem[1]);
			r1.addBreak();
			r1.addBreak();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		FileOutputStream out = new FileOutputStream(file+"/"+sdf.format(new Date())+".docx");
        doc.write(out);
        out.close();
		return true;
	}
	public static void main(String[] args) throws Exception {
		WordExport.exportWord("时间_备注,时间_备注,时间_备注", "C:/Users/wxw/Desktop");
	}
}
