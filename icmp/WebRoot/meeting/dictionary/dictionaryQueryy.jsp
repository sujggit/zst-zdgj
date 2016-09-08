<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
  <title>数据字典列表</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx }/dictionary/dictionaryList.action" id="pageform" name="pageform" method="post">
  <div id="basicform" class="contentwrapper">  
      
     <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="45%" class="tableaddtitle" align="center">数据类型</td>
          <td width="65%" class="tableadd_data">
          	<select name="dictionaryVO.dicType" id="dicType" title="请选择" style="cursor:pointer" >
          		 <option value="">请选择</option>
				 <zzst:option type="dicType" value="${dictionaryVO.dicType}" required="true">
				 </zzst:option>
				 <option <c:if test="${dictionaryVO.dicType=='controlMenu'}">selected</c:if> value="controlMenu">控制菜单</option>
				 <option <c:if test="${dictionaryVO.dicType=='applyFlow'}">selected</c:if> value="applyFlow">流程类型</option>
			 	 <option <c:if test="${dictionaryVO.dicType=='changeCss'}">selected</c:if> value="changeCss">换肤模板</option>
			 </select>
          </td>
          <td align="center" class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="dictionaryqeury();"/></td>
        </tr>
      </table>
      
      
      <!--
      <div class="widgetcontent">
        <div class="msgmore"  onclick="disquery()";><a href="javascript:void(0);"><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7"  />
              <area shape="rect" coords="36,0,51,6" />
            </map>
        </a></div>
      </div>
      contenttitle-->
      
      
      <!--contenttitle--> 
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a class="funcOper <%= FuncEnum.FUNC_NO_ADD%>" style="cursor: pointer;" onclick="addnew();">增加</a></h5>
      </div>
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table2">
        <thead>
          <tr>
            <th width="50px" class="head1">序号</th>
            <th width="88px" class="head1">数据类型</th>
            <th width="88px" class="head1">数据名称</th>
            <th width="88px" class="head1">数值</th>
            <th width="133px" class="head1">描述</th>
            <th width="166px" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${dList}" var="dictionary" 	varStatus="state">
			<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td>
					<zzst:lable type="dicType" value="${dictionary.dicType}">
					</zzst:lable>
					<c:if test="${dictionary.dicType=='controlMenu'}">控制菜单
					</c:if>
					<c:if test="${dictionary.dicType=='applyFlow'}">流程类型
					</c:if>
					<c:if test="${dictionary.dicType=='changeCss'}">换肤模板
					</c:if>
					<c:if test="${dictionary.dicType=='controlRightMenu'}">右键菜单
					</c:if>
				</td>
				<td>
					<c:out value="${dictionary.dicViewName}"/>
			    </td>
				<td><c:out value="${dictionary.dicValue}"/></td>
                <td title="${dictionary.description}"><c:out value="${dictionary.description}" /></td>
          	    <td class="alc">
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" onclick="javascript:detail('${dictionary.dicID}');"/> 查看
					<c:if test="${dictionary.dicType!='controlMenu' && dictionary.dicType!='applyFlow' && dictionary.dicType!='changeCss' && dictionary.dicType!='controlRightMenu'}">
						<a class="funcOper <%= FuncEnum.FUNC_NO_MODIFY%>" onclick="javascript:modifyDictionary('${dictionary.dicID}');" />  修改 
						<a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:delDictioanry('${dictionary.dicID}');"/>   删除
					</c:if>
          	   	</td>
			</tr>
		  </c:forEach>
        </tbody>
      </table>
    </div>
 </form>
 <script type="text/javascript">
		function delDictioanry(id){
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="delDictionary.action?dictionaryVO.dicID=" + id;
		}
		
		function listUser(){
			document.pageform.submit();
		}
		
	function modifyDictionary(id){
			var url="${sys_ctx }/dictionary/beforeModify.action?dictionaryVO.dicID=" + id;
			location.href=url;
	}
		
	function tijiao(){
      var path=document.getElementById("fileName");
      document.getElementById("pathID").value = path.value;
      document.getElementById("form").submit();
   }
   	//添加
   	function addnew(){
   		document.location.href = "${sys_ctx }/dictionary/beforeAdd.action";
   	}
   
	/**
	*查看详细信息
	*/
	function detail(id){
		window.showModalDialog("${sys_ctx }/dictionary/detail.action?dictionaryVO.dicID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	}
	
	function exportLog(){
		document.getElementById('pageform').action="${sys_ctx}/user/exportQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx}/user/manageUserList.action";
		
	}
	//查询功能
	function dictionaryqeury(){
		  document.getElementById("pageform").submit();
		  var dictionaryTypess= document.getElementById("dicType").value;
	    }
	</script>
</body>
</html>
