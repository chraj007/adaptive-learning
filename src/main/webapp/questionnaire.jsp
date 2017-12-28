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

    <title>Questionnaire</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="questionnaireForm" class="form-signin">
        <h2 class="form-signin-radio">Questionnaire</h2>
        <spring:bind path="q1">
            <div class="form-group ${status.error ? 'has-error' : ''}"
                <form:input type="radio" path="q1" class="form-control">Question1</form:input>

            </div>
        </spring:bind>

        <spring:bind path="q2">
            <div class="radio ${status.error ? 'has-error' : ''}">
                <form:input type="radio" path="q2" class="form-control">Question2</form:input>

            </div>
        </spring:bind>

        <spring:bind path="q3">
                    <div class="radio ${status.error ? 'has-error' : ''}">
                        <form:input type="radio" path="q3" class="form-control" >Question3</form:input>

                    </div>
                </spring:bind>


        <spring:bind path="q4">
            <div class="radio ${status.error ? 'has-error' : ''}">
                <form:input type="radio" path="q4" class="form-control">Question4</form:input>

            </div>
        </spring:bind>

        <spring:bind path="q5">
            <div class="radio ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="q5" class="form-control">Question5</form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

      <spring:bind path="q6">
                <div class="radio ${status.error ? 'has-error' : ''}">
                    <form:input type="radio" name="q6" class="form-control">
                               Question6 </form:input>

                </div>
            </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
