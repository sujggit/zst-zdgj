 <%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/common.jsp"%>


		<script type="text/javascript">
		function exportComparison(){
		window.location.href="${sys_ctx}/detail/exportComparisonList.action";
 	
		}

		function refresh(){		
         window.location.reload();
			}
		
		</script>

</head>
<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' onload="setInterval('refresh()',60*1000)">
<form action="${sys_ctx}/statistics/queryNum.action" id="pageform" name="pageform" method="post">
   <div id="contentwrapper" class="contentwrapper">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议列表</td>
          <td width="53%" class="tableadd_data" ><select class="inputtran" ><option></option><option>请选择—1</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><input type="checkbox" />视频</span><span><input type="checkbox" />音视频</span></td>
           <td class="tableaddtitle"><input type="reset" class="searchbtn radius2" value="点 名" /><input type="reset" class="searchbtn radius2" value="终止点名" /><input type="reset" class="searchbtn radius2" value="刷 新" /></td>
        </tr>
      </table>
      <!--contenttitle-->
      <!--contenttitle--> 
    </div>
    
    <div id="contentwrapper" class="contentwrapper">
      <!--contenttitle-->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="">
        <thead>
          <tr>
            <th width="%" class="head1">会场名称</th>
            <th width="%" class="head1">结果</th>
            <th width="%" class="head1">音频</th>
            <th width="%" class="head1">视频亮度</th>
            <th width="%" class="head1">视频颜色</th>
            <th width="%" class="head1">丢包率</th>
            <th width="%" class="head1">帧率</th>
            <th width="%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <tr class="gradeC" style="background:#f4f7fa;">
            <td>大庆石化分公司</td>
            <td>好</td>
            <td>有</td>
            <td>正常</td>
            <td>正常</td>
            <td>0%</td>
            <td>25</td>
            <td class="alc"><a href="#">确认</a> | <a href="Automatic_list.html">查看详情</a></td>
          </tr>
          <tr class="gradeA">
            <td>吉林石化分公司</td>
            <td>差</td>
            <td>无</td>
            <td>偏亮</td>
            <td>中</td>
            <td>0.9%</td>
            <td>25</td>
            <td class="alc"><a href="#">确认</a> | <a href="Automatic_list.html">查看详情</a></td>
          </tr>
        </tbody>
      </table>
      <!--contenttitle--> 
    </div>
    
    
      </form>
      </body>
      </html>