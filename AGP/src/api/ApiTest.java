package api;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ApiTest {
	public static void main (String[] argv) throws SQLException {

			

			try {
				new ApiLucene().sqlJoinLuceneQuery("SELECT name,type,longitude,latitude,id_isle,description FROM TouristicSite WHERE type= 'historic' with musée mosquée");
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		
		
	}
	
}
