<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="utf-8" />
<title>Home page</title>
</head>

<%@include file="styleTeams.jsp" %>

<body>
	<div align="center">
		<h1 style="line-height: 3.5em;">Game Molkky Version 1 !</h1>
		<c:if test= "${ isSame == true}"> 
			<h4 style="color:red">Please enter a different name for each team !</h4>
		</c:if>
		<form method="post">
			<table id="table1">
				<tr>
					<td style="color: red"><c:out value="Team 1"/></td>
					<td><input type="text" name="team1"/></td>
				</tr>
				<tr>
					<td style="color: #0000FF"><c:out value="Team 2"/></td>
					<td><input type="text" name="team2"/></td>
				</tr>
				<td colspan="3">
			</table>
			<input type="submit" name="teams" value="Lets Play" class="button"/>		
		</form>

<%-- 			<c:if test="${ !empty file }"><p><c:out value="Le fichier ${ file } a été uploadé !" /></p></c:if>
 --%>		
		<form  method="post" action="teams" enctype="multipart/form-data">  <!--  enctype="multipart/form-data" -->
			
			<table id="table2">
				<td><b><c:out value="Choose csv file to upload (not obligatory) :"/></b></td>
				<td><input  name="file" type="file" id="file" accept=".csv"/></td>
			</table>
			
			<input type="submit" name="teamsWithCSV" value="Add CSV file" required="file" class="button"/>
		
		</form>
	</div>
	<img src="imageTeams.jpg" id="image"/>
</body>
</html>