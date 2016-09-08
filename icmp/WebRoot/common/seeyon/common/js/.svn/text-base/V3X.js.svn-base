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

var portalOfA8IframName = "frame_A8";


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
                + width + "px;dialogHeight:" + height + "px;";
                
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



/*************************************   附件  **********************************************************/

var attachmentConstants = {
	height : 18	
}

function downloadAttachment(fileId, createDate, filename){
	var contextPath = v3x.baseURL;
	var f = document.forms['downloadFileForm'];
	if(!f){
		var form = document.createElement("<form name='downloadFileForm' action='" + contextPath + "/fileUpload.do' method='get' target='downloadFileFrame' style='margin:0px;padding:0px'></form>");
		document.body.appendChild(form);
		form.appendChild(document.createElement("<input type='hidden' name='method' value='download'>"));
		form.appendChild(document.createElement("<input type='hidden' name='fileId' value=''>"));
		form.appendChild(document.createElement("<input type='hidden' name='createDate' value=''>"));
		form.appendChild(document.createElement("<input type='hidden' name='filename' value=''>"));

		f = document.forms['downloadFileForm'];
	}
	
	f.fileId.value = fileId;
	f.createDate.value = createDate;
	f.filename.value = filename;
	
	f.submit();
}

/**
 * 附件对象
 * 特别说明：needClone 是指，该附件需要复制，如：转发协同的原有附件需要复制一份
 */
function Attachment(id, reference, subReference, category, type, filename, mimeType, createDate, size, fileUrl, description, needClone,extension,icon){
	this.id = id;
	this.reference = reference;
	this.subReference = subReference;
	this.category = category;
	this.type = type;
	this.filename = filename;
	this.mimeType = mimeType;
	this.createDate = createDate;
	this.size = size;
	this.fileUrl = fileUrl;
	this.description = description || "";
	this.needClone = needClone;
	this.extension=extension;
	this.icon=icon;
}

/**
 * 在附件区显示附件
 */
Attachment.prototype.show = function(isShowLink, isShowClose){
	document.write(this.toString(isShowLink, isShowClose));
}

Attachment.prototype.toString = function(isShowLink, isShowDelete){
	var contextPath = v3x.baseURL;
	var str = "";

	str += "<div id='attachmentDiv_" + this.fileUrl + "' style='float: left;height: " + attachmentConstants.height + "px; line-height: 14px;' noWrap>"
	str += "<img src='" + contextPath + "/common/images/attachmentICON/" + this.icon + "' border='0' height='16' width='16' align='absmiddle' style='margin-right: 3px;'>";
	
	if(isShowLink && this.type == 0){//downloadURL
		str += "<a href=\"" + contextPath + "/fileUpload.do?method=download&fileId=" + this.fileUrl + "&createDate=" + this.createDate.substring(0, 10) + "&filename=" + encodeURIComponent(this.filename) + "\" title=\"" + escapeStringToHTML(this.filename) + "\" target='downloadFileFrame' style='font-size:12px'>";
	}
	
	if(this.type == 2 && this.description){	//文档
		var click = "";
		if(this.mimeType == "collaboration"){
			click = "openDetail('', 'from=Done&affairId=" + this.description + "&isQuote=true')";
		}
		if(this.mimeType == "edoc"){
			click = "openDetail('', 'from=Done&openFrom=glwd&affairId=" + this.description + "&isQuote=true')";
		}
		else if(this.mimeType == "km"){
			click = "openDetailURL('" + docURL + "?method=docOpenIframeOnlyId&openFrom=glwd&docResId=" + this.description + "')";
		}
		
		str += "<a class=\"like-a\" onclick=\"" + click + "\" title=\"" + escapeStringToHTML(this.filename) + "\" style='font-size:12px'>";
		isShowLink = true;
	}
		
	str += this.filename.getLimitLength(16).escapeHTML();
	
	if(this.size && this.type == 0){
		str += "(" + (parseInt(this.size/1024) + 1) + "KB)";
	}
	
	//显示链接
	if(isShowLink){
		str += "</a>";
	}
	
	//显示删除
	if(isShowDelete){
		str += "<img src='" + contextPath + "/common/images/attachmentICON/delete.gif' onclick='deleteAttachment(\"" + this.fileUrl + "\")' class='cursor-hand' title='" + v3x.getMessage('V3XLang.attachment_delete') + "' height='11' align='absmiddle'>";		
	}
	
	str += "&nbsp;</div>";
	
	return str;
}

function openDetailURL(_url) {
    var rv = v3x.openWindow({
        url: _url,
        workSpace: 'yes'
    });
}

/**
 * 将附件对象转换成数据框
 */
Attachment.prototype.toInput = function(){
	var str = "";
	str += "<input type='hidden' name='attachment_id' value='" + this.id + "'>";
	str += "<input type='hidden' name='attachment_reference' value='" + this.reference + "'>";
	str += "<input type='hidden' name='attachment_subReference' value='" + this.subReference + "'>";
	str += "<input type='hidden' name='attachment_category' value='" + this.category + "'>";
	str += "<input type='hidden' name='attachment_type' value='" + this.type + "'>";
	str += "<input type='hidden' name='attachment_filename' value='" + escapeStringToHTML(this.filename) + "'>";
	str += "<input type='hidden' name='attachment_mimeType' value='" + this.mimeType + "'>";
	str += "<input type='hidden' name='attachment_createDate' value='" + this.createDate + "'>";
	str += "<input type='hidden' name='attachment_size' value='" + this.size + "'>";
	str += "<input type='hidden' name='attachment_fileUrl' value='" + this.fileUrl + "'>";
	str += "<input type='hidden' name='attachment_description' value='" + this.description + "'>";
	str += "<input type='hidden' name='attachment_needClone' value='" + this.needClone + "'>";
	
	return str;
}

/**
 * 显示附件
 */
function showAttachment(subRef, type, attachmentTrId, numberDivId){
	try{
		if(!theToShowAttachments){
			return;
		}
		var attachmentNumber = 0;
		var str = "";
		for(var i = 0; i < theToShowAttachments.size(); i++) {
			var att  = theToShowAttachments.get(i);
			
			if(att.subReference == subRef && att.type == type){
				str += att.toString(true, false);
				
				attachmentNumber++;
			}
		}
		document.write(str);
		document.close();
		
		if(attachmentNumber > 0){
			if(attachmentTrId){
				var attachmentTr = document.getElementById(attachmentTrId);
				
				if(attachmentTr){
					attachmentTr.style.display = "";
				}
			}
			if(numberDivId){
				var attachmentNumberDiv = document.getElementById(numberDivId);
				if(attachmentNumberDiv){
					attachmentNumberDiv.innerHTML = "" + attachmentNumber;
				}
			}
		}
	}
	catch(e){
	}
}
/**
 * 展开附件区域
 */
function exportAttachment(obj){
	if(obj.getAttribute('expand')){
		return;
	}
	
	var originalClassName = obj.className;
	obj.className = 'div-float';
	
	var h = obj.scrollHeight;
	if(h >= (attachmentConstants.height * 2)){
		obj.className = 'attachment-all-80';
	}
	else{
		obj.className = originalClassName;
	}
	
	obj.setAttribute('expand', "yes");
}

/**********************************************/
/* 一下方法用在上传
/**********************************************/
var fileUploadAttachments = new Properties();
// 上传数量
var fileUploadQuantity = 5;

/**
 * 是否上传了附件
 */
function isUploadAttachment(){
	return !fileUploadAttachments.isEmpty();
}

/**
 * 将附件转成input
 */
function saveAttachment(){
	var atts = fileUploadAttachments.values();
	
	if(!atts || atts.isEmpty()){
		return true;
	}
	
	var attInputStr = "";
	for(var i=0; i<atts.size(); i++) {
		attInputStr += atts.get(i).toInput();
	}
	
	var attachmentInputsObj = document.getElementById("attachmentInputs");
	if(attachmentInputsObj){
		attachmentInputsObj.innerHTML = attInputStr;
	}
	else{
		alert("Warn: Save attachments unsuccessful")
		return false;
	}
	
	return true;
}

/**
 * 设置附件的是否复制属性
 */
function cloneAllAttachments(){
	var atts = fileUploadAttachments.values();

	for(var i = 0; i < atts.size(); i++) {
		atts.get(i).needClone = true;
	}
}

/**
 * 删除附件
 */
function deleteAttachment(fileUrl, showAlert){
	var file = fileUploadAttachments.get(fileUrl);
	if(file == null){
		return;
	}
	
	if(showAlert != false && !confirm(v3x.getMessage("V3XLang.attachment_delete_alert", file.filename))){
		return;
	}
	
	fileUploadAttachments.remove(fileUrl);
	document.getElementById("attachmentDiv_" + fileUrl).removeNode(true);
	
	showAttachmentNumber(file.type);
	
	var num = getFileAttachmentNumber(file.type);
	if(num < 1){
		showAtachmentTR(file.type, "none");
	}
}

/**
 * 按钮事件
 */
function insertAttachment(){
	v3x.openWindow({
		url		: downloadURL + "&quantity=" + fileUploadQuantity,
		width	: 400,
		height	: 220,
		resizable	: "yes"
	});
}

/**
 * 添加附件
 */	
function addAttachment(type, filename, mimeType, createDate, size, fileUrl, canDelete, needClone, description,extension,icon) {
	canDelete = canDelete == null ? true : canDelete;
	needClone = needClone == null ? false : needClone;
	description = description ==null ? "" : description;
	var attachment = new Attachment('', '', '', '', type, filename, mimeType, createDate, size, fileUrl, description, needClone,extension,icon);
	if(fileUploadAttachments.containsKey(fileUrl)){
		return;
	}
	fileUploadAttachments.put(fileUrl, attachment);
	
	showAtachmentObject(attachment, canDelete)
	showAtachmentTR(type);
	showAttachmentNumber(type);
}

function deleteAllAttachment(uploadNum)
{
	var keys = fileUploadAttachments.keys();
	for(var i = 0; i < keys.size(); i++) {
		var att = fileUploadAttachments.get(keys.get(i));
		if(att.type == uploadNum){
			fileUploadAttachments.remove(keys.get(i));
			i -= 1;
		}
	}
	
	var id = "attachmentArea";
	if(uploadNum != 0){
		id = "attachment" + uploadNum + "Area";
	}
	
	var attachmentAreaObj = document.getElementById(id);
	if(attachmentAreaObj){
		attachmentAreaObj.style.display = "";
		attachmentAreaObj.innerHTML ="";
	}
	
	var id = "attachmentTR";
	if(uploadNum != 0){
		id = "attachment" + uploadNum + "TR";
	}
		
	var attachmentTRObj = document.getElementById(id);
	if(attachmentTRObj){
		//_display = _display || "";
		attachmentTRObj.style.display = "none";
		//attachmentTRObj.innerHTML="";
	}
}

/**
 * 显示附件对象
 */
function showAtachmentObject(attachment, canDelete){
	if(!attachment){
		return
	}
	var id = "attachmentArea";
	if(attachment.type != 0){
		id = "attachment" + attachment.type + "Area";
	}
	
	var attachmentAreaObj = document.getElementById(id);
	if(attachmentAreaObj){
		attachmentAreaObj.style.display = "";
		attachmentAreaObj.innerHTML += attachment.toString(true, canDelete);
	}
}

/**
 * 显示附件行
 * @type 附件类型
 * @param _display style.display值，默认显示
 */
function showAtachmentTR(type, _display){
	var id = "attachmentTR";
	if(type != 0){
		id = "attachment" + type + "TR";
	}
		
	var attachmentTRObj = document.getElementById(id);
	if(attachmentTRObj){
		_display = _display || "";
		attachmentTRObj.style.display = _display;
	}
}

/**
 * 显示文件附件的数量
 */
function showAttachmentNumber(type){
	var id = "attachmentNumberDiv";
	if(type != 0){
		id = "attachment" + type + "NumberDiv";
	}
		
	var attachmentNumberDivObj = document.getElementById(id);
	if(attachmentNumberDivObj){
		attachmentNumberDivObj.innerText = getFileAttachmentNumber(type);
	}
}

/**
 * 文件附件的数量
 */
function getFileAttachmentNumber(type){
	var number = 0;
	
	var files = fileUploadAttachments.values();
	if(!files){
		return number;
	}
	
	for(var i = 0; i < files.size(); i++) {
		if(files.get(i).type == type){
			number++;
		}
	}
		
	return number;
}



/********************************************  选人界面实体 **************************************************
 * @param type 实体类型：Member/Department/Post/Level
 * @param id 对应的实体InternalId
 * @param name 实体名称
 * @param typeName 实体类型名称：人员/部门/岗位/职务级别
 * @param acountId 所属单位id
 * @param accountShortname 所属单位别名
 * @author tanmf 
 * Select People Element
 */
function Element(type, id, name, typeName, accountId, accountShortname, description){
	this.type = type;
	this.id = id;
	this.name = name;
	this.typeName = typeName;
	this.accountId = accountId || "";
	this.accountShortname = accountShortname || "";
	this.description = description;
	this.entity = null;
}

Element.prototype.copy = function(anth){
	this.type = anth.type;
	this.id = anth.id;
	this.name = anth.name;
	this.typeName = anth.typeName;
	this.accountId = anth.accountId;
	this.accountShortname = anth.accountShortname;
	this.description = anth.description;
}

Element.prototype.toString = function(){
	return this.type + "\t" + this.id + "\t" + this.name + "\t" + this.typeName + "\t" + this.accountId + "\t" + this.accountShortname;
}

/**
 * 得到Element[] 的所有名称，格式为: 谭敏锋,李立,开发部
 */
function getNamesString(elements){
	if(!elements){
		return "";
	}
	
	var sp = v3x.getMessage("V3XLang.common_separator_label");
	
	var names = [];
	for(var i = 0; i < elements.length; i++) {
		var e = elements[i];
		var _name = null;
		if(e.accountShortname){
			_name = e.name + "(" + e.accountShortname + ")";
		}
		else{
			_name = e.name;
		}
		
		names[names.length] = _name;
	}
	
	return names.join(sp);
}

/**
 * 得到Element[] 的所有Id，格式为: 
 * 1、如果：needType 为 true
 * Member|0977614325432,Member|23456754365745,Department|3451234132
 * 2、如果：needType 为 false
 * 0977614325432,23456754365745,3451234132
 * 
 * @needType 是否要类型标示 默认为true
 */
function getIdsString(elements, needType){
	if(!elements){
		return "";
	}
	
	if(needType == null){
		needType = true;
	}
	
	var names = [];
	for(var i = 0; i < elements.length; i++) {
		if(needType){
			names[names.length] = elements[i].type + "|" + elements[i].id;
		}
		else{
			names[names.length] = elements[i].id;
		}
	}
	
	return names.join(",");
}

/**
 * 将Member|0977614325432|谭敏锋|123412,Department|3451234132|开发部|1234123格式的人员数据转换成Element[]
 * 该方法只用在回显选人界面数据
 * 
 * e.g
 * String people = "Member|0977614325432|谭敏锋|123412,Department|3451234132|开发部|1234123";
 * <script>
 * elements_${选人组件id} = parseElements(people);
 * </script>
 * 
 * @param idsString 格式为 EntityType|EntityId|EntityName|AccountId
 * @param type 数据类型
 * @return Element[]，但不解释现实的名称，
 */
function parseElements(idsString){
	if(!idsString || idsString == "null"){
		return null;
	}
	
	var elements = [];
	
	var enteries = idsString.split(",");
	for(var i = 0; i < enteries.length; i++) {
		if(!enteries[i]){
			continue;
		}
		
		var e = enteries[i].split("|");
		if(e.length == 4){
			var element = new Element(e[0], e[1], e[2], null, e[3], null, '');
			
			elements[elements.length] = element;
		}
	}

	return elements;
}

/**
 * parseElements4Exclude("Member|0977614325432,Department|3451234132");
 * parseElements4Exclude("0977614325432,3451234132", "Member");
 * 
 * @param idsString Member|0977614325432,Department|3451234132
 * @param type 指定类型
 */
function parseElements4Exclude(idsString, type){
	if(!idsString || idsString == "null"){
		return null;
	}
	
	var elements = [];
	
	var enteries = idsString.split(",");
	for(var i = 0; i < enteries.length; i++) {
		if(!enteries[i]){
			continue;
		}
		
		if(type){
			elements[elements.length] = new Element(type, enteries[i]);
		}
		else{
			var e = enteries[i].split("|");
			if(e.length == 2){
				var element = new Element(e[0], e[1]);
				
				elements[elements.length] = element;
			}
		}
	}

	return elements;
}

/**
 * 得到Element[] 的所有Id专程input，如：
 * 1、如果：needType 为 true
 * <input type='hidden' name='person' value="Member|43265345643564356">
 * <input type='hidden' name='person' value="Member|56732452435345234">
 * <input type='hidden' name='person' value="Department|-445652435345234">
 * 2、如果：needType 为 false
 * <input type='hidden' name='person' value="43265345643564356">
 * <input type='hidden' name='person' value="56732452435345234">
 * <input type='hidden' name='person' value="-445652435345234">
 * 
 * @needType 是否要类型标示 默认为true
 */
function getIdsInput(elements, inputName, needType){
	if(!elements){
		return "";
	}
	
	if(needType == null){
		needType = true;
	}
	
	var str = "";
	for(var i=0; i<elements.length; i++) {
		if(needType){
			str += "<input type='hidden' name='"+inputName+"' value=\"" + elements[i].type + "|" + elements[i].id + "\">";
		}
		else{
			str += "<input type='hidden' name='"+inputName+"' value=\"" + elements[i].id+"\">";
		}
	}
	
	return str;
}

/***************************************************  AJAX ******************************************************/

var AJAX_XMLHttpRequest_DEFAULT_METHOD = "POST";

var AJAX_XMLHttpRequest_DEFAULT_async = true; //默认异步

var AJAX_RESPONSE_XML_TAG_BEAN = "B";
var AJAX_RESPONSE_XML_TAG_LIST = "L";
var AJAX_RESPONSE_XML_TAG_Value = "V";
var AJAX_RESPONSE_XML_TAG_Property = "P";
var AJAX_RESPONSE_XML_TAG_Name = "n";


/**
 * AJAX Service Parameter
 */
function AjaxParameter(){
	this.instance =[];
};

AjaxParameter.prototype.put = function(index, type, value){
	var isArray = type.indexOf("[]") > -1;
	
	this.instance[this.instance.length] = {
		index : index,
		type  : isArray ? type.substring(0, type.length - 2) : type,
		value : value,
		isArray : isArray
	};
};

/**
 *
 */
AjaxParameter.prototype.toAjaxParameter = function(serviceName, methodName, needCheckLogin){
	needCheckLogin = needCheckLogin == null ? "false" : needCheckLogin;
	if(!serviceName || !methodName){
		return null;
	}
	
	var str = "";
		str += "S=" + serviceName;
		str += "&M=" + methodName; 
		str += "&CL=" + needCheckLogin; 

	if(this.instance != null && this.instance.length > 0){
		for(var i = 0; i < this.instance.length; i++){
			var obj = this.instance[i];
			
			var paramterName = "P_" + obj.index + "_" + obj.type;
			
			if(obj.isArray){//数组
				if(obj.value == null || obj.value.length == 0){
					str += "&" + paramterName + "_A";
				}
				else if(obj.value instanceof Array){
					for(var k = 0; k < obj.value.length; k++) {
						str += "&" + paramterName + "_A=" + encodeURIComponent(obj.value[k]);
					}
				}
			}
			else{
				var v = obj.value == null ? "" : obj.value;
				str += "&" + paramterName + "=" + encodeURIComponent(v);
			}
		}
	}
		
	return str;
};

/**
 * Browser independent XMLHttpRequestLoader
 * 
 * @param _caller d
 */
function XMLHttpRequestCaller(_caller, serviceName, methodName, async, method, needCheckLogin, actionUrl) {
	if((!serviceName || !methodName) && !actionUrl){
		alert("AJAX Service name or method, actionUrl is not null.");
		throw new Error(3, "AJAX Service name or method is not null.");
	}
	
	this.params = new AjaxParameter();
	this.serviceName = serviceName;
	this.methodName = methodName;
	this.needCheckLogin = needCheckLogin == null ? "true" : needCheckLogin;

	this.method = method || AJAX_XMLHttpRequest_DEFAULT_METHOD;
	this.async = (async == null ? AJAX_XMLHttpRequest_DEFAULT_async : async);
	this._caller = _caller;
	this.actionUrl = actionUrl;
	
	this.filterLogoutMessage = true;
};

/**
 * 
 * caller.addParameter(1, "String", "a8");
 * caller.addParameter(2, "Long", 2345234);
 * caller.addParameter(3, "String[]", ["tanmf", "jicnm", "maok", ""]);
 * caller.addParameter(4, "date", "2007-01-01 12:25:23");
 * 
 * @param index 参数顺序，从1开始
 * @param type 参数类型 当前支持byte Byte short Short int Integer long Long double Double float Float boolean Boolean char character String date datetime
 * @param value 参数值 可以是数组
 */
XMLHttpRequestCaller.prototype.addParameter = function(index, type, value) {
	this.params.put(index, type, value);
};

/**
 * 发出请求
 */
XMLHttpRequestCaller.prototype.serviceRequest = function() {    
	var url = null;
	var sendContent = null;
	if(this.actionUrl){
		url = getBaseURL() + this.actionUrl;
	}
	else{
		var _url = getBaseURL() + "/getAjaxDataServlet"
		var _queryString = this.params.toAjaxParameter(this.serviceName, this.methodName, this.needCheckLogin);
		if(!_queryString){
			throw new Error(5, "没有任何参数");
		}
		
		if(_queryString.length < 500){
			this.method = "GET";
		}
		
		if(this.method.toUpperCase() == "POST" ){
			url = _url;
			sendContent = _queryString;
		}
		else if(this.method.toUpperCase() == "GET" ){
			url = _url + "?" + _queryString
		}
	}
	
	var xmlRequest = getHTTPObject();
	var c = this._caller;
	var flm = this.filterLogoutMessage;
	
	if(!xmlRequest){
		throw new Error(2, "当前浏览器不支持XMLHttpRequest");
	}

	if(this.async){	//异步
		xmlRequest.onreadystatechange = function() {
			if (xmlRequest.readyState == 4){
				if (xmlRequest.status == 200){
					var returnValue = xmlHandle(xmlRequest.responseXML);
//					window.clipboardData.setData("text", xmlRequest.responseTEXT);
					if(!returnValue){
						returnValue = doFilterLogoutMessage(xmlRequest.responseTEXT, flm);
					}
		
					c.invoke(returnValue);	//回调主函数
				}
				else{
					if(c && c.showAjaxError){
						c.showAjaxError(xmlRequest.status);
					}
					else{
						c.invoke(null);
					}
				}
			}
		};
	}
	
	xmlRequest.open(this.method, url, this.async);
	xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlRequest.send(sendContent);

	if(!this.async) { //同步
		if (xmlRequest.readyState == 4){
			if (xmlRequest.status == 200){
				var returnValue = xmlHandle(xmlRequest.responseXML);
//				window.clipboardData.setData("text", xmlRequest.responseTEXT);
				if(!returnValue){
					returnValue = doFilterLogoutMessage(xmlRequest.responseTEXT, flm);
				}
				
				return returnValue;
			}
			else{
//				throw "There was a problem retrieving the XML data:\n" + xmlRequest.statusText + " for AjAX Service: \n" + this.serviceName + "." + this.methodName;
			}
		}
	}
};

function doFilterLogoutMessage(result, filterLogoutMessage){
	if(filterLogoutMessage == false || result == null){
		return result;
	}

	if(result.indexOf("[LOGOUT]") == 0){
		//alert(result.substring(8));
		return null;
	}
	
	return result;
}

/**
 * 解析XML
 */
function xmlHandle(xmlDom){
	if(!xmlDom){
		return null;
	}
  
	try{
		var root = xmlDom.documentElement;
		if(null != root) {
			var type = root.nodeName;

			if(type == AJAX_RESPONSE_XML_TAG_BEAN){
				return  beanXmlHandle(root);//bean xml
			}
			else if(type == AJAX_RESPONSE_XML_TAG_LIST){
				return  listXmlHandle(root);//bean xml
			}
			else if(type == AJAX_RESPONSE_XML_TAG_Value){
				return root.firstChild.nodeValue;
			}
		}
	}
	catch (e) {
		throw e.message;
	}
  
	return null;
};

/**
 * 解析
 * @return Properties
 */
function beanXmlHandle(_node){
	if(!_node){
		return null;
	}

	var properties = new Properties();
	properties.type = "";

	var propertys = _node.childNodes;

	if(propertys != null && propertys.length > 0){
		for (var i = 0; i < propertys.length; i++) {
			var key = propertys[i].attributes.getNamedItem(AJAX_RESPONSE_XML_TAG_Name).nodeValue;
			var value = "";

			var fChild = propertys[i].firstChild;

			if(fChild != null){
				if(fChild.childNodes != null && fChild.childNodes.length > 0){ //有子节点
					var type = fChild.nodeName;
					
					if(type == AJAX_RESPONSE_XML_TAG_BEAN){
				    	value = beanXmlHandle(fChild);
				    }
				    else if(type == AJAX_RESPONSE_XML_TAG_LIST){
				    	value = listXmlHandle(fChild);
				    }
				    else if(type == AJAX_RESPONSE_XML_TAG_Value){
				    	value = fChild.firstChild.nodeValue;
				    }
				}
				else{
					value = fChild.nodeValue;
				}
			}

			properties.putRef(key, (value));
		}
	}

	return properties;
};

/**
 *
 * @return Array Properties[]
 */
function listXmlHandle(_node){
	var list = new Array();

	if(_node != null){
		var properties = new Properties();
		var beans = _node.childNodes;

		if(beans != null && beans.length > 0){
			for (var i = 0; i < beans.length; i++) {
				var type = beans[i].nodeName;
				var returnVal = "";	
	        
				if(type == AJAX_RESPONSE_XML_TAG_BEAN){
					returnVal = beanXmlHandle(beans[i]);
				}
				else if(type == AJAX_RESPONSE_XML_TAG_LIST){
					returnVal =  listXmlHandle(beans[i]);
				}
				else if(type == AJAX_RESPONSE_XML_TAG_Value){
					returnVal = beans[i].firstChild.nodeValue;
				}
	        
				list[i] = returnVal;
			}
		}
	}

	return list;
};


/** Cross browser XMLHttpObject creator */
function getHTTPObject() 
{
  var xmlhttp;
  /*@cc_on
  @if (@_jscript_version >= 5)
    try {
      xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e) {
      try {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
      } 
      catch (E) {
        xmlhttp = false;
      }
    }
  @else
  xmlhttp = false;
  @end @*/
  if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
    try {
      xmlhttp = new XMLHttpRequest();
    } 
    catch (e) {
      xmlhttp = false;
    }
  }
  return xmlhttp;
};


function getBaseURL(){
	try{
		if(v3x){
			return v3x.baseURL;
		}
		else if(parent.v3x){
			return parent.v3x.baseURL;
		}
		else if(getA8Top().v3x){
			return getA8Top().v3x.baseURL;
		}
		else if(getA8Top().conextPath){
			return getA8Top().conextPath;
		}
	}
	catch(e){
	}
	
	return "/seeyon";
};
//////*************zhangh add 以ajax方式提交form数据，采用post方式，提交url从form的action中读取,返回数据为Properties对象或者对象数组*********************************////////
function ajaxFormSubmit(formObj)
{
  var AjaxParams=new AjaxParameter();
  var xmlRequest=getHTTPObject();
  var _queryString=AjaxParams.FormToAjaxParameter(formObj); 
  xmlRequest.open("post",formObj.action,false);
  xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
  xmlRequest.send(_queryString);
  if (xmlRequest.readyState == 4)
  {
	if (xmlRequest.status == 200)
	{
		var returnValue = xmlHandle(xmlRequest.responseXML);
		if(returnValue==null)
		{
			returnValue=xmlRequest.responseTEXT;
			if(returnValue.search("<")>0)
			{
				returnValue=returnValue.substr(returnValue.search("<"));
				returnValue=getXMLDoc(returnValue);	
				returnValue = xmlHandle(returnValue);				
			}
			else
			{
				return returnValue;
			}
		}		
		if(!returnValue)
		{			
			returnValue = xmlRequest.responseTEXT;	
		}		
		return returnValue;
	}
	else
	{
		return false;
	}
  }
  return false;
};
function getXMLDoc(xmlText){
  if(window.ActiveXObject){
   xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
   xmlDoc.async=false;
   xmlDoc.onreadystatechange = function() 
   {
    //if(xmlDoc.readyState == 4) doAction();
   }
   xmlDoc.loadXML(xmlText);
  }else if(document.implementation&&document.implementation.createDocument){
   xmlDoc=document.implementation.createDocument('','',null);
   //xmlDoc.onload=doAction();
   xmlDoc.loadXML(xmlText);
  }else return null;
  return xmlDoc;
 };
 
////////////**************************Ajax 方式 直接提交Form数据时，把form中的数据转换成request 格式的ajax参数  zhangh add************************////////////////////
//formObj:form对象
AjaxParameter.prototype.FormToAjaxParameter = function(formObj)
{  
  var submitData="";
  var ds=new Properties();
  var i;
  var obj,objValue;
  var tempValue;
  for(i=0;i<formObj.elements.length;i++)
  {
    obj=formObj.elements(i);
    if(obj.disabled){continue;}
    if(obj.type=="select-one" || obj.type=="hidden" || obj.type=="password" || obj.type=="text" || obj.type=="textarea")
    {
    	ds.put(obj.name,obj.value);
    }
    else if(obj.type=="select-multiple" || obj.type=="checkbox" || obj.type=="radio")
    {
      objValue=ds.get(obj.name);
      tempValue=getFormInputValue(obj);
      if(tempValue!="")
      {
        if(objValue!=null && objValue!="")
        {
          objValue+=",";          
        }
        else
        {
          objValue=tempValue;
        }
      }
      if(objValue==null){objValue="";}
      ds.put(obj.name,objValue);
    }
    submitData=ds.toQueryString();
  }
  return submitData;
};

function getFormInputValue(inputObj)
{
  var tempValue="";
  var i;
  var objs;
  if(inputObj.type=="select-multiple")
  {
    for(i=0;i<inputObj.options.length;i++)
    {
      if(inputObj.options[i].selected==true)
      {
        if(tempValue!=""){tempValue+=",";}
        tempValue+=inputObj.options[i].value;
      }
    }
  }
  else if(inputObj.type=="checkbox" || inputObj.type=="radio")
  {
    objs=document.getElementsByName(inputObj.name);
    for(i=0;i<objs.length;i++)
    {
      if(objs[i].checked==true)
      {
        if(tempValue!=""){tempValue+=",";}
        tempValue+=objs[i].value;
      }
    }    
  }
  return tempValue;
};
///////////***************************Ajax 方式 直接提交Form数据时，把form中的数据转换成ajax参数 结束***********************************************/////////////////
/**********************************************  表格排序  *****************************************************/

var dom = (document.getElementsByTagName) ? true : false;
var ie5 = (document.getElementsByTagName && document.all) ? true : false;

var arrowUp, arrowDown;

if (ie5 || dom)
	initSortTable();

function initSortTable() {
	arrowUp = document.createElement("SPAN");
	var tn = document.createTextNode("5");
	arrowUp.appendChild(tn);
	arrowUp.className = "arrow";

	arrowDown = document.createElement("SPAN");
	var tn = document.createTextNode("6");
	arrowDown.appendChild(tn);
	arrowDown.className = "arrow";
};

function sortTable(tableNode, nCol, bDesc, sType) {
	var tBody = tableNode.tBodies[0];
	var trs = tBody.rows;
	var a = new Array();

	for (var i=0; i<trs.length; i++) {
		a[i] = trs[i];
	}

	a.sort(compareByColumn(nCol,bDesc,sType));

	for (var i=0; i<a.length; i++) {
		tBody.appendChild(a[i]);
	}
};

function CaseInsensitiveString(s) {
	return String(s).toLocaleString();
};

function parseDate(s) {
	return Date.parse(s.replace(/\-/g, '/'));
}

function toNumber(s) {
    return Number(s.replace(/[^0-9\.]/g, ""));
};

function compareByColumn(nCol, bDescending, sType) {
	var c = nCol;
	var d = bDescending;

	var fTypeCast = String;

	if (sType == "Number")
		fTypeCast = parseInt;
	else if (sType == "Date")
		fTypeCast = String; //显作为字符串
	else if (sType == "CaseInsensitiveString")
		fTypeCast = CaseInsensitiveString;

	return function (n1, n2) {
	    if(fTypeCast == String || fTypeCast == CaseInsensitiveString){
	    	var f = fTypeCast(getInnerText(n1.cells[c])).localeCompare(fTypeCast(getInnerText(n2.cells[c])));
	    	if(d){
	    		return f * -1;
	    	}else{
	    		return f;
	    	}
	    }
	    else{
			if (fTypeCast(getInnerText(n1.cells[c])) < fTypeCast(getInnerText(n2.cells[c])))
				return d ? -1 : +1;
			if (fTypeCast(getInnerText(n1.cells[c])) > fTypeCast(getInnerText(n2.cells[c])))
				return d ? +1 : -1;
			return 0;
	    }
	};
};


function sortColumn(e, isChangeTRColor) {
	var tmp, el, tHeadParent;

	if (ie5)
		tmp = e.srcElement;
	else if (dom)
		tmp = e.target;
		
	tHeadParent = getParent(tmp, "THEAD");
	
	var tFooterParent = getParent(tmp, "TFOOT");
	
	if(tmp.tagName == "TD" && tFooterParent == null && tHeadParent == null && isChangeTRColor == true){	//如果点击的是表格中的数据单元格，则选择该行
		selectRow(tmp);
	}

	el = getParent(tmp, "TD");
	
	if(el == null || el.type == null || el.type == ""){
		return;
	}

	if (tHeadParent == null)
		return;

	if (el != null) {
		var p = el.parentNode;
		var i;

		if (el._descending)	// catch the null
			el._descending = false;
		else
			el._descending = true;

		if (tHeadParent.arrow != null) {
			if(tHeadParent.arrow.parentNode == null){
				tHeadParent.arrow = null;
			}
			else{
				if (tHeadParent.arrow.parentNode != el) {
					tHeadParent.arrow.parentNode._descending = null;	//reset sort order
				}
				tHeadParent.arrow.parentNode.removeChild(tHeadParent.arrow);
			}
		}

		if (el._descending)
			tHeadParent.arrow = arrowDown.cloneNode(true);
		else
			tHeadParent.arrow = arrowUp.cloneNode(true);

		el.appendChild(tHeadParent.arrow);

		// get the index of the td
		for (i=0; i<p.cells.length; i++) {
			if (p.cells[i] == el) break;
		}

		var table = getParent(el, "TABLE");
		// can't fail

		sortTable(table,i,el._descending, el.getAttribute("type"));
	}
};


function getInnerText(el) {
	if (ie5) return el.innerText;	//Not needed but it is faster

	var str = "";

	for (var i=0; i<el.childNodes.length; i++) {
		switch (el.childNodes.item(i).nodeType) {
			case 1: //ELEMENT_NODE
				str += getInnerText(el.childNodes.item(i));
				break;
			case 3:	//TEXT_NODE
				str += el.childNodes.item(i).nodeValue;
				break;
		}
	}

	return str;
};

function getParent(el, pTagName) {
	if (el == null) return null;
	else if (el.nodeType == 1 && el.tagName.toLowerCase() == pTagName.toLowerCase())	// Gecko bug, supposed to be uppercase
		return el;
	else
		return getParent(el.parentNode, pTagName);
};

var currentSelectTr = null;

function clearSiblingStyle(objTr){
	var siblings = objTr.parentNode.childNodes;
	
	if(siblings != null){
		for(var i = 0; i < siblings.length; i++){
			var o = siblings[i];
			redoStyle(o);
		}
	}
};
/**
 * 把行的颜色还原为原始颜色
 */
function redoStyle(){
	var obj = currentSelectTr;
	if(!obj){
		return;
	}
	
	var nowClassName = obj.className;
	var oldClassName = obj.className2;
	
	if(oldClassName != null && nowClassName != oldClassName){
		obj.className = oldClassName;
	}
	
	var thisCheckbox = getCheckboxFromTr(obj);
		
	if(thisCheckbox && thisCheckbox.disabled != true){
		thisCheckbox.checked = false;
	}
	
	var children = obj.cells;
	
	for(var i = 0; i < children.length; i++) {
		var td = children.item(i);
		var cn = td.className;
		var cns = cn.split(" ");
		
		var cnnew = "";
		
		for(var j = 0; j < cns.length; j++) {
			if(cns[j] != "no-read"){
				cnnew += cns[j] + " ";
			}
		}
		
		td.className = cnnew;
	}
};

/**
 * 把行的颜色改为被选的颜色，样式名为sort-select
 */
function changeSelectedStyle(obj){
	if(obj == null){
		return;
	}
	
	var nowClassName = obj.className;
	var oldClassName = obj.className2;
		
	if(oldClassName == null){ //第一次点击
		obj.className2 = nowClassName; //创建新的标签属性
		obj.className = "sort-select";
	}
	else if(nowClassName == oldClassName){ //当前样式为老样式
		obj.className = "sort-select";
	}
	else{ //还原为老样式
		obj.className = oldClassName;
	}
};

/**
 *
 */
function selectRow(currentTd){
	if(currentTd.tagName == "INPUT"){
		unselectAll();
		return;
	}
	var currentTr = getParent(currentTd, "TR");
	var currentTbody = getParent(currentTr, "tbody");

	if(currentTr != null && currentTbody != null){
//		clearSiblingStyle(currentTr);
		redoStyle();
		changeSelectedStyle(currentTr);
		
		currentSelectTr = currentTr;
				
		var thisCheckbox = getCheckboxFromTr(currentTr);
		if(thisCheckbox != undefined && thisCheckbox != null) {
			noSelected(thisCheckbox.name);
			
			if(thisCheckbox.disabled != true){
				thisCheckbox.checked = true;
			}
			
			unselectAll();
		}
	}
};

/**
 * 从TR中找chechbox以及radio
 * @param thisTr - TR object
 * @return chechbox object
 */
function getCheckboxFromTr(thisTr) {
	if(thisTr == null || thisTr.childNodes.length == 0) {
		return null;
	}
	else {
		for(var i=0; i<thisTr.childNodes.length; i++) {
			var thisChild = thisTr.childNodes[i];
			if(thisChild.type == "checkbox" || thisChild.type == "radio") {
				return thisChild;
			}
			else {
				var tempResult = getCheckboxFromTr(thisChild);
				if(tempResult != null) {
					return tempResult;
				}
			}
		}
	}
}

function selectAll(allButton, targetName){
	var objcts = document.getElementsByName(targetName);
	
	if(objcts != null){
		for(var i = 0; i < objcts.length; i++){
			if(objcts[i].disabled == true){
				continue;
			}
			objcts[i].checked = allButton.checked;
		}
	}
};

function noSelected(checkboxName){
	var checkboxes = document.getElementsByName(checkboxName);
	if(checkboxes){
		for(var i = 0; i < checkboxes.length; i++) {
			if(checkboxes[i].disabled == true){
				continue;
			}
			checkboxes[i].checked = false;
		}
	}
};

function unselectAll(){
	var objcts = document.getElementById("allCheckbox");
	if(objcts && objcts.disabled != true){
		objcts.checked = false;
	}
};


/****************** 分页 ************************/
var canDoAction = true; //避免重复提交-锁 
function getPageAction(obj){	

	var form1 = getForm(obj);
	if(!form1){
		return;
	}
	if(!canDoAction){
		return;
	}
	form1.attributes.getNamedItem("METHOD").nodeValue = "get";

	var keys = pageQueryMap.keys();
	for(var i=0; i<keys.size(); i++){
		var key = keys.get(i);
		var value = pageQueryMap.get(key);
		if(!key || key == "pageSize"){
			continue;
		}

		if(typeof value == "object"){
			
	    }
		else{
			var str = "<input type='hidden' name=\"" + key + "\">";
			var e = document.createElement(str);
			e.value = value;
			form1.appendChild(e);
		}
	}
	
	var v = form1.pageSize.value;
	if(!new RegExp("^-?[0-9]*$").test(v) || parseInt(v, 10) < 1){
		form1.pageSize.value = 20;
		form1.page.value = 1;
	}
	//window.clipboardData.setData("text", form1.outerHTML)
	form1.target = "_self";
	form1.submit();
	canDoAction = false;
};

function enterSubmit(obj, type){
	if(event.keyCode == 13){
		if(type == "pageSize"){
			pagesizeChange(obj);
		}
		else if(type == "intpage"){
			pageChange(obj);
		}
	}
};

function getForm(obj){
	return document.getElementsByName("pageSize")[0].form;
};
function pageGo(obj){
	getPageAction(obj);
};
function first(obj){
	pageQueryMap.put("page", 1);
	getPageAction(obj);
};
function pageChange(obj){
	if(!new RegExp("^-?[0-9]*$").test(obj.value)){
		return;
	}
	
	var pageCount = obj.getAttribute("pageCount");
	if(obj.value > parseInt(pageCount, 10)){
		obj.value = pageCount;
	}
	
	pageQueryMap.put("page", obj.value);
	getPageAction(obj);
};
function last(obj, lastPage){
	pageQueryMap.put("page", lastPage);
	getPageAction(obj);
};
function next(obj){
	var page = parseInt(pageQueryMap.get("page"));
	pageQueryMap.put("page", page + 1);
	
	getPageAction(obj);
};
function pagesizeChange(obj){
	var v = obj.value;
	if(!new RegExp("^-?[0-9]*$").test(v) || parseInt(v, 10) < 1){
		return;
	}

	pageQueryMap.put("pageSize", v);
	pageQueryMap.put("page", 1);
	getPageAction(obj);
};
function prev(obj){
	var page = parseInt(pageQueryMap.get("page"));
	pageQueryMap.put("page", page - 1);
	getPageAction(obj);
};

/********************************** 表单验证 *****************************************/
/**
 * 常量定义
 */
var formValidate = {
	unCharactor		: "\"\\/|><:*?'",
	integerDigits	:	"10",
	decimalDigits	:	"0"
}

/**
 * 表单验证
 */
function checkForm(formObj){	
	var elements = formObj.elements;
	
	var clearValueElements = [];

	if(elements != null){
		for(var i = 0; i < elements.length; i++){
			var e = elements[i];
			var clearValue = e.getAttribute("clearValue");
			
			if(clearValue == "true"){
				clearValueElements[clearValueElements.length] = e;
				continue;
			}
			
			var validateAtt = e.getAttribute("validate");
			if(validateAtt != null && validateAtt != ""){
				var validateFuns = validateAtt.split(",");
				
				for(var f = 0; f < validateFuns.length; f++){
					var fun = validateFuns[f];
					
					if(fun){
						var result = eval(fun + "(e)");
					
						if(!result){return false;}
					}
				}
			}
		}
	}
	
	for(var j = 0; j < clearValueElements.length; j++) {
		clearDefaultValueWhenSubmit(clearValueElements[j]);
	}
	
	return true;
};

/**
 * 执行正则表达式
 */
function testRegExp(text, re) {
	return new RegExp(re).test(text);
};

/**
 * 在提交的时候，清除掉默认值
 */
function clearDefaultValueWhenSubmit(element){
	var defaultValue = getDefaultValue(element);
	
	var v = element.value;
	
	if(v == defaultValue){
		element.value = "";
	}
};

/**
 * 打印出提示消息，并聚焦
 */
function writeValidateInfo(element, message){
	alert(message);

	var onAfterAlert = element.getAttribute("onAfterAlert");
	if(onAfterAlert){
		try{
			eval(onAfterAlert);
		}
		catch(e){
		}
	}
	else{
		try{
			element.focus();
			element.select();
        }
		catch(e){
		}
	}
};

/**
 * 验证是否为空，不允许空格
 */
function notNull(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	if(value == null || value == "" || value.trim() == ""){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_notNull", inputName));
		return false;
	}
	
	var maxLength = element.getAttribute("maxSize");
	
	if(maxLength && value.length > maxLength){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_maxLength", inputName, maxLength, value.length));
		return false;
	}
	
	return true;
};

/**
 * 检测长度
 */
function maxLength(element){
	var value = element.value;
	if(!value){
		return true;
	}
	
	var inputName = element.getAttribute("inputName");
	
	var maxLength = element.getAttribute("maxSize");
	
	if(maxLength && value.length > maxLength){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_maxLength", inputName, maxLength, value.length));
		return false;
	}
	
	return true;
};
/**
 *  检测最小长度
 */
function minLength(element){
	var value = element.value;
	if(!value){
		return true;
	}
	
	var inputName = element.getAttribute("inputName");
	
	var minLength = element.getAttribute("minLength");
	
	if(minLength && value.length < minLength){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_minLength", inputName, minLength, value.length));
		return false;
	}
	
	return true;
};

/**
 * 是否为数字
 */
function isNumber(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var integerDigits = element.getAttribute("integerDigits") || formValidate.integerDigits;
	var decimalDigits = element.getAttribute("decimalDigits") || formValidate.decimalDigits;
	
	if(value == "0"){
		return true;
	}
		
	if(!testRegExp(value, "^-?[0-9]{0,"+integerDigits+"}\\.?[0-9]{0,"+decimalDigits+"}$")){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isNumber", inputName));
		return false;
	}
	
	return true;
};

/**
 * 检测是否是邮箱
 */
function isEmail(element){
	var value = element.value;
	if(!value){
		return true;
	}
	
	var inputName = element.getAttribute("inputName");
	
	if(value.indexOf("@") == -1 || value.indexOf(".") == -1){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isEmail", inputName));
		return false;
	}
	
	return true;
};

/**
 * 验证是否为空，允许空格
 */
function notNullWithoutTrim(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	if(value == null || value == ""){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_notNull", inputName));
		return false;
	}
	
	var maxLength = element.getAttribute("maxLength");
	if(maxLength && value.length > maxLength){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_maxLength", inputName, maxLength));
		return false;
	}
	
	return true;
};

/**
 * 验证是否为整数，并验证max和min
 */
function isInteger(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var max = element.getAttribute("max");
	var min = element.getAttribute("min");
		
	if(value != "0" && (isNaN(value) || value.indexOf("0") == 0 || !testRegExp(value, "^-?[0-9]*$"))){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isInteger", inputName));
		return false;
	}
	
	if(max != null && max != "" && parseInt(value) > parseInt(max)){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isInteger_max", inputName, max));
		return false;
	}
	
	if(min != null && min != "" && parseInt(value) < parseInt(min)){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isInteger_min", inputName, min));
		return false;
	}

	return true;
};

/**
 * 是否为正常的字符串，不允许特殊字符，如：/ character
 */
function isWord(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var character = element.getAttribute("character") || formValidate.unCharactor;

	for(var i = 0; i < character.length; i++){
		if(value.indexOf(character.charAt(i)) > -1){
			writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isWord", inputName, character));
			return false;
		}
	}
	
	return true;
};

/**
 * 是否是数字、字母、下划线
 */
function isCriterionWord(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	if(!testRegExp(value, '^[\\w-]+$')){
		writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isCriterionWord", inputName));
		return false;
	}
	
	return true;
};

/**
 * 以指定文本开头
 */
function startsWith(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var prefix = element.getAttribute("prefix");
	
    if(value.indexOf(prefix) != 0){ // prefix是扩展的属性
    	writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_startsWith", inputName, prefix));
        return false;
    }
        
    return true;
};

/**
 * 历史原因,拼写错误,废弃,但能正常运行,请用isDefaultValue
 */
function isDeaultValue(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var deaultValue = getDefaultValue(element);
	
	if(value == deaultValue){
    	writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_notNull", inputName));
        return false;
	}
	
	return true;
};

function isDefaultValue(element){
	var value = element.value;
	var inputName = element.getAttribute("inputName");
	
	var defaultValue = getDefaultValue(element);
	
	if(value == defaultValue){
    	writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_notNull", inputName));
        return false;
	}
	
	return true;
};

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
        url: contextPath + "/common/js/addDate/date.htm?type=" + type,
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
 
/**************************************************   打印   **************************************************/
var plist = null;//定义全局变量（打印内容对象列表）
var styleData = null;//定义样式表全局变量
/**
 * 初始化打印数据
 * printFragmentList -- 打印内容对象列表
 * styleDatas -- 打印样式
 */
function  printList(printFragmentList,styleDatas){
	if(!printFragmentList) {return;}
	plist = printFragmentList;
    styleData = styleDatas;
	printButton();
}

/**
 * 弹出打印对话框
 */
function printButton(){
   v3x.openWindow({
		url : v3x.baseURL + "/apps_res/print/print.jsp",
		workSpace : true,
		resizable : true,
		dialogType : "1",
		scrollbars: false
	});
}

/**
 * 打印按钮界面
 * 弹出打印页面onload此方法
 */
   function printLoad(){
   	try{
   	   var obj  = v3x.getParentWindow(); 
   	   var context = document.getElementById("context");
   var tlist = obj.plist;//获取打印内容
   var tlength = tlist.size();
   for(var i=0; i<tlength; i++){
 	    var s = tlist.get(i);     
        context.innerHTML += "<p>"+s.dataHtml+"</p>";
   }
     
   var klist = obj.styleData;//获取样式表列表    
   setStyle(klist) 
   var checkOption = document.getElementById("checkOption");
   var nlist  = obj.plist;
   var nlength = tlist.size();
   var flag = 0;
   disabledLink();
   //只有一个选项的时候,就没必要出现了,也没必要出现全部选项
   if(nlength<=1){return;}
   for(var i=0; i<nlength; i++){
 	    var s = nlist.get(i);    
 	    if(s.dataName != null && s.dataName != ""){
            checkOption.innerHTML +="<label for='dataNameBox"+i+"'><input type=checkbox checked name='dataNameBoxes' id=dataNameBox"+i+" onclick='printMain(this)'><font style='font-size:12px'>"+s.dataName+"</font></label>&nbsp;&nbsp;";
 	        flag ++;
 	    }
   } 
   if(flag >0)//当有多个备选项时显示
    checkOption.innerHTML +="<font style='font-size:12px'><label for='printall'><input type=checkbox id ='printall' checked name=cboxs onclick=printAll(this)>" + _("printLang.print_all") + "</label></font>";
        document.close();
   	}catch(e){}
    }
	
   /**
* 响应checked事件 
*/
   function printMain(e){
   	    var  obj = v3x.getParentWindow(); 
        var tlist  = obj.plist;
	    var context = document.getElementById("context");
    context.innerHTML="";
    creatDataHtml(tlist,context);
 	checkCount(e,tlist);
 	disabledLink();
}
function cleanSpecial(str){
	var position = str.indexOf("<DIV>");
	if(position == -1){
		return str;
	}
	var leftstr = str.substr(0,position-1);
	var rightstr = str.substr(position);
	var nextposition = rightstr.indexOf("</DIV>");
	var laststr = rightstr.substr(nextposition+6);
	return cleanSpecial(leftstr+laststr);
}
/**
 * 创建Html片断
 */
function  creatDataHtml(tlist,context){
	var tlength = tlist.size();
    for(var i=0; i<tlength; i++){
 	    var s = tlist.get(i);
 	    if(s.dataName != null && s.dataName != ""){
     	    var thisCheckBox = document.getElementById("dataNameBox"+i);//取得每一个按钮
     	    if(thisCheckBox.checked){//判断当前按钮是否选中   	
	    	    context.innerHTML +=  "<p>"+s.dataHtml+"</p>";
	        }else{
	        	//有一个按钮没有选  则全部打印按钮不能选中
	        	var thisAllCheckBox =document.getElementById("printall");
	        	thisAllCheckBox.checked = false;
	        }
	    }
	    //由于正文传入了空值，所以做判断
	    if(s.dataName == ""){
	    	context.innerHTML +=  "<p>"+s.dataHtml+"</p>";	
	    }
 	} 
}
 /**
  * 检查按钮checked个数是否合法
  */
function  checkCount(e,tlist){
	  if(e.checked == false){
 		var count= 0;
 		for(var i =0;i<tlist.size();i++){
 	        var s = tlist.get(i);
 	        if(s.dataName !=null && s.dataName != ""){
     	        var thisCheckBox = document.getElementById("dataNameBox"+i);//取得每一个按钮
     	         if(thisCheckBox.checked==false){//判断当前按钮是否选中  
     	              count ++;	
     	         }
     	    }
 		}
 		if(count == tlist.size()){
 			alert(_('printLang.print_least_select_one'));
 			e.checked = true;
 			printMain(e);
 			return false;
 		}
 	}   
}
/**
 * 打印对象
 */
function PrintFragment(dataName,dataHtml){
	this.dataName = dataName;//按钮名称
	this.dataHtml  = dataHtml;//代码片断	
}

/**
 * 取消链接及不需要的事件
 */
function disabledLink(){
	var aaa = document.body.getElementsByTagName("a");
	var sk = document.body.getElementsByTagName("span");
	var uuu = document.body.getElementsByTagName("u");
	var tables = document.body.getElementsByTagName("table");
	var inputs = document.body.getElementsByTagName("input");
	var imgs = document.body.getElementsByTagName("img");
	var selects=document.body.getElementsByTagName("select");
	var textareas=document.body.getElementsByTagName("TEXTAREA");
	var tds = document.body.getElementsByTagName("td");
	
	   for(var i=0;i<aaa.length;i++){
	      //aaa[i].style.color = "#000000";
	      aaa[i].onclick="";
		  aaa[i].href="###";
		  //aaa[i].style.display = "none";
		  aaa[i].style.textDecoration="none";
		  aaa[i].style.cursor="default";
	   }
	   for(var i=0;i<sk.length;i++){
		   sk[i].onmouseout = "";
		   sk[i].onmouseover = "";
		   sk[i].onclick="";
	   }
	   for(var i=0;i<uuu.length;i++){
	      uuu[i].onclick= function(){
	      	alert(_('printLang.print_preview_link_alert'));
	      }
	   }
	   for(var i=0;i<tables.length;i++){
		  tables[i].onclick="";
	   }
	   var i = 0;
	   while(i<inputs.length){
	   	  if(inputs[i].type == 'checkbox'){
	   	  	i++;
	   	  	continue;
	   	  }   	  
	   	  if(inputs[i].type == 'button' && inputs[i].value != 'go'){
	   	  	i++;
	   	  	continue;
	   	  }
		  inputs[i].onkeypress="";
		  inputs[i].onchange="";
		  inputs[i].onclick="";
		  if(inputs[i].type=="text")
		  {
		  	inputs[i].readOnly="readOnly";
			inputs[i].outerHTML="<span style='"+inputs[i].style.cssText+"' class='"+inputs[i].className+"'>"+inputs[i].value+"</span>";
		  }else
		    i++;
		}
		//如果打印内容为表单时，去掉表单中控件的图片
		for(var i=0;i<imgs.length;i++){
			  imgs[i].onkeypress="";
			  imgs[i].onchange="";
			  imgs[i].onclick="";
			  var imgsrc = imgs[i].src.toString();
			  if(imgsrc.indexOf("form/image/selecetUser.gif") !=-1 || imgsrc.indexOf("form/image/date.gif") !=-1){
			  	 imgs[i].outerHTML = "";
			  	 i--;
			  }		     
		}
		for(var i=0;i<selects.length;i++)
		{
			selects[i].outerHTML=selects[i].options[selects[i].selectedIndex].text;		
		}
		for(var i=0;i<textareas.length;i++)
		{
			textareas[i].outerHTML="<pre>"+textareas[i].value+"<pre>";
		}
		for(var i=0;i<tds.length;i++){
		   tds[i].onclick="";
	   }
		
	}

   /**
* 打印内容界面
*/
  function printInnerLoad(){
  	   var context = document.getElementById("context");
   var obj  = parent.v3x.getParentWindow();
   var tlist = obj.plist;//获取打印内容
   var tlength = tlist.size();
   for(var i =0;i<tlength;i++){
 	    var s = tlist.get(i);     
        context.innerHTML += "<p>"+s.dataHtml+"</p>";
   }
   var klist = obj.styleData;//获取样式表列表
       if(!klist){
           setStyle(klist) ;
       }
  }
   /**
* 设置样式表
*/
   function setStyle(klist){
  	 if(klist.size()>0){
            var linkList = document.getElementById("linkList");
        for(var j = 0;j<klist.size();j++){//引入样式表
        	var linkChild = document.createElement("<link>");
            linkChild.rel="stylesheet";  
            linkChild.href= klist.get(j);
            linkChild.type="text/css"; 
                linkList.appendChild(linkChild);
            }
       } 	
   }
  /**
   * 选择打印全部
   */
function printAll(e){
	var boxs = document.getElementsByName("dataNameBoxes");
	if(e.checked){
		for(var j=0;j<boxs.length;j++){
			boxs[j].checked = true;
		}
		printMain(e);
	}
}
  
function onbeforeprint(){
	document.getElementById("checkOption").style.display="none";
}
  
function onafterprint(){
	document.getElementById("checkOption").style.display="";
}


/****************************************/
/************** 正文类型切换 **************/
/****************************************/
/**
 * 选择类型事件
 */
function chanageBodyType(bodyType, isRevertContent) {
    var bodyTypeObj = document.getElementById("bodyType");
    if (bodyTypeObj && bodyTypeObj.value == bodyType) {
        return true;
    }
    	
    if (confirm(v3x.getMessage("V3XLang.common_confirmChangBodyType"))) {
        showEditor(bodyType, true);

        return true;
    }

    return false;
}

function getA8Top(){
	try {
		var A8TopWindow = null;
		if(portalOfA8IframName){
			eval("A8TopWindow = top.frames['" + portalOfA8IframName + "']");
			if(!(A8TopWindow && A8TopWindow.A8PageTop)){
				A8TopWindow = top;
			}
		}
		else{
			A8TopWindow = top;
		}
		
		return A8TopWindow;
	}
	catch (e) {
		return top;
	}
}

/**
 * 显示编辑器
 */
function showEditor(flag, isRevertContent) {
	//是否还原正文，默认为true
	isRevertContent = (isRevertContent == null) ? true : false;
		
    if (flag == 'HTML') {
        removeOfficeDiv(isRevertContent);

        oFCKeditor.ReplaceTextarea();
    }
    else if (flag == 'OfficeWord') {
        oFCKeditor.remove();

        showOfficeDiv("doc");
    }
    else if (flag == 'OfficeExcel') {
        oFCKeditor.remove();

        showOfficeDiv("xls");
    }
    else if (flag == 'WpsWord') {
        oFCKeditor.remove();

        showOfficeDiv("wps");
    }
    else if (flag == 'WpsExcel') {
        oFCKeditor.remove();

        showOfficeDiv("et");
    }

    var bodyTypeObj = document.getElementById("bodyType");
    if (bodyTypeObj) {
    	setContentTypeState(bodyTypeObj.value,flag);
        bodyTypeObj.value = flag;
    }
    //公告新闻预览屏蔽（如果是WORD或者EXCEL）
    try{
	    var bulBottPre = document.getElementById("bulBottPre").value;
	    if (bulBottPre && bulBottPre=='1' ) {
	    	if(flag == 'HTML'){
	    		myBar.enabled('preview');
	    	}else{
	    		myBar.disabled('preview');
	    	}
	    }
    }catch (e) {
	}
}
function initContentTypeState(){
	try{
		bodyType=document.getElementById("bodyType").value;
		bodyTypeSelector.disabled("menu_bodytype_"+bodyType);					
	}
	catch(e){		
	}	
}

function setContentTypeState(bodyTypeFrom,bodyTypeTo){
	try{
		if(bodyTypeFrom==bodyTypeTo)		{
			bodyTypeSelector.disabled("menu_bodytype_"+bodyTypeTo);			
		}
		else		{
			bodyTypeSelector.disabled("menu_bodytype_"+bodyTypeTo);	
			bodyTypeSelector.enabled("menu_bodytype_"+bodyTypeFrom);		
		}		
	}
	catch(e){		
	}
}

/****************************************/
/************ 列表页面的精确查找 ***********/
/****************************************/
function showNextCondition(conditionObject) {
    var options = conditionObject.options;
	
    for (var i = 0; i < options.length; i++) {
        var d = document.getElementById(options[i].value + "Div");
        if (d) {
            d.style.display = "none";
        }
    }
if(!document.getElementById(conditionObject.value + "Div")) return;
    document.getElementById(conditionObject.value + "Div").style.display = "block";
}

/**
 * 当使用到搜索时，显示前端
 */
function showCondition(conditionValue, textfieldValue, textfield1Value) {
	
    if (!conditionValue) {
        return;
    }
    var conditionObj = document.getElementById("condition")

    selectUtil(conditionObj, conditionValue); //选择条件
    showNextCondition(conditionObj); //显示条件值区�?

    var theDiv = document.getElementById(conditionValue + "Div");

    if (theDiv) {
        var nodes = theDiv.childNodes;

        if (nodes) {
            for (var j = 0; j < nodes.length; j++) {
                var node = nodes.item(j);
                if (node.tagName == "INPUT") {
                    eval("node.value = " + node.name + "Value;")
                }
                else if (node.tagName == "SELECT") {
                    eval("selectUtil(node, " + node.name + "Value)")
                }
            }
        }
    }
}


/**
 * 根据后端的值，将下拉按钮对应的项置于选中状�?
 */
function selectUtil(selectObj, selectedValue) {
    if (!selectObj) {
        return false;
    }

    var ops = selectObj.options;

    for (var i = ops.length - 1; i >= 0; i--) {
        if (ops[i].value == selectedValue) {
            selectObj.selectedIndex = i;
            return true;
        }
    }

    return false;
}
/**
 * 搜索按钮事件
 */
function doSearch() {
    var theForm = document.getElementsByName("searchForm")[0];
    var searchDate = document.getElementById('createDateDiv');
   
    if (theForm) {
	    var options = theForm.condition.options;
	
	    for (var i = 0; i < options.length; i++) {
	        if (theForm.condition.value == options[i].value) continue;
	
	        var d = document.getElementById(options[i].value + "Div");
	        if (d) {
	            d.innerHTML = "";
	        }
	    }
	    
	    theForm.target = "_self";
        theForm.submit();
    }
}

function doSearchEnter(){
    if(event.keyCode == 13){
    	doSearch();
    }
}

/**
 * 弹出窗口的关闭时间
 * <body onkeypress="listenerKeyESC()">
 */
function listenerKeyESC(){
	if(event.keyCode == 27){
		window.close();
	}
}

/**
 * 检测checkbox是否被选择
 * @return 0 - 表示选择  否则返回选择的个数
 */
function validateCheckbox(checkboxName){
	checkboxName = checkboxName || "id";
	var id_checkbox = document.getElementsByName(checkboxName);
    if (!id_checkbox) {
        return 0;
    }

    var selectedCount = 0;
    var len = id_checkbox.length;
    for (var i = 0; i < len; i++) {
        if (id_checkbox[i].checked) {
            selectedCount++;
        }
    }
    
    return selectedCount;
}

/**
 * 取checkbox的第一个选择值
 */
function getCheckboxSingleValue(checkboxName){
	var o = getCheckboxSingleObject(checkboxName);
    
    return o == null ? null : o.value;
}

/**
 * 取checkbox的第一个选择对象
 */
function getCheckboxSingleObject(checkboxName){
	checkboxName = checkboxName || "id";
	var id_checkbox = document.getElementsByName(checkboxName);
    if (!id_checkbox) {
        return 0;
    }

    var selectedCount = 0;
    var len = id_checkbox.length;
    for (var i = 0; i < len; i++) {
        if (id_checkbox[i].checked) {
            return id_checkbox[i];
        }
    }
    
    return null;
}

/*****************************************
 * 振荡回复
 */
var currentOpinionId = "";

function hiddenReplyDiv(){
	var obj_ = document.getElementById("replyDiv" + currentOpinionId);
	if(obj_){
		obj_.innerHTML = "";
		obj_.style.display = "none";
	}
	fileUploadAttachments.clear();
}
function reply(opinionId, writeMemberId, isUploadAtt){
	hiddenReplyDiv();
	
	document.getElementById("uploadAttachmentSpan").style.display = (isUploadAtt == true ? "" : "none");
	//会议里没关联文档
	try{
	document.getElementById("myDocumentSpan").style.display = (isUploadAtt == true ? "" : "none");
	}
	catch(e)
	{
	}
	
	var obj = document.getElementById("replyDiv" + opinionId);
	if(obj){
		obj.innerHTML = document.getElementById("replyCommentHTML").innerHTML;
		obj.style.display = "";
		
		var theForm = document.getElementsByName("repform")[0];
		theForm.isHidden.id = "isHidden";
		try{
			theForm.isSendMessage.id = "isSendMessage";
		}
		catch(e){
		}
		//焦点下移显示出回复按钮
		if(theForm.b11) {
			theForm.b11.focus();
		}
		theForm.content.focus();
		
		theForm.opinionId.value = opinionId;
		if(writeMemberId){
			theForm.memberId.value = writeMemberId;
		}
	}
	
	currentOpinionId = opinionId;
}

function checkReplyForm(f){
//	f.opinionId.value = currentOpinionId;
	if(checkForm(f)){
		return true;
	}
	
	return false;
}

/**
 * 对标题默认值的切换
 * @param isShowBlack 去掉为默认值，显示空白，用在onFocus
 */
function checkDefSubject(obj, isShowBlack) {
	var dv = getDefaultValue(obj);
    if (isShowBlack && obj.value == dv) {
            obj.value = "";
    }
    else if (!obj.value) {
            obj.value = dv;
    }
}

/**
 * 从input中读取属性为defaultValue的值
 */
function getDefaultValue(obj){
	if(!obj){
		return null;
	}
    var def = obj.attributes.getNamedItem("defaultValue");
    if(!def){
    	def = obj.attributes.getNamedItem("deaultValue"); //兼容以前错误的写法
    }
    
    if(def){
    	return def.nodeValue;
    }
    
    return null;
}

/***********************************************
 * 处理界面的按钮切换
 */
function Panel(id, label, onclick) {
    this.id = id;
    this.label = label;
    this.onclick = onclick || "";
}

Panel.prototype.toString = function() {
    //return "<div id='button" + this.id + "' onClick=\"changeLocation('" + this.id + "');" + this.onclick + "\" class=\"sign-button\">" + this.label + "</div>" +
    //       "<div class=\"sign-button-line\"></div>";
    return "<div id='button-L" + this.id + "' class=\"sign-button-L\"></div><div id='button" + this.id + "' onClick=\"changeLocation('" + this.id + "');" + this.onclick + "\" class=\"sign-button-M\">" + this.label + "</div>" +
    		"<div id='button-R" + this.id + "' class=\"sign-button-R\"></div><div class=\"sign-button-line\"></div>";
}

Panel.prototype.toMinString = function(){
	return "<div class=\"sign-min-label\" onclick=\"changeLocation('" + this.id + "');showPrecessArea()\" title=\"" + this.label + "\">" + this.label + "</div><div class=\"separatorDIV\"></div>"
}

function showPanels(isShowHiddenButton) {
	if(isShowHiddenButton != false){
		document.write('<div id="hiddenPrecessAreaDiv" onclick="hiddenPrecessArea()" title="' + v3x.getMessage("V3XLang.common_hiddenPrecessArea") + '"></div>');
	}
	
    for (var i = 0; i < panels.size(); i++) {
        document.write(panels.get(i).toString());
    }
    document.close();
}

function showMinPanels(){
    for (var i = 0; i < panels.size(); i++) {
        document.write(panels.get(i).toMinString());
    }
    
    document.close();
}

function changeLocation(id) {
    for (var i = 0; i < panels.size(); i++) {
        var id_ = panels.get(i).id;
        if (id_ == id) continue;

        document.getElementById('button-L' + id_).className = "sign-button-L";
        document.getElementById('button' + id_).className = "sign-button-M";
        document.getElementById('button-R' + id_).className = "sign-button-R";
        var o = document.getElementById(id_ + "TR");
        if (o) {
            o.style.display = "none";
        }
    }

    var bObj = document.getElementById("button" + id);
    if(bObj){
    	document.getElementById('button-L' + id).className = "sign-button-L-sel";
    	bObj.className = "sign-button-M-sel";
    	document.getElementById('button-R' + id).className = "sign-button-R-sel";
    }
    
    var trObj = document.getElementById(id + "TR");
    if(trObj){
    	trObj.style.display = "";
    }
}

function showPrecessArea(width) {
	width = width || "36%";
	try{
	    parent.document.all.zy.cols = "*," + width;
	}	
	catch(e){		
	}
	
    var obj = document.getElementById('signAreaTable');
    if(obj){
    	obj.style.display = "";
    }
    var _signMinDiv = document.getElementById('signMinDiv');
    if(_signMinDiv){
    	_signMinDiv.style.display = "none";
    	_signMinDiv.style.height = "0px";
    }
}

function hiddenPrecessArea() {
	try{
    	parent.document.all.zy.cols = "*,45";
	}
	catch(e){
	}
    var obj = document.getElementById('signAreaTable');
    if(obj){
    	obj.style.display = "none";
    }
    var _signMinDiv = document.getElementById('signMinDiv');
    if(_signMinDiv){
    	_signMinDiv.style.display = "";
    	_signMinDiv.style.height = "100%";
    }
}
/**
 * 刷新当前页面
 */
function refreshIt() {
    location.reload(true);
}

/**
 * 刷新当前工作区
 */
function refreshWorkSpace() {
	var _nowSelectId = getA8Top().reFlesh();
}

/**
 * 页面回退
 */
function locationBack() {
    history.back();
}
/**
 * 将字符串转换成HTML代码
 */
function escapeStringToHTML(str){
	if(!str){
		return "";
	}
	
	str = str.replace(/&/g, "&amp;");
	str = str.replace(/</g, "&lt;");
	str = str.replace(/>/g, "&gt;");
	str = str.replace(/\r/g, "<br>");
	str = str.replace(/\'/g, "&#039;");
	str = str.replace(/"/g, "&#034;");
	
	return str;
}

/**
 * 获取QueryString参数
 */
function getParameter(name1){
	var queryString = document.location.search;
	
	if(queryString){
		queryString = queryString.substring(1);
		
		var params = queryString.split("&");
		
		for(var i = 0; i < params.length; i++) {
			var items = params[i].split("=");
			
			if(name1 == items[0]){
				return items[1];
			}
		}
	}
}

/**
 * 给选择列表设置选择项
 * @param selectId 选择列表的Id
 * @param value 选择的值
 */
function setSelectValue(selectId, value){
	var object = document.getElementById(selectId);
	if(!object){
		return;
	}
	
	var os = object.options;
	if(!os){
		return;
	}
	
	for(var i = 0; i < os.length; i++){
		var o = os[i];
		if(o.value == value){
			o.selected = true;				
			break;
		}
	}
}

var sxUpConstants = {
	status_0 : "0,*",
	status_1 : "35%,*"
}
var sxDownConstants = {
	status_0 : "*,12",
	status_1 : "35%,*"
}
var sxMiddleConstants = {
	status_0 : "35%,*",
	status_1 : "35%,*"
}
var indexFlag = 0;
function previewFrame(direction){
	if(!direction) return;
	var obj = parent.parent.document.all.sx;
	if(obj == null){
		obj = parent.document.all.sx;
	}
	
	if(obj == null){
		return;
	}
	
	if(indexFlag > 1){
		indexFlag = 0;
	}
		
	var status = eval("sx" + direction + "Constants.status_" + indexFlag);
	obj.rows = status;
	
	if(direction != "Middle"){
		indexFlag++;
	}
}

function checkImageSize(img){
	if(img.width > 540){ img.width = 540;}
}

/**
 * 得到上下框架的中间横条
 * @param isShowButton 是否显示中间的按钮
 */
function getDetailPageBreak(isShowButton){
	var showButtonFlag = true; 
	if(isShowButton != true && (window.dialogArguments || window.opener)){
		showButtonFlag = false;
	}
	
	var contentP = "";
	try{
		contentP = v3x == null ? "" : v3x.baseURL + "/common/";
	}catch(e){}
	
	document.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">");
	document.write("<tr align=\"center\">");
	document.write("<td class=\"detail-top\">");
	if(showButtonFlag){
		document.write("<img src=\"" + contentP + "images/button.preview.up.gif\" border='0' height=\"8\" onclick=\"previewFrame('Up')\" class=\"cursor-hand\">");
		document.write("<img src=\"" + contentP + "images/button.preview.down.gif\" border='0' height=\"8\" onclick=\"previewFrame('Down')\" class=\"cursor-hand\">");
	}
	document.write("</td>");
	document.write("</tr>");
	document.write("</table>");
	document.close();
	
	previewFrame('Middle');
}

function getLimitLength (text, maxlengh, symbol) {
    return text.getLimitLength(maxlengh, symbol); 
}

function changeMenuTab(clickDiv)
{
  var menuDiv=document.getElementById("menuTabDiv");
  var clickDivStyle=clickDiv.className;
  if(clickDivStyle=="tab-tag-middel-sel"){return;}
  var divs=menuDiv.getElementsByTagName("div");
  var i;
  for(i=0;i<divs.length;i++)
  {    
  	clickDivStyle=divs[i].className;  	
  	if(clickDivStyle.substr(clickDivStyle.length-4)=="-sel")
  	{  		
  		divs[i].className=clickDivStyle.substr(0,clickDivStyle.length-4);
  	}  	    
  }
  for(i=0;i<divs.length;i++)
  {
        if(clickDiv==divs[i])
  	    {
  	      divs[i-1].className=divs[i-1].className+"-sel";
  	      divs[i].className=divs[i].className+"-sel";
  	      divs[i+1].className=divs[i+1].className+"-sel";
  	    }    
  }
  var detailIframe=document.frames("detailIframe");
  detailIframe.location.href=clickDiv.url;
}
function setDefaultTab(pos)
{
  var menuDiv=document.getElementById("menuTabDiv");
  var divs=menuDiv.getElementsByTagName("div");
  divs[pos*4].className=divs[pos*4].className+"-sel";
  divs[pos*4+1].className=divs[pos*4+1].className+"-sel";
  divs[pos*4+2].className=divs[pos*4+2].className+"-sel";
  var detailIframe=document.frames("detailIframe");
  detailIframe.location.href=divs[pos*4+1].url;
}

function getRadioValue(radioName){
	var radios = document.getElementsByName(radioName);
	if(!radios){
		return null;
	}
	
	for(var i = 0; i < radios.length; i++) {
		if(radios[i].checked){
			return radios[i].value;
		}
	}
	
	return null;
}

var sx_variable = {
	detailFrameName : "",
	title : "", 
	imgSrc : "", 
	count : 0, 
	description: "",
	
	isShow : false
}

/**
 * 上下结构的页面，显示下面的图片、总数、描述
 * 
 * @param detailFrameName 下面页面的frame的名称
 * @param title 显示的标题 要国际化哦
 * @param imgSrc 显示的图标名称，统一放在/common/images/detailBannner下，比如：/common/images/detailBannner/101.gif
 * @param count 显示的总数，如果为null或者为负数，表示不显示总数
 * @param description 显示的描述
 */
function showDetailPageBaseInfo(detailFrameName, title, imgSrc, count, description){
	parent.sx_variable.detailFrameName = detailFrameName;
	parent.sx_variable.title = title;
	parent.sx_variable.imgSrc = imgSrc;
	parent.sx_variable.count = count;
	parent.sx_variable.description = description;
	
	parent.doDetailPageBaseInfo();
}

function doDetailPageBaseInfo(){
	if(!sx_variable.detailFrameName){
		return;
	}
	
	var detailDocument = null;
	try{
		detailDocument = eval(sx_variable.detailFrameName)
	}
	catch(e){
	}
	
	if(detailDocument && detailDocument.document.readyState == "complete"){ //下面的页面已经加载完了
		var flag = eval("detailDocument.detailPageBaseInfoFlag");
		if(!flag){
			detailDocument.location.href = v3x.baseURL + "/common/detail.html";
			window.setTimeout("doDetailPageBaseInfo()", 500);
			return;
		}
		
		detailDocument.document.getElementById("titlePlace").innerText = sx_variable.title;
		detailDocument.document.getElementById("img").src = v3x.baseURL + sx_variable.imgSrc;
		
		if(sx_variable.count != null && sx_variable.count >= 0){
			detailDocument.document.getElementById("countPlace").innerHTML = v3x.getMessage("V3XLang.common_detailPage_count_label", "<span class='countNumber'>" + sx_variable.count + "</span>");
		}
		
		detailDocument.document.getElementById("descriptionPlace").innerHTML = sx_variable.description || "";
		
		detailDocument.document.getElementById("allDiv").style.display = "";
	}
	else{
		window.setTimeout("doDetailPageBaseInfo()", 500);
	}
}

function reloadDetailPageBaseInfo(){
	try{
		parent.doDetailPageBaseInfo();
	}
	catch(e){}
}

/******************************************  页签切换  *************************************************/
function changeTabUnSelected(id){
	if(id){
		document.getElementById("l-" + id).className = "tab-tag-left";
		document.getElementById("m-" + id).className = "tab-tag-middel cursor-hand";
		document.getElementById("r-" + id).className = "tab-tag-right";
	}
}

function changeTabSelected(id){
	if(id){
		document.getElementById("l-" + id).className = "tab-tag-left-sel";
		document.getElementById("m-" + id).className = "tab-tag-middel-sel";
		document.getElementById("r-" + id).className = "tab-tag-right-sel";
	}
}


/*************************************** 归档 ******************************************************
 * appName:应用 枚举key; 
 * ids:要归档的源数据id串，以逗号分割          如 12345,98754
 * atts：逗号分割的是否有附件标记串，和ids顺序一致，默认false     如  true,false
 * validAcl: 是否验证写入权限（一般管理员调用进行预归档），true或false，默认true（验证）
 * 
 */
function pigeonhole(appName, ids, atts, validAcl){
	var returnval = v3x.openWindow({
		url : pigeonholeURL + "?method=docPigeonhole&appName=" + appName + "&ids=" + ids + "&atts=" + atts + "&validAcl=" + validAcl,
		width : "500",
		height : "500",
		resizable : "true",
		scrollbars : "true"			
	});

	if (returnval == undefined)
	 	returnval = "cancel";
	return returnval;
}

function projectPigeonhole(appName, ids, projectId, atts) {
	var returnval = v3x.openWindow({
		url : pigeonholeURL + "?method=docTreeProjectIframe&appName=" + appName + "&ids=" + ids + "&projectId=" + projectId + "&atts=" + atts,
		width : "500",
		height : "500",
		resizable : "true",
		scrollbars : "true"			
	});

	if (returnval == undefined)
	 	returnval = "cancel";
	 	
	return returnval;
}

function  isPhoneNumber(element){
var value = element.value;
var inputName = element.getAttribute("inputName");
var cellphone=/^([\d-]*)$/;
if(!cellphone.test(value)){
writeValidateInfo(element, v3x.getMessage("V3XLang.formValidate_isNumber", inputName));
return false;
}
return true;
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


