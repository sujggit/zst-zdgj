<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DVD控制</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">

	//方向键
	function directionForDVD(op){
		var ip = document.getElementById("ccip").value;
		//$("#"+op).attr("class","span_"+op+"_act");
		DwrMethod.directionForDVD(ip,op,directionForDVD_back);
	}

	function directionForDVD_back(para){
		if(para){
			$("#up").attr("class","span_up");
			$("#down").attr("class","span_down");
			$("#left").attr("class","span_left");
			$("#right").attr("class","span_right");
			$("#enter").attr("class","span_ok");
			$("#"+para).attr("class","span_"+para+"_act");
		}else{
			alert("失败");
		}
	}
	
	//控制键
	function operatorForDVD(op,id){
		var ip = document.getElementById("ccip").value;
		$(".k2").removeAttr("class");
		$("#b"+id).attr("class","k2");
		DwrMethod.operatorForDVD(ip,op,operatorForDVD_back);
	}
	function operatorForDVD_back(result){
		if(result == false){
			alert("失败");
			$(".k2").removeAttr("class");//操作失败即清除样式
		}
	}
	
	//数字键
	function changeNum(op){
		var ip = document.getElementById("ccip").value;
		document.getElementById("showView").value = op;
		DwrMethod.numForDVD(ip,op,numForDVD_back);
	}
	function numForDVD_back(result){
		if(result == false){
			alert("失败");
		}
	}
	
	//字符键
	function charForDVD(op,id){
		var ip = document.getElementById("ccip").value;
		$(".k2").removeAttr("class");
		$("#b"+id).attr("class","k2");
		DwrMethod.charForDVD(ip,op,charForDVD_back);
	}
	function charForDVD_back(result){
		if(result == false){
			alert("失败");
		}
	}
</script>
</head>
<body>
<div id="k8" class="k" style="display:block">
<input type="hidden" value="${param.ccip }" id="ccip"/>
	<table width="60%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td style="text-align:center">
				<a href="#">
                    <div class="dd_5">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
                            <tr>
                                <td> </td>
                                <td><span onclick="directionForDVD('up');" class="span_up" id="up"></span></td>
                                <td> </td>
                            </tr>
                            <tr>
                                <td><span onclick="directionForDVD('left');" class="span_left" id="left"></span></td>
                                <td><span onclick="directionForDVD('enter');" class="span_ok" id="enter"></span></td>
                                <td><span onclick="directionForDVD('right');" class="span_right" id="right"></span></td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td><span onclick="directionForDVD('down');" class="span_down" id="down"></span></td>
                                <td> </td>
                            </tr>
                        </table>
                    </div>
				</a>
			</td>
			<td style="text-align:center">
                <div class="dd_2" style="width:193px">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
                        <tr>
                            <td align="center"><input type="text" id="showView" style="border:none;margin:0;padding:0" disabled="disabled"/></td>
                        </tr>  
                    </table>
                </div>
                <div class="dd_3" style="width:203px">
                    <table width="100%" border="1" cellspacing="0" cellpadding="0" class="con_2" align="center" style="">
                        <tr>
                            <td align="center" onclick="changeNum(1)">1</td>
                            <td align="center" onclick="changeNum(2)">2</td>
                            <td align="center" onclick="changeNum(3)">3</td>
                        </tr>
                        <tr>
                            <td align="center" onclick="changeNum(4)">4</td>
                            <td align="center" onclick="changeNum(5)">5</td>
                            <td align="center" onclick="changeNum(6)">6</td>
                        </tr>
                        <tr>
                            <td align="center" onclick="changeNum(7)">7</td>
                            <td align="center" onclick="changeNum(8)">8</td>
                            <td align="center" onclick="changeNum(9)">9</td>
                        </tr>
                        <tr>
                            <td align="center"></td>
                            <td align="center"  onclick="changeNum(0)">0</td><td align="center"></td>
                        </tr>
                    </table>
                </div>
            </td>
		</tr>
	</table>            
	<div class="con_3">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <td  onclick="operatorForDVD('power',1)"><span id="b1">电源</span></td>
                <td onclick="operatorForDVD('menu',2)"><span  id="b2">菜单</span></td>
                <td onclick="operatorForDVD('openOrClose',3)"><span  id="b3">开/关仓</span></td>
                <td onclick="operatorForDVD('audioLine',4)"><span  id="b4">声道</span></td>
                <td></td>
            </tr>
            <tr>
                <td onclick="charForDVD('start',5)"><span  id="b5">开始</span></td>
                <td onclick="charForDVD('pause',6)"><span  id="b6">暂停</span></td>
                <td onclick="operatorForDVD('back',7)"><span  id="b7">返回</span></td>
                <td onclick="operatorForDVD('title',8)"><span  id="b8">字幕</span></td>
                <td></td>
            </tr>
            <tr>
                <td onclick="charForDVD('lastSong',9)"><span  id="b9">上一首</span></td>
                <td onclick="charForDVD('nextSong',10)"><span  id="b10">下一首</span></td>
                <td onclick="charForDVD('forward',11)"><span  id="b11">前进</span></td>
                <td onclick="charForDVD('reverse',12)"><span  id="b12">后退</span></td>
                <td onclick="charForDVD('stop',13)"><span  id="b13">停止</span></td>
            </tr>
		</table>  
	</div>  
</div> 
</body>
</html>
