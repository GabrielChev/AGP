package persistance.lucene;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LuceneConstants {
	public static final String CONTENTS = "contents";
	public static final String FILE_NAME = "filename";
	public static final String FILE_PATH = "filepath";
	public static final int MAX_SEARCH = 10;
	private  String INDEX_DIR = "";
	private  String DESCRIPTION_DIR = "";


	public String LuceneConstants() {
		String path = "";
		URL url = LuceneConstants.class.getResource("");
		String [] paths = url.getPath().split("bin");
		
		setINDEX_DIR(paths[0]+"index");

		 url = LuceneConstants.class.getResource("");

		paths = url.getPath().split("bin");
		path = paths[0]+"description";
		setDESCRIPTION_DIR(path);
		 return path;		
	}
	
	public String getINDEX_DIR() {
		return INDEX_DIR;
	}
	public void setINDEX_DIR(String iNDEX_DIR) {
		INDEX_DIR = iNDEX_DIR;
	}
	
	public String getDESCRIPTION_DIR() {
		return DESCRIPTION_DIR;
	}

	public void setDESCRIPTION_DIR(String dESCRIPTION_DIR) {
		DESCRIPTION_DIR = dESCRIPTION_DIR;
	}
	/*public String createIndexDirectory() {
		File file = new File ("index");
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Index Directory created");
			} else {
				System.out.println("Failed to create index directory!");
			}
		}
		URL url = LuceneConstants.class.getResource("");
		String [] paths = url.getPath().split("bin");
		return paths[0]+"index";
		
	}*/
	
	

	
}
