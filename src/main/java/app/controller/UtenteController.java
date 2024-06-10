package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import app.entity.Utente;
import app.model.UtenteModel;
import jakarta.inject.Inject;


/**
 * Servlet implementation class UtenteController
 */

public class UtenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UtenteModel utenteModel;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");
		switch (operazione) {
		case ("add"):
			request.setAttribute("message", "Inserire i dati dell'utente" + operazione);
			request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
			break;
		case ("list"):
			List<Utente> lst = utenteModel.GetUtenteList();
			request.setAttribute("lstutenti", lst);
		//	lst.forEach((u) -> {System.out.println(u.getNome());});
			request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
			break;
/*		case ("update"):
			String ut = request.getParameter("UpdateUT");
			Utente u = utenteModel.GetUtente(ut);
			request.setAttribute("Utente", u);
			request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
			break;
			
	*/	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");
		
		switch (operazione) {
		case ("add"):
			Utente ut = new Utente(request.getParameter("nome"),request.getParameter("cognome"), 
							request.getParameter("email"));
			String strDatNat = request.getParameter("DataNascita");
			LocalDate datanasc = LocalDate.parse(strDatNat, DateTimeFormatter.ISO_LOCAL_DATE);
			ut.setDatanasc(datanasc);
			utenteModel.saveUtente(ut);
			List<Utente> lst = utenteModel.GetUtenteList();
			request.setAttribute("lstutenti", lst);
			request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
			break;
	/*	case("update"):
			String Idu = request.getParameter("id");
			Utente utu = utenteModel.GetUtente(Idu);
			if(request.getParameter("nome") != "")
			utu.setNome(request.getParameter("nome"));
			if(request.getParameter("cognome") != "")
			utu.setCognome(request.getParameter("cognome"));
			if(request.getParameter("email") != "")
			utu.setEmail(request.getParameter("email"));
			utenteModel.UpdateUtente(utu);
			List<Utente> lstUP = utenteModel.GetUtenteList();
			request.setAttribute("lstutenti", lstUP);
			request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
	
			break;
	*/	case("delete"):
			String Id = request.getParameter("deleteUT");
			utenteModel.DeleteUtente(Id);
			List<Utente> uplst = utenteModel.GetUtenteList();
			request.setAttribute("lstutenti", uplst);
			request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
			break;
	}

}
}