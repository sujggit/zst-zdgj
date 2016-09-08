<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
    
<title>backups</title>
<link rel="stylesheet" href="split.css" type="text/css" />
</head>
  
<body>
<div class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">MCU备份</h5>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td width="15%" class="tableaddtitle">会议名称</td>
				<td class="tableadd_data">销售公司加油卡管理系统会议</td>				
			</tr>
		</table>
    <form id="form1" name="form1" action="" method="post" class="add_item">    	
        <div id="container">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="backups" >
            	<tr>
            		<th width="50%" style="text-align:left">使用中的MCU<span><img src="../images/use.gif"/></span></th>
            		<th class="backup_border"></th>
            		<th width="50%" style="text-align:left">备份MCU<span><img src="../images/backup.gif"/></span></th>
            	</tr>
            	<tr>
            		<td>集团MCU</td>
            		<td class="backup_border"><a href="#">切换到MCU</a></td>
            		<td>集团MCU备份</td>
            	</tr>
            	<tr>
            		<td>华北MCU</td>
            		<td class="backup_border"><a href="#">切换到MCU</a></td>
            		<td>华北MCU备份</td>
            	</tr>
            	<tr>
            		<td>华东MCU</td>
            		<td class="backup_border"><a href="#">切换到MCU</a></td>
            		<td>华东MCU备份</td>
            	</tr>
            	<tr>
            		<td>华南MCU</td>
            		<td class="backup_border"><a href="#">切换到MCU</a></td>
            		<td>华南MCU备份</td>
            	</tr>
            	<tr>
            		<td>.</td>
            		<td class="backup_border"><a href="#">切换到MCU</a></td>
            		<td>.</td>
            	</tr>
            </table>
        </div>
    </form>
	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		<tr>
			<td>
				<input type="button" class="submit1 radius2" value="确 定" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
				<input type="button" class="reset1 radius2" value="取 消" onclick="MM_goToURL('parent','CRmanage_list.html');return document.MM_returnValue"/></button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
