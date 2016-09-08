<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.templateMeeting.TemplateMeetingService" %>
<%@ page  import="com.zzst.service.meeting.template.TemplateService" %>
<%@ page  import="com.zzst.action.meeting.util.ServiceFactory" %>
<%@ page  import="com.zzst.model.meeting.templateMeeting.TemplateMeetingVO" %>
<%@ page  import="com.zzst.model.meeting.template.TemplateVO" %>
<%
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);

%>

<html>
  <head>
    <title>会议结构</title>
      
    <%@include file="/common/common.jsp"%>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link href="${sys_ctx }/project/zhuanyuanban/css/global.css" rel="stylesheet" type="text/css" />
	<link href="${sys_ctx }/project/zhuanyuanban/css/listheaderfixed.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	 <script language="JavaScript">
		
		var setting = {
			view: {
				
				//addHoverDom: addHoverDomAddress,
				//removeHoverDom: removeHoverDomAddress,
				selectedMulti: false
			},
			edit: {
				//enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
			}
		};

		<%
	 		String temId = request.getParameter("id");
			TemplateVO tepVO = ServiceFactory.getTemplateService().queryByID(temId);
			TemplateMeetingVO tem = new TemplateMeetingVO();
			tem.setTemplateId(temId);
			 ArrayList list = ServiceFactory.getTemplateMeetingService().query(tem,null);
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
				      for(int i=0;i<list.size();i++){
				    	  TemplateMeetingVO temVO = (TemplateMeetingVO)list.get(i);
				    	    dataObj.append("{id:'"+temVO.getId()+"',pId:'"+temVO.getParentId()+"',name:\""+temVO.getMeetingName()+"\"");
			               if(i<3)
				             dataObj.append(",open:true");
				             dataObj.append("}");
		                	
			                 if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                 }
				       }
				      dataObj.append("];");
				      out.print(dataObj);
		}     
		%>
		function initjPa(){
			$.fn.zTree.init($("#templateMeeting"), setting, zNodes);
		};
		
		window.onload=initjPa;
	</script>
	<style type="text/css">
  .ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-112px 0; vertical-align:top; *vertical-align:middle}
	</style>
  </head>
  <body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
    <div id="basicform" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10"><%=tepVO.getTemplateName() %>会议列表</h5>
      </div>
     <div class="dtree">
            <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
              <tfoot>
              </tfoot>
              <tbody>
                <tr class="gradeA">
                  <td align="">
                      <ul id="templateMeeting" class="ztree"></ul>	
	
	   			</td>
    			</tr>
    		</tbody>
   		 </table>
   	</div>
  </div>
        
      <!--contenttitle-->
   
	</body>
  
</html>
  
