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
                <form action="jsp/home-admin.jsp">
                <button class="login-btn">Torna alla Admin Home</button>
                </form>
            </div>
        </div>
    </header>
    <main id="main-container">
        <article>
            <form action="#" method="post">
                <input type="hidden" name="operazione" value="add">
                <br>
                <label for="nome"><strong>Inserisci nome</strong> </label>
                <input name="nome" type="text" placeholder="Nome" required>
                <label for="cognome"><strong>Inserisci cognome</strong> </label>
                <input name="cognome" type="text" placeholder="Cognome" required>
                <label for="username"><strong>Username</strong></label>
                <input name="username" type="text" placeholder="Username" required>


                <label for="password"><strong>Password</strong></label>
                <input name="password" type="password" placeholder="Password" required>

                <div class="buttons" style="left: 30%; position: relative">
                    <button class="login-btn">Registra nuovo amministratore</button>
                </div>

            </form>
        </article>
    </main><br>
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