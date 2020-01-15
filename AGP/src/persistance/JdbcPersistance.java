package persistance;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import buisness.objects.TouristicSite;



public class JdbcPersistance  {
	
	
	
	public TouristicSite selectTouristicSiteByPath(String descriptionAttribut) {
		TouristicSite site = null;
		try {
			String isle;
			String name, type = null, description = null;
			float longitude = 0, latitude = 0, price = 0;
			
			String selectAddressQuery = "SELECT name,type,description,longitude,lattitude,price,Isle.name AS isle FROM TouristicSite,Isle WHERE description = ? AND Isle.id_island = TouristicSite.id_isle";
				
			PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

			preparedStatement.setString(1, descriptionAttribut);
			
			ResultSet result = preparedStatement.executeQuery();

			while(result.next()){
				name = result.getString("name");
				type = result.getString("type");
				description = result.getString("description");
				longitude = result.getFloat("longitude");
				latitude = result.getFloat("lattitude");
				price = result.getFloat("price");
				isle = result.getString("isle");
				
				site.setName(name);
				site.setDescription(description);
				site.setLatitude(latitude);
				site.setLongitude(longitude);
				site.setType(type);
				// TODO ADD isle and price
			}
			preparedStatement.close();
			
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return site;
	}
	
	
	
/*	private void addClient(int idEntry) {
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
*/
	
}
	



