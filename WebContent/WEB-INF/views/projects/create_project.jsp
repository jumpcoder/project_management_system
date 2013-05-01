<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" />
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
				<form class="form-horizontal" action = "create_project.do" method = "post">
					<fieldset>
						<legend>创建一个新项目</legend>
						<div class="control-group">
							<label class="control-label" for="input01">项目名称</label>
							<div class="controls">
								<input type="text" class="span5" id="input01" name = "name" x-webkit-speech="undefined">
								<p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">项目描述</label>
							<div class="controls">
								<textarea class="span5" rows="4" name = "describle"></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="multiSelect">负责人</label>
							<div class="controls">
								<select id="multiSelect" name = "manager">
									<c:choose>
										<c:when test = "${empty employeeList }">
										<option>无用户</option>
										</c:when>
										<c:otherwise>
											<c:forEach var = "employee" items = "employeeList">
											<option>${employee.name }</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="input01">项目成员</label>
							<div class="controls">
								<input type="text" class="span5" id="input01" x-webkit-speech="undefined" name = "members">
							</div>
						</div>
				  
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">保存</button>
							<button class="btn" onclick="location.back()">返回</button>
						</div>
					</fieldset>
				</form>		   
			</div>
			<div class="span3">
				
			</div>
		</div>
	</div>
</body>
</html>