package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;

@WebServlet("/DoacaoDelete")
public class DoacaoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoacaoDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int doacaoId = Integer.parseInt(request.getParameter("doacaoId"));
		DoacaoDao.delete(doacaoId);

		DoacaoCreateAndFind doacoaCreateAndFind = new DoacaoCreateAndFind();
		doacoaCreateAndFind.doGet(request, response);

	}

}