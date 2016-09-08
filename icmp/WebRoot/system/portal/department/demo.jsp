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
  
      <input type="text" onclick="javascript:selectDepartments(this)" id="departmentName">
      <input type="text" id="departmentID">
	  <script type="text/javascript">
	         /**
	          *方法说明
	          *方法名称：creatUserSelect(param1,param2)
	          *参数param1为点击的事件触发对象
	          *参数param2为参数对象
	          *param2具体说明：
	          *  methodName:返回函数方法名称
	          *  peopleID：要显示人员ID的页面元素id
	          *  splitString:分隔符
	          *  selectType:选择类型radio为单选，multiple为多选
	          *  middleSelect:中间部门是否可选,可选则添加此参数并设置为true
	          *  不可选中间部门则直接不添加此参数或者设置为false;
	          **/
	          
	          function selectDepartments(thisDom){
	              
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectedDepart:'1-2-4-3',
	                  selectType:'multiple',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
	          
	          //返回方法
	          //用于获取返回参数
	          //返回参数为数组类型
	          //用法类似VO如获取所选第一个部门的名称则为departArray[0].departmentName
		      //已提供的部门参数：departmentID,departmentCode,departmentName
		      //departArray["departNameExtra"] 外部部门
	          function getReturnDepartMethod(departArray){
	              alert(departArray["departNameExtra"]);
	              alert(departArray[0].departmentName+"//"+departArray[0].fullName+"//ARRAY0:"+departArray[0].departmentID);
	              alert(departArray[1].departmentName+"//"+departArray[1].fullName+"//ARRAY1："+departArray[1].departmentID);
 	         
	          }
	      </script>
      
  </body>
</html>
