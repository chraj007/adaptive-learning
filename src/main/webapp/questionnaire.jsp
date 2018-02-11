<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
<jsp:include page="welcome.jsp" />

<div class="container">
<span>${message}</span>

    <form:form method="POST" modelAttribute="questionnaireForm" class="form-signin">
    <form:hidden path="id" />

        <h2 class="form-signin-radio">Questionnaire</h2>
        <spring:bind path="q1">
                    <div class="form-group ">
                    <p>Q1.I have strong beliefs about what is right and wrong, good and bad.</p>
                       <form:radiobutton path="q1" value="Yes"/>Yes
                       <form:radiobutton path="q1" value="No"/>No
                    </div>
                </spring:bind>

        <spring:bind path="q2">
                <div class="form-group">
                <p>Q2.I often act without considering the possible consequences. </p>
                    <form:radiobutton path="q2" value="Yes"/>Yes
                    <form:radiobutton path="q2" value="No"/>No
                    </div>
          </spring:bind>

          <spring:bind path="q3">
                          <div class="form-group">
                          <p>Q3.I tend to solve problems using a step-by-step approach. </p>
                              <form:radiobutton path="q3" value="Yes"/>Yes
                              <form:radiobutton path="q3" value="No"/>No
                              </div>
                    </spring:bind>

     <spring:bind path="q4">
       <div class="form-group ">
           <p>Q4.I believe that formal procedures and policies restrict people. </p>
                  <form:radiobutton path="q4" value="Yes"/>Yes
                  <form:radiobutton path="q4" value="No"/>No
          </div>
     </spring:bind>

        <spring:bind path="q5">
          <div class="form-group">
          <p>Q5.I have a reputation for saying what I think, simply and directly. </p>
              <form:radiobutton path="q5" value="Yes"/>Yes
              <form:radiobutton path="q5" value="No"/>No
              </div>
                       </spring:bind>
           <spring:bind path="q6">
                   <div class="form-group">
                      <p>Q6.I often find that actions based on feelings are as sound as those based on careful thought and analysis.</p>
                         <form:radiobutton path="q6" value="Yes"/>Yes
                             <form:radiobutton path="q6" value="No"/>No
                             </div>
            </spring:bind>
            <spring:bind path="q7">
                    <div class="form-group ">
                    <p>Q7.I like the sort of work where I have time for thorough preparation and
                          implementation. </p>
                    <form:radiobutton path="q7" value="Yes"/>Yes
                    <form:radiobutton path="q7" value="No"/>No
                    </div>
             </spring:bind>
            <spring:bind path="q8">
                    <div class="form-group ">
                    <p>Q8.I regularly question people about their basic assumptions. </p>
                    <form:radiobutton path="q8" value="Yes"/>Yes
                    <form:radiobutton path="q8" value="No"/>No
                    </div>
              </spring:bind>
            <spring:bind path="q9">
                    <div class="form-group ">
                    <p>Q9.What matters most is whether something works in practice.</p>
                    <form:radiobutton path="q9" value="Yes"/>Yes
                    <form:radiobutton path="q9" value="No"/>No
                    </div>
             </spring:bind>
        <spring:bind path="q10">
            <div class="form-group ">
            <p>Q10.I actively seek out new experiences.</p>
            <form:radiobutton path="q10" value="Yes"/>Yes
            <form:radiobutton path="q10" value="No"/>No
               </div>
         </spring:bind>
        <spring:bind path="q11">
            <div class="form-group ">
            <p>Q11.When I hear about a new idea or approach I immediately start working out how to
                   apply it in practice.</p>
            <form:radiobutton path="q11" value="Yes"/>Yes
            <form:radiobutton path="q11" value="No"/>No
            </div>
            </spring:bind>
        <spring:bind path="q12">
            <div class="form-group ">
            <p>Q12.I am keen on self-discipline such as watching my diet, taking regular exercise,
                   sticking to a fixed routine, etc. </p>
            <form:radiobutton path="q12" value="Yes"/>Yes
            <form:radiobutton path="q12" value="No"/>No
            </div>
            </spring:bind>
        <spring:bind path="q13">
            <div class="form-group ">
            <p>Q13.I take pride in doing a thorough job.</p>
            <form:radiobutton path="q13" value="Yes"/>Yes
            <form:radiobutton path="q13" value="No"/>No
            </div>
        </spring:bind>
        <spring:bind path="q14">
            <div class="form-group ">
            <p>Q14.I get on best with logical, analytical people and less well with spontaneous
                   ‘irrational’ people. </p>
            <form:radiobutton path="q14" value="Yes"/>Yes
            <form:radiobutton path="q14" value="No"/>No
            </div>
         </spring:bind>
        <spring:bind path="q15">
            <div class="form-group ">
            <p>Q15.I take care over the interpretation of data available to me and avoid jumping to
                   conclusions.</p>
            <form:radiobutton path="q15" value="Yes"/>Yes
            <form:radiobutton path="q15" value="No"/>No
            </div>
        </spring:bind>
        <spring:bind path="q16">
            <div class="form-group ">
            <p>Q16.I have strong beliefs about what is right and wrong, good and bad.</p>
            <form:radiobutton path="q16" value="Yes"/>Yes
            <form:radiobutton path="q16" value="No"/>No
            </div>
        </spring:bind>
         <spring:bind path="q17">
            <div class="form-group ">
            <p>Q17.I have strong beliefs about what is right and wrong, good and bad.</p>
            <form:radiobutton path="q17" value="Yes"/>Yes
            <form:radiobutton path="q17" value="No"/>No
            </div>
            </spring:bind>
         <spring:bind path="q18">
            <div class="form-group ">
            <p>Q18.I have strong beliefs about what is right and wrong, good and bad.</p>
            <form:radiobutton path="q18" value="Yes"/>Yes
            <form:radiobutton path="q18" value="No"/>No
            </div>
         </spring:bind>
         <spring:bind path="q19">
            <div class="form-group ">
            <p>Q19.I have strong beliefs about what is right and wrong, good and bad.</p>
            <form:radiobutton path="q19" value="Yes"/>Yes
            <form:radiobutton path="q19" value="No"/>No
            </div>
         </spring:bind>
         <spring:bind path="q20">
            <div class="form-group ">
            <p>Q20.I have strong beliefs about what is right and wrong, good and bad.</p>
            <form:radiobutton path="q20" value="Yes"/>Yes
            <form:radiobutton path="q20" value="No"/>No
            </div>
         </spring:bind>
        <spring:bind path="q21">
            <div class="form-group ">
            <p>Q21.I have strong beliefs about what is right and wrong, good and bad.</p>
                <form:radiobutton path="q21" value="Yes"/>Yes
                <form:radiobutton path="q21" value="No"/>No
            </div>
    </spring:bind>
    <spring:bind path="q22">
            <div class="form-group ">
            <p>Q22.I have strong beliefs about what is right and wrong, good and bad.</p>
               <form:radiobutton path="q22" value="Yes"/>Yes
               <form:radiobutton path="q22" value="No"/>No
            </div>
    </spring:bind>
    < spring:bind path="q23">
                    <div class="form-group ">
                    <p>Q23.I have strong beliefs about what is right and wrong, good and bad.</p>
                       <form:radiobutton path="q23" value="Yes"/>Yes
                       <form:radiobutton path="q23" value="No"/>No
                    </div>
                </spring:bind>
    <spring:bind path="q24">
                <div class="form-group ">
                <p>Q24.I have strong beliefs about what is right and wrong, good and bad.</p>
                   <form:radiobutton path="q24" value="Yes"/>Yes
                   <form:radiobutton path="q24" value="No"/>No
                </div>
            </spring:bind>
        <spring:bind path="q25">
                    <div class="form-group ">
                    <p>Q25.I have strong beliefs about what is right and wrong, good and bad.</p>
                       <form:radiobutton path="q25" value="Yes"/>Yes
                       <form:radiobutton path="q25" value="No"/>No
                    </div>
                </spring:bind>
        <spring:bind path="q26">
                    <div class="form-group">
                    <p>Q26.I have strong beliefs about what is right and wrong, good and bad.</p>
                    <form:radiobutton path="q26" value="Yes"/>Yes
                     <form:radiobutton path="q26" value="No"/>No
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
