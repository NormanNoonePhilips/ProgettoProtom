<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Easy News</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>

    <header>
        <div class="container">
            <div class="logo h1">
                <h1> Easy News</h1>
                <div class="logo img">
                 <a href="${pageContext.request.contextPath}"><img src="images/Newsletter.jpg" height="10%" width="10%"></a>
                </div>
                <div class="logo h2">
                    <h2> l'informazione a portata di un click!</h2>
                </div>
            </div>
            <nav>

            </nav>
            <div class="buttons">
            <form action="./AdminController" method="post">
            <input type="hidden" name="operazione" value="logout">
                <button class="login-btn">Logout</button>
                </form>
            </div>
        </div>
    </header>

    <main class="main">
        <div class="buttons">
       	  <form action="NewsController" method="post" >	
       	  <input type="hidden" name="operazione" value="list">
          <button type="submit" class="login-btn" id="news-button">Archivio News</button>
          </form>
            <form action="AdminController" method="post">	
       	  	<input type="hidden" name="operazione" value="list">
            <button type="submit" class="login-btn" id="admin-button">Lista Admin</button>
            </form>
            <form action="UtenteController" method="post">	
       	    <input type="hidden" name="operazione" value="list">
            <button type="submit" class="login-btn" id="iscritti-button">Lista Iscritti</button>
            </form>
            
            <img src="images/news-logo.png" id="news-logo">
            <img src="images/admin-logo.png" id="admin-logo">
            <img src="images/iscritti-logo.png" id="iscritti-logo">
        </div>
       
    </main>

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