<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  	<%@include file="/common/common.jsp"%>
    <title>My JSP 'hy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <div class="czdiv_top">
	<div id="basicform" class="contentwrapper czdiv_top">    
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td width="10%" class="tableaddtitle">会议选择</td>
              	<td class="tableadd_data" >
                	<span class="field" style="float:left">
                        <select name="selection" id="selection2">
                            <option value="" selected="selected">年终汇报会</option>
                            <option value="1">全体会议</option>
                            <option value="1">全体会议</option>
                        </select>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间：&nbsp;&nbsp;9:40
                    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间：&nbsp;&nbsp;12:40  
					</span>
                                     
				<span onclick="maximizition()" class="maxSpan" id="maxSpan" title="最大化"><img height="20px" style="cursor:pinter" src="${sys_ctx }/images/sf.png" id="maxW"/></span></td>
			</tr>
		</table>
	</div>   
    <div id="contentwrapper" class="contentwrapper czdiv_top">
		<table width="99%" border="0" cellpadding="0" cellspacing="0" class="stdtable" id="table4">
			<tbody>
				<tr class="gradeA">
					<td>
                    	<div class="czdiv">
                            <ul class="czdiv_1 czdived" style="width:38%">
                                <h3>会议控制</h3>
                                <li><a href="#" title="开始轮询"><span class="czdiv_kslx"></span></a></li>
                                <li><a href="#" title="播放轮询"><span class="czdiv_bflx"></span></a></li>
                                <li><a href="#" title="修改轮询"><span class="czdiv_xglx"></span></a></li>
                                <li><a href="#" title="结束轮询"><span class="czdiv_jslx"></span></a></li>                                    
                                <li><a href="#" title="暂停轮询"><span class="czdiv_ztlx"></span></a></li>
                                <li><a href="#" title="字幕"><span class="czdiv_zm"></span></a></li>
                                <li><a href="#" title="分屏"><span class="czdiv_fp"></span></a></li>                                
                                <li><a href="#" title="预监"><span class="czdiv_yj"></span></a></li>   
                                <li><a href="#" title="继续录制"><span class="czdiv_jxlz"></span></a></li> 
                                <li><a href="#" title="结束录制"><span class="czdiv_jslz"></span></a></li> 
                                <li><a href="#" title="开始录制"><span class="czdiv_kslz"></span></a></li> 
                                <li><a href="#" title="暂停录制"><span class="czdiv_ztlz"></span></a></li> 
                            </ul>
                             <ul class="czdiv_2 czdived" style="width:26%">
                                <h3>会议控制</h3>
                                <li><a href="#" title="连接"><span class="czdiv_lj"></span></a></li>
                                <li><a href="#" title="取消静音"><span class="czdiv_jy"></span></a></li>
                                <li><a href="#" title="取消闭音"><span class="czdiv_qxby"></span></a></li>       
                                <li><a href="#" title="取消禁屏"><span class="czdiv_qxbs"></span></a></li>
                                <li><a href="#" title="挂断"><span class="czdiv_dk"></span></a></li>
                                <li><a href="#" title="静音"><span class="czdiv_qxjy"></span></a></li>
                                <li><a href="#" title="闭音"><span class="czdiv_by"></span></a></li>
                                <li><a href="#" title="禁屏"><span class="czdiv_bs"></span></a></li>                                
                            </ul>
                             <ul class="czdiv_3 czdived" style="width:13%">
                                <h3>会议控制</h3>
                                <li><a href="#" title="添加会场"><span class="czdiv_tjhc"></span></a></li>
                                <li><a href="#" title="删除会场"><span class="czdiv_schc"></span></a></li>
                            </ul>
                            <ul class="czdiv_4 czdived" style="width:13%">
                                <h3>会议控制</h3>
                                <li><a href="#" title="MCU备份"><span class="czdiv_mcubf"></span></a></li>
                                <li><a href="#" title="应急处理"><span class="czdiv_yjcl"></span></a></li>
                            </ul>
                            <ul class="czdiv_5" style="width:8%;float:left">
                                <h3>会议控制</h3>
                                <li><a href="#" title="结束会议"><span class="czdiv_jshy"></span></a></li>
                                <li><a href="#" title="延时会议"><span class="czdiv_yshy"></span></a></li> 
                            </ul>
                        </div>
					</td>
				</tr>
			</tbody>
		</table>
		
		<table width="99%" border="0" cellpadding="0" cellspacing="0" id="table3" style="margin-bottom:0px; margin-top:3px;">
          <tbody>
            <tr>
              <td style="font-size:14px;text-align:left">会场统计：当前连接终端 <span style="color:red" id="meetingRoomCount">${meetingRoomCount }</span> 个
              		&nbsp;&nbsp;<span id="errorMessageId"></span>
               </td>
                <td align="right">		
              <span style=" float:right; font-size:14px">搜索：<input style="font:14px" id="datepicker" type="text" class="searwidth100" onkeyup="serachRoom(this)" onclick="clearInput(this)" value="请输入关键字"/></span>
              </td>
             
            </tr>
          </tbody>
        </table>
        <table width="100%" cellpadding="0" cellspacing="0" border="0" class="stdtablemeet" id="query_table_nosearch" >
            <thead>
                <tr>
                    <th width="50" class="meetinghead"><input type="checkbox" name="checkbox2" id="checkAll" onclick="checkall(document.myform.room)" class="checkbox1" style="background:none;border:none"/></th>
                    <th width="%" class="meetinghead">会场名</th>
                    <th width="%" class="meetinghead">IP</th>
                    <th width="%" class="meetinghead">连接状态</th>
                    <th width="%" class="meetinghead">音频状态</th>
                    <th width="%" class="meetinghead">视频状态</th>
                    <th width="%" class="meetinghead">角色</th>
                    <th width="%" class="meetinghead">丢包率</th>
                    <th width="%" class="meetinghead">呼叫方向</th>
                    <th width="%" class="meetinghead">所属MCU</th>
                    <th width="%" class="meetinghead">预监</th>
                </tr>
            </thead>
            <tbody>
				<tr id="room_${meetingRoom.meetingMCUKeyID}" onmousemove="onchangActionTr('${meetingRoom.meetingMCUKeyID}');">
					<td class="head1">
						<input type="checkbox" name="room" id="room_${meetingRoom.meetingMCUKeyID}_checkbox" value="${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"/>
					</td>
					<td>12云南销售公司</td>
                    <td>10.33.50.26</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>	
				<tr id="room_${meetingRoom.meetingMCUKeyID}" onmousemove="onchangActionTr('${meetingRoom.meetingMCUKeyID}');">
					<td class="head1">
						<input type="checkbox" name="room" id="room_${meetingRoom.meetingMCUKeyID}_checkbox" value="${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"/>
					</td>
					<td>1云南销售公司</td>
                    <td>10.33.50.16</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>			
			</tbody>
		</table>
    </div> 
</div>   	
  </body>
</html>






