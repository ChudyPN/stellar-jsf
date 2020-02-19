<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<table>
    <tr>
        <th>Name</th>
        <th>Star</th>
    </tr>

    <c:forEach items="${systems}" var="system">
        <tr>
            <td><a href="./planets?systemId=${system.id}">${system.name}</a></td>
            <td><c:out value="${fn:toUpperCase(system.star)}"/></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="footer.jsp"/>
