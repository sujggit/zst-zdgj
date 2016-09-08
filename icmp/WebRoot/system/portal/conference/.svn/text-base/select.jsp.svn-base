<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="zzst" uri="http://www.zzstworld.com"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/select.css" type="text/css" rel="stylesheet" />
<c:set var="swh_ctx" value="${pageContext.request.contextPath}"></c:set>
<title>会场选择</title>
<link   type="text/css"   rel="stylesheet"   href="css/xtree.css"/>
<script   type="text/javascript"   src="js/xtree.js"></script>   
<script   type="text/javascript"   src="js/xmlextras.js"></script>   
<script   type="text/javascript"   src="js/xloadtree.js"></script>
<script   type="text/javascript"   src="js/selectAdapter.js"></script>    
<script type='text/javascript' src='${swh_ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${swh_ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${swh_ctx }/dwr/interface/VenueSelectAction.js'></script>
        <script type="text/javascript">
               Array.prototype.remove=function(dx)
  				{
				    if(isNaN(dx)||dx>this.length){return false;}
				    for(var i=0,n=0;i<this.length;i++)
				    {
				        if(this[i]!=this[dx])
				        {
				            this[n++]=this[i]
				        }
				    }
				    this.length-=1
			   }
			   //获取到得所有会场数组
			   var allVenueArray = new Array();
			   //返回的对象数组
               var returnArray = new Array();
               //获得的原始参数对象
               var parentParam = window.dialogArguments.d_ParametersArray;
               //可选的select
               var optionalSel = new Object();
               //已选择的select
               var selectedSel = new Object();
               //已选择的对象数组
               var selectedObjArray = new Array();
               window.onload= function(){
                  //初始化对象
                  optionalSel = document.getElementById("optionalObjList");
                  
                  selectedSel = document.getElementById("selectedObjList");
                 
                  //如果有已经选择的会场则显示
                  if(parentParam.selectedVenue){
                       var venueArray = parentParam.selectedVenue.split(",");  
                       for(var i=0;i<venueArray.length;i++){
                           selectedObjArray[venueArray[i]] = venueArray[i];
                       }
                  }
               }
               function getVenueById(ids){
                   VenueSelectAction.queryVenueById(ids,calExistBack);
               }
               function calExistBack(lst){
               
               }
               
               //获取会场类型下的所有会场
               function  getVenuesByType(roomType,startTime,endTime){
                     VenueSelectAction.queryVenue(roomType,startTime,endTime,calVenueBack);
               }
               //获取关联会场返回方法
               function calVenueBack(lst){
                     
                     if(null!=lst){
                     //删除所有会场
                         select.deleteAllOption(optionalSel);
                         
                         var length = lst.length;
                         for(var i=0;i<length;i++){
                            

                             var itemText = lst[i].venueName;
                             var itemValue = lst[i].venueID;
                             select.addOption(optionalSel,itemText,itemValue);
                             
                             var newDepartObj = {
			                       venueID:lst[i].venueID,
			                       venueCode:lst[i].venueCode,
			                       venueName:lst[i].venueName,
			                       venueIP:lst[i].venueIP,
			                       venuePort:lst[i].venuePort,
			                       contractTel:lst[i].contractTel,
			                       callSpeed:lst[i].callSpeed,
			                       contractPersonID:lst[i].contractPersonID,
			                       contractPersonName:lst[i].contractPersonName,
			                       callType:lst[i].callType,
			                       venueProperty:lst[i].venueProperty,
			                       venueNumber:lst[i].venueNumber,
			                       state:lst[i].state
			                   }
			                   //像会场数组赋值
			                   allVenueArray[lst[i].venueID]=newDepartObj;
                         }
                     }
               }
            
              
              //添加选中的会场
              function addNewOptions(type){
                   
                   var itemValue = "";
                   var itemText  = "";
                   //存放已经选择的名称
                   var selectedObjName = "";
                   //看是否设置了为单选
                   var selectType = window.dialogArguments.d_ParametersArray.selectType;

                   if(type=="one"){
                       //判断是单选还是复选
                       if(selectType){
                        if(selectType=="radio"){
	                           var selectArray = select.getAllOptions(selectedSel);
	                           if(selectArray.length>0){
	                               alert("不能多选！");
	                               return;
	                           }
	                        }
	                   }
                        
                       //高效方法
                       itemValue = optionalSel.options[optionalSel.selectedIndex].value;
                       itemText = optionalSel.options[optionalSel.selectedIndex].text;
                       
                       
                       //过滤前端已选
                       if(selectedObjArray[itemValue]){
	                                     selectedObjName =selectedObjName+itemText+" ";
	                                     alert(selectedObjName+" 已选择！");
	                                     return;
	                   }
     
                       if(!select.hasOptionValue(selectedSel,itemValue))
	                           select.addOption(selectedSel,itemText,itemValue);
	                   return ;
                   }else{
                        itemValue = select.getSelectedValue(optionalSel);
                        itemText  = select.getSelectedText(optionalSel);
                   }
             
                   var itemLength = itemValue.length;
                   
                   //判断是单选还是复选
                 
                   if(selectType){
                        if(selectType=="radio"){
                            var selectArray = select.getAllOptions(selectedSel);
	                           if(selectArray.length>0||itemLength>1){
	                               alert("不能多选！");
	                               return;
	                           }
	                        }
	                   }
                   for(var i=0;i<itemLength;i++){
	                   if(!select.hasOptionValue(selectedSel,itemValue[i])){
	                   
	                   
	                               //过滤已经选中的
	                               //alert(itemValue[i]+"///"+selectedObjArray.toString());
	                               if(selectedObjArray[itemValue[i]]){
	                                     selectedObjName = selectedObjName+itemText[i]+" ";
	                                     continue;
	                               }
	                               select.addOption(selectedSel,itemText[i],itemValue[i]);
	                           }
                   }
                   
                   
                     if(selectedObjName)
                       alert(selectedObjName+" 已选择！");
		       }
		       
              //删除已选中的会场
              function deleteSelectedOptions(type){
                   try{
	                   if(type=="one"){
	                       select.deleteByIndex(selectedSel,selectedSel.selectedIndex);
	                       return ;
	                   }
	                  
	                   var itemValue =  select.getSelectedValue(selectedSel);
	                   var itemText  =  select.getSelectedText(selectedSel);
	                   var itemLength = itemValue.length;
	                  
	                   for(var i=0;i<itemLength;i++){
	                       select.deleteOptionByValue(selectedSel,itemValue[i]);
	                   }
	                   
                   }catch(err){
                       return;
                   }
              }
              
            //保存并退出
            function saveObjAndClose(){

                   
                  var selectedValues =  select.getAllOptions(selectedSel);
                  var selectedVenueLength = selectedValues.length;
              
                  for(var i=0;i<selectedVenueLength;i++){
                       returnArray[i] = allVenueArray[selectedValues[i]];
                  }
                       try{
					         eval("window.dialogArguments."+window.dialogArguments.d_ParametersArray.methodName+"(returnArray)");
					         window.close();        
						}catch(err){
						       alert(err);
							   window.close();
					  }
                    
                  
            }
            
            function cancelOperate(){
                     window.close();
            } 
        </script> 
</head>

<body>
 <div class="boxbg" align="left"  style="border:1px solid #437e8c;">
   <table width="100%" border="0px" height="532px" cellspacing="0" cellpadding="0">
     <tr>
       <td  style="width:7px;"><img src="images/xg_02.gif" width="7" height="36" /></td>
       <td class="bluebg" style="width:506px">会场选择</td>
       <td  style="width:9px;" ><img src="images/xg_06.gif" width="9" height="36" /></td>
     </tr>
     <tr>
            <td colspan="3">
                 <table width="100%" height="390px" style="border-bottom:#437e8c 1px solid;">
                    <tr class="textga">
                         <td width="50%" height="39" align="left" style="padding-left:20px;font-size:12px">可选会场</td>
                         <td width="55%" align="left" style="padding-left:65px;font-size:12px">已选会场</td>
                    </tr>
                    <tr>
                          <td colspan="2"><table width="98%" align="center">
                    <tr>
                           <td width="35%" rowspan="2">
                           
                            <table width="100%" height="330px">
                             <tr>
                               <td style="background:url(images/xgwb.png);height:198px">
                                  <div  style="no-repeat;overflow:scroll;width:186px;height:190px;padding-left:10px;margin-top:0px;border:0px solid red">
                                       <script type="text/javascript">   
							                    webFXTreeConfig.rootIcon        = "images/xp/folder.png";   
									            webFXTreeConfig.openRootIcon    = "images/xp/openfolder.png";   
									            webFXTreeConfig.folderIcon        = "images/xp/folder.png";   
									            webFXTreeConfig.openFolderIcon    = "images/xp/openfolder.png";   
									            webFXTreeConfig.fileIcon          = "images/xp/file.png";   
									            webFXTreeConfig.lMinusIcon        = "images/xp/Lminus.png";   
									            webFXTreeConfig.lPlusIcon        = "images/xp/Lplus.png";   
									            webFXTreeConfig.tMinusIcon        = "images/xp/Tminus.png";   
									            webFXTreeConfig.tPlusIcon        = "images/xp/Tplus.png";   
									            webFXTreeConfig.iIcon            = "images/xp/I.png";   
									            webFXTreeConfig.lIcon            = "images/xp/L.png";   
									            webFXTreeConfig.tIcon            = "images/xp/T.png";
									               
									            var rti;   
									            var tree = new WebFXLoadTree("会议室","tree.jsp?parentID=-1&mrType="+parentParam.roomType+"&startTime="+parentParam.startTime+"&endTime="+parentParam.endTime+"&selectedVenue="+parentParam.selectedVenue+"&date="+new Date());   
									          
									            document.write(tree); 
                                                
                                      </script> 
                                    
							     </div>
							        </td>
                             </tr>
                             <tr>
                                <td style="font-size:12px">已选会场</td>
                             </tr>
                             <tr>
                               <td >
                                 
                                   <select style="margin-top:0px;background:transparent;width:186px" class="selected-s"  size="25" id="optionalObjList" ondblclick="javascript:addNewOptions('one')" onclick="" multiple>
                                            
                                   </select>
                                 
                               </td>
                             </tr>
                           </table>
                           </td>
                           <td width="18%" align="center" valign="bottom">
                               <input type="button" name="button" id="button" onclick="javascript:addNewOptions()" style="margin-bottom:20px;cursor:pointer"  class="faxi"value="" /></td>
                           <td width="37%" rowspan="2" >
                           
                           <select style="width:195px" size="17" style="background:none" class="selected"  id="selectedObjList" ondblclick="deleteSelectedOptions('one')" multiple>
                           </select>
                           
                           </td>
                    </tr>
                    <tr>
	                      <td align="center" valign="top">
	                          <input type="button" name="button2" onclick="deleteSelectedOptions()" id="button2" style="margin-top:20px;cursor:pointer"  class="faxi2"value="" />
	                      </td>
                     </tr>
                  </table>
             </td>
         </tr>
         <tr>
           <td colspan="3" style="padding-left:10px; padding-top:15px; padding-bottom:20px;">
           
           <script type="text/javascript">
                                
                                  if("yes"==parentParam.needCallSpeed){
	                                   document.write("<table border='0' width='100%' >");
	                                   document.write("<tr>");
	                                   document.write("<td width='22%' class='hjsl'>呼叫速率</td>");
	                                   document.write("<td width='78%'><input type='text' id='callSpeed'/></td>");
	                                   document.write("</tr>");
	                                   document.write("</table>");
                                   }else{
                                       document.write("&nbsp;");
                                   }
              </script>
           </td>
          </tr>
       </table></td>
     </tr>
     <tr>
		       <td colspan="3"><table  align="center" width="60%" style=" margin-top:15px; margin-bottom:20px;">
		         <tr>
		           <td align="center">
		               <input type="button" name="button" id="button"  class="anjiu"  onclick="saveObjAndClose()" value="确定" />
		           </td>
		           <td align="center">
		               <input type="button" name="button" id="button"  onclick="cancelOperate()"  class="anjiu"value="取消" /></td>
		         </tr>
		       </table></td>
		     </tr>
       </table>
 </div>
</body>
</html>