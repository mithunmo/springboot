<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<title><tiles:importAttribute name="title" /><spring:message code="${title}" /></title>
   	<link rel="stylesheet" href="/css/ver3/cb.css"> <!-- In our static file structure, all css files laction will be /css/ver3/... -->
</head>

<body>
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	<div class="wrap">
		<tiles:insertAttribute name="button"></tiles:insertAttribute>
	</div>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>