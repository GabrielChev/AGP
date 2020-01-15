package api;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ApiTest {
	public static void main (String[] argv) throws SQLException {
		try {
			String path = path = new File(".").getCanonicalPath();
			System.out.println(path);
			new ApiLucene().sqlJoinLuceneQuery("SELECT name,type,longitude,latitude,id_isle,description FROM TouristicSite WHERE type= 'activity' with balade ");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
