package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;


@WebServlet("/UsuarioUpdate")
public class UsuarioFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UsuarioFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*===== Search for a customer by id. ======*/
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		Usuario usuario = UsuarioDao.findByPk(usuarioId);
		
		request.setAttribute("usuario", usuario);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("formUpdateUser.jsp");
		resquesDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(Integer.parseInt(request.getParameter("id")));
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
		
		UsuarioDao.update(usuario);
		UsuarioCreateAndFind usuarioCreateAndFind = new UsuarioCreateAndFind();
		usuarioCreateAndFind.doGet(request, response);
		
	}

}
