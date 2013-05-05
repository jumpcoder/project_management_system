<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
				  <li>
					<a href="goals.do"><i class="icon-flag"></i>目标</a>
				  </li>
				  <li><a href="resource.do"><i class="icon-folder-open"></i>资料库</a></li>
				  <li><a href="file.do"><i class="icon-file"></i>文件共享</a></li>
				  <li><a href="contact.do"><i class="icon-user"></i>联系人</a></li>
				  <li class="active"><a href="#"><i class="icon-white icon-fire"></i>想法</a></li>
				  <li><a href="#"><i class="icon-warning-sign"></i>Bug</a></li>
				  <li><a href="#"><i class="icon-cog"></i>项目设置</a></li>
				</ul>
			</div>
		</div>
		<div class="span9">
			<ul class="breadcrumb" style="margin-bottom:0px;border-radius: 3px 3px 0 0;margin-top:15px">
				<li class="active">
					<a href="idea.html"><i class="icon-fire"></i>想法</a>
				</li>
				<li class="pull-right"><i class="icon-plus"></i><a href="new_idea.html" class="link-black">发表想法</a></li>
			</ul>
			<div class="wall" style="margin-bottom:20px;">
				<blockquote>
				  <h4><a href="idea_show.html">使用Ajax技术</a></h4>
				  <p style="font-size:14px;line-height:1.5;">在最新的版本中使用Ajax技术怎么样，推荐看看Jquery的Ajax和DWR...</p>
				  <small>樊凯发布于 1个月前</small>
				  <a href="" title="编辑"><i class="icon-pencil"></i></a>
				  <a href="" title="删除"><i class="icon-trash"></i></a>
				</blockquote>
				
				<blockquote>
				  <h4><a href="">添加验证码功能</a></h4>
				  <p style="font-size:14px;line-height:1.5;">在最新的版本中使用Ajax技术怎么样，推荐看看Jquery的Ajax和DWR...</p>
				  <small>樊凯发布于 1个月前</small>
				  <a href="" title="编辑"><i class="icon-pencil"></i></a>
				  <a href="" title="删除"><i class="icon-trash"></i></a>
				</blockquote>
				<blockquote>
				  <h4><a href="">留言功能</a></h4>
				  <p style="font-size:14px;line-height:1.5;">在最新的版本中使用Ajax技术怎么样，推荐看看Jquery的Ajax和DWR...</p>
				  <small>樊凯发布于 1个月前</small>
				  <a href="" title="编辑"><i class="icon-pencil"></i></a>
				  <a href="" title="删除"><i class="icon-trash"></i></a>
				</blockquote>
				
				<div class="pagination pull-right">
				  <ul>
					<li><a href="#">Prev</a></li>
					<li class="active">
					  <a href="#">1</a>
					</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">Next</a></li>
				  </ul>
				</div>
				
				<div class="clear"></div>
			</div>
		</div>
	  </div>
	</div>
</body>
</html>