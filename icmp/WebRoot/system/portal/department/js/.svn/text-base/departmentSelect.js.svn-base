

 var d_ParametersArray = new Object();
 function creatDepartmentSelect(thisDom,param){
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
    splitString = "-";
    d_ParametersArray = param;
    var url ="";
    //window.open(url+"/system/portal/department/select.jsp?splitString="+splitString+"&optointype="+param.selectType,"部门选择","top=" + y + ",left=" + x + ",scrollbars=" + scrollbars + ",dialog=yes,minimizable=" + resizable + ",modal=yes,width=" + width + ",height=" + height + ",resizable=" + resizable);
    window.showModalDialog(url+"/icmp/system/portal/department/select_new.jsp?splitString="+splitString+"&optointype="+param.selectType,window,"dialogHeight:576px;dialogWidth:650px");
 }