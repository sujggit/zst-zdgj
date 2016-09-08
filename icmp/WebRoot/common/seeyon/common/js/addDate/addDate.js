var __addDataEventObject = null;

/**
 * e.g whenstart('${pageContext.request.contextPath}', this, 575, 140);
 * 
 * @param contextPath 跟路径 ${pageContext.request.contextPath}
 * @param whoClick 要赋值的Object，如果为null，则返回日期数据
 * @param myLeft 距屏幕左面距离
 * @param myTop 距屏幕上面距离
 * @param type 选择类型 date datetime 默认 date
 * @param
 */
function whenstart(contextPath, whoClick, myLeft, myTop, type){
	type = type || "date";
	
	__addDataEventObject = whoClick;
	var rv = v3x.openWindow({
        url: contextPath + "/common/js/addDate/date.htm?type=" + type,
        height: 230,
        width: 250,
        dialogTop: myTop,
        dialogLeft: myLeft
	});
	
	if(!whoClick && rv){ 
		return rv;
	}
	
	return null;
}


/***************************************************/
//功能:添加字符串对象的trim函数
String.prototype.trim = function()
{
    // 用正则表达式将前后空格
    // 用空字符串替代。
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
//功能:判断是否为合法的日期字符串
//参数:必须是年月日格式，年要求四位，月日可以是长类型或者短类型，必须以'-'或者'/'作为分隔符
//     isSave为true时合法日期保存到当前日期对象
Date.prototype.isDate=function(szDate,isSave)
{
    var re,regu;
    var splitChar,Year,Month,Day;
    var szArry;
    var strObj=new String(szDate);
	if(strObj.length<8 || strObj.length>10) return false;//判断日期的长度，完整的年，长短日期格式
	regu="^([0-9]){4}(-|/)([0-9]){1,2}(-|/)([0-9]){1,2}$";//日期模板校验(以‘－’或者‘/’分割的日期)
	re=new RegExp(regu);
	if(strObj.search(re)==-1) return false;
	splitChar=strObj.charAt(4);//年必须输入四位数字
	szArry=strObj.split(splitChar);
	if(szArry.length!=3) return false;
	Year=parseInt(szArry[0],10);
	Month=parseInt(szArry[1],10);
	Day=parseInt(szArry[2],10);
	if(Year<1900 || Year>2500) return false;
	if(Month<1 || Month>12) return false;//月必须在１－－１２之间
	if(Day<1 || Day>31) return false;//日必须在１－３１之间
	switch(Month)
	{
		case 4:
		case 6:
		case 9:
		case 11:
			if(Day>30) return false;
			break;
		case 2:
			if((Year%4==0 && Year%100!=0) || Year%400==0)//润年2月份29天
			{
				if(Day>29) return false;
			}
			else
			{
				if(Day>28) return false;
			}
			break;
		default: break;
	}
	if(isSave)
	{
	  this.setYear(Year);
	  this.setMonth(Month-1);
	  this.setDate(Day);
	}
	return true;
}

/**
 * 将日期字符串转换成日期对象
 */
function parseDate(dateStr){
	var ds = dateStr.split("-");
	var y = parseInt(ds[0], 10);
	var m = parseInt(ds[1], 10) - 1;
	var d = parseInt(ds[2], 10);
	
	return new Date(y, m, d);
}
//功能:得到输入日期前几天或者后几天的日期

Date.prototype.dateAdd=function(curDateStr,iPassNum)
{
  var dateObj;
  var sNewDate=curDateStr;
  var y,m,d;
  var sDate;
  var bUpChange=false;
  var splitChar;
  var szArry;
  var strObj;
  if(this.isDate(curDateStr,true)==false)
  {
    //alert("当前日期错误!");
    return curDateStr;
  }
  strObj=new String(curDateStr);
  splitChar=strObj.charAt(4);//年必须输入四位数字
  szArry=strObj.split(splitChar);
  y=parseInt(szArry[0],10);
  m=parseInt(szArry[1],10);
  d=parseInt(szArry[2],10);

  while(iPassNum!=0)
  {
    //设置日期
    if(iPassNum>0) d++;
    else d--;
    if(d<=0 || d>31)
    {
       bUpChange=true;
       if(d<=0) d=31;
       else d=1;
    }
    else
    {
      bUpChange=false;
    }
    //设置月
    if(bUpChange)
    {
      if(iPassNum>0) m++;
      else m--;
      if(m<=0 || m>12)
      {
        bUpChange=true;
        if(m<=0) m=12;
        else m=1;
      }
      else
      {
        bUpChange=false;
      }
    }
    //设置年
    if(bUpChange)
    {
      if(iPassNum>0) y++;
      else y--;
    }
    sNewDate=y+"-"+m+"-"+d;
    if(this.isDate(sNewDate,false))
    {
      if(iPassNum>0) iPassNum--;
      else iPassNum++;
    }
  }
  return sNewDate;
}
//功能:得到输入日期所在的星期的开始日期(星期一)和结束日期(星期五)
Date.prototype.getWeekStart=function(dateStr)
{
  this.isDate(dateStr,true);
  var iWeek=this.getDay();

  //一周的第一天这里定为周日
  var iPassNum=iWeek;
  if(iPassNum!=0) iPassNum=-iPassNum;
  return formatDate(this.dateAdd(dateStr,iPassNum));
}

Date.prototype.getWeekEnd=function(dateStr)
{
  this.isDate(dateStr,true);
  var iWeek=this.getDay();
  //alert(dateStr+"|||"+this.getYear()+"-"+m+"-"+this.getDate());
  //alert("iWeek:"+iWeek);
  //if(iWeek==0) iWeek=7;
  var iPassNum=6-iWeek;
  return formatDate(this.dateAdd(dateStr,iPassNum));
}

//功能:得到输入日期所在的月份的开始日期和结束日期
Date.prototype.getMonthStart=function(dateStr)
{
  this.isDate(dateStr,true);
	dateStr=this.getYear()+"-"+(this.getMonth()+1)+"-1";
  return formatDate(dateStr);
}
Date.prototype.getMonthEnd=function(dateStr)
{
  this.isDate(dateStr,true);
	var months=[31,28,31,30,31,30,31,31,30,31,30,31];
  this.isDate(dateStr,true);
	var iYear=this.getYear();
  var iMonth=this.getMonth()+1;

  var iDay=months[this.getMonth()];

	if(iYear%4==0 && iMonth==2){
		iDay++;
	}
	dateStr=iYear+"-"+iMonth+"-"+iDay;
  return formatDate(dateStr);
}
//功能:得到输入日期所在的季度的开始日期和结束日期
Date.prototype.getSeasonStart=function(dateStr)
{
	var a=[1,1,1,4,4,4,7,7,7,10,10,10];
  this.isDate(dateStr,true);
	dateStr=this.getYear()+"-"+a[this.getMonth()]+"-1";
  return formatDate(dateStr);
}
Date.prototype.getSeasonEnd=function(dateStr)
{
  this.isDate(dateStr,true);
	var a=[3,3,3,6,6,6,9,9,9,12,12,12];
	var m=[31,31,31,30,30,30,30,30,30,31,31,31];
  this.isDate(dateStr,true);
	dateStr=this.getYear()+"-"+a[this.getMonth()]+"-"+m[this.getMonth()];
  return formatDate(dateStr);
}

function formatDate(dateStr){
	var d = dateStr.split("-");
	var month = parseInt(d[1], 10);
	var date = parseInt(d[2], 10);
	
	return d[0] + "-" + (month < 10 ? "0" + month : month) + "-" + (date < 10 ? "0" + date : date);
}

/**
 * 日期格式化
 */
Date.prototype.format = function(pattern) {
	var hour = this.getHours();
	var o = {
		"M+" : this.getMonth() + 1, //month
		"d+" : this.getDate(),    //day
		"H+" : hour,   //hour
		"h+" : (hour > 12 ? hour - 12 : hour),   //hour
		"m+" : this.getMinutes(), //minute
		"s+" : this.getSeconds(), //second
		"q+" : Math.floor((this.getMonth()+3)/3),  //quarter
		"S" : this.getMilliseconds() //millisecond
	}
	
	if(/(y+)/.test(pattern)){
		pattern = pattern.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}
	
	for(var k in o)if(new RegExp("("+ k +")").test(pattern)){
		pattern = pattern.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
	}
  
	return pattern;
}

/**
 * 比较两个字符串日期的前后，不比较时间
 * 
 * @param dateStr1 日期1 字符串
 * @param dateStr2 日期2 字符串
 * @return 负整数、零或正整数，根据此对象是小于、等于还是大于
 */
function compareDate(dateStr1, dateStr2){
	var date1 = parseDate(dateStr1);
	var date2 = parseDate(dateStr2);
	
	return date1.getTime() - date2.getTime();
}

/*************************************以下为日期格式转换函数*******************************/

/*
功能:YYYY-MM-DD 数字日期转化为汉字
例:2008-3-7 -> 二零零八年三月七日
调用:date2chinese1("2008-3-7") 

date2chinese0("2008-5-8"); －－》 二〇〇八年三月七日

date2chinese("2008-05-8"); －－》 2008年5月8日


*/
var chinese=["零","一","二","三","四","五","六","七","八","九"];
var len = ["十"];
var ydm =["年","月","日"];
function num2chinese(s)
{

//将单个数字转成中文.
s=""+s;
slen = s.length;
var result="";
for(var i=0;i<slen;i++)
{
result+=chinese[s.charAt(i)];
}
return result;
}


function n2c(s)
{ 
//对特殊情况进行处理.
s=""+s;
var result="";
if(s.length==2)
{
if(s.charAt(0)=="1")
{
if(s.charAt(1)=="0")return len[0];
return len[0]+chinese[s.charAt(1)];
}
if(s.charAt(1)=="0")return chinese[s.charAt(0)]+len[0];
return chinese[s.charAt(0)]+len[0]+chinese[s.charAt(1)];
}
return num2chinese(s)
}

function date2chinese0(s)
{
  var ns=date2chinese(s);
  ns=ns.replace(/零/g, "〇");
  return ns;
}

function date2chinese1(s)
{
  var str;
  var ns=s.split("-");  
  if(ns.length!=3){ns=s.split("/");}
  if(ns.length!=3){return s;}
  if(ns[1].charAt(0)=="0"){ns[1]=ns[1].substr(1);}
  if(ns[2].charAt(0)=="0"){ns[2]=ns[2].substr(1);}
  str=ns[0]+"年"+ns[1]+"月"+ns[2]+"日";
  return str;
}

function date2chinese(s)
{
//验证输入的日期格式.并提取相关数字.
var datePat = /^(\d{2}|\d{4})(\/|-)(\d{1,2})(\2)(\d{1,2})$/; 
var matchArray = s.match(datePat); 
var ok="";
if (matchArray == null) return false;
for(var i=1;i<matchArray.length;i=i+2)
{
ok+=n2c(matchArray[i]-0)+ydm[(i-1)/2];

}

return ok;
}

/****************************************************************************************************/


