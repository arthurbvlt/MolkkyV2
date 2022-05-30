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
	<h1 style="padding-bottom: 30px">Let's play!</h1>
	
	<div class="bg1" 
			<c:if test="${  sessionScope.team1.equals(sessionScope.round.team)}" >
		 	style="background-color: red"
			</c:if>
			<c:if test="${  !sessionScope.team1.equals(sessionScope.round.team)}" >
		 	style="	background-color: rgb(41, 121, 255)"
			</c:if>
	>
		<h2>
			<c:out value="Team to play :  ${ sessionScope.round.team.name }"></c:out>
		</h2>
		<h4>
		<h2>
			<c:out value="Score  :  ${ sessionScope.round.totalScore }"></c:out>
		</h2>
		<h2>
			<c:out value="Turn  :  ${ sessionScope.round.nbRound}"></c:out>
		</h2>
	</div>
	<div class="bg2"
			<c:if test="${  !sessionScope.team1.equals(sessionScope.round.team)}" >
		 	style="background-color: red"
			</c:if>
			<c:if test="${  sessionScope.team1.equals(sessionScope.round.team)}" >
		 	style="background-color: rgb(41, 121, 255)"
			</c:if>
	>
		<h4>
			<c:out value="Team :  ${ roundOld.team.name }"></c:out>
		</h4>
		<h4>
			<c:out value="Score  :  ${ roundOld.totalScore }"></c:out>
		</h4>
		<h4>
			<c:out value="Turn  :  ${ roundOld.nbRound}"></c:out>
		</h4>
	</div>
		
		<form  action="${pageContext.request.contextPath}/main"method="post">
				
			<table style="with: 80%">
			
			<h2 style="padding-top: 1em">
				<c:out value="Its   :  ${ sessionScope.round.team.name} turn to play"></c:out>
			</h2>
				<tr>
					<td><c:out value="Add new Score" /></td>
					<td><input type="number" id="score" name="score" min="0" max="12" value="0"><br><br></td>
				</tr>
			</table>
			<input class="button" type="submit" name="main" value="Send score" />
		</form>

	</div>
</body>


</html>