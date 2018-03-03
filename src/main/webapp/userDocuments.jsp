<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>uploadfile</title>

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


   <table class="table table-hover">
       <thead>
         <tr>
           <th>S.No</th>
           <th>Title</th>
           <th>Uploaded At</th>
           <th>Profiling Status</th>
           <th>Keywords</th>
           <th>Action</th>
         </tr>
       </thead>
       <tbody>

       <c:forEach var="userDoc" items="${userDocuments}" varStatus="document">
                <tr>
                  <td>${document.index+1}</td>
                  <td>${userDoc.documentTitle}</td>
                  <td>${userDoc.uploadedAt}</td>
                  <td>${userDoc.profilingDone}</td>
                  <td>${userDoc.keywords}</td>
                  <td><a href="${contextPath}/viewDoc/${userDoc.id}">View</a></td>
                </tr>
           </c:forEach>

       </tbody>
     </table>

</div>

<script>
window.onload=function() {
    jQuery('.nav li').removeClass('active');
    jQuery("#mdocs").addClass('active');

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


