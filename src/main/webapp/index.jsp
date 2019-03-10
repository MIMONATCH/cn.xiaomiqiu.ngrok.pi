<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CQJTU-2019</title>
	<!-- CSS样式文件和JS文件的引入 -->
	<link rel="stylesheet" href="/webproject/resource/bootstrap/css/bootstrap.min.css"/>
	<script src="/webproject/resource/jquery/jQuery-2.1.4.min.js"></script>
	<script src="/webproject/resource/echarts/echarts.simple.min.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          <a class="navbar-brand" href="https://v3.bootcss.com/examples/dashboard/#">综合实训</a>
        </div>
      </div>
 </nav>
<div class="container-fluid">
  <div class="row">
  	<div class="col-md-3">
  		<ul style="list-style-type:none">
  			<li><button id="btn1" type="button" class="btn btn-link">词云</button></li>
  			<li><button id="btn2" type="button" class="btn btn-link">关键字分析</button></li>
  			<li><button id="btn3" type="button" class="btn btn-link">文件上传</button></li>
  			<li><button id="btn4" type="button" class="btn btn-link">功能四</button></li>
  			<li><button id="btn5" type="button" class="btn btn-link">功能五</button></li>
  		</ul>
  	</div>
  	<div class="col-md-9">
  		<iframe id="myiframeID" height="400" width="600" frameborder="0" src="iframejsp/a.jsp"></iframe>
    </div>
  </div>
  	<div class="row">
  		
  	</div>
  </div>
  <script type="text/javascript">
  		var index = 0
		$("button").click(function(){
			var btnid = $(this).attr("id")
			if(btnid == "btn1"){
				$("#myiframeID").attr("src","iframejsp/a.jsp")
				
			}
			if(btnid == "btn2"){
				$("#myiframeID").attr("src","iframejsp/b.jsp")
				
			}
			if(btnid == "btn3"){
				$("#myiframeID").attr("src","iframejsp/c.jsp")
				
			}
			if(btnid == "btn4"){
				$("#myiframeID").attr("src","iframejsp/d.jsp")
				
			}
			if(btnid == "btn5"){
				$("#myiframeID").attr("src","iframejsp/e.jsp")
				
			}
		})
	</script>
</body>
</html>