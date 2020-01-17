package persistance.jdbc;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import buisness.objects.Transport;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;




public class JdbcPersistance  {
	
	
	public  JdbcPersistance() {}
	
	
	
	public ArrayList<TouristicSite> FetchTourisitcSites(String query) throws Exception {
		ArrayList<TouristicSite> queryResult = new ArrayList<TouristicSite>() ; 			
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(query);
		
		ResultSet result = preparedStatement.executeQuery();
				
		while (result.next()) {
			TouristicSite tourisitcsite  = new TouristicSite();
			tourisitcsite.setName(result.getString("name"));	
			tourisitcsite.setType(result.getString("type"));
			tourisitcsite.setLongitude(result.getFloat("longitude"));
			tourisitcsite.setLatitude(result.getFloat("latitude"));
			tourisitcsite.setPrice(result.getFloat("price"));
			tourisitcsite.setIsleName(result.getString("id_isle"));
			tourisitcsite.setDuration(result.getFloat("duration"));
			tourisitcsite.setDescription(result.getString("description"));
			
			queryResult.add(tourisitcsite);
		}
	preparedStatement.close();
	return queryResult;				
}

	
	public ArrayList<Transport> FetchTransports(String query) throws Exception{
		ArrayList<Transport> queryResult = new ArrayList<Transport>() ;
		String selectAddressQuery = query;
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
		
		ResultSet result = preparedStatement.executeQuery();
		
		while (result.next()) {
			Transport transport  = new Transport();
			transport.setType(result.getString("type"));
			transport.setKilometerPrice(result.getFloat("kilometerPrice"));
			transport.setKilometerDuration(result.getFloat("kilometerDuration"));
			
			queryResult.add(transport);
	
		}	
		preparedStatement.close();
		return queryResult;
	}

	
	public ArrayList<Hotel> FetchHotels(String query) throws Exception{
		System.out.println(query);
		ArrayList<Hotel> queryResult = new ArrayList<Hotel>() ; 
		String selectAddressQuery = query;
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

		ResultSet result = preparedStatement.executeQuery();
		
		while (result.next()) {
			Hotel hotel  = new Hotel();
			hotel.setName(result.getString("name"));
			hotel.setBeach(result.getString("beach"));
			hotel.setPrice(result.getFloat("price")) ;
			hotel.setLongitude(result.getFloat("longitude")) ;
			hotel.setLatitude(result.getFloat("latitude")) ;
			hotel.setRating(result.getFloat("rating"));
			hotel.setIsleName(result.getString("isleName")) ;
			
			queryResult.add(hotel);
		}
		preparedStatement.close();
		return queryResult;		
	}
	
	public void insertTouristicSite(TouristicSite touristicsite) throws Exception{
		ArrayList<Hotel> queryResult = new ArrayList<Hotel>() ; 
		String selectAddressQuery = " insert into Touristicsite ("
				+ "name, type, description, longitude, latitude,price,IsleNamen,duration) "
				+ "values ("+touristicsite.getName()+","+touristicsite.getType()+","+touristicsite.getPrice()+","+touristicsite.getIsleName()+", "+touristicsite.getDuration()+")";
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
	
		ResultSet result = preparedStatement.executeQuery();
		
		preparedStatement.close();
	}
}




