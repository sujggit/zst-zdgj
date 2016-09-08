package com.zzst.action.meeting.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * 页面提示信息
 * @author xmj
 *
 */
public class PagepromptTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String  type;
	private String	value;
	private	String	dispcontent	;
	public	static	int		NEXTVALUE	=	1	;
	
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			if(this.getType()==null||this.getType().length()<=0){
				out.print("type属性不能为空");
				return TagSupport.EVAL_BODY_AGAIN;
			}
			out.print(getOptionsContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}
	
	
 
	private String	getOptionsContent(){
		if(NEXTVALUE==Integer.MAX_VALUE){
			NEXTVALUE = 0;
		}else{
			NEXTVALUE++;
		}
		String htm = "";
		//String promptinfo	=	CjfBaseInfoHelper.getInfoDesc("pageprompt",this.getType());
		//if(promptinfo	==	null ||promptinfo.trim().length()==0	)return "&nbsp;";
		
		//if(this.getDispcontent()==null||this.getDispcontent().length()<=0){
			
			String param	=	"pagepromptCode="+this.getType();
			String windowsparam	=	"dialogWidth=400px;dialogHeight=300px";
			//String[] value	= promptinfo.split("&&&");
			//if(value==null){
			//	return "&nbsp;";
		//	}
			/*if(value.length==1){
				param=param+value[0];
			}else if(value.length==2){
				param=param+value[0];
				windowsparam=value[1];
				
			}
			*/
			String javascript	=	"window.showModalDialog(\"/icmp/common/remindinfo.jsp?"+param+"\",\"说明\",\""+windowsparam+"\");";
			
			htm="<a   href=\"javascript:void(0);\" onclick=\"javascript:promptinfo"+NEXTVALUE+"A();\" >说明</a>";
			htm+="<script type=\"text/javascript\"> function promptinfo"+NEXTVALUE+"A(){"+javascript+"}</script>";
			
			
			
		//}else{
		//	return promptinfo;
		//}
		 


		return htm;
	}
	
	
	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getValue() {
		return value;
	}




	public void setValue(String value) {
		this.value = value;
	}




	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}



	public String getDispcontent() {
		return dispcontent;
	}



	public void setDispcontent(String dispcontent) {
		this.dispcontent = dispcontent;
	}

	

}
