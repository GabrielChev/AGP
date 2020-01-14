package persistance.lucene;

import java.sql.SQLException;
import java.util.ArrayList;

public class LuceneTest {
	private static ArrayList<String> selectedFiles =  new ArrayList<String>();
	
	public static void main (String[] argv) throws SQLException {
		System.out.println("main test ");
	
		LuceneFinalResults luceneQuery1 = new LuceneFinalResults("mosquée","SELECT name,type,longitude,latitude,id_isle  FROM TouristicSite");
		
	}

	
}
