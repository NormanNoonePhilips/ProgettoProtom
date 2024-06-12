<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import = "java.util.List" %>
<html lang="it">
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
                <button class="login-btn">Admin Login</button>
                
            </div>
        </div>
    </header>
    <table class = "table-borderless" >
        <thead class="table-borderless thead ">
            <tr>
             <td><strong>Titolo</strong></td>
             <td><strong>Autore</strong></td>
             <td><strong>Data pubblicazione</strong></td>
             
            </tr>
            
        </thead>
        <tbody class ="table-borderless th td">
            <c:forEach var="u" items="${lstnews}">
            <tr>
                <td>${u.getTitolo()} </td>
                <td>${u.getAutore()}</td>
                <td>${u.getData()}</td>  
               <td class="buttons">
               <form action="NewsController" method="post">
               <input type="hidden" name="infoNW" value="${u.getId()}">
               <input type="hidden" name="operazione" value="info">
                <button class="modifica">Vedi di pi&#249</button>
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
</body>
</html>

