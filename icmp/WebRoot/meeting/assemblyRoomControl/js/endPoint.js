



var ENDPOINT = {
   init:function(){
       
       document.getElementById("PIP").onclick=function(){  sendCommand("COMMAND_PIP"); };
       document.getElementById("CAM").onclick=function(){sendCommand("COMMAND_CAMERA");}
       document.getElementById("NUM1").onclick=function(){sendCommand("COMMAND_NUM_1");}
       document.getElementById("NUM2").onclick=function(){sendCommand("COMMAND_NUM_2");}
       document.getElementById("NUM3").onclick=function(){sendCommand("COMMAND_NUM_3");}
       document.getElementById("NUM4").onclick=function(){sendCommand("COMMAND_NUM_4");}
       document.getElementById("NUM5").onclick=function(){sendCommand("COMMAND_NUM_5");}
       document.getElementById("NUM6").onclick=function(){sendCommand("COMMAND_NUM_6");}
       document.getElementById("NUM7").onclick=function(){sendCommand("COMMAND_NUM_7");}
       document.getElementById("NUM8").onclick=function(){sendCommand("COMMAND_NUM_8");}
       document.getElementById("NUM9").onclick=function(){sendCommand("COMMAND_NUM_9");}
       document.getElementById("NUM0").onclick=function(){sendCommand("COMMAND_NUM_0");}
       document.getElementById("NUM*").onclick=function(){sendCommand("COMMAND_NUM_XIN");}
       document.getElementById("NUM#").onclick=function(){sendCommand("COMMAND_NUM_JIN");}
       
       document.getElementById("CONTENT").onclick=function(){sendCommand("COMMAND_GRAPHICS");}
       document.getElementById("INFO").onclick=function(){sendCommand("COMMAND_INFO");}
       document.getElementById("LEFT").onclick=function(){sendCommand("COMMAND_LEFT");}
       document.getElementById("RIGHT").onclick=function(){sendCommand("COMMAND_RIGHT");}
       document.getElementById("ENTER").onclick=function(){sendCommand("COMMAND_SELECT");}
       document.getElementById("BOTTOM").onclick=function(){sendCommand("COMMAND_DOWN");}
       document.getElementById("UP").onclick=function(){sendCommand("COMMAND_UP");}
       
       document.getElementById("FAR").onclick=function(){sendCommand("COMMAND_FAR");}
       document.getElementById("NEAR").onclick=function(){sendCommand("COMMAND_NEAR");}
       document.getElementById("RETURN").onclick=function(){sendCommand("COMMAND_BACK");}
       document.getElementById("CATALOG").onclick=function(){sendCommand("COMMAND_DIRECTORY");}
       document.getElementById("HOME").onclick=function(){sendCommand("COMMAND_HOME");}
       
       document.getElementById("KEYBOARD").onclick=function(){sendCommand("COMMAND_KEYBOARD");}
       document.getElementById("DELETE").onclick=function(){sendCommand("COMMAND_DELETE");}
       document.getElementById("MUTE").onclick=function(){sendCommand("COMMAND_MUTE");}
       document.getElementById("POINT").onclick=function(){sendCommand("COMMAND_PERIOD");}
       
       document.getElementById("DAIL").onclick=function(){sendCommand("COMMAND_DAILUP");}
       document.getElementById("HANGUP").onclick=function(){sendCommand("COMMAND_HANGUP");}
       
   }

}

//画中画
function sendCommand(command){
   
   var meetingRoomID = window.parent.currentMeetingRoomID;
   var equipmentID = window.parent.currentEquipmentID;
  
   ControlAction.sendCommand(equipmentID,command,calback);
}
function calback(lst){
  // alert("返回："+lst);
}