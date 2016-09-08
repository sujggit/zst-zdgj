<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<%@include file="/common/common.jsp"%>
	<head>
	<script type="text/javascript">
	  function menu(m) {
		for ( var x = 2; x <= 5; x++) {
			document.getElementById("k" + x).style.display = "none";
			document.getElementById("m" + x).style.backgroundColor = "";
		}

		document.getElementById("k" + m).style.display = "block";
		document.getElementById("m" + m).style.backgroundColor = "#fff";
	  }
	</script>


	</head>
	<body class="withvernav" onload="menu(2);">
		<div class="min-widthdiv">
			<div class="bodywrapper">
					<div id="basicform" class="contentwrapper">
						<!--contenttitle-->
						<div class="center1">
							<div id="m">
								<ul>
						
									<li id="m2" onmousedown=
	menu(2);
>
										会议类型
									</li>
									<li id="m3" onmousedown=
	menu(3);
>
										会议状态
									</li>
									<li id="m4" onmousedown=
	menu(4);
>
										日志类型
									</li>
									<li id="m5" onmousedown=
	menu(5);
>
										会议室类型
									</li>
									<!-- centercontent <li id="m6" onmousedown=
	menu(6);
>
										控制按钮类型
									</li>-->
								</ul>
							</div>
							
							<div id="k2" class="k" style="display: none">
								<%@include file="./meetingType.jsp"%>
							</div>
							<div id="k3" class="k" style="display: none">
								<%@include file="./meetingStatus.jsp"%>
							</div>
							<div id="k4" class="k" style="display: none">
								<%@include file="./logType.jsp"%>
							</div>
							<div id="k5" class="k" style="display: none">
								<%@include file="./meetingRoomType.jsp"%>
							</div>
							<!--<div id="k6" class="k" style="display: none">
								
							</div>include file="./meetingControlMenu.jsp"-->

						</div>
                      
						<!--contenttitle-->
					</div>
					<!--contentwrapper-->
				</div>
			</div>
	</body>
</html>
