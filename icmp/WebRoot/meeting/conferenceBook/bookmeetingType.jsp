<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.action.meeting.util.BaseInfoHelp" %>
<%@ page import="com.zzst.model.enums.BaseInfoEnum"%>
<!--<div class="fl"><li id="Tab1"  onClick="javascript:switchTab('Tab1');" >视频会议</li>&nbsp;</div>
<div class="fl"><li id="Tab2" class="Selected" onClick="javascript:switchTab('Tab2');">本地会议</li></div>
 -->
<%=BaseInfoHelp.listBaseInfoHtmlStr(BaseInfoEnum.DICTIONARY_MEEITNG_TYPE)%>