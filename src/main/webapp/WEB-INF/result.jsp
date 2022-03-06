<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="utf-8" />
<title>Result</title>
</head>

<%@include file="styleResult.jsp" %>

<body>
	<div align="center">
		<c:choose>	
			<c:when test="${  !sessionScope.game.teamWinner.equals(null)}">
				<h2 
					<c:if test="${  sessionScope.game.teamWinner.equals(sessionScope.game.team1) }" >
				 	style="color: red"
					</c:if>
					<c:if test="${  !sessionScope.game.teamWinner.equals(sessionScope.game.team1) }" >
				 	style="color: #0000FF"
					</c:if>
				>
					<c:out value="Winner :  ${ sessionScope.game.teamWinner.name }"></c:out>
				</h2>
				<h4>
					<c:out value="Score  :  ${ sessionScope.round.totalScore }"></c:out>
				</h4>
				<h2
					<c:if test="${  !sessionScope.game.teamWinner.equals(sessionScope.game.team1)  }" >
				 	style="color: red"
					</c:if>
					<c:if test="${  sessionScope.game.teamWinner.equals(sessionScope.game.team1)  }" >
				 	style="color: #0000FF"
					</c:if>
				>
					<c:out value="Looser :  ${ sessionScope.game.teamWinner.equals(sessionScope.game.team1) ? sessionScope.game.team2.name : sessionScope.game.team1.name }"></c:out>
				</h2>
				<h4>
					<c:out value="Score :  ${ sessionScope.roundOld.totalScore }"></c:out>
				</h4>
			</c:when>
			<c:otherwise>
				<h2>
					<c:out value="You ended up tied !"></c:out>
				</h2>
				<h4 style="color: red">
					<c:out value="The team ${sessionScope.round.team.name} finished with a score of: ${sessionScope.round.totalScore}"></c:out>
				</h4>
				<h4 style="color: #0000FF">
					<c:out value="The team ${sessionScope.oldRound.team.name} finished with a score of: ${sessionScope.oldRound.totalScore}"></c:out>
				</h4>
			</c:otherwise>
		</c:choose>	
			<input type="button" class="button"  value="Back home" onclick="window.location.href='/test/teams';" />
			<input type="button" class="button"  value="Historical" onclick="window.location.href='/test/historical';" />
			
	</div>
	
</body>


</html>