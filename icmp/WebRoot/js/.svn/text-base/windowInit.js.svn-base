/**
 *页面初始化js
 */
 var initWindow = new Object();
 initWindow.init = function(){
     var topDiv = document.getElementById("topDiv");
	 var addTopDiv = document.getElementById("addTopDiv");
     var bodyWidth = document.body.clientWidth;

     if(topDiv){
         topDiv.style.width =bodyWidth+"px";
     }
	 if(addTopDiv){
         addTopDiv.style.width = bodyWidth+"px"; 
     }
 }

  $(document).ready(function(){ 
       initWindow.init();
   }); 
  
  function htmlUtil(){
		this.title=function(var1,var2){
			var obj = document.getElementById(var1);
			obj.title=var2;
			obj.alt=var2;
		};
		this.style_cursor = function(var1,var2){
			var obj = document.getElementById(var1);
			obj.style.cursor=var2;
		}
	}
  
//全选反选--列头全选框被单击---03
  function ChkA03Click(sonName, cbA03Id){
      var arrSon = document.getElementsByName(sonName);
	  var cbA03 = document.getElementById(cbA03Id);
	  var tempState=cbA03.checked;
	  for(var i=0;i<arrSon.length;i++) {
      if(arrSon[i].checked!=tempState)
          arrSon[i].click();
     }
  }

  // --子项复选框被单击---
  function ChkSonClick(sonName, cbA03Id) {
   var arrSon = document.getElementsByName(sonName);
   var cbA03 = document.getElementById(cbA03Id);
   for(var i=0; i<arrSon.length; i++) {
       if(!arrSon[i].checked) {
       cbA03.checked = false;
       return;
       }
   }
   cbA03.checked = true;
  }
