<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<!-- <link rel="stylesheet" type="text/css" href="css/index.css">  -->
	<link rel="stylesheet" type="text/css" href="css/list.css">
	<script src="js/jquery.1.7.2.min.js"></script>
	<script src="js/jquery.img_silder.js"></script>
	<script>
	        $(function(){
	            $('#silder').imgSilder({
					s_width:'100%', //容器宽度
					s_height:180, //容器高度
					is_showTit:true, // 是否显示图片标题 false :不显示，true :显示
					s_times:3000, //设置滚动时间
					css_link:'css/style.css'
				});
			});
    </script>
</head>
<body>
	<!-- 图片轮播 -->
	<div id="banner_button" style="width:95%;">
		<div id="banner_top" style="width:100%;text-align:center;padding-top:15px;padding-bottom:15px;">
			<button style="width:28%;">周边旅游</button>
			<button style="width:28%;">国内旅游</button>
			<button style="width:28%;">国际旅游</button>
		</div>
		<div id="banner_bottom" style="width:100%;margin-bottom:20px;">
			<input type="text" placeholder="请输入您想要的目的地" style="width:100%;"></input>
		</div>
	</div>
	<!-- 列表项 -->
	<div id="list_container" style="width:95%;">
		
	<c:forEach items="${list}" var="cell"> 
			<table>
			<tr>	
				<td style="width:40%;text-align:center;" rowspan="3"><img src="${cell.suoluetu }" width="100%" height="120px"></td>
				<td style="text-align:center;" colspan="2">${cell.name }</td>
			</tr>
			<tr>
				<td style="width:30%;text-align:center;">任意时间</td>
				<td style="width:30%;text-align:center;">${cell.price }</td>
			</tr>
			<tr>	
				<td style="text-align:center;" colspan="2"><a href="getdetail?type=${cell.type}&id=${cell.id}">查看详情</a></td>
			</tr>
		</table>
	</c:forEach> 
	
	</div>

</body>
</html>