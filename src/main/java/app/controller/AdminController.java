package app.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.inject.Inject;

import app.entity.Admin;
import app.entity.News;
import app.model.AdminModel;
import app.model.NewsModel;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminModel adminModel;
	@Inject
	private NewsModel newsModel;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");
		switch (operazione) {
		case ("add"):
			HttpSession session = request.getSession(false);
			if (session != null) {
				request.getRequestDispatcher("/jsp/AddAdmin.jsp").forward(request, response);
			}
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");

		switch (operazione) {

		case ("add"):
			Admin ad = new Admin(request.getParameter("nome"), request.getParameter("cognome"),
					request.getParameter("username"), request.getParameter("password"));
			adminModel.saveAdmin(ad);
			List<Admin> lst = adminModel.GetAdminList();
			request.setAttribute("lstadmin", lst);
			request.getRequestDispatcher("/jsp/lista-admin.jsp").forward(request, response);
			break;

		case ("delete"):
			String Id = request.getParameter("deleteAD");
			adminModel.DeleteAdmin(Id);
			List<Admin> uplst = adminModel.GetAdminList();
			request.setAttribute("lstadmin", uplst);
			request.getRequestDispatcher("/jsp/lista-admin.jsp").forward(request, response);
			break;

		case ("login"):
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean flag = adminModel.LoginAdmin(username, password);
			if (flag) {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
			} else {
				request.getRequestDispatcher("/home-admin").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/jsp/home-admin.jsp").forward(request, response);
			break;

		case ("logout"):
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			List<News> lst2 = newsModel.GetNewsList();
			request.setAttribute("lstnews", lst2);
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		case ("list"):
			List<Admin> lstad = adminModel.GetAdminList();
			request.setAttribute("lstadmin", lstad);
			request.getRequestDispatcher("/jsp/lista-admin.jsp").forward(request, response);
			break;

		}
	}
}