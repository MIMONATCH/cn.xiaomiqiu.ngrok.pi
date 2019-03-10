<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- CSS样式文件和JS文件的引入 -->
	<link rel="stylesheet" href="/webproject/resource/bootstrap/css/bootstrap.min.css"/>
	<script src="/webproject/resource/jquery/jQuery-2.1.4.min.js"></script>
	<script src="/webproject/resource/echarts/echarts.simple.min.js"></script>
</head>
<body>
	<div class="form-group">
		<form action="../MyclassSync" method="get">
		<input name="forminput" type="text" class="form-control"></input>
		</form>
  	</div>
  		<div class="raw">
  			<button id="btn_submit" type="button" class="btn btn-info btn-sm">生成词云</button>
  		</div>
  		<div>
  			<img alt="no image" id="image" src=""></img>
  		</div>
  		<script type="text/javascript">
  		var index=0
  		$("button").click(function(){
			var inputval = $("input").val()
			index++
			$.ajax({
				url:"../MyclassAsync",
				type:"post",
				data:{
					"urlPath":inputval,
					"id":index
				},
				dataType:"text",
				success:function(e){
					$("img").attr("src",e)
					alert(e)
				}
			})
		})
  		</script>
</body>
</html>