<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>四分屏6</title>
<link rel="stylesheet" href="${sys_ctx }/meeting/meetingManage/split/split.css" type="text/css" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
<script type='text/javascript' src='${sys_ctx }/meeting/meetingManage/split/splitJs.js'></script>
</head>
  
<body>
<input type="hidden" value="${confVO.confID}" id="confID"/>
<input type="hidden" value="${confVO.confFlagId}" id="meetingDetailID"/>
<div class="k_right">
	<div>
    	<ul style="width:145px;height:145px;float:right;margin-left:5px">
        	<li>
				<select id="1">
					<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" <c:if test="${meetingMcu.mcu_participant_id == selectItem2 }">selected</c:if>>
						${meetingMcu.mcu_participant_name }
					</option>
					</c:forEach>
				</select>
			</li>
        </ul>
    </div>
    <div>
    	<ul style="width:145px;height:145px;float:right">
        	<li>
				<select id="0">
					<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" <c:if test="${meetingMcu.mcu_participant_id == selectItem1 }">selected</c:if>>
						${meetingMcu.mcu_participant_name }
					</option>
					</c:forEach>
				</select>
			</li>
        </ul>
    </div>
    <div>
    	<ul style="width:265px;height:145px;float:left;margin-right:5px;margin-top:5px">
        	<li>
				<select id="2">
					<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" <c:if test="${meetingMcu.mcu_participant_id == selectItem3 }">selected</c:if>>
						${meetingMcu.mcu_participant_name }
					</option>
					</c:forEach>
				</select>
			</li>
        </ul>
    </div>
    <div>
    	<ul style="width:265px;height:145px;float:left;margin-top:5px">
        	<li>
				<select id="3">
					<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" <c:if test="${meetingMcu.mcu_participant_id == selectItem4 }">selected</c:if>>
						${meetingMcu.mcu_participant_name }
					</option>
					</c:forEach>
				</select>
			</li>
        </ul>
    </div>
</div>
<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer k_bottom" id="table">
	<tfoot>
    </tfoot>
    <tbody>
		<tr>
			<td id="frmright1"><input name="提交" type="button" class="submit1 radius2" value="生效"  onclick="splitSubmit(4,'${LAYOUT_MODE}')"/></td>
		</tr>
	</tbody>
</table>
</body>
</html>

