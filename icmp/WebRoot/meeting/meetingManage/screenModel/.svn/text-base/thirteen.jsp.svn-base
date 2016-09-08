<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${sys_ctx }/style/screenModel.css" type="text/css">
    
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>


<script language="javascript">
	var data2 = [ { name:"请选择...", id:"0" }];
	var data3 = [ { name:"自动", id:"auto" }];
   	var data4 = [ { name:"自动轮询", id:"autoscan" }];
	var data5 = [ { name:"空", id:"blank" }];
	
	function setVideo3(videoModeId, lecturerId, isConversationId){
<%--		var mcuType = parent.document.getElementById(confID).value;--%>

			var confID = document.getElementById("confID").value;
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var mcuType = parent.document.getElementById(confID).value;
			var videoMode = "";
			if(mcuType == 11){
			videoMode = parent.document.getElementById("mode").value;
			}
		var lecturer = "";
		if(videoMode == "4"){
			lecturer = "";
		}
		
		var confID = document.getElementById("confID").value;
		
		var meetingDetailID = document.getElementById("meetingDetailID").value;
		//var isConversation = document.getElementById(isConversationId);
		//the first select in every column
		var selectItem1 = document.getElementById('selectId1');
		var selectItem2 = document.getElementById('selectId2');
		var selectItem3 = document.getElementById('selectId3');
		var selectItem4 = document.getElementById('selectId4');
		var selectItem5 = document.getElementById('selectId5');
		var selectItem6 = document.getElementById('selectId6');
		var selectItem7 = document.getElementById('selectId7');
		var selectItem8 = document.getElementById('selectId8');
		var selectItem9 = document.getElementById('selectId9');
		var selectItem10 = document.getElementById('selectId10');
		var selectItem11 = document.getElementById('selectId11');
		var selectItem12 = document.getElementById('selectId12');
		var selectItem13 = document.getElementById('selectId13');

		//var selectItems = selectItem6.value + "_" + selectItem1.value + "_" + selectItem2.value + "_" + selectItem3.value + "_" + selectItem4.value+ "_" + selectItem5.value+ "_"
 		var selectItems = selectItem1.value + "_" + selectItem2.value + "_" + selectItem3.value + "_" + selectItem4.value+ "_" + selectItem5.value+ "_" + selectItem6.value+ "_" + selectItem7.value+ "_" + selectItem8.value+ "_" + selectItem9.value+ "_" + selectItem10.value+ "_" + selectItem11.value+ "_" + selectItem12.value+ "_" + selectItem13.value;
		//the second select in every column
		/*
		var slaveSelectItem1 = document.getElementById('slaveSlectId1');
		var slaveSelectItem2 = document.getElementById('slaveSlectId2');
		var slaveSelectItem3 = document.getElementById('slaveSlectId3');
		var slaveSelectItem4 = document.getElementById('slaveSlectId4');
		var slaveSelectItem5 = document.getElementById('slaveSlectId5');
		var slaveSelectItem6 = document.getElementById('slaveSlectId6');
		var slaveSelectItem7 = document.getElementById('slaveSlectId7');
		var slaveSelectItem8 = document.getElementById('slaveSlectId8');
		var slaveSelectItem9 = document.getElementById('slaveSlectId9');
		var slaveSelectItem10 = document.getElementById('slaveSlectId10');
		var slaveSelectItem11 = document.getElementById('slaveSlectId11');
		var slaveSelectItem12 = document.getElementById('slaveSlectId12');
		var slaveSelectItem13 = document.getElementById('slaveSlectId13');
		var slaveSelectItems = slaveSelectItem1.value + "_" + slaveSelectItem2.value + "_" + slaveSelectItem3.value + "_" + slaveSelectItem4.value+ "_" + slaveSelectItem5.value+ "_" + slaveSelectItem6.value+ "_" + slaveSelectItem7.value+ "_" + slaveSelectItem8.value+ "_" + slaveSelectItem9.value+ "_" + slaveSelectItem10.value+ "_" + slaveSelectItem11.value+ "_" + slaveSelectItem12.value+ "_" + slaveSelectItem13.value;
		*/
		if(selectItems != null){
		//alert(selectItems);
			McuDwrMethod.setVideoScreen(meetingDetailID, confID, lecturer, videoMode, '${LAYOUT_MODE}', 13, selectItems);
			parent.setIntervaltime();
		}
	}
	/*
	*  演讲者 select 过滤其他select option 
	*/
	function selectDriverDel(id){
<%--		if(id.value!="auto"){--%>
<%--				var confID = document.getElementById("confID").value;--%>
<%--				McuHelpDwrMethod.getMastListExceptLec(id.value,confID,callback4); --%>
<%--		--%>
<%--		}--%>
		if(document.getElementById("lecturerId").disabled ==""){
			var confID = document.getElementById("confID").value;
		    McuHelpDwrMethod.getMastListExceptLec(id.value,confID,callback4); 
		}
		
	}
	function callback4(lst){
	   

	    var avalue = document.getElementById('selectId1').value;
		var bvalue = document.getElementById('selectId2').value;
		var cvalue = document.getElementById('selectId3').value;
		var dvalue = document.getElementById('selectId4').value;
		var evalue = document.getElementById('selectId5').value;
		var fvalue = document.getElementById('selectId6').value;
		var gvalue = document.getElementById('selectId7').value;
		var hvalue = document.getElementById('selectId8').value;
		var ivalue = document.getElementById('selectId9').value;
		var jvalue = document.getElementById('selectId10').value;
		var kvalue = document.getElementById('selectId11').value;
		var lvalue = document.getElementById('selectId12').value;
		var mvalue = document.getElementById('selectId13').value;

		var speakerSelect1 = document.getElementById('selectId1');
		var speakerText1 = speakerSelect1.options[speakerSelect1.selectedIndex].text;
		var speakerSelect2 = document.getElementById('selectId2');
		var speakerText2 = speakerSelect2.options[speakerSelect2.selectedIndex].text;
		var speakerSelect3 = document.getElementById('selectId3');
		var speakerText3 = speakerSelect3.options[speakerSelect3.selectedIndex].text;
		var speakerSelect4 = document.getElementById('selectId4');
		var speakerText4 = speakerSelect4.options[speakerSelect4.selectedIndex].text;
		var speakerSelect5 = document.getElementById('selectId5');
		var speakerText5 = speakerSelect5.options[speakerSelect5.selectedIndex].text;
		var speakerSelect6 = document.getElementById('selectId6');
		var speakerText6 = speakerSelect6.options[speakerSelect6.selectedIndex].text;
		var speakerSelect7 = document.getElementById('selectId7');
		var speakerText7 = speakerSelect7.options[speakerSelect7.selectedIndex].text;
		var speakerSelect8 = document.getElementById('selectId8');
		var speakerText8 = speakerSelect8.options[speakerSelect8.selectedIndex].text;
		var speakerSelect9 = document.getElementById('selectId9');
		var speakerText9 = speakerSelect9.options[speakerSelect9.selectedIndex].text;
		var speakerSelect10 = document.getElementById('selectId10');
		var speakerText10 = speakerSelect10.options[speakerSelect10.selectedIndex].text;
		var speakerSelect11 = document.getElementById('selectId11');
		var speakerText11 = speakerSelect11.options[speakerSelect11.selectedIndex].text;
		var speakerSelect12 = document.getElementById('selectId12');
		var speakerText12 = speakerSelect12.options[speakerSelect12.selectedIndex].text;
		var speakerSelect13 = document.getElementById('selectId13');
		var speakerText13 = speakerSelect13.options[speakerSelect13.selectedIndex].text;
	   	
	   	
	   	/*
		*  a select option 初始化
		*/
		dwr.util.removeAllOptions('selectId1');
		dwr.util.addOptions('selectId1', data3, "id", "name");
		dwr.util.addOptions('selectId1', data4, "id", "name");
		dwr.util.addOptions('selectId1', data5, "id", "name");
		dwr.util.addOptions('selectId1', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId1', avalue);
		var lecturerSelect = document.getElementById("lecturerId");
		if(speakerText1 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
			document.getElementById('selectId1').value='auto';
			dwr.util.removeAllOptions('slaveSlectId1');
		   	dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
		}
		/*
		*  b select option 初始化
		*/
		dwr.util.removeAllOptions('selectId2');
		dwr.util.addOptions('selectId2', data3, "id", "name");
		dwr.util.addOptions('selectId2', data4, "id", "name");
		dwr.util.addOptions('selectId2', data5, "id", "name");
		dwr.util.addOptions('selectId2', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId2', bvalue);
		if(speakerText2 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId2').value='auto';
		dwr.util.removeAllOptions('slaveSlectId2');
	   	dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
		}
	   	/*
		*  c select option 初始化
		*/
		dwr.util.removeAllOptions('selectId3');
		dwr.util.addOptions('selectId3', data3, "id", "name");
		dwr.util.addOptions('selectId3', data4, "id", "name");
		dwr.util.addOptions('selectId3', data5, "id", "name");
		dwr.util.addOptions('selectId3', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId3', cvalue);
		if(speakerText3 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId3').value='auto';
		dwr.util.removeAllOptions('slaveSlectId3');
	   	dwr.util.addOptions('slaveSlectId3', data2, "id", "name");		
		}
		/*
		*  d select option 初始化
		*/
		
		dwr.util.removeAllOptions('selectId4');
		dwr.util.addOptions('selectId4', data3, "id", "name");
		dwr.util.addOptions('selectId4', data4, "id", "name");
		dwr.util.addOptions('selectId4', data5, "id", "name");
		dwr.util.addOptions('selectId4', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId4', dvalue);
		
		if(speakerText4 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId4').value='auto';
		dwr.util.removeAllOptions('slaveSlectId4');
	   	dwr.util.addOptions('slaveSlectId4', data2, "id", "name");		
		}	
		/*
		*  e select option 初始化
		*/
		dwr.util.removeAllOptions('selectId5');
		dwr.util.addOptions('selectId5', data3, "id", "name");
		dwr.util.addOptions('selectId5', data4, "id", "name");
		dwr.util.addOptions('selectId5', data5, "id", "name");
		dwr.util.addOptions('selectId5', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId5', evalue);
		
		if(speakerText5 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId5').value='auto';
		dwr.util.removeAllOptions('slaveSlectId5');
	   	dwr.util.addOptions('slaveSlectId5', data2, "id", "name");		
		}	
		/*
		*  f select option 初始化
		*/
		dwr.util.removeAllOptions('selectId6');
		dwr.util.addOptions('selectId6', data3, "id", "name");
		dwr.util.addOptions('selectId6', data4, "id", "name");
		dwr.util.addOptions('selectId6', data5, "id", "name");
		dwr.util.addOptions('selectId6', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId6', fvalue);
		
		if(speakerText6 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId6').value='auto';
		dwr.util.removeAllOptions('slaveSlectId6');
	   	dwr.util.addOptions('slaveSlectId6', data2, "id", "name");		
		}	
		/*
		*  g select option 初始化
		*/
		dwr.util.removeAllOptions('selectId7');
		dwr.util.addOptions('selectId7', data3, "id", "name");
		dwr.util.addOptions('selectId7', data4, "id", "name");
		dwr.util.addOptions('selectId7', data5, "id", "name");
		dwr.util.addOptions('selectId7', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId7', gvalue);
		
		if(speakerText7 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId7').value='auto';
		dwr.util.removeAllOptions('slaveSlectId7');
	   	dwr.util.addOptions('slaveSlectId7', data2, "id", "name");		
		}
		/*
		*  h select option 初始化
		*/
		dwr.util.removeAllOptions('selectId8');
		dwr.util.addOptions('selectId8', data3, "id", "name");
		dwr.util.addOptions('selectId8', data4, "id", "name");
		dwr.util.addOptions('selectId8', data5, "id", "name");
		dwr.util.addOptions('selectId8', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId8', hvalue);
		
		if(speakerText8 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId8').value='auto';
		dwr.util.removeAllOptions('slaveSlectId8');
	   	dwr.util.addOptions('slaveSlectId8', data2, "id", "name");		
		}
		/*
		*  i select option 初始化
		*/
		dwr.util.removeAllOptions('selectId9');
		dwr.util.addOptions('selectId9', data3, "id", "name");
		dwr.util.addOptions('selectId9', data4, "id", "name");
		dwr.util.addOptions('selectId9', data5, "id", "name");
		dwr.util.addOptions('selectId9', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId9', ivalue);
		
		if(speakerText9 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId9').value='auto';
		dwr.util.removeAllOptions('slaveSlectId9');
	   	dwr.util.addOptions('slaveSlectId9', data2, "id", "name");		
		}	
		/*
		*  j select option 初始化
		*/
		dwr.util.removeAllOptions('selectId10');
		dwr.util.addOptions('selectId10', data3, "id", "name");
		dwr.util.addOptions('selectId10', data4, "id", "name");
		dwr.util.addOptions('selectId10', data5, "id", "name");
		dwr.util.addOptions('selectId10', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId10', jvalue);
		
		if(speakerText10 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId10').value='auto';
		dwr.util.removeAllOptions('slaveSlectId10');
	   	dwr.util.addOptions('slaveSlectId10', data2, "id", "name");		
		}	
		/*
		*  k select option 初始化
		*/
		dwr.util.removeAllOptions('selectId11');
		dwr.util.addOptions('selectId11', data3, "id", "name");
		dwr.util.addOptions('selectId11', data4, "id", "name");
		dwr.util.addOptions('selectId11', data5, "id", "name");
		dwr.util.addOptions('selectId11', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId11', kvalue);
		
		if(speakerText11 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId11').value='auto';
		dwr.util.removeAllOptions('slaveSlectId11');
	   	dwr.util.addOptions('slaveSlectId11', data2, "id", "name");		
		}
		/*
		*  l select option 初始化
		*/
		dwr.util.removeAllOptions('selectId12');
		dwr.util.addOptions('selectId12', data3, "id", "name");
		dwr.util.addOptions('selectId12', data4, "id", "name");
		dwr.util.addOptions('selectId12', data5, "id", "name");
		dwr.util.addOptions('selectId12', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId12', lvalue);
		
		if(speakerText12 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId12').value='auto';
		dwr.util.removeAllOptions('slaveSlectId12');
	   	dwr.util.addOptions('slaveSlectId12', data2, "id", "name");		
		}
		/*
		*  m select option 初始化
		*/
		dwr.util.removeAllOptions('selectId13');
		dwr.util.addOptions('selectId13', data3, "id", "name");
		dwr.util.addOptions('selectId13', data4, "id", "name");
		dwr.util.addOptions('selectId13', data5, "id", "name");
		dwr.util.addOptions('selectId13', lst, 'mcu_participant_id', 'mcu_participant_name');
		slef_selected('selectId13', mvalue);
		
		if(speakerText13 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
		document.getElementById('selectId13').value='auto';
		dwr.util.removeAllOptions('slaveSlectId13');
	   	dwr.util.addOptions('slaveSlectId13', data2, "id", "name");		
		}			
	}

	function slef_selected(id, value) {
	
		document.getElementById(id).value=value;
	}

	/*
	*  视频模式 select 限制演讲者select option
	*/
	
	function screen(){
		checkroll();
		if(document.getElementById('select').value!="0"){
			var id = "自动";
			var screenValue = document.getElementById('select').value;
			var confID = document.getElementById("confID").value;
			if(screenValue == "0"){
				document.getElementById("lecturerId").disabled = "";
				McuHelpDwrMethod.getMastListExceptLec(document.getElementById("lecturerId").value,confID,callback4);
			}
			if(screenValue == "4"){
				document.getElementById("lecturerId").disabled = "disabled";
				if( document.getElementById("lecturerId").value != "自动"){
					McuHelpDwrMethod.getMastListExceptLec(id,confID,callback4);
				}
			}
		}else{
			screen1();
		}
	}
	
	function screen1(){
	
		var id = "自动";
		var screenValue = document.getElementById('select').value;
		var confID = document.getElementById("confID").value;
		if(screenValue == "0"){	
			document.getElementById("lecturerId").disabled = "";
		}
		if(screenValue == "4"){
			document.getElementById("lecturerId").disabled = "disabled";
		}
	}
	

	
	function setVideoMode(videoModeId, lecturerId){
		var id = "自动";
		var confID = document.getElementById("confID").value;
		var screenValue = document.getElementById(videoModeId).value;
		if(screenValue == "0"){
			document.getElementById(lecturerId).disabled = "";
			McuHelpDwrMethod.getMastListExceptLec(document.getElementById("lecturerId").value,confID,callback4);
			if(document.getElementById("isConversationId").checked==true){
				document.getElementById("checkrollImage1").style.display = "";
				document.getElementById("checkrollImage2").style.display = "none";
			}
		}
		if(screenValue == "4"){
			document.getElementById(lecturerId).disabled = "disabled";
			if( document.getElementById(lecturerId).value != "自动"){
				McuHelpDwrMethod.getMastListExceptLec(id,confID,callback4);
			}
			if(document.getElementById("isConversationId").checked==true){
				document.getElementById("checkrollImage1").style.display = "";
				document.getElementById("checkrollImage2").style.display = "";
			}
		}
	}
	 /*
	*  select option 互斥
	*/
	function check(id){
	
			if(id.value!="autoscan" && id.value!="auto"){
				
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId1');
<%--	    		var data2 = [ { name:"请选择...", id:"0" }];--%>
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
			}
	}	
	function callback(lst){
			
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
					
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
	    		if(id1.value == id2.value && id1.value != 'auto'){
					dwr.util.removeAllOptions('slaveSlectId2');
		    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
		    		id2.value = 'auto';
		    		}
		    	if(id1.value == id3.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId3');
		    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");	
		    		id3.value = 'auto';
		    	}
		    	if(id1.value == id4.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId4');
		    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");	
		    		id4.value = 'auto';
		    	}
		    	if(id1.value == id5.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId5');
		    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");	
		    		id5.value = 'auto';
		    	}
		    	if(id1.value == id6.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId6');
		    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");	
		    		id6.value = 'auto';
		    	}
		    	if(id1.value == id7.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId7');
		    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");	
		    		id7.value = 'auto';
		    	}
		    	if(id1.value == id8.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId8');
		    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
		    		id8.value = 'auto';
		    	}
		    	if(id1.value == id9.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    	}
		    	if(id1.value == id10.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    	}
		    	if(id1.value == id11.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    	}
		    	if(id1.value == id12.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    	}
		    	if(id1.value == id13.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    	}
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId1');
			dwr.util.addOptions('slaveSlectId1', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId1', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId1', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId1', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id1.value == id2.value && id1.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id1.value == id3.value && id1.value != 'auto'){
	    	dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");	
    		id3.value = 'auto';
    		}	
    		if(id1.value == id4.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId4');
		    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");	
		    		id4.value = 'auto';
		    }
		    if(id1.value == id5.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId5');
		    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");	
		    		id5.value = 'auto';
		    	}
	    	if(id1.value == id6.value && id1.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");	
	    		id6.value = 'auto';
	    	}
	    	if(id1.value == id7.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId7');
		    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");	
		    		id7.value = 'auto';
	    	}
	    	if(id1.value == id8.value && id1.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}	
	    	if(id1.value == id9.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id1.value == id10.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id1.value == id11.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    	}
	    	if(id1.value == id12.value && id1.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
	    		id12.value = 'auto';
	    	}
	    	if(id1.value == id13.value && id1.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    	}
	}
		
		function check1(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback1); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId2');
	    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
			}
		}	
	    function callback1(lst){
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
  			  var id11 = document.getElementById("selectId11");
  			  var id12 = document.getElementById("selectId12");
  			  var id13 = document.getElementById("selectId13");
	    	
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId2');
	    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
	    	if(id2.value == id1.value && id2.value != 'auto'){
				dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
	    		id1.value = 'auto';
	    	}
	    	if(id2.value == id3.value && id2.value != 'auto'){
	    		
	   			dwr.util.removeAllOptions('slaveSlectId3');
	    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");	
	    		id3.value = 'auto';
	    	}
	    	if(id2.value == id4.value && id2.value != 'auto'){
	    		
	   			dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");	
	    		id4.value = 'auto';
	    	}
	    	if(id2.value == id5.value && id2.value != 'auto'){
	    		
	   			dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");	
	    		id5.value = 'auto';
	    	}
	    	if(id2.value == id6.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");	
	    		id6.value = 'auto';
	    	}
	    	if(id2.value == id7.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");	
	    		id7.value = 'auto';
	    	}
	    	if(id2.value == id8.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id2.value == id9.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id2.value == id10.value && id2.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id2.value == id11.value && id2.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    	}
	    	if(id2.value == id12.value && id2.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
	    		id12.value = 'auto';
	    	}
	    	if(id2.value == id13.value && id2.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
	    		id13.value = 'auto';
	    	}
		    	return;
		    	}
			dwr.util.removeAllOptions('slaveSlectId2');
			dwr.util.addOptions('slaveSlectId2', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId2', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId2', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId2', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id2.value == id1.value && id2.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id2.value == id3.value && id2.value != 'auto'){
    		
   			dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");	
    		id3.value = 'auto';
    		}
    		if(id2.value == id4.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");	
	    		id4.value = 'auto';
	    	}
	    	if(id2.value == id5.value && id2.value != 'auto'){
	    		
	   			dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");	
	    		id5.value = 'auto';
	    	}
	    	if(id2.value == id6.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");	
	    		id6.value = 'auto';
	    	}
	    	if(id2.value == id7.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");	
	    		id7.value = 'auto';
	    	}
	    	if(id2.value == id8.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}	
	    	if(id2.value == id9.value && id2.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id2.value == id10.value && id2.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id2.value == id11.value && id2.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    	}
	    	if(id2.value == id12.value && id2.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
	    		id12.value = 'auto';
	    	}
	    	if(id2.value == id13.value && id2.value != 'auto'){
		    	dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
	    		id13.value = 'auto';
	    	}	
		}
		
		function check2(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback2); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId3');
	    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
			}
		}	
	    function callback2(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId3');
	    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
	    	if(id3.value == id2.value && id3.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id3.value == id1.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id3.value == id4.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id3.value == id5.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id3.value == id6.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id3.value == id7.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id3.value == id8.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id3.value == id9.value && id3.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id3.value == id10.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id3.value == id11.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id3.value == id12.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id3.value == id13.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId3');
			dwr.util.addOptions('slaveSlectId3', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId3', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId3', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId3', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id3.value == id2.value && id3.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id3.value == id1.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id3.value == id4.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id3.value == id5.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id3.value == id6.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id3.value == id7.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id3.value == id8.value && id3.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}	
    		if(id3.value == id9.value && id3.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id3.value == id10.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id3.value == id11.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id3.value == id12.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id3.value == id13.value && id3.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }		
		}


		function check3(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback3); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
			}
		}	
	    function callback3(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
	    	if(id4.value == id1.value && id4.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id4.value == id2.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id4.value == id3.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id4.value == id5.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id4.value == id6.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id4.value == id7.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id4.value == id8.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id4.value == id9.value && id4.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id4.value == id10.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id4.value == id11.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id4.value == id12.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id4.value == id13.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId4');
			dwr.util.addOptions('slaveSlectId4', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId4', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId4', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId4', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id4.value == id1.value && id4.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id4.value == id2.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id4.value == id3.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}	
    		if(id4.value == id5.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id4.value == id6.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id4.value == id7.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id4.value == id8.value && id4.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}	
    		if(id4.value == id9.value && id4.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id4.value == id10.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id4.value == id11.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id4.value == id12.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id4.value == id13.value && id4.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		function check4(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback5); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
			}
		}	
	    function callback5(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
	    	if(id5.value == id1.value && id5.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id5.value == id2.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id5.value == id3.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id5.value == id4.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id5.value == id6.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id5.value == id7.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id5.value == id8.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id5.value == id9.value && id5.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id5.value == id10.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id5.value == id11.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id5.value == id12.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id5.value == id13.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId5');
			dwr.util.addOptions('slaveSlectId5', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId5', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId5', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId5', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id5.value == id1.value && id5.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id5.value == id2.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id5.value == id3.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id5.value == id4.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id5.value == id6.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id5.value == id7.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id5.value == id8.value && id5.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id5.value == id9.value && id5.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}	
	    	if(id5.value == id10.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id5.value == id11.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id5.value == id12.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id5.value == id13.value && id5.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
    	}
    	function check5(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback6); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
			}
		}	
	    function callback6(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
	    	if(id6.value == id1.value && id6.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id6.value == id2.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id6.value == id3.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id6.value == id4.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id6.value == id5.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id6.value == id7.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id6.value == id8.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id6.value == id9.value && id6.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id6.value == id10.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id6.value == id11.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id6.value == id12.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id6.value == id13.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId6');
			dwr.util.addOptions('slaveSlectId6', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId6', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId6', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId6', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id6.value == id1.value && id6.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id6.value == id2.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id6.value == id3.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id6.value == id4.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id6.value == id5.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id6.value == id7.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id6.value == id8.value && id6.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id6.value == id9.value && id6.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id6.value == id10.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id6.value == id11.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id6.value == id12.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id6.value == id13.value && id6.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		
		   function check6(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback7); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
			}
		}	
	    function callback7(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
	    	if(id7.value == id1.value && id7.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id7.value == id2.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id7.value == id3.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id7.value == id4.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id7.value == id5.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id7.value == id6.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id7.value == id8.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id7.value == id9.value && id7.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id7.value == id10.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id7.value == id11.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id7.value == id12.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id7.value == id13.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId7');
			dwr.util.addOptions('slaveSlectId7', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId7', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId7', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId7', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id7.value == id1.value && id7.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id7.value == id2.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id7.value == id3.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id7.value == id4.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id7.value == id5.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id7.value == id6.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id7.value == id8.value && id7.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId8');
    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
    		id8.value = 'auto';
    		}
    		if(id7.value == id9.value && id7.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id7.value == id10.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id7.value == id11.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id7.value == id12.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id7.value == id13.value && id7.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		
		    	function check7(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback8); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
			}
		}	
	    function callback8(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
	    	if(id8.value == id1.value && id8.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id8.value == id2.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id8.value == id3.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id8.value == id4.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id8.value == id5.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id8.value == id6.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id8.value == id7.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id8.value == id9.value && id8.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id8.value == id10.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id8.value == id11.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id8.value == id12.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id8.value == id13.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId8');
			dwr.util.addOptions('slaveSlectId8', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId8', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId8', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId8', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id8.value == id1.value && id8.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id8.value == id2.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id8.value == id3.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id8.value == id4.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id8.value == id5.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id8.value == id6.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id8.value == id7.value && id8.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id8.value == id9.value && id8.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
	    		id9.value = 'auto';
	    	}
	    	if(id8.value == id10.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id8.value == id11.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id8.value == id12.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id8.value == id13.value && id8.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		function check8(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback9); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");
			}
		}	
	    function callback9(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");
	    	if(id9.value == id1.value && id9.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id9.value == id2.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id9.value == id3.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id9.value == id4.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id9.value == id5.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id9.value == id6.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id9.value == id7.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id9.value == id8.value && id9.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id9.value == id10.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id9.value == id11.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id9.value == id12.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id9.value == id13.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId9');
			dwr.util.addOptions('slaveSlectId9', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId9', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId9', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId9', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id9.value == id1.value && id9.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id9.value == id2.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id9.value == id3.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id9.value == id4.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id9.value == id5.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id9.value == id6.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id9.value == id7.value && id9.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id9.value == id8.value && id9.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id9.value == id10.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id9.value == id11.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id9.value == id12.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id9.value == id13.value && id9.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		function check9(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback10); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId10');
	    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");
			}
		}	
	    function callback10(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId10');
	    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");
	    	if(id10.value == id1.value && id10.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id10.value == id2.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id10.value == id3.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id10.value == id4.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id10.value == id5.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id10.value == id6.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id10.value == id7.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id10.value == id8.value && id10.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id10.value == id9.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id10.value == id11.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id10.value == id12.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id10.value == id13.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId10');
			dwr.util.addOptions('slaveSlectId10', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId10', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId10', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId10', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id10.value == id1.value && id10.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id10.value == id2.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id10.value == id3.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id10.value == id4.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id10.value == id5.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id10.value == id6.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id10.value == id7.value && id10.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id10.value == id8.value && id10.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id10.value == id9.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id10.value == id11.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id10.value == id12.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id10.value == id13.value && id10.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		function check10(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback11); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId11');
	    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");
			}
		}	
	    function callback11(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId10');
	    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");
	    	if(id11.value == id1.value && id11.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id11.value == id2.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id11.value == id3.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id11.value == id4.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id11.value == id5.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id11.value == id6.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id11.value == id7.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id11.value == id8.value && id11.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id11.value == id9.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id11.value == id10.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id11.value == id12.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id11.value == id13.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId11');
			dwr.util.addOptions('slaveSlectId11', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId11', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId11', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId11', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id11.value == id1.value && id11.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id11.value == id2.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id11.value == id3.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id11.value == id4.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id11.value == id5.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id11.value == id6.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id11.value == id7.value && id11.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id11.value == id8.value && id11.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id11.value == id9.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id11.value == id10.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id11.value == id12.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    if(id11.value == id13.value && id11.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
			function check11(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback12); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");
			}
		}	
	    function callback12(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");
	    	if(id12.value == id1.value && id12.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id12.value == id2.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id12.value == id3.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id12.value == id4.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id12.value == id5.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id12.value == id6.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id12.value == id7.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id12.value == id8.value && id12.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id12.value == id9.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id12.value == id10.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id12.value == id11.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id12.value == id13.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId12');
			dwr.util.addOptions('slaveSlectId12', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId12', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId12', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId12', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id12.value == id1.value && id12.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id12.value == id2.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id12.value == id3.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id12.value == id4.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id12.value == id5.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id12.value == id6.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id12.value == id7.value && id12.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id12.value == id8.value && id12.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id12.value == id9.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id12.value == id10.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id12.value == id11.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id12.value == id13.value && id12.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId13');
		    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");	
		    		id13.value = 'auto';
		    }
		}
		
		function check12(id){
				if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback131); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");
			}
		}	
	    function callback131(lst){
	    
			  var id1 = document.getElementById("selectId1");
			  var id2 = document.getElementById("selectId2");
			  var id3 = document.getElementById("selectId3");
			  var id4 = document.getElementById("selectId4");
			  var id5 = document.getElementById("selectId5");
			  var id6 = document.getElementById("selectId6");
			  var id7 = document.getElementById("selectId7");
			  var id8 = document.getElementById("selectId8");
			  var id9 = document.getElementById("selectId9");
			  var id10 = document.getElementById("selectId10");
			  var id11 = document.getElementById("selectId11");
			  var id12 = document.getElementById("selectId12");
			  var id13 = document.getElementById("selectId13");
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");
	    	if(id13.value == id1.value && id13.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id13.value == id2.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id13.value == id3.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id13.value == id4.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id13.value == id5.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id13.value == id6.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id13.value == id7.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id13.value == id8.value && id13.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id13.value == id9.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id13.value == id10.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id13.value == id11.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id13.value == id12.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		    	return;
		    }
			dwr.util.removeAllOptions('slaveSlectId13');
			dwr.util.addOptions('slaveSlectId13', data3, "id", "name");
			dwr.util.addOptions('slaveSlectId13', data4, "id", "name");
			dwr.util.addOptions('slaveSlectId13', data5, "id", "name");
			dwr.util.addOptions('slaveSlectId13', lst, 'mcu_participant_id', 'mcu_participant_name');
			if(id13.value == id1.value && id13.value != 'auto'){
			dwr.util.removeAllOptions('slaveSlectId1');
    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
    		id1.value = 'auto';
    		}
    		if(id13.value == id2.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId2');
    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
    		id2.value = 'auto';
    		}
    		if(id13.value == id3.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId3');
    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
    		id3.value = 'auto';
    		}
    		if(id13.value == id4.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId4');
    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
    		id4.value = 'auto';
    		}
    		if(id13.value == id5.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId5');
    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
    		id5.value = 'auto';
    		}
    		if(id13.value == id6.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId6');
    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
    		id6.value = 'auto';
    		}
    		if(id13.value == id7.value && id13.value != 'auto'){
    		dwr.util.removeAllOptions('slaveSlectId7');
    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
    		id7.value = 'auto';
    		}
    		if(id13.value == id8.value && id13.value != 'auto'){
	   			dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");	
	    		id8.value = 'auto';
	    	}
	    	if(id13.value == id9.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId9');
		    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");	
		    		id9.value = 'auto';
		    }
		    if(id13.value == id10.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId10');
		    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");	
		    		id10.value = 'auto';
		    }
		    if(id13.value == id11.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId11');
		    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");	
		    		id11.value = 'auto';
		    }
		    if(id13.value == id12.value && id13.value != 'auto'){
			    	dwr.util.removeAllOptions('slaveSlectId12');
		    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");	
		    		id12.value = 'auto';
		    }
		}

	    /*
		*  点名判断
		*
		*/
		function checkroll(){
		
			var videoMode = document.getElementById("videoModeId");
			var isConversation = document.getElementById("isConversationId");
				if(isConversation.checked==true){
					if(videoMode.value=="0"){
					  	document.getElementById("checkrollImage1").style.display = "";
						document.getElementById("checkrollImage2").style.display = "none";
				  	}
					if(videoMode.value=="4"){
					  	document.getElementById("checkrollImage1").style.display = "";
						document.getElementById("checkrollImage2").style.display = "";
				  	}
				}
				if(isConversation.checked==false){
					document.getElementById("checkrollImage1").style.display = "none";
					document.getElementById("checkrollImage2").style.display = "none";
			}
		}

</script>
  </head>
  
  <body>
          <input type="hidden" value="${confVO.confID}" id="confID"/>
     <input type="hidden" value="${confVO.confFlagId}" id="meetingDetailID"/>
   <table width="100%" border="0" cellspacing="1" cellpadding="0" height="100%" bgcolor="#e4eafa">
   	 <!--<tr>
   	 <td colspan="4" bgcolor="#bdcbef" style="border:1px solid #505050;height:30px;font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp;分屏模式： 
   	 		 <input type="hidden" id="videoMode" value="${confVO.videoMode}" >
   	 	<c:if test="${confVO.videoMode=='1'}"><span class="fonttsx">演示模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='0'}"><span class="fonttsx">演讲者模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='4'}"><span class="fonttsx">相同分屏模式</span></c:if>
   	 	&nbsp;&nbsp;&nbsp;&nbsp;演讲者： <span class="fonttsx"><input type="text" id="lecturerId" value="${confVO.lectureName }" /></span>
			 	&nbsp;&nbsp;&nbsp;&nbsp;
			 	<span style="display:none;">
			 <input type="hidden" value="${confVO.isConversation }" id="isConversation"/>
			 <script language="javascript">
			 var isConversation = document.getElementById("isConversation").value;
			 if(isConversation == 'YES'){
			 document.getElementById("isConversationId").checked = true;
			 }
			 if(isConversation == 'NO'){
			 document.getElementById("isConversationId").checked = false;
			 }
			 </script>
			 </span>
			 </td>
   	 </tr>
   	 
   	   --><tr>
   	     <td width="25%" height="75px" style="border:1px solid #505050" valign="top"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	      <div style="margin-top:15px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId2" >
   	         <option value="auto" ${'auto' == selectItem2 ? "selected" : "" }>自动</option>
			 <option value="autoscan" ${'autoscan' == selectItem2 ? "selected" : "" }>自动轮询</option>
			 <option value="blank" ${'blank' == selectItem2 ? "selected" : "" }>空</option>
			 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem2 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			 </c:forEach>
 	         </select>
<%-- 	         <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId1">--%>
<%--				<option value="auto" ${'auto' == selectItemOption1 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption1 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption1 ? "selected" : "" }>空</option>--%>
<%--				 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption1 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	         </select>--%>
 	        </div>
 	       </form></td>
   	     <td height="75px" width="25%" style="border:1px solid #505050"  ><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:15px;">
	   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId3">
	   	         <option value="auto" ${'auto' == selectItem3 ? "selected" : "" }>自动</option>
				 <option value="autoscan" ${'autoscan' == selectItem3 ? "selected" : "" }>自动轮询</option>
				 <option value="blank" ${'blank' == selectItem3 ? "selected" : "" }>空</option>
				 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
						<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem3 ? "selected" : "" }>
							${meetingMcu.mcu_participant_name }
						</option>
					</c:if>
				 </c:forEach>
	 	       </select>
<%--	 	        <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId2">--%>
<%--					<option value="auto" ${'auto' == selectItemOption2 ? "selected" : "" }>自动</option>--%>
<%--					<option value="autoscan" ${'autoscan' == selectItemOption2 ? "selected" : "" }>自动轮询</option>--%>
<%--					<option value="blank" ${'blank' == selectItemOption2 ? "selected" : "" }>空</option>--%>
<%--					 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption2 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%--	 	        </select>--%>
 	        </div>
 	       </form></td>
   	     <td width="25%" height="75px" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:15px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId4" >
   	        <option value="auto" ${'auto' == selectItem4 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem4 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem4 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem4 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId3">--%>
<%--				<option value="auto" ${'auto' == selectItemOption3 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption3 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption3 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption3 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      
   	     <td width="25%" height="75px" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:15px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId5" >
   	        <option value="auto" ${'auto' == selectItem5 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem5 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem5 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem5 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId4">--%>
<%--				<option value="auto" ${'auto' == selectItemOption4 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption4 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption4 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption4 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      </tr>
 	     <tr>
 	      <td height="75px" width="25%"   style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId6" >
   	        <option value="auto" ${'auto' == selectItem6 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem6 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem6 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem6 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId5">--%>
<%--				<option value="auto" ${'auto' == selectItemOption5 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption5 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption5 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption5 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	       
 	      <td height="150px" width="50%" colspan="2"  rowspan="2" valign="top" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	      <div  style="margin-top:0px; height:15px; text-align:left; padding-left:10px;padding-top:8px;">
   	      </div>
   	       <div style="margin-top:40px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId1">
   	        <option value="auto" ${'auto' == selectItem1 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem1 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem1 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem1 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId6">--%>
<%--				<option value="auto" ${'auto' == selectItemOption6 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption6 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption6 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption6 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId7" >
   	        <option value="auto" ${'auto' == selectItem7 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem7 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem7 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem7 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId7">--%>
<%--				<option value="auto" ${'auto' == selectItemOption7 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption7 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption7 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption7 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      </tr><tr>
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId8" >
   	        <option value="auto" ${'auto' == selectItem8 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem8 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem8 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem8 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId8">--%>
<%--				<option value="auto" ${'auto' == selectItemOption8 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption8 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption8 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption8 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	     
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId9" >
   	        <option value="auto" ${'auto' == selectItem9 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem9 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem9 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem9 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId9">--%>
<%--				<option value="auto" ${'auto' == selectItemOption9 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption9 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption9 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption9 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      </tr><tr>
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId10" >
   	        <option value="auto" ${'auto' == selectItem10 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem10 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem10 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem10 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId10">--%>
<%--				<option value="auto" ${'auto' == selectItemOption10 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption10 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption10 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption10 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId11" >
   	        <option value="auto" ${'auto' == selectItem11 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem11 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem11 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem11 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId11">--%>
<%--				<option value="auto" ${'auto' == selectItemOption11 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption11 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption11 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption11 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId12" >
   	        <option value="auto" ${'auto' == selectItem12 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem12 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem12 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem12 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId12">--%>
<%--				<option value="auto" ${'auto' == selectItemOption12 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption12 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption12 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption12 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
 	      <td height="75px" width="25%" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:10px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId13" >
   	        <option value="auto" ${'auto' == selectItem13 ? "selected" : "" }>自动</option>
			<option value="autoscan" ${'autoscan' == selectItem13 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem13 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<c:if test="${confVO.videoMode != '0' || (confVO.videoMode == '0' && confVO.lectureName != meetingMcu.mcu_participant_name) }">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem13 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				</c:if>
			</c:forEach>
   	      </select>
<%--   	      <select name="nameID"  style="color:#666; font-size:12px;" id="slaveSlectId13">--%>
<%--				<option value="auto" ${'auto' == selectItemOption13 ? "selected" : "" }>自动</option>--%>
<%--				<option value="autoscan" ${'autoscan' == selectItemOption13 ? "selected" : "" }>自动轮询</option>--%>
<%--				<option value="blank" ${'blank' == selectItemOption13 ? "selected" : "" }>空</option>--%>
<%--			 <c:forEach items="${list}"--%>
<%--				var="meetingMcu">--%>
<%--				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItemOption13 ? "selected" : "" }>--%>
<%--					${meetingMcu.mcu_participant_name }--%>
<%--				</option>--%>
<%--			 </c:forEach>--%>
<%-- 	      </select>--%>
 	      </div>
 	       </form>
 	      </td>
        </tr>
   	   <tr>
   	     <td height="60" colspan="4" style="border:1px solid #505050" align="center" bgcolor="#bdcbef">
   	     	<input type="button" value="生 效" onclick="setVideo3('videoModeId', 'lecturerId', 'isConversationId');" style="border-top:1px solid #ffffff; border-left:1px solid #ffffff; border-right:1px solid #4d658d;  border-bottom:1px solid #4d658d; width:80px;height:24px; background:#6b7c98; color:#ffffff; font-size:12px; font-family:'微软雅黑', '黑体', '宋体', Arial, Verdana"  />
   	     </td>
       </tr>
     </table>
  </body>
   <script>
   	/*
	  var id1 = document.getElementById("selectId1");
	  var id2 = document.getElementById("selectId2");
	  var id3 = document.getElementById("selectId3");
	  var id4 = document.getElementById("selectId4");
	  var id5 = document.getElementById("selectId5");
	  var id6 = document.getElementById("selectId6");
	  var id7 = document.getElementById("selectId7");
	  var id8 = document.getElementById("selectId8");
	  var id9 = document.getElementById("selectId9");
	  var id10 = document.getElementById("selectId10");
	  var id11 = document.getElementById("selectId11");
	  var id12 = document.getElementById("selectId12");
	  var id13 = document.getElementById("selectId13");
	  var data2 = [ { name:"请选择...", id:"0" }];
	    screen1();
	    checkroll();
	   	check13(id1); 
	   	check14(id2);
	   	check15(id3);
	   	check16(id4);
	   	check17(id5);
	   	check18(id6);
	   	check19(id7);
	   	check20(id8);
	   	check21(id9);
	   	check22(id10);
	   	check23(id11);
	   	check24(id12);
	   	check25(id13);
   	
   	   	var meetingDetailID = document.getElementById("meetingDetailID").value; 	
   		McuHelpDwrMethod.checkMain(meetingDetailID,function (mainMark){
   		if(mainMark == true){
   		document.getElementById("slaveSlectId1").style.display = "none";
   		document.getElementById("slaveSlectId2").style.display = "none";
   		document.getElementById("slaveSlectId3").style.display = "none";
   		document.getElementById("slaveSlectId4").style.display = "none";
   		document.getElementById("slaveSlectId5").style.display = "none";
   		document.getElementById("slaveSlectId6").style.display = "none";
   		document.getElementById("slaveSlectId7").style.display = "none";
   		document.getElementById("slaveSlectId8").style.display = "none";
   		document.getElementById("slaveSlectId9").style.display = "none";
   		document.getElementById("slaveSlectId10").style.display = "none";
   		document.getElementById("slaveSlectId11").style.display = "none";
   		document.getElementById("slaveSlectId12").style.display = "none";
   		document.getElementById("slaveSlectId13").style.display = "none";
   		}else{
   		return;
   		}
   		});
   	*/
   	
   	/*
	*  select级联初始化
	*
	*/
   	
   function check13(id){
			if(id.value!="autoscan" && id.value!="auto"){
				
				var confID = document.getElementById("confID").value;
				
				McuHelpDwrMethod.getCasList(id.value,confID,callback13); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
			}
		}	
		
    function callback13(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
		    	return;
		    }
		}
		
	  function check14(id){
		 	if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback14); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId2');
	    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
			}
		}	
		
    function callback14(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId2');
	    		dwr.util.addOptions('slaveSlectId2', data2, "id", "name");
		    	return;
		    }
		}
	
	function check15(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback15); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId3');
	    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
			}
		}	
		
    function callback15(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId3');
	    		dwr.util.addOptions('slaveSlectId3', data2, "id", "name");
		    	return;
		    }
		}
			function check16(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback16); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
			}
		}	
		
    	function callback16(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId4');
	    		dwr.util.addOptions('slaveSlectId4', data2, "id", "name");
		    	return;
		    }
		}
		function check17(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback17); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
			}
		}	
		
    	function callback17(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId5');
	    		dwr.util.addOptions('slaveSlectId5', data2, "id", "name");
		    	return;
		    }
		}
		function check18(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback18); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
			}
		}	
		
    	function callback18(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId6');
	    		dwr.util.addOptions('slaveSlectId6', data2, "id", "name");
		    	return;
		    }
		}
		function check19(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback19); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
			}
		}	
		
    	function callback19(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId7');
	    		dwr.util.addOptions('slaveSlectId7', data2, "id", "name");
		    	return;
		    }
		}
		function check20(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback20); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
			}
		}	
		
    	function callback20(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId8');
	    		dwr.util.addOptions('slaveSlectId8', data2, "id", "name");
		    	return;
		    }
		}
		function check21(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback21); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");
			}
		}	
		
    	function callback21(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId9');
	    		dwr.util.addOptions('slaveSlectId9', data2, "id", "name");
		    	return;
		    }
		}
		function check22(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback22); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId10');
	    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");
			}
		}	
		
    	function callback22(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId10');
	    		dwr.util.addOptions('slaveSlectId10', data2, "id", "name");
		    	return;
		    }
		}
		function check23(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback23); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId11');
	    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");
			}
		}	
		
    	function callback23(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId11');
	    		dwr.util.addOptions('slaveSlectId11', data2, "id", "name");
		    	return;
		    }
		}
		function check24(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback24); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");
			}
		}	
		
    	function callback24(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId12');
	    		dwr.util.addOptions('slaveSlectId12', data2, "id", "name");
		    	return;
		    }
		}
		function check25(id){
			if(id.value!="autoscan" && id.value!="auto"){
				var confID = document.getElementById("confID").value;
				McuHelpDwrMethod.getCasList(id.value,confID,callback25); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");
			}
		}	
		
    	function callback25(lst){
	    	if(lst.length == 0){
	    		dwr.util.removeAllOptions('slaveSlectId13');
	    		dwr.util.addOptions('slaveSlectId13', data2, "id", "name");
		    	return;
		    }
		}
	
  </script>
</html>
