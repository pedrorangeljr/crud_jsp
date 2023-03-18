package conexao;

import java.sql.Connection;

public class SinlgeConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/crud3?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;

}
