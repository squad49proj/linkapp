package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/CreateAndFind")
public class UsuarioCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioCreateAndFind() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Usuario> usuarios = UsuarioDao.find(pesquisa);

		request.setAttribute("usuarios", usuarios);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("listaUsuario.jsp");// lista.jsp
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* =====Cadastro user===== */
		Usuario usuario = new Usuario();

		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setSexo(request.getParameter("sexo"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setComplemento(request.getParameter("complemento"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setEstado(request.getParameter("estado"));
		usuario.setCep(request.getParameter("cep"));
		usuario.setTipoUsuario(request.getParameter("tipoUsuario"));

		UsuarioDao.create(usuario);
		doGet(request, response);
	}

}
