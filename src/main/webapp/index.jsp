<!DOCTYPE html>
<html lang="it">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import = "java.util.List" %>
<%@page import="app.model.UtenteModel"%>
<%@page import="app.entity.Utente" %>

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
                    <img src="/images/Newsletter.jpg" height="10%" width="10%">
                </div>
                <div class="logo h2">
                    <h2> l'informazione a portata di un click!</h2>
                </div>
            </div>
            <nav>
               
            </nav>
            <div class="buttons">
            <form action="jsp/home-admin.jsp">
                <button class="login-btn">Admin Login</button>
                </form>
            </div>
        </div>
    </header>
    <main class = "main">
    <div class ="news">
       <h1>Ultime notizie</h1> 
       <ul class = "news li">
       <c:forEach var="u" items="${lstnews}">
        <li><a href = "a"><strong>${u.getTitolo()}</strong> a cura di <i>${u.getAutore()} (${u.getData()})</i></a></li>
        </c:forEach>
       </ul>
       
       <div class = "buttons">
       	<form action= "NewsController" method="get">
       	<input type="hidden" name="operazione" value="list">
        <button class = "login-btn">Vai alle News</button>
        </form>
       </div>
    </div>
    <section class="registration">
        <h2>Registrati per rimanere sempre aggiornato</h2>
        <form action="UtenteController" method="post">
                    <input type="hidden" name="operazione" value="add">
					<label for="nome"> Inserisci nome</label> <br>
					<input name="nome" type="text" placeholder="Nome" required> <br> <br>
					<label for="cognome"> Inserisci cognome</label> <br>
					<input name="cognome" type="text" placeholder="Cognome" required> <br> <br>
					<label for="DataNascita"> Inserisci Data di Nascita</label> <br>
					<input name="DataNascita" type="date" placeholder="Data di Nascita" required> <br> <br>
					<label for="password"> Inserisci Email</label> <br>
					<input name="email" type="email" placeholder="Email"> <br> <Br>
					<label for="check">Accetta Termini e Condizioni</label> 
					<input name="check" type="checkbox" required> <br> <br>
       			 <button class="newsletter-btn" type="submit">Iscriviti alla Newsletter</button>
        </form>
                <% 
            String error = request.getParameter("errore");
if (error != null && error.equals("etaNonValida")){
	out.println("<p style = 'color:red;'> Eta non valida </p>");
	}
if (error != null && error.equals("nonAut")){
out.println("<p style = 'color:red;'> Non sei Autorizzato ad accedere a questa pagina <br> Effettuare il Login </p>");
}
%>     
  
    </section>
</main>
 

<footer>
    <p>&copy; 2024- Easy News</p>
    <div class="social-icons">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="https://www.instagram.com/thomasthetrainofficial?igsh=MXVyaW81dWpyNDdqMw=="><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-linkedin-in"></i></a>
    </div>
</footer>
<script>
if(session != null){
	
}
</script>

</body>
</html>
