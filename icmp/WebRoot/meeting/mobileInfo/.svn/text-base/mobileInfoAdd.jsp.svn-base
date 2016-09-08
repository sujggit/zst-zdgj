<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type='text/javascript' src='${sys_ctx }/meeting/dictionary/js/dictionary.js'></script>
  <title>添加联系人</title>
  <script type="text/javascript">
		function backHistory(){
        	window.location.href="${sys_ctx}/mobileInfo/querymobileInfo.action";
        }
		
		function pageInit(){
		    var obj = new htmlUtil();
			obj.title("myname","请输入名字，长度不超过50个字符");		
			obj.title("mymobile","请输入正确的手机号码");
		}
		
		function add(){
			$('#form').validate({    
			rules:{ 
					"mobileInfoVO.name":{
						required: true,
						minlength:1,
		           		maxlength:50
		           		},
		           	"mobileInfoVO.mobile":    {
						required: true,
						max:19999999999,
						min:10000000000
		           		},
			  	}
			});
			$("#form").submit();
		}
  </script>
</head>
<body onload="pageInit();">
  <div id="basicform" class="contentwrapper">
    <form action="${sys_ctx }/mobileInfo/addMobileInfo.action" 	method="post" name="form" id="form">
      <div class="contenttitle2">
        <h5 class="fwb fl10">联系人增加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="query_tableOther">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>姓名</td>
          <td width="35%" class="tableadd_data" ><input id="myname" class="inputtran" name="mobileInfoVO.name" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>电话</td>
          <td class="tableadd_data" ><input id="mymobile" class="inputtran" name="mobileInfoVO.mobile" /></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2 submitBtn_Disa" value="保 存" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>