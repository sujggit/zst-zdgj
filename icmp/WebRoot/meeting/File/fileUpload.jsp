<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>

<title>会议资料上传</title>
</head>
<body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <form action="${sys_ctx }/file/addMeetingFile.action" enctype="multipart/form-data" id="form" name="form" method="post" target="iframeTemp" >
     <input type="hidden" value="${param.meetingDetailID}" name="uploadFileVO.uploadKey"/>
     <input type="hidden" name="uploadFileVO.createUserID" id="userID" value="${sys_userSession.userID}"/>
     <input type="hidden" value="<%= application.getRealPath("/")%>" id="serverPath"/>
     <input type="hidden" id="isUploadFinished" value="" onclick="uploadFinished()"/>
	    <div id="contentwrapper" class="contentwrapper">
        <div class="contenttitle2">
	        <h5 class="fwb fl10" id="titleDiv">文件上传</h5>
	    </div>
	    <table border="0" cellspacing="0" cellpadding="0" class="stdtable" id="query_tableOther">
	       <thead>
	        <tr>
	           	<th width="9%" class="head1">序号</th>
	            <th width="72%" class="head1">上传文件（MaxSize:20MB）</th>           
	            <th width="19%" class="head1">操作</th>
            </tr>
           </thead>
	  		<tr>
		      <td class="alc">1</td>
		      <td>
		      	<input type="file" style="width: 88%" name="fileUrlTemp" value="" id="fileUrlTemp1" onchange="upload(1);"/>
		      	<input type="hidden" name="fileUrl" id="fileUrl1" value="" />
				<img src="${sys_ctx }/meeting/File/img/empty.gif" title="" style="float: right" id="fileIco1"/>
		      </td>
		      <td class="alc">
		        <input type="button" value="删 除" style="padding: 3px 10px;" onclick="delCurrentRow(this,1)" class="reset1 radius2"/>
		      </td>
	 		</tr>
	      </table>
	      <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	        <tfoot>
	        </tfoot>
	        <tbody>
	          <tr>
	            <td>
	              <span style="margin: 8px 10px" id="uploadSpan" class="promptSpan"></span>
	              <input type="button" value="添 加" onclick="addMore()" class="submit1 radius2"/>
	              <input type="button" id="uploadDataBaseBtn" value="保存上传" class="submit1 radius2" onclick="javascript:uploadDataBase();"/>
	              <input type="button" id="cancelBtn" value="关  闭" class="reset1 radius2"  onclick="javascript:window.close();"/>
	            </td>
	          </tr>
	        </tbody>
	      </table>
	    <iframe name="iframeTemp" id="iframeTemp" src="" frameborder="0" scrolling="no" style="display: none;height: 36px;"></iframe>	
	  </div>
  </form>
  <script type="text/javascript">
	<%
	  String meetingName=request.getParameter("meetingName");
	  //判断浏览器是IE还是google或者其他；若是IE则UTF-8为乱码，若是google则GB2312是乱码
	  String ie = request.getHeader("User-Agent");
	  if(ie.indexOf("MSIE")!=-1){
		  meetingName = new String(meetingName.getBytes("ISO8859-1"), "gb2312");
	  }else{
		  meetingName = new String(meetingName.getBytes("ISO8859-1"), "UTF-8");
	  }
	  out.println("var meetingName = '" + meetingName + "'");  
	 %>
	 document.getElementById("titleDiv").innerHTML = "文件上传（所属会议：" + meetingName + "）";
	//addMore函数可以提供上传多个文件上传，delCurrentRow函数删除当前的行
	function addMore(){
		var index = document.getElementsByTagName("tr").length - 1;
		var table = document.getElementById("query_tableOther");	
		$("#query_tableOther").append("<tr><td class='alc'>"+index+"</td><td></td><td class='alc'></td></tr>");
		var td2 = document.getElementsByTagName("tr")[index].getElementsByTagName("td")[1];
		var td3 = document.getElementsByTagName("tr")[index].getElementsByTagName("td")[2];
		$(td2).append("<input type='file' style='width: 88%' name='fileUrlTemp' value='' id='fileUrlTemp"+index+"' onchange='upload("+index+")'/>");
		$(td2).append("<input type='hidden' name='fileUrl' id='fileUrl"+index+"' value='' />");
		$(td2).append("<img src='${sys_ctx }/meeting/File/img/empty.gif' title='' style='float: right' id='fileIco"+index+"'/>");		
		$(td3).append("<input type='button' id='delBtn' value='删  除' class='reset1 radius2' style='padding: 3px 8px;' onclick='delCurrentRow(this,"+index+");'/>");
	}
	function delCurrentRow(currentRow,index){
		var fileUrl = document.getElementById("fileUrl"+index).value;
		var serverPath = document.getElementById("serverPath").value;
		$(currentRow).parent().parent().remove();
		if(fileUrl){//删除上传的文件
			var filePath = serverPath + fileUrl;
			DwrMethod.delFile(filePath,function(para){});
		}
		//$("#query_tableOther").append("<tr style='display:none'></tr>");
	}

	/**上传文件函数~负责与后台servlet的数据提交；target="iframeTemp"时form表单必须的属性；enctype="multipart/form-data"是form表单上传文件必须的
	$("#form").attr("action","${sys_ctx }/fileupload?savePath=/file/meeting/&maxSize=20&index="+index);其中：有三个参数比传：
	savePath:上传文件的路径；maxSize：上传文件的限制值；index上传文件的file的id的索引参数，也可以确认是此jsp页面属于单文件上传，还是多文件上传
	*/
	function upload(index){
		/**
		通过前台控制上传文件类型；若安全性要求很高，则必须也进行后台的控制
		*/
		var reg = /^.*(.doc|.docx|.xls|.xlsx|.ppt|.pptx|.pdf|.txt|.jpg|.gif|.png|.jpeg|.bmp)$/i;
		
		if(reg.test(document.getElementById("fileUrlTemp"+index).value)){
			var d=document.getElementById("fileUrlTemp"+index);
			x=d.value.split("\\");
			var inputValue=x[x.length-1];
			var c=document.getElementsByTagName("tr").length-1;
			if(c==2){
			$("#form").attr("action","${sys_ctx }/fileupload?savePath=/file/meeting/&maxSize=20&index="+index);
			document.getElementById("fileUrl"+index).value="";
			document.getElementById("uploadSpan").innerHTML="正在上传...";
			document.getElementById("fileIco"+index).src="${sys_ctx }/meeting/File/img/empty.gif";
			document.getElementById("fileIco"+index).title="";
			document.getElementById("isUploadFinished").value="";
			$(":file").attr("disabled","true");
			$("#fileUrlTemp"+index).removeAttr("disabled");//保证上传过成功只有一个file正在上传；
			$("#form").submit();
			$(":button").attr("disabled","true");
			$("#fileUrlTemp"+index).attr("disabled","true");//上传的过程中保证所有的file以及button都不可用；
			$("#form").attr("action","${sys_ctx }/file/addMeetingFile.action");
			}else{
				var array=new Array();
				for(var i=1;i<c;i++){
					if(i!=index){
					var a=document.getElementById("fileUrlTemp"+i);
					if(a.value!=null&&a.value!=""){
					b=a.value.split("\\");
					oper=b[b.length-1];
					array.push(oper);
					}
					}
				}
				var uPload=0;
				for(var j=0;j<array.length;j++){
					
					if(array[j].indexOf(inputValue)>-1){
						alert("相同文件，请重新选择文件上传！");
						document.getElementById("fileUrlTemp"+index).value="";
						document.getElementById("fileUrl"+index).value="";
						document.getElementById("fileIco"+index).src="${sys_ctx }/meeting/File/img/empty.gif";
						return uPload=1;
					}
				}
				if(uPload!=1){
					$("#form").attr("action","${sys_ctx }/fileupload?savePath=/file/meeting/&maxSize=20&index="+index);
					document.getElementById("fileUrl"+index).value="";
					document.getElementById("uploadSpan").innerHTML="正在上传...";
					document.getElementById("fileIco"+index).src="${sys_ctx }/meeting/File/img/empty.gif";
					document.getElementById("fileIco"+index).title="";
					document.getElementById("isUploadFinished").value="";
					$(":file").attr("disabled","true");
					$("#fileUrlTemp"+index).removeAttr("disabled");//保证上传过成功只有一个file正在上传；
					$("#form").submit();
					$(":button").attr("disabled","true");
					$("#fileUrlTemp"+index).attr("disabled","true");//上传的过程中保证所有的file以及button都不可用；
					$("#form").attr("action","${sys_ctx }/file/addMeetingFile.action");
				}
				
				
			}
		}else{
			alert("请重新上传！允许上传的文件格式有：doc|docx|xls|xlsx|ppt|pptx|pdf|txt|jpg|gif|png|jpeg|bmp");
		}
	}

	//上传完毕后，由servlet调用的函数，保证上传完毕后所有的file以及button都恢复可用；
	function uploadFinished(){
		$(":file").removeAttr("disabled");
		$(":button").removeAttr("disabled");
		setTimeout("document.getElementById('uploadSpan').innerHTML=''",3000)
	}

	//上传完毕后，提交保存相应数据到数据中；
	function uploadDataBase(){
		var fileUrls = document.getElementsByName("fileUrl");
		if(undefined != fileUrls[0]){
			var fileUrlArr = new Array();
			var flag = true;
			if(fileUrls[0].value){
				for(var i=0;i<fileUrls.length;i++){
					if(fileUrls[i].value){
						fileUrlArr.push(fileUrls[i].value);
					}else{
						flag = false;
					}
				}
				if(flag){
					$(":file").attr("disabled","true");
					$("#form").attr("action","${sys_ctx }/file/addMeetingFile.action?fileUrlArr="+fileUrlArr);
					//window.returnValue="1";
					$("#form").submit();
					$("#uploadDataBaseBtn").attr("disabled","true");
					//$("#cancelBtn").removeAttr("disabled");
					setTimeout("window.close()",5000);
				}else{
					alert("请删除没有上传以及上传失败的行！");
				}
			}else{
				alert("请先上传文件！");
			}
		}else{
			alert("请添加并上传文件！");
		}
	}
  </script>
<body style="tml&gt;"></body>
</html>