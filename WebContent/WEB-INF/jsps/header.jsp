
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse navbar-fixed-top">

      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">ONLINE BANK</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
              <li class="active"><a href="${pageContext.request.contextPath}/showAllAccount">All ACCOUNT</a></li>
            <li><a href="${pageContext.request.contextPath}/createAccount">NEW
		ACCOUNT</a></li>
		<li><a href="${pageContext.request.contextPath}/checkBalance">BALANCE</a></li>
            <li><a href="${pageContext.request.contextPath}/depositAccount">DEPOSIT</a></li>
		
		<li><a href="${pageContext.request.contextPath}/withdrawMoney">WITHDRAW</a></li>
		<li><a href="${pageContext.request.contextPath}/transferMoney">TRANSFER</a></li>
		
		<li><a href="${pageContext.request.contextPath}/task">REPORT</a></li>
		<li><a href="${pageContext.request.contextPath}/closeAccount">CLOSE A/C</a></li>
		<%-- <li><sec:authorize access="!isAuthenticated()">
		<a href="${pageContext.request.contextPath}/login">Login</a>
		<br> 
	</sec:authorize></li>--%>
	
	<li> <sec:authorize access="isAuthenticated()">
		<a href="<c:url value='j_spring_security_logout'/>">Logout</a>
		<br>
	</sec:authorize></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<nav class="navbar navbar-default">

      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <!--  <a class="navbar-brand" href="#">Project name</a> -->
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
          
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>