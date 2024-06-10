<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="app.model.UtenteModel"%>
    <%@page import = "java.util.ArrayList" %>
	<%@page import = "java.util.List" %>
	<%@page import = "java.time.LocalDate"%>
<%@ page import= "java.time.format.DateTimeFormatter"%>
<%@page import= "java.time.Period" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Utenti</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 
</head>
<body>
 
<table class="table table-bordered border-info border-4">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Cognome</th>
      <th scope="col">Eta</th>
       <th scope="col">Email</th>
      <th scope="col">Funzioni</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
 <c:forEach var="u" items="${lstutenti}">
    <tr>
      <th scope="row"><h2>${u.getId()}</h2></th>
      <td><h2>${u.getNome()}</h2></td>
      <td><h2>${u.getCognome()}</h2></td>
        <td><h2>${u.getEmail()}</h2></td>
      <td><h2>${u.getDatanasc()}</h2></td>
      <td>
      <form action="/proget/UtenteController" method="post" onsubmit="return conferma()">
		<input type="hidden" name="operazione" value="delete">
		<input type="hidden" name="deleteUT" value="${u.getId()}">
		<button type="submit">Cancella Utente</button>
		</form>
		<form action="/proget/UtenteController" method="get">
		<input type="hidden" name="operazione" value="update">
		<input type="hidden" name="UpdateUT" value="${u.getId()}">
		<button type="submit">Aggiorna Utente</button>
		</form>
		</td>
    </tr>
   </c:forEach>
  </tbody>
</table> 
<form action="jsp/add.jsp" >
<button type="submit">Aggiungi Nuovo Utente</button>
</form>
<form action="/proget" method="post">
<button type="submit">Torna alla Home</button>
</form>
<script>
function conferma() {
let result = confirm("Sei sicuro di voler eliminare quest utente?");
return result;
}
</script>
</body>
</html></html>