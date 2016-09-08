<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>demo</title>
<%@include file="/common/common.jsp"%>
<script type="text/javascript">
  function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("mcuVO.mcuUserName","输入长度不超过25个字符");				 
			    obj.title("mcuVO.mcuIp","请输入正确的IP格式如：10.1.1.1");	
			    obj.title("mcuVO.mcuPsw","请输入您的密码");				
			}
			
			
			
			 function McuTemplateAdd(){
               
                   $('#pageform').validate({    
					rules:{   
					"mcuUserName" : {
					            required:true,
					                 },
					 "mcuIp" : {
					            minlength:1,
					           maxlength:25,
					           checkIP:true,
					               },
					             
					                 
				     "mcuPsw" : {
					            required:true,
					               },
					
					       }  
				                           });
				
                $('#pageform').submit();
                
             }
			

  

</script>
</head>

<body class="withvernav" onload="pageInit();">
  <form id="pageform" name="pageform" action="${sys_ctx}/baseInfo/getMCUTemplate.action"  method="post">
	<div id="basicform" class="contentwrapper">
        <div class="contenttitle2">
          <h5 class="fwb fl10">提取模板</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
          <tr>
            <td width="15%" class="tableaddtitle" >请输入MCU的IP</td>
            <td width="85%" class="tableadd_data" ><input id="mcuVO.mcuIp" name="mcuIp" type="text" class="inputtran" /></td>
          </tr>
          <tr>
            <td class="tableaddtitle" >请输入MCU的用户名</td>
            <td class="tableadd_data" ><input id="mcuVO.mcuUserName" name="mcuUserName" type="text" class="inputtran" /></td>
          </tr>
          <tr>
            <td class="tableaddtitle">请输入MCU的密码</td>
            <td class="tableadd_data" ><input id="mcuVO.mcuPsw" name="mcuPsw" type="text" class="inputtran" /></td>
          </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table2">
          <tfoot>
          </tfoot>
          <tbody>
            <tr>
              <td>
              	<input type="button" class="submit1 radius2" onclick="McuTemplateAdd();" value="提 交" />
                <input type="button"   value="重置"  class="reset1 radius2"/>
               </td>
            </tr>
          </tbody>
        </table>
         
        <!--contenttitle-->
      </div>
</form>
      <!--contenttitle--> 
    <!--contentwrapper--> 
	 <div id="info" >
	   <c:forEach var="tempProfile" items="${profileList}">  
	  		<p> mcu IP:${mcuIp }  <br></br>
	  		模板名称：${tempProfile.profileName}  <br></br>
	  		模板ID：${tempProfile.guid}
	  		</p>
	   </c:forEach>
    </div>
 
 </body>
 </html>