<!DOCTYPE html>

<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News - Easy News</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>News - Easy News</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <header>
        <div class="container">
            <div class="logo h1">
                <h1> Easy News</h1>
                <div class = "logo img">
                    <a href="${pageContext.request.contextPath}"><img src="images/Newsletter.jpg" height="10%" width="10%"></a>
                </div>
                <div class="logo h2">
                    <h2> l'informazione a portata di un click!</h2>
                </div>
            </div>
            <div class="buttons">
               <form action="jsp/Login.jsp">
                <button class="login-btn">Admin Login</button>
                </form>
                
            </div>
        </div>
    </header>
    <div class="news-container">
        <div class="news-item">
            <h2 class="news-title">${InfNews.getTitolo()}</h2>
            <div class="news-meta">
                <span class="news-author"> ${InfNews.getAutore()}</span>
                <span class="news-date">${InfNews.getData()}</span>
            </div>
            <p class="news-text">${InfNews.getTesto()}</p>
        </div>
    </div>
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