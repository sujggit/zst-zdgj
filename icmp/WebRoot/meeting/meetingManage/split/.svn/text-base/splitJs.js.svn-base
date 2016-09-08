function splitSubmit(screenCount,layoutMode){
		if(screenCount==100){
			var meetingMode = "conference";
			screenCount = 1;
			var splitInfos = new Array();
			splitInfos[0] = "auto";
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var confID = "";
			var mcuType = "";
			var videoMode = "";
			var lecturer = "";
			var monitor = document.getElementById("monitor").value;
			var type = document.getElementById("type").value;
		}else{
	  		var splitInfos = new Array();
	  		$("ul li select").each(function(i){
	  			splitInfos[$(this).attr("id")] = $(this).val();
	  		});
	  		var meetingDetailID = document.getElementById("meetingDetailID").value;
	  		var confID = document.getElementById("confID").value;
	  		var mcuType = parent.document.getElementById(confID).value;
			var videoMode = "";
			if(mcuType == 11){
				videoMode = parent.document.getElementById("mode").value;
			}
			var lecturer = "";
			
			var monitor = parent.document.getElementById("monitor").value;
			
		
			
			var meetingMode = "personal";
			var type = parent.document.getElementById("type").value;
		}
		
  		McuDwrMethod.setVideoScreen(meetingDetailID, confID, lecturer, videoMode, layoutMode, screenCount, splitInfos, monitor,meetingMode,type);
  	}

	//初始化onchange事件
	$(document).ready(function(){
		$("ul li select").change(mutex);
	
	});
	
	// 互斥操作
	function mutex(){
		var id = $(this).attr("id");
		var value = $(this).val();
		var text = $.trim($(this).find("option:selected").text());
		$("ul li select").not($("#"+id)[0]).each(function(){
			if($(this).val()==value&&text!="自动"&&text!="空"){
				$(this).find("option[text='自动']").attr("selected",true);
			}
		});
	}
