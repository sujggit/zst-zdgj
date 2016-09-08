<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文件导入</title>
</head>
<body style='' >
  <form action="" enctype="multipart/form-data" id="form" name="form" method="post" target="iframeTemp" >
     <input type="hidden" id="isUploadFinished" value="" onclick="uploadFinished()"/>
	    <div id="contentwrapper" class="contentwrapper">
        <div class="contenttitle2">
	        <h5 class="fwb fl10">文件导入</h5>
	    </div>
	    <table border="0" cellspacing="0" cellpadding="0" class="stdtable" id="query_tableOther">
	       <thead>
	        <tr>
	           	<th width="9%" class="head1">序号</th>
	            <th width="72%" class="head1">导入文件</th>           
	            <th width="19%" class="head1">操作</th>
            </tr>
           </thead>
	  		<tr>
		      <td class="alc">1</td>
		      <td>
		      	<input type="file" style="width: 88%" name="fileUrlTemp" value="" id="fileUrlTemp1" />
				<img src="${sys_ctx }/images/dtree_images/empty.gif" title="" style="float: right" id="fileIco1"/>
		      </td>
		      <td class="alc">
		        <input type="button" value="导入" onclick="upload(1)" class="stdbtn"/>
		      </td>
	 		</tr>
	      </table>
	      <div style="color: red;margin-left: 100px;">仅支持xls格式</div>
	      <input type="button" id="cancelBtn" value="关  闭" class="submit1 radius2"  onclick="javascript:window.close();" style="float: right;margin-right: 20px"/>
	      <span style="font-size:14px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; color: red;float: right;margin: 8px 10px" id="uploadSpan"></span>
	    <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>	
	  </div>
  </form>
  <script type="text/javascript">
	

	/**上传文件函数~负责与后台servlet的数据提交；target="iframeTemp"时form表单必须的属性；enctype="multipart/form-data"是form表单上传文件必须的
	$("#form").attr("action","${sys_ctx }/fileupload?savePath=/file/meeting/&maxSize=20&index="+index);其中：有三个参数比传：
	savePath:上传文件的路径；maxSize：上传文件的限制值；index上传文件的file的id的索引参数，也可以确认是此jsp页面属于单文件上传，还是多文件上传
	*/
	function upload(index){
		/**
		通过前台控制上传文件类型；若安全性要求很高，则必须也进行后台的控制
		*/
		var type = window.parent.dialogArguments.type1;
		
		if( confirm("导入excel会清空现有临时数据,请确保之前的数据同步已经完成")){
			var reg = /^.*(.xls)$/i;
			if(reg.test(document.getElementById("fileUrlTemp"+index).value)){
				$("#form").attr("action","${sys_ctx }/importMeetingRoom?type="+type+"&savePath=/file/import/&maxSize=20&index="+index);
				document.getElementById("uploadSpan").innerHTML="正在上传...";
				document.getElementById("fileIco"+index).src="${sys_ctx }/images/dtree_images/empty.gif";
				document.getElementById("fileIco"+index).title="";
				document.getElementById("isUploadFinished").value="";
				$(":file").attr("disabled","true");
				$("#fileUrlTemp"+index).removeAttr("disabled");//保证上传过成功只有一个file正在上传；
				$("#form").submit();
				$(":button").attr("disabled","true");
				$("#fileUrlTemp"+index).attr("disabled","true");//上传的过程中保证所有的file以及button都不可用；
				$("#form").attr("action","${sys_ctx }/file/addMeetingFile.action");
	
				
				
			}else{
				alert("请重新上传！只允许xls格式");
			}
		}
	}

	//上传完毕后，由servlet调用的函数，保证上传完毕后所有的file以及button都恢复可用；
	function uploadFinished(){
		
		$(":file").removeAttr("disabled");
		$(":button").removeAttr("disabled");
		window.returnValue="1";
		setTimeout("window.close()",2000);
	}

	
  </script>
</body>
</html>