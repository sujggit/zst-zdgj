<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>一级菜单</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/UserAction.js'></script>
  <script language="javascript">
	function changeClass(a){
	/**alert("come in");
	 var removeClassA=$('ul li .current a');
       $('li').bind('click',function(){
      
     	removeClassA.removeClass('current');
      	$(this).addClass('current');
      	removeClassA=$(this);
   	});*/
    
	}
	function menu(id,name){
	   var removeClassA=$('ul li .current a ');
       $('li').bind('click',function(){
	       removeClassA.removeClass('current');
	       $(this).addClass('current');
	       removeClassA=$(this);
       });
	   UserAction.getFunTreeByID(id,menuBack);
	}
	
	function menuBack(list){
		if(list){
			if(list.length>0){
				parent.document.getElementById('leftMenu').cols="230,*";
				var ul = parent.frames["leftFrame"].document.getElementById("leftUl");
				$(ul).empty();
				for(var i=0;i<list.length;i++){
		         $(ul).append("<li id=url"+i+" onclick='issession();window.parent.openNewFunction(\""+list[i].func_url+"\",\""+list[i].func_name+"\",\""+list[i].func_id+"\");changeClass(this);'><a href='#' class='"+list[i].className+"'><div style='width:200px;height:21px'>"+list[i].func_name+"</div></a></li>");
					
				}
				leftFrame = parent.frames["leftFrame"];
				leftFrame.document.images[0].src="${sys_style1}/images/one.png";
				/**
				setTimeout(function(){
					var ul = leftFrame.document.getElementById("url0");
					ul.click();
					//$("#url0").trigger("click");
					},100);
				**/
			}
		}else{
			//alert("用户信息失效，请重新登录！");
			window.parent.location.href = "${sys_ctx }/user/userExit.action";
		}
	}
  </script>	
</head>
<body>
  <div class="header">
	  <ul class="menu">
    <c:forEach  items="${sys_userSession.funcVOList}" var="funVO" varStatus="state">
     <c:if test="${(funVO.parent_id!= '-1') &&( funVO.parent_id == '0')&&(funVO.className != null) }">
      <li><a href='#' onclick="menu('${funVO.func_id}','${funVO.func_name }');" id="${funVO.func_id }" style="cursor:hand"><span class="${funVO.className }"></span>${funVO.func_name }</a></li>
     </c:if>
     </c:forEach>
    </ul>
    <!--headerwidget--> 
  </div>
</body>
</html>