package tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

import persistance.jdbc.JdbcConnection;

public class TestConnexionJdbc {

	@Test
	public void test() {
		System.out.println("Test Select Count Hotel");
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
	@Test
	public void testSelectMultiple() {
		System.out.println("Test Select id and name isle");
	//	String selectAddressQuery = "SELECT DISTINCT Isle.id_isle AS idIsle,Isle.name AS isleName FROM Isle,Hotel WHERE Isle.id_isle = Hotel.id_isle";
		String selectAddressQuery = "SELECT Isle.id_isle AS idIsle,Isle.name AS isleName FROM Isle";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
			
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				System.out.println(result.getString("idIsle") + " : " + result.getString("isleName"));
			}
			preparedStatement.close();
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
	@Test
	public void testSelectMultiple2() {
		System.out.println("Test Select");
		String selectAddressQuery = "SELECT * FROM TouristicSite";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
			
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				System.out.println(result.getString("id_touristicSite") + " : " + result.getString("name"));
			}
			preparedStatement.close();
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
	
}