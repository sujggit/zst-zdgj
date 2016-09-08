function check(id){
	$("#button").attr("disabled",true);
	var a=document.getElementById(id);
	
	if(a.value==""||a.value==null){
		$("#button").attr("disabled","");	
	  return;
	}
	DwrMethod.checkEquipmentIP(a.value,callback);
}
	
function callback(lst){
	if(lst.length>0){
		alert("此设备的IP已被占用");
		document.getElementById("ip").value="";
		
	}
	$("#button").attr("disabled","");
}

function checkNames(tempids,currName){
	$("#button").attr("disabled",true);
	var tempName=document.getElementById(tempids).value;
	if(tempName==""||tempName==null||tempName==currName){
		$("#button").attr("disabled","");	
	  return;
	}
	DwrMethod.checkEquipmentNameBoolean(tempName,function(liboolean){
		if(liboolean){
			alert('此设备名称被占用!');
			document.getElementById(tempids).value="";
			
		}
		$("#button").attr("disabled","");
	});	
}

function checkCommandIP(commndIP){
	$("#button").attr("disabled",true);
	var a=document.getElementById(commndIP);
	if(a.value==""||a.value==null){
		$("#button").attr("disabled","");	
	  return;
	}
	DwrMethod.checkEquipmentIP(a.value,callbackCommandIP);
}
	
function callbackCommandIP(lst){
  if(lst.length>0){
	alert("此设备连接IP已被占用");
	document.getElementById("commandIP").value="";
	
  }
  $("#button").attr("disabled","");
}


function checkTerIP(id){
	$("#button").attr("disabled",true);
		  var a=document.getElementById(id);
		  var radioTreaty = document.getElementById("radioTreaty")
		  
		  if(radioTreaty.value!="e164"){
			if(a.value == "0.0.0.0"){
	   			if(confirm("只有通信协议为E.164才能将IP填写为'0.0.0.0'，是否将通信协议修改为E.164？")){
				radioTreaty.value="e164";
				a.disabled = true;
			}else{
				a.value = "";
			}
	   		}
	   	  }else{
		alert("通信协议为E.164时，不能修改IP");
		a.value="0.0.0.0";
		a.disabled = true;
		
	   	  }
		  
		  if(a.value==""||a.value==null || a.value=="0.0.0.0"){
			  $("#button").attr("disabled","");	
				return;
			}
		    DwrMethod.checkEquipmentIP(a.value,terIPcallback);
		}
			
	    function terIPcallback(lst){
	    	if(lst.length > 0){
	    	alert("此设备IP已被占用");
	    	document.getElementById("ip").value="";  	
	    	}		
	    	$("#button").attr("disabled","");
		}