<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/resources/slideunlock/slide-unlock.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/slideunlock/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/slideunlock/jquery.slideunlock.js"></script>
<style>
html, body, h1 {
	margin: 0;
	padding: 0;
}

body {
	background-color: #393939;
	color: #d5d4ff;
	overflow: hidden
}

#demo {
	width: 600px;
	margin: 150px auto;
	padding: 10px;
	border: 1px dashed #d5d4ff;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	text-align: left;
}
</style>
<script>
$(function() {
	var slider = new SliderUnlock("#slider", {
		successLabelTip : "欢迎访问素材家园"
	}, function() {
		alert("验证成功,即将跳转至素材家园首页");
		window.location.href = "http://www.sucaijiayuan.com"
	});
	slider.init();
})		
</script>
</head>
<body>
		<div id="slider">
			<div id="slider_bg">验证:</div>
			<span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
		</div>
		
		
</body>
</html>