<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/meta.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>优惠促销</title>

<script>
	function init(){
	}
	
	function nxt(){
		var pageNo = parseInt(document.getElementById("pageNo").value);
		pageNo = pageNo+1;
		if(pageNo>document.getElementById("pageCount").value){
			pageNo = document.getElementById("pageCount").value;
		}
		window.location.href="${ctx}/index?pageNo="+pageNo+"&cid=${cid}";
	}
	
	function pre(){
		var pageNo = parseInt(document.getElementById("pageNo").value);
		pageNo = pageNo-1;
		if(pageNo<0){
			pageNo = 1;
		}
		
		window.location.href="${ctx}/index?pageNo="+pageNo+"&cid=${cid}";
	}
</script>

</head>
<body onload="init()">

<h1>优惠促销</h1>

<!-- 类别 -->
<div style="text-align:center;width:1280px;">
<c:forEach var="c" items="${ category}">
	<a href="${ctx}/index?method=category&id=${c.id }" >${c.name }</a>
</c:forEach>
</div>

<!-- 优惠详情 -->

<div id="left" style="position:absolute;lef:10px;top:100px;border:1px solid red;">

<table>
	<tr>
		<td>
			<!-- 图片 -->
		</td>
		<td>
			<!-- 标题 -->
			<!-- 内容 -->
		</td>
	</tr>
</table>
<br>now
<br>
id=${rs.now.id}
title=${rs.now.title}
pageno=${rs.page.pageNo} 
${isFirst }
</div>

<br>

<c:if test="${not empty rs.pre}">
	<c:choose>
		<c:when test="${isFirst }">
			<a href="${ctx}/detail?type=hot&id=${rs.pre.id}&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${rs.preIndex}">上一页[${rs.pre.id}:${rs.pre.title}]</a>
		</c:when>
		<c:otherwise>
			<a href="${ctx}/detail?cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${rs.preIndex}">上一页[${rs.pre.id}:${rs.pre.title}]</a>
		</c:otherwise>
	</c:choose>
	
</c:if>

<c:if test="${not empty rs.nxt }">
	<a href="${ctx}/detail?cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${rs.nxtIndex}">下一页[${rs.nxt.id}:${rs.nxt.title}]</a>
</c:if>

</body>
</html>