<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="styles.css">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
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
             <td><strong>Nome</strong></td>
             <td><strong>Cognome</strong></td>
             <td><strong>Email</strong></td>
             <td><strong>Data Nascita</strong></td>
            </tr>
            
        </thead>
        <tbody class ="table-borderless">
        <c:forEach var="u" items="${lstutenti}">
            <tr>
                <td>${u.getNome()} </td>
                <td>${u.getCognome()}</td>
                <td>${u.getEmail()}</td>
                <td>${u.getData()}</td>
                <td class="buttons">
                
                
                <form action="UtenteController" method="post" onsubmit="return conferma()">
		<input type="hidden" name="operazione" value="delete">
		<input type="hidden" name="deleteUT" value="${u.getId()}">
                    <button class="modifica">Elimina</button>
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
