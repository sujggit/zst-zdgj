function switchSysBar(id,tid) {
        var innerText = document.getElementById(id).showstate;
        if (innerText == 3) {
            document.getElementById(id).showstate = 4
            document.getElementById(id).style.display = "none";
            $("#"+tid).find("img").attr("src",$("#"+tid).find("img").attr("src")=="<%=MeetingConfig.CONTENT_PATH%>images/left_nav.gif"?"<%=MeetingConfig.CONTENT_PATH%>images/right_nav.gif":"<%=MeetingConfig.CONTENT_PATH%>images/left_nav.gif");
		}
        else {
            document.getElementById(id).showstate = 3
            document.getElementById(id).style.display = "";
			$("#left_nav").attr("src","<%=MeetingConfig.CONTENT_PATH%>images/left_nav.gif");
            $("#"+tid).find("img").attr("src",$("#"+tid).find("img").attr("src")=="<%=MeetingConfig.CONTENT_PATH%><%=MeetingConfig.CONTENT_PATH%>images/left_nav.gif"?"<%=MeetingConfig.CONTENT_PATH%>images/right_nav.gif":"<%=MeetingConfig.CONTENT_PATH%>images/left_nav.gif");
        }
    }
	
 function AXzhz(hideme)
 {
  var AX=document.all(hideme); //����һ������
  AX.style.display=AX.style.display=="none"?"":"none"; //�ж��Ƿ�����
  if($("#"+hideme).css("display")=="none")
  {
  	$("#show1").attr("class","leftczbghide");
  }
  else
  {
  	$("#show1").attr("class","leftczbg");

  }
 }

 function AXzhzNew(showme,className)
 {

  $("."+className).hide();
  $("#"+showme).show();
 } 
  function iframeAutoFit()
   {
      try
      {
         if(window!=parent)
         {
          var a = parent.document.getElementsByTagName("IFRAME");
            for(var i=0; i<a.length; i++) //author:meizz
            {
               if(a[i].contentWindow==window)
               {
                   var h = document.body.scrollHeight;
                   if(document.all) {h += 4;}
                   if(window.opera) {h += 1;}
                   a[i].style.height = h;
               }
            }
         }
      }
      catch (ex)
      {
         alert("�ű��޷����������");
      }
   }
   if(document.attachEvent)  window.attachEvent("onload",  iframeAutoFit);  
   else  window.addEventListener('load',  iframeAutoFit,  false);
   
//�б�
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}

//����Ӧ�߶�
function SetCwinHeight(){
var frmright=document.getElementById("frmright"); //iframe id
if (document.getElementById){
   if (frmright && !window.opera){
    if (frmright.contentDocument && frmright.contentDocument.body.offsetHeight){
     frmright.height = frmright.contentDocument.body.offsetHeight+20;
    }else if(frmright.Document && frmright.Document.body.scrollHeight){
     frmright.height = frmright.Document.body.scrollHeight+20;
    }
   }
}
}

//select�б��

function AjaxSelectBox(v){
 var dl = v.parentNode;
 var dd = dl.getElementsByTagName("dd")[0];
 var dt = dl.getElementsByTagName("dt")[0];
 var lis = dl.getElementsByTagName("li");
 var html = '';
 for(var y=0; y<lis.length; y++){   
  html += '<li onclick="SetSelectInput(this,1);" onmouseout="SetSelectInput(this,2);" onmousemove="SetSelectInput(this,3);" value="'+lis[y].value+'">' + lis[y].innerHTML + '</li>';
 }
 dl.getElementsByTagName("ul")[0].innerHTML = html;
 dd.style.display = "block";
 dl.onmouseout = function() {dd.style.display = "none";}
 dd.onmouseover = function() {dd.style.display = "block";}
}

function SetSelectInput(v,flag){
 var dl = v.parentNode;
 while(dl.nodeName != 'DL'){
  dl = dl.parentNode;
 }
 var input = dl.getElementsByTagName("input")[0];
 var dd = dl.getElementsByTagName("dd")[0]; 
 var dt = dl.getElementsByTagName("dt")[0]; 
 dd.onmouseover = function() {dd.style.display = "block";}
 v.onmouseover = function() {dd.style.display = "block";} 
 dd.onmouseout = function() {dd.style.display = "none"} 
 if(flag == 1){
  input.value = v.attributes.getNamedItem("value").value;
  
  dd.style.display = "none";
 } else if(flag == 2){
  v.className = 'out'; return; 
 } else{
  v.className = 'move'; return; 
 }  
}