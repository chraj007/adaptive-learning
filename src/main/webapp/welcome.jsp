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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <img id="logo-main" src="${contextPath}/images/al_logo.png" width="200" height="100px" alt="Logo Thing main logo">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="${contextPath}/userprofile">User Profile</a></li>
      <li><a href="${contextPath}/questionnaire">Questionnaire</a></li>
      <li><a href="${contextPath}/upload">Upload File</a></li>
      <li><a class="active" href="${contextPath}/list_documents">My Documents</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a id ="logoutId" href=""><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
       <form id="logoutForm" method="POST" action="${contextPath}/logout">
                  <input class="glyphicon glyphicon-log-in" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </form>
    </ul>
  </div>
</nav>





<script>
window.onload=function() {
   document.getElementById("logoutId").onclick=function() {
     document.getElementById("logoutForm").submit();
     return false;
   }
 }
</script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
