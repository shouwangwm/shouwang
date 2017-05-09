<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>操作</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
  </head>
  <script type="text/javascript" src="/resources/jquery-1.4.2.min.js"></script>
  <script type="text/javascript">
  $(function(){
	  $("#new").bind('click',function(){
		  window.location.href = '/admin!insert.action?tbCommodity.commId='+$('#new_commodityId').val()+'&tbCommodity.commName='+$('#new_commodityName').val();
	  }); 
	  $('input[name=update]').bind('click',function(){
		  var commName = $(this).parent().prev().children()[0].value;
		  var commId = $(this).parent().prev().prev().children()[0].value;
		  window.location.href = '/admin!update.action?tbCommodity.commId='+commId+'&tbCommodity.commName='+commName;
	  });
	  $('input[name=delete]').bind('click',function(){
		  var commId = $(this).parent().prev().prev().prev().children()[0].value;
		  window.location.href = '/admin!delete.action?tbCommodity.commId='+commId;
	  });
  });
  </script>
  
  <body>
  <a href="/index.html">去首页</a>
  	<input type="text" id="new_commodityId"/>
	<input type="text" id="new_commodityName"/>
	<input type="button" value="添加" id="new"/> 
  	<table border="1">
  		<s:iterator value="#request.admins">
  			<tr>
				<td><input type="text" value="<s:property value="commId"/>" readonly="readonly"/></td>
				<td><input type="text" value="<s:property value="commName"/>"/></td>
				<td><input type="button" value="修改" name="update"/></td>
				<td><input type="button" value="删除" name="delete"/></td>
  			</tr>
  		</s:iterator>
  	</table>
  	
  </body>
</html>
