<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="styles.css">
    <title>Home Page - Easy News</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
</head>
</head>

<body>

    <header>
        <div class="container">
            <div class="logo h1">
                <h1> Easy News</h1>
                <div class="logo img">
                    <img src="./Newsletter.jpg" height="10%" width="10%">
                </div>
                <div class="logo h2">
                    <h2> l'informazione a portata di un click!</h2>
                </div>
            </div>
            <nav>
                

            </nav>
            <div class="buttons">
                <button class="login-btn">Admin</button>
            </div>
        </div>
    </header>
    <main class="container">
        <article>
            <h2>Modulo di Inserimento Articolo</h2>
            <form action="#" method="POST">
                <label for="author">Autore:</label>
                <input type="text" id="author" name="author" required>

                <label for="title">Titolo:</label>
                <input type="text" id="titolo" name="titolo" required>

                <label for="date">Data di Pubblicazione:</label>
                <input type="date" id="date" name="date" required>
                
                <label for="content">Testo dell'Articolo:</label>
                <textarea id="content" name="content" rows="10" required></textarea>
                
                <div class="buttons">
                    <button type="submit" class="login-btn">Aggiungi Articolo</button>
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
    