<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>音频查看</title>
</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx}/equipment/audioModify.action" id="addMcuForm" name="addMcuForm" method="post"/>
   <input type="hidden" name="equipmentVO.equipmentID" id="equipmentID" value="${equipmentVO.equipmentID}"  />
   <div id="basicform" class="contentwrapper"> 
  	<div class="contenttitle2">
        <h5 class="fwb fl10">音频查看</h5>
      </div>
   <div id="k7"  class="k" style="display:block">
                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
                    <tr>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备类型</td>
                      <td width="35%" class="tableadd_data" >
	                      <zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentType}"></zzst:lable>
                      </td>
                      <td width="15%" class="tableaddtitle"><span>*</span>设备厂家</td>
                      <td width="35%" class="tableadd_data">${equipmentVO.equipmentName}</td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>设备型号</td>
                      <td class="tableadd_data" >
                         <zzst:lable type="equipmentEnum" value="${equipmentVO.equipmentModel}"></zzst:lable></td>
                      </td>
                      <td class="tableaddtitle"><span>*</span>设备名称</td>
                      <td class="tableadd_data">${equipmentVO.equipmentNO}</td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>管理IP</td>
                      <td class="tableadd_data" >${equipmentVO.ip}</td>
                      <td class="tableaddtitle"><span>*</span>MAC</td>
                      <td class="tableadd_data">${equipmentVO.mac}</td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>端口号</td>
                      <td class="tableadd_data" >${equipmentVO.port}</td>
                      <td class="tableaddtitle"><span>*</span>状态</td>
                      <td class="tableadd_data">
                        <select name="equipmentVO.status" id="status" class="inputtran" disabled="disabled">
							<zzst:option type="equipmentStatus" value="${equipmentVO.status}" required="true"/>
			 			</select></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle"><span>*</span>所属会议室</td>
                      <td class="tableadd_data" colspan="3">${equipmentVO.meetingRoomVO.meetingRoomName}</td>
                    </tr>
                    <tr>
			          <td class="tableaddtitle"><span>*</span>管理员</td>
                      <td class="tableadd_data">${equipmentVO.userVO.name}</td>
			          <td class="tableaddtitle">序列号</td>
			          <td class="tableadd_data">${equipmentVO.serialNumber}</td>
        		   </tr>
                    <tr>
			          <td class="tableaddtitle">维保开始日期</td>
			          <td class="tableadd_data" ><fmt:formatDate value='${equipmentVO.maintenanceStartTime}' pattern='yyyy-MM-dd HH:mm'/></td>
			          <td class="tableaddtitle">期限</td>
			          <td class="tableadd_data">
			          	<select class="inputtran"  name="equipmentVO.maintenanceMonths" id="maintenanceMonths" disabled="disabled">
			    <%--<option value="23">请选择...</option>--%>
			    <%--<option value="0.05" ${meetingDetailVO.meetingDescription=="0.05" ? "selected" : "" }>0.05</option>--%>
						    <zzst:option type="maintenanceStartTime" value="${equipmentVO.maintenanceMonths}" />
			    		</select> 
			          </td>
			        </tr>
        		   <tr>
        		   	  <td class="tableaddtitle">资产编号</td>
			          <td class="tableadd_data" >${equipmentVO.equipmentIdentifier}</td>
        		      <td class="tableaddtitle">启用时间</td>
                      <td class="tableadd_data"><fmt:formatDate value='${equipmentVO.createDate}' pattern='yyyy-MM-dd HH:mm'/></td>
                    </tr>
                    <tr>
                      <td class="tableaddtitle">设备描述</td>
                       <td colspan="3" class="tableadd_data" ><textarea name="equipmentVO.description" rows="5" class="areatran" id="description">${ equipmentVO.description}</textarea></td>
                      </tr>
                  </table>
                  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
                    <tfoot>
                    </tfoot>
                    <tbody>
                      <tr>
                        <td>
                           <input type="button" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
                        </td>
                      </tr>
                    </tbody>
                </table>            
            </div></div>
  </body>
</html>