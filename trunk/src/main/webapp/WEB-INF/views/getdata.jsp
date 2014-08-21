<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Get Data page</title>
</head>
<body>
	<div style="color: red;">${error}</div>
	<table>
		<c:forEach var="data" items="${dataList}">
			<tr>
				<td>${data.id}</td>
				<td>${data.data}</td>
				<td>${data.recordCreatedDate}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="<c:url value="/"/>" method="post">
	    <input type="submit" value="<spring:message code='label.startagain'/>">
	</form>
</body>
</html>
