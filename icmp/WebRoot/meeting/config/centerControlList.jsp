<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
	<head>
		<%@include file="/common/common.jsp"%>
		<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>中控配置管理</title>
		<script type="text/javascript">
		//add by yangyi		
			function selectDepartments(thisDom){
	              
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectType:'radio',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
			//add by yangyi
		    function getReturnDepartMethod(departList){
		    
		    	var departmentID="";
	            var departmentName="";
	            var depLength = departList.length;
	            for(var i=0;i<depLength;i++){
	              departmentID+=departList[i].departmentID;
	              departmentName+=departList[i].departmentName;
	              
	              //alert(departList[i].departmentName+" + "+departList[i].departmentID);
	            }
	          	$("#corpID").attr("value",departmentID);
               	$("#corpName").attr("value",departmentName);
		    }
		function delCCInfo(id){
			
			if(!confirm("确认删除？")){
				return;
			}	
			location.href="${sys_ctx }/config/delCenterControlInfo.action?centerControlVO.id="+id;
		}
		

		/**
		function departmentTree(corpID, corpName){
			var retVal=window.showModalDialog('/icmp/meeting/department/tree.jsp','example03','dialogWidth=300px;dialogHeight=427px;directories;scrollbars=yes');
	       if(retVal==undefined){
			return;
			}
	        var arrayValue = retVal.split("-");
	         if(arrayValue.length>=2){

			   document.getElementById("corpName").value=arrayValue[0];
			   document.getElementById("corpID").value=arrayValue[1];
			   }
			   else if (arrayValue.length==1 && arrayValue[0]=="1"){
			   document.getElementById("corpName").value="";
			   document.getElementById("corpID").value="";
			   }
	
		}
		**/
		
	function modifyCCInfo(id){
	var url="${sys_ctx }/config/modifyCenterControlInfoBefore.action?centerControlVO.id="+id;
	location.href=url;
	}
		
	function tijiao(){
      
      var path=document.getElementById("fileName");
      document.getElementById("pathID").value = path.value;

      document.getElementById("form").submit();
   }
  
   	function addnew(){
   		document.location.href = "${sys_ctx }/config/addCenterControlInfoBefore.action";
   	}
  
	
	
	/**
	*²
	*@param		${String}	id
	*@return	null	
	*/
	function detailCCInfo(id)
	{
		window.showModalDialog("${sys_ctx }/config/getCenterControlInfo.action?centerControlVO.id="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	}
	
	function exportEquipment(){
	           var ccIp= document.getElementById("ccIp").value;
	          
				location.href="${sys_ctx }/config/centerControlInfoExportQuery.action?centerControlVO.ccIP="+ccIp;
				//document.getElementById('pageform').action="${sys_ctx}/config/getCenterControlList.action";
			}
	
	function add(){
  location.href="${sys_ctx}/config/addCenterControlInfoBefore.action";
  }	

	function copyCCInfo(id){
		location.href="${sys_ctx }/config/copyCenterControlInfoBefore.action?centerControlVO.id="+id;
	}
</script>
	</head>

	<body>
		<form action="${sys_ctx }/config/getCenterControlList.action" id="pageform" name="pageform" method="post">
				<div id="basicform" class="contentwrapper">

					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="tableadd">
						<tr>
							<td width="15%" class="tableaddtitle">
								中控IP
							</td>
							<td class="tableadd_data">
								<select name="centerControlVO.ccIP" id="ccIp" class="select200 fontstyle" onchange="queryForm();">
								<option value="">请选择</option>
				                <c:forEach items="${ccEquipmentList}" var="equipmentsVO" varStatus="statue">
				   				  <option value="${equipmentsVO.ip}"  ${centerControlVO.ccIP==equipmentsVO.ip  ? "selected" : "" }  >${equipmentsVO.meetingRoomVO.meetingRoomName}(${equipmentsVO.ip })</option>
				   				</c:forEach>
				              </select>
								
							</td>

						</tr>
					</table>
					<div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />         
        </a>
        </div>

                  </div>
                  
                  
					<div class="contenttitle2">
						<h5 class="fwb fl10">
							查询列表
						</h5>
						<h5 class="fwb fr10">
							<a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" onclick="add();">增加 </a> 
							<a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" onclick="exportEquipment();"> 导出</a>
						</h5>
					</div>
					
     
     
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
						id="query_table">
						<thead>
							<tr>
								<th width="6%" class="head1">
									序号
								</th>
								<th width="14%" class="head1">
									设备名称
								</th>
								<th width="12%" class="head1">
									中控IP
								</th>
								<th width="15%" class="head1">
									设备类型
								</th>
								<th width="12%" class="head1">
									设备编号
								</th>
								<th width="17%" class="head1">
									操作
								</th>
							</tr>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<c:forEach items="${ccList}" var="centerControl"
								varStatus="state">

								<tr>
									<td class="alc">
										<c:out value="${state.index+1}"></c:out>
									</td>
									<td>
										&nbsp;
										<c:out value="${centerControl.equipmentName}"></c:out>
									</td>
									<td>
										&nbsp;
										<c:out value="${centerControl.ccIP}" />
									</td>
									<td class="center">
										<zzst:lable type="ccequipmentType"
											value="${centerControl.equipmentType}"></zzst:lable>
									</td>
									<td>
										&nbsp;
										<c:out value="${centerControl.ccNO}"></c:out>
									</td>
									<td class="alc">
										<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" style="cursor: pointer;"
											onclick="javascript:detailCCInfo('${centerControl.id}')" />查看
										 
										<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" style="cursor: pointer;"
											onclick="javascript:modifyCCInfo('${centerControl.id}')" />修改
										 
										<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" style="cursor: pointer;"
											onclick="javascript:delCCInfo('${centerControl.id}')" />删除
											
										<a class="funcOper <%= FuncEnum.FUNC_NO_COPY%>" style="cursor: pointer;" 
											onclick="javascript:copyCCInfo('${centerControl.id}')" />复制
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<jsp:include page="/common/pageFooter.jsp" />
				</div>
		</form>
	</body>
</html>
