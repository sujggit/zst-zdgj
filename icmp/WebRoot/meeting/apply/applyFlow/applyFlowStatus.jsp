<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>审批流程查看页面</title>
		<%@include file="/common/common.jsp"%>
		<style type="text/css">
		   input{border:0px ;}
		</style>
		<link rel="stylesheet" href="${sys_ctx }/plug-in/applyFlow/applyFlow.css" type="text/css"/> 
		
	</head >
 <body style='OVERFLOW-X:HIDDEN'>
   <div id="basicform" class="contentwrapper">
    <div class="contenttitle2" style="width:98%">
        <h5 class="fwb fl10">审批流程：</h5>
      </div>
 	<c:forEach items="${flowList}" var="flowVO" varStatus="state">
  	  <c:if test="${flowVO.flowType==1}" > 
		      <div class="divbg" style="color: red">${flowVO.flowName}
			       <c:if test="${state.index != 0 }">
			          (
				       <c:forEach items="${flowVO.flowMemberList}" var="flowMemberVO" >
				       	  ${flowMemberVO.userVO.name }
				       </c:forEach>
			       	   ) 
			       </c:if>
			       <c:if test="${ state.last == true}">
			         (结束)
			       </c:if>
		      </div>
		      <c:if test="${ state.last == false}">
			        <div class="divarr">
		      			<div class="arrsty"></div>
		            </div>
			  </c:if>
      </c:if>
		 <c:if test="${flowVO.flowType==0}"> 
		    
		        <div class="divbg">
		        	${flowVO.flowName}
		        	
		        	<c:if test="${state.index != 0 }">
			          (
				       <c:forEach items="${flowVO.flowMemberList}" var="flowMemberVO" >
				       	  ${flowMemberVO.userVO.name }
				       </c:forEach>
			       	   ) 
			       </c:if>
			        <c:if test="${ state.last == true}">
				     (结束)
				    </c:if>
		        </div>
		   	    <c:if test="${ state.last == false}">
			        <div class="divarr">
		      			<div class="arrsty"></div>
		            </div>
			   </c:if>
		 </c:if>
    </c:forEach>
    <!--<div class="divbg" >结束</div> -->
     </div>
	</body>
</html>
