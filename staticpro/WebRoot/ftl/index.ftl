<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>      
    <title>testftl</title>  
 <meta http-equiv="pragma" content="no-cache">  
 <meta http-equiv="cache-control" content="no-cache">  
 <meta http-equiv="expires" content="0">      
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page">  
  </head>  
  <body>  
  

   <a href="/admin.action">È¥²Ù×÷Ò³</a><br/>
   <#list commoditys as comm>
   		<a href="/html/${comm.commId}.html">${comm.commName}</a>
   </#list>

  </body>  
</html>  