package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Duvida;

public class DuvidaDao implements CRUDDOACAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Duvida duvida) {
		sql = "INSERT INTO duvidas VALUES (null, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, duvida.getNome());
			preparedStatement.setString(2, duvida.getEmail());
			preparedStatement.setString(3, duvida.getAssunto());
			preparedStatement.setString(4, duvida.getMensagem());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	};

	public static void delete(int duvidaId) {

		sql = "DELETE FROM duvidas WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, duvidaId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on doacao");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on doacao. " + e.getMessage());

		}

	}

	public static List<Duvida> find(String pesquisa) {

		sql = String.format("SELECT * FROM duvidas WHERE nome like '%s%%' OR email LIKE '%s%%' ", pesquisa, pesquisa);
		List<Duvida> duvidas = new ArrayList<Duvida>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Duvida duvida = new Duvida();

				duvida.setId(resultSet.getInt("id"));
				duvida.setNome(resultSet.getString("nome"));
				duvida.setEmail(resultSet.getString("email"));
				duvida.setAssunto(resultSet.getString("assunto"));
				duvida.setMensagem(resultSet.getString("mensagem"));

				duvidas.add(duvida);
			}

			System.out.println("--correct find duvidas");
			return duvidas;

		} catch (SQLException e) {
			System.out.println("--incorrect find duvidas. " + e.getMessage());
			return null;
		}

	}

	public static Duvida findByPk(int duvidaId) {

		return null;

	}

	public static void update(Duvida duvida) {

	}
}