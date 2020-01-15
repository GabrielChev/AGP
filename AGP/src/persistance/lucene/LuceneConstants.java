package persistance.lucene;

import java.io.File;
import java.io.IOException;

public class LuceneConstants {
	public static final String CONTENTS = "contents";
	public static final String FILE_NAME = "filename";
	public static final String FILE_PATH = "filepath";
	public static final int MAX_SEARCH = 10;
	public static final String INDEX_DIR = "./Users/macbookpro/git/AGP/AGP/src/persistance/Index";
	
	public String path = null;
	public String LuceneConstants() {
		 String path = "";
		try {
			path = new File(".").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 path ="/Users/macbookpro/git/AGP/AGP/src/persistance/description";
		 return path;
	}

}
