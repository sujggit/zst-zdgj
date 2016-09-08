<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
<title>维修信息添加 </title>
		<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null
			*/
            function closeWin(){
            	window.close();
            }

         
           function pageInit(){
			    var obj = new htmlUtil();
			    obj.title("equipmentNO","不可修改");	
			    obj.title("status","请选择");	
				obj.title("maintainCost","请输入整数数字");	
			    obj.title("updateTime","请选择");	
			    //obj.title("description","输入长度不超过500个字符");	
			}

			/**
			*	实现验证、友好提示功能
			*@return	null	
			*/
			
   	          function addF(){
                  $('#addForm').validate({    
					rules:{    
					    
					    
					       "equipmentMaintainVO.status" : {
					           required:true
					           },
					      
					        "equipmentMaintainVO.maintainCost" : {
					        	   digits: true
					           },
					        
					       "equipmentMaintainVO.updateTime" : {
							    required:true
					            
					           }
					           
					},    
					messages:{
					      status:{required: "必选"}
					}    
				  });
				  
				     if( document.getElementById("maintainCost").value == ""){
				    	 document.getElementById("maintainCost").value = 0;
				     }
                    var maintainCostvalue=document.getElementById("maintainCost").value;
                    if(parseInt(maintainCostvalue)==maintainCostvalue){
				     window.returnValue="1";
				     $('#addForm').submit();
				     window.close();	
				     }else{
				     alert('费用必须为整数');
				     }
             }

  			
  			
   	       function clearText( op){
					op.innerHTML="";
   	   	       }
           	
         

 		
    	</script>
    	
</head>

<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'   onload="pageInit();">
<form action="${sys_ctx}/equipment/equipmentMaintainAdd.action" id="addForm" name="addForm" method="post" target="hideFrame">
<input type="hidden" value="${equipmentVO.meetingRoomVO.meetingRoomID }" name="equipmentMaintainVO.roomID" />
<div class="contenttitle2">
        <h5 class="fwb fl10">维修信息添加</h5>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="30%" class="tableaddtitle"><span>*</span>设备名称</td>
          <td width="70%"  colspan="3" class="tableadd_data" >
            <input type="hidden" id="equipmentID" name="equipmentMaintainVO.equipmentID" value="${equipmentVO.equipmentID}"/>
			<input type="text"  id="equipmentNO" class="inputtran" value="${equipmentVO.equipmentNO}" readonly/>                            
		  </td>
		</tr>
		<tr>
          <td width="30%" class="tableaddtitle"><span>*</span>状态</td>
          <td width="70%" colspan="3" class="tableadd_data">
          	<select id="status" name="equipmentMaintainVO.status" class="inputtran">
          		<zzst:option type="equipmentStatus" value="${equipmentVO.status}"></zzst:option>
          	</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">费用(元)</td>
          <td colspan="3" class="tableadd_data" >
          	<input type="text"  id="maintainCost"  name="equipmentMaintainVO.maintainCost" class="inputtran" value="" />                            
		  </td>
	    </tr>
	    <tr>
          <td class="tableaddtitle"><span>*</span>填写时间</td>
          <td colspan="3" class="tableadd_data">
          	<input name="equipmentMaintainVO.updateTime" class="inputtran"  id="updateTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" 
          	value="<fmt:formatDate value='${equipmentMaintainVO.updateTime}' pattern='yyyy-MM-dd HH:mm'/>"
             />
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle">描述</td>
          <td colspan="3" class="tableadd_data" >
          
          <textarea name="equipmentMaintainVO.description"  class="areatran" id="description" style="width:100%" rows="10" onfocus="clearText(this)"></textarea>
          </td>
        </tr>
      </table>
      <iframe id="hideFrame" name="hideFrame" style="display: none;"></iframe>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td>
            
            <input type="button" name="button" id="button" class="submit1 radius2" value="确 定" onclick="addF();"/>
              
              <input type="button"name="button2" id="button2"  class="reset1 radius2" value="取 消" onclick="closeWin();"/>
              </td>
          </tr>
        </tbody>
      </table>
  </form>
</body>

</html>