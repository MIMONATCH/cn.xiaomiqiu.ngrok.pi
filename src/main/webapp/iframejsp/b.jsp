<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<div class="class="form-group"">
		<form action="../GetWord" method="get">
		<input name="forminput" type="text" class="form-control"></input>
		</form>
		<button id="btn_submit" type="button" class="btn btn-info btn-sm">生成柱状图</button>
	</div>
	<div class="row">
		<div id="testcharts" style="width: 600px; height: 400px;"></div>
	</div>
	<script text="text/javascript">
		var myCharts = echarts.init(document.getElementById('testcharts'));
		
		$("button").click(function(){
			var path = $("input").val()
			$.ajax({
				url:"../GetWord",
				type:"post",
				data:{
					"urlpath": path
				},
				datatype:"json",
				success:function(result){
					console.log(result)
					var data = JSON.parse(result)
					var option = {
				            title: {
				                text: 'test'
				            },
				            xAxis: {
				                type: 'category',
				                data: data.keys
				            },
				            yAxis: {
				                type: 'value'
				            },
				            series: [{
				                data: data.values,
				                type: 'bar'
				            }]
				        };
					myCharts.setOption(option);
				}
			})
		})
	</script>
</body>
</html>