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
					<a href="goal.do"><i class="icon-white icon-flag"></i>目标</a>
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
			
			
			<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
				<li class="active">
					<a href="javascript:;"><i class="icon-th"></i>目标1</a>
				</li>
				<li style="float:right">
					<i class="icon-edit"></i><a href="edit_task.do" class="link-black">编辑</a>
				</li>
			</ul>
			<div class="wall">
				<p>北京市公安局有关负责人表示，利用互联网编造、传播谣言的行为严重扰乱社会秩序、影响社会稳定、危害社会诚信，公安机关对此将依法查处。希望广大网民自觉遵守法律法规，不信谣、不传谣，发现谣言及时举报，共同维护健康的网络环境和良好的社会秩序。</p>
				<div class="progress progress-danger">
					<div class="bar" style="width: 60%;">当前目标总进度完成60%</div>
				</div>

				<div class="page-header">
					<a href="create_task.do" class="btn btn-success"><i class="icon-plus icon-white"></i>添加新任务</a>
				</div>
				<dl>
					<c:choose>
						<c:when test = "${empty taskList }">
							
						</c:when>
						<c:otherwise>
							<c:forEach var = "task" items = "${taskList }">
							<dt style="margin-top:15px"><i class="icon-bookmark"></i><a href=${task.employeeId == emloyeeId?"edit_task.do" : "#" }>${task.name }</a>&nbsp;&nbsp;&nbsp;[${task.employeeName }]</dt>
		        			<dd>${task.describle }</dd>
		        			<div class="progress progress-success">
							  <div class="bar" style="width:${task.percentage}%;">${task.percentage}%</div>
							</div>
							
							</c:forEach>
						</c:otherwise>
					</c:choose>
      			</dl>
			</div>
			
		</div>
	  </div>
	</div>
</body>
</html>