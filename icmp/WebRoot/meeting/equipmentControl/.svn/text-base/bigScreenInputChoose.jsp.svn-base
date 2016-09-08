<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@include file="/common/common.jsp"%>
	<link href="${sys_ctx }/meeting/equipmentControl/css/lg.css" type="text/css" rel="stylesheet" />
  	<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
	
    <title>大屏输出选择</title>
    
    
    
  <script type="text/javascript">
  
  	  //获得大屏信息的字符数组
  	  var bgNOs = "${equipmentVO.equipmentNO}";
  	  //alert("bgNOs:"+bgNOs);
	  var ls_bgNOs = bgNOs.split(",");
  		
	  function matriSwitchss(chooseBgId){
	  	var ids1=document.getElementById("matrixNames").value;
		var chooseInputId = document.getElementById("chooseInputId").value;
		var inputVlaues = chooseInputId;
		
		var ls_bg = chooseBgId.replace("view","");
		//alert("ls_bg::"+ls_bg);
		var bgNum = ls_bg - 1;
		//alert("bgNum::"+bgNum);
		var bgInfore = ls_bgNOs[bgNum];
		//alert("大屏信息为："+bgInfore+"；屏幕顺序为："+bgNum);
		
		var ids2 = "${equipmentVO.description}";
		//alert("ids2:"+ids2);
		
		var ipCC = document.getElementById("ip").value;
		
		var idss=chooseBgId;
	    var outputValues=bgInfore;
	    //输出数据模拟
	    TerminalDwrMethod.bigscreenChoose(ipCC,ids2,ids1,inputVlaues,outputValues,matriSwitchssback);
	  }
	   
	    function matriSwitchssback(result){
	    	if(result==true){
	    	alert("成功！");
	    	}else{
	    	alert("失败！");
	    	}	
		}
  
	 var newImgID = 0;
	 function newDiv(item){
		var imgStr = "<img id='newImg"+newImgID+"' src='${sys_ctx }/images/red_02.png'/>";
		//alert(item.id);
		for(var i=1;i<9;i++){
			if('bigScreenArea'+i == item.id ){
				//alert('bigScreenArea'+i == item.id );
				$("#viewDiv"+i).append(imgStr);
			}
		}
		newImgID = newImgID+1;
	 }

	function matrixName(desc,bgNOs){
		//alert("desc::"+desc);
      var ids=document.getElementById("matrixNames").value;
      var ips=document.getElementById("ip").value;
      var element =document.createElement("a");   
			    element.href="${sys_ctx}/equipmentControl/bigScreenInputChooseBefore.action?equipmentVO.ip="+ips+"&matrixSwitchVO.id="+ids+"&equipmentVO.description="+desc+"&equipmentVO.equipmentNO="+bgNOs;   
			    document.body.appendChild(element);   
			    element.click();
    }
  	</script>
</head>
	<body style="background-color: #F7F7F7">
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="srcmtable">
				<tr>
					<td>
						
							<div class="scrmdiv" style="width:400px; height:200px;text-align:left;">
								${equipmentVO.meetingRoomVO.description }
							</div>
						
					<script type="text/javascript">
					
					//样式选择 	
					function divStyle(bgLsLength){
					  for(var i=1;i<bgLsLength+1;i++){
					  	//alert("####:"+"#"+bgStyle+i);
						$("#"+"view"+i).droppable({
					      drop: function(event,ui){
					      	//alert("@@@:"+this.id);
							matriSwitchss(this.id);
					      }
					    });
					  }
					}
					var bigScreenList = ${bgLsLength};
					if(bigScreenList != 0){
						//alert("length::"+bigScreenList);
						divStyle(bigScreenList);
					}
  					</script>
				</td> 	
			</table>
		</div>
		<div id="inputArea" >
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="height:150px;">
         		<input type="hidden" name="equipmentVO.ip"  id="ip"   value="${equipmentVO.ip}">
         		<input type="hidden" name="chooseInputId"  id="chooseInputId" >
         		<tr>
        			<td colspan="2" valign="middle" style="height:30px">
         				<select name="matrixSwitchVO.id" class="sel_sx" id="matrixNames" onchange="matrixName('${equipmentVO.description}','${equipmentVO.equipmentNO}');">
        					<c:forEach items="${matrixSwitchVOList}" var="matrixSwitchVOTemp" varStatus="state">
   		            			<option value="${matrixSwitchVOTemp.id}" ${matrixSwitchVOTemp.id==matrixSwitchVO.id  ? "selected" : "" } ><c:out value="${matrixSwitchVOTemp.name}"/></option>
            				</c:forEach>
        				</select>
        			</td>
        		</tr>
         		<tr> 
         		<c:forEach items="${matrixSwitchVO.in}" var="vo" varStatus="status">  
          			<td><div align="center" id="${vo[0]}" class="cc_btn" name="inputName" id="${vo[0]}">${vo[1]}</div></td>
           			<script>
           				$("#${vo[0]}").draggable({
           					drag: function(event, ui){
           						var chooseInputId = document.getElementById("chooseInputId");
           						chooseInputId.value = this.id;
           						//alert("ch_id:"+this.id);
           					},
							cursor: 'move' ,
							containment: 'document', 
							helper:'clone',
							opacity:1 ,
							revert:'invalid',
							scroll:false
						});
           			</script>
           			<c:if test="${status.index>0&&(status.index+1)%10==0}"> 
          				</tr>
         			</c:if>
        		</c:forEach>
        	</table>
	</body>
</html>
