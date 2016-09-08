<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
		<title>会场组修改</title>
		<script type="text/javascript">
            /**
			*	返回列表
			*@return	null*/
            function backHistory(){
            	window.location.href="${sys_ctx}/templateEquipmentGroup/MeetingGroupQuery.action";
            }

            function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("name","输入长度不超过25个字符");	
			    obj.title("description","请输入描述");	
			}

			/**
			*	会场组添加事件，实现验证、友好提示功能
			*@return	null		*/
               function meetingGroupModify(){
                  $('#MeetingGroupAddForm').validate({    
					rules:{  
					 "templateEquipmentGroupVO.name" : {	 
				            required:true,
				            maxlength:25
				         }			        
					} 
				  });
                $("#MeetingGroupAddForm").submit();
             }
    	</script>
	</head>
	<body onload="pageInit();" style='OVERFLOW: AUTO; OVERFLOW-X: HIDDEN'>
		<form action="${sys_ctx}/templateEquipmentGroup/MeetingGroupModify.action" id="MeetingGroupAddForm" name="MeetingGroupAddForm" method="post">
     	  	<input type="hidden" name="templateEquipmentGroupVO.ID" value="${templateEquipmentGroupVO.ID}"/>
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						会场组修改 
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td class="tableaddtitle">
							<span>*</span>名称
						</td>
						<td class="tableadd_data">
							<input name="templateEquipmentGroupVO.name" id="name" class="inputtran" value="${templateEquipmentGroupVO.name}" />
							<font size="3"><span id="boolName"></span></font>
						</td>
					</tr>
					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>描述
						</td>
						<td class="tableadd_data">
							<textarea class="areatran" name="templateEquipmentGroupVO.description" id="description" cols="5" >${templateEquipmentGroupVO.description}</textarea>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<td>
								<input type="button" class="submit1 radius2" value="确 定" onclick="meetingGroupModify();" />
								<input type="button" class="reset1 radius2" value="取 消" onclick="backHistory();" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
	</body>
</html>