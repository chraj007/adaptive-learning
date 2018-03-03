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

        <div class="container" style="padding-top:100px;">

            <form:form method="POST" modelAttribute="questionnaireForm" class="form">
            <form:hidden path="id" />

            <p>
                This questionnaire is designed to find out your preferred learning style(s). Over the years you have probably developed learning "habits" that help you benefit more from some experiences than from others. Since you are probably unaware of this, this questionnaire will help you pinpoint your learning preferences so that you are in a better position to select learning experiences that suit your style and having a greater understanding of those that suit the style of others.
            </p>
            <p>
                This is an internationally proven tool designed by Peter Honey and Alan Mumford.
            </p>
            <p>
                There is no time limit to this questionnaire. It will probably take you 10-15 minutes. The accuracy of the results depends on how honest you can be. There are no right or wrong answers.

            </p>

            <p>
                <ul>
                   <li><b>If you agree more than you disagree with a statement put a tick by it.</b></li>
                   <li><b>If you disagree more than you agree put a cross by it.</b></li>
                   <li><b>Be sure to mark each item with either a tick or cross.</b></li>
               </ul>
           </p>

           <h2 class="form-signin-radio">Questionnaire</h2>
           <table><tr><td>
            <ol type="1">
                <li>
                    <spring:bind path="q1">
                    <div class="form-group ">
                        <p>I have strong beliefs about what is right and wrong, good and bad.</p>
                        <form:radiobutton path="q1" value="Yes"/>Yes
                        <form:radiobutton path="q1" value="No"/>No
                    </div>
                </spring:bind>
            </li>
            <li>
                <spring:bind path="q2">
                <div class="form-group">
                    <p>I often act without considering the possible consequences. </p>
                    <form:radiobutton path="q2" value="Yes"/>Yes
                    <form:radiobutton path="q2" value="No"/>No
                </div>
            </spring:bind>
        </li>
        <li>
          <spring:bind path="q3">
          <div class="form-group">
              <p>I tend to solve problems using a step-by-step approach. </p>
              <form:radiobutton path="q3" value="Yes"/>Yes
              <form:radiobutton path="q3" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
       <spring:bind path="q4">
       <div class="form-group ">
         <p>I believe that formal procedures and policies restrict people. </p>
         <form:radiobutton path="q4" value="Yes"/>Yes
         <form:radiobutton path="q4" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q5">
        <div class="form-group">
          <p>I have a reputation for saying what I think, simply and directly. </p>
          <form:radiobutton path="q5" value="Yes"/>Yes
          <form:radiobutton path="q5" value="No"/>No
      </div>
    </spring:bind>
    </li>
    <li>
     <spring:bind path="q6">
         <div class="form-group">
          <p>I often find that actions based on feelings are as sound as those based on careful thought and analysis.</p>
              <form:radiobutton path="q6" value="Yes"/>Yes
              <form:radiobutton path="q6" value="No"/>No
            </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q7">
        <div class="form-group ">
            <p>I like the sort of work where I have time for thorough preparation and
              implementation. </p>
              <form:radiobutton path="q7" value="Yes"/>Yes
              <form:radiobutton path="q7" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
        <spring:bind path="q8">
        <div class="form-group ">
            <p>I regularly question people about their basic assumptions. </p>
            <form:radiobutton path="q8" value="Yes"/>Yes
            <form:radiobutton path="q8" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q9">
        <div class="form-group ">
            <p>What matters most is whether something works in practice.</p>
            <form:radiobutton path="q9" value="Yes"/>Yes
            <form:radiobutton path="q9" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q10">
        <div class="form-group ">
            <p>I actively seek out new experiences.</p>
            <form:radiobutton path="q10" value="Yes"/>Yes
            <form:radiobutton path="q10" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q11">
        <div class="form-group ">
            <p>When I hear about a new idea or approach I immediately start working out how to
             apply it in practice.</p>
             <form:radiobutton path="q11" value="Yes"/>Yes
             <form:radiobutton path="q11" value="No"/>No
         </div>
     </spring:bind>
     </li>
     <li>
     <spring:bind path="q12">
     <div class="form-group ">
        <p>I am keen on self-discipline such as watching my diet, taking regular exercise,
         sticking to a fixed routine, etc. </p>
         <form:radiobutton path="q12" value="Yes"/>Yes
         <form:radiobutton path="q12" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q13">
        <div class="form-group ">
            <p>I take pride in doing a thorough job.</p>
            <form:radiobutton path="q13" value="Yes"/>Yes
            <form:radiobutton path="q13" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q14">
        <div class="form-group ">
            <p>I get on best with logical, analytical people and less well with spontaneous
             ‘irrational’ people. </p>
             <form:radiobutton path="q14" value="Yes"/>Yes
             <form:radiobutton path="q14" value="No"/>No
         </div>
     </spring:bind>
     </li>
     <li>
     <spring:bind path="q15">
     <div class="form-group ">
        <p>I take care over the interpretation of data available to me and avoid jumping to
         conclusions.</p>
         <form:radiobutton path="q15" value="Yes"/>Yes
         <form:radiobutton path="q15" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q16">
        <div class="form-group ">
            <p>I like to reach a decision carefully after weighing up many alternatives</p>
            <form:radiobutton path="q16" value="Yes"/>Yes
            <form:radiobutton path="q16" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q17">
       <div class="form-group ">
        <p>I'm attracted more to novel, unusual ideas than to practical ones</p>
        <form:radiobutton path="q17" value="Yes"/>Yes
        <form:radiobutton path="q17" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q18">
       <div class="form-group ">
        <p>I don't like disorganised things and prefer to fit things into a coherent pattern</p>
        <form:radiobutton path="q18" value="Yes"/>Yes
        <form:radiobutton path="q18" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q19">
       <div class="form-group ">
        <p>I accept and stick to laid down procedures and policies so long as I regard them as an efficient way of getting the job done</p>
        <form:radiobutton path="q19" value="Yes"/>Yes
        <form:radiobutton path="q19" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q20">
       <div class="form-group ">
        <p>I like to relate my actions to a general principle</p>
        <form:radiobutton path="q20" value="Yes"/>Yes
        <form:radiobutton path="q20" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q21">
        <div class="form-group ">
            <p> In discussions I like to get straight to the point</p>
            <form:radiobutton path="q21" value="Yes"/>Yes
            <form:radiobutton path="q21" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q22">
        <div class="form-group ">
            <p>I tend to have distant, rather formal relationships with people at work</p>
            <form:radiobutton path="q22" value="Yes"/>Yes
            <form:radiobutton path="q22" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q23">
        <div class="form-group ">
            <p>I thrive on the challenge of tackling something new and different</p>
            <form:radiobutton path="q23" value="Yes"/>Yes
            <form:radiobutton path="q23" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q24">
        <div class="form-group ">
            <p>I enjoy fun-loving, spontaneous people</p>
            <form:radiobutton path="q24" value="Yes"/>Yes
            <form:radiobutton path="q24" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q25">
        <div class="form-group ">
            <p>I pay meticulous attention to detail before coming to a conclusion</p>
            <form:radiobutton path="q25" value="Yes"/>Yes
            <form:radiobutton path="q25" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q26">
        <div class="form-group">
            <p>I find it difficult to produce ideas on impulse</p>
            <form:radiobutton path="q26" value="Yes"/>Yes
            <form:radiobutton path="q26" value="No"/>No
        </div>
    </spring:bind>
    </l1>

    <li>
                    <spring:bind path="q27">
                    <div class="form-group ">
                        <p>I believe in coming to the point immediately.</p>
                        <form:radiobutton path="q27" value="Yes"/>Yes
                        <form:radiobutton path="q27" value="No"/>No
                    </div>
                </spring:bind>
            </li>
            <li>
                <spring:bind path="q28">
                <div class="form-group">
                    <p>I am careful not to jump to conclusions too quickly </p>
                    <form:radiobutton path="q28" value="Yes"/>Yes
                    <form:radiobutton path="q28" value="No"/>No
                </div>
            </spring:bind>
        </li>
        <li>
          <spring:bind path="q29">
          <div class="form-group">
              <p>I prefer to have as many resources of information as possible - the more data to think 	over the better</p>
              <form:radiobutton path="q29" value="Yes"/>Yes
              <form:radiobutton path="q29" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
       <spring:bind path="q30">
       <div class="form-group ">
         <p>Flippant people who don't take things seriously enough usually irritate me </p>
         <form:radiobutton path="q30" value="Yes"/>Yes
         <form:radiobutton path="q30" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q31">
        <div class="form-group">
          <p>I listen to other people's points of view before putting my own forward </p>
          <form:radiobutton path="q31" value="Yes"/>Yes
          <form:radiobutton path="q31" value="No"/>No
      </div>
    </spring:bind>
    </li>
    <li>
     <spring:bind path="q32">
         <div class="form-group">
          <p>I tend to be open about how I'm feeling</p>
              <form:radiobutton path="q32" value="Yes"/>Yes
              <form:radiobutton path="q32" value="No"/>No
            </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q33">
        <div class="form-group ">
            <p>In discussions I enjoy watching the manoeuvrings of the other participants </p>
              <form:radiobutton path="q33" value="Yes"/>Yes
              <form:radiobutton path="q33" value="No"/>No
          </div>
      </spring:bind>
    </li>

    <li>
        <spring:bind path="q34">
        <div class="form-group ">
            <p>I prefer to respond to events on a spontaneous, flexible basis rather than plan things out 	in advance</p>
            <form:radiobutton path="q34" value="Yes"/>Yes
            <form:radiobutton path="q34" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q35">
        <div class="form-group ">
            <p>I tend to be attracted to techniques such as network analysis, flow charts, branching 	programs, contingency planning, etc.</p>
            <form:radiobutton path="q35" value="Yes"/>Yes
            <form:radiobutton path="q35" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q36">
        <div class="form-group ">
            <p>It worries me if I have to rush out a piece of work to meet a tight deadline.</p>
             <form:radiobutton path="q36" value="Yes"/>Yes
             <form:radiobutton path="q36" value="No"/>No
         </div>
     </spring:bind>
     </li>
     <li>
     <spring:bind path="q37">
     <div class="form-group ">
        <p>I tend to judge people's ideas on their practical merits </p>
         <form:radiobutton path="q37" value="Yes"/>Yes
         <form:radiobutton path="q37" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q38">
        <div class="form-group ">
            <p>Quiet, thoughtful people tend to make me feel uneasy</p>
            <form:radiobutton path="q38" value="Yes"/>Yes
            <form:radiobutton path="q38" value="No"/>No
        </div>
    </spring:bind>
    </li>

     <li>
     <spring:bind path="q39">
     <div class="form-group ">
        <p>I often get irritated by people who want to rush things.</p>
         <form:radiobutton path="q39" value="Yes"/>Yes
         <form:radiobutton path="q39" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q40">
        <div class="form-group ">
            <p>It is more important to enjoy the present moment than to think about the past or future</p>
            <form:radiobutton path="q40" value="Yes"/>Yes
            <form:radiobutton path="q40" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q41">
       <div class="form-group ">
        <p>I think that decisions based on a thorough analysis of all the information are sounder 	than those based on intuition</p>
        <form:radiobutton path="q41" value="Yes"/>Yes
        <form:radiobutton path="q41" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q42">
       <div class="form-group ">
        <p>I tend to be a perfectionist</p>
        <form:radiobutton path="q42" value="Yes"/>Yes
        <form:radiobutton path="q42" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q43">
       <div class="form-group ">
        <p>In discussions I usually produce lots of spontaneous ideas</p>
        <form:radiobutton path="q43" value="Yes"/>Yes
        <form:radiobutton path="q43" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q44">
       <div class="form-group ">
        <p>In meetings I put forward practical realistic ideas</p>
        <form:radiobutton path="q44" value="Yes"/>Yes
        <form:radiobutton path="q4" value="No"/>No
    </div>
    </spring:bind>
    </li>

    <li>
                    <spring:bind path="q45">
                    <div class="form-group ">
                        <p>More often than not, rules are there to be broken</p>
                        <form:radiobutton path="q45" value="Yes"/>Yes
                        <form:radiobutton path="q45" value="No"/>No
                    </div>
                </spring:bind>
            </li>
            <li>
                <spring:bind path="q46">
                <div class="form-group">
                    <p>I prefer to stand back from a situation. </p>
                    <form:radiobutton path="q46" value="Yes"/>Yes
                    <form:radiobutton path="q46" value="No"/>No
                </div>
            </spring:bind>
        </li>
        <li>
          <spring:bind path="q47">
          <div class="form-group">
              <p>I can often see inconsistencies and weaknesses in other people's arguments  </p>
              <form:radiobutton path="q47" value="Yes"/>Yes
              <form:radiobutton path="q47" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
       <spring:bind path="q48">
       <div class="form-group ">
         <p>On balance I talk more than I listen </p>
         <form:radiobutton path="q48" value="Yes"/>Yes
         <form:radiobutton path="q48" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q49">
        <div class="form-group">
          <p>I can often see better, more practical ways to get things done </p>
          <form:radiobutton path="q49" value="Yes"/>Yes
          <form:radiobutton path="q49" value="No"/>No
      </div>
    </spring:bind>
    </li>
    <li>
     <spring:bind path="q50">
         <div class="form-group">
          <p>I think written reports should be short and to the point</p>
              <form:radiobutton path="q50" value="Yes"/>Yes
              <form:radiobutton path="q50" value="No"/>No
            </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q51">
        <div class="form-group ">
            <p>I believe that rational, logical thinking should win the day</p>
              <form:radiobutton path="q51" value="Yes"/>Yes
              <form:radiobutton path="q51" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
        <spring:bind path="q52">
        <div class="form-group ">
            <p>I tend to discuss specific things with people rather than engaging in social discussion</p>
            <form:radiobutton path="q52" value="Yes"/>Yes
            <form:radiobutton path="q52" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q53">
        <div class="form-group ">
            <p>I like people who approach things realistically rather than theoretically</p>
            <form:radiobutton path="q53" value="Yes"/>Yes
            <form:radiobutton path="q53" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q54">
        <div class="form-group ">
            <p>In discussions I get impatient with irrelevancies and digressions</p>
            <form:radiobutton path="q54" value="Yes"/>Yes
            <form:radiobutton path="q54" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q55">
        <div class="form-group ">
            <p>If I have a report to write I tend to produce lots of drafts before settling on the final version</p>
             <form:radiobutton path="q55" value="Yes"/>Yes
             <form:radiobutton path="q55" value="No"/>No
         </div>
     </spring:bind>
     </li>
     <li>
     <spring:bind path="q56">
     <div class="form-group ">
        <p>I am keen to try things out to see if they work in practice </p>
         <form:radiobutton path="q56" value="Yes"/>Yes
         <form:radiobutton path="q56" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q57">
        <div class="form-group ">
            <p>I am keen to reach answers via a logical approach</p>
            <form:radiobutton path="q57" value="Yes"/>Yes
            <form:radiobutton path="q57" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q58">
        <div class="form-group ">
            <p>I enjoy being the one that talks a lot </p>
             <form:radiobutton path="q58" value="Yes"/>Yes
             <form:radiobutton path="q58" value="No"/>No
         </div>
     </spring:bind>
     </li>

    <li>
       <spring:bind path="q59">
       <div class="form-group ">
        <p>In discussions I often find I am the realist, keeping people to the point and avoiding wild speculations</p>
        <form:radiobutton path="q59" value="Yes"/>Yes
        <form:radiobutton path="q59" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q60">
       <div class="form-group ">
        <p>I like to ponder many alternatives before making up my mind</p>
        <form:radiobutton path="q60" value="Yes"/>Yes
        <form:radiobutton path="q60" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q61">
       <div class="form-group ">
        <p>In discussions with people I often find I am the most dispassionate and objective</p>
        <form:radiobutton path="q61" value="Yes"/>Yes
        <form:radiobutton path="q61" value="No"/>No
    </div>
    </spring:bind>
    </li>
    <li>
       <spring:bind path="q62">
       <div class="form-group ">
        <p>In discussions I'm more likely to adopt a "low profile" than to take the lead and do most of the talking</p>
        <form:radiobutton path="q62" value="Yes"/>Yes
        <form:radiobutton path="q62" value="No"/>No
    </div>
    </spring:bind>
    </li>


    <li>
                    <spring:bind path="q63">
                    <div class="form-group ">
                        <p>I like to be able to relate current actions to a longer term bigger picture</p>
                        <form:radiobutton path="q63" value="Yes"/>Yes
                        <form:radiobutton path="q63" value="No"/>No
                    </div>
                </spring:bind>
            </li>
            <li>
                <spring:bind path="q64">
                <div class="form-group">
                    <p>When things go wrong I am happy to shrug it off and "put it down to experience"</p>
                    <form:radiobutton path="q64" value="Yes"/>Yes
                    <form:radiobutton path="q64" value="No"/>No
                </div>
            </spring:bind>
        </li>
        <li>
          <spring:bind path="q65">
          <div class="form-group">
              <p>I tend to reject wild, spontaneous ideas as being impractical</p>
              <form:radiobutton path="q65" value="Yes"/>Yes
              <form:radiobutton path="q65" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
       <spring:bind path="q66">
       <div class="form-group ">
         <p>It's best to think carefully before taking action </p>
         <form:radiobutton path="q66" value="Yes"/>Yes
         <form:radiobutton path="q66" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q67">
        <div class="form-group">
          <p>On balance I do the listening rather than the talking</p>
          <form:radiobutton path="q67" value="Yes"/>Yes
          <form:radiobutton path="q67" value="No"/>No
      </div>
    </spring:bind>
    </li>
    <li>
     <spring:bind path="q68">
         <div class="form-group">
          <p>I tend to be tough on people who find it difficult to adopt a logical approach</p>
              <form:radiobutton path="q68" value="Yes"/>Yes
              <form:radiobutton path="q68" value="No"/>No
            </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q69">
        <div class="form-group ">
            <p>Most times I believe the end justifies the means</p>
              <form:radiobutton path="q69" value="Yes"/>Yes
              <form:radiobutton path="q69" value="No"/>No
          </div>
      </spring:bind>
    </li>
    <li>
        <spring:bind path="q70">
        <div class="form-group ">
            <p>I don't mind hurting people's feelings so long as the job gets done </p>
            <form:radiobutton path="q70" value="Yes"/>Yes
            <form:radiobutton path="q70" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q71">
        <div class="form-group ">
            <p>I find the formality of having specific objectives and plans stifling</p>
            <form:radiobutton path="q71" value="Yes"/>Yes
            <form:radiobutton path="q71" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q72">
        <div class="form-group ">
            <p>I'm usually one of the people who puts life into a party</p>
            <form:radiobutton path="q72" value="Yes"/>Yes
            <form:radiobutton path="q72" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q73">
        <div class="form-group ">
            <p>I do whatever is expedient to get the job done</p>
             <form:radiobutton path="q73" value="Yes"/>Yes
             <form:radiobutton path="q73" value="No"/>No
         </div>
     </spring:bind>
     </li>
     <li>
     <spring:bind path="q74">
     <div class="form-group ">
        <p>I quickly get bored with methodical, detailed work</p>
         <form:radiobutton path="q74" value="Yes"/>Yes
         <form:radiobutton path="q74" value="No"/>No
     </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q75">
        <div class="form-group ">
            <p>I am keen on exploring the basic assumptions, principles and theories underpinning things and events</p>
            <form:radiobutton path="q75" value="Yes"/>Yes
            <form:radiobutton path="q75" value="No"/>No
        </div>
    </spring:bind>
    </li>
    <li>
        <spring:bind path="q76">
        <div class="form-group ">
            <p>I'm always interested to find out what people think </p>
             <form:radiobutton path="q76" value="Yes"/>Yes
             <form:radiobutton path="q76" value="No"/>No
         </div>
     </spring:bind>
     </li>
<li>
        <spring:bind path="q77">
        <div class="form-group ">
            <p>I like meetings to be run on methodical lines, sticking to laid down agenda, etc. </p>
            <form:radiobutton path="q77" value="Yes"/>Yes
            <form:radiobutton path="q77" value="No"/>No
        </div>
    </spring:bind>
    </li>

    <li>
            <spring:bind path="q78">
            <div class="form-group ">
                <p>I steer clear of subjective or ambiguous topics </p>
                 <form:radiobutton path="q78" value="Yes"/>Yes
                 <form:radiobutton path="q78" value="No"/>No
             </div>
         </spring:bind>
         </li>

         <li>
              <spring:bind path="q79">
              <div class="form-group ">
                 <p>I enjoy the drama and excitement of a crisis situation</p>
                  <form:radiobutton path="q79" value="Yes"/>Yes
                  <form:radiobutton path="q79" value="No"/>No
              </div>
             </spring:bind>
             </li>
             <li>
                 <spring:bind path="q80">
                 <div class="form-group ">
                     <p>People often find me insensitive to their feelings</p>
                     <form:radiobutton path="q80" value="Yes"/>Yes
                     <form:radiobutton path="q80" value="No"/>No
                 </div>
             </spring:bind>
             </li>
    </ol>
    </table></tr></td>
    <button class="btn btn-lg btn-primary" type="submit">Submit</button>
    </form:form>
<span>${message}</span>
    </div>
    <!-- /container -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
    </html>
