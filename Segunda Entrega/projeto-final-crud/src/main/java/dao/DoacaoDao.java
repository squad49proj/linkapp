package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Doacao;

public class DoacaoDao implements CRUDDOACAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Doacao doacao) {
		sql = "INSERT INTO doacao VALUES (?, ?, ?, null)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, doacao.getNome());
			preparedStatement.setString(2, doacao.getEmail());
			preparedStatement.setString(3, doacao.getQuantia());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	};

	public static void delete(int doacaoId) {

		sql = "DELETE FROM doacao WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, doacaoId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on doacao");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on doacao. " + e.getMessage());

		}

	}

	public static List<Doacao> find(String pesquisa) {

		sql = String.format("SELECT * FROM doacao WHERE nome like '%s%%' OR email LIKE '%s%%' ", pesquisa, pesquisa);
		List<Doacao> doacoes = new ArrayList<Doacao>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Doacao doacao = new Doacao();

				doacao.setNome(resultSet.getString("nome"));
				doacao.setEmail(resultSet.getString("email"));
				doacao.setQuantia(resultSet.getString("quantia"));
				doacao.setId(resultSet.getInt("id"));

				doacoes.add(doacao);
			}

			System.out.println("--correct find doacoes");
			return doacoes;

		} catch (SQLException e) {
			System.out.println("--incorrect find doacoes. " + e.getMessage());
			return null;
		}

	}

	public static Doacao findByPk(int DoacaoId) {

		return null;

	}

	public static void update(Doacao doacao) {

	}
}