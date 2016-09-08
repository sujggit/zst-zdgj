/*保存cookie
   c_name--key,value---value
   默认时长为一年
   
*/

function setCookie(c_name,value,expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays); 
	//exdate.setDate(exdate.getDate() + expiredays); 
	document.cookie=c_name+"="+escape(value)+((expiredays==null)?"":";expires="+exdate.toGMTString())+";path=/";
	
}
/*
function SetCookie(name,value){
    var argv=SetCookie.arguments;
    var argc=SetCookie.arguments.length;
    var expires=(2<argc)?argv[2]:null;
    var path=(3<argc)?argv[3]:null;
    var domain=(4<argc)?argv[4]:null;
    var secure=(5<argc)?argv[5]:false;
    document.cookie=name+"="+escape(value)+((expires==null)?"":("; expires="+expires.toGMTString()))+((path==null)?"":("; path="+path))+((domain==null)?"":("; domain="+domain))+((secure==true)?"; secure":"");
}
function GetCookie(Name) {
    var search = Name + "=";
    var returnvalue = "";
    if (document.cookie.length > 0) {
          offset = document.cookie.indexOf(search);
          if (offset != -1) {      
                offset += search.length;
                end = document.cookie.indexOf(";", offset);                        
                if (end == -1)
                      end = document.cookie.length;
                returnvalue=unescape(document.cookie.substring(offset,end));
          }
    }
    return returnvalue;
}*/

/*获取cookie,根据c_name--key值来获取*/

function getCookie(c_name){
	if (document.cookie.length > 0) {   
		 var c_start = document.cookie.indexOf(c_name + "=");   
		 if (c_start != -1) {   
			 c_start = c_start + c_name.length + 1;   
		     var c_end = document.cookie.indexOf(";", c_start);   
			     if (c_end == -1) {   
			                c_end = document.cookie.length;   
		           }   
			     return unescape(document.cookie.substring(c_start, c_end));   
			        }   
			    }   
			    return "";  

}
	/*  
	递归换肤  
*/  
function changeSkin(winObj, cssPath) { 
	  //alert(cssPath);
	    var frames = winObj.frames;   
	    for (var i = 0; i < frames.length; i++) {   
        //证明是该页面是框架页面   
	        //alert(frames[i].name + ":" + frames[i].frames.length);   
       if (frames[i].frames.length > 0) {  
    	   
                var linkObj = frames[i].document.getElementById("style"); //获取link对象   
                if (linkObj != null) {   
	                    linkObj.href = "/icmp/style/" + cssPath + "/css/style.default.css";   
               }   
            
	            changeSkin(frames[i], cssPath);//递归换肤  
	        } else { 
	            //非框架页面,换肤   
            var linkObj = frames[i].document.getElementById("style"); //获取link对象   
            if (linkObj != null) {   
	                linkObj.href = "/icmp/style/"+ cssPath + "/css/style.default.css";   
            }	        
          }   
    }   
	}  
	function changeCss(winObj, cssPath) {  
		//alert("come in");
	    setCookie("cssPath", cssPath, 365); //设置cookie   
	    changeSkin(winObj, cssPath); //换肤   
	    //alert(cssPath);
	}  

