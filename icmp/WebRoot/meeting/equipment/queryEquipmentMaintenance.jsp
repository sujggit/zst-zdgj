<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<%@include file="/common/funcOperPower.jsp"%><!-- 依赖于jquery，必须在common.jsp后面 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>

<title>设备列表</title>
<script type="text/javascript">	

	function addEquipment(){  
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
		
	}
		               
	       
			/**
			*	查看设备管理详细信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDetail(id,id2){
			  if(id2==1){
				window.showModalDialog("${sys_ctx}/equipment/mcuDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			 }else if(id2==0){
				window.showModalDialog("${sys_ctx}/equipment/terminalDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}else if(id2==2){
				window.showModalDialog("${sys_ctx}/equipment/controlDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}else if(id2==4){
				window.showModalDialog("${sys_ctx}/equipment/noticeDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}else if(id2==5){
				window.showModalDialog("${sys_ctx}/equipment/QBoxDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}
			else if(id2==6){
				window.showModalDialog("${sys_ctx}/equipment/microphoneDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}
			else if(id2==7){
				window.showModalDialog("${sys_ctx}/equipment/videoCardDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}else if( id2==8 ){
				window.showModalDialog("${sys_ctx}/equipment/otherEquipmentDetail.action?equipmentVO.equipmentID="+id,window,'dialogWidth=800px;dialogHeight=470px;');
			}
				
          }
			

			/**
			*	修改设备管理信息
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentModify(id,id2){
			
			   if(id2==1){
				   window.location.href="${sys_ctx}/equipment/mcuBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==0){
				   window.location.href="${sys_ctx}/equipment/terminalBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==2){
				   window.location.href="${sys_ctx}/equipment/controlBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==4){
					window.location.href="${sys_ctx}/equipment/noticeBeforeModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==5){
					window.location.href="${sys_ctx}/equipment/QBoxBeforeModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==6){
					window.location.href="${sys_ctx}/equipment/microphoneBeforModify.action?equipmentVO.equipmentID="+id;
				}else if(id2==7){
					window.location.href="${sys_ctx}/equipment/videoCardBeforModify.action?equipmentVO.equipmentID="+id;
				}else if( id2==8){
					window.location.href="${sys_ctx}/equipment/otherEquipmentBeforeModify.action?equipmentVO.equipmentID="+id;
					
				}
			}

			/**
			*删除设备管理详细 信息 
			*@param		${String}	id
			*@return	null	
			*/
			function equipmentDele(id){
				if(!window.confirm("是否确认删除？")) return;
				window.location.href="${sys_ctx}/equipment/delete.action?equipmentVO.equipmentID="+id;
			}
			

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
				document.getElementById('pageform').action="${sys_ctx}/equipment/exportQuery.action";
				document.getElementById('pageform').submit();
				document.getElementById('pageform').action="${sys_ctx}/equipment/queryEquipmentMaintenance.action";
			}

			function equipmentMainTain(id){
				window.showModalDialog("${sys_ctx}/equipment/equipmentMaintain.action?equipmentVO.equipmentID="+id,window,'dialogWidth=600px;dialogHeight=470px;');
			}

		</script>
</head>
 <body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <form action="${sys_ctx}/equipment/queryEquipmentMaintenance.action" id="pageform" name="pageform" method="post">

<div id="basicform" class="contentwrapper">      
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="msgmore">
        <tr>
          <td width="15%" class="tableaddtitle">设备类型</td>
          <td width="35%" class="tableadd_data" >
         	 <select name="equipmentVO.equipmentType" id="equipmentType" title="请选择" style="cursor:pointer" >
				     <zzst:option type="equipmentType" value="${equipmentVO.equipmentType}" required="false"/>
			 </select>
          </td>
          <td width="15%" class="tableaddtitle">维保起止时间</td>
          <td width="35%" class="tableadd_data">
           <input type="text" style="cursor: hand" id="startTime" name="equipmentVO.maintenanceStartTime" 	readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});"   value='<fmt:formatDate value="${equipmentVO.maintenanceStartTime}"  pattern="yyyy-MM-dd HH:mm"/>'/>
            --        
           <input type="text" style="cursor: hand" id="endTime" name="equipmentVO.maintenanceEndTime" 	readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startTime\',{m:10})||\'%y-%M-%d %H:%m\'}'});"   value='<fmt:formatDate value="${equipmentVO.maintenanceEndTime }"  pattern="yyyy-MM-dd HH:mm"/>'/>
           
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
        <h5 class="fwb fr10"><!--<a style="cursor: pointer;" onclick="addEquipment();">增加</a> | --><a class="funcOper <%= FuncEnum.FUNC_NO_EXPORT%>" style="cursor: pointer;" onclick="exportEquipment();"> 导出</a></h5>
      </div>
      <!--contenttitle-->
      
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="6%" class="head1">序号</th>
            <th width="13%" class="head1">设备名称</th>
            <th width="13%" class="head1">设备类型</th>
            <th width="19%" class="head1">所属会议室</th>
            <th width="13%" class="head1">维保开始时间</th>
            <th width="12%" class="head1">期限</th>
            <th width="13%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <c:forEach items="${equipmentVOList}" var="equipmentVO" 	varStatus="state">
				<tr>
				<td class="alc"><c:out value="${state.index+1}"></c:out></td>
				<td><c:out value="${equipmentVO.equipmentNO}"/></td>
				<td>
					<zzst:lable type="equipmentType" 
							value="${equipmentVO.equipmentType}">
					</zzst:lable>
			    </td>
                <td ><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"/></td>
                <td><fmt:formatDate value="${equipmentVO.maintenanceStartTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
                <td><zzst:lable value="${equipmentVO.maintenanceMonths}" type="maintenanceStartTime"></zzst:lable></td>
          	    <td class="alc">
          	       
          	        <a class="funcOper <%= FuncEnum.FUNC_NO_DETAIL%>" style="cursor:pointer"  onclick="javascript:equipmentDetail('${equipmentVO.equipmentID}','${equipmentVO.equipmentType}');" >查看</a> 
          	    	<!-- <a style="cursor:pointer" onclick="javascript:equipmentModify('${equipmentVO.equipmentID}','${equipmentVO.equipmentType}');"  >修改</a> | 
          	    	<a style="cursor:pointer" onclick="javascript:equipmentMainTain('${equipmentVO.equipmentID}');"  >维护</a> |-->
          	        <!--<a  onclick="javascript:equipmentDele('${equipmentVO.equipmentID}');" style="cursor:pointer"  >删除</a> -->
          	    	 
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
