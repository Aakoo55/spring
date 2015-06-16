<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.4/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="styles/common.css">
<title>Matches</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Matches</h3>
			</div>

			<div class="panel-body">

				<form action="matches" method="post">
					<c:if test="${not empty error}">
						<b style="color: red;"><c:out value="${error}"></c:out></b>
					</c:if>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th colspan="2">HOME</th>
								<th></th>
								<th colspan="2">AWAY</th>
								<th></th>
								<th>+/-</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${matches}" var="match">
								<tr>
									<td><c:out value="${match.id}" /></td>
									<td><c:out value="${match.home}" /></td>
									<td><c:out value="${match.homeGoals}" /></td>
									<td>-</td>
									<td><c:out value="${match.awayGoals}" /></td>
									<td><c:out value="${match.away}" /></td>
									<td><c:if test="${match.overtime}">ot</c:if></td>
									<td><a href="?delId=<c:out value="${match.id}"></c:out>"
										class="btn btn-danger"><span
											class="glyphicon glyphicon-minus" aria-hidden="true"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td style="vertical-align: middle;">ADD</td>
								<td><input type="text" name="home" placeholder="Home..."
									class="form-control" /></td>
								<td><input type="number" name="homeGoals" value="0"
									class="form-control" /></td>
								<td>-</td>
								<td><input type="number" name="awayGoals" value="0"
									class="form-control" /></td>
								<td><input type="text" name="away" placeholder="Away..."
									class="form-control" /></td>
								<td>
									<div class="checkbox">
										<label> <input type="checkbox" name="overtime"
											value="true"></input>
										</label>
									</div>
								</td>
								<td><button type="submit" class="btn btn-success">
										<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									</button></td>
							</tr>
						</tfoot>
					</table>

				</form>
			</div>
		</div>
	</div>
</body>
</html>