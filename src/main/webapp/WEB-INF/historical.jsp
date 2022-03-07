<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="utf-8" />
<title>Historical</title>
</head>

<%-- <%@include file="styleResult.jsp" %>
 --%>
<body>
	<p> Historique de ce match : </p>
	
	<c:forEach items="${sessionScope.roundsT1 }" var="round">
		<p>Round <c:out value="${ round.nbRound }"/></p>
		<p>Score de l'�quipe <c:out value="${ sessionScope.game.team1.name} : ${ round.score}"></c:out></p>
	</c:forEach>

	<c:forEach items="${ sessionScope.roundsT2 }" var="round">
		<p>Round <c:out value="${ round.nbRound }"/></p>
		<p>Score de l'�quipe <c:out value="${ sessionScope.game.team2.name} : ${ round.score}"></c:out></p>
	</c:forEach>
	
	<c:out value="Historique des anciens matchs de l'�quipe ${ sessionScope.game.team1.name} :"></c:out>
	<p> Match contre l'�quipe ... : Victoire </p>
	<p> Match contre l'�quipe ... : D�faite </p>	
	<c:out value="Historique des anciens matchs de l'�quipe ${ sessionScope.game.team2.name} :"></c:out>
	<p> Match contre l'�quipe ... : D�faite </p>	
	<p> Match contre l'�quipe ... : Victoire </p>
</body>


</html>