package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import model.Pedido;

@WebServlet("/PedidoCreateAndFind")
public class PedidoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PedidoCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Pedido> pedidos = PedidoDao.find(pesquisa);

		request.setAttribute("pedidos", pedidos);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("request.jsp");
		resquesDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Pedido pedido = new Pedido();

		pedido.setEquip(request.getParameter("equip"));
		pedido.setRelato(request.getParameter("relato"));
		pedido.setCpf(request.getParameter("cpf"));
		pedido.setNome(request.getParameter("nome"));

		PedidoDao.create(pedido);

		doGet(request, response);
	}

}
