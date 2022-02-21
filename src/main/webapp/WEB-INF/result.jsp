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

<%@include file="styleResult.jsp" %>

<body>
	<div align="center">
		<c:choose>
			<c:when test="${  sessionScope.team1.isWinner== true || sessionScope.team2.isWinner== true}">
				<h2 
					<c:if test="${  sessionScope.team1.isWinner }" >
				 	style="color: red"
					</c:if>
					<c:if test="${  !sessionScope.team1.isWinner }" >
				 	style="color: #0000FF"
					</c:if>
				>
					<c:out value="Winner :  ${ sessionScope.team1.isWinner ? sessionScope.team1.name : sessionScope.team2.name }"></c:out>
				</h2>
				<h4>
					<c:out value="Score  :  ${ sessionScope.team1.isWinner ? sessionScope.team1.score : sessionScope.team2.score }"></c:out>
				</h4>
				<h2
					<c:if test="${  !sessionScope.team1.isWinner }" >
				 	style="color: red"
					</c:if>
					<c:if test="${  sessionScope.team1.isWinner }" >
				 	style="color: #0000FF"
					</c:if>
				>
					<c:out value="Looser :  ${ sessionScope.team1.isWinner ? sessionScope.team2.name : sessionScope.team1.name }"></c:out>
				</h2>
				<h4>
					<c:out value="Score :  ${ sessionScope.team1.isWinner ? sessionScope.team2.score : sessionScope.team1.score }"></c:out>
				</h4>
			</c:when>
			<c:otherwise>
				<h2>
					<c:out value="You ended up tied !"></c:out>
				</h2>
				<h4 style="color: red">
					<c:out value="The team ${sessionScope.team1.name} finished with a score of: ${sessionScope.team1.score}"></c:out>
				</h4>
				<h4 style="color: #0000FF">
					<c:out value="The team ${sessionScope.team2.name} finished with a score of: ${sessionScope.team2.score}"></c:out>
				</h4>
			</c:otherwise>
		</c:choose>	
			<input type="button" class="button"  value="Back home" onclick="window.location.href='/test/teams';" />
	</div>
	
</body>


</html>