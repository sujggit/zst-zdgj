<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zzst.model.meeting.auth.FuncVO" %>
       

<%
//查询全部功能
 	List list =(List)request.getAttribute("treelist");
 
	String str="";
	List rlist = new ArrayList();
 	rlist =(List) request.getAttribute("rolelist");
 	
	 //判断功能是否关联角色
	Map cmap = new HashMap();
	for(int j=0;j<rlist.size();j++)
	{
		 FuncVO f =(FuncVO)rlist.get(j);
	  	 cmap.put(f.getFunc_id()+"",f.getFunc_id()+"");
	}
	for(int i=0;i<list.size();i++)
	{
		FuncVO func = (FuncVO)list.get(i);
		str=func.getParent_id()+"_"+func.getFunc_id();
	
			if(cmap.containsKey(func.getFunc_id()+""))
			{
				%>
				data["<%=str%>"] = "text: <%=func.getFunc_name() %>;url:javascript:addchecked(this);checked:true;";
				<%			
			}else{
				%>
				data["<%=str%>"] = "text: <%=func.getFunc_name()%>;url:javascript:addchecked(this);";
				<%
			}
	}
%>