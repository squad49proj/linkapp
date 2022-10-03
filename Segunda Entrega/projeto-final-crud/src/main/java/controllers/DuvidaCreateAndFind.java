package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuvidaDao;
import model.Duvida;

@WebServlet("/DuvidaCreateAndFind")
public class DuvidaCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DuvidaCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Duvida> duvidas = DuvidaDao.find(pesquisa);

		request.setAttribute("duvidas", duvidas);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("duvidas.jsp");
		resquesDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Duvida duvida = new Duvida();

		duvida.setNome(request.getParameter("nome"));
		duvida.setEmail(request.getParameter("email"));
		duvida.setAssunto(request.getParameter("assunto"));
		duvida.setMensagem(request.getParameter("mensagem"));

		DuvidaDao.create(duvida);

		doGet(request, response);
	}

}