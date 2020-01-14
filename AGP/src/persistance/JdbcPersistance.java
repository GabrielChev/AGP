package persistance;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class JdbcPersistance  {
	
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
	}

	
	

	private void addClient(int idEntry) {
		try {

			String insertAddressQuery = "INSERT INTO client (arrival_time, service_start_time, departure_time, "
					+ "is_served, priority, entry_id) VALUES (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(insertAddressQuery);

		

			preparedStatement.executeUpdate();

			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
}
	



