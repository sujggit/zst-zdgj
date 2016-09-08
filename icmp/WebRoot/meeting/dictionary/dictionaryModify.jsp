<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp" %>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <title>添加数据字典</title>
  <script type="text/javascript">
		function backHistory(){
        	window.location.href="${sys_ctx}/dictionary/dictionaryList.action";
        }
		
		function pageInit(){
		    var obj = new htmlUtil();
			obj.title("dicViewName","输入长度不超过25个字符");		
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
    <form action="${sys_ctx }/dictionary/modifyDictionary.action" method="post" name="form" id="form">
      <input type="hidden" name="dictionaryVO.dicID" value="${dictionaryVO.dicID }"/>
      <div class="contenttitle2">
        <h5 class="fwb fl10">数据字典修改</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="25%" class="tableaddtitle"><span>*</span>数据类型</td>
          <td width="75%" class="tableadd_data">
          	<select name="dictionaryVO.dicType" id="dicType" title="请选择" style="cursor:pointer" >
				 <zzst:option type="dicType" value="${dictionaryVO.dicType}" required="false"/>
			 </select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>数据名称</td>
          <td class="tableadd_data" ><input id="dicViewName" type="text" class="inputtran" name="dictionaryVO.dicViewName" value="${dictionaryVO.dicViewName}"/></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>数值</td>
          <td class="tableadd_data" ><input id="dicValue" type="text" class="inputtran" name="dictionaryVO.dicValue" value="${dictionaryVO.dicValue}" /></td>
        </tr>
        <tr>  
          <td class="tableaddtitle"><span>*</span>描述</td>
          <td class="tableadd_data">
          	<input id="description" type="text" class="inputtran" name="dictionaryVO.description" value="${dictionaryVO.description}" />
          </td>
         </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>        
        <tbody>
          <tr>
            <td>
              <input type="button" class="submit1 radius2" value="确 定" onclick="add();"/>
              <input type="button" class="reset1 radius2" value="取 消" onclick="backHistory()"/>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>