<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<%-- <jsp:include flush="false" page="menu.jsp" /> --%>
	<h2>Home page ${user.name}</h2>
	<form action="<c:url value="/getdata"/>" method="post">
	    <input type="submit" value="<spring:message code='label.getdata'/>">
	</form>
</body>
</html>
