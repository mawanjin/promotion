<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/meta.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="../../css/discount.css" />

<title>优惠促销</title>
<style>
	
</style>
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

<!-- 左上角：优惠促销 -->
<div><h1>优惠促销</h1></div>


<!-- 类别 -->
<div style="text-align:center;width:1280px;">
<table width=100%>
	<tr>
		<td width="25%"></td>
		<td>
			<c:forEach var="c" items="${ category}">
			<a href="${ctx}/index?method=category&id=${c.id }" >${c.name }</a>
			</c:forEach>
		</td>
		<td width="25%"></td>
	</tr>
</table>
</div>

<!-- 左侧内容 -->
<div style="position:absolute;left:10px;top:100px;width:600px;height:600px;border:1px solid red;padding:5px 2px 5px 5px;">
	
	<table width="100%" height=100%>
		<tr>
			<!-- 海报 -->
			<td width=45%>
				<c:forEach var="pic" items="${hot.mhpromotionPics }">
					
					<c:if test="${pic.type eq 1}">
						${pic.id.pic }	
					</c:if>
					
				</c:forEach>
			</td>
			<!-- 简介 -->
			<td>
				<table width=100% height=100% border=1>
					<tr>
						<td>${hot.title}</td>
					</tr>
					<tr>
						<td height=90%>${hot.summary}</td>
					</tr>
					<tr>
						<td><a href="${ctx}/detail?type=hot&id=${hot.id }&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }">查看详情</a></td>
					</tr>
				</table>
				
			</td>
		</tr>
	</table>
</div>

<!-- 右侧内容 -->
<div style="position:absolute;left:600px;top:100px;width:600px;height:600px;border:1px solid blue;padding:5px 2px 5px 5px;">

	<table width=100% height=100%>
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<!-- 图片 -->
							<c:forEach var="online" items="${rs.page.list}"  end="0"> 
								<c:forEach var="pic" items="${online.mhpromotion.mhpromotionPics }">
									<c:if test="${pic.type eq 2 }">${pic.id.pic }</c:if>
								</c:forEach>
							</c:forEach>
						</td>
						<td>
							<!-- 内容 -->
							<table>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}" end="0">
											${online.mhpromotion.title }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  end="0">
											${online.mhpromotion.summary }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  end="0">
											<a href="${ctx}/detail?&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${((rs.page.pageNo-1)*rs.page.pageSize)}">查看详情</a>
										</c:forEach>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<!-- 第一行第二列 -->
			<td>
				<table>
					<tr>
						<td>
							<!-- 图片 -->
							<c:forEach var="online" items="${rs.page.list}"  begin="1" end="1">
								<c:forEach var="pic" items="${online.mhpromotion.mhpromotionPics }">
									<c:if test="${pic.type eq 2 }">${pic.id.pic }</c:if>
								</c:forEach>
							</c:forEach>
						</td>
						<td>
							<!-- 内容 -->
							<table>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}" begin="1" end="1">
											${online.mhpromotion.title }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="1" end="1">
											${online.mhpromotion.summary }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="1" end="1">
											<a href="${ctx}/detail?&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${1+((rs.page.pageNo-1)*rs.page.pageSize)}">查看详情</a>
										</c:forEach>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 第二行 -->
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<!-- 图片 -->
							<c:forEach var="online" items="${rs.page.list}"  begin="2" end="2">
								<c:forEach var="pic" items="${online.mhpromotion.mhpromotionPics }">
									<c:if test="${pic.type eq 2 }">${pic.id.pic }</c:if>
								</c:forEach>
							</c:forEach>
						</td>
						<td>
							<!-- 内容 -->
							<table>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}" begin="2" end="2">
											${online.mhpromotion.title }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="2" end="2">
											${online.mhpromotion.summary }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="2" end="2">
											<a href="${ctx}/detail?&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${2+((rs.page.pageNo-1)*rs.page.pageSize)}">查看详情</a>
										</c:forEach>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<!-- 第二行第二列 -->
			<td>
				<table>
					<tr>
						<td>
							<!-- 图片 -->
							<c:forEach var="online" items="${rs.page.list}"  begin="3" end="3">
								<c:forEach var="pic" items="${online.mhpromotion.mhpromotionPics }">
									<c:if test="${pic.type eq 2 }">${pic.id.pic }</c:if>
								</c:forEach>
							</c:forEach>
						</td>
						<td>
							<!-- 内容 -->
							<table>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}" begin="3" end="3">
											${online.mhpromotion.title }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="3" end="3">
											${online.mhpromotion.summary }
										</c:forEach>
									</td>
								</tr>
								<tr>
									<td>
										<c:forEach var="online" items="${rs.page.list}"  begin="3" end="3">
											<a href="${ctx}/detail?&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${3+((rs.page.pageNo-1)*rs.page.pageSize)}">查看详情</a>
										</c:forEach>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
	</table>
	
</div>
<!-- 
<c:forEach var="online" items="${rs.page.list}" varStatus="sta">
	图片:
	<c:forEach var="pic" items="${online.mhpromotion.mhpromotionPics }">
		${pic.id.pic }
	</c:forEach>
	
	<br/>
	<a href="${ctx}/detail?&cid=${cid}&count=${rs.page.count}&pageCount=${rs.page.pageCount }&pageNo=${rs.page.pageNo }&pageSize=${rs.page.pageSize }&index=${sta.index+((rs.page.pageNo-1)*rs.page.pageSize)}">标题：${online.mhpromotion.title }</a>
	<br/>
	简介:${online.mhpromotion.summary }
	<br/>
	<a href="${ctx}/detail?id=${online.mhpromotion.id }">detail</a>
	
</c:forEach>
 -->


<!-- 底部 -->
<div style="position:absolute;top:700px;border:1px solid yellow;">
	



<!-- 分页参数  -->
<input type="hidden" id="pageNo" name="pageNo" value="${rs.page.pageNo }" />
<input type="hidden" id="pageSize" name="pageSize" value="${rs.page.pageSize }" />
<input type="hidden" id="pageCount" name="pageCount" value="${rs.page.pageCount }" />

pageNo:${rs.page.pageNo }
<br>
pageSize:${rs.page.pageSize }
<br>
pageCount:${rs.page.pageCount }
<br>
count:${rs.page.count }


<c:if test="${rs.page.hasPre }">
	<a href="javascript:pre();" >上一页</a>
</c:if>

<c:if test="${rs.page.hasNext }">
	<a href="javascript:nxt();" >下一页</a>
</c:if>
</div>
</body>
</html>