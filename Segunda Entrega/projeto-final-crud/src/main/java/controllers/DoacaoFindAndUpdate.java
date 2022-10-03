package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;
import model.Doacao;

@WebServlet("/DoacaoUpdate")
public class DoacaoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoacaoFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int doacaoId = Integer.parseInt(request.getParameter("doacaoId"));
		Doacao doacao = DoacaoDao.findByPk(doacaoId);

		request.setAttribute("doacao", doacao);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formPedidoUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Doacao doacao = new Doacao();

		doacao.setId(Integer.parseInt(request.getParameter("id")));
		doacao.setNome(request.getParameter("nome"));
		doacao.setEmail(request.getParameter("equip"));
		doacao.setQuantia(request.getParameter("relato"));

		DoacaoDao.update(doacao);

		DoacaoCreateAndFind doacaoCreateAndFind = new DoacaoCreateAndFind();
		doacaoCreateAndFind.doGet(request, response);
	}

}
