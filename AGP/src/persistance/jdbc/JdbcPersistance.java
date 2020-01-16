package persistance.jdbc;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import buisness.objects.Transport;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;




public class JdbcPersistance  {
	
	
	public  JdbcPersistance() {}
	
	
	
	public ArrayList<TouristicSite>  FetchTourisitcSites(String query) throws Exception {
		ArrayList<TouristicSite> queryResult = new ArrayList<TouristicSite>() ; 
			
				PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(query);

				ResultSet result = preparedStatement.executeQuery();
				TouristicSite tourisitcsite  = new TouristicSite();
		
				
		while (result.next()) {
			 
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
	
	public ArrayList<Transport> FetchTransportsWays(String query) throws Exception{
		ArrayList<Transport> queryResult = new ArrayList<Transport>() ;
		String selectAddressQuery = query;
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

		ResultSet result = preparedStatement.executeQuery();
		Transport transport  = new Transport();
		while (result.next()) {
			transport.setType(result.getString("type"));
			transport.setKilometerPrice(result.getFloat("kilometerPrice"));
			transport.setKilometerDuration(result.getFloat("kilometerDuration"));
			
			queryResult.add(transport);
	
		}
		
		preparedStatement.close();
		return queryResult;
		
}

	
	
	public ArrayList<Hotel> FetchHotels(String query) throws Exception{
		ArrayList<Hotel> queryResult = new ArrayList<Hotel>() ; 
		String selectAddressQuery = query;
		PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

		ResultSet result = preparedStatement.executeQuery();
		Hotel hotel  = new Hotel();
		while (result.next()) {
			
			hotel.setName(result.getString("name"));
			hotel.setBeach(result.getString("beach"));
			hotel.setPrice(result.getFloat("price")) ;
			hotel.setLongitude(result.getFloat("longitude")) ;
			hotel.setLatitude(result.getFloat("laitude")) ;
			hotel.setRating(result.getFloat("rating"));
			hotel.setIsleName(result.getString("isleName")) ;
			
			queryResult.add(hotel);
	
		}
		
		preparedStatement.close();
		return queryResult;
		
}
	
}




