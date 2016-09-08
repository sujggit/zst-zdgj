<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type='text/javascript' src='${sys_ctx }/meeting/dictionary/js/dictionary.js'></script>
  <title>添加数据字典</title>
  <script type="text/javascript">
		function backHistory(){
        	window.location.href="${sys_ctx}/dictionary/dictionaryList.action";
        }
		
		function pageInit(){
		    var obj = new htmlUtil();
			obj.title("dicViewName","输入长度不超过25个字符");		
//			obj.title("dicType","请选择");	
			obj.title("dicValue","输入长度不超过25个字符");
			obj.title("description","输入长度不超过100个字符");
		}
		
		function add(){
			$('#form').validate({    
			rules:{ 
					"dictionaryVO.dicViewName":{
						required: true,
						minlength:1,
		           		maxlength:25
		           		},
		           	"dictionaryVO.dicValue":    {
						required: true,
						minlength:1,
		           		maxlength:25
		           		},
		           	"dictionaryVO.description":    {
						required: true,
						minlength:1,
		           		maxlength:100
		           		}
			  	}
			});
			$("#form").submit();
		}
  </script>
</head>
<body onload="pageInit();">
  <div id="basicform" class="contentwrapper">
    <form action="${sys_ctx }/dictionary/addDictionary.action" 	method="post" name="form" id="form">
      <div class="contenttitle2">
        <h5 class="fwb fl10">数据字典增加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd" id="query_tableOther">
        <tr>
          <td width="25%" class="tableaddtitle"><span>*</span>数据类型</td>
          <td width="75%" class="tableadd_data">
          	<select name="dictionaryVO.dicType" id="dicType" title="请选择" style="cursor:pointer" onchange="dictionaryView(this);">
				 <zzst:option type="dicType" value="${dictionaryVO.dicType}" required="true"/>
			 </select>
			 &nbsp;&nbsp;&nbsp;&nbsp;<font color="red"><span id="spanTitle"></span></font>
          </td>
        </tr>
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>数据名称</td>
          <td width="35%" class="tableadd_data" ><input id="dicViewName" class="inputtran" name="dictionaryVO.dicViewName" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>数值</td>
          <td class="tableadd_data" ><input id="dicValue" class="inputtran" name="dictionaryVO.dicValue" />&nbsp;&nbsp;<font color="red"><span id="spanValue"></span></font></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>描述</td>
          <td class="tableadd_data">
			<input id="description" class="inputtran" name="dictionaryVO.description" />
		  </td> 
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