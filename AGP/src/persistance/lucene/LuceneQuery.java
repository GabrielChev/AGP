package persistance.lucene;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import java.io.File;
public class LuceneQuery {
	
  static String dataDir = new LuceneConstants().LuceneConstants();
  private ArrayList<String> pathList = new ArrayList<String>();
  private Indexer indexer;
  private Searcher searcher;
   
  public  LuceneQuery (String searchingWord) {
	  LuceneConstants lc = new LuceneConstants();
	  lc.LuceneConstants();
      try {
      	 if (isDirectoryEmpty(new File(lc.getINDEX_DIR()))) {//isDirectoryEmpty(new File(LuceneConstants.INDEX_DIR))) {
         	createIndex();
         }
         pathList = search(searchingWord,pathList);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
	
   }
  
   
   public ArrayList<String> getPathList() {
	   return pathList;
   }


   public void setPathList(ArrayList<String> pathList) {
	   this.pathList = pathList;
	}


private void createIndex() throws IOException {
	LuceneConstants lc = new LuceneConstants();
	  lc.LuceneConstants();

	  System.out.println("LuceneQuery : "+lc.getINDEX_DIR());

		      indexer = new Indexer(lc.getINDEX_DIR());
		      int numIndexed;
		      long startTime = System.currentTimeMillis();	
		      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		      long endTime = System.currentTimeMillis();
		      indexer.close();
		      System.out.println(numIndexed+" File indexed, time taken: "
		         +(endTime-startTime)+" ms");
	 
   }	   
private  ArrayList<String>  search(String searchQuery, ArrayList<String> pathList) throws IOException, ParseException {
	LuceneConstants lc = new LuceneConstants();
      searcher = new Searcher(lc.getINDEX_DIR());
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
   
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH)+" score : "+scoreDoc);
            pathList.add(splitPath(doc.get(LuceneConstants.FILE_PATH)));
            
      }  
      return  pathList;
   }
   
   public static boolean isDirectoryEmpty(File file){
	   if(file != null && file.isDirectory()){
	    return ( file.list().length == 0 ? true : false); 
	   }
	   return false;
	  }
	 
   public String splitPath(String path) {
	   String newPath = "";
	   
	   String[] tabString = path.split("/");
	   for(String word : tabString) {
		   if(word.contains(".txt")) {
			   newPath = word;
		   }
	   }
	   
	   return newPath;
   }
}

