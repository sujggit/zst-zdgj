<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.meetingRoom.MeetingRoomVO"  %>
<%@ page import="com.zzst.action.meeting.meetingRoom.MeetingRoomAction"%>
<%@ page import="com.zzst.model.meeting.address.AddressVO"%>
<%@ page import="com.zzst.meeting.dwr.DwrMethod"%>
<%@ page import="com.zzst.model.meeting.centerControl.CenterControlVO"  %>
<%@page import="com.zzst.model.enums.CenterControlEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<%@include file="/common/common.jsp"%>
	<title>会场控制</title>
	<link rel="stylesheet" href="${sys_ctx }/plug-in/jquery-ztree-v3.0/css/zTreeStyle/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.core-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.excheck-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/plug-in/jquery-ztree-v3.0/js/jquery.ztree.exedit-3.0.js"></script>
	<script type="text/javascript" src="${sys_ctx }/dwr/interface/DwrMethod.js"> </script>
	<script type="text/javascript">
		 <%
			 /**浏览器缓存问题add by xiongshun 20130305 15:00
	     	*/
	     	response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store"); 
	     	response.setDateHeader("Expires",0);
	     	response.setHeader("Pragma","no-cache");
			 MeetingRoomAction dptAction = new MeetingRoomAction();
			 ArrayList listDpt = dptAction.getRoomAdressList();
			 DwrMethod dwrMethod = new DwrMethod();
			     if(null!=listDpt){
			          StringBuffer dataWH = new StringBuffer();
			          dataWH.append("var dataWH = new Array();");
			          //构造树数据
			          StringBuffer dataObj = new StringBuffer();
			          dataObj.append("var zNodes = [");
			          int m = 0;
			          int n = 0;
			          int deptLength = listDpt.size();
				      for(int i=0;i<deptLength;i++){
				         AddressVO dpvo = (AddressVO)listDpt.get(i);
				        // UserAction  userAction = new UserAction();
				         String departID = dpvo.getAddressID();
				         String departName = dpvo.getName();
				         ArrayList lst_user = dptAction.getMeetingRoomWithCenterControl(departID);
				         if(null!=lst_user&&lst_user.size()>0){
				            int length = lst_user.size();
				            for(int j=0;j<length;j++){
				                 MeetingRoomVO userVO = (MeetingRoomVO)lst_user.get(j);
				                 ArrayList alist = dwrMethod.getCenterControlEquipments(userVO.getMeetingRoomID());
				                 
				                 if(alist!=null&&alist.size()>0){
				                	 /**如果当前节点下没有会议室则树结构直接不显示出来，以免客户进行无用的操作
							            */
							         if(!(dataObj.toString().contains(departID))){
								    	dataObj.append("{id:'"+departID+"',pId:'"+dpvo.getParentID()+"',name:\""+dpvo.getName()+"\",fullName:\""+dpvo.getName()+"\",open:true,isParent:true},");
							         	m++;
							         }
							         CenterControlVO ccVO = (CenterControlVO)alist.get(0);
							         String status = "";
							         String ccStatus = dwrMethod.getccStatus(ccVO.getCcIP());
							         if(ccStatus==null||ccStatus=="1"||ccStatus=="-1"){
							        	 status += "状态未知";
							        	 dataObj.append("{id:'"+userVO.getMeetingRoomID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"\",fullName:\""+userVO.getMeetingRoomName()+"("+status+")"+"\",icon:\"/icmp/meeting/equipmentControl/images/connected2.png\",isParent:false},");//disconnected2.png
							         }else{
							        	 status += "已连接";
							        	 dataObj.append("{id:'"+userVO.getMeetingRoomID()+"',pId:'"+departID+"',name:\""+userVO.getMeetingRoomName()+"\",fullName:\""+userVO.getMeetingRoomName()+"("+status+")"+"\",icon:\"/icmp/meeting/equipmentControl/images/connected2.png\",isParent:false},");
							         }
							         //System.out.println("ccIp====================="+ccVO.getCcIP()+"======="+dwrMethod.getccStatus(ccVO.getCcIP()));
							         //System.out.println("ccIp====================="+ccStatus+"=======");
					                 
					                 String newObj = "{"+
							          "conferenceID:'"+userVO.getMeetingRoomID()+"',"+
							          "conferenceName:'"+userVO.getMeetingRoomName()+"'"+
							         "};";               
					                 dataWH.append("dataWH['"+userVO.getMeetingRoomID()+"'] = "+newObj+";");
					                 m++;
					                 n = m;
					         	};
				             }
				         }
			         }
					  String data = dataObj.substring(0,dataObj.length()-1);
					  data += "];";
				      dataObj.append("];");
				      String str222 = "var defalutTree = ";
				      str222 += n;
				      str222 += ";";
				      //System.out.println(data);
				      out.println(str222);
				      out.println(dataWH);
				      out.println(data);//向jsp页面写入页面
			     }
		%>
		var setting = {
			view: {
				selectedMulti: false,
				showTitle: true
			},
			edit: {
				enable: false
			},
			data: {
				key: {
					title: "fullName"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
			  onClick:getInfo
			}
		};
		
		$(document).ready(function createTree() {
			$.fn.zTree.init($("#treeObject"), setting, zNodes);
			$("#iframe_I2").hide();
			startCenter();
		})
   		/*
		===========================================
		//去除前后空格
		===========================================
		*/
		String.prototype.Trim = function(){
			return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		var powerStatus = "";
		function getInfo(event,treeId,treeNode){//树的回调函数
			//alert(treeNode.id);
			DwrMethod.getCenterControlEquipments(treeNode.id,getInfoCallback);
		}
		function getInfoCallback(list){
			powerStatus = "";
			if(list.length>0){
				$("#m ul").empty();
				$("#iframe_I2").removeAttr("src");//点击treeNode时，首先清除iframe的内容，否则在点击时会有些许问题
				for(var i=0;i<list.length;i++){
					var ccIp = list[i].ccIP.Trim();
					var equipmentType = list[i].equipmentType.Trim();
					var equipmentName = list[i].equipmentName.Trim();
					if(equipmentType=="screent_view"){
						continue;
					}
					if(equipmentType == "<%=CenterControlEnum.type_screent_id%>"){
						powerStatus += equipmentType;
						powerStatus += ",";
					}
					if(equipmentType == "<%=CenterControlEnum.type_sysPower_id%>"){
						powerStatus += equipmentType;
						powerStatus += ",";
						continue;
					}
					var funURL = "<li onclick='redirect(\""+list[i].equipmentType.Trim()+"\",\""+list[i].ccIP.Trim()+"\")'><a target='I2'>"+equipmentName+"</a></li>";
					$("#m ul").append(funURL);
					//$("#m ul").append("<li id='m"+i+"' onmousedown=\"menu(\'"+list[i].equipmentType+"\')\">"+list[i].equipmentName+"</li>");
				}
				if(powerStatus){
					var funURL = "<li onclick='redirect(\"<%=CenterControlEnum.type_sysPower_id%>\",\""+list[0].ccIP.Trim()+"\")'><a target='I2'>电源状态</a></li>";
					$("#m ul").append(funURL);
				}
			}
			else{
				alert("请选择具体的会议室！");
			}
			setTimeout(function(){
				if(list.length>0){
					redirect(list[0].equipmentType.Trim(),list[0].ccIP.Trim());
					$("#m ul li").removeClass("kk");
					$("#m ul li").first().addClass("kk");
				}
			},100);
			//setTimeout("redirect('audio','10.191.180.231')",200);默认显示第一组控制功能
			
			$("#m ul li").click(function(){//点击变色功能
				$("#m ul li").removeClass("kk");
				$(this).addClass("kk"); 
			})
		}
		function redirect(equipmentType,ccIp){
			var URL =["${sys_ctx}/equipmentControl/audioControlBefore.action?equipmentVO.ip="+ccIp//音频扩声audio
		              ,"${sys_ctx}/equipmentControl/cameraBefore.action?equipmentVO.ip="+ccIp//摄像头控制camera
		              ,"${sys_ctx}/equipmentControl/getLightControl.action?equipmentVO.ip="+ccIp//灯光控制light
		              ,"${sys_ctx}/equipmentControl/matrixBefore.action?equipmentVO.ip="+ccIp//矩阵切换matrix
		              ,"${sys_ctx}/equipmentControl/getPlasmaTV.action?equipmentVO.ip="+ccIp//等离子控制pla
		              ,"${sys_ctx}/equipmentControl/getProjector.action?equipmentVO.ip="+ccIp//投影仪控制proj
		              ,"${sys_ctx}/equipmentControl/fixedTimeBeforeNew.action?equipmentVO.ip="+ccIp+"&powerStatus="+powerStatus//系统电源sysPower
		              ,"${sys_ctx}/equipmentControl/getLiftingScreen.action?equipmentVO.ip="+ccIp//升降屏控制upDownScreen
		              ,"${sys_ctx}/equipmentControl/centerControlBefore.action?equipmentVO.ip="+ccIp//中控状态vedioTerminal原型无
		              ,"${sys_ctx}/meeting/equipmentControl/dvdControl.jsp?ccip="+ccIp//DVD控制"dvd"
		              ,"${sys_ctx}/equipmentControl/bigscreenMonitorBefore.action?equipmentVO.ip="+ccIp//大屏监控screent原型无
		              ,"${sys_ctx}/equipmentControl/bigscreenPowerBefore.action?equipmentVO.ip="+ccIp//大屏电源screent
		              ,"${sys_ctx}/equipmentControl/curtainControlBefore.action?equipmentVO.ip="+ccIp//窗帘curtain
		              ,"${sys_ctx}/equipmentControl/getVideom.action?equipmentVO.ip="+ccIp//画面分割器控制videom
		              ,"${sys_ctx}/equipmentControl/roomModelControlBefore.action?equipmentVO.ip="+ccIp//会议组合键控制roomModel
		              ];
			$("#iframe_I2").removeAttr("src");
			if(equipmentType == "audio"){
				$("#iframe_I2").attr("src",URL[0]);
			}else if(equipmentType == "camera"){
				$("#iframe_I2").attr("src",URL[1]);
			}else if(equipmentType == "light"){
				$("#iframe_I2").attr("src",URL[2]);
			}else if(equipmentType == "matrix"){
				$("#iframe_I2").attr("src",URL[3]);
			}else if(equipmentType == "pla"){
				$("#iframe_I2").attr("src",URL[4]);
			}else if(equipmentType == "proj"){
				$("#iframe_I2").attr("src",URL[5]);
			}else if(equipmentType == "sysPower"){
				$("#iframe_I2").attr("src",URL[6]);
			}else if(equipmentType == "upDownScreen"){
				$("#iframe_I2").attr("src",URL[7]);
			}else if(equipmentType == "dvd"){
				$("#iframe_I2").attr("src",URL[9]);
			}else if(equipmentType == "curtain"){
				$("#iframe_I2").attr("src",URL[12]);
			}else if(equipmentType == "videom"){
				$("#iframe_I2").attr("src",URL[13]);
			}else if(equipmentType == "roomModel"){
				$("#iframe_I2").attr("src",URL[14]);
			}else if(equipmentType == "screent"){
				$("#iframe_I2").attr("src",URL[11]);
			}
		}
		/**
		如果没有中控下带有可控设备则不触发默认点击事件
		*/
		if(defalutTree>0){
			var defalutTreeId = "treeObject_2";//"treeObject_"+defalutTree;
			defalutTreeId += "_a";
			$(document).ready(function(){$("#"+defalutTreeId).trigger("click")});
		}
		
		
		function startCenter(){
			DwrMethod.startCenter(function callback(flag){
				if(flag){
					//alert("操作成功");
					document.getElementById("stopCenter").disabled=false;
					document.getElementById("startCenter").disabled=true;
					$("#iframe_I2").show();
					setTimeout("temp()",1000)//保证页面已经显示出来然后再绑定时间
					//$("#m ul li").bind("onclick");
				}else{
					alert("操作失败");
				}
			});
		}
		function temp(){
			$("#m ul li").bind("onclick");
		}
		function stopCenter(){
			//DWREngine.setAsync(false);
			DwrMethod.stopCenter(function callback(flag){
				if(flag){
					alert("操作成功");
					document.getElementById("stopCenter").disabled=true;
					document.getElementById("startCenter").disabled=false;
					$("#m ul li").unbind("onclick");
					$("#iframe_I2").hide();
				}else{
					alert("操作失败");
				}
			});
		}
	</script>
  </head>
  <body><!--  onunload="stopCenter();" -->
	<div class="Conference_Management" style="border: 0px solid red;height: 99.9%; overflow-x:auto">
       	 <input id="startCenter" type="hidden" value="开启中控检测" style="float:left;margin-left:10px;margin-top:10px;font-size:12px;" onclick="startCenter();" 
       	<%
       		if(DwrMethod.numberCenStatus==1){//判断系统是否开启中控检测线程
       	%>	
       		disabled="disabled"/>
       	<%
       		}else{
       	%>
       		/>
       	<%
       		}
       	%>
       	<input id="stopCenter" type="hidden" value="关闭中控检测" style="float:left;;margin-left:15px;margin-top:10px;font-size:12px;" onclick="stopCenter();" 
       		<%
       		if(DwrMethod.numberCenStatus==0||DwrMethod.numberCenStatus==2){
       	%>	
       		disabled="disabled"/>
       	<%
       		}else{
       	%>
       		/>
       	<%
       		}
       	%> 
	    <div class="dtree" bgcolor="#cccccc" style="padding-top:35px;">
	    
	        <!-- <p style="border-bottom:1px solid #ccc; color: #292421; font-family: 'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold;padding-left: 12px">请选择会场</p> -->
	            <div >
				 <ul id="treeObject" class="ztree"></ul>
				</div>
	    </div>
	</div>
    <!--leftmenu-->
 	<div class="centercontent tables list">
	    <table width="100%" cellspacing="0" cellpadding="0">
		  <tr>
	        <th scope="col">
	        	<div id="m">
					<ul>
						<li style="cursor: help;">首先在会议室下添加智能中控</li>
			            <li style="cursor: help;">然后在智能中控下添加相关设备</li> 
			            <!--  <li><a target="I2" class="kk">矩阵切换</a></li> 
			            <li><a target="I2">摄像头</a></li> 
			            <li><a target="I2">音频</a></li> -->
			        </ul>
	    		</div>
	        </th>
		  </tr>
		  <tr>
		    <td><iframe name="I2" id="iframe_I2" width="100%" border="0" frameborder="0" scrolling="yes" style="min-height:442px; display:block;"></iframe></td>
		  </tr>
		</table>
	</div>
  </body>
</html>