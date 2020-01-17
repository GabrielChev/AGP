package persistance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import buisness.objects.TouristicSite;

public class test {

	public static void main(String[] args) {
		String query = "Select * from Hotel";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		
	}

}
