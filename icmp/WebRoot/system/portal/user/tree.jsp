
<%
 System.out.println(request.getParameter("parentID"));
 String parentID = request.getParameter("parentID");
 %>

<%@ page language="java" import="java.util.*" contentType="text/xml;" pageEncoding="UTF-8" %> 
<%@ page import="com.zzst.model.meeting.department.DepartmentVO"%>

<%
// DepartmentAction dptAction = new DepartmentAction();
// ArrayList listDpt = dptAction.getDepartmentListByID(parentID);
 
// response.setContentType("text/xml");
  //   if(null!=listDpt){
   //  out.println("<tree text=\"loaded\">");
	//     for(int i=0;i<listDpt.size();i++){
	 //       System.out.println(listDpt.get(i));
	 //       DepartmentVO dpvo = (DepartmentVO)listDpt.get(i);
	        
	    //    if(dpvo.getNodeProperty().equals(DepartmentVO.NODE_PROPERTY_BRANCH)){
	    //        out.println("<tree text='"+dpvo.getDepartmentName()+"' src=\"tree.jsp?parentID="+dpvo.getDepartmentID()+"\"  action=\"javascript:getUser("+dpvo.getDepartmentID()+")\" />");
	   //     }else{
	   //         out.println("<tree text='"+dpvo.getDepartmentName()+"' icon=\"images/xp/folder.png\" action=\"javascript:getUser("+dpvo.getDepartmentID()+")\"/>"); 
	   //     }
	  //   }
	 //           out.println("</tree>");
    // }
%>
