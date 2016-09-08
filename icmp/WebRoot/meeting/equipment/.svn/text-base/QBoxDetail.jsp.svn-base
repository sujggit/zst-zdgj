<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common_header.jsp"%>
		<style type="text/css">
		   input{
		       border:0px ;
		   }
		</style>
	</head >

  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
		<tr>
		    <td colspan="4" class="contenttitle fontstyle fontb">设备详情${equipmentVO.equipmentName}</td>
		  </tr>
          <tr>
            <td width="20%" class="ar fontstyle fontb pr3 tdhight">设备类型</td>
             <td width="30%" class="al pl3">
             <zzst:lable type="equipmentType" value="${equipmentVO.equipmentType}"></zzst:lable>
            </td>
            <td width="15%" class="ar fontstyle fontb pr3 tdhight">设备名称</td>
            <td width="35%" class="al pl3"><c:out value="${equipmentVO.equipmentName}"></c:out>
            </td>
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">管理IP</td>
            <td class="al pl3">
             <c:out value="${equipmentVO.ip}" ></c:out>
            </td>
            <td class="ar fontstyle fontb pr3 tdhight">端口号</td>
            <td class="al pl3">
            <c:out value="${equipmentVO.port}"></c:out>
            </td>
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight">设备型号</td>
           <td class="al pl3">
            	<zzst:lable type="equipment_QBox_Model" value="${equipmentVO.equipmentModel}"></zzst:lable>	
           </td>
		   <td class="ar fontstyle fontb pr3 tdhight">呼叫IP</td>
           <td class="al pl3">
           		<c:out value="${equipmentVO.description}"></c:out>
           </td> 
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight">所属会议室</td>
             <td class="al pl3">
               <c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"></c:out>
            </td>
           <!--<td class="ar fontstyle fontb pr3 tdhight">Mac地址</td>
           <td class="al pl3">
           		<c:out value="${equipmentVO.mac}"></c:out>
           </td>
          -->
          <td class="ar fontstyle fontb pr3 tdhight">管理员</td>
            <td class="al pl3">
			   <c:out value="${equipmentVO.userVO.name}"></c:out>
            </td>
          
          </tr>
          <tr>
            <td class="ar fontstyle fontb pr3 tdhight">状态</td>
            <td class="al pl3">
            	<zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable>
            </td>
          </tr>
        </table>           
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
        <tfoot>
        </tfoot>        
        <tbody>
		  <tr>
		    <td>
		          <input type="button" name="button2" id="cancelButton" value="关  闭"  class="submit1 radius2"  onclick="javascript:window.close();" />
		    	 </td>
		    	 </tr>
		    	 </tbody>
    	 </table>
	</body>
</html>