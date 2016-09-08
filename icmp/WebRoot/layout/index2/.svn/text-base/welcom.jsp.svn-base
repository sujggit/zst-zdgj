<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>middle</title>
<script type="text/javascript">
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      oldonload();
      func();
    }
  }
}
function prepareInputsForHints() {
 var inputs = document.getElementsByTagName("input");
 for (var i=0; i<inputs.length; i++){
  // test to see if the hint span exists first
  if (inputs[i].parentNode.getElementsByTagName("span")[0]) {
   // the span exists!  on focus, show the hint
   inputs[i].onfocus = function () {
    this.parentNode.getElementsByTagName("span")[0].style.display = "inline";
   }
   // when the cursor moves away from the field, hide the hint
   inputs[i].onblur = function () {
    this.parentNode.getElementsByTagName("span")[0].style.display = "none";
   }
  }
 }
 // repeat the same tests as above for selects
 var selects = document.getElementsByTagName("select");
 for (var k=0; k<selects.length; k++){
  if (selects[k].parentNode.getElementsByTagName("span")[0]) {
   selects[k].onfocus = function () {
    this.parentNode.getElementsByTagName("span")[0].style.display = "inline";
   }
   selects[k].onblur = function () {
    this.parentNode.getElementsByTagName("span")[0].style.display = "none";
   }
  }
 }
}
addLoadEvent(prepareInputsForHints);
</script>
</head>

<body>
<div class="hyjrner">


<div class="tablesdiv2">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="hyjrys">
    <tr>
      <td  align="right">
      <div class="hyjrbgys"></div>
      </td>
    </tr>
  </table>
</div>

</div>
</body>
</html>
