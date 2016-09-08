<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>通知内容配置</title>

		<script type="text/javascript">
           
             function noticeAdd(){
              
				  var array = new Array();
				 
				  var infos = document.getElementsByName("ids");
				  for(var i=0;i<infos.length;i++){
				   var array1 = new Array();
				  	array1[0] = infos[i].value;
				  	var content = document.getElementById(infos[i].value).value;
				  	array1[1] = content;
				  	array.push(array1);
				  }
               DwrMethod.modifyNoticeContent(array,callback);
               }
             
           	function callback(data){
           		if(data){
           			alert("配置成功！");
           		}else{
           			alert("配置失败！");
           		}
           	}
           
           
            function backHistory(){
            	window.location.href="${sys_ctx}/baseInfo/beforeNoticeConfig.action";
            }
 		
 		
    	</script>
</head>

<body STYLE='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN' >

<form action="${sys_ctx}/baseInfo/beforeNoticeConfig.action" id="emailForm" name="emailForm" method="post">
 <div id="basicform" class="contentwrapper">
<div class="contenttitle2">
        <h5 class="fwb fl10">通知内容配置</h5>
      </div>
     
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
      <c:forEach items="${baseInfoList}" var="noticeContent">
        <tr>
          <td class="tableaddtitle"><span></span>${noticeContent.description }</td>
          <td class="tableadd_data" >
         
           <textarea class="areatran"  id="${noticeContent.id }" maxlength="50" cols="100" onKeyDown='if (this.value.length>=50&&event.keyCode!=8){event.returnValue=false}'><c:out value="${noticeContent.infoValue}"></c:out></textarea>
           <input type="hidden" value="${noticeContent.id }" name="ids"/>
          </td>
        </tr>
        </c:forEach>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr class="gradeA">
          <td class="tableaddtitle">
             <h5 class="fwb fl10" style="color:red">邮件格式说明："##1表示会议名称，##2和##3表示开始和结束时间，##4表示会议室名称，</br>##5表示设备名称，##6表示调试时间，内容长度不能超过50个汉字"</h5>
          </td>
          </tr>
          <tr>
            <td align="right"><input type="button" class="submit1 radius2" value="确 定" name="button" id="button" onclick="noticeAdd()"/>
            
              <input type="reset" class="reset1 radius2" value="取 消" onclick="backHistory();"/>
             
             
              </td>
          </tr>
        </tbody>
      </table>
      </div>
  </form>
</body>

</html>