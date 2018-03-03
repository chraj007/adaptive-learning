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

<table width=100% height=100%>

<tr><td width=70%>
<object data='${contextPath}${userDocument.filePath}/${userDocument.documentTitle}#toolbar=1'
                         type='application/pdf'
                         width='100%'
                         height='700px'>
                     </object>

</td>
<td width=30%>




<ul class="nav nav-pills" align ="center">
  <li id="txtLi" class="active"><a href="javascript:void(0);" onclick="return showText();" id="textLink">Text Materials</a></li>
  <li id="vidLi"><a href="javascript:void(0);"  onclick="return showVideos();" id="videoLink">Video Material</a></li>
</ul>
<br/>
<br/>
<div id="txtRms" class="pre-scrollable" style="max-height: 75vh;">
        <ul>
       <c:forEach var="relDoc" items="${text}" varStatus="document">
                <li>
                  <a href="${relDoc.url}" target="_blank">${relDoc.title}</a>
                  <span class="text-truncate"><p style="font-size:12px;font-style:oblique;">${relDoc.description}</p></span>
                </li>
           </c:forEach>


      </ul>
      </div>

      <div id="videoRms" style="display:none;max-height: 75vh;" class="pre-scrollable">
        <ul>
             <c:forEach var="relDoc" items="${yt}" varStatus="document">
                      <li>
                        <a href="https://www.youtube.com/watch?v=${relDoc.url}" data-toggle="tooltip" title= "${relDoc.description}" target="_blank">${relDoc.title}</a>
                        <iframe width="300" height="150" src="https://www.youtube.com/embed/${relDoc.url}" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen=""></iframe>
                      </li>
                 </c:forEach>


            </ul>
      </div>
</td></tr>

</table>


<script>

    function showText() {
    document.getElementById("vidLi").classList.remove("active");
    document.getElementById("txtLi").classList.add("active");

        if(document.getElementById('txtRms').style.display=='none') {
            document.getElementById('txtRms').style.display='block';
             document.getElementById('videoRms').style.display='none';
        }
        return false;
    }
    function showVideos() {
    document.getElementById("txtLi").classList.remove("active");
    document.getElementById("vidLi").classList.add("active");
        if(document.getElementById('videoRms').style.display=='none') {
            document.getElementById('videoRms').style.display='block';
            document.getElementById('txtRms').style.display='none';
        }
        return false;
    }

   window.onload=function() {
       jQuery('.nav li').removeClass('active');
       jQuery("#mdocs").addClass('active');
        document.getElementById("txtLi").classList.add("active");
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


