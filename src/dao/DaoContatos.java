package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.SinlgeConnection;
import model.Contatos;

public class DaoContatos {
	
	private Connection connection;
	
	public DaoContatos() {
		
		connection = SinlgeConnection.getConnection();
	}
	
	/*Metodo Salvar Contatos*/
	
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
	
	
	/* Metododo responsavel por  Validar Login */

	public boolean validarLogin(String login) {

		try {

			String sql = "select count(1) as quantidade from contato where login = '" + login + "'";
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet resultSet = consultar.executeQuery();

			if (resultSet.next()) {

				return resultSet.getInt("quantidade") <= 0; // Return True
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
	
	 /* Metodo responsavel por validar senha*/
	
		public boolean validarSenha(String senha) {

			try {

				String sql = "select count(1) as quantidade from contato where senha = '" + senha + "'";
				PreparedStatement consultar = connection.prepareStatement(sql);
				ResultSet resultSet = consultar.executeQuery();

				if (resultSet.next()) {

					return resultSet.getInt("quantidade") <= 0; // Return True
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			return false;
		}

}
