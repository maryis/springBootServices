<%--
    Created by IntelliJ IDEA.
    User: ${USER}
Date: ${DATE}
    Time: ${TIME}
        To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>welcome</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/register" class="form-control">
       <c:if test="${pageContext.request.userPrincipal.name != null}">
           <h2 class="text-center text-danger" type="">
               Welcome ${pageContext.request.userPrincipal.name}
               <a href="/logout" >logout</a>
           </h2>
       </c:if>
    </form>
</div>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
