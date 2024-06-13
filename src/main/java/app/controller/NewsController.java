package app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import app.entity.News;
import app.entity.Utente;
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
			throw new ServletException("operazione è null");
		} else {
			switch (operazione) {
			case ("add"):
				HttpSession session = request.getSession(false);
				if (session != null) {
					request.getRequestDispatcher("/jsp/FormInserimento.jsp").forward(request,
							response);
				} else {
					response.sendRedirect(request.getContextPath() + "/index.jsp?error=nonAut");
				}
				break;
			case ("list"):
				List<News> lst = newsModel.GetNewsList();
				request.setAttribute("lstnews", lst);
				request.getRequestDispatcher("/jsp/utListNews.jsp").forward(request,
						response);
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
			//HttpSession session = request.getSession(false);
		//	if (session != null) {
				switch (operazione) {
				case ("add"):
					News nw = new News(request.getParameter("autore"), request.getParameter("titolo"), request.getParameter("genere"));

					String strDatPub = request.getParameter("DataPubblicazione");
					LocalDate dataPubl = LocalDate.parse(strDatPub, DateTimeFormatter.ISO_LOCAL_DATE);
					nw.setDataPublicazione(dataPubl);
					String text = request.getParameter("articolo");
					nw.setTesto(text);
					newsModel.saveNews(nw);
					List<News> lst = newsModel.GetNewsList();
					request.setAttribute("lstnews", lst);
					request.getRequestDispatcher("/jsp/adNewsList.jsp").forward(request,
							response);
					break;
				case ("delete"):
					String Id = request.getParameter("deleteNW");
					newsModel.DeleteNews(Id);
					List<News> uplst = newsModel.GetNewsList();
					request.setAttribute("lstnews", uplst);
					request.getRequestDispatcher( "/jsp/adNewsList.jsp").forward(request,
							response);
					break;
				
				case ("list"):
					List<News> lstlst = newsModel.GetNewsList();
					request.setAttribute("lstnews", lstlst);
					request.getRequestDispatcher("/jsp/adNewsList.jsp").forward(request,
					response);
					break;
				case("info"):
					String IdN = request.getParameter("infoNW");
					News inf = newsModel.GetNews(IdN);
					request.setAttribute("InfNews", inf);
					request.getRequestDispatcher( "/jsp/infoNews.jsp").forward(request,
							response);
					break;
				case("update"):
					String Idu = request.getParameter("id");
					News news = newsModel.GetNews(Idu);
					if(request.getParameter("autore") != "")
					news.setTitolo(request.getParameter("titolo"));
					if(request.getParameter("autore") != "")
					news.setAutore(request.getParameter("autore"));
					if(request.getParameter("DataPublicazione") != "") {
						String sd = request.getParameter("DataPublicazione");
						LocalDate ld = LocalDate.parse(sd, DateTimeFormatter.ISO_LOCAL_DATE);
						news.setDataPublicazione(ld);
					}
					if(request.getParameter("articolo") != "")
						news.setTesto(request.getParameter("articolo"));
					newsModel.UpdateNews(news);
					List<News> lstNW = newsModel.GetNewsList();
					request.setAttribute("lstnews", lstNW);
					request.getRequestDispatcher("/jsp/adNewsList.jsp").forward(request, response);
					break;
				case ("updateRed"):
					String idN = request.getParameter("UpdateNW");
					News nwUP = newsModel.GetNews(idN);
					request.setAttribute("News", nwUP);
					request.getRequestDispatcher("/jsp/FormUpdatejsp.jsp").forward(request, response);
					break;
				}
				
//			} else {
		//		response.sendRedirect("/index.jsp?error=nonAut");
	//		}
		}
	}
}
