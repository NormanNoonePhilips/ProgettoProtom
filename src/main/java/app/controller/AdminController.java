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
			request.setAttribute("message", "Inserire i dati dell'admin" + operazione);
			break;
		case ("list"):
			List<Admin> lst = adminModel.GetAdminList();
			request.setAttribute("lstadmin", lst);
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
			break;

		case ("delete"):
			String Id = request.getParameter("deleteAD");
			adminModel.DeleteAdmin(Id);
			List<Admin> uplst = adminModel.GetAdminList();
			request.setAttribute("lstadmin", uplst);
			break;

		case ("login"):
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean flag = adminModel.LoginAdmin(username, password);
			if (flag) {
				HttpSession session = request.getSession();
			} else {
				response.sendRedirect("/index.jsp");
			}
			break;

		case ("logout"):
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}

		}
	}
}