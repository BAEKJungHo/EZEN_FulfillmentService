<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ==================================================================== -->
<title>판매내역 조회</title>
<link href="/FulfillmentService/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/_storage_top.jspf"%>
	<%@ include file="../common/_nav.jspf"%>
	<div class="container">
		<div class="row" style="margin-top: 70px">
			<div class="col-md-offset-1 col-md-11">
				<h3>판매내역 조회</h3></div>
			<div class="col-md-12"><hr>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-primary">
					<table class="table table-striped">
						<thead>
						<tr>
							<th>제품명</th>
							<th>수량</th>
							<th>날짜</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<th>(제품명)</th>
							<th>(수량ID)</th>
							<th>(날짜)</th>
						</tr>
						</tbody>
					</table>
				<div class="col-md-3"></div>
			</div>
		</div>
	</div>
	<%@ include file="../common/_bottom.jspf"%>
	<!-- ==================================================================== -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="/FulfillmentService/js/bootstrap.min.js"></script>
</body>
</html>