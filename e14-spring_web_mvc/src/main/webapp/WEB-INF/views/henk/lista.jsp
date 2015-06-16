<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Henkilölista näyttäminen</title>
<link rel="stylesheet" type="text/css"
	href="../resources/styles/common.css">
</head>
<body>
	<h1>Henkilölistaus</h1>
	<div style="display: table;">
		<c:forEach items="${henkilot}" var="henkilo">
			<div style="display: table-row;">
				<div style="display: table-cell;">
					<c:out value="${henkilo.etunimi}" default="-----" />
				</div>
				<div style="display: table-cell;">
					<c:out value="${henkilo.sukunimi}" default="-----" />
				</div>
			</div>
		</c:forEach>
	</div>
	<a href="uusi">Takaisin</a>
</body>
</html>