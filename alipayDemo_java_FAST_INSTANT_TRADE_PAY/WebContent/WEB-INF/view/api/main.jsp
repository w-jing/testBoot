<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<%@ include file="../base/common.jsp"%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>开发者工具</title>
    <link href="static/css/main.css" rel="stylesheet">
  </head>
  <body>
    <%@ include file="../base/head.jsp"%>
    <div class="container">
      <!-- body begin -->
      <div class="container-body">
        <!-- Tabs -->
        <div id="tabs">
          <!-- Nav tabs -->
          
        </div>

      </div>
    </div>
    <!-- footer begin -->
    <%@ include file="../base/foot.jsp"%>
  </body>
  <script src="static/js/main.js"></script>
  <script src="static/js/tabPanel.js"></script>
  <script type="text/javascript">
    var url = "getApiInfo.json";
    $.post(url,function(json){
      $('#tabs').tabPanel({
        data:json
      })
    });

  </script>
</html>