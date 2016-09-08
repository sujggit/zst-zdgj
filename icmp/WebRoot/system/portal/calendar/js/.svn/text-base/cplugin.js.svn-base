var v3x = new V3X();
var messageRegEx_0 = /\{0\}/g;
var messageRegEx_1 = /\{1\}/g;
var messageRegEx_2 = /\{2\}/g;
var messageRegEx_3 = /\{3\}/g;
var messageRegEx_4 = /\{4\}/g;
var messageRegEx_5 = /\{5\}/g;
var messageRegEx_6 = /\{6\}/g;
var messageRegEx_7 = /\{7\}/g;
var messageRegEx_8 = /\{8\}/g;
var messageRegEx_9 = /\{9\}/g;
var messageRegEx_10 = /\{10\}/g;
var messageRegEx_11 = /\{11\}/g;
var messageRegEx_12 = /\{12\}/g;
var messageRegEx_13 = /\{13\}/g;
var messageRegEx_14 = /\{14\}/g;
var messageRegEx_15 = /\{15\}/g;


String.prototype.getBytesLength = function() {
	var cArr = this.match(/[^\x00-\xff]/ig);
	return this.length + (cArr == null ? 0 : cArr.length);
};

String.prototype.getLimitLength = function(maxlengh, symbol) {
	if(!maxlengh || maxlengh < 0){
		return this;
	}
	var len = this.getBytesLength();

	if(len <= maxlengh){
		return this;
	}
	
	symbol = symbol == null ? ".." : symbol;
	maxlengh = maxlengh - symbol.length;

    var a = 0; 
    var temp = ''; 

    for (var i = 0; i < this.length; i++)    { 
        if (this.charCodeAt(i) > 255) a += 2; 
        else a++; 

        temp += this.charAt(i);  

        if(a >= maxlengh) {
			return temp + symbol;
		}
    } 

    return this; 
};

String.prototype.escapeHTML = function(){
	try{
		return escapeStringToHTML(this);
	}
	catch(e){}
	
	return this;
};

String.prototype.escapeSpace = function(){	
	return this.replace(/ /g, "&nbsp;");
};

String.prototype.startsWith = function(prefix){	
	return this.indexOf(prefix) == 0;
};

/**
 * 去掉空格
 */
String.prototype.trim = function(){
	var chs = this.toCharArray();
	
	var st = 0;
	var off = chs.length;
	
	for(var i = 0; i < chs.length; i++){
		var c = chs[i];
		if(c == ' '){
			st++;
		}
		else{
			break;
		}
	}
	
	if(st == this.length){
		return "";
	}
	
	for(var i = chs.length; i > 0; i--){
		var c = chs[i-1];
		if(c == ' '){
			off--;
		}
		else{
			break;
		}
	}
		
	return this.substring(st, off);
};

/**
 * 将字符串转成数组
 */
String.prototype.toCharArray = function(){
	var array = [];
	
	for(var i = 0; i < this.length; i++){
		array[i] = this.charAt(i);
	}		
	
	return array;
};

/**
 * 
 */
Array.prototype.indexOf = function(object){
	for(var i = 0; i < this.length; i++) {
		if(this[i] == object){
			return i;
		}
	}
	
	return -1;
}

/**
 * 日志
 */
var log = {
	rootLogger : "info",
	
	debugLevel : {debug : true , info : true , warn : true , error : true },
	infoLevel  : {debug : false, info : true , warn : true , error : true },
	warnLevel  : {debug : false, info : false, warn : true , error : true },
	errorLevel : {debug : false, info : false, warn : false, error : true },
	
	debug : function(message){
		if(this.isDebugEnabled())
			alert("Debug : " + message)
	},	
	info : function(message){
		if(this.isInfoEnabled())
			alert("Info : " + message)
	},	
	warn : function(message){
		if(this.isWarnEnabled())
			alert("Warn : " + message)
	},
	error : function(message, exception){
		if(this.isErrorEnabled())
			alert("Error : " + message + "\n\n" + exception.message)
	},
	
	isDebugEnabled : function(){
		return eval("this." + this.rootLogger + "Level.debug");
	},	
	isInfoEnabled : function(){
		return eval("this." + this.rootLogger + "Level.info");
	},	
	isWarnEnabled : function(){
		return eval("this." + this.rootLogger + "Level.warn");
	},	
	isErrorEnabled : function(){
		return eval("this." + this.rootLogger + "Level.error");
	}	
}


var EmptyArrayList = new ArrayList();

/**
 * ArrayList like java.util.ArrayList
 */
function ArrayList(){
	this.instance = new Array();
}

ArrayList.prototype.size = function(){
	return this.instance.length;
}
/**
 * 在末尾追加一个
 */
ArrayList.prototype.add = function(o){
	this.instance[this.instance.length] = o;
}
/**
 * 当list中不存在该对象时才添加
 */
ArrayList.prototype.addSingle = function(o){
	if(!this.contains(o)){
		this.instance[this.instance.length] = o;
	}
}
/**
 * 在指定位置增加元素
 * @param posation 位置， 从0开始
 * @param o 要增加的元素
 */
ArrayList.prototype.addAt = function(position, o){
	if(position >= this.size() || position < 0 || this.isEmpty()){
		this.add(o);
		return;
	}
	
	var tempList = new Array();
	var len = this.size();

	for(var i = 0; i < len; i++){
		if(i == position){
			tempList[tempList.length] = o;
		}

		tempList[tempList.length] = this.get(i);
	}
	
	this.instance = tempList;
}

/**
 * Appends all of the elements in the specified Collection to the end of
 * this list, in the order that they are returned by the
 * specified Collection's Iterator.  The behavior of this operation is
 * undefined if the specified Collection is modified while the operation
 * is in progress.  (This implies that the behavior of this call is
 * undefined if the specified Collection is this list, and this
 * list is nonempty.)
 */
ArrayList.prototype.addAll = function(array){
	if(!array || array.length < 1){
		return;
	}
	
	this.instance = this.instance.concat(array);
}

/**
 * 追加一个List在队尾
 */
ArrayList.prototype.addList = function(list){
	if(list && list instanceof ArrayList && !list.isEmpty()){
		this.instance = this.instance.concat(list.instance);
	}
}

/**
 * @return the element at the specified position in this list.
 */
ArrayList.prototype.get = function(index){
	if(this.isEmpty()){
		return null;
	}

	if(index > this.size()){
		return null;
	}

	return this.instance[index];
}

/**
 * 最后一个
 */
ArrayList.prototype.getLast = function(){
	if(this.size() < 1){
		return null;
	}

	return this.instance[this.size() - 1];
}

/**
 * Replace the element at the specified position in the list with the specified element
 * @param index int index of element to replace
 * @param obj Object element to be stored at the specified posotion
 * @return Object the element previously at the specified posotion
 * @throws IndexOutOfBoundException if index out of range
 */
ArrayList.prototype.set = function(index, obj){
	if(index >= this.size()){
		throw "IndexOutOfBoundException : Index " + index + ", Size "+this.size();
	}
	
	var oldValue = this.instance[index];
	this.instance[index] = obj;
	
	return oldValue;
}

/**
 * Removes the element at the specified position in this list.
 * Shifts any subsequent elements to the left (subtracts one from their
 * indices).
 */
ArrayList.prototype.removeElementAt = function(index){
	if(index > this.size()){
		return;
	}

	var tempList = new Array();
	var k = 0;
	for(var i = 0; i < this.size(); i++){
		if(i != index){
			tempList[k++] = this.instance[i];
		}
	}

	this.instance = tempList;
}
/**
 * Removes the element in this list.
 */
ArrayList.prototype.remove = function(o){
	var tempList = new Array();
	var k = 0;
	for(var i = 0; i < this.size(); i++){
		if(this.instance[i] != o){
			tempList[k++] = this.instance[i];
		}
	}

	this.instance = tempList;
}
/**
 * @return <tt>true</tt> if this list contains the specified element.
 */
ArrayList.prototype.contains = function(o, comparatorProperies){
	return this.indexOf(o, comparatorProperies) > -1;
}
/**
 * Searches for the first occurence of the given argument, testing 
 * for equality using the <tt>==</tt> method. 
 */
ArrayList.prototype.indexOf = function(o, comparatorProperies){
	for(var i = 0; i < this.size(); i++){
		var s = this.instance[i];
		if(s == o){
			return i;
		}
		else if(comparatorProperies != null && s != null && o != null && s[comparatorProperies] == o[comparatorProperies]){
			return i;
		}
	}

	return -1;
}
/**
 * Returns the index of the last occurrence of the specified object in this list. 
 * @return the index of the last occurrence of the specified object in this list;
 *         returns -1 if the object is not found. 
 */
ArrayList.prototype.lastIndexOf = function(o, comparatorProperies){
	for(var i = this.size() - 1; i >= 0; i--){
		var s = this.instance[i];
		if(s == o){
			return i;
		}
		else if(comparatorProperies != null && s != null && o != null && s[comparatorProperies] == o[comparatorProperies]){
			return i;
		}
	}

	return -1;
}

/**
 * Returns a view of the portion of this list between 
 * fromIndex, inclusive, and toIndex, exclusive.
 * @return a view of the specified range within this list. 
 */
ArrayList.prototype.subList = function(fromIndex, toIndex){
	if(fromIndex < 0){
		fromIndex = 0;
	}
	
	if(toIndex > this.size()){
		toIndex = this.size();
	}
	
	var tempList = new ArrayList();
	
	for(var i = fromIndex; i < toIndex; i++){
		tempList.add(this.instance[i]);
	}
	
	return tempList;
}
/**
 * Returns an array containing all of the elements in this list in the correct order;
 *
 * @return Array
 */
ArrayList.prototype.toArray = function(){
	return this.instance;
}

/**
 * Tests if this list has no elements.
 *
 * @return <tt>true</tt> if this list has no elements;
 */
ArrayList.prototype.isEmpty = function(){
	return this.size() == 0;
}
/**
 * Removes all of the elements from this list.  The list will
 * be empty after this call returns.
 */
ArrayList.prototype.clear = function(){
	this.instance = new Array();
}
/** 
 * show all elements
 */
ArrayList.prototype.toString = function(sep){
	sep = sep || ", ";
	return this.instance.join(sep);
}


var EmptyProperties = new Properties();

/**
 *
 */
function Properties(jsProps){
	this.instanceKeys = new ArrayList();
	this.instance = {};
	
	if(jsProps){
		this.instance = jsProps;
		for(var i in jsProps){
			this.instanceKeys.add(i);
		}
	}
}

/**
 * Returns the number of keys in this Properties.
 * @return int
 */
Properties.prototype.size = function(){
  return this.instanceKeys.size();
}

/**
 * Returns the value to which the specified key is mapped in this Properties.
 * @return value
 */
Properties.prototype.get = function(key, defaultValue){
	if(key == null){
		return null;
	}
	
	var returnValue = this.instance[key];
  
	if(returnValue == null && defaultValue != null){
		return defaultValue;
	}

	return returnValue;
}
/**
 * Removes the key (and its corresponding value) from this 
 * Properties. This method does nothing if the key is not in the Properties.
 */
Properties.prototype.remove = function(key){
	if(key == null){
		return null;
	}
	this.instanceKeys.remove(key);
	delete this.instance[key]
}
/**
 * Maps the specified <code>key</code> to the specified 
 * <code>value</code> in this Properties. Neither the key nor the 
 * value can be <code>null</code>. <p>
 *
 * The value can be retrieved by calling the <code>get</code> method 
 * with a key that is equal to the original key. 
 */
Properties.prototype.put = function(key,value){
	if(key == null){
		return null;
	}
	
	if(!this.instanceKeys.contains(key)){
		this.instanceKeys.add(key);
	}

	this.instance[key] = value;
}

/**
 * 直接追加，不考虑重复key
 */
Properties.prototype.putRef = function(key,value){
	if(key == null){
		return null;
	}

	this.instanceKeys.add(key);
	this.instance[key] = value;
}

/**
 * Returns the value to which the specified value is mapped in this Properties.
 * e.g:
 * userinfo.getMultilevel("department.name")  the same sa :  userinfo.get("department").get("name")
 * @return string
 */
Properties.prototype.getMultilevel = function(key, defaultValue){
	if(key == null){
		return null;
	}
	
	var _keys = key.split(".");
  
	function getObject(obj, keys, i){
		try{
			if(obj == null || (typeof obj != "object")){
				return null;
			}
	
			var obj1 = obj.get(keys[i]);
	
			if(i < keys.length - 1){
				obj1 = getObject(obj1, keys, i + 1);
			}
	
			return obj1;
		}
		catch(e){
		}

		return null;
	}

	var returnValue = getObject(this, _keys, 0);

	return returnValue == null ? defaultValue : returnValue;
}

/**
 * Tests if the specified object is a key in this Properties.
 * @return boolean
 */
Properties.prototype.containsKey = function(key){
	if(key == null){
		return false;
	}
	
	return this.instanceKeys.contains(key);
}

/**
 * Returns an ArrayList of the keys in this Properties.
 * @return ArrayList
 */
Properties.prototype.keys = function(){
	 return this.instanceKeys;
}

/**
 * Returns an ArrayList of the values in this Properties.
 * @return ArrayList
 */
Properties.prototype.values = function(){
	var vs = new ArrayList();
	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		
		if(key){
			var value = this.instance[key];
			vs.add(value);
		}
	}

	return vs;
}

/**
 * Tests if this Properties maps no keys to values.
 * @return boolean
 */
Properties.prototype.isEmpty = function(){
	return this.instanceKeys.isEmpty();
}

/**
 * Clears this Properties so that it contains no keys. 
 */
Properties.prototype.clear = function(){
	this.instanceKeys.clear();
	this.instance = {};
}
/**
 * exchange entry1(key1-value1) with entry2(key2-value2)
 */
Properties.prototype.swap = function(key1, key2){
	if(!key1 || !key2 || key1 == key2){
		return;
	}
	
	var index1 = -1;
	var index2 = -1;
	
	for(var i = 0; i < this.instanceKeys.instance.length; i++) {
		if(this.instanceKeys.instance[i] == key1){
			index1 = i;
		}
		else if(this.instanceKeys.instance[i] == key2){
			index2 = i;
		}		
	}
	
	this.instanceKeys.instance[index1] = key2;
	this.instanceKeys.instance[index2] = key1;
}

Properties.prototype.entrySet = function(){
	var result = [];
	
	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		var value = this.instance[key];
		
		if(!key){
			continue;
		}
		
		var o = new Object();
		o.key = key;
		o.value = value;
		
		result[result.length] = o;
	}
	
	return result;
}

/**
 *
 */
Properties.prototype.toString = function(){
	var str = "";

	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		str += key + "=" + this.instance[key] + "\n";
	}

	return str;
}
/**
 * 转换成key1=value1;key2=value2;的形式
 * token1 -- 对应第一层分隔符  如上式的";"
 * token2 -- 对应第二层分隔符  如上式的"="
 */
Properties.prototype.toStringTokenizer = function(token1, token2){
	token1 = token1 == null ? ";" : token1;
	token2 = token2 == null ? "=" : token2;
	var str = "";

	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		var value = this.instance[key];
		
		if(!key){
			continue;
		}
		
		if(i > 0){
			str += token1;
		}
		str += key + token2 + value;
	}

	return str;
}

Properties.prototype.toQueryString = function(){
	if(this.size() < 1){
		return "";
	}
	
	var str = "";
	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		var value = this.instance[key];
		
		if(!key){
			continue;
		}
		
		if(i > 0){
			str += "&";
		}

		if(typeof value == "object"){
			
	    }
		else{
			str += key + "=" + encodeURIat(value);
		}
	}

	return str;
}

function encodeURIat(str)
{
	var strTemp=encodeURI(str);
	strTemp=strTemp.replace(/&/g,"%26");
	return strTemp;
}

Properties.prototype.toInputString = function(){
	if(this.size() < 1){
		return "";
	}
	
	var str = "";
	for(var i=0; i<this.instanceKeys.size(); i++){
		var key = this.instanceKeys.get(i);
		var value = this.instance[key];
		
		if(!key){
			continue;
		}

		if(typeof value == "object"){
			
	    }
		else{
			str += "<input type='hidden' name=\"" + key + "\" value=\"" + encodeURI(value) + ">";
		}
	}

	return str;
}

function Set(){
	this.instance = new Array();
	this.key = {
		
	}
}

Set.prototype.add = function(){
	if(arguments == null || arguments.length < 1){
		throw "arguments is null";
	}
	
	for(var i = 0; i < arguments.length; i++) {
		var a = arguments[i];
		if(!this.contains(a)){ //存在
			this.instance[this.size()] = a;
			this.key[a] = "A8"; //随便给个值
		}
	}
}

Set.prototype.size = function(){
	return this.instance.length;
}

Set.prototype.contains = function(o){
	return this.key[o] != null;
}

Set.prototype.isEmpty = function(){
	return this.size() == 0;
}

Set.prototype.clear = function(){
	this.instance = new Array();
	this.key = {
		
	}
}

Set.prototype.get = function(index){
	if(this.isEmpty()){
		return null;
	}

	if(index > this.size()){
		return null;
	}

	return this.instance[index];
}

Set.prototype.toArray = function(){
	return this.instance;
}
Set.prototype.toString = function(){
	return this.instance.join(', ');
}

/**
 * StringStringBuffer对象
 */
function StringBuffer(){
	this._strings_ = new Array();
}
StringBuffer.prototype.append = function(str){
	if(str){
		if(str instanceof Array){
			this._strings_ = this._strings_.concat(str);
		}
		else{
			this._strings_[this._strings_.length] = str;
		}
	}
	
	return this;
}
StringBuffer.prototype.reset = function(newStr){
	this.clear();
	this.append(newStr);
}
StringBuffer.prototype.clear = function(){
	this._strings_ = new Array();
}
StringBuffer.prototype.isBlank = function(){
	return this._strings_.length == 0;
}

StringBuffer.prototype.toString = function(sp){
	sp = sp == null ? "" : sp;
	if (this._strings_.length == 0)
		return "";
	return this._strings_.join(sp);
}

function V3X(){
  
	this.windowArgs = new Array();
	this.lastWindow = null;
	// Browser check
	var ua = navigator.userAgent;
	this.isMSIE = (navigator.appName == "Microsoft Internet Explorer");
	this.isMSIE5 = this.isMSIE && (ua.indexOf('MSIE 5') != -1);
	this.isMSIE5_0 = this.isMSIE && (ua.indexOf('MSIE 5.0') != -1);
	this.isMSIE7 = this.isMSIE && (ua.indexOf('MSIE 7') != -1);
	this.isMSIE8 = this.isMSIE && (ua.indexOf('MSIE 8') != -1);
	this.isGecko = ua.indexOf('Gecko') != -1;
	this.isGecko18 = ua.indexOf('Gecko') != -1 && ua.indexOf('rv:1.8') != -1;
	this.isSafari = ua.indexOf('Safari') != -1;
	this.isOpera = ua.indexOf('Opera') != -1;
	this.isMac = ua.indexOf('Mac') != -1;
	this.isNS7 = ua.indexOf('Netscape/7') != -1;
	this.isNS71 = ua.indexOf('Netscape/7.1') != -1;
	this.dialogCounter = 0;
	
	this.defaultLanguage = "en";
	this.currentLanguage = "";
	this.baseURL = "";
	this.loadedFiles = new Array();
		
	this.workSpaceTop = 120;
	this.workSpaceLeft = 0;
	this.workSpaceWidth = screen.width - this.workSpaceLeft;
	this.workSpaceheight = screen.height - this.workSpaceTop - 20 - (this.isMSIE7 ? 35 : 0);

	// Fake MSIE on Opera and if Opera fakes IE, Gecko or Safari cancel those
	if (this.isOpera) {
		this.isMSIE = true;
		this.isGecko = false;
		this.isSafari =  false;
	}
	
	this.settings = {
		dialog_type : "modal",
		resizable : "yes",
		scrollbars : "yes"
	};
}

V3X.prototype.init = function(contextPath, language){	
	if(contextPath){
		this.baseURL = contextPath;
	}
	
	this.currentLanguage = language;		
	this.loadLanguage("/common/js/i18n");
}

/**
 * 
	var args = new Array();
	
	args['file']   = 'about.htm';
	args['width']  = 480;
	args['height'] = 380;
	
	v3x.openWindow(args});
 */
V3X.prototype.openWindow = function(args) {
	var html, width, height, x, y, resizable, scrollbars, url;

	this.windowArgs = args;

	html = args['html'];
		
	if(args["FullScrean"]){
		width = this.workSpaceWidth;
		height = this.workSpaceheight + this.workSpaceTop;
		
		x = 0;
		y = 0; 
	}
	else if(args["workSpace"]){
		width = this.workSpaceWidth;
		height = this.workSpaceheight;
		
		x = this.workSpaceLeft;
		y = this.workSpaceTop; 
	}
	else if(args["workSpaceRight"]){
		width = this.workSpaceWidth - 130;
		height = this.workSpaceheight;
		
		x = 130;
		y = this.workSpaceTop;
	}
	else{
		width = args['width'] || 320;
		height = args['height'] || 200;
		
		width = parseInt(width);
		height = parseInt(height);
		
		if (this.isMSIE){
			if(this.isMSIE7||this.isMSIE8){
				height -= 6;
			}
			else{
				height += 20;
			}
		}
		
		x = args["left"] || parseInt(screen.width / 2.0) - (width / 2.0);
		y = args["top"] || parseInt(screen.height / 2.0) - (height / 2.0);		
	}

	resizable = args['resizable'] || this.settings["resizable"];
	scrollbars = args['scrollbars'] || this.settings["scrollbars"];

	url = args['url'];

	if (html) {
		var win = window.open("", "v3xPopup" + new Date().getTime(), "top=" + y + ",left=" + x + ",scrollbars=" + scrollbars + ",dialog=yes,minimizable=" + resizable + ",modal=yes,width=" + width + ",height=" + height + ",resizable=" + resizable);
		if (win == null) {
			return;
		}

		win.document.write(html);
		win.document.close();
		win.resizeTo(width, height);
		win.focus();
		
		return win;
	}
	else {
		var dialog_type = args["dialogType"] || this.settings["dialog_type"];
		
		if (this.isMSIE && dialog_type == "modal") {
            var features = "resizable:" + resizable 
                + ";scroll:"
                + scrollbars + ";status:no;help:no;dialogWidth:"
                + 280 + "px;dialogHeight:" + 240 + "px;";
                
			if(args["workSpace"] || args["workSpaceRight"] || (args["left"] && args["top"])){
				features += "dialogTop:" + y + "px;dialogLeft:" + x + "px;";				
			}
            else{
            	features += "center:yes;";
            }
            
			return window.showModalDialog(url, window, features);
		}
		else {
			var rv = null;
			var modal = (resizable == "yes") ? "no" : "yes";

			if (this.isGecko && this.isMac)
				modal = "no";

			if (args['closePrevious'] != "no")
				try {this.lastWindow.close();} catch (ex) {}

			var win = window.open(url, "v3xPopup" + new Date().getTime(), "top=" + y + ",left=" + x + ",scrollbars=" + scrollbars + ",dialog=" + modal + ",minimizable=" + resizable + ",modal=" + modal + ",width=" + width + ",height=" + height + ",resizable=" + resizable);
			if (win == null) {
				return;
			}

			if (args['closePrevious'] != "no")
				this.lastWindow = win;

//			eval('try { win.resizeTo(width, height); } catch(e) { }');

			// Make it bigger if statusbar is forced
			if (this.isGecko) {
				if (win.document.defaultView.statusbar.visible)
					win.resizeBy(0, this.isMac ? 10 : 24);
			}

			win.focus();
			
			return win;
		}
	}
}

V3X.prototype.closeWindow = function(win) {
	win.close();
}

/**
 * 得到弹出当前窗口的直接父窗口
 */
V3X.prototype.getParentWindow = function(win){
	win = win || window;
	if(win.dialogArguments){
		return win.dialogArguments;
	}
	else{
		return win.opener;
	}
}

V3X.prototype.loadLanguage = function(url){
	this.loadScriptFile(this.baseURL + url + "/" + this.currentLanguage + ".js");
}

/**
 * JS的国际化
 */
V3X.prototype.getMessage = function(key){
	try{
		var msg = eval("" + key);
		
		if(msg && arguments.length > 1){
			for(var i = 0; i < arguments.length - 1; i++) {
				var regEx = eval("messageRegEx_" + i);
				msg = msg.replace(regEx, arguments[i + 1]);
			}
		}
		
		return msg;
	}
	catch(e){
	}
	
	return "";
}



/**
 * 
 */
V3X.prototype.loadScriptFile = function(url) {
	for (var i=0; i<this.loadedFiles.length; i++) {
		if (this.loadedFiles[i] == url)
			return;
	}

	document.write('<script language="javascript" type="text/javascript" src="' + url + '"></script>');

	this.loadedFiles[this.loadedFiles.length] = url;
};


/**
 * 是按钮失效，参数button支持id，和object
 * 
 */
function disableButton(button, height){
	height = height || "100%";
	if(!button){
		return false;
	}
	
	var el = null;
	if(typeof button == "string"){
		el = document.getElementById(button);
	}
	else{
		el = button;
	}
	
	if(!el){
		return false;
	}
	
	if(document.readyState != "complete")	{
		window.setTimeout("disableButton("+button+")", 300);
		return;
	}
	
	var cDisabled = el.cDisabled;
	cDisabled=(cDisabled!=null);
	if(!cDisabled){
		el.cDisabled = true;
		
		if(document.getElementsByTagName){
			var str  = "<span style='background: buttonshadow; filter: chroma(color=white) dropshadow(color=buttonhighlight, offx=1, offy=1); height: " + height + ";'>";
				str += "  <span style='filter: mask(color=white); height: " + height + "'>";
				str += el.innerHTML
				str += "  </span>";
				str += "</span>";
				
			el.innerHTML = str;
		}
		else{
			el.innerHTML='<span style="background: buttonshadow; width: 100%; height: 100%; text-align: center;">'+'<span style="filter:Mask(Color=buttonface) DropShadow(Color=buttonhighlight, OffX=1, OffY=1, Positive=0); height: 100%; width: 100%; text-align: center;">'+el.innerHTML+'</span>'+'</span>';
		}
	
		if(el.onclick!=null){
			el.cDisabled_onclick = el.onclick;
			el.onclick = null;
		}
		
		if(el.onmouseover!=null){
			el.cDisabled_onmouseover = el.onmouseover;
			el.onmouseover = null;
		}
		
		if(el.onmouseout!=null){
			el.cDisabled_onmouseout = el.onmouseout;
			el.onmouseout = null;
		}
	}
}

/**
 * 使按钮生效
 */
function enableButton(button){
	if(!button){
		return false;
	}
	
	var el = null;
	if(typeof button == "string"){
		el = document.getElementById(button);
	}
	else{
		el = button;
	}
	
	if(!el){
		return false;
	}

	var cDisabled=el.cDisabled;
	cDisabled=(cDisabled!=null);
	
	if(cDisabled){
		el.cDisabled=null;
		el.innerHTML=el.children[0].children[0].innerHTML;
		
		if(el.cDisabled_onclick!=null){
			el.onclick=el.cDisabled_onclick;
			el.cDisabled_onclick=null;
		}
		
		if(el.cDisabled_onmouseover!=null){
			el.onmouseover=el.cDisabled_onmouseover;
			el.cDisabled_onmouseover=null;
		}
		
		if(el.cDisabled_onmouseout!=null){
			el.onmouseout=el.cDisabled_onmouseout;
			el.cDisabled_onmouseout=null;
		}
		
	}	
}




/*********************************  日期选择器 *********************************************/
var __addDataEventObject = null;

/**
 * e.g whenstart('${pageContext.request.contextPath}', this, 575, 140);
 * 
 * @param contextPath 跟路径 ${pageContext.request.contextPath}
 * @param whoClick 要赋值的Object，如果为null，则返回日期数据
 * @param myLeft 距屏幕左面距离(废弃，去鼠标点击的位置) 
 * @param myTop 距屏幕上面距离(废弃，去鼠标点击的位置) 
 * @param type 选择类型 date datetime 默认 date
 * @param
 */
function whenstart(contextPath, whoClick, myLeft, myTop, type){
	type = type || "date";
	
	__addDataEventObject = whoClick;
	var rv = v3x.openWindow({
        url: contextPath + "/select.jsp?type=" + type+"&state=0",
        height: 230,
        width: 250,
        'top': event.screenY + 20,
        left: event.screenX - 50
	});
	
	if(!whoClick && rv){
		return rv;
	}
	
	return null;
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
 
/**ie8下模态对话框，聚焦不了**/
function setFocus(id){
	if(v3x){
		if(v3x.isMSIE8){
			document.getElementById(id).focus();
		}else{
			return;
		}
	}else{
		return;
	}
}

//创建日期插件函数
function creatCalendar(thisDom,param,url){
    var a=event.clientX;
	var b =event.clientY+length;
	url = "/icmp/system/portal/calendar";
	var type = param.dateType;
	whenstart(url,thisDom,a,b,type);
}
								


