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

	/*Metodo listar contatos*/
	
	public List<Contatos> listarContatos() throws Exception{
		
		List<Contatos> listar = new ArrayList<Contatos>();
		
		String sql = "SELECT * FROM contato";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();
		
		while(resultSet.next()) {
			
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
}
