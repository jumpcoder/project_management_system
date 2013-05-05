<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>凯盛项目管理系统</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
	<script type="text/javascript" src="static/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</head>
<body class="body">
	
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">Kaishengit PMS</a>
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
					  <li><a href="news.do"><i class="icon-home"></i>最新动态</a></li>
					  <li class="active">
						<a href="#"><i class="icon-white icon-flag"></i>目标</a>
					  </li>
					  <li><a href="resource.do"><i class="icon-folder-open"></i>资料库</a></li>
					  <li><a href="file.do"><i class="icon-file"></i>文件共享</a></li>
					  <li><a href="contact.do"><i class="icon-user"></i>联系人</a></li>
					  <li><a href="idea.do"><i class="icon-fire"></i>想法</a></li>
					  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
					  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				
				<div class="btn-group" style="float:right">
	          		<a class="btn" href="#"><i class="icon-cog"></i>操作</a>
	          		<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
	          		<ul class="dropdown-menu">
	            		<li><a href="create_goal.do"><i class="icon-plus"></i>添加新目标</a></li>
	            		<li><a href="#"><i class="icon-zoom-in"></i>浏览所有任务</a></li>
	          		</ul>
	        	</div>

				<div class="clear"></div>
				<c:forEach var = "goal" items = "${goalList }">
					<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
						<li class="active">
							<a href="goal.do?id=${goal.id }"><i class="icon-th"></i>${goal.name}</a>
						</li>
						<li style="float:right"><i class="icon-edit"></i><a href="edit_goal.do?id=${goal.id} }" class="link-black">编辑</a></li>
					</ul>
					<div class="wall">
						<p>${goal.describle }</p>
						<div class="progress progress-danger">
							<div class="bar" style="width: 60%;">已完成60%</div>
						</div>
					</div>	
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>