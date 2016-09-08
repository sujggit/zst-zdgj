<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>上传授权文件</title>
  <script type="text/javascript">
      function menu(){
		document.getElementById("m6").style.backgroundColor="#fff";
	  }	

	  //上传/icmp/WebRoot/images/zst.png
       function upload(){
		 if(document.getElementById("fileUrlTemp").value){
			 var reg = /^.*(.lic)$/i;
	    	 if(reg.test(document.getElementById("fileUrlTemp").value)){
				$("#form").attr("action","${sys_ctx }/fileupload?savePath=/WEB-INF/classes/&maxSize=1&index=shouquanUpload");
				$("#form").attr("target","iframeTemp");
				document.getElementById('uploadSpan').innerHTML="正在上传...";
				document.getElementById('fileUrl1').value="";
				$("#form").submit();
				$("#form").attr("action","");
				$("#form").attr("target","");
				//$("#form").removeAttr("enctype");
	    	 }else{
	    		 alert("请重新上传！允许上传的文件格式有：lic");
		   	 }
		 }else{
			document.getElementById('uploadSpan').innerHTML="请先选择要上传的授权文件";
		 }
	   }

	   function changeUploadSpan(){
		   if($("#uploadSpan").html()=="上传成功"){//代表上传成功
			   document.getElementById('uploadSpan').innerHTML="授权文件替换成功";
			}
	   }
    </script>
  </head>
  <body onload="menu();" >
    <div id="contentwrapper" class="contentwrapper"><!--contenttitle-->
      <%@include file="./pageLabel.jsp"%>
      <div id="basicform">
         <form action="" id="form" name="form" method="post" enctype="multipart/form-data" target="iframeTemp">
         	<input type="hidden" id="isUploadFinished" value="" onclick="changeUploadSpan()"/>
         	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
         	    <!--<div class="contenttitle2">
        		  <h5 class="fwb fl10">logo图标替换（最佳尺寸：70px*42px）</h5>
      		    </div>-->
	         	<tr>
		          <td class="tableaddtitle" width="20%"><span class="fonttsx">*</span>授权文件</td>
		          <td class="tableadd_data" colspan="3" width="80%">
				    <input type="file" style="width: 48%" name="fileUrlTemp" id="fileUrlTemp" value="浏览" onchange="document.getElementById('uploadSpan').innerHTML='请上传文件'" />
				    <input type="button" value="点击上传" onclick="upload();" id="upFileBtn" class="stdbtn mlr10" style='padding: 3px 2px;' />
				    <font color="red"></font>
				    <input type="hidden" name="uploadFileVO.fileUrl" id="fileUrl1" value="" />
				    <span style="color: red" id="uploadSpan"></span><!-- id="fileUrl1" id="uploadSpan"都是上传的后台写入前台的id所以不可缺-->
				    <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>
				    <img src="${sys_ctx }/images/dtree_images/empty.gif" title="" id="fileIco1"/>
				  </td>
		        </tr>
		    </table>
         </form>
        </div>
        </div>
  </body>
</html>