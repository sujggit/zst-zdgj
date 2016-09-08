/**
  *建立对象（user、dept、room、level）选择树
  *
  **/
  var u_ParametersArray = new Object();
  
  /**
   * 分级信息选择
   * @param thisDom
   * @param uParameters
   * @return
   */
  function creatLevelSelect(thisDom,uParameters){
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
 	    
 	   uParameters.splitString="-";
 	    u_ParametersArray = uParameters;
 	    var url ="";
 	    window.showModalDialog(url+"/icmp/system/portal/selectTree/select_level.jsp?splitString="+uParameters.splitString+"&optointype="+uParameters.selectType,window,"dialogHeight:578px;dialogWidth:650px");
 	   
 	 }