<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>demo</title>

</head>
<body class="withvernav">
 <div class="centercontent tables">
    
    <!--pageheader-->
    <div id="basicform" class="contentwrapper">
    
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
        <tr>
          <td width="15%" class="tableaddtitle">会议名称</td>
          <td width="35%" class="tableadd_data" ><input type="text" name="it3" class="inputtran" /></td>
          <td width="15%" class="tableaddtitle" >会议状态</td>
          <td width="35%" class="tableadd_data" ><input type="text" name="it4" class="inputtran" /></td>
          <td rowspan="2" class="tableaddtitle" style="vertical-align:bottom;"><span class="tableaddtitle">
            <input type="reset" class="searchbtn radius2" value="查 询" />
          </span></td>
        </tr>
        <tr>
          <td class="tableaddtitle">开始时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="it" class="inputtran" /></td>
          <td class="tableaddtitle">结束时间</td>
          <td class="tableadd_data" ><img src="${sys_style1 }/images/c2.png" width="16" height="16" style="vertical-align:middle; padding:3px;" />
            <input type="text" name="it" class="inputtran" /></td>
        </tr>
        
      </table>

      <!--contenttitle-->
      <div class="widgetcontent">
        <div class="msgmore"><a href=""><img src="${sys_style1 }/images/calarrow_1.png" width="51" height="5" border="0" usemap="#Map" />
            <map name="Map" id="Map">
              <area shape="rect" coords="2,-1,6,7" href="1.html" />
              <area shape="rect" coords="36,0,51,6" href="2.html" />
            </map>
        </a></div>
      </div>
      
      <!--contenttitle--> 
    </div>
    <div id="contentwrapper" class="contentwrapper">
      <div class="contenttitle2">
        <h5 class="fwb fl10">查询列表</h5>
        <h5 class="fwb fr10"><a href="Conference Management_add.html">导出</a></h5>
      </div>
      <!--contenttitle--><!--
      
      <div class="tableoptions">
                显示 &nbsp;<select class="radius3">
                    	<option value="">10</option>
                        <option value="">20</option>
                        <option value="">30</option>
                    </select> &nbsp;项
                    <span style=" float:right; margin-right:10px;">搜索：<input id="datepicker" type="text" class="searwidth100" /></span>
      </div>
      -->
      <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="query_table">
        <thead>
          <tr>
            <th width="8%" class="head1">序号</th>
            <th width="16%" class="head1">会议名称</th>
            <th width="16%" class="head1">开始时间</th>
            <th width="16%" class="head1">结束时间</th>
            <th width="16%" class="head1">会议类型</th>
            <th width="16%" class="head1">会议状态</th>
            <th width="12%" class="head1">操作</th>
          </tr>
        </thead>
        <tfoot>
        </tfoot>
        <tbody>
          <tr>
            <td class="">1</td>
            <td>会议1</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>2</td>
            <td>会议2</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>3</td>
            <td>会议3</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>4</td>
            <td>会议4</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议中            </td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>5</td>
            <td>会议5</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>6</td>
            <td>会议6</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>7</td>
            <td>会议7</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>8</td>
            <td>会议8</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>9</td>
            <td>会议9</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
          <tr>
            <td>10</td>
            <td>会议10</td>
            <td>2013-01-07 15:46</td>
            <td class="center">2013-01-07 17:46</td>
            <td>视频会议</td>
            <td class="center">会议结束</td>
            <td class="center"><a href="Conference Management_view.html">查看</a> | <a href="#">删除</a></td>
          </tr>
        </tbody>
      </table>
      
     <jsp:include page="/common/pageFooter.jsp" />
      <!--contenttitle--> 
    </div>
    <!--contentwrapper--> 
  </div>
  </body>
  </html>