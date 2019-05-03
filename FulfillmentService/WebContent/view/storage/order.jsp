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
<title>발주 / 출고 (발주)</title>
<link href="/FulfillmentService/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/_storage_top.jspf"%>
	<%@ include file="../common/_nav.jspf"%>
	<div class="container">
		<div class="row" style="margin-top: 70px">
			<div class="col-md-offset-1 col-md-11">
				<h3>발주</h3>
			</div>
			<div class="col-md-12">
				<hr>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-primary">
					<ul class="nav nav-tabs">
						<li role="presentation" class="active"><a href="#">발주</a></li>
						<li role="presentation"><a href="../storage/shipping.jsp">출고</a></li>
					</ul>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>날짜</th>
								<th>구매처ID</th>
								<th>제품ID</th>
								<th>수량</th>
								<th>물품가격</th>
								<th>총가격</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>(물품명)</th>
								<th>(가격)</th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th>
									<input type="button" value="발주" action="#">&nbsp;&nbsp;
									&nbsp;&nbsp;<input type="reset" value="취소">
								</th>
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