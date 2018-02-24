<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AccessDenied page</title>

    <link rel="stylesheet"
          href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet"
          href="<c:url value="/resources/css/app.css" />">
</head>
<body>
<div class="generic-container">
    <div>
        <span>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</span> <span
            class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
    </div>
</div>
</body>

<script type="text/javascript"
        src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
        src="<c:url value="/resources/js/app.js" />"></script>

</html>