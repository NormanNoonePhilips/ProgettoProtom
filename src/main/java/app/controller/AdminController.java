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
import app.model.AdminModel;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminModel adminModel;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operazione = request.getParameter("operazione");
		switch (operazione) {
		case ("add"):
			HttpSession session = request.getSession(false);
			if (session != null) {
				request.getRequestDispatcher(request.getContextPath() + "/jsp/addAdmin.jsp").forward(request, response);
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
			request.getRequestDispatcher(request.getContextPath() + "/jsp/lista-admin.jsp").forward(request, response);
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
				response.sendRedirect("/index.jsp");
			}
			request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request, response);
			break;

		case ("logout"):
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		case ("list"):
			List<Admin> lstad = adminModel.GetAdminList();
			request.setAttribute("lstadmin", lstad);
			request.getRequestDispatcher("/jsp/lista-admin.jsp").forward(request, response);
			break;

		}
	}
}