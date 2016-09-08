<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>会议室日历</title>
  <link rel="stylesheet" href="calendar.css" type="text/css" />
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/BaseDwrMethod.js'></script>
</head>
<body>	
  <div class="contentwrapper">
	<table width="100%" cellpadding="0" cellspacing="0" border="0" class="stdtablemeet">
        <thead>
            <tr>
                <td style="text-align:left" onclick="preYear()"><a href="#"><img src="../../style/normal/images/prev.png"/></a></td><td style="cursor: default;"><a id="currYear" style="cursor: default;"></a></td><td style="text-align:right" onclick="nextYear()"><a href="#"><img src="../../style/normal/images/next.png"/></a></td>
            </tr>
        </thead>
        <tbody>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">1月</a></td><td><h6 class="yuding"></h6><a href="#">2月</a></td><td><h6 class="yuding"></h6><a href="#">3月</a></td>
			</tr>
			<tr>	
				<td><h6 class="yuding"></h6><a href="#">4月</a></td><td><h6 class="yuding"></h6><a href="#">5月</a></td><td><h6 class="yuding"></h6><a href="#">6月</a></td>
			</tr>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">7月</a></td><td><h6 class="yuding"></h6><a href="#">8月</a></td><td><h6 class="yuding"></h6><a href="#">9月</a></td>
			</tr>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">10月</a></td><td><h6 class="yuding"></h6><a href="#">11月</a></td><td><h6 class="yuding"></h6><a href="#">12月</a></td>
			</tr>			
		</tbody>
	</table>
  </div>
  <script type="text/javascript">
    var currYear = "${param.currYear}";//上一页面传来的年月日
    var currMonth = "${param.currMonth}";
    var currDay = "${param.currDay}";
  	var myDate = new Date();

	if(currYear==null||currYear.length==0){
		currYear = myDate.getFullYear();
	}
	
	if(currMonth==null||currMonth.length==0){
		currMonth = myDate.getMonth();
	}
	
	if(currDay==null||currDay.length==0){
		currDay = myDate.getDate();
	}
	
	$(document).ready(function(){
		$("#currYear").text(currYear+"年");
		var months = $("table tbody tr td");
		$(months[currMonth-1]).addClass("xuanzhong");

		getMeetingOccupy();

		$("table tbody tr td a").bind("click",function(){
			var selYear = $("#currYear").text().substring(0,4);
			var selMonth = $(this).text().substring(0,$(this).text().length-1);
			if(currYear==selYear&&currMonth==selMonth){
				window.location.href = "${sys_ctx }/meeting/conferenceBook/calendarMonth.jsp?selYear="+selYear+"&selMonth="+selMonth+"&currDay="+currDay;
			}else{
				window.location.href = "${sys_ctx }/meeting/conferenceBook/calendarMonth.jsp?selYear="+selYear+"&selMonth="+selMonth;
			}
		})
	})
	
	/**获取会议的个数
	*/
	function getMeetingOccupy(){
		BaseDwrMethod.getMeetingOccupy($("#currYear").text().substring(0,4),null,function(result){
			if(result){
				var numbers = $("table tbody tr td h6");
				var results = result.split(";");
				var resultss = "";
				var monthTemp = "";
				for(var i=0;i<results.length;i++){
					resultss = results[i].split(":");
					monthTemp = resultss[0]-1;
					$(numbers[monthTemp]).text("");//先清空
					if(resultss[1]>0){
						$(numbers[monthTemp]).text(resultss[1]);
					}
					$(numbers[monthTemp]).attr("title",resultss[0]+"月份有"+resultss[1]+"个会议");
				}
			}
		});
	}

	//上一年
	function preYear(){
		var year = parseInt($("#currYear").text().substring(0,4),10) - 1;
		$("#currYear").text(year+"年");
		getMeetingOccupy();
	}
	//下一年
	function nextYear(){
		var year = parseInt($("#currYear").text().substring(0,4),10) + 1;
		$("#currYear").text(year+"年");
		getMeetingOccupy();
	}
  </script>
</body>
</html>