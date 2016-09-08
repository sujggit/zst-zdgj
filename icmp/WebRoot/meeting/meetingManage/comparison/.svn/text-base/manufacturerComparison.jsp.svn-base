<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base target="_self" />
		<%@include file="/common/common.jsp"%>

		<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>	
		<script type="text/javascript">
	function toSubmit(){
    $("#pageform").submit();
		}

	function back(){
      window.location.href="${sys_ctx}/videoCardCompare/queryComparisonList.action";
		}

	function test(ip){
		
		ip = document.getElementById("ipID").value;
		var now=new Date();
		var number = now.getTime();
		McuDwrMethod.getBlowUp(ip, function(nameIP){
		if(ip != "" && ip != null && name!=""){
		
		document.getElementById("farview").src= "" +nameIP +"?"+number; 
		}else{
		document.getElementById("farview").src="${sys_ctx }/images/lineOut.png"; 
		
		}
		McuDwrMethod.getBlowDown(ip, function(nameIP1){
		document.getElementById("nearview").src= "" +nameIP1 +"?"+number; 
		})
		});
		
	}
	 </script>
	</head>
	<!-- body style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN'-->
	<body style='overflow:auto'>
		<form action="${sys_ctx}/videoCardCompare/mamufactruerComparison.action" id="pageform" name="pageform" method="post">
		<div class="contentwrapper">
			<input type="hidden" name="comparisonVO.compDetailID" value="${comparisonVO.compDetailID}"/>
			<input type="hidden" name="comparisonVO.ID" value="${comparisonVO.ID}"/>
			<div class="contenttitle2">
				<h5 class="fwb fl10">
					${meetingRoomVO.meetingRoomName }手工点名确认
				</h5>
			</div>
			<table width="100%" border="0" cellspacing="1" cellpadding="0"
				class="tableadd">
				<tr>
					<td width="15%" class="tableaddtitle">上行音频</td>

					<td width="35%" class="tableadd_data">
						<select name="comparisonVO.upAudioQuality" >
							<option value="6">好</option>
							<option value="5">中</option>
							<option value="4">差</option>
						</select>
					</td>

					<td width="15%" class="tableaddtitle">下行音频</td>
					<td width="35%" class="tableadd_data">
						<select name="comparisonVO.downAudioQuality">
							<option value="6">好</option>
							<option value="5">中</option>
							<option value="4">差</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tableaddtitle">上行视频</td>
					<td class="tableadd_data">
						<select name="comparisonVO.upVideoQuality">
							<option value="6">好</option>
							<option value="5">中</option>
							<option value="4">差</option>
						</select>
					</td>
					<td class="tableaddtitle">下行视频</td>
					<td class="tableadd_data">
						<select name="comparisonVO.downVideoQuality">
							<option value="6">好</option>
							<option value="5">中</option>
							<option value="4">差</option>
						</select>
					</td>
				</tr>

				<tr>
					<td class="tableaddtitle">结果</td>
					<td colspan="3" class="tableadd_data">
						<select name="comparisonVO.result">
							<option value="6">好</option>
							<option value="5">中</option>
							<option value="4">差</option>
						</select>
					</td>
				</tr>
				
			</table>
			<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
				<tfoot>
				</tfoot>
				<tbody>
					<tr>
						<td>
							<input type="button" class="submit1 radius2" value="确 定"  onclick="toSubmit();"/>

							<input type="button" class="reset1 radius2" value="取 消"
								onclick="back()" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</form>
		<form action="${sys_ctx}/videoCardCompare/mamufactruerComparison.action" id="pageform" name="pageform" method="post" style="margin-top:5px">
		<div class="contentwrapper"	>
			<div class="contenttitle2">
				<h5 class="fwb fl10">会场监测</h5>
			</div>
			<div class="dtree">
				<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="table">
              		<thead>
          				<tr>
            				<th width="50%" class="head1" style="text-align:center">会场近端:</th>
            				<th width="50%" class="head1" style="text-align:center">会场远端:</th>
          				</tr>
        			</thead>
                    <tbody>
                		<tr class="gradeA">
                 			<td align="center"><img id="nearview" src="${sys_ctx }/images/lineOut.png" height="187" width="220"></td>
                            <td align="center"><img id="farview" src="${sys_ctx }/images/lineOut.png" height="187" width="220"></td>
                		</tr>
              		</tbody>
            	</table>
			</div>
		</div>
		</form>
  <input type="hidden" id="ipID" value="${comparisonVO.description}"/>
  <!--  table width="236" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tr>
	    <td  colspan="2" class="mainTableTitle_hc"><font size="4">会场监测</font></td>
	  </tr>
	  <tr>
	    <td colspan="2" align="left">
		    <table width="99%" border="0" cellspacing="0" cellpadding="0">
		     
		      <tr>
		        <td  align="left" valign="top" class="marginData1">
		          	<span id="near"></span>会场近端： <span id="near"></span>
		          
		          </td>
		          <td   align="left" valign="top" class="marginData1">
		        	<span id="far"></span>会场远端： <span id="far"></span>
		        	</td>
		          </tr>
		          <td  align="left" valign="top" class="marginData1">
		          <img id="nearview" src="${sys_ctx }/images/lineOut.png" height="187" width="220">
		          </td>
		        <td  align="left" valign="top" class="marginData1">
		        <img id="farview" src="${sys_ctx }/images/lineOut.png" height="187" width="220">&nbsp;&nbsp;
		        </td>
		      
		    </table>
	    </td>
	    </tr>
	</table-->
	<script type="text/javascript">
		test('ip');
		window.setInterval("test('ip')", 10000);
		
</script>
	</body>
</html>