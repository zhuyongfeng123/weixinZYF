<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借阅列表</title>
<style type="text/css">
	.item:hover{
		background-color: #aaa;
	}
</style>
</head>
<body>
	<c:forEach items="${debitList.items }" var="item">
	<div class="item">
		${item.book.name }
		<a href="/kemao_3/library/debit/remove/${item.book.id }" style="float: right;">删除</a>
	</div>
	</c:forEach>
</body>
</html>