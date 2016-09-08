/*
*Date: 2010-01-22 11:20:21
* author:wangrl
*/

/**
js中常用常量
**/
var selfMeetingType=11;
var assignLocalMeetingType=21;
var assignVideoMeetingType=22;
var detailLocalMeetingType=31;
var detailVideoMeetingType=2;
var self_splitString=">>>>>><<<>>>";
//全局对象
var self_common=new Object();
/**测试函数**/
self_common.test=function(){
alert("测试成功！");
}
/**
页面展开收缩箭头控制
**/
self_common.showArrow=function(obj){

  if(obj.src.search(/moredown_hot.gif/)!=-1){
     obj.src=obj.src.replace(/moredown_hot.gif/,"moreup_hot.gif");
  }else if(obj.src.search(/moreup_hot.gif/)!=-1){
  obj.src= obj.src=obj.src.replace(/moreup_hot.gif/,"moredown_hot.gif");
  }
  }
