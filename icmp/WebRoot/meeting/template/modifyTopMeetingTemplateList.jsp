<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>高级模板修改页面 </title>
    <%@include file="/common/common.jsp"%>
    
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
    
   
    
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
			 
			
			
				/**
			*	设置页面参数
			*@return	null	
			*/
           function pageInit(){
			    var obj = new htmlUtil();
				obj.title("templateName","输入长度不超过25个字符");	
				obj.title("duration","输选择");	
				obj.title("description","输入不超过500个字符描述会议室相关信息");	
			};
			/**
			*	修改模板
			*@return	null	
			*/
   			function  templateModify(){
   			  $('#modifyForm').validate({    
					rules:{    
					    "templateVO.templateName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					      },
					     "templateVO.duration" : {
					           required:true
					      }
					}
				  });
                     $('#modifyForm').submit();
           	};
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/detail/manageMeetingTemplateList.action";
            };
	      
    	</script>
    
</head>
<body onload="pageInit(); " style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<div id="basicform" class="contentwrapper"/>
<form action="${sys_ctx}/detail/modifyTopMeetingTemplate.action" id="modifyForm" name="modifyForm" method="post">
<input name="templateVO.id" id="templateId" type="hidden" value="${templateVO.id}"/>

<div class="contenttitle2">
    <h5 class="fwb fl10">高级模板修改</h5>
</div>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>模板名称</td>
          <td width="35%" class="tableadd_data" >
          <input class="inputtran" style="width:80%" type="text" name="templateVO.templateName" id="templateName" value='<c:out value="${templateVO.templateName}"></c:out>' />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>会议时长</td>
          <td width="35%" class="tableadd_data">
          		<select class="inputtran"  name="templateVO.duration" id="duration">
			   	 <zzst:option type="meetingtime" value="${templateVO.duration}" />
    			</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">模板描述</td>
          <td colspan="3" class="tableadd_data" ><textarea name="templateVO.description" rows="5" class="areatran" id="description">${templateVO.description}</textarea></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="templateModify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
  </form>
 </div>
</body>
</html>