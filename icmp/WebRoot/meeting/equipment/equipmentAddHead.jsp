<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryEquipmentVO"%>
<%@page import="com.zzst.model.enums.EquipmentEnum"%>
<html>

<script type="text/javascript">
   function menu1()
  {
        location.href="${sys_ctx }/equipment/terminalBeforAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="#fff";
     
      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
  
  
    function menu2()
  {      //alert("******");
         location.href="${sys_ctx }/equipment/mcuBeforAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
     

      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
   function menu3()
  {    // alert("***********");
        location.href="${sys_ctx }/equipment/centerControlBeforAdd.action";
        //alert("&&&&&");
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
     

      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
  
  
  function menu4()
  { 
        location.href="${sys_ctx }/equipment/videoCardBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
     

      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }


  function menu5()
  { 
        location.href="${sys_ctx }/equipment/otherEquipmentBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
     

      
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }

  function menu6()
  {
        location.href="${sys_ctx }/equipment/noticeBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="#fff";
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
  
  function menu7()
  {      
         location.href="${sys_ctx }/equipment/audioBeforeAdd.action";
       //document.getElementsByTagName("li")[x-1].style.backgroundColor="";
       //document.getElementsByTagName("li")[m-1].style.backgroundColor="#f00";
  }
</script>
  <body>
   
       
     
    <!--pageheader-->
       
            <div id="m">
                <ul> 
                    <%
            	ArrayList deList = (ArrayList)request.getAttribute("deList");
            	if(deList != null && deList.size() > 0){
            		for(int i=0; i<deList.size(); i++){
            			DictionaryEquipmentVO deEquipmentVO = (DictionaryEquipmentVO)deList.get(i);
            			if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_TERMINAL){
            				%>
            				<li id="m1" onmousedown="menu1();" style="background:<%=request.getAttribute("style1")%>">终端增加</li> 
            				
            				<%
            			}
            			if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_MCU){
            				
            				%>
            				<li id="m2" onmousedown="menu2();" style="background:<%=request.getAttribute("style2")%>">MCU增加</li>
            				<%
            			}
						if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_CENTERCONTROL){
            				
            				%>
            				 <li id="m3" onmousedown="menu3();" style="background:<%=request.getAttribute("style3")%>">中控增加</li>  
            				<%
            			}
            			if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_VIDEOCARD){
            				
            				%>
            				 <li id="m4" onmousedown="menu4();" style="background:<%=request.getAttribute("style4")%>">比对卡增加</li>  
            				<%
            			}
						if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_OTHEREQUIPMENT){
            				
            				%>
            				 <li id="m5" onmousedown="menu5();" style="background:<%=request.getAttribute("style5")%>">其他设备增加</li>  
            				<%
            			}
						
						if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_ENC){
		     				%>
		     				<li id="m6" onmousedown="menu6();" style="background:<%=request.getAttribute("style6")%>">告示增加</li> 
		     				
		     				<%
		     			}
		     			if(deEquipmentVO.getDicValue()==EquipmentEnum.TYPE_ID_AUDIO){
		     				
		     				%>
		     				<li id="m7" onmousedown="menu7();" style="background:<%=request.getAttribute("style7")%>">音频增加</li>
		     				<%
		     			}
            			
            		}
            	}
            	%>
            	 
              </ul>
            </div>
           
            
  </body>
</html>