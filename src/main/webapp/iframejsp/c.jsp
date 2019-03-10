<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
	<!-- CSS样式文件和JS文件的引入 -->
	<link rel="stylesheet" href="/webproject/resource/bootstrap/css/bootstrap.min.css"/>
	<script src="/webproject/resource/jquery/jQuery-2.1.4.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<form role="form" action="../Unloadcontrol" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">关键字</label> 
					<input type="text" class="form-control" id="name" name="skey" placeholder="请输入审查关键字">
				</div>
				<div class="form-group">
					<label for="inputfile">文件输入</label> 
					<input type="file" id="inputfile" name="filename">
				</div>
				<button type="submit" class="btn btn-info btn-sm">提交</button>
			</form>
			${msg}
		</div>
	</div>
</body>
</html>