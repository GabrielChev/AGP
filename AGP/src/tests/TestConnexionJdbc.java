package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.PreparedStatement;

import persistance.JdbcConnection;

class TestConnexionJdbc {

	@Test
	void test() {
		int idEntry = 0;
		try {
		
			
			String selectAddressQuery = "SELECT count(*) as co FROM Hotel";
			PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

			ResultSet result = preparedStatement.executeQuery();

			result.next();
			System.out.println(result.getInt("co"));

			preparedStatement.close();
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
}