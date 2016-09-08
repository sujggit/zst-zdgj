<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
    <title>终端备份配置</title>
  </head>
  <body>
    <form id="form1" name="form1" action="" method="post">
        <div id="basicform" class="contentwrapper">
    	  <div class="contenttitle2">
        	<h5 class="fwb fl10">终端备份配置</h5>
      	  </div>
		  <div align="center" class="bllr" >		
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
			  <tr>
				<td align="center">
				  <table border="0" cellspacing="1" cellpadding="0" class="table_css_lx" >
				    <tr id="dp2">
					  <th width="45%" style="text-align:left;" >终端列表</th>
					    <td width="100" rowspan="2" align="center">
					       <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align:center; height:200px;">
				            <tr>
				              <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="moveAllOptions(document.form1.form1leftsel,document.form1.form1rightsel)"/></td>
				            </tr>
				            <tr>
				              <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)" /></td>
				            </tr>
				            <tr>
				              <td><input type="button" class="stdbtn mlr10" value="&lt;删除"  onclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)" /></td>
				            </tr>
				            <tr>
				              <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="moveAllOptions(document.form1.form1rightsel,document.form1.form1leftsel)" /></td>
				            </tr>
				          </table>
					    </td>
						<th width="45%" style="text-align:left;">主终端 </th>
					  </tr>
				  	  <tr>
						<td>
						  <div class="input_txt" style="width:100%; height:300px;  overflow: hidden;border:1px solid #666666;" >
							<select  id="form1leftsel" style="width:100%;  height: 300px;"  multiple="multiple" ondblclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)">
								<c:forEach items="${equipmentVOList}" var="equipmentVO" varStatus="state">                       	
                                      <option value="${equipmentVO.equipmentID}">${equipmentVO.equipmentNO}(${equipmentVO.meetingRoomVO.meetingRoomName})</option>
                                      </c:forEach>
    						</select>
						  </div>
						</td>
						<td align="center">
							<div class="input_txt"  style="width:100%; height:300px;  overflow: auto;border:1px solid #666666;" >
								<select name="equipmentBackupVO" id="form1rightsel" style="width:100%;  height: 300px;" multiple="multiple"  ondblclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)">
									<zzst:option type="equipmentName" value="" />
   								</select>
							</div>
						</td>
					  </tr>
					  <input type="hidden"  id="InUseEquipmentID" name="InUseEquipmentID" value=""/>
					</table>						
				  </td>								
			    </tr>																		
		      </table>
		    </div>
		    <div align="center">
		      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
				  <tr>
					<td width="15%" class="tableaddtitle">备份终端</td>
					<td class="tableadd_data" >
					  <select name="equipmentbackupIDs"  class="select200 fontstyle" >
					    <option value="" selected="selected">请选择……</option>
					    <c:forEach items="${equipmentVOList}" var="equipmentVO" varStatus="state">                       	
                           <option value="${equipmentVO.equipmentID}">${equipmentVO.equipmentNO}(${equipmentVO.meetingRoomVO.meetingRoomName})</option>
                           </c:forEach>
                         </select>
					</td>
				</tr>
			  </table>
			</div>					
            <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
              <tfoot></tfoot>
              <tbody>
                  <tr>
                      <td>
                          <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="saveterminal(document.form1)"/>
                          <input type="button" class="reset1 radius2" value="返回" onclick="goBackAdd();"/>
                      </td>
                  </tr>
              </tbody>
           </table> 
         </div>
      </form>
      <script type="text/javascript">  
	      function saveterminal(formobj){
	        var inuser= document.getElementsByName("equipmentbackupIDs");	
			for(var k=0;k<inuser.length;k++){
			  var obj = document.getElementById(formobj.id + "rightsel");}
			  for(var j=0;j<obj.options.length;j++){
				if(obj.options[j].value==inuser[0].value){
				alert("对不起，自己不能被自己备份");
				return;
				}			
			}
	     		
			var rightsltobj = document.getElementById(formobj.id + "rightsel");
			
			if(rightsltobj.options.length==0||rightsltobj==null){
			  alert("请选择主终端");
			  return ;
			}
			if(inuser[0].value==null||inuser[0].value==""){
			  alert("请选者终端备份");
			  return ;
			}
			//alert(rightsltobj.id);
			//var form1 = document.getElementById(formobj.id);
			var rightsltids = "";
		
			for(var i=0;i<rightsltobj.options.length;i++){
				rightsltids += ","+rightsltobj.options[i].value;
			}
			rightsltids = rightsltids.substring(1);
			//alert(rightsltids);
		
			//alert(rightsltids + "===" + rightsltnames);
			formobj.action = "/icmp/equipmentBackup/addTerminalBackup.action";
			document.getElementById("InUseEquipmentID").value=rightsltids;
			formobj.submit();
		}	
	     
	     /**
		 add by tanzanlong
		 *(按住shift或ctrl可以多选;select option操作)
		 *选定一项或多项然后点击添加或移除
		 *或在选择项上双击进行添加和移除
		 *e1点击的select对象 e2被添加的select对象
		*/
		function moveOption(e1, e2){
			if(e1==null)return;
			if(e2==null)return;
			for(var i=0;i<e1.options.length;i++){
			    if(e1.options[i].selected){
			        var e = e1.options[i];
			        if(this.isExist(e2, e.text, e.value)==true){
			        }else{
			        	e2.options.add(new Option(e.text, e.value));
			        }
			        e1.remove(i);
			        i=i-1;
			    }
			}
			/**
			var num = 0;
			if( e2.id == e2.form.id + "rightsel"){
				num = e2.options.length;
			}else if( e2.id == e2.form.id + "leftsel"){
				num = e1.options.length;
			}
			//$("#numberID").html(num);
			document.getElementById(e1.form.id + "numberID").innerHTML=num;
			*/
		}
	
		/**
		*add by tanzanlong
		*添加全部选项到右侧下拉列表
		**/
		function moveAllOptions(e1,e2){
			if(e1==null)return;
			if(e2==null)return;
			for(var i=0;i<e1.options.length;i++){
		        var e = e1.options[i];
		        if(this.isExist(e2, e.text, e.value)==true){
		        }else{
		        	e2.options.add(new Option(e.text, e.value));
		        }
		        e1.remove(i);
		        i=i-1;
		    }
		    /**
			var num = 0;
			if( e2.id == e2.form.id + "rightsel"){
				num = e2.options.length;
			}else if( e2.id == e2.form.id + "leftsel"){
				num = e1.options.length;
			}
			//$("#numberID").html(num);
			document.getElementById(e1.form.id + "numberID").innerHTML=num;
			*/
		}
		
		function isExist(e2,text,value){
			for(var i=0;i<e2.options.length;i++){
				if(e2.options[i].value == value||(e2.options[i].text==text))return true;
			}
			return false;
		}
		/**初始化选择项个数
		function num(formobj){
			var num = document.getElementById(formobj.id + "rightsel").options.length;
			//alert(num);
			document.getElementById(formobj.id + "numberID").innerHTML=num;
		}
		*/
		
		function goBackAdd(){
			window.location.href="/icmp/equipmentBackup/terminalBackupquery.action";
		}
	</script>
  </body>
</html>