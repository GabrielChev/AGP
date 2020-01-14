package persistance.lucene;

import java.sql.SQLException;

public class LuceneTest {
	public static void main (String[] argv) throws SQLException {
		String query = "SELECT name,type,longitude,latitude,id_isle  FROM TouristicSite WHERE";
		LuceneFinalResults luceneQuery = new LuceneFinalResults("musée",query);
		
		
		System.out.println("lucene = " + luceneQuery.getSelectedFiles());
		System.out.println("query = "+ luceneQuery.getQueryResult());
		
	}
}
