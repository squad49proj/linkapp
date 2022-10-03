package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuvidaDao;

@WebServlet("/DuvidaDelete")
public class DuvidaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DuvidaDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int duvidaId = Integer.parseInt(request.getParameter("duvidaId"));
		DuvidaDao.delete(duvidaId);

		DuvidaCreateAndFind duvidaCreateAndFind = new DuvidaCreateAndFind();
		duvidaCreateAndFind.doGet(request, response);

	}

}
