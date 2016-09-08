<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum"%>
<!--&nbsp;<a href="${sys_ctx }/equipment/mcuBeforAdd.action">MCU添加</a>
&nbsp;&nbsp;<a href="${sys_ctx }/equipment/terminalBeforAdd.action">终端添加</a>
&nbsp;&nbsp;<a href="${sys_ctx }/equipment/centerControlBeforAdd.action">中控添加</a>
&nbsp;&nbsp;<a href="${sys_ctx }/equipment/microphoneBeforAdd.action">话筒添加</a>
&nbsp;&nbsp;<a href="${sys_ctx}/equipment/noticeBeforAdd.action">告示添加</a>
&nbsp;&nbsp;<a href="${sys_ctx}/equipment/QBoxBeforAdd.action">QBox添加</a> -->
<%=BaseInfoHelp.listBaseInfoHtmlStr(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE)%>