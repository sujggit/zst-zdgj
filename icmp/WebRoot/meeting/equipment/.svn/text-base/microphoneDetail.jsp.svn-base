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
    <td colspan="4" class="contenttitle fontstyle fontb">设备详情：${equipmentVO.equipmentName}</td>
  </tr>
          <tr>
          <td width="20%" class="ar fontstyle fontb pr3 tdhight">设备类型：</td>
          <td width="30%" class="al pl3">
              <c:out value="话筒"></c:out>   
          </td>
           <td width="15%" class="ar fontstyle fontb pr3 tdhight">设备名称：</td>
           <td width="35%" class="al pl3"><c:out value="${equipmentVO.equipmentName}"></c:out></td>
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight">设备型号：</td>
           <td class="al pl3">
             <zzst:lable type="equipment_Microphpne_Model" value="${equipmentVO.equipmentModel}"></zzst:lable>	
            </td>
             <td class="ar fontstyle fontb pr3 tdhight">设备编号：</td>
           <td class="al pl3"> <c:out value="${equipmentVO.equipmentNO }"></c:out></td>
          </tr>
         
          <tr>
          <td class="ar fontstyle fontb pr3 tdhight">启用时间：</td>
           <td class="al pl3"><c:out value="${equipmentVO.createDate}"></c:out></td>
            <td class="ar fontstyle fontb pr3 tdhight">状态：</td>
           <td class="al pl3">
               <zzst:lable type="equipmentStatus" value="${equipmentVO.status}"></zzst:lable>	
            </td>
          </tr>
          <tr>
           <td class="ar fontstyle fontb pr3 tdhight">所属单位：</td>
              <td class="al pl3"><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"></c:out></td>
            <td class="ar fontstyle fontb pr3 tdhight">管理员：</td>
           <td class="al pl3"><c:out value="${equipmentVO.userVO.name}"></c:out></td>
          </tr>
           <tr>
            <td class="ar fontstyle fontb pr3 tdhight">设备描述：</td>
           <!--  <td class="al pl3" colspan="3"> <textarea readonly style="height: auto;width:86%" rows="13" ><c:out value="${equipmentVO.description}"></c:out></textarea></td>
           -->
            <td class="al pl3" colspan="3"><c:out value="${equipmentVO.description}"></c:out></td>
           </tr>
        </table>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
           <tfoot>
        	</tfoot>        
        	<tbody>
		  <tr>
		    <td>
		          <input type="button" name="button2" id="cancelButton" value="关  闭" style="cursor:pointer"  class="button fontstyle fontb"  onclick="javascript:window.close();" />
		    	 </td>
		    	 </tr>
		    </tbody>
    	 </table>
	</body>
</html>