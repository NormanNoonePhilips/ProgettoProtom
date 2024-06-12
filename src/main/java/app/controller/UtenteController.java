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
import jakarta.servlet.http.HttpSession;
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
				request.getRequestDispatcher("/index.jsp").forward(request, response);
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
				response.sendRedirect("index.jsp?errore=etaNonValida");
				break;
				}
				ut.setDatanasc(datanasc);
				utenteModel.saveUtente(ut);
				List<Utente> lst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", lst);
				request.getRequestDispatcher( "/jsp/archivio-iscritti.jsp").forward(request, response);
				break;
			case ("delete"):
				HttpSession session = request.getSession(false);
			if (session != null) {
				String Id = request.getParameter("deleteUT");
				utenteModel.DeleteUtente(Id);
				List<Utente> uplst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", uplst);
				request.getRequestDispatcher("/jsp/archivio-iscritti.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/index.jsp?error=nonAut");
			}
				break;
			case ("list"):
				List<Utente> lstlst = utenteModel.GetUtenteList();
				request.setAttribute("lstutenti", lstlst);
				HttpSession session2 = request.getSession(false);
				session2.invalidate();
				request.getRequestDispatcher("/jsp/archivio-iscritti.jsp").forward(request, response);
				break;
			
			}
		}

	}
}