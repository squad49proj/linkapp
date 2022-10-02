package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Usuario;

public class UsuarioDao implements CrudUsuario{
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	
	public static void create(Usuario usuario) {
		String sql = "INSERT INTO usuario VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getCpf());
			preparedStatement.setString(3, usuario.getSexo());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, usuario.getSenha());
			preparedStatement.setString(6, usuario.getEndereco());
			preparedStatement.setString(7, usuario.getComplemento());
			preparedStatement.setString(8, usuario.getCidade());
			preparedStatement.setString(9, usuario.getEstado());
			preparedStatement.setString(10, usuario.getCep());
			preparedStatement.setString(11, usuario.getTipoUsuario());
			
			
			
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct insert on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect insert on database" + e.getMessage());
			
		}
		
	}
	
	public static void delete(int UsuarioId) {
		String sql = "DELETE FROM usuario WHERE id= ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, UsuarioId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on user");
			
		}catch(SQLException e){
			
			System.out.println("--incorrect delete on user"+ e.getMessage());
			
			
		}
		
		
	}
	
	public static List<Usuario> find(String pesquisa){
		
		String sql = String.format("SELECT * FROM usuario WHERE cpf LIKE '%s%%' or nome LIKE '%s%%' ", pesquisa,pesquisa);
		List<Usuario> usuario = new ArrayList<Usuario>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Usuario usuarios = new Usuario();
				
				usuarios.setId(resultSet.getInt("id"));
				usuarios.setNome(resultSet.getString("nome"));
				usuarios.setCpf(resultSet.getString("cpf"));
				usuarios.setSexo(resultSet.getString("sexo"));
				usuarios.setEmail(resultSet.getString("email"));
				usuarios.setSenha(resultSet.getString("senha"));
				usuarios.setEndereco(resultSet.getString("endereco"));
				usuarios.setComplemento(resultSet.getString("complemento"));
				usuarios.setCidade(resultSet.getString("cidade"));
				usuarios.setEstado(resultSet.getString("estado"));
				usuarios.setCep(resultSet.getString("cep"));
				usuarios.setTipoUsuario(resultSet.getString("tipoUsuario"));
				
				usuario.add(usuarios);
						
			}
			System.out.println("--Correct find user. ");
			return usuario;
			
		}catch(SQLException e){
			System.out.println("--Incorrect find user" + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	/*Search user from Id*/
	public static Usuario findByPk(int usuarioId) {
		String sql = String.format("SELECT * FROM usuario WHERE id= %d",usuarioId);
				
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Usuario usuario = new Usuario();
			
			while(resultSet.next()) {
				
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setSexo(resultSet.getString("sexo"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setEndereco(resultSet.getString("endereco"));
				usuario.setComplemento(resultSet.getString("complemento"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setCep(resultSet.getString("cep"));
				usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));
			}
			
			System.out.println("--Correct find by id user. ");
			return usuario;
			
		}catch(SQLException e){
			
			System.out.println("--Incorrect find user" + e.getMessage());
			return null;
			
		}
		
		
		
		
		
	}
	public static void update(Usuario usuario) {
		sql = "UPDATE usuario SET nome=?, cpf=?,sexo=?, email=?, senha=?, endereco=?,complemento=?, cidade=?, estado=?, cep=?, tipoUsuario=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getCpf());
			preparedStatement.setString(3, usuario.getSexo());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, usuario.getSenha());
			preparedStatement.setString(6, usuario.getEndereco());
			preparedStatement.setString(7, usuario.getComplemento());
			preparedStatement.setString(8, usuario.getCidade());
			preparedStatement.setString(9, usuario.getEstado());
			preparedStatement.setString(10, usuario.getCep());
			preparedStatement.setString(11, usuario.getTipoUsuario());
			preparedStatement.setInt(12, usuario.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Correct update on database");
			
		}catch(SQLException e){
			System.out.println("--Incorrect update on database" + e.getMessage());
			
		}
		
	}
	
	

}
