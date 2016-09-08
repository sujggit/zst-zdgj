 
 Date.getCurrentDateTime = function() {  //获取当前时间   
    var now= new Date();   
    var _month = ( 10 > (now.getMonth()+1) ) ? '0' + (now.getMonth()+1) : now.getMonth()+1;   
    var _day = ( 10 > now.getDate() ) ? '0' + now.getDate() : now.getDate();   
    var _hour = ( 10 > now.getHours() ) ? '0' + now.getHours() : now.getHours();   
    var _minute = ( 10 > now.getMinutes() ) ? '0' + now.getMinutes() : now.getMinutes();   
    var _second = ( 10 > now.getSeconds() ) ? '0' + now.getSeconds() : now.getSeconds();   
    return now.getYear() + '-' + _month + '-' + _day + ' ' + _hour + ':' + _minute + ':' + _second;   
};  