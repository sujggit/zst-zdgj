<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<%@include file="/common/common.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/meeting/config/js/centerControlJS.js'></script>
		<title>中控配置增加</title>
		<script type="text/javascript">
            /**
			*	返回列表
			*@return	null*/
            function backHistory(){
            	window.location.href="${sys_ctx}/config/getCenterControlList.action";
            }

           function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("equipmentName","不超过25个字符");	
			    obj.title("ccNO","不超过25个字符");	
			    obj.title("ccIP","请选择");	
			    obj.title("equipmentType","请选择");	
			}

			/**
			*	中控配置添加事件，实现验证、友好提示功能
			*@return	null		*/
			
               function centerControlAdd(){
                  $('#centerControlAddForm').validate({    
					rules:{   
						"centerControlVO.equipmentName" : {
	           			 	minlength:1,
		           	 	    maxlength:25,
				            required:true
				         },
				         "centerControlVO.ccIP" : {	
				        	   	minlength:1,				      
				           		required:true
				          },
					   "centerControlVO.equipmentType" : {
					           minlength:1,
					            //maxlength:25,
					           required:true
					     },
					     "centerControlVO.ccNO" : {
					           minlength:1,
						       maxlength:25,
						       //digits:true,
					           required:true
					     }
					      //"centerControlVO.controlInitDate" : {
					      //     required:true,
					     //      },
					}  
				  });
                  //$('#centerControlAddForm').submit();
                  check();
             }

               /**
      			*	验证中控配置名称
      			*@return	null
      			*/
   			function check(){
   				var equipmentName = document.getElementById("equipmentName").value;
   				var ccNO = document.getElementById("ccNO").value;
   				var ccIP = document.getElementById("ccIP").value;
   				var equipmentType = document.getElementById("equipmentType").value;
   				if(ccIP && equipmentType && ccNO && equipmentName){//都是必填
   					BaseDwrMethod.checkCenterControlInfo(ccIP,equipmentType,equipmentName,ccNO,function(result){
   						if(result){
   							alert(result);
   						}else{
   							$('#centerControlAddForm').submit();
   						}
   					})
   				}else{
   					$('#centerControlAddForm').submit();
   				}
   			}
   			
   			
   			
    	</script>
	</head>
	<body onload="pageInit();" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx}/config/addCenterControlInfo.action"
			id="centerControlAddForm" name="centerControlAddForm" method="post">
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">中控配置增加</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					
					<tr>
						<td class="tableaddtitle">
							<span>*</span>中控IP
						</td>
						<td class="tableadd_data">
							<select name="centerControlVO.ccIP" id="ccIP"
								class="select200 fontstyle">
								<option value="">请选择</option>
								<c:forEach items="${ccEquipmentList}" var="equipmentsVO" varStatus="statue">
									<option value="${equipmentsVO.ip}">
										${equipmentsVO.meetingRoomVO.meetingRoomName}(${equipmentsVO.ip
										})
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle">
							<span>*</span>设备类型
						</td>
						<td class="tableadd_data">
							<select name="centerControlVO.equipmentType" id="equipmentType"
								title="请选择" class="select200 fontstyle" style="cursor: pointer" onchange="controlView(this);">
								<zzst:option type="ccequipmentType" value="${centerControlVO.equipmentType}" required="true" />
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><span id="spanTitle"></span></font>
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle">
							<span>*</span>设备名称
						</td>
						<td class="tableadd_data">
							<input type="text" name="centerControlVO.equipmentName"
								id="equipmentName" class="inputtran" value="计算机矩阵"/>

						</td>
					</tr>
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>设备编号
						</td>
						<td class="tableadd_data">
							<input maxlength="25" type="text" name="centerControlVO.ccNO" id="ccNO"
								class="inputtran" value="1"/>
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>详细配置
						</td>
						<td class="tableadd_data">
							<textarea class="areatran" name="centerControlVO.controlInitDate"
								id="controlInitDate" cols="5" >in:01-输入一;02-输入二out:01-输出一;02-输出二</textarea>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<td>
								<input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定"
									onclick="centerControlAdd();" />
								<input type="button" class="reset1 radius2" value="取 消"
									onclick="backHistory();" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</body>
</html>