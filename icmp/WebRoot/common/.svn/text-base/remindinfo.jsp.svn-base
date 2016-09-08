<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

	
	
<html>

<%
		String	dispMode	=	request.getParameter("pagepromptCode");
		String infoType		=	"";
		String infoName		=	"";
		String	dispContent	=	"";
		String title	=	"说明";
		DictionaryVO dictionaryVO=new DictionaryVO();
			dictionaryVO.setDicType(dispMode);
			ArrayList dList = new ArrayList();
			dList = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
		
		
		
	
		
	%>
	


	
	<head>
	<%@include file="/common/common.jsp"%>
		<title>详细信息</title>
		
	</head>

	<body>
		<div id="basicform" class="contentwrapper">
			<div class="contenttitle2"  >
       	 		<h5 class="fwb fl10"><%=title %></h5>
     		</div>
			
			
			<%
				if("meetingNoticeType".equals(dispMode)){
			%>
			
			<table  width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				<%
					for(int i=0;i<dList.size();i++){
					DictionaryVO di = new DictionaryVO();
					di =(DictionaryVO) dList.get(i);
				%>
				<tr><td  class="tableaddtitle" style="width: 20%"> <%= di.getDicViewName() %> </td>
				<td class="tableadd_data" ><%= di.getDescription() %></td>
				</tr>	
				<%  
					}
				%>
			</table>		
			
			<%
				}else if("meetingServiceType".equals(dispMode)){
			%>
			
			<table  width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				<%
					for(int i=0;i<dList.size();i++){
					DictionaryVO di = new DictionaryVO();
					di =(DictionaryVO) dList.get(i);
				%>
				<tr><td  class="tableaddtitle"  style="width: 20%"> <%= di.getDicViewName() %> </td>
				<td class="tableadd_data"><%= di.getDescription() %></td>
				</tr>	
				<%  
					}
				%>
				
			 
										
			</table>
			
			
			<%	
				}else if("meetingRecordType".equals(dispMode)){
			%>
			<table  width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				<%
					for(int i=0;i<dList.size();i++){
					DictionaryVO di = new DictionaryVO();
					di =(DictionaryVO) dList.get(i);
				%>
				<tr><td  class="tableaddtitle" style="width: 20%"> <%= di.getDicViewName() %> </td>
				<td class="tableadd_data"><%= di.getDescription() %></td>
				</tr>	
				<%  
					}
				%>
				
			 
										
			</table>
			<%  
					}
				%>
			<table  width="100%" cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td><input type="reset" class="submit1 radius2" value="关 闭" onclick="javascript:window.close();"/>
		              </td>
		          </tr>
		        </tbody>
    		 </table>
		</div>
		
		
	</body>

</html>
       