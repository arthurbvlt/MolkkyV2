<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<meta charset="utf-8" />
<title>Game page</title>
</head>

<%@include file="styleMain.jsp" %>

<body>
	<div class="container" align="center">
		<p>Lets play!</p>
		<h2>
			<p 
				<c:if test="${  sessionScope.team1.isTurn }" >
				 	style="color: red"
				</c:if>
			>
				<c:out value="Team 1 :  ${ sessionScope.team1.name }" ></c:out>
			</p>
		</h2>
		<h4>
			<c:out value="Score  :  ${ sessionScope.team1.score }"></c:out>
		</h4>
		<h4>
			<c:out value="Turn  :  ${ sessionScope.team1.turn }"></c:out>
		</h4>
		<h2>
			<p 
				<c:if test="${  sessionScope.team2.isTurn }" >
				 	style="color: #0000FF"
				</c:if>
			>
				<c:out value="Team 2 :  ${ sessionScope.team2.name }"></c:out>
			
			</p>
		</h2>
		<h4>
			<c:out value="Score  :  ${ sessionScope.team2.score }"></c:out>
		</h4>
		<h4>
			<c:out value="Turn  :  ${ sessionScope.team2.turn }"></c:out>
		</h4>
	
			
			<form  action="${pageContext.request.contextPath}/main"method="post">
					
				<table style="with: 80%">
						<c:choose>
					    <c:when test="${  sessionScope.team1.isTurn }">
					   		<h2><c:out value="It is ${ sessionScope.team1.name } turn to play "></c:out></h2>
		    				<c:set target="${ sessionScope.team1 }" property="isTurn" value="false" />
		    				<c:set target="${ sessionScope.team2 }" property="isTurn" value="true"  />
					    </c:when>
					    <c:when test="${ sessionScope.team2.isTurn }">
					    	<h2><c:out value="It is ${ sessionScope.team2.name } turn to play "></c:out></h2>
		    				<c:set target="${ sessionScope.team2 }" property="isTurn" value="false" />
		    				<c:set target="${ sessionScope.team1 }" property="isTurn" value="true" />
					    </c:when>
					    
					    <c:otherwise></c:otherwise>
					</c:choose> 
	
					<tr>
						<td><c:out value="Add new Score :" /></td>
						<td><input type="number" id="score" name="score" min="0" max="12" value="0"><br><br></td>
					</tr>
				</table>
				<div>
					<input class="button" type="submit" name="main" value="Send score"/>
					<input class="button" type="submit" name="finish" value="Finish the game"/>
				</div>
			</form>
	</div>
	
	<%--  <%@include file="JS.jsp" %> --%>
</body>


</html>