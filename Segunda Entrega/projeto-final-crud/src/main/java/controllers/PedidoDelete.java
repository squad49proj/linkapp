package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;

@WebServlet("/PedidoDelete")
public class PedidoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PedidoDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
		PedidoDao.delete(pedidoId);

		PedidoCreateAndFind pedidoCreateAndFind = new PedidoCreateAndFind();
		pedidoCreateAndFind.doGet(request, response);

	}

}
