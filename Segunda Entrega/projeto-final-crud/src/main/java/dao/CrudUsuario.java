package dao;

import java.util.List;

import model.Usuario;

public interface CrudUsuario {
	public static void create(Usuario usuario){}
	
	public static void delete(int UsuarioId){}
	
	public static List<Usuario> find(String pesquisa){return null;}
	
	public static Usuario findByPk(int usuarioId) {return null;}
	
	public static void update(Usuario usuario) {}
}
