function htmlUtil(){
	this.title = function(var1,var2){
		var obj = document.getElementById(var1);
		obj.title = var2;
		obj.alt = var2;
	}
}

// ȫѡ��ѡ--��ͷȫѡ�򱻵���---03
function ChkA03Click(sonName, cbA03Id){
    var arrSon = document.getElementsByName(sonName);
 var cbA03 = document.getElementById(cbA03Id);
 var tempState=cbA03.checked;
 for(i=0;i<arrSon.length;i++) {
  if(arrSon[i].checked!=tempState)
           arrSon[i].click();
 }
}

// --���ѡ�򱻵���---
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