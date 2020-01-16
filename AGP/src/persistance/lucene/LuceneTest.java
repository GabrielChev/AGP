package persistance.lucene;

import java.sql.SQLException;
import java.util.ArrayList;

public class LuceneTest {
	private static ArrayList<String> selectedFiles =  new ArrayList<String>();
	
	public static void main (String[] argv) throws SQLException {
		
		LuceneFinalResults luceneQuery1 = new LuceneFinalResults();
		luceneQuery1.LuceneSearch("mosquée","SELECT name,type,longitude,latitude,description,id_isle  FROM TouristicSite WHERE type = 'historic'");
		
	}

	
}
