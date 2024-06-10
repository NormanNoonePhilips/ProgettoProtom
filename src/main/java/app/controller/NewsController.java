package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import app.entity.News;
import app.model.NewsModel;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class NewsController
 */
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NewsModel newsModel;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operazione = request.getParameter("operazione");
		if (operazione == "" || operazione == null) {

		} else {
			switch (operazione) {
			case ("add"):
				request.setAttribute("message", "Inserire i dati dell'utente" + operazione);
				request.getRequestDispatcher("/jsp/add.jsp").forward(request, response);
				break;
			case ("list"):
				List<News> lst = newsModel.GetNewsList();
				request.setAttribute("lstutenti", lst);
				// lst.forEach((u) -> {System.out.println(u.getNome());});
				request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
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
			throw new ServletException("operazione è null");
		} else {
			HttpSession session = request.getSession();
			if (session != null ) {
			switch (operazione) {
			case ("add"):
				News nw = new News(request.getParameter("autore"), request.getParameter("genere"));

				String strDatPub = request.getParameter("DataPublicazione");
				LocalDate dataPubl = LocalDate.parse(strDatPub, DateTimeFormatter.ISO_LOCAL_DATE);
				nw.setDataPublicazione(dataPubl);
				String text = request.getParameter("testo");
				nw.setTesto(text);
				newsModel.saveNews(nw);
				List<News> lst = newsModel.GetNewsList();
				request.setAttribute("lstnews", lst);
				request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
				break;
			case ("delete"):
				String Id = request.getParameter("deleteNW");
				newsModel.DeleteNews(Id);
				List<News> uplst = newsModel.GetNewsList();
				request.setAttribute("lstnews", uplst);
				request.getRequestDispatcher("/jsp/list_utente.jsp").forward(request, response);
				break;
			}
			}else {
				response.sendRedirect("/index.jsp?error=nonAut");
			}
		}
	}
}
