<!DOCTYPE html>
<html lang="it">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import = "java.util.List" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="styles.css">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
     <link href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" rel="stylesheet">
</head>
<body>
    <header>
        <div class="container">
            <div class="logo h1">
                <h1> Easy News</h1>
                <div class = "logo img">
                    <img src="./Newsletter.jpg" height="10%" width="10%">
                </div>
                <div class="logo h2">
                    <h2> l'informazione a portata di un click!</h2>
                </div>
            </div>
            <nav>
               
            </nav>
            <div class="buttons">
                <button class="login-btn">Admin Logout</button>
                
            </div>
        </div>
    </header>
    <table class = "table-borderless" >
        <thead class="table-borderless thead ">
            <tr>
             <td><strong>Titolo</strong></td>
             <td><strong>Autore</strong></td>
             <td><strong>Data pubblicazione</strong></td>
             <td><strong>Operazioni</strong></td>
            </tr>
            
        </thead>
        <tbody class ="table-borderless">
        	<c:forEach var="u" items="${lstnews}">
            <tr>
                <td>${u.getTitolo()} </td>
                <td>${u.getAutore()}</td>
                <td>${u.getData()}</td>
                
                <td class="buttons">
          		<form action="NewsController" method="post">
		<input type="hidden" name="operazione" value="updateRed">
		<input type="hidden" name="UpdateNW" value="${u.getId()}">
		<button type="submit" class="modifica">Modifica</button>
		</form>
                
                <form action="NewsController" method="post" onsubmit="return conferma()">
		<input type="hidden" name="operazione" value="delete">
		<input type="hidden" name="deleteNW" value="${u.getId()}">
		<button type="submit" class="modifica">Elimina</button>
		</form>
                    
                </td>
                
            </tr>
            </c:forEach>
            
        </tbody>

    </table>
<footer>
    <p>&copy; 2024- Easy News</p>
    <div class="social-icons">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-linkedin-in"></i></a>
    </div>
</footer>
<script>
function conferma() {
let result = confirm("Sei sicuro di voler eliminare quest utente?");
return result;
}
</script>
</body>
</html>