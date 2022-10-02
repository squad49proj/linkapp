package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Pedido;

public class PedidoDao implements CRUDREQUESTS {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Pedido pedido) {
		sql = "INSERT INTO requests VALUES (null, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, pedido.getNome());
			preparedStatement.setString(2, pedido.getEquip());
			preparedStatement.setString(3, pedido.getRelato());
			preparedStatement.setString(4, pedido.getCpf());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}
	}

	public static void delete(int pedidoId) {
		sql = "DELETE FROM requests WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, pedidoId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on requests");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on requests. " + e.getMessage());
		}
	}

	public static List<Pedido> find(String pesquisa) {

		sql = String.format("SELECT * FROM requests WHERE cpf like '%s%%';", pesquisa);

		List<Pedido> pedidos = new ArrayList<Pedido>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Pedido pedido = new Pedido();

				pedido.setId(resultSet.getInt("id"));
				pedido.setEquip(resultSet.getString("equip"));
				pedido.setRelato(resultSet.getString("relato"));
				pedido.setCpf(resultSet.getString("cpf"));
				pedido.setNome(resultSet.getString("nome"));

				pedidos.add(pedido);

			}

			System.out.println("--correct find requests");
			return pedidos;

		} catch (SQLException e) {
			System.out.println("--incorrect find requests. " + e.getMessage());
			return null;
		}

	}

	public static Pedido findByPk(int pedidoId) {
		sql = String.format("SELECT * FROM requests WHERE id = %d ", pedidoId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Pedido pedido = new Pedido();

			while (resultSet.next()) {
				pedido.setId(resultSet.getInt("id"));
				pedido.setEquip(resultSet.getString("equip"));
				pedido.setRelato(resultSet.getString("relato"));
				pedido.setCpf(resultSet.getString("cpf"));
				pedido.setNome(resultSet.getString("nome"));
			}

			System.out.println("--correct find by pk requests");
			return pedido;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk requests. " + e.getMessage());
			return null;
		}
	}

	public static void update(Pedido pedido) {
		sql = "UPDATE requests SET nome=?, equip=?, relato=?, cpf=? WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, pedido.getNome());
			preparedStatement.setString(2, pedido.getEquip());
			preparedStatement.setString(3, pedido.getRelato());
			preparedStatement.setString(4, pedido.getCpf());
			preparedStatement.setInt(5, pedido.getId());

			preparedStatement.executeUpdate();

			System.out.println("--correct update on database");

		} catch (SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());
		}
	}
}
