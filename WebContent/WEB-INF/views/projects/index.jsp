<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>凯盛项目管理系统</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="static/css/typo.css" />
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">凯盛项目管理系统</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span9">     
				<div class="page-header">
	          		<h2>项目列表</h2>
	          	</div>
	          	<a href="create_project.do" class="btn btn-success"><i class="icon-plus icon-white"></i>创建一个新项目</a>
			    <c:choose>
				    <c:when test = "${empty projectList}">
				    <ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
						<li class="active">
							<div>无项目</div>
						</li>
					</ul>			    	
				    </c:when>
				    <c:otherwise>
				    	<c:forEach var = "project" items = "${projectList }">
				    	<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
							<li class="active">
								<a href="project.do?id=${project.id }"><i class="icon-th"></i>${project.name }</a>
							</li>
						</ul>	
						<div class="wall">
							<p>${project.describle }</p>
						</div>
				    	</c:forEach>
				    </c:otherwise>
			    </c:choose>
			</div>
			<div class="span3">	
			</div>
		</div>
	</div>
</body>
</html>