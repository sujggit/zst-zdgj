<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.DictionaryEnum"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>
 <%
											DictionaryVO dictionaryVO = new DictionaryVO();
											dictionaryVO.setDicType(DictionaryEnum.CONTROLMENU);
											Set unitNames = new LinkedHashSet();
											List dList = ServiceFactory.getDictionaryService().query(
													dictionaryVO, null);
											String ifStr = "";
											for (int i = 0; i < dList.size(); i++) {
												DictionaryVO dv = (DictionaryVO) dList.get(i);
												unitNames.add(dv.getDescription());
												ifStr += dv.getDescription() + "-" + dv.getDicValue() + ",";
											}

											Iterator strs = unitNames.iterator();
											int tempi = 1;
											while (strs.hasNext()) {

												String str = (String) strs.next();
												String classname = "czdived";
												String div_5 = "";
												if (tempi++ == unitNames.size()) {
													classname = "czdiv_5";
													div_5 = "float:left;";
												}
												int width = Integer.parseInt(str.split("~")[1]);
												String strZname = str.split("~")[0];
										%>
										<ul class="<%=classname%>" style="<%=div_5%>width:<%=width%>px">
											<h3><%=strZname%></h3>
											<%
												if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_POLLSTART_ID + ",")) {
											%>
											<li id="pollStart">
												<a id="polla" onclick="startPolling1()" title="<%=DictionaryEnum.CONTROLMENU_POLLSTART_NAME %>"><span
													class="czdiv_kslx"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_POLLSDEFINED_ID + ",")) {
											%>
											<li id="pollmodify">
												<a id="moypolla" onclick="beforeModifyPoll()" title="<%=DictionaryEnum.CONTROLMENU_POLLSDEFINED_NAME %>"><span
													class="czdiv_xglx"></span>
												</a>
											</li>
											<%
												}
												if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_POLLSUSPEND_ID + ",")) {
											%>
											<li id="pollSuspend">
												<a id="suspolla" onclick="stopPoll1()" title="<%=DictionaryEnum.CONTROLMENU_POLLSUSPEND_NAME %>"><span
													class="czdiv_jslx"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_YUJIAN_ID + ",")) {
											%>
											<li>
												<a onclick="openyj()" title="<%=DictionaryEnum.CONTROLMENU_YUJIAN_NAME %>"><span class="czdiv_yj"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_JLD_ID + ",")) {
											%>
											<li>
												<a onclick="openmcujl()" title="<%=DictionaryEnum.CONTROLMENU_JLD_NAME %>"><span class="czdiv_yj"></span>
												</a>
											</li>
											<%
												}
													
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_SUBTITLE_ID + ",")) {
											%>
											<li>
												<a onclick="getMessageOverlay();" title="<%=DictionaryEnum.CONTROLMENU_SUBTITLE_NAME %>"><span
													class="czdiv_zm"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_SCREENMODEL_ID + ",")) {
											%><li>
												<a onclick="screenModel()" title="<%=DictionaryEnum.CONTROLMENU_SCREENMODEL_NAME %>"><span
													class="czdiv_fp"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_CONNECT_ID + ",")) {
											%>
											<li>
												<a onclick="dialParticipants('room', 'true')" title="<%=DictionaryEnum.CONTROLMENU_CONNECT_NAME %>"><span
													class="czdiv_lj"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_DISCONNECT_ID + ",")) {
											%>
											<li>
												<a onclick="dialParticipants('room', 'false')" title="<%=DictionaryEnum.CONTROLMENU_DISCONNECT_NAME %>"><span
													class="czdiv_dk"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_MUTE_ID + ",")) {
											%>
											<li>
												<a onclick="muteParticipants('room', 'true')" title="<%=DictionaryEnum.CONTROLMENU_MUTE_NAME %>"><span
													class="czdiv_qxjy"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_UNMUTE_ID + ",")) {
											%>
											<li>
												<a onclick="muteParticipants('room', 'false')" title="<%=DictionaryEnum.CONTROLMENU_UNMUTE_NAME %>"><span
													class="czdiv_jy"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_BLOCKAUDIO_ID + ",")) {
											%>
											<li>
												<a onclick="blockParticipants2('room', 'true')" title="<%=DictionaryEnum.CONTROLMENU_BLOCKAUDIO_NAME %>"><span
													class="czdiv_by"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_UNBLOCKAUDIO_ID + ",")) {
											%>
											<li>
												<a onclick="blockParticipants2('room', 'false')"
													title="<%=DictionaryEnum.CONTROLMENU_UNBLOCKAUDIO_NAME %>"><span class="czdiv_qxby"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_SUSPENDVIDEO_ID + ",")) {
											%>
											<li>
												<a onclick="suspendParticipants2('room', 'true')"
													title="<%=DictionaryEnum.CONTROLMENU_SUSPENDVIDEO_NAME %>"><span class="czdiv_bs"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_UNSUSPENDVIDEO_ID + ",")) {
											%>
											<li>
												<a onclick="suspendParticipants2('room', 'false')" 
													title="<%=DictionaryEnum.CONTROLMENU_UNSUSPENDVIDEO_NAME %>" ><span class="czdiv_qxbs"></span>
												</a>
											</li>
											<%
												}
													
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_CREATROOM_ID + ",")) {
											%>
											<li>
												<a onclick="createMeetingRoomList(this)" title="<%=DictionaryEnum.CONTROLMENU_CREATROOM_NAME %>"><span
													class="czdiv_tjhc"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_DELROOM_ID + ",")) {
											%>
											<li>
												<a onclick="delParticipants('room');" title="<%=DictionaryEnum.CONTROLMENU_DELROOM_NAME %>"><span
													class="czdiv_schc"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_BEIFEN_ID + ",")) {
											%>
											<li>
												<a onclick="openmcubk();" title="<%=DictionaryEnum.CONTROLMENU_BEIFEN_NAME %>"><span
													class="czdiv_mcubf"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"
															+ DictionaryEnum.CONTROLMENU_TONGBU_ID + ",")) {
											%>
											<li>
												<a onclick="synConfsFromMcu();" title="<%=DictionaryEnum.CONTROLMENU_TONGBU_NAME %>"><span
													class="czdiv_yjcl"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"+ DictionaryEnum.CONTROLMENU_ENDCONFERENCE_ID + ",")) {
											%>
											<li>
												<a onclick="deleteConf('')" title="<%=DictionaryEnum.CONTROLMENU_ENDCONFERENCE_NAME %>"><span
													class="czdiv_jshy"></span>
												</a>
											</li>
											<%
												}
													if (ifStr.contains(str + "-"+ DictionaryEnum.CONTROLMENU_RECORDSTART_ID + ",")) {
													//开始录制
											%>
											<li id="recordNew">
						<a onclick="recordControl(1);" title="开始录制" <c:if test="${(confVO.recordingStatus!='stop')&&(confVO.recordingStatus!=null) }">style='display:none'</c:if>>
                   		 <span class="czdiv_kslz"></span></a>
                    	<a  onclick="recordControl(2);" title="暂停录制" <c:if test="${confVO.recordingStatus!='start' }">style='display:none'</c:if>>
                    	 <span class="czdiv_ztlz"></span></a>
                    	<a  onclick="recordControl(3);" title="继续录制" <c:if test="${confVO.recordingStatus!='pause' }">style='display:none'</c:if>>
                        <span class="czdiv_jxlz"></span></a>
											</li>
											<%
											
												}if (ifStr.contains(str + "-"+ DictionaryEnum.CONTROLMENU_RECORDEND_ID + ",")) {
												//结束录制
											%>
											<li>
												<a onclick="recordControl('stop');" title="<%=DictionaryEnum.CONTROLMENU_RECORDEND_NAME %>"><span
													class="czdiv_jslz"></span>
												</a>
											</li>
											<%
												}if (ifStr.contains(str + "-"+ DictionaryEnum.CONTROLMENU_DELAYCONFERENCE_ID + ",")) {
												//延时会议
											%>
											<li>
												<a onclick="viewDIV('delayMeetingTime');" title="<%=DictionaryEnum.CONTROLMENU_DELAYCONFERENCE_NAME %>"><span
													class="czdiv_yshy"></span>
												</a>
											</li>
											<%
												}
											%>
										</ul>

										<%
											}
										%>
 

										<!-- 
            		<li ><a onclick="screenModel()"><img src="${sys_ctx }/meeting/meetingManage/image/report/fp.png" align="absmiddle" /> 会议分屏</a></li>            		
            		<li id="pollStart"><a id="polla" onclick="startPolling1()"><img src="${sys_ctx }/meeting/meetingManage/image/report/lx.png" align="absmiddle" /> 轮询</a></li>            		
            		<li id="pollSuspend"><a id="suspolla" onclick="stopPoll1()"><img src="${sys_ctx }/meeting/meetingManage/image/report/ztlx.png" align="absmiddle" />停止轮询</a></li> 
            		<li id="pollmodify"><a id="moypolla" onclick="beforeModifyPoll()"><img src="${sys_ctx }/images/mcu/lx.png" align="absmiddle" /> 定制轮询</a></li>           	
            		<li><a  onclick="viewDIV('delayMeetingTime');"><img src="${sys_ctx }/meeting/meetingManage/image/report/yshy.png" align="absmiddle" /> 延时会议</a></li>            		          		
            		<li><a  onclick="getMessageOverlay();"><img src="${sys_ctx }/meeting/meetingManage/image/report/xszm.png" align="absmiddle" /> 显示字幕</a></li>
            		<li id="record">
            			<a onclick="recordControl(1);" <c:if test="${(confVO.recordingStatus!='stop')&&(confVO.recordingStatus!=null) }">style='display:none'</c:if>>
                   		<img src="${sys_ctx }/meeting/meetingManage/image/report/qxsppb.png" align="absmiddle" /> 开始录制</a>
                    	<a  onclick="recordControl(2);" <c:if test="${confVO.recordingStatus!='start' }">style='display:none'</c:if>>
                    	<img src="${sys_ctx }/meeting/meetingManage/image/report/sppb.png" align="absmiddle" /> 暂停录制</a>
                    	<a  onclick="recordControl(3);" <c:if test="${confVO.recordingStatus!='pause' }">style='display:none'</c:if>>
                    	<img src="${sys_ctx }/meeting/meetingManage/image/report/qxsppb.png" align="absmiddle" /> 继续录制</a>
                    </li>
                    <li><a  onclick=""><img src="${sys_ctx }/meeting/meetingManage/image/report/sppb.png" align="absmiddle" /> 结束录制</a></li>
                    <li><a  onclick="deleteConf('')"><img src="${sys_ctx }/meeting/meetingManage/image/report/jshy.png" align="absmiddle" /><span style="color:red"> 结束会议</span></a></li>
                   	<li><a onclick="dialParticipants('room', 'true')" ><img src="${sys_ctx }/meeting/meetingManage/image/report/lj.png" align="absmiddle" /> 连接</a></li>
                    <li><a  onclick="dialParticipants('room', 'false')"><img src="${sys_ctx }/meeting/meetingManage/image/report/gd.png" align="absmiddle" /> 挂断</a></li>
                    <li><a  onclick="muteParticipants('room', 'true')"><img src="${sys_ctx }/meeting/meetingManage/image/report/jy.png" align="absmiddle" /> 静音</a></li>
                    <li><a  onclick="muteParticipants('room', 'false')"><img src="${sys_ctx }/meeting/meetingManage/image/report/qxjy.png" align="absmiddle" /> 取消静音</a></li>
                   
                    <li><a  onclick="blockParticipants2('room', 'true')"><img src="${sys_ctx }/meeting/meetingManage/image/report/by.png" align="absmiddle" /> 闭音</a></li>
                    <li><a  onclick="blockParticipants2('room', 'false')"><img src="${sys_ctx }/meeting/meetingManage/image/report/qxby.png" align="absmiddle" /> 取消闭音</a></li>
                    <li><a  onclick="suspendParticipants2('room', 'true')"><img src="${sys_ctx }/meeting/meetingManage/image/report/bs.png" align="absmiddle" /> 闭视</a></li>
                    <li><a  onclick="suspendParticipants2('room', 'false')"><img src="${sys_ctx }/meeting/meetingManage/image/report/qxbs.png" align="absmiddle" /> 取消闭视</a></li>
					<li><a onclick="createMeetingRoomList(this)" ><img src="${sys_ctx }/meeting/meetingManage/image/report/tjhc.png" align="absmiddle" /> 添加会场</a></li>
                    <li><a  onclick="delParticipants('room');"><img src="${sys_ctx }/meeting/meetingManage/image/report/schc.png" align="absmiddle" /> 删除会场</a></li>
                    <li <c:if test="${confVO.lectureName!='[None]' or confVO.videoMode=='4' }">style="display:none"</c:if>><a  onclick="setPersonal('room');"><img src="${sys_ctx }/meeting/meetingManage/image/report/fp.png" align="absmiddle" /> 会场分屏</a></li>
            		<li><a  onclick="terminalBackup('room');"><img src="${sys_ctx }/meeting/meetingManage/image/report/bf.png" align="absmiddle" /> 终端备份 </a></li>
            		<li><a onclick="openyj()"><img src="${sys_ctx }/meeting/meetingManage/image/report/yj.png" align="absmiddle" /> 预监</a></li>
            		<li><a onclick="openmcubk()"><img src="${sys_ctx }/meeting/meetingManage/image/report/MCU.png" align="absmiddle" />MCU备份</a></li>
            		-->