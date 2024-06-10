<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert titlehere</title>
</head>
<body>

<div style="background-image: url('https://th.bing.com/th/id/R.c57cfdc45acfd12ad2e095541fb4da13?rik=HXyrEGmdNFK3cA&pid=ImgRaw&r=0');width: 150%; color: white; text-align: center;" > Registrazione
                <form action="/UtenteController" method="post">
                    <input type="hidden" name="operazione" value="add">
					<label for="nome"> Inserisci nome</label> <br>
					<input name="nome" type="text" placeholder="Nome" required> <br>
					<label for="cognome"> Inserisci cognome</label> <br>
					<input name="cognome" type="text" placeholder="Cognome" required> <br>
					<label for="DataNascita"> Inserisci Data di Nascita</label> <br>
					<input name="DataNascita" type="date" placeholder="Data di Nascita" required> <br>
					<label for="password"> Inserisci Email</label> <br>
					<input name="email" type="email" placeholder="Email"> <br>
					<label for="check">Accetta Termini e Condizioni</label>
					<input name="check" type="checkbox" required>
					<button type="submit">Registra nuovo utente</button>
                </form>
            </div>
            <% 
            String error = request.getParameter("errore");
if (error != null && error.equals("etaNonValida")){
	out.println("<p style = 'color:red;'> Eta non valida </p>");
	}
if (error != null && error.equals("nonAut")){
out.println("<p style = 'color:red;'> Non sei Autorizzato ad accedere a questa pagina <br> Effettuare il Login </p>");
}
%>
<form action="../UtenteController" method="get">
		<input type="hidden" name="operazione" value="list">
		<button type="submit">Lista Utenti</button>
		</form>


 <form action="../NewsController" method="post">
                    <input type="hidden" name="operazione" value="add">
					<label for="autore"> Inserisci autore</label> <br>
					<input name="autore" type="text" placeholder="Nome" required> <br>
					<label for="genere"> Inserisci categoria</label> <br>
					<input name="genere" type="text" placeholder="Cognome" required> <br>
					<label for="DataPubblicazione"> Inserisci Data Pubblicazione</label> <br>
					<input name="DataPubblicazione" type="date" placeholder="Data di Nascita" required> <br>
					<label for="articolo"> Inserisci Articolo</label> <br>
					<textarea name="articolo" cols="120" rows="30"></textarea> <br>
					<button type="submit">Registra nuovo utente</button>
                </form>

</body>
</html>