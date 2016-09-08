<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆</title>
	<%@include file="/common/common_header.jsp"%>
  </head>
  
  <body>
    <input    name="imgPath" id="imgPath" />
										
	<input  name="imgTitle" style="cursor:pointer" id="imgTitle" type="text" readonly
			size="30"  onclick="uploadFile(this);"/>
	
	<script type="text/javascript">											
			function uploadFile(element){
	           	 var params = {
		          	methodName:'finish',
					excuteFileType:''
		         }
		         swhUploadFile(element,params); 
		    }
			 function   finish(retvalue){
	           		var processID 	=		retvalue[0] ;
				   	var result 		=		retvalue[1] ;
				   	var message 	=		retvalue[2] ;
					 if(result != "success"){
						alert("上传失败："+message);
						return ;
					}
					var fileCaption =		retvalue[3] ;
				   	var retFactName =		retvalue[4] ;
				   	var retFactPath =		retvalue[5] ;
					 
	                var realPath = retFactPath +"/"+ retFactName;
	                 alert(realPath);
				}
	</script>   
  </body>
</html>
