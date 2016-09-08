<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
	<head>
		<%@include file="/common/common.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>配置列表管理</title>
		<script type="text/javascript">
		
		function delBaseInfo(id){
			
			if(!confirm("确定要删除吗？")){
				return;
			}	
			location.href="${sys_ctx }/baseInfo/delBaseInfo.action?baseInfoVO.id="+id;
		}
		
	
	function configurationDetail(id){
		window.showModalDialog("${sys_ctx }/baseInfo/configurationDetail.action?baseInfoVO.id="+id,window,'dialogWidth=600px;dialogHeight=470px;');
	                               }
						
	function modify(id){
	                      var url="${sys_ctx }/baseInfo/configurationQueryById.action?baseInfoVO.id="+id;
	                        location.href=url;
				            //window.location.href="${sys_ctx }/baseInfo/configurationQueryById.action?baseInfoVO.id="+id;
				       }
	
	
	 function add(){
window.location.href="${sys_ctx }/meeting/config/configurationAdd.jsp";
                   }
 function exportList(){
 var infoType=document.getElementById("infoType").value;
  window.location.href="${sys_ctx }/baseInfo/baseInfoexportQuery.action?baseInfoVO.infoType="+infoType;
                      }
</script>
	</head>

	<body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
		<form action="${sys_ctx }/baseInfo/queryBaseInfoList.action" id="pageform" name="pageform" method="post">
			<div id="contentwrapper" class="contentwrapper">
				<div id="basicform" class="contentwrapper">

					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="tableadd">
						<tr>
							<td width="15%" class="tableaddtitle">
								配置类型
							</td>
							<td class="tableadd_data">
								<select onchange="queryForm();" name="baseInfoVO.infoType"
									id="infoType" title="请选择" class="select200 fontstyle"
									style="cursor: pointer">
									<option value="">请选择</option>
									<zzst:option type="baseInfoType" value="${baseInfoVO.infoType}"
										required="true" />
								</select>
								
							</td>

						</tr>
					</table>
					<div class="widgetcontent">
        <div class="msgmore" onclick="disquery()"><a href="javascript:void(0);" ><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0"  />         
        </a>
        </div>

                  </div>
					<div class="contenttitle2">
						<h5 class="fwb fl10">
							查询列表
						</h5>
						<h5 class="fwb fr10">
							<!--<a onclick="add();">增加 </a>|-->
							<a onclick="exportList();"> 导出</a>
						</h5>
					</div>
					
     
     
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
						id="query_table">
						<thead>
							<tr>
								<th width="8%" class="head1">
									序号
								</th>
								<th width="15%" class="head1">
									配置类型
								</th>
								<th width="29%" class="head1">
									配置名称
								</th>
								<th width="19%" class="head1">
									配置内容
								</th>
								<th width="15%" class="head1">
									描述
								</th>
								<th width="14%" class="head1">
									操作
								</th>
							</tr>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<c:forEach items="${baseInfoList}" var="baseInfoVO"
								varStatus="state">
								<tr>
									<td class="alc">
										<c:out value="${state.index+1}"></c:out>
									</td>

									<td>									
									 <zzst:lable type="baseInfoType" value="${baseInfoVO.infoType}"></zzst:lable>				
									</td>

									<!--  <td class="ac fontstyle ">&nbsp;<c:out value="${baseInfo.infoType}"/></td>-->
									<td>
										&nbsp;
										<c:out value="${baseInfoVO.infoName}" />
									</td>
									<td>
										&nbsp;
										<c:out value="${baseInfoVO.infoValue}" />
									</td>
									<td>
										&nbsp;
										<c:out value="${baseInfoVO.description}" />
									</td>
									<td class="alc">
										
				                        <a style="cursor: pointer;"
											onclick="javascript:configurationDetail('${baseInfoVO.id}')" />查看|
										<a style="cursor: pointer;"
											onclick="javascript:modify('${baseInfoVO.id}')" />修改 
										
										<!--<a style="cursor: pointer;"
											onclick="javascript:delBaseInfo('${baseInfoVO.id}')" />删除-->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<jsp:include page="/common/pageFooter.jsp" />

					<!--contenttitle-->
				</div>
			</div>
		</form>
	</body>
</html>
