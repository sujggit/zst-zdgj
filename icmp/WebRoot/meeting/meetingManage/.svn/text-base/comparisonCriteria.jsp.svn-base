<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO" %>
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
			    
				obj.title("SGapCriteria_Good","请输入正确的标准格式");	
				obj.title("SGapCriteria_Ok","请输入正确的标准格式");
				obj.title("SGapCriteria_Bad","请输入正确的标准格式");	
				obj.title("IndexGapCriteria_Good","请输入正确的标准格式");
				obj.title("IndexGapCriteria_Ok","请输入正确的标准格式");
				obj.title("IndexGapCriteria_Bad","请输入正确的标准格式");
				obj.title("x_max","请输入0-256内的数字");
				obj.title("x_min","请输入0-256内的数字");
				obj.title("description","输入需100字符以内");
			}

			/**
			*	
			*@return	null		*/
			
               function compareCriteriaModify(){
               
            	   var validator = $("#compareCriteria").validate({
						rules: {
							"comparisonCriteriaVO.SGapCriteria_Ok":{
								required: true,
								digits:true,
								
								max:100000000
				           		},
				           		
							"comparisonCriteriaVO.SGapCriteria_Good": {
								required: true,
								digits:true,
								
								max:100000000,
				           		
								},
							"comparisonCriteriaVO.SGapCriteria_Bad":    {
								required: true,
								digits:true,
							
								max:100000000
				           		//passwdChk: true
				           		},
				           		"comparisonCriteriaVO.IndexGapCriteria_Good":    {
									required: true,
									digits:true,
								
									max:100000000
					           		//passwdChk: true
					           		},
					           		"comparisonCriteriaVO.x_max":    {
										required: true,
										digits:true,
									
										max:256
						           		
						           		},
						           		"comparisonCriteriaVO.x_min":    {
											required: true,
											digits:true,
										
											max:256
							           		
							           		},
					           "comparisonCriteriaVO.IndexGapCriteria_Ok":    {
										required: true,
										digits:true,
									
										max:100000000
						           	
						           		},
						           	  "comparisonCriteriaVO.description":    {
											
							           		maxlength:100
							           	
							           		},
							"comparisonCriteriaVO.IndexGapCriteria_Bad":   {
								required: true,
								digits:true,					
								max:100000000,
				           	
				           		}
					  	},
					  	
					});
            	   var max= $("#x_max").val();
                   var min= $("#x_min").val();
                  
                   if(max<min||max==min){
                    	 $("#error")[0].style.display='block';
                         
                      return ;
                         }
                   
                $("#compareCriteria").submit();
             }
        
       
    	</script>
    	<%
    	ComparisonCriteriaVO comparisonCriteriaVO=(ComparisonCriteriaVO)request.getAttribute("comparisonCriteriaVO");
    	%>
	</head>


	<body  style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN' onload="pageInit();">
		<form
			action="${sys_ctx}/videoCardCompare/compareCriteriaModify.action"
			id="compareCriteria" name="compareCriteria" method="post">
			
     <input type="hidden" name="comparisonCriteriaVO.comCriteriaID" value="<%=comparisonCriteriaVO.getComCriteriaID() %>"/>
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						比对卡修改 
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td class="tableaddtitle">
							<span>*</span>好的面积差值标准
						</td>
						
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.SGapCriteria_Good" id="SGapCriteria_Good"
								class="inputtran" value="<%=comparisonCriteriaVO.getSGapCriteria_Good() %>" />
						</td>
							

						<td class="tableaddtitle">
							<span>*</span>一般的面积差值标准
						</td>
						<td class="tableadd_data">
						<input type="text" name="comparisonCriteriaVO.SGapCriteria_Ok" id="SGapCriteria_Ok"
								class="inputtran" value="<%=comparisonCriteriaVO.getSGapCriteria_Ok() %>" />
						</td>
						
						
					</tr>

<tr>
						<td class="tableaddtitle">
							<span>*</span>差的面积差标准
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.SGapCriteria_Bad" id="SGapCriteria_Bad"
								class="inputtran" value="<%=comparisonCriteriaVO.getSGapCriteria_Bad() %>" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>好的最大值下标标准
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.IndexGapCriteria_Good" id="IndexGapCriteria_Good"
								class="inputtran" value="<%=comparisonCriteriaVO.getIndexGapCriteria_Good() %>" />

						</td>
					</tr>

<tr>
						<td class="tableaddtitle">
							<span>*</span>一般的最大值下标标准
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.IndexGapCriteria_Ok" id="IndexGapCriteria_Ok"
								class="inputtran" value="<%=comparisonCriteriaVO.getIndexGapCriteria_Ok() %>" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>差的最大值下标标准
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.IndexGapCriteria_Bad" id="IndexGapCriteria_Bad"
								class="inputtran" value="<%=comparisonCriteriaVO.getIndexGapCriteria_Bad() %>" />

						</td>
					</tr>

<tr>
						<td class="tableaddtitle">
							<span>*</span>有效x轴最小值
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.x_min" id="x_min"
								class="inputtran" value="<%=comparisonCriteriaVO.getX_min() %>" />
								<span style="color:red;display:none;font-size:12px;float:right" id="error">最小值必须小于最大值</span>

						</td>
						<td class="tableaddtitle">
							<span>*</span>有效x轴最大值
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonCriteriaVO.x_max" id="x_max"
								class="inputtran" value="<%=comparisonCriteriaVO.getX_max() %>" />

						</td>
					</tr>


					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>描述：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonCriteriaVO.description" id="description" cols="5" style="width:90%"><%=comparisonCriteriaVO.getDescription() %></textarea>
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