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

 
<body class="img">	
	<h2 id="header"> Historique de ce match : </h2>
	<div class="row">
		<div class="col-md-4 offset-md-2 rectangle">
			<c:forEach items="${sessionScope.roundsT1 }" var="round">
				<p>Round <c:out value="${ round.nbRound }"/></p>
				<p>Score de l'équipe <c:out value="${ sessionScope.game.team1.name} : ${ round.score}"></c:out></p>
				<p>__________________________________</p>
			</c:forEach>
		</div>
		<div class="col-md-4 offset-md-1 rectangle">
			<c:forEach items="${ sessionScope.roundsT2 }" var="round">
				<p>Round <c:out value="${ round.nbRound }"/></p>
				<p>Score de l'équipe <c:out value="${ sessionScope.game.team2.name} : ${ round.score}"></c:out></p>
				<p>__________________________________</p>
			</c:forEach>
		</div>
	</div>

	
	<div id="historique" class="row">
		<div class="col-md-4 offset-md-2 rectangle">
			<p class="historiqueP">Historique des anciens matchs de l'équipe</p>
			<p class="nomEquipe"><c:out value="${ sessionScope.game.team1.name}"></c:out></p>
			
			<c:forEach items="${sessionScope.gamesT1 }" var="gameVar">
				<p><c:out value="Match contre l'équipe ${ sessionScope.game.team1.name.equals(gameVar.team1.name)? gameVar.team2.name : gameVar.team1.name } :"></c:out></p>
				<p
					<c:if test="${  sessionScope.team1.name.equals(gameVar.teamWinner.name)}" >
				 	style="color: green"
					</c:if>
					<c:if test="${  !sessionScope.team1.name.equals(gameVar.teamWinner.name)}" >
				 	style="color: red"
					</c:if>
				>
					<c:out value="${ sessionScope.team1.name.equals(gameVar.teamWinner.name) ? 'Victoire' : 'Défaite' } "></c:out>
				</p>
				<p>__________________________________</p>
			</c:forEach>
		</div>	
	
		<div class="col-md-4 offset-md-1 rectangle">
			<p class="historiqueP">Historique des anciens matchs de l'équipe</p>
			<p class="nomEquipe"><c:out value="${ sessionScope.game.team2.name}"></c:out></p>
			
			<c:forEach items="${sessionScope.gamesT2 }" var="gameVar">
				<p><c:out value="Match contre l'équipe ${ sessionScope.game.team2.name.equals(gameVar.team2.name)? gameVar.team1.name : gameVar.team2.name } :"></c:out></p>
				<p
					<c:if test="${  sessionScope.team2.name.equals(gameVar.teamWinner.name)}" >
				 	style="color: green"
					</c:if>
					<c:if test="${  !sessionScope.team2.name.equals(gameVar.teamWinner.name)}" >
				 	style="color: red"
					</c:if>
				>
					<c:out value="${ sessionScope.team2.name.equals(gameVar.teamWinner.name) ? 'Victoire' : 'Défaite' } "></c:out>
				</p>				<p>__________________________________</p>
			</c:forEach>
		</div>
	</div>
	<input type="button" class="button"  value="Back home" onclick="window.location.href='/test/teams';" />
</body>


</html>