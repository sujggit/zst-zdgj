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
		function delAddress(id){
			
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="${sys_ctx }/address/delAddress.action?addressVO.addressID="+id;
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
		
	function modifyAddress(id){
	var url="${sys_ctx }/address/modifyAddressBefore.action?addressVO.addressID="+id;
	location.href=url;
	}
		
	function tijiao(){
      
      var path=document.getElementById("fileName");
      document.getElementById("pathID").value = path.value;

      document.getElementById("form").submit();
   }
   	//添加
   	function addnew(){
   		document.location.href = "${sys_ctx }/address/addAddressBefore.action";
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
	function detailAddress(id)
	{
		window.showModalDialog("${sys_ctx }/address/detailAddress.action?addressVO.addressID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	}
</script>
</head>
<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx }/address/querryAddressList.action" id="pageform" name="pageform" method="post">
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
							<input name="button2" type="button" class="searbutton fontstyle fontb"
								value="查 询" onclick="queryForm();" />
							<input name="button2" type="button" class="searbutton fontstyle fontb"
								value="增 加" onclick="addnew();" />
						</div>
						
					</div>
       				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
						<tr>
							<td class="ar fontstyle fontb pr3 tdhight">位置名称：</td>
							<td class="al pl3 tdhight">
				            	<input type="text" name="addressVO.name" id="addressVO.name" class="input200 fontstyle" value="${addressVO.name }"/>
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
							cellpadding="0" class="stdtable">
							<thead>
								<tr>
					          	<th width="8%" >序号</th>
					            <th width="20%"  >位置名称</th>
					            <th width="18%" >上级节点</th>
					            <th width="18%"  >状态</th>
					            <th width="18%"  >描述</th>
					            <th width="18%"  >操作</th>
					          </tr>
					          </thead>
					          <tbody>
	          <c:forEach items="${addressVOList}" var="address" 	varStatus="state">
		              <tr >
		              		<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				            <td >&nbsp;<c:out value="${address.name}"/></td>
				            <td>&nbsp;<c:out value="${address.parentID}"/></td>
				            <td>&nbsp;<c:out value="${address.status}"/></td>
				            <td>&nbsp;<c:out value="${address.description}"/></td>
				           
				            <td class="alc">
				                <img src="/icmp/images/main/hr.gif"  style="cursor:pointer" onclick="delAddress('${address.addressID}')" title="删除" name="button2" id="button2" value="" class="cx_delete" />
				            	<img src="/icmp/images/main/edit-icon.gif" style="cursor:pointer" onclick="modifyAddress('${address.addressID}');"  title="修改" name="button2" id="button2" value="" class="cx_Modify" />
				   				<img src="/icmp/images/main/save-icon.gif" style="cursor:pointer"  onclick="detailAddress('${address.addressID}');"  title="查看" name="button2" id="button2" value="" class="cx_Detailed" />
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
