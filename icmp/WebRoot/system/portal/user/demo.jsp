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
      <input type="text" onclick="javascript:selectUsers(this);" id="selectPeopleName">
      <input type="text" id="selectPeopleID">
  
      <script type="text/javascript">
         /**
          *方法说明
          *方法名称：creatUserSelect(param1,param2)
          *参数param1为点击的事件触发对象
          *参数param2为参数对象
          *param2具体说明：
          *  methodName:返回函数名称
          *  selectedUser：已选人员
          *  selectType:选择类型radio为单选，multiple为多选
          **/
          
          function selectUsers(thisDom){
              var userParameters = {
                  methodName:'getReturnUserMethod',
                  selectedUser:'10020691-10015390-10015391-10015392-10015393',
                  selectType:'multiple'
              }
             creatUserSelect(thisDom,userParameters); 
          }
          //返回方法
          //用于获取返回参数
          //返回参数为数组类型
          //用法类似VO如获取所选第一个用户的名称则为userArray[0].userName
          //以提供的参数：userName,userID,userNO
          //mobilePhone 移动电话
	      //telPhone 电话
	      //departmentID	;		// 部门ID
          //departmentName	;		// 部门名称
	      // positionID		;		// 职位ID
	      //positionName    ;       //职位名称
          function getReturnUserMethod(userArray){
              //alert(userArray);
              alert(userArray[0].userID);
              alert(userArray[0].userName+"//"+userArray[0].departmentName);
          }
      </script>
  </body>
</html>
