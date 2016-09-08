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
   <form action="${sys_ctx }/conference/conferenceList.action" id="pageform" name="pageform" method="post">
    <input name="meetingDetailVO.meetingStartTime" id="meetingStartTime" type="hidden"  value=""/>
	<input name="meetingDetailVO.meetingEndTime" id="meetingEndTime"  type="hidden" value=""/>
   </form>
	<table width="100%" cellpadding="0" cellspacing="0" border="0" class="stdtablemeet">
        <thead>
            <tr>
                <td style="text-align:left" onclick="preMonth()"><a href="#"><img src="../../style/normal/images/prev.png"/></a></td><td colspan="5"><a id="selDate" onclick="selectYear()"></a></td><td style="text-align:right" onclick="nextMonth()"><a href="#"><img src="../../style/normal/images/next.png"/></a></td>
            </tr>
            <tr>
                <th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th>
            </tr>
        </thead>
        <tbody>
        	<!-- 
			<tr>
				<td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td>
			</tr>	
			<tr>
				<td><h6 class="yuding"></h6><a href="#">1</a></td><td><a href="#">2</a></td><td><a href="#">3</a></td><td><a href="#">4</a></td><td><a href="#">5</a></td><td><a href="#">6</a></td><td><a href="#">7</a></td>
			</tr>
			<tr>
				<td><a href="#">8</a></td><td><a href="#">9</a></td><td><a href="#">10</a></td><td><a href="#">11</a></td><td><a href="#">12</a></td><td><a href="#">13</a></td><td><a href="#">14</a></td>
			</tr>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">15</a></td><td><a href="#">16</a></td><td><a href="#">17</a></td><td><a href="#">18</a></td><td><a href="#">19</a></td><td><a href="#">20</a></td><td><a href="#">21</a></td>
			</tr>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">22</a></td><td><a href="#">23</a></td><td><a href="#">24</a></td><td><a href="#">25</a></td><td><a href="#">26</a></td><td><a href="#">27</a></td><td><a href="#">28</a></td>
			</tr>
			<tr>
				<td><h6 class="yuding"></h6><a href="#">29</a></td><td><a href="#">30</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td>
			</tr>
		 -->		
		</tbody>
	</table>
  </div>
  <script type="text/javascript">
    var selYear = "${param.selYear}";//上一页面传来的年月日-----都为空
    var selMonth = "${param.selMonth}";  	
	var currDay = "${param.currDay}";
	var myDate = new Date();

	if(selYear==null||selYear.length==0){
		selYear = myDate.getFullYear();//从 Date 对象以四位数字返回年份。
	}
	
	if(selMonth==null||selMonth.length==0){
		selMonth = myDate.getMonth()+1;
	}
	
	if(currDay==null||currDay.length==0){
		currDay = myDate.getDate();
	}
		
	var currYear = parseInt(selYear,10);//以十进制来解析字符串
	var currMonth = parseInt(selMonth,10);//当前选中的月，此页面的日不可变
  
  	$(document).ready(function(){
		$("#selDate").text(currYear+"年"+selMonth+"月");
		initPage();
		if(currDay){
			var currDay1 = Number(currDay);
			var days = $("table tbody tr td a");
			//alert(JSON.stringify(days));
			$(days[currDay1-1]).parent().addClass("xuanzhong");
		}else{
			//alert(1);
		}
  	 })
  	 
  	 function selectYear(){
  		window.location.href = "${sys_ctx }/meeting/conferenceBook/calendarYear.jsp?currYear="+currYear+"&currMonth="+currMonth+"&currDay="+currDay;
 	 }

	/**根据年和月获取当月的天数
	*/
  	function getDaysInMonth(year,month){
		month = parseInt(month,10);//第二个参数代表10进制
		var temp = new Date(year,month,0);
		return temp.getDate();
  	}

  	/**根据年、月和日获取当月当日属于周几
	*/
  	function getWeek(year,month,day){//0星期日1一2二3三4四5五6六;月份0~11
  		month = parseInt(month,10);
  		day = parseInt(day,10);
  		var temp = new Date(year,month-1,day);
  		return temp.getDay();
  	}

  	function initPage(){
  		$("table tbody").empty();//在给定的祖先元素下匹配所有的后代元素
		var day = getDaysInMonth(currYear,currMonth);
		var firstWeek = getWeek(currYear,currMonth,1);//本月第一天是星期几
		if(firstWeek==0){//星期日
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td></tr>");
				$("table tbody").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currcurrMonth==11){
					$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a><td>1</td><td>2</td><td>3</td><td>4</td></tr>");
			}
		}else if(firstWeek==1){//星期一
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td></tr>");
				$("table tbody").append("<tr><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td><td>13</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>");
				$("table tbody").append("<tr><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td><td>2</td><td>3</td><td>4</td></tr>");
				$("table tbody").append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a></td><td>1</td><td>2</td><td>3</td></tr>");
				$("table tbody").append("<tr><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td></tr>");
			}
		}else if(firstWeek==2){//星期二
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>");
				$("table tbody").append("<tr><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td><td>12</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>27</a><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td><td>2</td><td>3</td><td>4</td></tr>");
				$("table tbody").append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td><td>2</td><td>3</td></tr>");
				$("table tbody").append("<tr><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>29</td><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>27</td><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a></td><td>1</td><td>2</td></tr>");
				$("table tbody").append("<tr><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td></tr>");
			}
		}else if(firstWeek==3){//星期三
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td><td>2</td><td>3</td><td>4</td></tr>");
				$("table tbody").append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td><td>2</td><td>3</td></tr>");
				$("table tbody").append("<tr><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td><td>2</td></tr>");
				$("table tbody").append("<tr><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>28</td><td>29</td><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a></td><td>1</td></tr>");
				$("table tbody").append("<tr><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td></tr>");
			}
		}else if(firstWeek==4){//星期四
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td><td>2</td><td>3</td></tr>");
				$("table tbody").append("<tr><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td><td>2</td></tr>");
				$("table tbody").append("<tr><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td></tr>");
				$("table tbody").append("<tr><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>27</td><td>28</td><td>29</td><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a></td></tr>");
				$("table tbody").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td></tr>");
			}
		}else if(firstWeek==5){//星期五
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td><td><h6 class='yuding'></h6><a href='#'>9</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td><td><h6 class='yuding'></h6><a href='#'>16</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td><td><h6 class='yuding'></h6><a href='#'>23</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td><td>2</td></tr>");
				$("table tbody").append("<tr><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td>1</td></tr>");
				$("table tbody").append("<tr><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td></tr>");
				$("table tbody").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td><td><h6 class='yuding'></h6><a href='#'>2</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td><td><h6 class='yuding'></h6><a href='#'>30</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>31</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td></tr>");
			}
		}else if(firstWeek==6){//星期六
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>2</a></td><td><h6 class='yuding'></h6><a href='#'>3</a></td><td><h6 class='yuding'></h6><a href='#'>4</a></td><td><h6 class='yuding'></h6><a href='#'>5</a></td><td><h6 class='yuding'></h6><a href='#'>6</a></td><td><h6 class='yuding'></h6><a href='#'>7</a></td><td><h6 class='yuding'></h6><a href='#'>8</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>9</a></td><td><h6 class='yuding'></h6><a href='#'>10</a></td><td><h6 class='yuding'></h6><a href='#'>11</a></td><td><h6 class='yuding'></h6><a href='#'>12</a></td><td><h6 class='yuding'></h6><a href='#'>13</a></td><td><h6 class='yuding'></h6><a href='#'>14</a></td><td><h6 class='yuding'></h6><a href='#'>15</a></td></tr>");
			$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>16</a></td><td><h6 class='yuding'></h6><a href='#'>17</a></td><td><h6 class='yuding'></h6><a href='#'>18</a></td><td><h6 class='yuding'></h6><a href='#'>19</a></td><td><h6 class='yuding'></h6><a href='#'>20</a></td><td><h6 class='yuding'></h6><a href='#'>21</a></td><td><h6 class='yuding'></h6><a href='#'>22</a></td></tr>");
			if(day==28){//二月
				$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td>1</td></tr>");
				$("table tbody").append("<tr><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td></tr>");
			}else if(day==29){//二月
				$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td></tr>");
				$("table tbody").append("<tr><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td></tr>");
			}else if(day==30){
				if(currMonth==4||currMonth==6||currMonth==9||currMonth==11){
					$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>30</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td></tr>");
			}else if(day==31){
				if(currMonth==5||currMonth==7||currMonth==10||currMonth==12){
					$("table tbody").prepend("<tr><td>25</td><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				}else if(currMonth==1||currMonth==8){
					$("table tbody").prepend("<tr><td>26</td><td>27</td><td>28</td><td>29</td><td>30</td><td>31</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				}else if(currMonth==3){//2月特殊情况暂不考虑
					$("table tbody").prepend("<tr><td>23</td><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td><td><h6 class='yuding'></h6><a href='#'>1</a></td></tr>");
				}
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>23</a></td><td><h6 class='yuding'></h6><a href='#'>24</a></td><td><h6 class='yuding'></h6><a href='#'>25</a></td><td><h6 class='yuding'></h6><a href='#'>26</a></td><td><h6 class='yuding'></h6><a href='#'>27</a></td><td><h6 class='yuding'></h6><a href='#'>28</a></td><td><h6 class='yuding'></h6><a href='#'>29</a></td></tr>");
				$("table tbody").append("<tr><td><h6 class='yuding'></h6><a href='#'>30</a></td><td><h6 class='yuding'></h6><a href='#'>31</a></td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>");
			}
		}

		getMeetingOccupy();//获取会议个数
		
		//绑定事件
		$("table tbody tr td a").bind("click",function(){
	  	  	var date = currYear + "-" + currMonth + "-" + $(this).text();
	  	    if(date!=null&&date.length>0){
				$("#meetingStartTime").attr("value",date);
			    $("#meetingEndTime").attr("value",date);
			}
			$("#pageform").submit();
	  	})
  	}
  	
  	/**获取会议的个数
	*/
  	function getMeetingOccupy(){
		BaseDwrMethod.getMeetingOccupy(currYear,currMonth,function(result){
			if(result){
				var numbers = $("table tbody tr td h6");
				var results = result.split(";");
				var resultss = "";
				var monthTemp = "";
				for(var i=0;i<results.length;i++){
					resultss = results[i].split(":");
					monthTemp = resultss[0]-1;
					if(resultss[1]>0){
						$(numbers[monthTemp]).text(resultss[1]);
					}
					$(numbers[monthTemp]).attr("title",resultss[0]+"号有"+resultss[1]+"个会议");
				}
			}
		});
	}

  //上一年
	function preMonth(){
		currMonth = parseInt($("#selDate").text().substring(5,$("#selDate").text().length-1),10) - 1;
		if(currMonth==0){
			currYear = currYear-1;
			currMonth = 12;
		}
		$("#selDate").text(currYear+"年"+currMonth+"月");
		initPage();
	}
	//下一年
	function nextMonth(){
		currMonth = parseInt($("#selDate").text().substring(5,$("#selDate").text().length-1),10) + 1;
		if(currMonth==13){
			currYear = currYear+1;
			currMonth = 1;
		}
		$("#selDate").text(currYear+"年"+currMonth+"月");
		initPage();
	}
  </script>
</body>
</html>