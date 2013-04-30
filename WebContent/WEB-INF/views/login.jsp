<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>凯盛项目管理系统</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
	<style type="text/css">
		body{
			background-image:url(img/bg.png);
		}
		#container{
			margin-top:100px;
		}
		#login{
			width:220px;
			margin:0px auto;
		}
	</style>
</head>
<body>
	<div id = "container" class="container" >
		<form id = "login" class="well" action = "login.do" method = "post">
			<legend>Kaishengit-PMS</legend>
			<label>账号</label>
			<input type="text" class="span3" name = "username" />
			<label>密码</label>
			<input type="text" class="span3" name = "password" />
			<br/>
			<button type="submit" class="btn btn-primary">进入系统</button>
		</form>
	</div>
</body>
</html>