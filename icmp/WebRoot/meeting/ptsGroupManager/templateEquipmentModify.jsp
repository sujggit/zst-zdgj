<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>修改会场</title>
		<%@include file="/common/common.jsp"%>
		<script type="text/javascript">
			/**
			*	设置页面参数
			*@return	null	
			*/
          function pageInit(){
			    var obj = new htmlUtil();
				obj.title("equipmentName","输入长度不超过25个字符");				
				obj.title("equipmentIp","输入正确格式的ip");	
			};
			/**
			*	修改会议室
			*@return	null	
			*/
   			
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(equipmentGroupID){
            	window.location.href="${sys_ctx}/templateEquipment/MeetingEquipmentQuery.action?templateEquipmentGroupVO.ID="+equipmentGroupID;
            };
             /**
			*	选择管理员
			*@return	null
			*/
           function add(){
          
		$("#addForm").submit();
		
		}
	</script>
</head>
<body onload="pageInit();" style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
	<form action="${sys_ctx}/templateEquipment/MeetingEquipmentModify.action" id="addForm" name="addForm" method="post">
	    <div id="basicform" class="contentwrapper">
			<input type="hidden" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}"/> 
			<input type="hidden" name="templateEquipmentVO.ID" value="${templateEquipmentVO.ID}"/> 
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					修改会场
				</h5>
			</div>

			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="tableadd">
				<tr>
					<td width="15%" class="tableaddtitle">
						<span>*</span>名称
					</td>
					<td width="35%" class="tableadd_data">
						<input type="text" class="inputtran"
							name="templateEquipmentVO.equipmentName" id="equipmentName"
							value="${templateEquipmentVO.equipmentName}" />
					</td>
					<td width="15%" class="tableaddtitle">
						<span>*</span>呼叫方式方向
					</td>
					<td width="35%" class="tableadd_data">
						<select style="width: 49%; float: left"
						name="templateEquipmentVO.callDirection">
							<option value="1" <c:if test="${templateEquipmentVO.callDirection == '1' }">selected</c:if>  >
								呼出
							</option>
							<option value="0" <c:if test="${templateEquipmentVO.callDirection == '0' }">selected</c:if>  >
								呼入
							</option>

						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						<span>*</span>类型
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.pInterface">
							<option value="h323">
								h.323
							</option>

						</select>
					</td>
					<td class="tableaddtitle">
						<span>*</span>IP地址
					</td>
					<td class="tableadd_data">
						<input type="text" style="float: left"
							name="templateEquipmentVO.equipmentIp" id="equipmentIp"
							value="${templateEquipmentVO.equipmentIp}" />
						<span style="color: red;">&nbsp;*必填</span>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						<span></span>别名/类型
					</td>
					<td class="tableadd_data">
						<input type="text" name="templateEquipmentVO.aliasName" value="${templateEquipmentVO.aliasName}"/>

						<select style="width: 120px;" name="templateEquipmentVO.aliasType">
							<option value="323_id" <c:if test="${templateEquipmentVO.aliasType == '323_id' }">selected</c:if> >
								323_ID
							</option>
							<option value="e164"  <c:if test="${templateEquipmentVO.aliasType == 'e164' }">selected</c:if>>
								e164
							</option>
						</select>
					</td>
					<td class="tableaddtitle">
						<span>*</span>连接速率
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.lineRate">
							<option value="" <c:if test="${templateEquipmentVO.lineRate == '' }">selected</c:if>>
								AUTO
							</option>
							<option value="384" <c:if test="${templateEquipmentVO.lineRate == '384' }">selected</c:if>>
								384
							</option>
							<option value="512" <c:if test="${templateEquipmentVO.lineRate == '512' }">selected</c:if>>
								512
							</option>
							<option value="768" <c:if test="${templateEquipmentVO.lineRate == '768' }">selected</c:if>>
								768
							</option>
							<option value="1024" <c:if test="${templateEquipmentVO.lineRate == '1024' }">selected</c:if>>
								1024
							</option>
							<option value="1536" <c:if test="${templateEquipmentVO.lineRate == '1536' }">selected</c:if>>
								1536
							</option>
							<option value="1920" <c:if test="${templateEquipmentVO.lineRate == '1920' }">selected</c:if>>
								1920
							</option>
							<option value="2048" <c:if test="${templateEquipmentVO.lineRate == '2048' }">selected</c:if>>
								2048
							</option>
							<option value="4096" <c:if test="${templateEquipmentVO.lineRate == '4096' }">selected</c:if>>
								4096
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						<span>*</span>分辨率
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.maxResolution">
							<option value="auto" <c:if test="${templateEquipmentVO.maxResolution == 'auto' }">selected</c:if>>
								AUTO
							</option>
							<option value="cif" <c:if test="${templateEquipmentVO.maxResolution == 'cif' }">selected</c:if>>
								CIF
							</option>
							<option value="sd" <c:if test="${templateEquipmentVO.maxResolution == 'sd' }">selected</c:if>>
								SD
							</option>
							<option value="hd_720" <c:if test="${templateEquipmentVO.maxResolution == 'hd_720' }">selected</c:if>>
								HD 720
							</option>
							<option value="hd_1080" <c:if test="${templateEquipmentVO.maxResolution == 'hd_1080' }">selected</c:if>>
								HD 1080
							</option>
						</select>
					</td>
					<td class="tableaddtitle">
						<span>*</span>视频协议
					</td>
					<td class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.videoProtocol">
							<option value="auto" <c:if test="${templateEquipmentVO.videoProtocol == 'auto' }">selected</c:if>>
								自动
							</option>
							<option value="h261" <c:if test="${templateEquipmentVO.videoProtocol == 'h261' }">selected</c:if>>
								h261
							</option>
							<option value="h263" <c:if test="${templateEquipmentVO.videoProtocol == 'h263' }">selected</c:if>>
								h263
							</option>
							<option value="h264" <c:if test="${templateEquipmentVO.videoProtocol == 'h264' }">selected</c:if>>
								h264
							</option>

						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">
						加密
					</td>
					<td colspan="3" class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.agc">
							<option value="">
								自动
							</option>
							<option value="">
								呼出
							</option>
						</select>
					</td>
				</tr>

				<tr>
					<td class="tableaddtitle">
						级联
					</td>
					<td colspan="3" class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.cascadeRole">
							<option value="none"  <c:if test="${templateEquipmentVO.cascadeRole == 'none' }">selected</c:if>>
								none
							</option>
							<option value="master" <c:if test="${templateEquipmentVO.cascadeRole == 'master' }">selected</c:if>>
								master
							</option>
							<option value="slave" <c:if test="${templateEquipmentVO.cascadeRole == 'slave' }">selected</c:if>>
								slave
							</option>


						</select>
					</td>
				</tr>

				<tr>
					<td class="tableaddtitle">
						IP Network Service
					</td>
					<td colspan="3" class="tableadd_data">
						<select style="width: 49%; float: left"
							name="templateEquipmentVO.description">
							<option value="IP Network Service"
								<c:if test="${templateEquipmentVO.description == 'IP Network Service' }">selected</c:if>>
								IP Network Service
							</option>
							<option value="Multiple Service2"
								<c:if test="${templateEquipmentVO.description == 'Multiple Service2' }">selected</c:if>>
								Multiple Service2
							</option>

						</select>
					</td>
				</tr>
			</table>
			<table cellpadding="0" cellspacing="0" border="0"
				class="buttoncontainer" id="table">
				<tfoot>
				</tfoot>
				<tbody>
					<tr>
						<td>
							<input type="button" class="submit1 radius2" value="确 定"
								onclick="add();" />
							<input type="button" class="reset1 radius2" value="取 消"
								onclick=" backHistory('${templateEquipmentGroupVO.ID}');" />
						</td>
					</tr>
				</tbody>
			</table>
		  </div>
		</form>
	</body>
</html>