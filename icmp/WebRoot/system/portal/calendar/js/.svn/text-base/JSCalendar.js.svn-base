
var _parent = window.opener;
if(!_parent){
  _parent = window.parent;
}
if(window.dialogArguments){
	_parent = window.dialogArguments;
}

var _cldTabIFrame = null;
var _cldTabIFrame2 = null;

var _cldTabFrm = null;
var _cldMonthMenuFrm = null;
var _curCldTabRltvObj = null;
var _bCanHide = true;
var _bHaveUpdated = false;
var _bHaveShown = false;

var _bHaveSelectNewValue = false;

var _dCurYear = null;
var _dCurMonth = null;
var _dCurDate = null;

var _originalHour = null;
var _originalMinute = null;

var _curCldTabRltvObjValue = "";

/**
  * �ڸ�����ؼ��У��Ҳ����˸�ռ���Χ������Ӱ��4��ǿ�ؼ����Ӿ�С�
  * _nShadowLength ���趨����Ӱ��ĳ��ȣ�Ĭ��ֵΪ 4��
  * ʹ����Ӱ�㽫��Ӧ���ͻ�����������ٶȣ��������õ��Ͽ�������ٶȣ��뽫��ֵ��Ϊ 0
  */
var _nShadowLength = 4;

var nowClickSrcElement = null;

/**
  * _sNeededFilePath ���趨��JSCalendar�ؼ�����������ļ���λ��
  * ���㽫���Ӧ�ò���Ӧ�÷������Ϻ�����Ҫ��ı��趨��Ӧ��ֵ��
  * ���磺
  *		_sNeededFilePath = "/MyWebAPP/comm/js/JSCalendar/";
  *
  * �ñ���ֵ������ȷ���ã���������������п��ܳ��ִ��� 
  */
var _sNeededFilePath = "../calendar/images/";//图片路径
var _sNeededCssPath  = "../calendar/style/";//css 路劲
/**
  * ��������ͼƬ
  * 
  */
var _imgReset1 = new Image();
	_imgReset1.src = _sNeededFilePath + "reset1.gif";
var _imgReset2 = new Image();
	_imgReset2.src = _sNeededFilePath + "reset2.gif";
var _imgBtnYear = new Image();
	_imgBtnYear.src = _sNeededFilePath + "btnYears.gif";
var _imgBgToday1 = new Image();
	_imgBgToday1.src = _sNeededFilePath + "bgToday1.gif";

var _monthDays = new Array(12);
    _monthDays[ 0] = 31;
    _monthDays[ 1] = 28;
    _monthDays[ 2] = 31;
    _monthDays[ 3] = 30;
    _monthDays[ 4] = 31;
    _monthDays[ 5] = 30;
    _monthDays[ 6] = 31;
    _monthDays[ 7] = 31;
    _monthDays[ 8] = 30;
    _monthDays[ 9] = 31;
    _monthDays[10] = 30;
    _monthDays[11] = 31;
var _weeks = new Array(7);

for(var i=0; i<7; i++) {
	_weeks[i] = _parent.v3x.getMessage("V3XLang.calendar_weeks" + i);
	
}
	//add by wangrl
	_weeks[0]="六";
	_weeks[1]="一";
	_weeks[2]="二";
	_weeks[3]="三";
	_weeks[4]="四";
	_weeks[5]="五";
	_weeks[6]="日";
	
var _months = new Array(12);
for(var i=0; i<12; i++) {
	_months[i] = _parent.v3x.getMessage("V3XLang.calendar_months" + i);
}
	
var _dftD = new Date();

function JSCalendar(rltvO, year, month, date, hour, minute){
	_originalHour = hour;
	_originalMinute = minute;
	
	if(_bHaveUpdated && rltvO == _curCldTabRltvObj) return;
	if(rltvO.tagName != "INPUT"){alert("JSCalendar 1.0 alerts you:\n\n INPUT element(object) must be required!");return};
	rltvO.readOnly = true;
	rltvO.style.cursor = "default";
	rltvO.style.textAlign = "center";
	_curCldTabRltvObjValue = rltvO.value;
	_bHaveSelectNewValue = false;
	//------------------------------------------------------------------------------
	this.createCldTabFrm = createCldTabFrm;	
	this.fillCldTabFrm = fillCldTabFrm;
	this.placeCldTabFrm = placeCldTabFrm;
	//------------------------------------------------------------------------------
	
	this._rltvO = (rltvO == null ? document.body : rltvO);
	var _oldDate = rltvO.value;
	var _oldDateType = "From Input!";

	this._year = (year == null ? _dftD.getFullYear() : year);
	this._month = (month == null ? _dftD.getMonth() : month - 1);;
	this._date = (date == null ? _dftD.getDate() : date);

	_dCurYear = this._year;
	_dCurMonth = this._month;
	_dCurDate = this._date;

	if(_cldTabIFrame == null)
		this.createCldTabFrm();
		
	_cldTabIFrame2.style.display = "inline";
	
	this.fillCldTabFrm(this._year, this._month, this._date);
	if(!_bHaveShown || rltvO != _curCldTabRltvObj) this.placeCldTabFrm();
	
	MakeDivShadowEffect(_cldTabFrm, '#aaaaaa', _nShadowLength);
	_curCldTabRltvObj = this._rltvO;
	
	_bHaveUpdated = true;
	_bHaveShown = true;
	
	setTargetFormaValue(_dCurYear, _dCurMonth + 1, nowClickSrcElement.innerText);
}

function createCldTabFrm(){
	var _sz = "<HTML>"
			+ "<HEAD><link href='" +_sNeededCssPath + "JSCalendar.css' rel=stylesheet type='text/css'></HEAD>"
			+ "<BODY leftmargin=0 topmargin=0 rightmargin=0 bottommargin=0 style='background-color:transparent;border:0px solid black;scroll:no'>"
			+ "</BODY></HTML>";
	_cldTabIFrame = frm;
	_cldTabIFrame2 = document.all("frm");
	_cldTabIFrame2.style.position = "absolute";

	
	_cldTabIFrame.document.open("text/html","replace");
	_cldTabIFrame.document.write(_sz);
	_cldTabIFrame.document.close();
	_cldTabFrm = _cldTabIFrame.document.createElement("TABLE");
	_cldTabFrm.id = "JACKSHANGJIELOVEFEIFEI"
	_cldTabFrm.style.position = "absolute";
	_cldTabFrm.className = "calendar";
	_cldTabFrm.border = 0;
	_cldTabFrm.cellSpacing = 0;
	_cldTabFrm.cellPadding = 0;
	_cldTabFrm.bgColor = "ffffff";
	_cldTabFrm.attachEvent("onmouseover", whenMouseOverCldTabFrm);
	_cldTabFrm.attachEvent("onmouseout", whenMouseOutCldTabFrm);
	var _TR = _cldTabFrm.insertRow();
	var _TD = _TR.insertCell();
	_TD.colSpan = 7;
	_TD.align = "center";
	_TD.height = "22px";
	_TD.innerHTML = "&nbsp;";
	for(var i = 0; i < 7; i++){
		_TR = _cldTabFrm.insertRow();
		for(var j = 0; j < 7; j++){
			_TD = _TR.insertCell();
			_TD.className="week";
			_TD.style.cursor = "default";
			_TD.align = "center";
			_TD.innerHTML = "*";
			if(i != 0){
				_TD.style.cursor = "hand";
				//_TD.attachEvent("onmouseover", whenMouseOverDateItem);
				//_TD.attachEvent("onmouseout", whenMouseOutDateItem);
				if(Parameters.state==0){
				    _TD.attachEvent("onclick", whenMouseOverDateItem);
				    _TD.attachEvent("ondblclick", ok);
				}
			}	
			
			if(i == 0) _TD.innerHTML = "<b>" + _weeks[j] + "</b>";//普通日期 weeks[j]存放了周信息
			if(i == 0 && (j == 0 || j == 6)) _TD.className = "tdHoliday";//周六周日
		}
	}
	// Create footer
	_TR = _cldTabFrm.insertRow(2);
	_TD = _TR.insertCell();
	_TD.colSpan = 7;
	_TD.height = 1;
	//_TD.bgColor = "black";
	
	if(Parameters && Parameters.type == "datetime"){
		_TR = _cldTabFrm.insertRow();
		_TD = _TR.insertCell();
		_TD.colSpan = 7;
		_TD.innerHTML = getTimeTableHTML();
	}
	
	_TR = _cldTabFrm.insertRow();
	_TD = _TR.insertCell();
	_TD.colSpan = 7;
	 if(Parameters.state==1){
			_TD.innerHTML = "<table cellspacing=0 cellpadding=0 class=calendar style='border:0px solid;width:100%'>"
				+ "<tr><td style='cursor:hand' onclick=\"parent._bHaveUpdated=false;parent.setTargetFormaValue(" + _dftD.getFullYear() + "," + (_dftD.getMonth() + 1) + "," + _dftD.getDate() + ");parent.fillCldTabFrm(" + _dftD.getFullYear() + "," + _dftD.getMonth() + "," + _dftD.getDate() + ");\">"
				+ "<b>&nbsp;<img src='" + _imgBgToday1.src + "' width=30px>"+_parent.v3x.getMessage('V3XLang.calendar_today')+" : " + _dftD.getFullYear() + "-" + (_dftD.getMonth() + 1) + "-" + _dftD.getDate()
				+ "</td>"
		//		+ "<td width=30px style='cursor:hand' onclick=parent.resetTargetValue() title='"+_parent.v3x.getMessage("V3XLang.calendar_close")+"'>"
		//		+ "<img src='" + _imgReset1.src + "' onmouseover=this.src='" + _imgReset2.src + "' onmouseout=this.src='" + _imgReset1.src + "'></td>"
		      

				+ "<td align=right class=smallFont></td></tr></table>";
	}else{
			_TD.innerHTML = "<table cellspacing=0 cellpadding=0 class=calendar style='border:0px solid;width:100%'>"
				+ "<tr><td style='cursor:hand' onclick=\"parent._bHaveUpdated=false;parent.setTargetFormaValue(" + _dftD.getFullYear() + "," + (_dftD.getMonth() + 1) + "," + _dftD.getDate() + ");parent.fillCldTabFrm(" + _dftD.getFullYear() + "," + _dftD.getMonth() + "," + _dftD.getDate() + ");\">"
				+ "<b>&nbsp;<img src='" + _imgBgToday1.src + "' width=30px>"+_parent.v3x.getMessage('V3XLang.calendar_today')+" : " + _dftD.getFullYear() + "-" + (_dftD.getMonth() + 1) + "-" + _dftD.getDate()
				+ "</td>"
		//		+ "<td width=30px style='cursor:hand' onclick=parent.resetTargetValue() title='"+_parent.v3x.getMessage("V3XLang.calendar_close")+"'>"
		//		+ "<img src='" + _imgReset1.src + "' onmouseover=this.src='" + _imgReset2.src + "' onmouseout=this.src='" + _imgReset1.src + "'></td>"
		      
		      
		         
				  + "<td width=40px  style='cursor:pointer;font-size:15px;' onclick='parent.ok()'>确定&nbsp;&nbsp;</td>"
				  + "<td width=40px  style='cursor:pointer;font-size:15px;' onclick='parent.closeCalendar()'>取消&nbsp;&nbsp;</td>"
				  + "<td width=40px  style='cursor:pointer;font-size:15px;' onclick='parent.ok1()'>清空&nbsp;&nbsp;</td>"
				
				+ "<td align=right class=smallFont></td></tr></table>";
	
	}
	_cldTabIFrame.document.body.insertBefore(_cldTabFrm);
}

function monthToSelector(c){
	var s = "<select onchange='parent.inputMonth(this)'>";
	for(var i = 0; i < 12; i++) {
	var n = i+1;
		s += "<option value='" + i + "' " + (_dCurMonth == i ? 'selected' : '') + ">" + n+ "</option>";
	}
	s += "<select>";
	
	return s;
}

function fillCldTabFrm(year, month, date){
	var dCurDate = 0;
	var dNextMonthDate = 1;
	var iDateStartRow = 3;
	var _d = new Date(year, month, 1);
	var _day = _d.getDay();
	var _td = null;

	_dCurYear = year;
	_dCurMonth = month;
	_dCurDate = date;

	if (((_dCurYear % 4 == 0) && !(_dCurYear % 100 == 0))
		||(_dCurYear % 400 == 0)) _monthDays[1] = 29;
	else _monthDays[1] = 28;
			
	_cldTabFrm.rows(0).cells(0).innerHTML
	 = "<table  class=calendar id=fillCalendar style=\"font-weight:bolder;border:0px;border-bottom:1px solid #85B4E1;width:100%;height:24px;\" cellspacing=0 cellpadding=0>"
		+ "<tr class=\"calendarTitle\"><td align=right>"
		+ "&nbsp;<a style='cursor:hand;width:10px;' title='"+_parent.v3x.getMessage("V3XLang.calendar_last_month")+"' onclick=\"parent.switchLastMonth()\" style='color:#000;font-size:11px;'><img border=0 align=absMiddle src='leftMounth.gif' style='height:7px;width:11px;'></a>"
		+ "</td>"
		+ "<td align=center vAlign=middle style='color:#ffffff'>"
		
		+ " <input type='text' readonly maxlength='4' class='year-input' onfocus='this.select()' onkeyup='parent.inputYear1(this)' onchange='parent.inputYear(this);' value='" + _dCurYear + "'>"
		+ "&nbsp;<img border=0 align=absMiddle src='" + _imgBtnYear.src + "' style='height:11px;width:8px;margin-right:17px;' usemap=#mapForBtnYears>"
		+ "<map name=mapForBtnYears><area title='"+_parent.v3x.getMessage("V3XLang.calendar_next_year")+"' href='Javascript:parent.switchLastYear()' shape=rect coords=0,0,10,5><area title='"+_parent.v3x.getMessage("V3XLang.calendar_last_year")+"' href='Javascript:parent.switchNextYear()' shape=rect coords=0,5,10,15></map>"		
		+ "" + monthToSelector() + "" 
		
		
		+ "</td>"
		+ "<td align=left>"
		+ "<a style='cursor:hand' title='"+_parent.v3x.getMessage("V3XLang.calendar_next_month")+"' onclick=\"parent.switchNextMonth()\" style='color:#000;font-size:11px;'><img border=0 align=absMiddle src='rightMounth.gif' style='height:7px;width:11px;'></a>&nbsp"
		+ "</td></tr></table>"
			
	_day = (_day == 0 ? 7 : _day);
	
	for(var i = _day - 1, dlt = 0; i >= 0; i--){
		_td = _cldTabFrm.rows(iDateStartRow).cells(i);
		_td.className = "lastMonth";
		_td.title = "";
		_td.name = "LASTMONTH";
		_td.style.backgroundColor = "transparent";
		_td.style.border = "0px solid";
		var _nextMonth = _dCurMonth - 1;
		if(_nextMonth < 0) _nextMonth = 11;
		_td.innerText = (_monthDays[_nextMonth] - (dlt++));
	}
	i = _day;
	for(var d = 1, iRow = iDateStartRow; d <= _monthDays[_dCurMonth] || iRow < 9; ){
		for(; i < 7; i++){
			dCurDate = d++;
			_td = _cldTabFrm.rows(iRow).cells(i);
			_td.disabled = false;
			_td.className = "normal";
			_td.name = "CURRENTMONTH";
			_td.style.backgroundColor = "transparent";
			_td.style.border = "0px solid";
			if(i == 0 || i == 6) _td.className = "tdHoliday2";
			
			if(d - 1 > _monthDays[_dCurMonth]){
				dCurDate = dNextMonthDate++;
				_td.className = "nextMonth";
				_td.name = "NEXTMONTH";
			}
			
			_td.innerHTML = dCurDate;
			
			if(dCurDate == _dCurDate && _td.name == "CURRENTMONTH"){
				_cldTabFrm.rows(iRow).cells(i).className = "tdCurDate";
			
				if(!nowClickSrcElement){
					nowClickSrcElement = _td;
				}
			}	
			if(dCurDate == _dftD.getDate() 
				&& _dCurMonth == _dftD.getMonth() 
				&& _dCurYear == _dftD.getFullYear()
				&& _td.name == "CURRENTMONTH"){
				_cldTabFrm.rows(iRow).cells(i).className = "tdToday";
				
				if(dCurDate == _dCurDate)
					_cldTabFrm.rows(iRow).cells(i).className = "tdTodayCurDate";
			}			
		}
		i = 0;
		iRow++;
	}
}


function getTimeTableHTML(nowHours, nowMinutes){
	if(!nowHours){
		nowHours = new Date().getHours();
	}
	if(!nowMinutes){
		nowMinutes = new Date().getMinutes();
	}
	
	var i = 0;
	var isNowHours = "";
	var isNowMinute = "";

	var allStr = "";
	allStr += '<table border="0" cellspacing="0" cellpadding="0">';
	allStr += ' <tr>';
	allStr += ' <td width=10>&nbsp;</td>';
	allStr += ' <td width=40>时间:</td>';
	allStr += ' <td>';
	allStr += ' <select name="timeHours" id="timeHours" style="width: 50px" onchange="parent.changeTime()">';

	//for(i=0; i<24; i++) //小时设置
	for(i=0; i<24; i++)
	{   
		//modify by wangrl
		//isNowHours = (i==nowHours || i == _originalHour) ? " selected" : "";
		//alert(_originalHour);
		if(_originalHour==null){
		    isNowHours = (i == nowHours) ? " selected" : "";
		}else{
			isNowHours = (i == _originalHour) ? " selected" : "";
		}
		allStr += '<option value="' + (i < 10 ? "0" + i : i) + '"' + isNowHours + '>' + (i < 10 ? "0" + i : i) + '</option>';
	}

	allStr += ' </select>';
	allStr += ' </td>';
	allStr += ' <td width=30>时</td>';
	allStr += ' <td>';
	allStr += " <select name='timeMinutes' id='timeMinutes' style='width: 50px' onchange='parent.changeTime()'>";

	//for(i=0;i<60;i++) //分钟设置
	for(i = 0;i < 60; i += 10)
	{
		//isNowMinute = (i==nowMinutes || i == _originalMinute) ? " selected" : "";
		if(_originalMinute==null){
			isNowMinute = (i==nowMinutes) ? " selected" : "";
		}else{
		   isNowMinute = (i == _originalMinute) ? " selected" : "";
		}
		allStr += '<option value="' + (i < 10 ? "0" + i : i) + '"' + isNowMinute + '>' + (i < 10 ? "0" + i : i) + '</option>';
	}

	allStr += ' </select>';
	allStr += ' </td>';
	allStr += ' <td>分</td>';
	allStr += ' </tr>';
	allStr += '</table>';
	
	
	return allStr;
}


function placeCldTabFrm(){
	
	var _rect = this._rltvO.getBoundingClientRect();
	var _bodyWidth = document.body.clientWidth;
	var _bodyHeight = document.body.clientHeight;
	
	var _tmp = _cldTabIFrame;
	_cldTabIFrame = _cldTabIFrame2;

	var _innerTabFrmRect = _cldTabFrm.getBoundingClientRect();

	var _cldTabFrmRect = _cldTabIFrame.getBoundingClientRect();

	_cldTabIFrame = _tmp;
}

function whenMouseOverCldTabFrm(){
	_bCanHide = false;
}

function whenMouseOutCldTabFrm(){
	_bCanHide = true;
}

function getNextDate(year, month, date){
	if(date == null) date = 1;
	if(date > _monthDays[month + 1]) date = _monthDays[month + 1];
	
	return new Date(year, month + 1, date);
}

function getLastDate(year, month, date){
	if(date == null) date = 1;
	if(date > _monthDays[month - 1]) date = _monthDays[month - 1];
	return new Date(year, month - 1, date);
}
function switchLastMonth(bLast){
 
	if(bLast == null) bLast = true;
	var _tmpdate = null;
	
	_tmpdate = bLast ? getLastDate(_dCurYear, _dCurMonth, _dCurDate) : getNextDate(_dCurYear, _dCurMonth, _dCurDate);
	
	setTargetFormaValue(_tmpdate.getFullYear(), _tmpdate.getMonth() + 1, _tmpdate.getDate());
	_bHaveUpdated = false;
	
	fillCldTabFrm(_tmpdate.getFullYear(), _tmpdate.getMonth(), _tmpdate.getDate());;
}
function switchNextMonth(){
   
	switchLastMonth(false);
}
function switchLastYear(){
    
	setTargetFormaValue(_dCurYear * 1 + 1, _dCurMonth * 1 + 1, _dCurDate);
	_bHaveUpdated = false;
	fillCldTabFrm(_dCurYear * 1 + 1, _dCurMonth * 1, _dCurDate);
}
function switchNextYear(){
    
	setTargetFormaValue(_dCurYear * 1 - 1, _dCurMonth * 1 + 1, _dCurDate);
	_bHaveUpdated = false;
	fillCldTabFrm(_dCurYear * 1 - 1, _dCurMonth * 1, _dCurDate);
}

//modify by wangrl
function whenMouseOverDateItem(){
	var e = _cldTabIFrame.event.srcElement;
	
	if(!e){
		e = nowClickSrcElement;
	}
	var _tmpdate = null;
	if(e.tagName == "TD"){
		whenMouseOutDateItem();//清除原有的样式
			
		if(e.name == "LASTMONTH"){
			_tmpdate = getLastDate(_dCurYear, _dCurMonth);
			//modify by wangrl
			//e.title = "Last : " + _tmpdate.getFullYear() + "-" + (_tmpdate.getMonth() + 1) + "-" + e.innerText;
			return;
		}
		if(e.name == "NEXTMONTH"){
			_tmpdate = getNextDate(_dCurYear, _dCurMonth);
			//modify by wangrl
			//e.title = "Next : " + _tmpdate.getFullYear() + "-" + (_tmpdate.getMonth() + 1) + "-" + e.innerText;
			return;
		}
	
		var sCurDate = _dCurYear + "-" + (_dCurMonth + 1) + "-" + e.innerText;
		//modify by wangrl
		//e.title = _parent.v3x.getMessage('V3XLang.calendar_current') + " : " + sCurDate;
		
		e.style.backgroundColor = "#DBDBDB";
		setTargetFormaValue(_dCurYear, _dCurMonth + 1, e.innerText);
	}
	
	nowClickSrcElement = e;
}

function resetTargetValue(){
	_curCldTabRltvObj.value = "";
	_bHaveSelectNewValue = true;
	hideCldTabFrm();	
}

function setTargetFormaValue(year, month, date){
    
    if(Parameters.state==1){
	     getCalendarInfo(year,month);
	}
	
	var _year, _month, _date;
	_year = year;
	_month = month * 1;
	_date = date * 1;
	if(_month < 10) _month = "0" + _month;
	if(_date < 10) _date = "0" + _date;
	
	var d = _year + "-" + _month + "-" + _date;
		
	if(Parameters && Parameters.type == "datetime"){
		var _timeHours = _cldTabIFrame.document.getElementById("timeHours");
		if(_timeHours){
			d += " " + _timeHours.value;
		}
		
		var _timeMinutes = _cldTabIFrame.document.getElementById("timeMinutes");
		if(_timeMinutes){
			d += ":" + _timeMinutes.value;
		}
	}
	
	_curCldTabRltvObj.value = d;
}

function whenMouseOutDateItem(){
	//var e = _cldTabIFrame.event.srcElement;
	
	var e = nowClickSrcElement;
	if(e && e.tagName == "TD")
		e.style.backgroundColor = "";
}
function whenClickDateItem(){
	var e = nowClickSrcElement;
	if(!e){
		return;
	}
		
	var _tmpdate = null;
	var _month = null;
	var _date = null;
	if(e.tagName == "TD"){
		_bHaveUpdated = false;
		if(e.name == "LASTMONTH"){
			_tmpdate = getLastDate(_dCurYear, _dCurMonth);
			setTargetFormaValue(_tmpdate.getFullYear(), _tmpdate.getMonth() + 1, e.innerText);
			fillCldTabFrm(_tmpdate.getFullYear(), _tmpdate.getMonth(), e.innerText);
			return;
		}
		if(e.name == "NEXTMONTH"){
			_tmpdate = getNextDate(_dCurYear, _dCurMonth);
			setTargetFormaValue(_tmpdate.getFullYear(), _tmpdate.getMonth() + 1, e.innerText);
			fillCldTabFrm(_tmpdate.getFullYear(), _tmpdate.getMonth(), e.innerText);
			return;
		}
		if(e.name == "CURRENTMONTH"){
			_tmpdate = new Date();
			setTargetFormaValue(_tmpdate.getFullYear(), _tmpdate.getMonth() + 1, e.innerText);
		}
		
		_bHaveSelectNewValue = true;
		
		hideCldTabFrm();
	}
}

function hideCldTabFrm(){
	if(!_bHaveSelectNewValue)
		if(_cldTabIFrame == null || !_bCanHide) return;

	var oFiredObj = null;
	try{
		oFiredObj = nowClickSrcElement;
	}catch(e){
		oFiredObj = _cldTabIFrame.event.srcElement;
	}
	if(oFiredObj == _curCldTabRltvObj) return;
		
	_cldTabIFrame2.style.display = "none";
	_bHaveUpdated = false;
	_bHaveShown = false;
	removeShadowDiv();
	if(!_bHaveSelectNewValue)
		_curCldTabRltvObj.value = _curCldTabRltvObjValue;
}

function removeShadowDiv(){
	parent.returnFun();

}
function removeShadowDiv1(){
	parent.returnFun1();
}
function removeCalendar(){
	parent.closeCalendar();
}
function MakeDivShadowEffect(divObj, color, nLength)
{
	
	var tmpstr = "window.document.arr" + divObj.id + " = new Array();";
	eval(tmpstr);
	//alert( tmpstr );
	var arrShadowDiv = eval("window.document.arr" + divObj.id);
	var _rect = divObj.getBoundingClientRect();
	for( i = nLength; i > 0; i --)
	{
		var rect = _cldTabIFrame.document.createElement( "DIV" );
		rect.style.position = "absolute";
		rect.style.left = (divObj.style.posLeft + i ) + "px";
		rect.style.top = (divObj.style.posTop + i ) + "px";
		rect.style.backgroundColor = color;
		var opacity = 1 - i / (i + 1);
		rect.style.filter = 'alpha(opacity=' + (100 * opacity) + ')';
		rect.style.zIndex = divObj.style.zIndex - 1;
		_cldTabIFrame.document.body.insertBefore(rect);
		arrShadowDiv[arrShadowDiv.length] = rect;
	}	
}

function ok(){
	removeShadowDiv();
	}
function ok1(){
	removeShadowDiv1()
}
function closeCalendar(){
	removeCalendar();
}
function changeTime(){
	setTargetFormaValue(_dCurYear, _dCurMonth + 1, nowClickSrcElement.innerText);
}

function inputMonth(e){

	var value = e.value;
	setTargetFormaValue(_dCurYear, parseInt(value) + 1, _dCurDate);
	_bHaveUpdated = false;
	fillCldTabFrm(_dCurYear, parseInt(value), _dCurDate);
}

function inputYear( e ){
   
	var value = e.value;
	if(!value && value.length != 4 || !new RegExp("^[0-9]{4}$").test(value)){
		e.value = _dCurYear;
		return false;
	}
	
	setTargetFormaValue(parseInt(value), _dCurMonth * 1 + 1, _dCurDate);
	_bHaveUpdated = false;
	fillCldTabFrm(parseInt(value), _dCurMonth * 1, _dCurDate);
}
function inputYear1( e ){

	var value = e.value;
	if(!value || value.length < 4){
		return true;
	}
	
	if(!new RegExp("^[0-9]{4}$").test(value)){
		e.value = _dCurYear;
		e.select();
		return false;
	}
	
	setTargetFormaValue(parseInt(value), _dCurMonth * 1 + 1, _dCurDate);
	_bHaveUpdated = false;
	fillCldTabFrm(parseInt(value), _dCurMonth * 1, _dCurDate);
}


///////////////////////////////

function changeCalendarDatesStyle(dateArray,year,month){
    
    var dCurDate = 0;
	var dNextMonthDate = 1;
	var iDateStartRow = 3;
	var _d = new Date(year, month, 1);
	var _day = _d.getDay();
	var _td = null;
    //alert(_day);
	i = 1;
	// alert("monthNum:"+_monthDays[month-1]+"num:"+month);
	for(var d = 1, iRow = iDateStartRow; d <= _monthDays[month-1] || iRow < 9; ){
	
	   //alert((month-1)+"//"+_monthDays[month-1]);
		for(; i < 7; i++){
			
			_td = _cldTabFrm.rows(iRow).cells(i);
            
            if(_td.innerHTML>_monthDays[month-1]){
			      continue ;
			}
			
			if(_td.name=="CURRENTMONTH"&&dateArray[_td.innerHTML].dayoff==1){
			     _td.style.backgroundColor = "#E1EEFF";
			}
			if(_td.name=="CURRENTMONTH"&&dateArray[_td.innerHTML].dayoff==0){
			     _td.style.backgroundColor = "transparent";
			}
			
			if(dateArray[_td.innerHTML].description){
			    
		        _td.title = dateArray[_td.innerHTML].description;
		     }
		     
		     _td.detachEvent("onclick",openSetDayState);
		     if(_td.name=="CURRENTMONTH"){
		        _td.attachEvent("onclick",openSetDayState);
		     }
		     dCurDate = d++;	
		}
		i = 0;
		iRow++;
		
	}

}


function openSetDayState(){
       var cTd =  _cldTabIFrame.event.srcElement;
       var date = _dCurYear+"-"+(_dCurMonth+1)+"-"+cTd.innerHTML;
       var authority = document.getElementById("modifyCalendarAuthority");

       if(!authority){
           return false;
       }
	   if(cTd.style.backgroundColor=="transparent"){
	      window.showModalDialog("modify.jsp?date="+date+"&dateType=0",window,"dialogWidth=400px;dialogHeight=200px");
	   }else{
	      window.showModalDialog("modify.jsp?date="+date+"&dateType=1",window,"dialogWidth=400px;dialogHeight=200px");
	   }
   
}

////////////////////////////////////////////////////////////////////
document.onclick = hideCldTabFrm;
