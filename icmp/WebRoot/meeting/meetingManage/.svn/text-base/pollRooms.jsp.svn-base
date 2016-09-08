<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common_header.jsp" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>定制轮询</title>
		<link href="${sys_ctx }/style/css.css" type="text/css" rel="stylesheet">
		<link href="/icmp/style/blue/selectRoom/contact.css" rel="stylesheet" type="text/css"/>
		<link href="/icmp/style/blue/selectRoom/content.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" type="text/css" href="/icmp/style/blue/layout.css" />
		<link rel="stylesheet" type="text/css" href="/icmp/style/blue/font.css" />
		<link rel="stylesheet" type="text/css" href="/icmp/style/blue/global.css" />
		<link rel="stylesheet" type="text/css" href="/icmp/style/blue/reset.css" />
		<script type="text/javascript" src="${sys_ctx }/js1/Common.js"></script>
		<script src="${sys_ctx }/js1/jquery-1.3.2.min.js" type="text/javascript"></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/engine.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/util.js'> </script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
	
	
	<script type="text/javascript">
		<!--
			function selectRooms(fromID, toID, numberID){
		 		var fromUsers = document.getElementById(fromID);
		 		var toUsers = document.getElementById(toID);
		 		for(var i=0; i < toUsers.length; i++){
			 		if(toUsers.options[i].text == ""){
			 			toUsers.remove(i);	
			 		}
		 		}
		 		
		 		for(var j=0; j < fromUsers.length; j++){
		 			if(fromUsers.options[j].selected){
		 				insertOption(toID, fromUsers.options[j].text, fromUsers.options[j].value);
		 			}
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function selectAllRooms(fromID, toID, numberID){
		 		var fromUsers = document.getElementById(fromID);
		 		var toUsers = document.getElementById(toID);
		 		for(var i=0; i < toUsers.length; i++){
			 		if(toUsers.options[i].text == ""){
			 			toUsers.remove(i);	
			 		}
		 		}
		 		
		 		for(var i=0; i < fromUsers.length; i++){
		 			insertOption(toID, fromUsers.options[i].text, fromUsers.options[i].value);
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function insertOption(toID, name, value){
		 		var o = document.createElement('option');
		 		o.text = name;
		 		o.value= value;
	
		 		var toUsers = document.getElementById(toID);	
		 		for(var i=0; i < toUsers.length; i++){
		 			if(toUsers.options[i].text == o.text && toUsers.options[i].value == o.value){
				 		return;
		 			}
		 		}
		 		
		 		try{
		 			toUsers.add(o, null);
		 		}
		 		catch(ex){
		 			toUsers.add(o);
		 		}
		 	}
		 	
		 
		 	function removeAllOptions(toID, numberID){
		 		var toUsers = document.getElementById(toID);	
				for(var i=toUsers.length - 1; i >= 0; i--){
		 			if(toUsers.options[i].selected == true){
		 				toUsers.options[i] = null;
		 			}
		 		}
		 		
		 		document.getElementById(numberID).innerHTML = toUsers.length;
		 	}
		 	
		 	function operateRooms(selectedRoomIDs){
		 		if('${param.op}' == 'polling'){
		 			alert("polling");
		 			pollRooms(selectedRoomIDs);
		 		}else{
		 			if('${param.op}' == 'add'){
		 			alert("add");
			 			addRooms(selectedRoomIDs);	 				
		 			}
		 		}
		 	}
		 	
		 	/**
		 	* poll rooms
		 	*/
		 	function pollRooms(selectedRoomIDs, intervalTime){
		 		var roomIDs = document.getElementById(selectedRoomIDs);
		 		var isAvailable = checkSelectedNumber(roomIDs);
		 		if(!isAvailable){
		 			return;
		 		}
		 		
		 		var finalRoomIDs = "";
		 		for(var i=0; i < roomIDs.length; i++){
		 			if(finalRoomIDs != ""){
		 				finalRoomIDs += "-";
		 			}
		 			finalRoomIDs += roomIDs.options[i].value;
		 		}
		 		
		 		var interval = getInterval(intervalTime);
		 		McuDwrMethod.pollParticipants('${chooseMeetingNumber}', finalRoomIDs, interval, pollingCallBack);
		 	}
		 	
		 	function getInterval(intervalTime){
		 		var intervalSelect = document.getElementById(intervalTime);
		 		var interval = intervalSelect.options[intervalSelect.selectedIndex].value;
		 		return interval;
		 	}
		 	
		 	/**
		 	*add rooms
		 	*/
		 	function addRooms(selectedRoomIDs){
		 		var roomIDs = document.getElementById(selectedRoomIDs);
		 		var isAvailable = checkSelectedNumber(roomIDs);
		 		if(!isAvailable){
		 			return;
		 		}
		 		
		 		var finalRoomIDs = "";
		 		var finalRoomNames = "";
		 		for(var i=0; i < roomIDs.length; i++){
		 			if(finalRoomIDs != ""){
		 				finalRoomIDs += "-";
		 				finalRoomNames +="、";
		 			}
		 			finalRoomIDs += roomIDs.options[i].value;
		 			finalRoomNames += roomIDs.options[i].text;
		 		}
		 		alert("dwr")
		 		McuDwrMethod.addParticipants('${chooseMeetingNumber}', finalRoomIDs, finalRoomNames, modifyMeetingCallBack);
		 	}
		 	
			function pollingCallBack(){
				window.close();
			}
		 	
		 	function modifyMeetingCallBack(){
		 		window.setTimeout("refreshOpener()", 5000);
		 		
		 	}
		 	
		 	function refreshOpener(){
		 		window.opener.location.reload();
		 		window.close();
		 	}
		 	
		 	function checkSelectedNumber(select){
	 			if(select == null){
	 				return false;
	 			}
	 			var count = 0;
	 			for(var i=0; i < select.length; i++){
	 				if(select.options[i].value != ""){
	 					count = count + 1;
	 					break;
	 				}
	 			}
	 			
	 			if(count == 0){
	 				alert("至少选择一个与会人");
	 				return false;
	 			}
	 			
	 			return true;
	 		}

  function a1(){
	 
	 document.getElementById("t1").className="on";
	
	 }
	 	

	 	
	function dblClickDelete(fromID, toID, numberID){
	 			removeAllOptions(toID, numberID);
	 		}
		
	 		
	function dblClickSelect(fromID, toID, numberID){
			var fromUsers = document.getElementById(fromID);
			var toUsers = document.getElementById(toID);
 		for(var i=0; i < toUsers.length; i++){
	 		if(toUsers.options[i].text == ""){
	 			toUsers.remove(i);	
	 		}
 		}
 		
 		insertOption(toID, fromUsers.options[fromUsers.selectedIndex].text, fromUsers.options[fromUsers.selectedIndex].value);
 		document.getElementById(numberID).innerHTML = toUsers.length;
		}
	 	
	 	//-->
	 	</script>	
	</head>

	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
		<div id="container">
		<div class="content">
		<div class="contenttitle fontstyle fontb">
  		<div class="fl"><img src="/icmp/images/blue/titleicon.gif" width="20" height="25" /></div>
  		<div class="fl">&nbsp;轮询会场</div>
		</div>
		<div class="tablesdiv">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" align="center">
			<tr>
				<td class="fontstyle fontb pr3 tdhight">&nbsp;&nbsp;&nbsp;&nbsp;自动轮询间隔时间（秒）：
					<select id="intervalTime" class="select200 fontstyle">
						<option value="10">10</option>
						<option value="20" selected>20</option>
						<option value="30">30</option>
						<option value="60">60</option>
						<option value="90">90</option>
						<option value="120">120</option>
						<option value="150">150</option>
						<option value="180">180</option>
						<option value="210">210</option>
						<option value="240">240</option>
						<option value="270">270</option>
						<option value="300">300</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<table border="0" cellspacing="1" cellpadding="0" class="table_css_lx">
						<tr id="dp2">
							<th width="45%" style="text-align:center;" >请选择会场</th>
							<td width="100" rowspan="2"><div class="btn_nav">
					            <input type="button" name="Submit" value="添加 &gt;" onclick="selectRooms('roomIDs', 'selectedRoomIDs', 'numberID');" class="btn_navbtn" />
					          </div>
					          <div class="btn_nav">
					          	<input type="button" name="Submit" value="添加所有 &gt;&gt;" onclick="selectAllRooms('roomIDs', 'selectedRoomIDs', 'numberID');" class="btn_navbtn" />
					          </div>
					          <div class="btn_nav">
					            <input type="button" name="Submit" class="btn_navbtn" onclick="removeAllOptions('selectedRoomIDs', 'numberID');" value="&lt; 删除" />
					        </div>
					          </td>
							<th width="45%" style="text-align:center;">已选择<span style="font-weight:bold;text-align:center;color:red"  id="numberID">0</span>会场 </th>
						</tr>
				  		<tr>
							<td>
								<div class="input_txt" style="width:100%; height:295px;  overflow: auto;border:1px solid #666666;" >
								<!-- <div  id="group1">-->
									<select id="roomIDs" style="width:100%;  height: 290px;" multiple="multiple"   ondblclick="dblClickSelect('roomIDs', 'selectedRoomIDs', 'numberID');" ondblclick="dblClickDelete('roomIDs', 'selectedRoomIDs', 'numberID');">
										<c:forEach items="${meetingRoomVOList}" var="meetingRoom">
											<option value="${meetingRoom.mcu_participant_ip }_${meetingRoom.mcuIp }">${meetingRoom.mcu_participant_name }</option>
										</c:forEach>
		    						</select>
								</div>
							</td>
							<!-- 							   
							<td  align="center" class="xxtabledatabg_m">
								<input type="button" class="btn_navbtn" value="添加>>" onclick="selectRooms('roomIDs', 'selectedRoomIDs', 'numberID');"><br /><br/>
					  				<br/><br/>
					  			<input type="button" class="btn_navbtn" value="所有>>" onclick="selectAllRooms('roomIDs', 'selectedRoomIDs', 'numberID');"><br/><br/>
					  				<br/></br>
					  			<input type="button" class="btn_navbtn" value="删除<<" onclick="removeAllOptions('selectedRoomIDs', 'numberID');">
							</td>
							-->
							<td align="center">
								<div class="input_txt"  style="width:100%; height:275px;  overflow: auto;border:1px solid #666666;" >
									<select id="selectedRoomIDs" style="width:100%;  height: 260px;" multiple="multiple"  ondblclick="dblClickDelete('roomIDs', 'selectedRoomIDs', 'numberID');">
	   									<option value=""></option>
	   								</select>
	<%--			   	  			<INPUT TYPE="button" class="btn_mr" value="置顶" onclick="moveTop(document.getElementById('selectedRoomIDs'));">   --%>
	<%--				  			<INPUT TYPE="button" class="btn_mr" value="置底" onclick="moveBottom(document.getElementById('selectedRoomIDs'));">--%>
								</div>
									<INPUT TYPE="button" class="searbutton fontstyle fontb" value="上移" onclick="moveUp(document.getElementById('selectedRoomIDs'));">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		  							<INPUT TYPE="button" class="searbutton fontstyle fontb" value="下移" onclick="moveDown(document.getElementById('selectedRoomIDs'));">
							</td>
						</tr>
					</table>						
				</td>								
			</tr>																		
		</table>						
		<!--<div class="btntable">
			<span style="margin:10px;">
		   		<input type="button" class="xxtabledatabg_btn" value="开始轮询" onclick="pollRooms('selectedRoomIDs', 'intervalTime');">
		    </span>
		    <span style="margin:10px;">
		       <input type="button" class="xxtabledatabg_btn" value="取消" onclick="window.close();">
		    </span>
		</div>
		-->
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		  <tr>
		    <td><input type="button" name="button" id="button" value="开始轮询" onclick="pollRooms('selectedRoomIDs', 'intervalTime');"  class="submit1 radius2" />
		      <input type="button" name="button2" id="button2" value="取消" onclick="window.close();" class="reset1 radius2" /></td>
		  </tr>
		</table>
		</div>
		</div>
	</body>
</html>
<SCRIPT LANGUAGE="JavaScript">   
<!--    
    //上移    
　   function moveUp(obj)    
　　{　    
　　　　　　for(var i=1; i < obj.length; i++)    
　　　　　　{//最上面的一个不需要移动，所以直接从i=1开始    
　　　　　　　　if(obj.options[i].selected)    
　　　　　　　　{    
　　　　　　　　　　if(!obj.options.item(i-1).selected)    
　　　　　　　　　　{    
　　　　　　　　　　　　var selText = obj.options[i].text;    
　　　　　　　　　　　　var selValue = obj.options[i].value;    
                        obj.options[i].text = obj.options[i-1].text;    
                        obj.options[i].value = obj.options[i-1].value;    
                        obj.options[i].selected = false;    
                        obj.options[i-1].text = selText;    
                        obj.options[i-1].value = selValue;    
                        obj.options[i-1].selected=true;    
　　　　　　　　　　}    
　　　　　　　　}    
　　　　　　}    
　　　　}    
   
        //下移    
        function moveDown(obj)    
　　　　{    
　　　　　　for(var i = obj.length -2 ; i >= 0; i--)    
　　　　　　{//向下移动，最后一个不需要处理，所以直接从倒数第二个开始    
　　　　　　　　if(obj.options[i].selected)    
　　　　　　　　{    
　　　　　　　　　　if(!obj.options[i+1].selected)    
　　　　　　　　　　{    
　　　　　　　　　　　　var selText = obj.options[i].text;    
　　　　　　　　　　　　var selValue = obj.options[i].value;    
            obj.options[i].text = obj.options[i+1].text;    
            obj.options[i].value = obj.options[i+1].value;    
           obj.options[i].selected = false;    
          obj.options[i+1].text = selText;    
          obj.options[i+1].value = selValue;    
         obj.options[i+1].selected=true;    
　　　　　　　　　　}    
　　　　　　　　}    
　　　　　　}    
　　　　}    
        //移动    
        function moveOption(obj1, obj2)    
        {    
             for(var i = obj1.options.length - 1 ; i >= 0 ; i--)    
             {    
                 if(obj1.options[i].selected)    
                 {    
                    var opt = new Option(obj1.options[i].text,obj1.options[i].value);    
                    opt.selected = true;    
                    obj2.options.add(opt);    
                    obj1.remove(i);    
                }    
             }    
        }    
        //置顶    
      function  moveTop(obj)     
      {     
            var  opts = [];     
            for(var i =obj.options.length -1 ; i >= 0; i--)    
            {    
                if(obj.options[i].selected)    
                {    
                    opts.push(obj.options[i]);    
                    obj.remove(i);    
                }    
            }    
            var index = 0 ;    
            for(var t = opts.length-1 ; t>=0 ; t--)    
            {    
                var opt = new Option(opts[t].text,opts[t].value);    
                opt.selected = true;    
                obj.options.add(opt, index++);    
            }    
        }     
      //置底    
      function  moveBottom(obj)     
      {     
            var  opts = [];     
            for(var i =obj.options.length -1 ; i >= 0; i--)    
            {    
                if(obj.options[i].selected)    
                {    
                    opts.push(obj.options[i]);    
                    obj.remove(i);    
                }    
            }    
             for(var t = opts.length-1 ; t>=0 ; t--)    
            {    
                var opt = new Option(opts[t].text,opts[t].value);    
                opt.selected = true;    
                obj.options.add(opt);    
            }    
        }     
   
    //-->   
</SCRIPT>   