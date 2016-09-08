<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>添加项</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="../js/dateDictionary.js"></script>
</head>
<body>
<div class="pageheader notab">
	<h3 class="pagetitle">当前位置：视频会议 ⇒ 添加项</h3>
</div>
<div class="contentwrapper">
    <div class="contenttitle2">
        <h5 class="fwb fl10">添加项</h5>
    </div>
    <form id="form1" name="form1" action="" method="post" class="add_item">
        <div id="container">
            <div class="content">
                <div class="tablesdiv">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables" >
                        <tr>
                            <td>
                                <table width="100%" border="0" cellspacing="1" cellpadding="0" class="table_css_lx">
                                    <tr id="dp2">
                                        <th width="48%" >请选择类型</th>
                                        <th width="100" rowspan="2">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                <tr>
                                                    <td><input type="button" class="stdbtn mlr10" value="添加所有&gt;&gt;" onclick="moveAllOptions(document.form1.form1leftsel,document.form1.form1rightsel)"/></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="button" class="stdbtn mlr10" value="添加&gt;" onclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)"/></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="button" class="stdbtn mlr10" value="&lt;删除" onclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)"/></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="button" class="stdbtn mlr10" value="&lt;&lt;删除所有" onclick="moveAllOptions(document.form1.form1rightsel,document.form1.form1leftsel)" /></td>
                                                </tr>
                                            </table>
                                        </th>
                                        <th width="48%">已选择<span style="color:#f00" id="form1numberID"></span>个类型 </th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="input_txt" >
                                                <select id="form1leftsel"  multiple="multiple" ondblclick="moveOption(document.form1.form1leftsel,document.form1.form1rightsel)">
                                                    <option value="0" >中国</option>
                                                    <option value="1" >美国</option>
                                                    <option value="2" >英国</option>
                                                </select>
                                            </div>
                                        </td>
                                        <td align="center">
                                            <div class="input_txt">
                                                <select id="form1rightsel" multiple="multiple"  ondblclick="moveOption(document.form1.form1rightsel,document.form1.form1leftsel)">
                                                
                                                </select>
                                            </div>
                                        </td>
                                    </tr>
                                    <input type="hidden"  id="form1baseInfoValues" name="baseInfoValues" value=""/>
                                    <input type="hidden" id="form1baseInfoTexts"  name="baseInfoTexts" value=""/>
                                </table>						
                            </td>								
                        </tr>																		
                    </table>
                </div>
            </div>
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