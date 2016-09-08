function dictionaryView(obj){
	if(obj.value=="meetingTime"){//立即召开-会议时长
		$('#dicViewName').attr("value","1个小时");
		$('#spanTitle').html("会议时长单位为小时--例如：1小时，数值填入1");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","1");
		$('#dicValue').attr("title","请输入小时");
		$('#spanValue').html("小时");
		$('#description').attr("disabled","");
		$('#description').val("立即召开下的会议时长选项");
		$('#description').attr("title","");
	}else if(obj.value=="meetingCost"){//会议费用-费用项
		$('#dicViewName').attr("value","部门主管");
		$('#spanTitle').html("会议费用单位为元--数值处请输入费用");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","100");
		$('#dicValue').attr("title","请输入费用");
		$('#spanValue').html("元");
		$('#description').attr("disabled","");
		$('#description').val("部门主管的费用");
		$('#description').attr("title","");
	}else if(obj.value=="meetingServiceType"){//会议服务类型
		$('#dicViewName').attr("value","特类会");
		$('#spanTitle').html("会议服务类型--数值处请输入整数");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","1");
		$('#dicValue').attr("title","请输入整数");
		$('#spanValue').html("数值不能重复");
		$('#description').attr("disabled","");
		$('#description').val("标准配置：茶水、矿泉水、速溶咖啡、研磨咖啡、签约物品；人员服务：迎宾服务、专递服务、签约礼仪、续水、更换矿泉水、咖啡续杯。");
		$('#description').attr("title","");
	}else if(obj.value=="meetLable"){//会议标签
		$('#dicViewName').attr("value","培训");
		$('#spanTitle').html("会议标签--数值处请输入数字");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","1");
		$('#dicValue').attr("title","请输入数字");
		$('#spanValue').html("数值不能重复");
		$('#description').attr("disabled","");
		$('#description').val("培训");
		$('#description').attr("title","");
	}else if(obj.value=="equipmentStatus"){//会场记录-记录项状态
		$('#dicViewName').attr("value","正常");
		$('#spanTitle').html("会场记录-记录项状态--正常/网络故障");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","1");
		$('#dicValue').attr("title","请输入数字");
		$('#spanValue').html("数值不能重复");
		$('#description').attr("disabled","");
		$('#description').val("会场维护~设备状态");
		$('#description').attr("title","");
	}else if(obj.value=="equipmentType"){//会场记录-记录项
		$('#dicViewName').attr("value","音频设备");
		$('#spanTitle').html("会场记录-记录项--音频设备/视频设备/终端设备");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","1");
		$('#dicValue').attr("title","请输入整数");
		$('#spanValue').html("数值不能重复");
		$('#description').attr("disabled","");
		$('#description').val("会场维护~设备类型");
		$('#description').attr("title","");
	}else if(obj.value=="meetingDebugDuration"){//调试会议时长
		$('#dicViewName').attr("value","半小时");
		$('#spanTitle').html("调试会议时长单位为小时--例如：半小时，数值填入0.5");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","0.5");
		$('#dicValue').attr("title","请输入数字");
		$('#spanValue').html("小时");
		$('#description').attr("disabled","");
		$('#description').val("调试会议时长(系统配置)");
		$('#description').attr("title","");
	}else if(obj.value=="pollTimeSpan"){//轮询间隔时间
		$('#dicViewName').attr("value","5秒");
		$('#spanTitle').html("轮询间隔单位为秒");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","5");
		$('#dicValue').attr("title","请输入数字");
		$('#spanValue').html("秒");
		$('#description').attr("disabled","");
		$('#description').val("轮询间隔(会议控制-定制轮询)");
		$('#description').attr("title","");
	}else if(obj.value=="maintenanceStartTime"){//设备维保期限
		$('#dicViewName').attr("value","1年");
		$('#spanTitle').html("设备维保期限单位为月--例如：一年为12个月");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","12");
		$('#dicValue').attr("title","请输入数据名称对应的数值");
		$('#spanValue').html("月");
		$('#description').attr("disabled","");
		$('#description').val("设备维保期限");
		$('#description').attr("title","");
	}else if(obj.value=="applyFlow"){//流程类型
		$('#dicViewName').attr("value","本地会议预约申请");
		$('#spanTitle').html("流程类型--数值处请输入整数");
		$('#dicValue').attr("disabled","");
		$('#dicValue').attr("value","6");
		$('#dicValue').attr("title","请输入整数");
		$('#spanValue').html("数值不能重复");
		$('#description').attr("disabled","");
		$('#description').val("系统管理-流程管理-增加流程中的流程类型。");
		$('#description').attr("title","");
	}
}