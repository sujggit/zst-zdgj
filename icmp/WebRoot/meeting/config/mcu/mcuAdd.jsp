<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>添加MCU模板</title>
		<script type="text/javascript">
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	//window.location.href="${sys_ctx}/config/getCenterControlList.action";
            }

         
           function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("equipmentType","输选择");	
			    obj.title("equipmentName","输入长度不超过25个字符");	
			    obj.title("ip","请输入正确的IP格式如：10.1.1.1");	
			    obj.title("port","请输入5000内数值型数据");	
			    obj.title("status","请选择");	
				obj.title("meetingRoomName","请选择");	
			    obj.title("terminalIP","请输入正确的IP格式如：10.1.1.1");	
			    
			
			}

			/**
			*	
			*@return	null	
			*/
               function mcuAdd(){
				    $('#mcuAddForm').validate({    
					rules:{    
					   "baseInfoVO.description" : {
					           required:true,
					           minlength:1,
					           maxlength:25
					           },
					     "baseInfoVO.infoValue" : {
					           required:true,
					           range:[0,9999]
					           }
					}
				  });
                $('#mcuAddForm').submit();
             }
    	</script>
</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'  onload="pageInit(); ">
<form action="${sys_ctx}/baseInfo/mcuAddSave.action" id="mcuAddForm" name="mcuAddForm" method="post">
<div id="container">
<div class="content">
<div class="contenttitle fontstyle fontb">
  <div class="fl"><img src="${sys_ctx}/images/blue/titleicon.gif" width="20" height="25" /></div>
  <div class="fl">&nbsp;MCU模板添加</div>
</div>
<div class="tablesdiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
   	
    	  <tr class="tdhight">
        	<td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>MCU名称</td>
            <td class="al pl3">
            	  <select class="select200 fontstyle gselect"  name="baseInfoVO.infoName" id="baseInfoVO.infoName">
				    <c:forEach items="${equipmentList}" var="equipmentVO" varStatus="state">
						<option value="${equipmentVO.ip }">${equipmentVO.equipmentNO }</option>									
					</c:forEach>									
			    </select>
            </td>
            <td class="ar fontstyle fontb pr3 tdhight"></td>
            <td class="al pl3"></td>
         </tr>
         <tr>
         <td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>模板名称</td>
           <td class="al pl3">
          	<input type="text" name="baseInfoVO.description" id="baseInfoVO.description" class="input200 fontstyle" value="" />
            </td>
          	<td class="ar fontstyle fontb pr3 tdhight"><span class="fonttsx">*</span>模板ID</td>
          	<td class="al pl3">
            	 <input type="text" name="baseInfoVO.infoValue" id="baseInfoVO.infoValue" class="input200 fontstyle" value="" />
            </td>
          </tr>
        </table>
    	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
	  <tr>
	    <td><input type="button" name="button" id="button" value="确 定" onclick="mcuAdd();"  class="submit1 radius2 submitBtn_Disa" />
	      <input type="button" name="button2" id="button2" value="返 回" onclick=" backHistory();" class="reset1 radius2" /></td>
	  </tr>
	</table>
</div>
</div>
  </form>
</body>

</html>