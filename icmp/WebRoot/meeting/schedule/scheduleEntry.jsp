<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file="/common/common.jsp"%>
    <title>领导日程录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
			margin: 5px;
		}
	</style>
	<script type="text/javascript">
		function meetingInfo(mvo,num){
			$("#meetingId_"+num).val(mvo.value.split("_")[0]);
			//alert(mvo.value);
			if(mvo.value!="0"){
				var strs = mvo.value.split("_");
				var id = strs[0];
				$("#meetingId_"+num).val(id);//修改隐藏域
				var room = strs[3];
				var temps = strs[1].split(" ")[1].split(".")[0].split(":");
				var tempe = strs[2].split(" ")[1].split(".")[0].split(":");
				var time = temps[0]+":"+temps[1]+"-"+tempe[0]+":"+tempe[1];
				$("#room_"+num).text(room);
				$("#time_"+num).text(time);
				return;
			}else{
				$("#room_"+num).text("");
				$("#time_"+num).text("");
				$("#meetingId_"+num).val("");//修改隐藏域
			}
		}
		function scheduleAdd(){
			if($("#leaderId").val()=="--请选择领导--"){
				alert("请选择领导!");return;
			};
			var inps = $(".yes");
			for(var i=0;i<inps.length;i++){
				if(!inps.get(i).value){//没有填写mark
					alert("请填写列入大事记的备注信息。");
					return
				}
			}
			$("#addForm").submit();
		}
		function changeMod(sel,index){
		    var val = sel.value;
			if(val==0){
				$("#mark_"+index).val("");
			}else if(val==1){
				$("#mark_"+index).val("XXX董事长（或总经理）在XXX（处）出席XXXX合作意向协议签字仪式。……(可补充一句描述性语句)。");
			}else if(val==2){
				$("#mark_"+index).val("中国电力（2380.HK、0735.HK）X年年度业绩发布会在XXX召开。XXX董事长在香港主持会议，公司领导XXX、XXX、XXX出席会议。");
			}else if(val==3){
				$("#mark_"+index).val("中电国际在XXX（地）举办XXX报告会，……(可补充一句描述性语句)。XXX董事长（或总经理）出席活动并作致辞，该活动……(可补充一句描述性语句)。");
			}else if(val==4){
				$("#mark_"+index).val("中电国际党组X年X次会议在本部召开，党组书记、董事长（或总经理）XXX主持会议。会议讨论了《XXX个议题。》等X个议题。党组成员XXX、XXX出席会议。");
			}else if(val==5){
				$("#mark_"+index).val("中国电力董事局会议在XXX召开，执行董事兼总裁XXX主持会议。本次会议听取了XXX委员会的汇报及建议，并一致批准了《XXX》、《XXX》等X个议案。提请股东大会XXX、XXX、XXX等事项。集团公司董事长、党组书记，中电国际党组书记、董事长XXX，中国电力非执行董事XXX、XXX，独立XXX、XXX出席会议。");
			}else if(val==6){
				$("#mark_"+index).val("中电国际（中国电力）X年第X次执行委员会会议在XXX地召开，XXX董事长（或总经理）主持会议。会议讨论了《XXX》、《XXX》等X个议题。");
			}else if(val==7){
				$("#mark_"+index).val("中电国际（中国电力）X年第X次总经理办公会议在XXX地召开， XXX总经理主持会议。会议讨论了《XXX》《XXX》等X个议题。");
			}else if(val==8){
				$("#mark_"+index).val("中电国际（中国电力）X年工作会议在公司本部召开，XXX主持会议。XXX总经理做了题为《XXX》的工作报告。XXX董事长出席会议并讲话。");
			}else if(val==9){
				$("#mark_"+index).val("XXX年度公司领导务虚会在公司本部召开，XXX主持会议。本次会议围绕……等重点问题进行研究分析。公司领导XXX、XXX参加会议。");
			}else if(val==10){
				$("#mark_"+index).val("XXX年中电国际XXX专业工作会议在XXX地召开。XXX领导出席会议并讲话。");
			}else if(val==11){
				$("#mark_"+index).val("根据国家电投任〔X〕X号，XXX担任XXX职务。");
			}else if(val==12){
				$("#mark_"+index).val("公司调整了内设机构及职责（中电国际人资〔X〕X号）；调整了党组成员和领导班子成员职责分工（中电国际人资〔X〕X号、中国电力人资〔X〕X号）；调整了部门级领导岗位（中电国际人资〔X〕X号、中国电力人资〔X〕X号）。");
			}else if(val==13){
				$("#mark_"+index).val("根据中电国际人资〔X〕X号文件，成立XXX机构，主要负责XXX等工作。根据中电国际党〔X〕X号，XXX任XXX公司党委书记。");
			}else if(val==14){
				$("#mark_"+index).val("暂无");
			}else if(val==15){
				$("#mark_"+index).val("根据X发改能源〔X〕X号，XXX项目获得国家或XXX省发改委的核准批复。");
			}else if(val==16){
				$("#mark_"+index).val("XXX董事长（或总经理）在X地出席X公司1000MW机组工程开工仪式。(可补充一句描述性语句)。");
			}else if(val==17){
				$("#mark_"+index).val("XXX董事长（或总经理）致信祝贺X公司X号机组顺利通过168小组试运行，中电国际总装机容量达到XXXX万千瓦。");
			}else if(val==18){
				$("#mark_"+index).val("XXX项目荣获XXX年度XXX奖。");
			}else if(val==19){
				$("#mark_"+index).val("XXX项目荣获XXX国家专利。");
			}else if(val==20){
				$("#mark_"+index).val("XXX董事长（或总经理）在X地受到（国家领导人）XXX亲切会见，……。(可补充2-3句，描述会见成果及意义)。");
			}else if(val==21){
				$("#mark_"+index).val("XXX省委书记XXX一行到中电国际X公司调研， XXX董事长（或总经理、或副总经理）陪同考察。");
			}else if(val==22){
				$("#mark_"+index).val("XXX局XXX到中电国际XXX公司检查指导工作。XXX代表公司汇报工作。");
			}
		}
		//在一个大的地方显示这里的值
		function showMod(inp,index){
			var val = inp.value;
			if(val==null||val==""){
				return
			}
			$("#tempArea").html(val);
			$("#tempIn").val("mark_"+index);
			$("#tempDiv").show();
		}
		function hidMod(){
			var id = $("#tempIn").val();//mark id
			var text = $("#tempArea").html();
			$("#"+id).val(text);
			$("#tempDiv").hide();
		}
		//当修改是否时，给备注增加属性，标记是否必填
		function beizhubitian(index){
			if($("#isEvent_"+index).val()=="1"){
				$("#mark_"+index).addClass("yes");
			}else{
				$("#mark_"+index).removeClass("yes");
			}
		}
	</script>
  </head>
  
  <body>
  <form id="addForm" action="/icmp/schedule/meetingScheduleAdd.action" method="post">
  <div align="center" style="text-align: center;">
    <h3 style="color: #486494; font-family: 微软雅黑;font-weight: bold;">公司领导日程安排</h3>
    <div style="text-align: right;"><input value="${nowWeek }" name="nowWeek" type="hidden">${nowWeek }：<select id="leaderId" name="leaderId">
  	  <option>--请选择领导--</option>
	  <c:forEach items="${mobileInfoVOList }" var="mobileInfoVO">
		<option value="${mobileInfoVO.id }">${mobileInfoVO.name }</option>
	  </c:forEach>
    </select>&nbsp;</div>
  	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="10%" class="head1">时间</th>
            <th width="12%" class="head1">工作安排</th>
            <th width="12%" class="head1">参加大会名称</th>
            <th width="10%" class="head1">会议室</th>
            <th width="10%" class="head1">会议时间</th>
            <th width="9%" class="head1">列入大事记</th>
            <th width="12%" class="head1">大事记模版</th>
            <th width="20%" class="head1">备注</th>
          </tr>
        </thead>
		<tbody>
		  <c:forEach items="${weekList }" var="week" varStatus="state">
		  	<tr>
		  		<td><input value="${week }" name="sv${state.index+1 }.weekTime" type="hidden">${week }</td>
		  		<td>
		  			<select style="width: 100%;" name="sv${state.index+1 }.workId">
	  					<option value="0" >请选择工作安排</option><!-- 未选择时，按0处理，对比会议的选择 -->
	  					<c:forEach items="${scheduleWorkVOList }" var="scheduleWorkVO">
	  						<option value="${scheduleWorkVO.workId }">${scheduleWorkVO.workName }</option>
	  					</c:forEach>
		  			</select>
		  		</td>
	  			<td>
	  				<input value="" id="meetingId_${state.index+1 }" name="sv${state.index+1 }.meetingId" type="hidden">
	  				<select style="width: 100%;" onchange="meetingInfo(this,${state.index+1 })">
	  					<option value="0" >选择大会</option>
	  					<c:forEach items="${meetingDetailVOList }" var="meetingDetailVO">
	  						<option value="${meetingDetailVO.meetingDetailID }_${meetingDetailVO.meetingStartTime }_${meetingDetailVO.meetingEndTime }_${meetingDetailVO.meetingRoomName }">${meetingDetailVO.meetingName }</option>
	  					</c:forEach>
	  					<!-- <option>（空）</option> -->
	  				</select>
	  			</td>
	  			<td id="room_${state.index+1 }"></td>
	  			<td id="time_${state.index+1 }"></td>
	  			<td>
	  				<select name="sv${state.index+1 }.isEvent" id="isEvent_${state.index+1 }" onchange="beizhubitian(${state.index+1 });">
	  					<option value="0">否</option>
	  					<option value="1">是</option>
	  				</select>
	  			</td>
	  			<td>
	  				<select name="" style="width: 100%;" onchange="changeMod(this,${state.index+1 });">
	  					<option value="0">-大事记模版-</option>
	  					<option value="1">领导行程-公司班子成员代表公司出席的公务、商务活动</option>
	  					<option value="2">领导行程-常规、周期性的活动</option>
	  					<option value="3">领导行程-特定活动</option>
	  					<option value="4">重要会议-党组会、民主生活会</option>
	  					<option value="5">重要会议-董事会</option>
	  					<option value="6">重要会议-执委会</option>
	  					<option value="7">重要会议-总经理（总裁）办公会</option>
	  					<option value="8">重要会议-年度（中）工作会</option>
	  					<option value="9">重要会议-年度务虚会</option>
	  					<option value="10">重要会议-公司年度专业会议</option>
	  					<option value="11">组干人事-集团调整任命（含董事任命）</option>
	  					<option value="12">组干人事-本部部门级负责人调整任命(正职且免职内容不写)</option>
	  					<option value="13">组干人事-三级单位调整任命（主要负责人：总经理、书记）</option>
	  					<option value="14">经营发展-投融资、重组注资</option>
	  					<option value="15">经营发展-核准（省级及以上项目）</option>
	  					<option value="16">经营发展-开工（省级及以上项目）</option>
	  					<option value="17">投产（省级以上政府机关核准项目）</option>
	  					<option value="18">知识产权及重大获奖事项-国家、行业级的表彰</option>
	  					<option value="19">知识产权及重大获奖事项-知识产权</option>
	  					<option value="20">上级领导视察调研-党和国家领导人</option>
	  					<option value="21">上级领导视察调研-省部级以上国家机关主要领导(省长、省委书记到所属企业)</option>
	  					<option value="22">上级领导视察调研-行业主管部门司局级(国资委、国家能源局、国家发改委领导到本部)</option>
	  				</select>
	  			</td>
	  			<td><input onclick="showMod(this,${state.index+1 });" value="" name="sv${state.index+1 }.mark" id="mark_${state.index+1 }" style="width: 98%;">
	  			</td>
	  		</tr>
		  	
		  	</c:forEach>
		 </tbody>
	  </table>
	  <br>
	  <hr>
	  
  </div>
	 &nbsp;联络员：${sys_userSession.name}<input value="${sys_userSession.userID}" name="applyId" type="hidden"><br>
	 <!-- &nbsp;发送短信：<select><option>显示自己范围内的领导发送（权限控制）</option></select>	 -->
  </form>
  <div align="center">
 	<button class="submit1" onclick="scheduleAdd();">提交</button>
 	<button class="submit1" onclick="javascript:window.location.reload();">取消</button>
  </div>
  <div id="tempDiv" align="center" style="background-color:#F7F7F7; display: none;position: relative;top: -250px;">
  	<input type="hidden" id="tempIn">
  	<textarea id="tempArea"></textarea><br>
  	<button class="submit1" onclick="hidMod();">确定</button>
  </div>
  </body>
</html>
