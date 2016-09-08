<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'demo.jsp' starting page</title>
    <%@include file="/common/common_header.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <input type="text" onclick="javascript:selectConference(this);" id="selectPeopleName">
      <input type="text" id="conferenceID">
  
      <script type="text/javascript">
         /**
          *方法说明
          *方法名称：creatConferenceSelect(param1,param2)
          *参数param1为点击的事件触发对象
          *参数param2为参数对象
          *param2具体说明：
          *  :返回函数名称
          *  selectedUser：已选会场
          *  selectType:选择类型radio为单选，multiple为多选
          **/
          
          function selectConference(thisDom){
              var conferenceParameters = {
                  methodName:'getReturnConferenceMethod',
                  selectedConference:'10020691-10015390-10015391-10015392-10015393',
                  selectType:'multiple'
              }
             creatConferenceSelect(thisDom,conferenceParameters); 
          }
          //返回方法
          //用于获取返回参数
          //返回参数为数组类型
          //用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
          //以提供的参数：conferenceID,conferenceName
          
          function getReturnConferenceMethod(conferenceArray){
              //alert(userArray);
              alert(conferenceArray[0].roomID);
              alert(conferenceArray[0].roomID+"//"+conferenceArray[0].roomName);
          }
      </script>
  </body>
</html>
