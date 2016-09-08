<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>会议比对列表</title>
		
		<script type="text/javascript">
		 function modify(id){
  location.href="${sys_ctx}/videoCardCompare/singleCompareCriteria.action?comparisonReferenceVO.ID="+id;
  }	
  
  
  function singleCompareadd(){
  window.location.href="${sys_ctx}/meeting/meetingManage/singleComparisonCriteriaAdd.jsp";
  
  }
  
  
   function equipmentdel(ID){
  
	if(!window.confirm("是否确认删除？")) return;
  window.location.href="${sys_ctx}/videoCardCompare/SingleCompareCriteriaDel.action?comparisonReferenceVO.ID="+ID;
  
  }
     </script>  
     
</head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   
    <form action="/icmp/videoCardCompare/queryCompareMeeting.action" method="post" name="pageform" id="pageform">
    <div id="basicform" class="contentwrapper">  
    <!--pageheader-->
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" align="center">
        <tr>
          <td width="15%" class="tableaddtitle">会场名称</td>
          <td class="tableadd_data">
          <input name="meetingRoomID" id="meetingRoomID" type="hidden" value="${meetingRoomID}"/>
           <input  name="meetingRoomName" value="${meetingRoomName}" style="cursor:pointer" readonly="readonly" onclick="javascript:selectConference(this)" class="inputtran"  id="meetingRoomName" type="text"/>
            <script type="text/javascript">
                    function selectConference(thisDom){
                          var selectedConference = document.getElementById("meetingRoomID").value;
			              var conferenceParameters = {
			                  methodName:'getReturnConferenceMethod',
			                  selectedConference:selectedConference,
			                  selectType:'radio'
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
			              var conferenceName = "";
			              var conferenceID = "";
			              var length = conferenceArray.length;
			              for(var i=0;i<length;i++){
			                      conferenceName =conferenceName+conferenceArray[i].conferenceName;
			                      conferenceID = conferenceID+conferenceArray[i].conferenceID;
			              }
			              document.getElementById("meetingRoomName").value=conferenceName;
			              document.getElementById("meetingRoomID").value=conferenceID;
			
			             // DwrMethod.getMcuTemplateByMeetingRoomID(conferenceID,getTemplateCallBack);
			          }
			          
			         //// function getTemplateCallBack( result ){
	 	    		//	document.getElementById('mySelect_02').innerHTML='<select name="meetingDetailVO.confProfileID" id="model" class="select200 fontstyle" >'+ result+'</select>';
	 			    // }
                </script>   
              
              
              
                       
          </td>
          
          
          
          <td class="tableaddtitle"><input type="button" class="stdbtn mlr10" value="查 询" onclick="queryForm();"/></td>
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
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a style="cursor: pointer;" onclick="singleCompareadd();">增加</a> </h5>
      </div>
      <!--contenttitle-->
      
      <!--<div class="tableoptions">
       <span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
      </div>-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th class="head1" width="10%" >序号</th>
            <th class="head1" width="70%" >会场名称</th>
            <th  class="head1" width="20%">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
           <c:forEach items="${comparisonReferenceVOList}" var="comparisonReferenceVO" varStatus="status">
				        <tr>
				          	<td class="alc"><c:out value="${status.index+1}"></c:out></td>
				          	<td>
				          		<c:out value="${comparisonReferenceVO.meetingRoomName}" />
				
				          	</td>
				          	<%--<td class="center">
				          		<c:out value="${meetingDetailVO.meetingName}" />
				          	</td>--%>
				          	<td class="alc">
				          <a style="cursor: pointer;" onclick="modify('${comparisonReferenceVO.ID}');">修改</a>|<a style="cursor: pointer;" onclick="equipmentdel('${comparisonReferenceVO.ID}');">删除</a>
				          	</td>
				          

				          
				        </tr>
			</c:forEach>
        </tbody>
      </table>
     <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
	</div>
   </form>
  </body>
</html>
