<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>查看公告</title>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="" method="post" name="form" id="form" enctype="multipart/form-data" target="">
		<input type="hidden" name="messageContent.id" id="res" value="${messageContent.id }" />
	    <div id="basicform" class="contentwrapper">
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">查看公告</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
	          <td width="25%" class="tableaddtitle">公告标题</td>
	          <td width="75%" class="tableadd_data" title="${messageContent.messageSubject }">
	           ${messageContent.messageSubject }
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">发布人</td>
	          <td class="tableadd_data">
		          ${messageContent.flowIdCont }
	          </td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">发布时间</td>
	          <td class="tableadd_data"><fmt:formatDate value='${messageContent.insertTime }'  pattern='yyyy-MM-dd'/></td>
	        </tr>
	        <tr>
	          <td class="tableaddtitle">公告内容</td>
	          <td class="tableadd_data" title="${messageContent.messageBody }">
	          	${messageContent.messageBody }
			  </td>
	        </tr>
	       </table>
	       <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		              	<input class="submit1 radius2" type="button" name="button2" id="button2" value="关闭"  onclick="javascript:window.close();"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
		<input type="hidden" name="messageContent.ifSuccess" id="ifSuccessID"/>
	</form>
  </body>
</html>
