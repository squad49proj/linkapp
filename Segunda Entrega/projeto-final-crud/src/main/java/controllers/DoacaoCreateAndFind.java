package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;
import model.Doacao;

@WebServlet("/DoacaoCreateAndFind")
public class DoacaoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoacaoCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Doacao> doacoes = DoacaoDao.find(pesquisa);

		request.setAttribute("doacoes", doacoes);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("doacoes.jsp");
		resquesDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Doacao doacao = new Doacao();

		doacao.setNome(request.getParameter("nome"));
		doacao.setEmail(request.getParameter("email"));
		doacao.setQuantia(request.getParameter("quantia"));

		DoacaoDao.create(doacao);

		doGet(request, response);
	}

}
