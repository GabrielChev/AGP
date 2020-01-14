package persistance;


import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	private static String host = "mysql-projetagp.alwaysdata.net";
	private static String base = "projetagp_base";
	private static String user = "projetagp";
	private static String password = "projet2020";
	private static String url = "jdbc:mysql://" + host + "/" + base;

	/**
	 * Lazy singleton instance.
	 */
	private static Connection connection;


	public static Connection getConnection() {
		if (connection == null) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
		return connection;
	}
}
