
	//初始化选择项个数
	   function num(formobj){
		var num = document.getElementById(formobj.id + "rightsel").options.length;
		//alert(num);
		document.getElementById(formobj.id + "numberID").innerHTML=num;
	   }

	/**
	 *(按住shift或ctrl可以多选;select option操作)
	 *选定一项或多项然后点击添加或移除
	 *或在选择项上双击进行添加和移除
	 *e1点击的select对象 e2被添加的select对象
	*/
	function moveOption(e1, e2){ 
		if(e1==null)return;
		if(e2==null)return;
		for(var i=0;i<e1.options.length;i++){
		    if(e1.options[i].selected){
		        var e = e1.options[i];
		        if(this.isExist(e2, e.text, e.value)==true){
		        }else{
		        	e2.options.add(new Option(e.text, e.value));
		        }
		        e1.remove(i);
		        i=i-1;
		    }
		}
		var num = 0;
		if( e2.id == e2.form.id + "rightsel"){
			num = e2.options.length;
		}else if( e2.id == e2.form.id + "leftsel"){
			num = e1.options.length;
		}
		//$("#numberID").html(num);
		document.getElementById(e1.form.id + "numberID").innerHTML=num;
	}
	
	/**
	*添加全部选项到右侧下拉列表
	**/
	function moveAllOptions(e1,e2){
		if(e1==null)return;
		if(e2==null)return;
		for(var i=0;i<e1.options.length;i++){
				var e = e1.options[i];
				if(this.isExist(e2, e.text, e.value)==true){
				}else{
					e2.options.add(new Option(e.text, e.value));
				}
				e1.remove(i);
				i=i-1;
			}
		var num = 0;
		if( e2.id == e2.form.id + "rightsel"){
			num = e2.options.length;
		}else if( e2.id == e2.form.id + "leftsel"){
			num = e1.options.length;
		}
		//$("#numberID").html(num);
		document.getElementById(e1.form.id + "numberID").innerHTML=num;
		    
	}
	

	function isExist(e2,text,value){
		for(var i=0;i<e2.options.length;i++){
			if(e2.options[i].value == value||(e2.options[i].text==text))return true;
		}
		return false;
	}

	/**
	 *保存option的value和text字符串
	**/
	function save(formobj){
		var rightsltobj = document.getElementById(formobj.id + "rightsel");
		//alert(rightsltobj.id);
		//var form1 = document.getElementById(formobj.id);
		var rightsltids = "";
		var rightsltnames = "";
	
		for(var i=0;i<rightsltobj.options.length;i++){
			rightsltids += ","+rightsltobj.options[i].value;
			rightsltnames += ","+rightsltobj.options[i].text;
		}
		rightsltids = rightsltids.substring(1);
		rightsltnames = rightsltnames.substring(1);
		//alert(rightsltids + "===" + rightsltnames);
		formobj.action = "";
		//formobj.action = "/icmp/baseInfo/addDateDictionary.action";
		document.getElementById(formobj.id+"baseInfoValues").value=rightsltids;
		document.getElementById(formobj.id+"baseInfoTexts").value=rightsltnames;
		formobj.submit();
	
	}	
	