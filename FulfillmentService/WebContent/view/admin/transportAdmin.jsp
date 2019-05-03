<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
label {
	margin-top: 3%;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ==================================================================== -->
<title>transportAdmin.jsp</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/_transport_top.jspf"%>
	<%@ include file="../common/_nav.jspf"%>
	<div class="container">
		<div class="row" style="margin-top: 80px">
			<div class="col-md-offset-1 col-md-6">
				<h3><i class="glyphicon glyphicon-list-alt"></i>&nbsp;송장 내역 조회</h3>
			</div>
			<div class="col-md-5">
				<form action="#" class="form-horizontal" method="post">
					<div class="form-group">
						<label class="control-label">검색:&nbsp;&nbsp;</label> <input
							type="text" name="search"  id="search1" placeholder="검색할 내용을 입력하세요" >&nbsp;&nbsp; 
							<input class="btn btn-primary btn-sm" type="submit" value="검색">
					</div>
				</form>
			</div>
			<div class="col-md-12">
				<hr>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<thead>
							<th class="col-md-2" style="text-align: center;">고객명</th>
							<th class="col-md-2" style="text-align: center;">전화번호</th>
							<th class="col-md-2" style="text-align: center;">주소</th>
							<th class="col-md-2" style="text-align: center;">제품코드</th>
							<th class="col-md-2" style="text-align: center;">제품명</th>
							<th class="col-md-2" style="text-align: center;">수량</th>
						</thead>
				 	<%-- <tbody>
					    <c:set var="dsList" value="${requestScope.dailySalesList}"/>
						<c:forEach var="dsDto" items="${dsList}">
						<tr>
							<td align="center">${}</td>
							<td align="center">${}</td>
							<td align="center">${}</td>
							<td align="center">${}</td>
							<td align="center">${}</td>
							<td align="center">${}</td>
						</tr>
						</c:forEach>
						</tbody> --%>
					</table>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
	<%@ include file="../common/_bottom.jspf"%>
	<!-- ==================================================================== -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>