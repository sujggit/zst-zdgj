<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>left</title>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
</head>
<body style="overflow:auto;overflow-x:hidden">
	<div class="vernav2 iconmenu">
		<ul>
			<li class="current"><a href="Tab/Tab.jsp" class="gallery" target="I2" >选项卡</a></li>
			<li><a href="Tab/listing.jsp" class="gallery" target="I2" >列表</a></li>
			<li><a href="Tab/regulate.jsp" class="gallery" target="I2" >控制字符个数</a></li>
			<li><a href="Tab/time.jsp" class="gallery" target="I2" >时间插件</a></li>
			<li><a href="Tab/acquiesce.jsp" class="gallery" target="I2" >可输入、可点击增长</a></li>
			<li><a href="Tab/ztree.jsp" class="gallery" target="I2" >树状图</a></li>
			<li><a href="Tab/select_all.jsp" class="gallery" target="I2" >全选</a></li>
			<li><a href="Tab/bd.jsp" class="gallery" target="I2" >表单</a></li>
			<li><a href="Tab/alternately.jsp" class="gallery" target="I2" >交互</a></li>
			<li><a href="Tab/add_item.jsp" class="gallery" target="I2" >添加项</a></li>
                   
		</ul>
	</div>
	<script>
		$("ul li").click(function(){
			$("ul li").removeClass("current");
			$(this).addClass("current");
		})
	</script>
</body>
</html>
