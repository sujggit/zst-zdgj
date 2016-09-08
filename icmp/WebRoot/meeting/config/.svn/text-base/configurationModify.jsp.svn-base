<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<%@include file="/common/common.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>添加告示</title>
<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/baseInfo/queryBaseInfoList.action";
            }

          /**
			*	输入提示
			*@return	null
			*/
            function pageInit(){
			   var obj = new htmlUtil();
			    obj.title("infoName","输入长度不超过25个字符");	
			    obj.title("infoValue","输入长度不超过500个数字");		
			    obj.title("infoType","请选择");	
			    obj.title("description","请输入详细描述");	
			    
			
			}

			/**
			*	修改事件，实现验证、友好提示功能
			*@return	null	
			*/
               function centerControlModify(){
               
                  $('#pageform').validate({    
					rules:{   
					"baseInfoVO.infoType" : {
					           required:true
					           },					     				 
					             "baseInfoVO.infoName" : {
					           required:true
					           },
					           
					   "baseInfoVO.infoValue" : {
					           required:true
					           },
					     "baseInfoVO.description" : {
					           required:true,
					          
					           },
					      
					       
					}  
				  });
				 
				  
                $('#pageform').submit();
             }
           	
           	
          
</script>
</head>

<body onload="pageInit()" STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
<form action="${sys_ctx }/baseInfo/configurationModify.action" id="pageform" name="pageform" method="post">
 <input name="baseInfoVO.id" type="hidden" id="baseInfoVO.id"  value="${baseInfoVO.id}"/>
<div class="centercontent tables">
    <!--pageheader-->
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
        <div class="contenttitle2">
          <h5 class="fwb fl10">配置修改</h5>
        </div>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
          <tr>
            <td width="15%" class="tableaddtitle"><span>*</span>类型配置</td>
            <td class="tableadd_data" > 
            <select onchange="listBaseInfo();" name="baseInfoVO.infoType" id="infoType" title="请选择"  class="select200 fontstyle" style="cursor:pointer" >
				            	   <zzst:option type="baseInfoType" value="${baseInfoVO.infoType}" required="false"/>
		 </select>
		 </td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span>*</span>配置名称</td>
            <td class="tableadd_data" ><input type="text" class="inputtran" name="baseInfoVO.infoName" id="infoName" value="${baseInfoVO.infoName}"  disabled="disabled"/></td>
          </tr>
          <tr>
            <td class="tableaddtitle"><span>*</span>配置内容</td>
            <td class="tableadd_data" ><input id="infoValue" type="text" name="baseInfoVO.infoValue" class="inputtran" value="${baseInfoVO.infoValue}" /></td>
          </tr>
          <tr>
            <td class="tableaddtitle" style="vertical-align:top;">描述</td>
            <td class="tableadd_data" ><textarea name="description" rows="5" name="baseInfoVO.description" class="areatran" id="description">${baseInfoVO.description}</textarea></td>
          </tr>
        </table>
        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
          <tfoot>
          </tfoot>
          <tbody>
            <tr>
              <td><input type="button" class="submit1 radius2" value="确 定" onclick="centerControlModify();" />             
                <input type="button" class="reset1 radius2" value="返回" onclick="backHistory();"/>
                </td>
            </tr>
          </tbody>
        </table>
        </div>
        </div>
        </form>
        </body>
        </html>