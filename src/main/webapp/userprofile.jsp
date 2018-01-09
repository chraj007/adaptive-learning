<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UserProfile</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="userProfile" method="POST" modelAttribute="userprofile" action="${contextPath}/userprofile">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>${pageContext.request.userPrincipal.name}</h2><br>

         <h4 class="text-center"><a href="${contextPath}/password">change password</a></h4>
         <spring:bind path="password">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                         <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                         <form:errors path="password"></form:errors>
                     </div>
                 </spring:bind>

                 <spring:bind path="passwordConfirm">
                     <div class="form-group ${status.error ? 'has-error' : ''}">
                         <form:input type="password" path="passwordConfirm" class="form-control"
                                     placeholder="Confirm your password"></form:input>
                         <form:errors path="passwordConfirm"></form:errors>
                     </div>
                 </spring:bind>
                 <spring:bind path="email">
                                 <div class="form-group ${status.error ? 'has-error' : ''}">
                                     <form:input type="email" path="email" class="form-control"
                                                 placeholder="email"></form:input>
                                     <form:errors path="email"></form:errors>
                                 </div>
                 </spring:bind>
         <h4 class="text-center"><a href="${contextPath}/filelist">view list of Files</a></h4>
         <h4 class="text-center"><a href="${contextPath}/changelstyle">Change Learning styles</a></h4>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>