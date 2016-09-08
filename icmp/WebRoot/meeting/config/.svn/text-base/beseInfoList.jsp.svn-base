<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common_header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>基础配置管理</title>
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
		function delBaseInfo(id){
			
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="${sys_ctx }/baseInfo/delBaseInfo.action?baseInfoVO.id="+id;
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
   	//添加
   	function addnew(){
   		//document.location.href = "${sys_ctx }/config/addCenterControlInfoBefore.action";
   	}
   	//显示隐藏查询域
	function disquery(){
		var obj = document.getElementById("queryid");
		if(obj){
			if(obj.style.display==""){
				obj.style.display = "none";
			}else{
				obj.style.display = "";
			}
			
		}
	}
	
	/**
	*查看详细信息
	*@param		${String}	id
	*@return	null	
	*/
	function detailCCInfo(id)
	{
		window.showModalDialog("${sys_ctx }/config/getCenterControlInfo.action?centerControlVO.id="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	}
</script>
</head>
<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx }/baseInfo/queryBaseInfoList.action" id="pageform" name="pageform" method="post">
 <div id="container">
				<div class="content">
					<div class="contenttitle fontstyle ">
						<div class="fl">
							<img src="${sys_page_list_down}" width="20" height="25" />
						</div>
						<div class="fl fontb">
							&nbsp;查询条件
						</div>
						<div class="fr">
							<%--<input name="button2" type="button" class="searbutton fontstyle fontb"
								value="查 询" onclick="listBaseInfo();" />--%>
							<input name="button2" type="button" class="searbutton fontstyle fontb"
								value="增 加" onclick="addnew();" />
						</div>
						
					</div>
       				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
						<tr>
							<td class="ar fontstyle fontb pr3 tdhight">配置类型：</td>
							<td class="al pl3 tdhight">
				            	<select onchange="queryForm();" name="baseInfoVO.infoType" id="infoType" title="请选择"  class="select200 fontstyle" style="cursor:pointer" >
				            	   <zzst:option type="baseInfoType" value="${baseInfoVO.infoType}" required="false"/>
							    </select>
				            </td>
          				</tr>
        			</table>
        			<div class="contenttitle fontstyle ">
						<div class="fl">
							<img src="${sys_page_list_table }" width="20" height="25" />
						</div>
						<div class="fl fontb">
							&nbsp;查询结果
						</div>
					</div>

					<div class="tablesdiv">
						<table width="100%" border="0" id="query_table" cellspacing="0"
							cellpadding="0" class="listsearch">
							<thead>
								<tr>
					          	<th width="65px" class="titlehome ac fontstyle" >序号</th>
					            <th width="100px" class="titlehome ac fontstyle" >配置类型</th>
					            <th width="" class="titlehome ac fontstyle" >配置名称</th>
					            <th width="150px" class="titlehome ac fontstyle" >配置内容</th>
					            <th width="150px" class="titlehome ac fontstyle" >描述</th>
					            <th width="" class="titlehome ac fontstyle" >顺序</th>
					            <th width="65px" class="titlehome ac fontstyle" >操作</th>
					          </tr>
					          </thead>
					          <tbody>
					           <c:forEach items="${baseInfoList}" var="baseInfo" 	varStatus="state">
		              <tr >
		              		<td class="ac fontstyle "><c:out value="${state.index+1}"></c:out></td>
		              		
		              		<td class="ac fontstyle ">
				            <zzst:lable type="baseInfoType" 
									value="${baseInfo.infoType}">
								</zzst:lable>
				            </td>
				            
				            <!--  <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.infoType}"/></td>-->
				            <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.infoName}"/></td>
				            <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.infoValue}"/></td>
				            <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.description}"/></td>
				            <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.order}"/></td>
				           
				            <td class="ac fontstyle ">
				                <img src="/icmp/images/main/hr.gif"  style="cursor:pointer" onclick="javascript:delBaseInfo('${baseInfo.id}')" title="删除" name="button2" id="button2" value="" class="cx_delete" />
				            </td>
		              </tr>
	          </c:forEach>
        </tbody>
						</table>
					</div>
				
					<jsp:include page="/common/pageFooter.jsp" />
						
				</div>
			</div>
		</form>
	</body>
</html>
