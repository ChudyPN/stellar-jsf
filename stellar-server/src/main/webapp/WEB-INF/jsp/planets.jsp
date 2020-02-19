<%@ page import="lab.stellar.entities.Planet" %>
<%@ page import="lab.stellar.entities.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <jsp:include page="header.jsp"/>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        <c:forEach items="${planets.items}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
        </tr>
        </c:forEach>

        <tr>
            <td colspan="2">
                <c:forEach var="i" begin="1" end="${planets.pageCount}">
                    <c:choose>
                        <c:when test="${planets.pageNo eq i}">
                            ${i}
                        </c:when>
                        <c:otherwise>
                            <a href="./planets?systemId=${param.systemId}&pageNo=${i}">
                                    ${i}
                            </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>

    </table>


    <jsp:include page="footer.jsp"/>
