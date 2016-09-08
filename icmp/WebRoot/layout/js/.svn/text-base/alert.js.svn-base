
function showHidden(){
var report=document.getElementById("report");
report.style.display="none";
}

function showAlertDetail(id){
	//alert(id);
	var temp=parseInt(document.getElementById("total").innerHTML);
	if(temp==1){
		var report=document.getElementById("report");
		report.parentNode.removeChild(report);
		window.showModalDialog('/icmp/info/informationDetail.action?informationVO.infoID='+id,window,'dialogWidth=600px;dialogHeight=470px;');
	    
	}
	
	
	var CurrentLen=temp-1;
	document.getElementById("total").innerHTML=""+CurrentLen+"";
	var detailMes=document.getElementById(id);
	detailMes.parentNode.removeChild(detailMes);
	window.showModalDialog('/icmp/info/informationDetail.action?informationVO.infoID='+id,window,'dialogWidth=600px;dialogHeight=470px;');
    
	
}

function showHiddenByAll(){
	AlertDwrMethod.hidenAlertInfomation();
	var report=document.getElementById("report");
	report.parentNode.removeChild(report);
	}