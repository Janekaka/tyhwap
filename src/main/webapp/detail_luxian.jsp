<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<title>detail</title>
	<link rel="stylesheet" type="text/css" href="css/detail.css">
</head>
<body>
	<div id="zssss"></div>
	<div id="detail_top">
		<a href="javascript: history.go(-1)"><img id="co1" src="images/detail_back.png"></a>
		<a href="#"><img id="co2" src="${item.suoluetu}"></a>
	</div>
	<div id="detail_introduce">
		<img src="images/detail_con.png"><h4>【路线详情页】${item.name}</h4>
		<p>${item.jianjie}</p>
		<span>仅售：<em>￥${item.price}</em></span>
	</div>
	<div id="detail_cont">
		<div id="tab-list">
		    <ul id="ul1">
		        <li class="active">路线特色</li><li>路线行程</li><li>预定须知</li><li>注意事项</li>
		    </ul>
		    <div>
		        <p>${item.introduction}</p>
		    </div>    
		    <div class="hide">
		        <p>${item.details}</p>
		    </div>    
		    <div class="hide">
		        <p>${item.notice}</p>
		    </div>
		    <div class="hide">
		        <p>${item.process}</p>
		    </div>
		</div>
		<script type="text/javascript">
			    window.onload = function() {
			        var oUl1 = document.getElementById("ul1");
			        var aLi = oUl1.getElementsByTagName("li");
			        var oDiv = document.getElementById("tab-list");
			        var aDiv = oDiv.getElementsByTagName("div");
			        for(var i = 0; i < aLi.length; i++) {
			            aLi[i].index = i;
			            aLi[i].onmouseover = function() {
			                for(var i = 0; i < aLi.length; i++) {
			                    aLi[i].className = "";
			                }
			                this.className = "active";
			                for(var j = 0; j < aDiv.length; j++) {
			                    aDiv[j].className = "hide";
			                }
			                aDiv[this.index].className = "show";
			            }        
			        }
			    }
   		</script>
	</div>
	<div id="detail_yuding">
		<ul>
			<li id="yd_1"><a href="kefu.html">客 服</a></li>
			<li id="yd_2"><a href="yuding.html?type=${item.type}&id=${item.id} ">立即预定</a></li>
		</ul>
	</div>
</body>
</html>