<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Portfolio by User</title>
</head>
<body>
 
<h2>Portfolio</h2>


<c:if  test="${!empty portfoliolist}">
<table class="data">
<tr>
    <th>Name</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${portfoliolist}" var="portfolio">
    <tr>
        <td>${portfolio.name}, ${portfolio.description} </td>
      
        <td><a href="portfolio/delete/${portfolio.portfolioId}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>