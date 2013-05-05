<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>凯盛项目管理系统</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="static/css/typo.css" />
</head>
<body class="body">
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">凯盛项目管理系统</a>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		<div class="row">
			<div class="span3">
				<div style="padding: 8px 0;" class="well">
					<ul class="nav nav-list">
						<li class="nav-header">新Apple总部项目</li>
						<li class="divider"></li>
						<li class="active"><a href="#"><i class="icon-white icon-home"></i>最新动态</a></li>
						<li><a href="goals.do"><i class="icon-flag"></i>目标</a></li>
						<li><a href="resource.do"><i class="icon-folder-open"></i>资料库</a></li>
						<li><a href="file.do"><i class="icon-file"></i>文件共享</a></li>
				  		<li><a href="contact.do"><i class="icon-user"></i>联系人</a></li>
				  		<li><a href="idea.do"><i class="icon-fire"></i>想法</a></li>
				  		<li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
				  		<li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			</div>
			<div class="span6">
			  	<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;">
					<li class="active">
						<i class="icon-th"></i>你在想什么？
					</li>
				</ul>
				<div class="wall">
					<form style="margin:0px">
						<textarea name="" id="" style="width:415px" rows="3"></textarea>
						<button class="btn btn-primary">发布</button>
					</form>
				</div>

				<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:20px">
					<li class="active">
						<i class="icon-th"></i>信息流
					</li>
				</ul>
				<div class="wall">
					
				</div>
			</div>
			<div class="span3">
				<div class="box">
					<div class="head">我的任务</div>
					<ul>
						<li><a href=""></a>任务1</li>
						<li><a href=""></a>任务1</li>
						<li><a href=""></a>任务1</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>