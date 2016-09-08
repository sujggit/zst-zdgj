 
   var d_xxx = new Object();
   
   
 
 
 //   function  swhUploadFile(element){
 //     alert("OK");
//	   var param = {
//	          	methodName:'finish',
//	          	excuteFileType:''
//				
//	          };
//	 creatUploadFile(element,param); 
// }  

    function  swhUploadFile(element,param){
	//   var departParameters = {
	//          	methodName:'finish',
	//          	selectedDepart:'',
	//			selectType:'multiple'
	//          }
	
	 creatUploadFile(element,param); 
 }
 function creatUploadFile(thisDom,param){
    var parameter={
        height: 300,
        width: 400,
        top: event.screenY-100,
        left: event.screenX + 50,
        scrollbars: "no",
        resizable: "no"
    };
    var x = 500 ; //parameter.left;300
    var y = 300 ;//parameter.top;500
    var scrollbars = parameter.scrollbars;
    var width= parameter.width;
    var height= parameter.height;
    var resizable = parameter.resizable;
    d_xxx = param;
    var url ="/icmp";
 
   // window.showModalDialog(url+"/plug-in/uploadfile/upload.jsp?methodName="+param.methodName+"&excuteFileType="+param.excuteFileType,"文件上传","dialogWidth=300px;dialogHeight=300px",'${swh_showModalDialogCss}');
    window.open(url+"/plug-in/uploadfile/upload.jsp?methodName="+param.methodName+"&excuteFileType="+param.excuteFileType,"文件上传","top=" + y + ",left=" + x + ",scrollbars=" + scrollbars + ",dialog=yes,minimizable=" + resizable + ",modal=yes,width=" + width + ",height=" + height + ",resizable=" + resizable);
   //  window.open(url+"/plug-in/uploadfile/upload.jsp?splitString="+splitString+"&optointype="+param.selectType); 
  }