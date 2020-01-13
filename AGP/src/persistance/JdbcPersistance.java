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

			preparedStatement.setInt(1, client.getArrivalTime());
			preparedStatement.setInt(2, client.getServiceStartTime());
			preparedStatement.setInt(3, client.getDepartureTime());
			preparedStatement.setBoolean(4, isServed);
			preparedStatement.setBoolean(5, client.isPriority());
			preparedStatement.setInt(6, idEntry);

			preparedStatement.executeUpdate();

			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}
}
	



