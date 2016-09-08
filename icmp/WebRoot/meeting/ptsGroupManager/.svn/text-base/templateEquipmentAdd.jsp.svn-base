<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>添加会场</title>
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
           
             $('#addForm').validate({    
					rules:{    
					   "templateEquipmentVO.equipmentName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
				      "templateEquipmentVO.equipmentIp" : {
				               required:true,
				                checkIP:true					         
					           }
					}
					
				  });
	      $("#addForm").submit();
		}
    </script>
</head>
<body onload="pageInit();" style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
	<form action="${sys_ctx}/templateEquipment/MeetingEquipmentAdd.action" id="addForm" name="addForm" method="post">
	  <div id="basicform" class="contentwrapper">
		<input type="hidden" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}"/> 
		<div class="contenttitle2">
			<h5 class="fwb fl10">添加会场</h5>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				<tr>
					<td width="15%" class="tableaddtitle">
						<span>*</span>名称
					</td>
					<td width="35%" class="tableadd_data">
						<input type="text" class="inputtran"
							name="templateEquipmentVO.equipmentName" id="equipmentName"
						
							 />
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
						<span>*</span>类型					</td>
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
							 />
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
							<option value="">
								AUTO
							</option>
							<option value="384">
								384
							</option>
							<option value="512">
								512
							</option>
							<option value="768">
								768
							</option>
							<option value="1024">
								1024
							</option>
							<option value="1536">
								1536
							</option>
							<option value="1920">
								1920
							</option>
							<option value="2048">
								2048
							</option>
							<option value="4096">
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
							<option value="auto">
								AUTO
							</option>
							<option value="cif">
								CIF
							</option>
							<option value="sd">
								SD
							</option>
							<option value="hd_720">
								HD 720
							</option>
							<option value="hd_1080">
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
							<option value="auto">
								自动
							</option>
							<option value="h261">
								h261
							</option>
							<option value="h263">
								h263
							</option>
							<option value="h264">
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
						<select style="width: 20%; float: left"
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
						<select style="width: 20%; float: left"
							name="templateEquipmentVO.cascadeRole">
							<option value="none">
								none
							</option>
							<option value="master">
								master
							</option>
							<option value="slave">
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
						<select style="width: 20%; float: left"
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
							<input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定"
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