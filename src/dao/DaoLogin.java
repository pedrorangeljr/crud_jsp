package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.SinlgeConnection;

public class DaoLogin {
	
	private Connection connection;
	
	public DaoLogin() {
		
		connection = SinlgeConnection.getConnection();
	}

	public boolean validarLogin(String login, String senha) throws Exception {
		
		String sql = "SELECT * FROM contato WHERE login = '"+login+"' and senha = '"+senha+"'";
		PreparedStatement valida = connection.prepareStatement(sql);
		ResultSet resultSet = valida.executeQuery();
		
		if(resultSet.next()) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
}
