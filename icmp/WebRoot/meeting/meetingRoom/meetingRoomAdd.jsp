<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>会议室增加 </title>
   <%@include file="/common/common.jsp"%>
   <script type='text/javascript' src='${sys_ctx }/system/portal/conference/js/conferenceSelect.js'></script>

   <script type='text/javascript' src='${sys_ctx }/system/portal/department/js/departmentSelect.js'></script>

   <script type='text/javascript' src='${sys_ctx }/system/portal/user/js/userSelect.js'></script>
    <link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css">
    
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
	<script language="JavaScript">
			 
		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClickSelect,
				onClick: onClickSelect
			}
		};
		<%
	 		
			 ArrayList list =  new AddressServiceImpl().query(null, null);
			     if(null!=list){
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
				      for(int i=0;i<list.size();i++){
				    	  AddressVO addressVO = (AddressVO)list.get(i);
				    	    dataObj.append("{id:'"+addressVO.getAddressID()+"',pId:'"+addressVO.getParentID()+"',name:\""+addressVO.getName()+"\"");
			               if(i<3)
				             dataObj.append(",open:true");
				             dataObj.append("}");
		                	
			                 if(i!=list.size()-1){
							      dataObj.append(",");			                	 
			                 }
				       }
				      dataObj.append("];");
				      out.print(dataObj);
		}     
		%>

		 
		function beforeClickSelect(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;
		}
		
		function onClickSelect(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("addressTree");
			nodes = zTree.getSelectedNodes();
			//v = "";
			//nodes.sort(function compare(a,b){return a.id-b.id;});
			//for (var i=0, l=nodes.length; i<l; i++) {
			//	v += nodes[i].id + ",";
			//}
			//if (v.length > 0 ) v = v.substring(0, v.length-1);
			var cityObj = $("#addressID");
			cityObj.attr("value", nodes[0].id);
			var cityObj2 = $("#name");
			cityObj2.attr("value", nodes[0].name);
		}

		function showMenu() {
			var cityObj = $("#name");
			var cityOffset = $("#name").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "name" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#addressTree"), setting, zNodes);
		});
			
			
				/**
			*	设置页面参数
			*@return	null	
			*/
           function pageInit(){
			    var obj = new htmlUtil();
				obj.title("meetingRoomName","不超过25个字符");	
				obj.title("roomNO","不超过25个字符");	
				obj.title("meetingRoomType","请选择");	
				obj.title("capacity","输入5000内的整数");	
				obj.title("name","输选择");	
				obj.title("title","请选择");	
				obj.title("names","请选择");	
				//obj.title("planeImg","请上传图片");	
				obj.title("status","请选择");
				obj.title("description","不超过500个字符");	
			}
			/**
			*	修改会议室
			*@return	null	
			*/
   			function  meetingRoomAdd(){
   			 
   			  $('#addForm').validate({    
					rules:{    
					   "meetingRoomVO.meetingRoomName" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
					     "meetingRoomVO.roomNO" : {
					           required:true,
					           minlength:1,
					           maxlength:25  
					           },
					    "meetingRoomVO.meetingroomType" : {
					           required:true
					        
					           },
					     "meetingRoomVO.capacity" : {
					           required:true,
					           digits:true,
					           range:[0,5000]
					           },
					       "meetingRoomVO.addressVO.name" : {
					           required:true
					           },
					       "meetingRoomVO.departmentVO.title" : {
					           required:true
					          },
					       "meetingRoomVO.userVO.name" : {
					           required:true
					           },
					       "meetingRoomVO.status" : {
					           required:true
					           },
					      "meetingRoomVO.description" : {
					           minlength:1,
					           maxlength:500  
					           }
					}
				  });
				  if($('#addForm').valid()){
                     $('#addForm').submit();
                     $("#button").attr("disabled",true);
                     }
           	}
            /**
			*	返回列表
			*@return	null
			*/
            function backHistory(){
            	window.location.href="${sys_ctx}/meetingRoom/query.action";
            }
             /**
			*	选择管理员
			*@return	null
			*/
              function check(id){
              $("#button").attr("disabled",true);
		  		var a=document.getElementById(id);	  
		  		if(a.value==""||a.value==null){
		  		$("#button").attr("disabled","");
					return;
				}
			    DwrMethod.checkMeetingRoomName(a.value,callback);
		}
	      
	           function callback(lst){
	    	if(lst.length > 0){
	    	alert("此会议室名称已被占用");
	    	document.getElementById("meetingRoomName").value="";  
	    	
	    	}			
	    	$("#button").attr("disabled","");
 		}

 		   function checkNO(op){
 			    $("#button").attr("disabled",true);
 			  if(op.value==""||op.value==null){
 			  $("#button").attr("disabled","");
 				return;
 			  }
 			  DwrMethod.checkMeetingRoomNO(op.value,function callbackNO(result){
					
						if(result){
							alert("会议室编号已被占用");
							op.value="";  
					   }
					   $("#button").attr("disabled","");
 	 			  });

 	 		}
	        /**
			*	选择所属部门
			*@return	null
			*/
	           function selectUsers(thisDom){
	              var userParameters = {
	                  methodName:'getReturnUserMethod',
	                  selectType:'radio'
	              }
	             creatUserSelect(thisDom,userParameters); 
	          }
	          /**
	          *上传图片
	          */
	    	  function getReturnUserMethod(userArray){
	              var userID="";
	              var loginName="";
	              var userLength = userArray.length;
	              for(var i=0;i<userLength;i++){
	            	  userID=userArray[i].userID;
	            	  loginName=userArray[i].userName;
	              }
	          	$("#userID").attr("value",userID);
               	$("#names").attr("value",loginName);
               
                
	         
	          }
	           function selectDepartments(thisDom){
	              
	              var departParameters = {
	                  methodName:'getReturnDepartMethod',
	                  selectType:'radio',
	                  extraDept:'false',
	                  middleSelect:'true'
	              }
	             creatDepartmentSelect(thisDom,departParameters); 
	          }
	           function getReturnDepartMethod(departArray){
	              var departmentID="";
	              var departmentName="";
	              var departLength = departArray.length;
	              for(var i=0;i<departLength;i++){
	            	  departmentID=departArray[i].departmentID;
	            	  departmentName=departArray[i].departmentName;
	              }
	              if(departmentID==''){
	              departmentID=0;
	              }
	          	$("#departmentId").attr("value",departmentID);
               	$("#title").attr("value",departmentName);
 	         
	          }
	           
	          /**
	          *上传图片
	          */
	    		function uploadFile(element){
	           	 var params = {
		          	methodName:'finish',
					excuteFileType:''
		         }
		         swhUploadFile(element,params); 
		    }
			 function   finish(retvalue){
	           		var processID 	=		retvalue[0] ;
				   	var result 		=		retvalue[1] ;
				   	var message 	=		retvalue[2] ;
					 if(result != "success"){
						alert("上传失败："+message);
						return ;
					}
					var fileCaption =		retvalue[3] ;
				   	var retFactName =		retvalue[4] ;
				   	var retFactPath =		retvalue[5] ;
					 
	                var realPath = retFactPath +"/"+ retFactName;
	                 alert(realPath+"//"+retFactName+"//"+retFactName+"//"+fileCaption);
				}
    	</script>
    	<style type="text/css">
	</style>
</head>
<body  onload="pageInit(); " style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
<div id="basicform" class="contentwrapper">
<form action="${sys_ctx}/meetingRoom/addSave.action" id="addForm" name="addForm" method="post">
<input name="meetingRoomVO.meetingRoomID" id="meetingRoomID" type="hidden" value="${meetingRoomVO.meetingRoomID}"/>
<div class="contenttitle2">
    <h5 class="fwb fl10">会议室增加</h5>
</div>
 <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle"><span>*</span>会议室名称</td>
          <td width="35%" class="tableadd_data" ><input type="text" title="请输入会议室名称" class="inputtran" name="meetingRoomVO.meetingRoomName" id="meetingRoomName"  onblur="javascript:check('meetingRoomName');"  /></td>
          <td width="15%" class="tableaddtitle"><span>*</span>会议室类型</td>
          <td width="35%" class="tableadd_data">
          <select class="" name="meetingRoomVO.meetingRoomType" id="meetingRoomType" >
				<zzst:option type="meetingRoomType" value="2" required="true"/>
			</select>
          </td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>网络拓扑</td>
          <td class="tableadd_data" >
          <input class="inputtran" onclick="showMenu();" id="name"  name="meetingRoomVO.addressVO.name" type="text" readonly value="" />
            <input class="inputtran" id="addressID"  name="meetingRoomVO.addressVO.addressID" type="hidden" value="" />
            <div id="menuContent" style=" background:#bbd6f3; width:200px; height:300px; float:left; overflow-x:hidden; overflow-y:scroll;
                 border:1px solid #2d96dc;display:none;position: absolute;">
	            <ul id="addressTree" class="ztree" style="margin-top:0; height:200px;width:160px;"></ul>
             </div>
          </td>
          <td class="tableaddtitle"><span>*</span>所属单位</td>
          <td class="tableadd_data">
            <input type="text" class="inputtran" name="meetingRoomVO.departmentVO.title" id="title" readonly="readonly"  onclick="selectDepartments(this);"/>
            <input type="hidden" class="inputtran" name="meetingRoomVO.departmentVO.id" id="departmentId"  value="" />
            <!--  <input type="text" class="inputtran" name="meetingRoomVO.departmentVO.title" id="title" readonly="readonly"  onclick="selectDepartments(this);"/>
            <input type="hidden" name="meetingRoomVO.departmentVO.id" id="departmentId" class="inputtran" value="" />--></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>状态</td>
          <td class="tableadd_data" ><select class="" name="meetingRoomVO.status" id="status" >
					<zzst:option type="meetingRoomStatus" value="" required="true"/>
				</select></td>
          <td class="tableaddtitle"><span>*</span>管理员</td>
          <td class="tableadd_data">
            
            <input type="text" class="inputtran" name="meetingRoomVO.userVO.name" id="names" readonly="readonly"  onclick="selectUsers(this);"/>
            <input type="hidden" name="meetingRoomVO.userVO.userID" id="userID" class="" value=""/></td>
        </tr>
        <tr>
          <td class="tableaddtitle"><span>*</span>容纳人数</td>
          <td class="tableadd_data" ><input class="inputtran" type="text" name="meetingRoomVO.capacity" id="capacity"  value="10"/></td>
          <td class="tableaddtitle"><span>*</span>会议室编号</td>
          <td class="tableadd_data"><input class="inputtran" type="text" name="meetingRoomVO.roomNO" id="roomNO" onblur="checkNO(this)" /></td>
        </tr>
        <tr>
          <td class="tableaddtitle">会议室描述</td>
          <td colspan="3" class="tableadd_data" ><textarea name="meetingRoomVO.description" rows="5" class="areatran" id="description"></textarea></td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td><input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="meetingRoomAdd();" id="button"/>
             
              <input type="button" class="reset1 radius2" value="取 消" onclick=" backHistory();"/>
              
              </td>
          </tr>
        </tbody>
      </table>
  </form>
 </div>
</body>
</html>