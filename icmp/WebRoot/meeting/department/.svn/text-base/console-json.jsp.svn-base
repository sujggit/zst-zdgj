<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zzst.model.meeting.department.DepartmentVO" %>
<%
List list = (List)request.getAttribute("list");
if(list !=null )
{	
%>
[
<%
 for(int i=0; i<list.size();i++ ) 
 { 
	 DepartmentVO obj = (DepartmentVO)list.get(i);
%>

{
	id:'<%=obj.getId() %>',
	text:'<%=obj.getTitle() %>',
    <%if(obj.getLeaf()==1){ %>
		leaf:true,
	<%} %>
	singleClickExpand:true
},
<%} %>
]
<%}%>