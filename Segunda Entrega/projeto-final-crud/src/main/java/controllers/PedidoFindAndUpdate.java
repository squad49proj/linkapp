package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import model.Pedido;

@WebServlet("/PedidoUpdate")
public class PedidoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PedidoFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
		Pedido pedido = PedidoDao.findByPk(pedidoId);

		request.setAttribute("pedido", pedido);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formPedidoUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Pedido pedido = new Pedido();

		pedido.setId(Integer.parseInt(request.getParameter("id")));
		pedido.setNome(request.getParameter("nome"));
		pedido.setEquip(request.getParameter("equip"));
		pedido.setRelato(request.getParameter("relato"));
		pedido.setCpf(request.getParameter("cpf"));

		PedidoDao.update(pedido);

		PedidoCreateAndFind pedidoCreateAndFind = new PedidoCreateAndFind();
		pedidoCreateAndFind.doGet(request, response);
	}

}
