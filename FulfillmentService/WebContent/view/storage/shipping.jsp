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
<title>발주 / 출고 (출고)</title>
<link href="/FulfillmentService/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/_storage_top.jspf"%>
	<%@ include file="../common/_nav.jspf"%>
	<div class="container">
		<div class="row" style="margin-top: 70px">
			<div class="col-md-offset-1 col-md-11"><h3>출고</h3></div>
			<div class="col-md-12"><hr></div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-primary">
					<ul class="nav nav-tabs">
						  <li role="presentation" ><a href="../storage/order.jsp">발주</a></li>
						  <li role="presentation" class="active"><a href="">출고</a></li>
						</ul>
					<table class="table table-striped">
						<thead>
						<tr>
							<th>배송비</th>
							<th>운송회사ID</th>
							<th>송장ID</th>
							<th>이름</th>
							<th>번호</th>
							<th>주소</th>
							<th>제품명</th>
							<th>수량</th>
							<th>날짜</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th class="col-md-3"><input class="btn btn-primary btn-sm" type="button" value="청구"></th>
						</tr>
						
						</tbody>
					</table>
				</div>
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