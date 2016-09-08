<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>用户分级配置</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-x:HIDDEN'>
  <div class="contentwrapper">
	<!-- <div id="m" style="background:none;border:none">  
     <%@include file="./levelHead.jsp"%>
    </div> -->
	<div id="k1" class="k" style="display:block">
	  <form action="${sys_ctx }/level/userLevelList.action" id="pageform" name="pageform" method="post">
		<input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_USER %>"/>
		<input id="level_pId" name="level_pId" type="hidden" value="<%=request.getAttribute("level_pId")%>"/>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <!-- <td width="15%" class="tableaddtitle">分级名称</td>
          <td width="35%" class="tableadd_data" >
         	 <input id="levelID" name="levelConfigVO.levelID" type="hidden" />
			 <input id="levelName" name="levelConfigVO.description" class="inputtran" onclick="selectLevelInfo(this)" readonly="readonly" title="请选择" value="${levelConfigVO.description }"/>
          </td> -->
          <td width="35%" class="tableaddtitle">用户名称</td>
          <td width="65%" class="tableadd_data">
          	<input id="userID" name="levelConfigVO.levelKey" type="hidden"/>
			<input id="userName" name="levelConfigVO.levelKeyName" class="inputtran" onclick="selectUsers(this)" readonly="readonly" title="请选择" value="${ levelConfigVO.levelKeyName}"/>
          </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="query();" /></td>
        </tr>
      </table>
      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
		<div class="contenttitle2">
          <h5 class="fwb fl10">查询列表</h5>
          <h5 class="fwb fr10"><!-- <a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;" onclick="userLevelAdd()" class="endLine" >增加</a> --></h5>
        </div>
	
		<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
			<thead>
                <tr>
                    <th width="7%" class="head1">序号</th>
                    <th width="24%" class="head1">分级名称</th>
                    <th width="22%" class="head1" title="拥有本级及下一级的权限">超级用户名称</th>
                    <th width="22%" class="head1" title="仅拥有本级的权限">普通用户名称</th>
                    <th width="25%" class="head1">操作</th>
                </tr>
			</thead>
			<tfoot>
        	</tfoot>
			<tbody>
			  <c:forEach items="${levelList}" var="levelVO" varStatus="state">
              	<tr>
              		<td class="alc"><c:out value="${state.index+1}"></c:out></td>
                    <td>&nbsp;<c:out value="${levelVO.levelName}"/></td>
		            <td title="${levelVO.levelKeyNames1}">&nbsp;<c:out value="${levelVO.levelKeyNames1}"/></td>
		            <td title="${levelVO.levelKeyNames2}">&nbsp;<c:out value="${levelVO.levelKeyNames2}"/></td>
		            <td class="alc">
		            	<a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:userLevelDetail('${levelVO.levelID}');"/> 查看
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:userLevelModify('${levelVO.levelID}');" /> 编辑
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:userLevelDel('${levelVO.levelID}');" class="endLine"/> 删除
						<c:if test="${levelVO.nodeServer==0 }"><a onclick="javascript:modifyNode('${levelVO.levelID}');" />节点</c:if>
					</td>
                </tr>
          	  </c:forEach>                
			</tbody>
		</table>
	  </form>
	</div>
  </div>
  <script type="text/javascript">
  	function userLevelAdd(){
		window.location.href = "${sys_ctx }/meeting/level/userLevelAdd.jsp";
  	}
	//查看用户分级配置详细信息
  	function userLevelDetail(id){
  		window.showModalDialog("${sys_ctx }/level/userLevelDetail.action?levelVO.levelID="+id,window,'dialogWidth=639px;dialogHeight=470px;');
  	}
	//修改用户分级配置信息
  	function userLevelModify(id){
  	  	var level_pId=document.getElementById("level_pId").value;
  		window.location.href = "${sys_ctx }/level/userLevelModifyBefore.action?levelVO.levelID="+id+"&level_pId="+level_pId;
  	}
	//删除用户分级配置信息
  	function userLevelDel(id){
  		if(!confirm("确定要删除吗？")){
			return;
		}
  		var level_pId=document.getElementById("level_pId").value;
  	  	
		var levelType = document.getElementById("levelType").value;
		BaseDwrMethod.checkLevelDel(id,function(para){
			if(para){
				location.href="${sys_ctx }/level/levelConfigDel.action?levelConfigVO.levelID="+id+"&levelConfigVO.levelType="+levelType+"&level_pId="+level_pId;
			}else{
				alert("只有上一级权限的用户才能删除当前分级的用户配置信息");
			}
		})
  	}

  	function query(){
  		document.getElementById("pageform").submit();
  	}
  	
  	function modifyNode(levelID){
  		window.showModalDialog("${sys_ctx }/level/beforeModifyNode.action?levelVO.levelID="+levelID,window,'dialogWidth=639px;dialogHeight=470px;');
  	}
  	/**选择分级信息
	*/
	function selectLevelInfo(thisDom){
		 var uParameters = {
            methodName:'getReturnLevelMethod',
            selectType:'radio'
        }
       creatLevelSelect(thisDom,uParameters);
	}
	function getReturnLevelMethod(returnObj){
		var returnObjs = eval(returnObj);
        var id="";
        var name="";
        for(var i=0;i<returnObjs.length;i++){
      	  id += returnObjs[i].id;
      	  name += returnObjs[i].name;
        }
    	$("#levelID").attr("value",id);
  		$("#levelName").attr("value",name);
   };

	/**选择用户信息
	*/
	function selectUsers(thisDom){
        var userParameters = {
            methodName:'getReturnUserMethod',
            selectType:'radio'
        }
       creatUserSelect(thisDom,userParameters); 
  	};
		function getReturnUserMethod(userArray){
        var userID="";
        var userName="";
        var userLength = userArray.length;
        for(var i=0;i<userLength;i++){
          	if(i==(userLength-1)){
                userName =userName+userArray[i].userName;
                userID = userID+userArray[i].userID;
            }else{
                userName =userName+userArray[i].userName+",";
                userID = userID+userArray[i].userID+",";
            }
        }
    	$("#userID").attr("value",userID);
  		$("#userName").attr("value",userName);
   };
  </script>
</body>
</html>