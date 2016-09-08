<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<style type="text/css">
		   input{
		       border:0px ;
		   }
		</style>
	</head >
 <body STYLE='OVERFLOW-Y:HIDDEN;OVERFLOW-X:HIDDEN'  >
   <div id="basicform" class="contentwrapper">
    <div class="contenttitle2" style="width:100%">
        <h5 class="fwb fl10">设备详情</h5>
      </div>
 	
        
         <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="20%" class="tableaddtitle">设备名称</td>
          <td width="30%" class="tableadd_data" >${difVO.equipmentNO}</td>
          <td width="20%" class="tableaddtitle">设备型号</td>
          <td width="30%" class="tableadd_data">
               <zzst:lable type="equipment_Terminal_Model" value="${difVO.equipmentModel}"></zzst:lable>         
            </td>
        </tr>
        <tr>
          <td class="tableaddtitle">mac地址</td>
          <td class="tableadd_data" ><c:out value="${difVO.mac}"></c:out></td>
          <td class="tableaddtitle">IP地址</td>
          <td class="tableadd_data"><c:out value="${difVO.ip}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">端口号</td>
          <td class="tableadd_data" >${difVO.port}</td>
          <td class="tableaddtitle">所属会议室</td>
          <td class="tableadd_data">${difVO.roomNO}</td>
        </tr>
        <tr>
          <td class="tableaddtitle">管理员</td>
          <td class="tableadd_data" ><c:out value="${difVO.adminName}"></c:out></td>
          <td class="tableaddtitle">所属MCU</td>
          <td class="tableadd_data"><c:out value="${difVO.mcuIp}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">用户名</td>
          <td class="tableadd_data" ><c:out value="${difVO.loginName}"></c:out></td>
          <td class="tableaddtitle">密码</td>
          <td class="tableadd_data"><c:out value="${difVO.loginPassword}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">序列号</td>
          <td class="tableadd_data" ><c:out value="${difVO.serialNumber}"></c:out></td>
          <td class="tableaddtitle">资产编号</td>
          <td class="tableadd_data"><c:out value="${difVO.equipmentIdentifier}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">维保开始日期</td>
          <td class="tableadd_data" ><fmt:formatDate value="${difVO.maintainceStartTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
          <td class="tableaddtitle">维保月份</td>
          <td class="tableadd_data"><c:out value="${difVO.maintainMonth == -2147483648 ? '':difVO.maintainMonth}"></c:out></td>
        </tr>
        <tr>
          <td class="tableaddtitle">终端状态</td>
          <td colspan="3" class="tableadd_data" ><zzst:lable type="equipmentStatus" value="${difVO.equipmentStatus}"></zzst:lable></td>
        </tr>
        <tr>
          <td class="tableaddtitle">操作描述</td>
          <td colspan="3" class="tableadd_data" ><c:out value="${difVO.description}"></c:out></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr">
            <td><input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
              </td>
          </tr>
        </tbody>
     </table>
     </div>
	</body>
</html>
