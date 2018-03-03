<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="welcome.jsp" />
<div class="container" style="padding-top:100px;">

        <form:form method="POST" modelAttribute="userProfileForm" class="form-signin">
            <form:hidden path="id" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

             <spring:bind path="username">

                  <div class="form-group ${status.error ? 'has-error' : ''}">
                  <label class="control-label" for="username">Username</label>
                      <form:input type="text" path="username" class="form-control" placeholder="Username"
                                  autofocus="true"></form:input>
                      <form:errors path="username"></form:errors>
                  </div>
              </spring:bind>


              <spring:bind path="firstname">

                  <div class="form-group ${status.error ? 'has-error' : ''}">
                  <label class="control-label" for="firstname">First Name</label>
                      <form:input type="text" path="firstname" class="form-control" placeholder="Firstname"></form:input>
                      <form:errors path="firstname"></form:errors>
                  </div>
              </spring:bind>

              <spring:bind path="lastname">

                        <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="control-label" for="lastname">Last Name</label>
                            <form:input type="text" path="lastname" class="form-control" placeholder="Lastname"></form:input>
                            <form:errors path="lastname"></form:errors>
                        </div>
                </spring:bind>


              <spring:bind path="email">

                  <div class="form-group ${status.error ? 'has-error' : ''}">
                  <label class="control-label" for="email">Email</label>
                      <form:input type="email" path="email" class="form-control"
                                  placeholder="Email"></form:input>
                      <form:errors path="email"></form:errors>
                  </div>
              </spring:bind>


           <button class="btn btn-lg btn-primary btn-block" type="submit">Update details</button>


       </form:form>
       <h4 class="text-center"><a href="${contextPath}/password">change password</a></h4>

</div>

<script>
window.onload=function() {
           jQuery('.nav li').removeClass('active');
           jQuery("#uprofile").addClass('active');
            document.getElementById("logoutId").onclick=function() {
                    document.getElementById("logoutForm").submit();
                    return false;
                  }
}
</script>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>