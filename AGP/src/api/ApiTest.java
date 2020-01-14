package api;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ApiTest {
	public static void main (String[] argv) throws SQLException {
		try {
			new ApiLucene().sqlJoinLuceneQuery("SELECT name,type,longitude,latitude,id_isle FROM TouristicSite with musée");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
