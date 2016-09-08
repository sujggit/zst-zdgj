 
 /**
  *建立人员选择树
  *
  **/
 
  var d_ParametersArray = new Object();

 /**
  *人员选择1
  *
  **/
 function creatUserSelect(thisDom,peopleParameters){
    var parameter={
        height: 600,
        width: 520,
        top: event.screenY-100,
        left: event.screenX + 50
    }

    var x = parameter.left;
    var y = parameter.top;
    var scrollbars = parameter.scrollbars;
    var width= parameter.width;
    var height= parameter.height;
    var resizable = parameter.resizable;
    
    peopleParameters.splitString="-";
    d_ParametersArray = peopleParameters;
    var url ="";
    window.showModalDialog(url+"/icmp/system/portal/user/select_new.jsp?splitString="+peopleParameters.splitString+"&optointype="+peopleParameters.selectType,window,"dialogHeight:578px;dialogWidth:650px");
   
 }
 /**
  *人员选择2
  *
  **/
 function openUserSelectTwo(thisDom,peopleName,peopleID,splitString,optointype){
  
    var parameter={
        height: 600,
        width: 520,
        top: event.screenY-100,
        left: event.screenX + 50
    }
    
    var x = parameter.left;
    var y = parameter.top;
    var scrollbars = parameter.scrollbars;
    var width= parameter.width;
    var height= parameter.height;
    var resizable = parameter.resizable;
    var url ="";
   // window.open(url+"/system/portal/user/select.jsp?splitString="+splitString+"&optointype="+optointype+"&peopleName="+peopleName+"&peopleID="+peopleID,"人员选择","top=" + y + ",left=" + x + ",scrollbars=" + scrollbars + ",dialog=yes,minimizable=" + resizable + ",modal=yes,width=" + width + ",height=" + height + ",resizable=" + resizable);
 }
 
 /**
  * 人员与岗位选择
  * @param thisDom
  * @param peopleParameters
  * @return
  */
 function creatUserAndPostSelect(thisDom,peopleParameters){
	    var parameter={
	        height: 600,
	        width: 520,
	        top: event.screenY-100,
	        left: event.screenX + 50
	    }

	    var x = parameter.left;
	    var y = parameter.top;
	    var scrollbars = parameter.scrollbars;
	    var width= parameter.width;
	    var height= parameter.height;
	    var resizable = parameter.resizable;
	    
	    peopleParameters.splitString="-";
	    d_ParametersArray = peopleParameters;
	    var url ="";
	    window.showModalDialog(url+"/icmp/system/portal/user/selectUserAndPost.jsp?splitString="+peopleParameters.splitString+"&optointype="+peopleParameters.selectType,window,"dialogHeight:490px;dialogWidth:560px");
	   
	 }
 /**
  *人员选择1(所有)
  *
  **/
 function creatUserSelAll(thisDom,peopleParameters){
    var parameter={
        height: 600,
        width: 520,
        top: event.screenY-100,
        left: event.screenX + 50
    }

    var x = parameter.left;
    var y = parameter.top;
    var scrollbars = parameter.scrollbars;
    var width= parameter.width;
    var height= parameter.height;
    var resizable = parameter.resizable;
    
    peopleParameters.splitString="-";
    d_ParametersArray = peopleParameters;
    var url ="";
    window.showModalDialog(url+"/icmp/system/portal/user/select_user_level.jsp?splitString="+peopleParameters.splitString+"&optointype="+peopleParameters.selectType,window,"dialogHeight:578px;dialogWidth:650px");
   
 }