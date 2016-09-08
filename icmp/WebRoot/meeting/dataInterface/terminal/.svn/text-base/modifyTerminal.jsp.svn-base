<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>终端修改页面 </title>
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
			obj.title("equipmentNO","输入长度不超过25个字符");	
			obj.title("equipmentModel","请选择");	
			obj.title("mac","输入长度不超过25个字符");	
			obj.title("ip","请输入正确的IP格式如：10.1.1.1");	
			obj.title("port","请输入10000内数值型数据");	
			obj.title("roomName","输入长度不超过25个字符");	
			obj.title("adminName","输入长度不超过25个字符");	
			//obj.title("planeImg","请上传图片");	
			obj.title("mcuIp","请输入正确的IP格式如：10.1.1.1");
			obj.title("serialNumber","输入长度不超过25个字符");
			obj.title("equipmentIdentifier","输入长度不超过25个字符");
			obj.title("maintainMonth","请输入正确的月份");
		};
		/**
		*	修改会议室
		*@return	null	
		*/
 		function  terminalModify(){
 			$('#modifyForm').validate({    
			  rules:{    
			   "tifVO.equipmentNO" : {
			           required:true,
			           minlength:1,
			           maxlength:25  
			           },
			     "tifVO.equipmentModel" : {
			           required:true
			           },
			    "tifVO.mac" : {
			           minlength:1,
			           maxlength:25
			           },
			     "tifVO.ip" : {
			        	   required:true,
				           minlength:1,
				           maxlength:25,
				           checkIP:true
			           },
			       "tifVO.port" : {
			        	 required:true,
				         range:[0,10000]
			           },
			       "tifVO.roomName" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			       "tifVO.adminName" : {
			           required:true,
			           minlength:1,
			           maxlength:25 
			           },
			       "tifVO.mcuIp" : {
			        	required:true,
				        minlength:1,
				        maxlength:25,
				        checkIP:true
			          },
		          "tifVO.serialNumber" : {
				        minlength:1,
				        maxlength:25
			          },
		          "tifVO.equipmentIdentifier" : {
				        minlength:1,
				        maxlength:25
			          },
		          "tifVO.maintainMonth" : {
			        	 range:[1,12]
			          }
			    }
		    });
 			//var a = document.getElementById("roomNO");
 			//check("meetingRoomName");
 			//checkNO(a);
 			    $('#modifyForm').submit();
 	 		
 			//window.returnValue="1";
     	   	//window.close();
		    /*var a = document.getElementById("meetingRoomName");
		    if("${mrVO.meetingroomName }" == a.value){
		    	$('#modifyForm').submit();
		    	window.returnValue="1";
		    	window.close();
			}else{
				DwrMethod.checkMeetingRoomName(a.value,callbackForm);
   				function callbackForm(list){
   					if(list.length > 0){
   		      	    	alert("此会议室名称已被占用");
   		      	    	document.getElementById("meetingRoomName").value="";  	
   		      	    }else{
   		      	        $('#modifyForm').submit();
   		      	        window.returnValue="1";
   		      	   		window.close();
   	   		        }
   	   			}
			}*/
         };
		


     	function checkNO(op){
		    
			  if(op.value==""||op.value==null || "${mrVO.roomNO}" == op.value){
				return;
			  }
			  DwrMethod.checkMeetingRoomNO(op.value,function callbackNO(result){
					
						if(result){
							alert("会议室编号已被占用");
							op.value="";  
					   }
	 		 });

	 	}
        /**
		*	返回列表
		*@return	null
		*/
        function backHistory(){
        	window.location.href="/icmp/terminalInterface/queryTerminal.action";
        };
        
      
         
    </script>
</head>
<body onload="pageInit();">
  <form action="${sys_ctx}/terminalInterface/modify.action" id="modifyForm" name="modifyForm" method="post" class="contentwrapper" >
    <input name="tifVO.equipmentID" id="terminalID" type="hidden" value="${tifVO.equipmentID}" />
    <div class="contenttitle2">
      <h5 class="fwb fl10">终端修改</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>终端名称</td>
          <td width="35%" class="tableadd_data" >
            <input class="inputtran" style="width:80%" type="text" name="tifVO.equipmentNO" id="equipmentNO" value='${tifVO.equipmentNO}' />
          </td>
          <td width="15%" class="tableaddtitle"><span>*</span>终端型号</td>
          <td width="35%" class="tableadd_data">
            <select name="tifVO.equipmentModel" id="equipmentModel" class="inputtran">
					<zzst:option type="equipment_Terminal_Model" value="${tifVO.equipmentModel}" required="true"/>
			   </select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">mac地址</td>
          <td class="tableadd_data" >
          <input class="inputtran"  id="mac"  name="tifVO.mac" type="text"  value='${tifVO.mac}' />
          </td>
          <td class="tableaddtitle"><span>*</span>IP地址</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="tifVO.ip" id="ip"  value="${tifVO.ip}" />
            </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>端口号</td>
          <td class="tableadd_data" >
           <input type="text" class="inputtran" name="tifVO.port" id="port"  value="${tifVO.port}" />
          </td>
          <td class="tableaddtitle"><span>*</span>所属会议室</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="tifVO.roomName" id="roomName" value="${tifVO.roomName}" />
          </td>  
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data" ><input class="inputtran" type="text" name="tifVO.adminName" id="adminName"  value="${tifVO.adminName}"></td>
          <td class="tableaddtitle"><span>*</span>所属MCU</td>
          <td class="tableadd_data">
          <select name="tifVO.mcuIp" id="mcuIp" class="inputtran">
				<c:forEach items="${equipmentVOListsss}" var="eMcu">
				<option value="${eMcu.ip}" ${eMcu.ip==tifVO.mcuIp ? "selected" : "" }>
							 ${eMcu.ip}(${tifVO.mcuIp})
					</option>
			    </c:forEach>
			</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data" ><input class="inputtran" type="text" name="tifVO.serialNumber" id="serialNumber"  value="${tifVO.serialNumber}"></td>
          <td class="tableaddtitle">资产编号</td>
          <td class="tableadd_data"><input class="inputtran" type="text" name="tifVO.equipmentIdentifier" id="equipmentIdentifier"  value="${tifVO.equipmentIdentifier}" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle">维保开始日期</td>
          <td class="tableadd_data" >
          	<input name="tifVO.maintainceStartTime" class="inputtran" id="maintainceStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" 
             	 value="<fmt:formatDate value='${tifVO.maintainceStartTime}' pattern='yyyy-MM-dd HH:mm'/>"
             />
          </td>
          <td class="tableaddtitle">维保月份</td>
          <td class="tableadd_data"><input class="inputtran" type="text" name="tifVO.maintainMonth" id="maintainMonth"  value="${tifVO.maintainMonth == -2147483648 ? '':tifVO.maintainMonth}" /></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="terminalModify();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
            </td>
          </tr>
        </tbody>
      </table>
      <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
  </form>
</body>
</html>