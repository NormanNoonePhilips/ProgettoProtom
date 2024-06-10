package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
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
		if (operazione == "" || operazione == null) {
			throw new ServletException("operazione è null");
			
		} else {
			switch (operazione) {
			case ("add"):
				request.setAttribute("message", "Inserire i dati dell'utente" + operazione);
				request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
				break;
			case ("list"):
				List<Utente> lst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", lst);
				// lst.forEach((u) -> {System.out.println(u.getNome());});
				request.getRequestDispatcher("/jsp/DavListTest.jsp").forward(request, response);
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");
		if (operazione == "" || operazione == null) {

		} else {
			switch (operazione) {
			case ("add"):
				Utente ut = new Utente(request.getParameter("nome"), request.getParameter("cognome"),
						request.getParameter("email"));
				String strDatNat = request.getParameter("DataNascita");
				LocalDate datanasc = LocalDate.parse(strDatNat, DateTimeFormatter.ISO_LOCAL_DATE);
				Period p = Period.between(datanasc, LocalDate.now());
				int eta = p.getYears();
				if (eta < 18) {
					System.out.println("error");
				response.sendRedirect("/Fila1/jsp/testDav.jsp?errore=etaNonValida");
				break;
				}
				ut.setDatanasc(datanasc);
				utenteModel.saveUtente(ut);
				List<Utente> lst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", lst);
				request.getRequestDispatcher("/jsp/DavListTest.jsp").forward(request, response);
				break;
			case ("delete"):
				String Id = request.getParameter("deleteUT");
				utenteModel.DeleteUtente(Id);
				List<Utente> uplst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", uplst);
				request.getRequestDispatcher("/jsp/DavListTest.jsp").forward(request, response);
				break;
			}
		}

	}
}