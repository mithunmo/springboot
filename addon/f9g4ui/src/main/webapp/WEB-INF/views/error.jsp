<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=1050, maximum-scale=1.5, user-scalable=1" />
		<meta http-equiv="refresh" content="0;url=/" />
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
<body>
	<div class="middle" style="height:auto;">
		<h3>One of our back end system is currently unavailable please try again after sometime.</h3>
		<a href="javascript:void(0);" onclick="history.back();">Click here to previous page</a>
	</div>
</body>
</html>