package persistance.lucene;

import java.io.File;
import java.io.IOException;

public class LuceneConstants {
	public static final String CONTENTS = "contents";
	public static final String FILE_NAME = "filename";
	public static final String FILE_PATH = "filepath";
	public static final int MAX_SEARCH = 10;
	public   String INDEX_DIR = "";
	
	public String path = null;
	public String LuceneConstants() {
		String path = "";
		setINDEX_DIR(createIndexDirectory());
	
		try {
			
			path = new File(".").getCanonicalPath();
			System.out.println(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 path = path+"/AGP/src/persistance/description";
		 return path;
	}
	
	public String getINDEX_DIR() {
		return INDEX_DIR;
	}
	public void setINDEX_DIR(String iNDEX_DIR) {
		INDEX_DIR = iNDEX_DIR;
	}
	
	public String createIndexDirectory() {
		File file = new File ("./Index");
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Index Directory created");
			} else {
				System.out.println("Failed to create index directory!");
			}
		}
		return file.getAbsolutePath();
		
	}
	
	public void createDescriptionDirectory() {
		File file = new File ("./Description");
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Description Directory created");
			} else {
				System.out.println("Failed to create Description directory!");
			}
		}
	}

}
