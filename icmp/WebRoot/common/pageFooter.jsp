<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.cbf.db.PageController"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.cbf.web.util.PageSplittor"%>
<%
	    PageSplittor pSplittor = (PageSplittor) request.getAttribute(PageSplittor.PAGE_SESSION);
	  
	if (pSplittor != null) {
		PageController pageController = pSplittor.getPControler();

		int currentPage = pageController.getCurrentPage();
		int totalPages = pageController.getTotalPage();
		int totalNO = pageController.getTotalNo();
		String action = pSplittor.getAction();
		HashMap htMap = pSplittor.getHtMap();
		Iterator it = htMap.keySet().iterator();
%>

<script language="javascript">
    //查询
     function queryForm(){
         document.pageform.currentPage.value=1;
         document.getElementById("pageform").submit();
     }
		
		function modifyInfo(url){
			window.location.href=url+"&searchFlag=modify&currentPage=<%=currentPage%>";
		}
		
		
		function delRow(mark,url){
			if(mark==0){
				if(confirm("确定要删除吗？")){
					window.location.href=url+"&searchFlag=del&currentPage=<%=currentPage%>";
				}
			}if(mark==1){
				window.location.href=url+"&searchFlag=del&currentPage=<%=currentPage%>";
			}
			
		}
		function nextPage(){
			
		    document.pageform.currentPage.value = <%=currentPage%> + 1;    
		    window.document.pageform.submit();
		}
		function lastPage(){
		    document.pageform.currentPage.value = <%=currentPage%> - 1;
		    window.document.pageform.submit();
		}
		function goToPage(){
		    
		     var nr1=document.pageform.toPage.value; 
		    var flg=0; 
			for (var i=0;i<nr1.length;i++){ 
			 var cmp="0123456789" 
			 var tst=nr1.substring(i,i+1) 
			 if (cmp.indexOf(tst)<0){ 
			  flg++; 
			 } 
			}
			if (flg!=0){ 
			alert("这里只接受数字."); 
		    return false; 
		    } 
		    
		    if(nr1 < 1 || nr1 > <%=totalPages%>){
		        alert("没有此页数据");
		        return false;
		    }
		     document.pageform.currentPage.value = document.pageform.toPage.value;
		    window.document.pageform.submit();
		}
		function firstPage(){
			document.pageform.currentPage.value = 1;
		    window.document.pageform.submit();
		}
		function lastestPage(){
			document.pageform.currentPage.value = <%=totalPages%>;
		    window.document.pageform.submit();
		}
		function  textkeydownf(){
		   if(event.keyCode==13) 
		   {
		   document.getElementById("skip").click();
		    event.returnValue = false; 
		   }
		} 

		function chengeOver(param){
					param.style.color = "#cc7744";
				}
				function chengeOut(param){
					param.style.color = "";
				}
			</script>
<input type="hidden" name="currentPage" value="<%=currentPage%>">

<%
		String name = null;
		while (it.hasNext()) {
			name = (String) it.next();
%>
<input type="hidden" name="<%=name%>" value="<%=htMap.get("" + name)%>">
<%
}
%>    
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables btntable">
	<tr>
          <td width="50%" align="left" class="pagetextl fontstyle" >
                                 共<span id='spanTotal'><%=totalNO %></span>条信息｜ 当前第
			<strong><%=currentPage%> </strong> /
			<strong><%=totalPages==0 ? 1 : totalPages%> </strong> 页</td>
			<td width="50%" align="right"  class="pagetextl fontstyle">
			<%
			if (currentPage == 1) {
			%>
			首页
			<%
			} else {
			%>
			<a style="cursor: pointer;" name="selectName"  onclick="javascript:firstPage()" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)">首页</a>
			<%
			}
			%>		
			|			
			<%
			if (currentPage > 1) {
			%>
			<a style="cursor: pointer;" name="selectName"  onclick="javascript:lastPage()" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)">上一页</a>
			<%
			} else {
			%>
			上一页
			<%
			}
			%>
			|
			<%
			if (currentPage < totalPages) {
			%>
			<a style="cursor: pointer;" name="selectName" id="nextPage" onclick="javascript:nextPage()" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)">下一页</a>
			<%
			} else {
			%>
			下一页
			<%
			}
			%>		
			|
			<%
			if (totalPages==0||totalPages==currentPage) {
			%>
			尾页
			<%
			} else {
			%>
			<a style="cursor: pointer;" name="selectName"  onclick="javascript:lastestPage()" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)">尾页</a>|
			<%
			}
			%>
			跳转到第	
			<input  size="1" class="input20 fontstyle" name="toPage"
				value="<%=currentPage%>" onkeydown="textkeydownf()">	
			页&nbsp;&nbsp;&nbsp;<a id="skip" style="cursor: pointer;" onclick="javascript:goToPage()" onmouseover="chengeOver(this)" onmouseout="chengeOut(this)">跳转</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%--<input type="submit" name="button" id="button" value="go" style="cursor:pointer" onclick="goToPage()" class="cx_TextBtngo"/>--%>
		</td>
	</tr>
</table>	

<%
}else{
%>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables btntable">
	<tr>
        <td width="50%" height="28" class="pagetextl fontstyle" style="color:#085b8b;">
			共0条信息&nbsp;&nbsp;
			｜
			当前第<strong>0 </strong> /<strong>0 </strong> 页
			</td>
			<td width="50%"  valign="middle" class="pagetextl fontstyle" style="color:#085b8b;">	
			<img src="${swh_ctx }/images/paginationFooter/page2.gif" width="8" height="9" />	
			首页<img src="${swh_ctx }/images/paginationFooter/page3.gif" width="10" height="9" />	
			上一页<img src="${swh_ctx }/images/paginationFooter/page4.gif" width="10" height="9" />
			下一页<img src="${swh_ctx }/images/paginationFooter/page5.gif" width="8" height="9" />
			尾页<img src="${swh_ctx }/images/paginationFooter/page1.gif" width="2" height="9" />	 
			跳转到第	<input  size="1" class="input20 fontstyle">	
			页<img src="${swh_ctx }/images/paginationFooter/page6.gif" width="13" height="11" />	
    </td>
  </tr>
 </table>
<%
}
%>
     