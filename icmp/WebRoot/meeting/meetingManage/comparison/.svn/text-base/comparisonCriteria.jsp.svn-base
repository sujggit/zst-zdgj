<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.comparison.ComparisonCriteriaVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<%@include file="/common/common.jsp"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript'
			src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
		<title>添加告示</title>
		<%
		
		%>
		<script type="text/javascript">
		
            
            /**
			*	返回列表
			*@return	null*/
			
            function backHistory(){
            	window.location.href = "${sys_ctx }/layout/inc1/welcom.jsp";
            }

         
            function pageInit(){
			    var obj = new htmlUtil();
			    
				obj.title("rsGap_Good_lower","请输入正确的标准格式");	
				obj.title("rsGap_Good_upper","请输入正确的标准格式");
				obj.title("rsGap_Ok_lower","请输入正确的标准格式");	
				obj.title("rsGap_Ok_upper","请输入正确的标准格式");
				obj.title("gsGap_Good_lower","请输入正确的标准格式");
				obj.title("gsGap_Good_upper","请输入正确的标准格式");

				obj.title("gsGap_Ok_lower","请输入正确的标准格式");
				obj.title("gsGap_Ok_upper","请输入正确的标准格式");


				obj.title("bsGap_Good_lower","请输入正确的标准格式");
				obj.title("bsGap_Good_upper","请输入正确的标准格式");
				obj.title("bsGap_Ok_lower","请输入正确的标准格式");
				obj.title("bsGap_Ok_upper","请输入正确的标准格式");
				
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
							"comparisonCriteriaVO.rsGap_Good_lower":{
								required: true,
								number:true,	
								min:-100,							
								max:100
				           		},
				         
					  
				  		
						"comparisonCriteriaVO.rsGap_Good_upper": {
							required: true,
							number:true,
							
							max:100
			           		
							},
						"comparisonCriteriaVO.rsGap_Ok_lower":    {
							required: true,
							number:true,
						
							max:100
							},
			           		"comparisonCriteriaVO.rsGap_Ok_upper":    {
								required: true,
								number:true,
							
								max:100
				           	
				           		},


				           	
				    	"comparisonCriteriaVO.gsGap_Good_lower":{
									required: true,
									number:true,
									
									max:100
					           		},
					           		
								"comparisonCriteriaVO.gsGap_Good_upper": {
									required: true,
									number:true,
									
									max:100
					           		
									},
								"comparisonCriteriaVO.gsGap_Ok_lower":    {
									required: true,
									number:true,
								
									max:100
					           		
					           		},
					           		"comparisonCriteriaVO.gsGap_Ok_upper":    {
										required: true,
										number:true,
									
										max:100
						           	
						           		},
						           		"comparisonCriteriaVO.bsGap_Good_lower":{
											required: true,
											number:true,
											
											max:100
							           		},
							           		
										"comparisonCriteriaVO.bsGap_Good_upper": {
											required: true,
											number:true,
											
											max:100
							           		
											},
										"comparisonCriteriaVO.bsGap_Ok_lower": {
											required: true,
											number:true,
										
											max:100
							           		
							           		},
							           		"comparisonCriteriaVO.bsGap_Ok_upper":{
												required: true,
												number:true,
											
												max:100
								           		
								           		},
								           	


				           		
				           		"comparisonCriteriaVO.x_max":    {
									required: true,
									number:true,
									 min:0,
									max:256
					           		
					           		},
					           		"comparisonCriteriaVO.x_min":    {
										required: true,
										number:true,
									    min:0,
										max:256
						           		
						           		},
				          
					           	  "comparisonCriteriaVO.description":  {
										
						           		maxlength:100,
						           	
						           		}
            	   }
						
					  	
					});
            	   var max= $("#x_max").val();
                   var min= $("#x_min").val();
                 var ma= parseInt(max);
                  var mi=parseInt(min);
                   if(ma<mi||ma==mi){
                    	 //$("#error")[0].style.display='block';
                         alert("下界不能大于上界");
                      return ;
                         }
                   
                $("#compareCriteria").submit();
             }
        
           function setRGoodLower(){
        	   //var rl= $("#rsGap_Good_lower").val();
        	    var rgl=$("#rsGap_Good_lower").val();
        	    var rgu= $("#rsGap_Good_upper").val();
        	    var l=parseInt(rgl);
        	    var u=parseInt(rgu);
        	   if(l>u){
            	  
            	   document.getElementById("rgoodlower").value=rgl;
            	   //$("#rsGap_Good_lower").focus();
            	       alert("下界不能大于上界");    	  
            	   if( $("#rsGap_Good_upper").focus()){
            		   $("#rsGap_Good_upper").focus();
            		}else{   
            			           			 
            			 $("#rsGap_Good_lower").focus();
            		}
            		     
            	  
        	   return ;
        	   
        		   }
        	   document.getElementById("rgoodlower").value=rgl;
               }
           function setRGoodUpper(){
        	   var rgu=$("#rsGap_Good_upper").val();
        	   var rgl=$("#rsGap_Good_lower").val();
        	   var l=parseInt(rgl);
       	       var u=parseInt(rgu);
       	   if(l>u){
       		 alert("下界不能大于上界");
           	document.getElementById("rgoodupper").value=rgu;
         if( $("#rsGap_Good_lower").focus()){
	      $("#rsGap_Good_lower").focus();
          }else{
    
	$("#rsGap_Good_upper").focus();
         }
           	
           	
       	   return ;
       	   
       		   }
           	
        	   document.getElementById("rgoodupper").value=rgu;
               }    
           
           function setGGoodLower(){
        	   var rgu=$("#gsGap_Good_upper").val();
               var rgl=$("#gsGap_Good_lower").val();
               var l=parseInt(rgl);
       	    var u=parseInt(rgu);
       	   if(l>u){
           	   alert("下界不能大于上界");
           	 document.getElementById("ggoodlower").value=rgl;

             if( $("#gsGap_Good_upper").focus()){
            	 $("#gsGap_Good_upper").focus();
      		}else{   
      			 //alert("下界不能大于上界");            			 
      			$("#gsGap_Good_lower").focus();
      		}
           
       	   return ;
       	   
       		   }
   		   
        	   document.getElementById("ggoodlower").value=rgl;
               }
           
           function setGGoodUpper(){
        	   var rgu=$("#gsGap_Good_upper").val();
               var rgl=$("#gsGap_Good_lower").val();
               var l=parseInt(rgl);
       	    var u=parseInt(rgu);
       	   if(l>u){
           	  alert("下界不能大于上界");
           	 document.getElementById("ggoodlower").value=rgl;

             if( $("#gsGap_Good_lower").focus()){
            	 $("#gsGap_Good_lower").focus();
      		}else{   
      			 //alert("下界不能大于上界");            			 
      			$("#gsGap_Good_upper").focus();
      		}
           	 
           
       	   return ;
       	   
       		   }
   		   
        
        	   document.getElementById("ggoodupper").value=$("#gsGap_Good_upper").val();
               }    

                
           function setBGoodLower(){
        	   var rgu=$("#bsGap_Good_upper").val();
               var rgl=$("#bsGap_Good_lower").val();
               var l=parseInt(rgl);
          	    var u=parseInt(rgu);
          	   if(l>u){
              	   alert("下界不能大于上界");
              	 document.getElementById("bgoodlower").value=rgl;


              	 if( $("#bsGap_Good_upper").focus()){
              		$("#bsGap_Good_upper").focus();
          		}else{   
          			 //alert("下界不能大于上界");            			 
          			$("#bsGap_Good_lower").focus();
          		}
              
          	   return ;
          	   
          		   }
        	   document.getElementById("bgoodlower").value=rgl;
               }
           function setBGoodUpper(){
        	   var rgu=$("#bsGap_Good_upper").val();
               var rgl=$("#bsGap_Good_lower").val();
               var l=parseInt(rgl);
          	    var u=parseInt(rgu);
          	   if(l>u){
              	  alert("下界不能大于上界");
              	 document.getElementById("bgoodlower").value=rgl;


              	 if( $("#bsGap_Good_upper").focus()){
              		$("#bsGap_Good_upper").focus();
           		}else{   
           			// alert("下界不能大于上界");            			 
           			$("#bsGap_Good_upper").focus();
           		} 
              	
          	   return ;
          	   
          		   }
        	   document.getElementById("bgoodupper").value=$("#bsGap_Good_upper").val();
               } 

//中的验证

function boolok(){
	  var rgl=$("#rsGap_Ok_lower").val();
	  var rgu=$("#rsGap_Good_lower").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
    	   alert("下界不能大于上界");
    	   $("#rsGap_Ok_lower").focus();
	   return ;
	   
		   }
}

function booloku(){
	  var rgl=$("#rsGap_Good_upper").val();
	  var rgu=$("#rsGap_Ok_upper").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
  	   alert("下界不能大于上界");
  	 $("#rsGap_Ok_upper").focus();
	   return ;
	   
		   }
}

function boolgok(){
	  var rgl=$("#gsGap_Ok_lower").val();
	  var rgu=$("#gsGap_Good_lower").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
  	   alert("下界不能大于上界");
  	 $("#gsGap_Ok_lower").focus();
	   return ;
	   
		   }
}

function boolgoku(){
	  var rgl=$("#gsGap_Good_upper").val();
	  var rgu=$("#gsGap_Ok_upper").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
	   alert("下界不能大于上界");
	   $("#gsGap_Ok_upper").focus();
	   return ;
	   
		   }
}


function boolbok(){
	  var rgl=$("#bsGap_Ok_lower").val();
	  var rgu=$("#bsGap_Good_lower").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
	   alert("下界不能大于上界");
	   $("#bsGap_Ok_lower").focus();
	   return ;
	   
		   }
}

function boolboku(){
	  var rgl=$("#bsGap_Good_upper").val();
	  var rgu=$("#bsGap_Ok_upper").val();
	  var l=parseInt(rgl);
	    var u=parseInt(rgu);
	   if(l>u){
	   alert("下界不能大于上界");
	   $("#bsGap_Ok_upper").focus();
	   return ;
	   
		   }
}
    	</script>
    	
    	
	</head>


	<body style='OVERFLOW: SCROLL; OVERFLOW-X: HIDDEN' onload="pageInit();">
		<form
			action="${sys_ctx}/videoCardCompare/compareCriteriaModify.action"
			id="compareCriteria" name="compareCriteria" method="post">

			<input type="hidden" name="comparisonCriteriaVO.comCriteriaID"
				value="${comparisonCriteriaVO.comCriteriaID }" />
			<!--pageheader-->
			<div id="basicform" class="contentwrapper">
			</div>
			<div id="contentwrapper" class="contentwrapper">

				<!--contenttitle-->
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
						  <tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>好的R值偏差
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Good_lower}" id="rsGap_Good_lower" name="comparisonCriteriaVO.rsGap_Good_lower"  onblur="setRGoodLower();"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Good_upper}" name="comparisonCriteriaVO.rsGap_Good_upper" id="rsGap_Good_upper" onblur="setRGoodUpper()"/>
							%
						</td>
						<td width="15%" class="tableaddtitle">
							<span>*</span>中的R值偏差
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Ok_lower}" name="comparisonCriteriaVO.rsGap_Ok_lower" onblur="boolok()" id="rsGap_Ok_lower"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Good_lower}" id="rgoodlower"  disabled/>
							% 或
							<br />
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Good_upper}"  id="rgoodupper"  disabled/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.rsGap_Ok_upper}" name="comparisonCriteriaVO.rsGap_Ok_upper" id="rsGap_Ok_upper" onblur="booloku()"/>
							%
						</td>
					</tr>
			
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>好的G值偏差
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Good_lower}" onblur="setGGoodLower()" name="comparisonCriteriaVO.gsGap_Good_lower" id="gsGap_Good_lower"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Good_upper}" onblur="setGGoodUpper();" name="comparisonCriteriaVO.gsGap_Good_upper" id="gsGap_Good_upper"/>
							%
						</td>
						<td width="15%" class="tableaddtitle">
							<span>*</span>中的G值偏差
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Ok_lower}" onblur="boolgok()" name="comparisonCriteriaVO.gsGap_Ok_lower" id="gsGap_Ok_lower"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Good_lower}"  id="ggoodlower"  disabled/>
							% 或
							<br />
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Good_upper}"  id="ggoodupper"  disabled/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.gsGap_Ok_upper}" onblur="boolgoku()" name="comparisonCriteriaVO.gsGap_Ok_upper" id="gsGap_Ok_upper"/>
							%
						</td>
					</tr>
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>好的B值偏差
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Good_lower}" onblur="setBGoodLower();" name="comparisonCriteriaVO.bsGap_Good_lower" id="bsGap_Good_lower"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Good_upper}" onblur="setBGoodUpper();" name="comparisonCriteriaVO.bsGap_Good_upper" id="bsGap_Good_upper"/>
							%
						</td>
						<td width="15%" class="tableaddtitle">
							<span>*</span>中的B值偏差：
						</td>
						<td width="35%" class="tableadd_data">
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Ok_lower}" name="comparisonCriteriaVO.bsGap_Ok_lower" onblur="boolbok()" id="bsGap_Ok_lower"/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Good_lower}" id="bgoodlower" disabled/>
							% 或
							<br />
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Good_upper}"  id="bgoodupper"disabled/>
							% 至
							<input type="text" style="width: 80px; margin: 0 2px"
								value="${comparisonCriteriaVO.bsGap_Ok_upper}" name="comparisonCriteriaVO.bsGap_Ok_upper" onblur="boolboku()" id="bsGap_Ok_upper"/>
							%
						</td>
					</tr>
					<tr>
						<td width="15%" class="tableaddtitle">
							<span>*</span>X轴的有效值区间
						</td>
						<td width="35%" class="tableadd_data" colspan="3">
							<input type="text" style="margin: 0 2px; width: 80px"
								value="${comparisonCriteriaVO.x_min}" name="comparisonCriteriaVO.x_min" id="x_min"/>
							&nbsp; 至&nbsp;&nbsp;
							<input type="text" style="margin: 0 2px; width: 80px"
								value="${comparisonCriteriaVO.x_max}" name="comparisonCriteriaVO.x_max" id="x_max"/>
							<!-- <span id="error" style="color: red">x_min需小于x_max</span> -->
						</td>
					</tr>
					<tr>
						<td width="15%" class="tableaddtitle">
							说明
						</td>
						<td width="35%" class="tableadd_data" colspan="3">
							<textarea style="width: 80%; height: 60px" name="comparisonCriteriaVO.description" id="description">${comparisonCriteriaVO.description}</textarea>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0"
					class="buttoncontainer" id="table">
					<tbody>
						<tr>
							<td>
								<input type="button" class="submit1 radius2" value="确 定"
									onclick="compareCriteriaModify()" />

								<input type="button" class="reset1 radius2" value="取 消"
									onclick="backHistory()" />

							</td>
						</tr>
					</tbody>
				</table>
			</div>


		</form>
	</body>
</html>