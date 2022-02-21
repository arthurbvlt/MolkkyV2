<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>CSV</title>
    </head>
   	<%@include file="styleCSV.jsp" %>
    <body>
		<div align="center">
			<c:if test= "${ isSame == true}"> 
				<h4 style="color:red">Please enter a different name for each team!</h4>
			</c:if>
			<form method="post" action="csv">  <!-- action="${pageContext.request.contextPath}/teamsWithCSV" -->
				<table>
					<tr>
						<td><c:out value="Select Team 1 name"/></td>
					    <td>
					    	<select id="select" name="select1">
							<c:forEach items="${ sessionScope.names }" var="names" varStatus="status">
		    				<option value="${ names }">${ names }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				
				<table>
					<tr>
						<td><c:out value="Select Team 2 name"/></td>
					    <td>
					    	<select id="select" name="select2">
							<c:forEach items="${ sessionScope.names }" var="names" varStatus="status">
		    				<option value="${ names }">${ names }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				
				<input type="submit" name="a" value="Lets Play" class="button"/>
			</form> 
		</div>
    </body>
</html>