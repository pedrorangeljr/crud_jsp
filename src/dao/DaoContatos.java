package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.SinlgeConnection;
import model.Contatos;

public class DaoContatos {

	private Connection connection;

	public DaoContatos() {

		connection = SinlgeConnection.getConnection();
	}

	/* Metodo Salvar Contatos */

	public void salvarContatos(Contatos contato) throws SQLException {

		String sql = "INSERT INTO contato(nome,telefone,email,login,senha)VALUES(?,?,?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);

		insert.setString(1, contato.getNome());
		insert.setString(2, contato.getTelefone());
		insert.setString(3, contato.getEmail());
		insert.setString(4, contato.getLogin());
		insert.setString(5, contato.getSenha());
		insert.execute();

		connection.commit();
	}

	/* Metodo listar contatos */

	public List<Contatos> listarContatos() throws Exception {

		List<Contatos> listar = new ArrayList<Contatos>();

		String sql = "SELECT * FROM contato";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();

		while (resultSet.next()) {

			Contatos contatos = new Contatos();

			contatos.setId(resultSet.getLong("id"));
			contatos.setNome(resultSet.getString("nome"));
			contatos.setTelefone(resultSet.getString("telefone"));
			contatos.setEmail(resultSet.getString("email"));
			contatos.setLogin(resultSet.getString("login"));

			listar.add(contatos);
		}

		return listar;
	}

	/* metodo deletar por ID */

	public void delete(String id) {

		try {

			String sql = "DELETE FROM contato WHERE id = '" + id + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();

			connection.commit();

		} catch (Exception e) {

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		}
	}
	
	/*Metodo consultar*/
	
	public Contatos consultar(String id) throws Exception{
		
		String sql = "SELECT * FROM contato WHERE id = '"+id+"'";
		PreparedStatement consultar = connection.prepareStatement(sql);
		ResultSet resultSet = consultar.executeQuery();
		
		while(resultSet.next()) {
			
			Contatos contato = new Contatos();
			
			contato.setId(resultSet.getLong("id"));
			contato.setNome(resultSet.getString("nome"));
			contato.setTelefone(resultSet.getString("telefone"));
			contato.setEmail(resultSet.getString("email"));
			contato.setLogin(resultSet.getString("login"));
			contato.setSenha(resultSet.getString("senha"));
			
			return contato;
		}
		
		return null;
	}
	
	/*Metodo atualizar*/
	
	public void atualizar(Contatos contato) {
		
		try {
			
			String sql = "UPDATE contato SET nome = ?, telefone = ?, email = ?, login= ?, senha = ? WHERE id = " + contato.getId();
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, contato.getNome());
			update.setString(2, contato.getTelefone());
			update.setString(3, contato.getEmail());
			update.setString(4, contato.getLogin());
			update.setString(5, contato.getSenha());
			update.executeUpdate();
			
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				
				connection.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			e.printStackTrace(); // imprime a pilha de erro no console
		}
	}
}
