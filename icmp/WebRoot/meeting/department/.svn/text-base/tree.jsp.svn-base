<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.zzst.service.meeting.department.*" %>
<%@ page import="com.zzst.model.meeting.department.DepartmentVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	DepartmentService action = new DepartmentServiceImpl();
	List treelist  = action.getAllFuncList(null,null);
  	System.out.println("****************tree:"+treelist.size());
  	
  	String treeStr = "";
	String colorFlag = "";
	
%>

<html>
  <head>
    <title>部门</title>    

	<script type="text/javascript" src="/icmp/js/dtree.js"></script>
     
 	<script type="text/javascript">
 	<!--
 		function dblClickSelect(id){
 			selected(id);
 			confirmContent();
 		}
 		function selected(id){
			var nodes = document.getElementsByName('nodeName');
 			for(var i=0; i<nodes.length; i++){
 				nodes[i].style.background="";
 			}
 			
 			var selectedColor = '#316ac5';
 			var node = document.getElementById(id);
 			node.style.background = selectedColor;
 		}
 		
 		function confirmContent(){
 			var nodes = document.getElementsByName('nodeName');
 			for(var i=0; i<nodes.length; i++){
 				if(nodes[i].style.background == "#316ac5"){
					window.returnValue = nodes[i].innerHTML + "-" + nodes[i].id
		 			window.close();
 				}
 			}
 		}
 		
 		function removeContent(){
			window.returnValue = "1";			
 			window.close(); 
 			window.close();
 		}
 	//-->
 	</script>
  </head>
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
  	<table width="100%" border="0" cellspacing="1" cellpadding="0" >
			      <tr>
			        <td class="tabletitleHome"></td>
			      </tr>
			      <tr>
    <div class="dtree"  style="height:400px;">

	<script type="text/javascript">
		<!--

		d = new dTree('d');
        d.add(0,-1,'导航');
        
		        <%
					for(int i=0;i<treelist.size();i++){
						DepartmentVO vo = (DepartmentVO) treelist.get(i); 
						boolean flag = action.ishaveChild(vo.getId());
						if(flag)
						{
				%>
				    	 d.add(<%=vo.getId()%>,<%=vo.getParentId()%>,'<%=vo.getTitle()%>');
				<%
					}
						else
						{	
	 	            %>  
	 	              	d.add(<%=vo.getId()%>,<%=vo.getParentId()%>,'<a onclick="selected(<%=vo.getId()%>);" ondblclick="dblClickSelect(<%=vo.getId()%>);" style="cursor:hand" id="<%=vo.getId()%>" name="nodeName"><%=vo.getTitle()%></a>');
                    <%}
					}	
                    %>
		  document.write(d);

		//-->
	</script>
     
</div>
 
	  	
	 </tr>
 <tr><td align="center" valign="bottom">
	  	<input type="button" class="mainbtn" value="确认" onclick="confirmContent();"/>
	  	<input type="button" value="清空" class="mainbtn" onclick="removeContent()"/>
	  	
	  </td></tr>
	  </table>
  </body>
</html>
