var manager = 0;
var cellNo=1;//分组表示列td_Mcu
var list = new Array();
function listGroup() {
	var onlyTd = new Array()
	list = document.getElementById("meetinglistTable").rows;
	for ( var i = 0, j = 0; i < list.length; i++) {
		var td = list[i].cells[cellNo].innerHTML
		if (jQuery.inArray(td, onlyTd) < 0) {
			onlyTd[j] = td;
			j++;
		}
	}

	for ( var i = 0; i < onlyTd.length; i++) {

		var trow = new Array();
		for ( var j = 0, t = 0; j < list.length; j++) {
			var td = list[j].cells[cellNo].innerHTML;
			if (td == onlyTd[i]) {
				trow[t] = list[j];
				t++;
			}
		}
		// alert(onlyTd[i]);
		if (trow.length > 1) {
			for ( var e = 0; e < trow.length; e++) {
				if (e > 0) {
					trow[e].style.display = "none";
				}else{
					trow[e].cells[cellNo].className="topcss";
				}
			}
		}

	}

}

function opentd(std) {
	var tdcon=std.innerHTML;
	for ( var i = 0; i < list.length; i++) {
		var td = list[i].cells[cellNo].innerHTML;
		list[i].onselectstart = list[i].ondrag = function(){return false;};
		if (td == tdcon) {
			list[i].style.display = "block";
			list[i].cells[cellNo].className="td_Mcu";
		}
	}
}

function closetd(std) {
	var tdcon=std.innerHTML;
	var trow = new Array();
	for ( var j = 0, t = 0; j < list.length; j++) {
		var td = list[j].cells[cellNo].innerHTML;
		if (td == tdcon) {
			trow[t] = list[j];
			t++;
		}
	}
	if (trow.length > 1) {
		for ( var e = 0; e < trow.length; e++) {
			if (e>0){
				trow[e].style.display = "none";	
			}else{
				trow[e].cells[cellNo].className="topcss";
			}
		}
	}
}
