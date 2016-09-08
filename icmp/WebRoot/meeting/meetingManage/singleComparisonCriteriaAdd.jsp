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
				
				obj.title("meetingRoomID","请选择会场");

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
					           		"comparisonReferenceVO.meetingRoomID":{
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
								digits:true,
								
								max:100000000
				           		
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
							          /** 		"comparisonReferenceVO.x_max":    {
							           			required: true,
												digits:true,
											
												max:100000000
								           	
								           		},
							"comparisonReferenceVO.x_min":   {
								required: true,
								digits:true,					
								max:100000000
				           	
				           		}*/
					  	},
					  	
					});
				  
                $("#compareCriteria").submit();
             }
        
               
    	</script>
		
	</head>


	<body style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN' onload="pageInit();">
		<form
			action="${sys_ctx}/videoCardCompare/SingleCompareCriteriaAdd.action"
			id="compareCriteria" name="compareCriteria" method="post">
			<div id="basicform" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						会场比对标准修改
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					
					<tr>
					<td class="tableaddtitle">会场：</td>
					
					<td class="tableadd_data" colspan="3">
					<input name="comparisonReferenceVO.meetingRoomID" id="meetingRoomID" type="hidden" value="${meetingDetailVO.meetingRoomID }"/>
               		<input  name="comparisonReferenceVO.meetingRoomName" value="${meetingDetailVO.meetingRoomName }" style="cursor:pointer" readonly="readonly" onclick="javascript:selectConference(this)" class="inputtran"  id="meetingRoomName" type="text"/>
                
                <script type="text/javascript">
                    function selectConference(thisDom){
                          var selectedConference = document.getElementById("meetingRoomID").value;
			              var conferenceParameters = {
			                  methodName:'getReturnConferenceMethod',
			                  selectedConference:selectedConference,
			                  selectType:'radio'
			              }
			             creatConferenceSelect(thisDom,conferenceParameters); 
			          }
			          //返回方法
			          //用于获取返回参数
			          //返回参数为数组类型
			          //用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
			          //以提供的参数：conferenceID,conferenceName
			          
			          function getReturnConferenceMethod(conferenceArray){
			              //alert(userArray);
			              var conferenceName = "";
			              var conferenceID = "";
			              var length = conferenceArray.length;
			              for(var i=0;i<length;i++){
			                      conferenceName =conferenceName+conferenceArray[i].conferenceName;
			                      conferenceID = conferenceID+conferenceArray[i].conferenceID;
			              }
			              document.getElementById("meetingRoomName").value=conferenceName;
			              document.getElementById("meetingRoomID").value=conferenceID;
			
			             // DwrMethod.getMcuTemplateByMeetingRoomID(conferenceID,getTemplateCallBack);
			          }
			          
			         //// function getTemplateCallBack( result ){
	 	    		//	document.getElementById('mySelect_02').innerHTML='<select name="meetingDetailVO.confProfileID" id="model" class="select200 fontstyle" >'+ result+'</select>';
	 			    // }
                </script>
					</td>
					</tr>
					
					
					
					<tr>
						<td class="tableaddtitle">
							<span>*</span>红色最大值下标
						</td>

						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.rIndex"
								id="rIndex" class="inputtran"
								value="" />
						</td>


						<td class="tableaddtitle">
							<span>*</span>绿色最大值下标
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.gIndex"
								id="gIndex" class="inputtran"
								value="" />
						</td>


					</tr>

					<tr>
						<td class="tableaddtitle">
							<span>*</span>蓝色最大值下标
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.bIndex"
								id="bIndex" class="inputtran"
								value="" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>红色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_R" id="S_R"
								class="inputtran" value="" />

						</td>
					</tr>

					<tr>
						<td class="tableaddtitle">
							<span>*</span>绿色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_G" id="S_G"
								class="inputtran" value="" />

						</td>
						<td class="tableaddtitle">
							<span>*</span>蓝色有效面积
						</td>
						<td class="tableadd_data">
							<input type="text" name="comparisonReferenceVO.S_B" id="S_B"
								class="inputtran" value="" />

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
							<span></span>组合256个红色值：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.R_Pr"
								id="R_Pr" cols="5" style="width: 90%"></textarea>
						</td>
					</tr>

					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>组合256个绿色值：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.G_Y"
								id="G_Y" cols="5" style="width: 90%"></textarea>
						</td>
					</tr>

					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>组合256个蓝色值：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran" name="comparisonReferenceVO.B_Pb"
								id="B_Pb" cols="5" style="width: 90%"></textarea>
						</td>
					</tr>


					<tr>
						<td class="tableaddtitle" style="vertical-align: top;">
							<span></span>描述：
						</td>
						<td class="tableadd_data" colspan="3">
							<textarea class="areatran"
								name="comparisonReferenceVO.description" id="description"
								cols="5" style="width: 90%"></textarea>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
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