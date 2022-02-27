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
<body>
	<p>Lets play!</p>
	<h2>
		<c:out value="Equipe à jouer :  ${ sessionScope.round.team.name }"></c:out>
	</h2>
	<h4>
		<c:out value="Score  :  ${ sessionScope.round.score }"></c:out>
	</h4>
	<h4>
		<c:out value="Turn  :  ${ sessionScope.round.nbRound}"></c:out>
	</h4>
	
	<h2>
		<c:out value="Equipe :  ${ roundOld.team.name }"></c:out>
	</h2>
	<h4>
		<c:out value="Score  :  ${ roundOld.score }"></c:out>
	</h4>
	<h4>
		<c:out value="Turn  :  ${ roundOld.nbRound}"></c:out>
	</h4>
		
		<form  action="${pageContext.request.contextPath}/main"method="post">
				
			<table style="with: 80%">
			
			<h4>
				<c:out value="Its   :  ${ sessionScope.round.team.name} turn to play"></c:out>
			</h4>
				<tr>
					<td><c:out value="Add new Score" /></td>
					<td><input type="number" id="score" name="score" min="0" max="12" value="0"><br><br></td>
				</tr>
			</table>
			<input type="submit" name="main" value="Send score" />
		</form>

	</div>
</body>


</html>