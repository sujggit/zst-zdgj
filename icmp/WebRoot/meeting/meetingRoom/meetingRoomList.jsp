<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <%@include file="/common/common.jsp"%>
	    <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>会议室管理查询页面</title>
		<script type="text/javascript">
			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomDetail(id){
				window.showModalDialog("${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
                 //window.location.href="${sys_ctx }/meetingRoom/detail.action?meetingRoomVO.meetingRoomID="+id;
			}

			/**
			*	添加会议室
			*@param		null
			*@param		null
			*/
			function addMeetingRoom(){
				 window.location.href="${sys_ctx }/meetingRoom/add.action";
			}

			/**
			*	查看会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomModify(id){
				window.location.href="${sys_ctx }/meetingRoom/modify.action?meetingRoomVO.meetingRoomID="+id;
			}

			/**
			*	复制会议室详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomCopy(id){
				window.location.href="${sys_ctx }/meetingRoom/copy.action?meetingRoomVO.meetingRoomID="+id;
			}

			
			/**
			*删除会议室 详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function meetingRoomDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx }/meetingRoom/delete.action?meetingRoomVO.meetingRoomID="+id;
			}

	          function selectUsers(thisDom){
	              var userParameters = {
	                  methodName:'getReturnUserMethod',
	                  selectType:'radio'
	              }
	             creatUserSelect(thisDom,userParameters); 
	          }
	      
	          function getReturnUserMethod(userArray){
	              //alert(userArray);
	             // alert(userArray[0].userID);
	            //  alert(userArray[0].userName);
	              var userID="";
	              var loginName="";
	              var userLength = userArray.length;
	              for(var i=0;i<userLength;i++){
	            	  userID=userArray[i].userID;
	            	  loginName=userArray[i].userName;
	              }
	          	$("#userID").attr("value",userID);
               	$("#names").attr("value",loginName);
               
             //  	document.getElementById("pageform").submit();
	          }
	          function pageInit(){
				    var obj = new htmlUtil();
					obj.title("meetingRoomType","输选择");	
					obj.title("names","请选择");	
				}
			
			function exportRoom(){
				document.getElementById('pageform').action="${sys_ctx}/meetingRoom/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/meetingRoom/query.action";
			}

		</script>
	</head>
	<body style=OVERFLOW:AUTO;OVERFLOW-X:HIDDEN>
		<form action="${sys_ctx}/meetingRoom/query.action" id="pageform" name="pageform" method="post">
			<div id="basicform" class="contentwrapper">
			  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="">
                 <tr>
                   <td width="15%" class="tableaddtitle">会议室名称</td>
                   <td width="35%" class="tableadd_data" >
			         <input class="inputtran" title="请输入会议室关键字" type="text" name="meetingRoomVO.meetingRoomName" id="meetingRoomName"  value="${meetingRoomVO.meetingRoomName}" />
				   </td>
                   <td width="15%" class="tableaddtitle">会议室类型</td>
                   <td width="35%" class="tableadd_data">
                   <select  class="" name="meetingRoomVO.meetingRoomType" id="meetingRoomType">
					   <zzst:option type="meetingRoomType" value="${meetingRoomVO.meetingRoomType}" required="false" />
				   </select></td>
                   <td class="tableaddtitle"><input type="reset" class="stdbtn mlr10" value="查 询" onclick="queryForm();" /></td>
                </tr>
             </table>
            
       <!--contenttitle-->
     <%@include file="/common/queryHidden.jsp"%>
      
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;"  onclick="addMeetingRoom();">增加 </a> <a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportRoom();"> 导出</a></h5>
      </div>
					
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="19%" class="head1">会议室名称</th>
            <th width="19%" class="head1">会议室类型</th>
            <th width="19%" class="head1">网络拓扑</th>
            <th width="19%" class="head1">所属单位</th>
            <th width="18%" class="head1">操作</th>
          </tr>
        </thead>
		  <tbody>
			<c:forEach items="${meetingRoomVOList}" var="meetingRoomVO" varStatus="state">
				<tr>
					<td class="alc">
						<c:out value="${state.index+1}"></c:out>
					</td>
					<td>
						<c:out value="${meetingRoomVO.meetingRoomName }" />
					</td>
					<td>
						<zzst:lable type="meetingRoomType" value="${meetingRoomVO.meetingRoomType}"></zzst:lable>
					</td>
					<td>
						<c:out value="${meetingRoomVO.addressVO.name}" />
					</td>
					<td >
						<c:out value="${meetingRoomVO.departmentVO.title}" />
					</td>
					<td class="alc">
						<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:meetingRoomDetail('${meetingRoomVO.meetingRoomID}');"/>查看   
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:meetingRoomModify('${meetingRoomVO.meetingRoomID}');" />修改   
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:meetingRoomDele('${meetingRoomVO.meetingRoomID}');"/> 删除    
						<a class="funcOper <%= FuncEnum.FUNC_NO_COPY%>" onclick="javascript:meetingRoomCopy('${meetingRoomVO.meetingRoomID}');"/> 复制
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
