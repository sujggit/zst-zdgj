    

 //初始化函数
	function initMenu(menuIDs){
	    var leftFrame = document.getElementById("leftFrame");
	    var topFrame = document.getElementById("menueFrame");
	    var topDocument = topFrame.contentWindow;
	    //alert(topFrame.contentWindow.document.getElementById("shhy").attributes["url"].nodeValue);
	    //var menu1 = topFrame.document.getElementById("zkkz");
	    //alert(menu1);
	    //alert(menu1.sa);
	    //menuBar
	    /**
                    <td class="tp_line"><a href="#" id="zkkz">中  控</a></td>
                    <td class="tp_line"><a href="#" id="yp">音  频</a></td>
                    <td class="tp_line"><a href="#" id="dp">大  屏</a></td>
                    <td class="tp_line"><a href="#" id="lb">录  播</a></td>
                    <td class="tp_line"><a href="#" id="xtgl">系统管理</a></td>
                    **/
	    try{
		    if(!menuIDs){
		    	alert("传入的菜单参数有误！");
		    }

		    var menuIDArray = menuIDs.split(",");
		    
		    var menuLength = Number(menuIDArray.length);
		   
		   for(var i=0;i<menuLength;i++){
		   	    topDocument.document.getElementById(menuIDArray[i]).onclick=(function(n,name){
		   	    	  // cLeftMenu(menuIDArray[i]);
		   	    	return function(){
		   	    		cLeftMenu(n,name);
		   	    	};
		   	    })(menuIDArray[i])
		   }
		}catch(err){
	    	alert("脚本错误描述:"+err.description); 
	    }
	}
  function cLeftMenu(menuID,menuName){ 
	  var leftFrame =  window.frames[2];
	    var leftTable = leftFrame.document.getElementById("muteName"); 
	    leftTable.innerText = menuName;
  	UserAction.getFunTreeByID(menuID,menuBack);
  }
  
  function menuBack(lst){
  	   var leftFrame =  window.frames[2]; 
       var leftTable = leftFrame.document.getElementById("menuTable"); 
  	   delTable(leftTable);
  	   
  	       var menuArray = new Array();//提取到得菜单数组
  	      if(null==lst)  return ;
  	      for(var i=0;i<lst.length;i++){
	  	      var menuObj = {
	  		    name:lst[i].func_name,
	  		    url:lst[i].func_url,
	  		    id:lst[i].func_id
	          };
	          menuArray[i] =  menuObj;
	          
	          addLeftMenu(menuArray[i]);
  	      }
  }
  
  var leftTdOldID = "";
  function setTdId(tdID){
	  leftTdOldID = tdID;
  }
  function getTdId(tdID){
	  return leftTdOldID ;
  }
  function selectedTd(obj){
	  if(leftTdOldID!=null&&leftTdOldID.length>0){
		    var leftFrame =  window.frames[2];
	  		var leftTd = leftFrame.document.getElementById(leftTdOldID);
	  		if(leftTd!=null)
	  			leftTd.className="lefttd fontstyle ac";
	  }
	  obj.parentNode.className="lefttdselect fontstylew ac";
      setTdId(obj.parentNode.id);
  }
  
  /**
   * 根据菜单的url在content区域打开新的功能页面
   * @param {} url
   */
  function openNewFunction(url,navigat,func_id){
  	 document.getElementById("rightFrame").src=url;
  	 
  	var currentFrame =  window.frames["currentFrame"];
    var divObj = currentFrame.document.getElementById("currentDiv");
    divObj.innerText = navigat;
    var funcId = currentFrame.document.getElementById("funcId");
    funcId.value = func_id;
  }
  
  /**
   * 添加left菜单
   * @param {} menuObj
   */
  function addLeftMenu(menuObj){
  	  var leftFrame = window.frames[2]; 
  	  
  	  var muteName = leftFrame.document.getElementById("muteName"); 
  	  var leftTable = leftFrame.document.getElementById("menuTable"); 
  	  var newLine = leftTable.insertRow(-1);
  	  var newCell = newLine.insertCell(-1);//声明新行中的第一个新列 
         //  newCell.className = "cter_dx";
         //  newCell.innerHTML = "<input type='button' name='button2' style='cursor:pointer' value='"+menuObj.name+"' onclick=\"javascript:window.parent.openNewFunction('"+menuObj.url+"')\"  class='cter_btn'/>" ;
  	  var id = "leftTd"+menuObj.id;
  	  newCell.id=id;
  	  //if(tdNum==0)
  		//  newCell.className = "lefttdselect fontstylew ac";
  	  //else
  	  newCell.className = "lefttd fontstyle ac";
	  newCell.innerHTML = "<span style=\"cursor:pointer\" onclick=\"javascript:window.parent.openNewFunction('"+menuObj.url+"');" +
	  		"window.parent.openNewCurrentFunction(this,'"+muteName.innerHTML+" &rArr; "+menuObj.name+"')\">"+menuObj.name+"</span>" ;
  }
  
  //删除表格所有 tr td
       function delTable(table){
		      var table = table;
		      while(table.hasChildNodes()){
		          table.removeChild(table.lastChild);
		     }
		}
 //添加一行
      function addNewRow(table){
      	   var newLine = table.insertRow(-1);//声明一个新行 
      	   return newLine;
      }
		