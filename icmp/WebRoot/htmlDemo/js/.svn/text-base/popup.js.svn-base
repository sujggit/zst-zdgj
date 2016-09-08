// JavaScript Document
var drag = {
			$: function(){ return document.getElementById(arguments[0]);},
			// 得到视口的大小			 
			getWindowsSize: function(){
				var de = document.documentElement,
					pageWidth = window.innerWidth,
					pageHeight = window.innerHeight;
				if(typeof pageWidth != 'number'){ //如果pageWidth不是数字,则ie,非ie支持innerWidth
					if(document.compatMode == 'CSS1Compat'){ //Standars mode 标准模式，完整dtd
						pageWidth = de.clientWidth;
						pageHeight = de.clientHeight;
					} else { //如果是 Quirks mode
						pageWidth = document.body.clientWidth;
						pageHeight = document.body.clientHeight;
					}
				}
				return {
					width: pageWidth,
					height: pageHeight
				}
			},
			/*
			   创建标签
			   @param {String} target 标签名称，为空则创建一个空的div
			   @param {Object} config 属性列表
			*/
			createElement: function(target, config){
				target = target || 'div';
				config = config || {};				
				var tag = document.createElement(target);
				for(var p in config){
					if(p.toLowerCase() == 'style'){
						tag.style.cssText = config[p];
					} else if(p.toLowerCase() == 'class' || p.toLowerCase() == 'cls'){
						tag.className = config[p];
					} else if(p.toLowerCase() == 'innerHTML'){
						tag.innerHTML = config[p];
					} else {
						tag.setAttribute(p, config[p]);
					}
				}
				//此处try为释放tag引用，否则创建的DOM永远无法被释放
				try{
					return tag;
				} finally {
					tag = null;
				}
			},			
			getEvent: function(event){
				return event ? event : window.event;
			},			
			init: function(id){
				var that = this,
					ele = this.$(id) || false,
					winWidth = this.getWindowsSize().width,
					winHeight = this.getWindowsSize().height;
				
				if(!ele) {
					ele = this.createElement('div', {
						id: 'drag',
						cls: 'drag_wrap'
					});
					var h1 = this.createElement('bottom');
					h1.innerHTML = '';
					var span = this.createElement('span');
					span.innerHTML = '<p>是否确定删除</p><c><input type="submit" class="submit1 radius2" value="确 定" /> <input type="submit" class="reset1 radius2" value="取 消" /></c>';
					var cont = this.createElement('div', {
						cls: 'drag_cont'
					});
					cont.innerHTML = '';					
					h1.appendChild(span);
					ele.appendChild(h1);
					ele.appendChild(cont);
					//ele.style.display = 'block';					
					document.body.appendChild(ele);
					
					span.onclick = function(){
						document.body.removeChild(ele);
						document.body.removeChild(oMask);
					}
				} else {
					var handler = ele.getElementsByTagName('h1')[0],
						close = handler.getElementsByTagName('span')[0];
						
					close.onclick = function(){
						ele.style.display = 'none';
						document.body.removeChild(oMask);
					}
				}				
				var oMask = this.createElement('div', {
					cls: 'mask'
				});
				oMask.style.cssText = 'width:' + winWidth + 'px;height:' + winHeight + 'px;';				
				document.body.appendChild(oMask);				
				ele.style.display = 'block';
				ele.style.left = (winWidth - ele.offsetWidth)/2 + 'px';
				ele.style.top = (winHeight - ele.offsetHeight)/2 + 'px';				
				return this;
			},			
			move: function(id){
				var that = this,
					ele = this.$(id),
					winWidth = this.getWindowsSize().width,
					winHeight = this.getWindowsSize().height,
					posx,
					poy;				
				if(!ele) return false;				
				var handler = ele.getElementsByTagName('h1')[0],
					close = handler.getElementsByTagName('span')[0];
				handler.onmousedown = function(e){
					evt = that.getEvent(e);
					posx = evt.clientX - parseInt(ele.style.left);
					posy = evt.clientY - parseInt(ele.style.top);					
					if (handler.setCapture) { //防止ie下拖动过快丢失对象
		                handler.setCapture();
		            } else if (window.captureEvents) {
		                window.captureEvents(e.MOUSEMOVE | e.MOUSEUP);
		            }					
					document.onmousemove = function(e){
						e = that.getEvent(e);
						var l = e.clientX - posx,
							t = e.clientY - posy;							
						if(l < 0){
							l = 0;
						} else if(l > winWidth - ele.offsetWidth){
							l = winWidth - ele.offsetWidth;
						}						
						if(t < 0){
							t = 0;
						} else if(t > winHeight - ele.offsetHeight){
							t = winHeight - ele.offsetHeight;
						}						
						ele.style.left = l + 'px';
						ele.style.top = t + 'px';
						
						window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty(); //取消选择文本
					}
					return false; //感谢清流鱼提出解决办法
				};				
				document.onmouseup = function(e){
					e = that.getEvent(e);					
					if (handler.releaseCapture) {
	                    handler.releaseCapture();
	                } else if (window.captureEvents) {
	                    window.captureEvents(e.MOUSEMOVE | e.MOUSEUP);
	                }					
					document.onmousemove = null;
				};				
				return this;
			},			
			close: function(id){
				var that = this,
					ele = this.$(id);
					
				if(!ele) return false;
				ele.style.display = 'none';
			}
		}