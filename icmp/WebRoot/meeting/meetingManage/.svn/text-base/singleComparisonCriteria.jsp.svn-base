<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page
	import="com.zzst.model.meeting.comparison.ComparisonReferenceVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<%@include file="/common/common.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript'
			src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
		<title>添加告示</title>
		<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null*/
			
            function backHistory(){
            	window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
            }

         
            function pageInit(){
			    var obj = new htmlUtil();
			    
				obj.title("rIndex","请输入正确的标准格式");	
				obj.title("gIndex","请输入正确的标准格式");
				obj.title("bIndex","请输入正确的标准格式");	
				obj.title("S_R","请输入正确的标准格式");
				obj.title("S_G","请输入正确的标准格式");
				obj.title("S_B","请输入正确的标准格式");
				

				obj.title("R_Pr","请输入1000以内字符");
				obj.title("G_Y","请输入1000以内字符");
				obj.title("B_Pb","请输入1000以内字符");
				
				obj.title("description","输入需100字符以内");
			}

			/**
			*	
			*@return	null		*/
			
               function compareCriteriaModify(){
               
            	   var validator = $("#compareCriteria").validate({
						rules: {
							"comparisonReferenceVO.rIndex":{
								required: true,
								digits:true,
								
								max:100000000
				           		},

				           		"comparisonReferenceVO.R_Pr":{
									required: true,							
					           	
					           		},
					           		"comparisonReferenceVO.G_Y":{
										required: true,										
						           		maxlength:2000
						           		},
						           		"comparisonReferenceVO.B_Pb":{
											required: true,											
							           		maxlength:2000
							           		},

				           		
							"comparisonReferenceVO.gIndex": {
								required: true,
								max:100000000,
								
				           		maxlength:25,
				           		
								},
							"comparisonReferenceVO.bIndex":    {
								required: true,
								digits:true,							
								max:100000000
				           		
				           		},
				           		"comparisonReferenceVO.S_R":    {
									required: true,
									digits:true,
								
									max:100000000
					           		
					           		},
					           "comparisonReferenceVO.S_G":    {
										required: true,
										digits:true,
									
										max:100000000
						           	
						           		},
						           	  "comparisonReferenceVO.S_B":    {
						           			required: true,
											digits:true,
										
											max:100000000
							           	
							           		}
					  	},
					  	
					});
				  
                $("#compareCriteria").submit();
             }
        
               
    	</script>
		<%
    	ComparisonReferenceVO comparisonReferenceVO=(ComparisonReferenceVO)request.getAttribute("comparisonReferenceVO");
    	%>
	</head>


	<body style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN' onload="pageInit();">
		<form
			action="${sys_ctx}/videoCardCompare/SingleCompareCriteriaModify.action"
			id="compareCriteria" name="compareCriteria" method="post">

			<input type="hidden" name="comparisonReferenceVO.ID"
				value="<%=comparisonReferenceVO.getID() %>" />
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						会场比对标准修改
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td class="tableaddtitle">
							<span>*</span>红色最大值下标
						</td>

						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.rIndex"
								id="rIndex" class="inputtran"
								value="<%=comparisonReferenceVO.getRIndex() %>" />
						</td>


						<td class="tableaddtitle">
							<span>*</span>绿色最大值下标
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.gIndex"
								id="gIndex" class="inputtran"
								value="<%=comparisonReferenceVO.getGIndex() %>" />
						</td>


					</tr>

					<tr>
						<td class="tableaddtitle">
							<span>*</span>蓝色最大值下标
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.bIndex"
								id="bIndex" class="inputtran"
								value="<%=comparisonReferenceVO.getBIndex() %>" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>红色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_R" id="S_R"
								class="inputtran" value="<%=comparisonReferenceVO.getS_R() %>" />

						</td>
					</tr>

					<tr>
						<td class="tableaddtitle">
							<span>*</span>绿色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_G" id="S_G"
								class="inputtran" value="<%=comparisonReferenceVO.getS_G() %>" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>蓝色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_B" id="S_B"
								class="inputtran" value="<%=comparisonReferenceVO.getS_B() %>" />

						</td>
					</tr>

<!-- 
					<tr>
						<td class="tableaddtitle">
							<span>*</span>有效x轴最小值
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.x_min" id="x_min"
								class="inputtran" value="" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>有效x轴最大值
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.x_max" id="x_max"
								class="inputtran" value="" />

						</td>
					</tr>
 -->

					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>组合256个红色值
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.R_Pr"
								id="R_Pr" cols="5" style="width: 90%"><%=comparisonReferenceVO.getR_Pr()%></textarea>
						</td>
					</tr>

					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>组合256个绿色值
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.G_Y"
								id="G_Y" cols="5" style="width: 90%"><%=comparisonReferenceVO.getG_Y()%></textarea>
						</td>
					</tr>

					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>组合256个蓝色值
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.B_Pb"
								id="B_Pb" cols="5" style="width: 90%"><%=comparisonReferenceVO.getB_Pb()%></textarea>
						</td>
					</tr>


					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>描述
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran"
								name="comparisonReferenceVO.description" id="description"
								cols="5" style="width: 90%"><%=comparisonReferenceVO.getDescription()%></textarea>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer"
					id="table">
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<td>
								<input type="button" class="submit1 radius2" value="确 定"
									onclick="compareCriteriaModify();" />

								<input type="button" class="reset1 radius2" value="取 消"
									onclick="backHistory();" />
							</td>
						</tr>
					</tbody>
				</table>
				<!--contenttitle-->
			</div>
		</form>
	</body>
</html>