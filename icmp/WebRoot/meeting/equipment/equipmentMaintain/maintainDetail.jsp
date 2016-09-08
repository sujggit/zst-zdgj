<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>

<title>维修详情列表</title>
<script type="text/javascript">	

	/*function addEquipment(){  
		DwrMethod.getEquipmentType(function backStr( result ){
			if( result == "none"){
				  alert("没有配置设备");
			}else if( result == "0" ){
				window.location.href="${sys_ctx}/equipment/terminalBeforAdd.action";
		    }else if( result == "1"){
		    	window.location.href="${sys_ctx}/equipment/mcuBeforAdd.action";
			}else if( result == "2"){
				window.location.href="${sys_ctx}/equipment/centerControlBeforAdd.action";
			}else if( result == "7"){
				window.location.href="${sys_ctx}/equipment/videoCardBeforeAdd.action";
			}else if( result == "8"){
				window.location.href="${sys_ctx}/equipment/otherEquipmentBeforeAdd.action";
			}
		});
		
	}*/
		               
			/**
			*删除维修详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function maintainDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/equipment/deleteEquipmentMaintain.action?equipmentMaintainVO.maintainID="+id;
			}
		

			/**
			*查询设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			//function equipmentqeury(){
			 // document.getElementById("pageform").submit();
			  //var equipmentTypess= document.getElementById("equipmentType").value;
			  //  document.pageform.submit();
		    //}

            function pageInit(){
			    var obj = new htmlUtil();
				//obj.title("equipmentType","请选择");	
				obj.title("meetingRoomName","请输入");	
			}
			//显示隐藏查询域
			function disquery(){
				$(".tableadd").slideToggle('fast');
			}
			function exportEquipment(){
				document.getElementById('pageform').action="${sys_ctx}/equipment/exportEquipmentMaintainDetail.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipment/maintainDetail.action";
			}

			function backHistory(){
				window.history.go(-1);
			}
		</script>
</head>
 <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/equipment/maintainDetail.action" id="pageform" name="pageform" method="post">
<input type="hidden" value="${equipmentMaintainVO.equipmentID}" name="equipmentMaintainVO.equipmentID"/>
<div id="basicform" class="contentwrapper">      
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="15%" class="tableaddtitle">填写时间</td>
          <td width="35%" class="tableadd_data" align="center">
           <input type="text" style="cursor: hand" id="startTime" name="equipmentMaintainVO.updateStartTime" 	readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='<fmt:formatDate value="${equipmentMaintainVO.updateStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'/>
            --        
           <input type="text" style="cursor: hand" id="endTime" name="equipmentMaintainVO.updateEndTime" 	readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\',{m:10})||\'%y-%M-%d %H:%m\'}'});"   value='<fmt:formatDate value="${equipmentMaintainVO.updateEndTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
           
           </td>
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();" /></td>
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
      
      <!--contenttitle--> 
    </div>
      <div id="contentwrapper" class="contentwrapper"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><!--<a style="cursor: pointer;" onclick="addEquipment();">增加</a> | --><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORTONLY%>" style="cursor: pointer;" onclick="exportEquipment();"> 导出</a><a class="funcOper <%= FuncEnum.FUNC_NO_BACKHISTORY%>" style="cursor: pointer;" onclick="backHistory();">返回</a></h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="15%" class="head1">设备名称</th>
            <th width="15%" class="head1">所属会议室</th>
            <th width="15%" class="head1">费用成本</th>
             <th width="15%" class="head1">状态</th>
            <th width="15%" class="head1">描述</th>
            <th width="16%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${list}" var="equipmentMaintainVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentMaintainVO.equipmentVO.equipmentNO}"/></td>
				<td><c:out value="${equipmentMaintainVO.equipmentVO.meetingRoomVO.meetingRoomName}"/></td>
                <td ><c:out value="${equipmentMaintainVO.maintainCost}"/></td>
                <td ><zzst:lable type="equipmentMaintainStatus" value="${equipmentMaintainVO.status}"></zzst:lable></td>
                <td><c:out value="${equipmentMaintainVO.description}"/></td>
          	    <td class="alc">
          	       
          	        <!--<a style="cursor:pointer"  onclick="javascript:equipmentDetail('${equipmentVO.equipmentID}','${equipmentVO.equipmentType}');" >查看</a>  -->
          	    	<!-- <a style="cursor:pointer" onclick="javascript:equipmentModify('${equipmentVO.equipmentID}','${equipmentVO.equipmentType}');"  >修改</a> | 
          	    	<a style="cursor:pointer" onclick="javascript:equipmentMainTain('${equipmentVO.equipmentID}');"  >维护</a> |-->
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DELETE%>" onclick="javascript:maintainDele('${equipmentMaintainVO.maintainID}');" style="cursor:pointer"  >删除</a> 
          	    	 
          	   	</td>
				</tr>
				</c:forEach>
        </tbody>
      </table>
      <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    
 </form>
</body>


</html>
