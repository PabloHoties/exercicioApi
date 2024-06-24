package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {

	public void insert(Contato contato) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO contato (nome, email, telefone) VALUES (?,?,?)");
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();
		if (resultSet.next())
			contato.setIdContato(resultSet.getInt(1));

		connection.close();
	}

	public void update(Contato contato) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("UPDATE contato SET nome=?, email=?, telefone=? WHERE idContato=?");
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setInt(4, contato.getIdContato());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("DELETE FROM contato WHERE idContato=?");
		statement.setInt(1, id);
		statement.execute();

		connection.close();
	}

	public Contato findById(Integer id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("SELECT idContato, nome, email, telefone FROM contato WHERE idContato=?");
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		Contato contato = null;

		if (resultSet.next()) {

			contato = new Contato();
			contato.setIdContato(resultSet.getInt("idContato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
		}
		connection.close();
		return contato;
	}

	public List<Contato> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("SELECT idContato, nome, email, telefone FROM contato");

		ResultSet resultSet = statement.executeQuery();

		List<Contato> contatos = new ArrayList<Contato>();

		while (resultSet.next()) {

			Contato contato = new Contato();
			contato.setIdContato(resultSet.getInt("idContato"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));

			contatos.add(contato);
		}
		connection.close();
		return contatos;
	}
}
