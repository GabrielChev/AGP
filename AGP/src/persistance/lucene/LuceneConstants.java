package persistance.lucene;

import java.io.File;

public class LuceneConstants {
	public static final String CONTENTS = "contents";
	public static final String FILE_NAME = "filename";
	public static final String FILE_PATH = "filepath";
	public static final int MAX_SEARCH = 10;
	public static final String INDEX_DIR = "/home/brahim/eclipse-workspace/AGP/AGP/src/persistance/Index";
	
	public String path = null;
	public String LuceneConstants() {
		 String path=new File(".").getAbsolutePath();
		 path = path+"src/persistance/description";
		 return path;
	}

}
