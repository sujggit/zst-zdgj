<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
  <head>
	<%@include file="/common/common.jsp"%>
	<title>告警信息管理</title>
	<script type="text/javascript">	
		/**
		*查询设备管理详细 信息 
		*@param		${String}	id
		*@return	null	
		*/
        function pageInit(){
		    var obj = new htmlUtil();
			obj.title("meetingRoomName","请输入");	
		}
	
		function informationExport(){
			document.getElementById('pageform').action="${sys_ctx}/equipment/exportQuery.action";
			document.getElementById('pageform').submit();
			document.getElementById('pageform').action="${sys_ctx}/equipment/query.action";
		}
		
 		function informationDetail(id){
			window.showModalDialog("${sys_ctx}/info/informationDetail.action?informationVO.infoID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
        }
		
   		/**
		*删除详细 信息 
		*@param		${String}	id
		*@return	null	
		*/
		function informationDel(id){
			if(!window.confirm("是否确认删除？")) return;
			window.location.href="${sys_ctx}/info/informationDel.action?informationVO.infoID="+id;
		}
    
        function informationexportQuery(){
        //var startTime= document.getElementById('startTime').value;
		//var endTime=document.getElementById('endTime').value;
        //window.location.href="${sys_ctx}/info/informationexportQuery.action?informationVO.startTime="+startTime+"&informationVO.endTime="+endTime;
        document.getElementById('pageform').action="${sys_ctx}/info/informationexportQuery.action";
        document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx}/info/queryInformationList.action";
        }
 		//onload="setInterval('open7();',3000);onload="setInterval('getAlert();',3000);""
	</script>
  </head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
	<form action="${sys_ctx}/info/queryInformationList.action" id="pageform" name="pageform" method="post">
	  <div id="contentwrapper" class="contentwrapper">
		<div id="basicform" class="contentwrapper">
		  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
       		<tr>
        		<td class="tableaddtitle">警告类型</td>
        		<td class="tableadd_data">
        		  <select name="informationVO.infoType" class="select200 fontstyle"  id="infoType">                  
          			<zzst:option type="infoType" value="${informationVO.infoType}" required="false"/>
				  </select>
      			</td>  
                <td width="15%" class="tableaddtitle">起止时间</td>
                <td width="35%" class="tableadd_data">
                  <input type="text" id="startTime" name="informationVO.startTime" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${informationVO.startTime }" pattern="yyyy-MM-dd HH:mm"/>'/>
                  --        
                  <input type="text" id="endTime" name="informationVO.endTime" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" value='<fmt:formatDate value="${informationVO.endTime }" pattern="yyyy-MM-dd HH:mm"/>'/>
                </td>
                <td class="tableaddtitle"><input type="button" class="stdbtn mlr10"" value="查 询" onclick="queryForm();" /></td>
       		</tr>
         </table>
		 <div class="widgetcontent">
       	   <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" /></a></div>
         </div>
		 
		 <div class="contenttitle2">
			<h5 class="fwb fl10">查询列表&nbsp;&nbsp; </h5>
       		<h5 class="fwb fr10"><a onclick="informationexportQuery()"> 导出</a></h5>
		 </div>
		 <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
			<thead>
	         <tr>
	           <th width="8%" class="head1">序号</th>
	           <th width="18%" class="head1">警告标题</th>
	           <th width="11%" class="head1">警告类型</th>
	           <%--<th width="11%" class="head1">登录人</th>--%>
	           <th width="12%" class="head1">告警时间</th>
	           <th width="32%" class="head1">描述</th>
	           <th width="8%" class="head1">操作</th>
	         </tr>
           </thead>
		   <tfoot>
		   </tfoot>
	       <tbody>
              <c:forEach items="${informationVOList}" var="informationVO" 	varStatus="state">
			    <tr >
			      <td class="alc"><c:out value="${state.index+1}"></c:out></td>
			      <td><c:out value="${informationVO.title}"/></td>
			      <td>
				     <zzst:lable type="infoType" value="${informationVO.infoType}"></zzst:lable>
		          </td>
			      <%--<td><c:out value="${informationVO.createUserID}" /></td>--%>
	                <td><fmt:formatDate value="${informationVO.createTime}"  pattern="yyyy-MM-dd"/></td>
	                <td><c:out value="${informationVO.content}"/></td>
	         	    <td class="alc">          	    	
	         	        <a style="cursor:pointer"  onclick="javascript:informationDetail('${informationVO.infoID}');"  title="查看">查看</a> 
	         	    	<!--contenttitle<fmt:formatDate value="${informationVO.createTime }"  pattern="yyyy-MM-dd HH:mm"/> <a  onclick="javascript:informationDel('${informationVO.infoID}');" style="cursor:pointer" title="删除" >|删除</a>-->
	         	   	</td>
			    </tr>
			 </c:forEach>
           </tbody>
		</table>
		<jsp:include page="/common/pageFooter.jsp" />
	  </div>
	</div>
   </form>
  </body>
</html>
