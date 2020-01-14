package persistance.lucene;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import java.io.File;
public class LuceneTester {
	
	static String DATA_DIR = new LuceneConstants().LuceneConstants();
   Indexer indexer;
   Searcher searcher;
   
  /*public ArrayList<String> LuceneTester (String searchingWord) {
	 ArrayList<String> pathList = new ArrayList<String>();
      try {
      	 if (isDirectoryEmpty(new File(LuceneConstants.INDEX_DIR))) {
         	createIndex();
         }
         pathList = search(searchingWord,pathList);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
	return pathList;
   }*/
   public static void main (String[] argv) {
	   System.out.println(DATA_DIR);
	   ArrayList<String> pathList = new ArrayList<String>();
	   LuceneTester tester;
	      try {
	      tester = new LuceneTester();
	      	 if (isDirectoryEmpty(new File(LuceneConstants.INDEX_DIR))) {
	          	tester.createIndex();
	          }
	      	pathList =  tester.search("mosquée", pathList);
	      
	      System.out.println("array "+pathList);
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
   }
   
   
   private void createIndex() throws IOException {
		      indexer = new Indexer(LuceneConstants.INDEX_DIR);
		      int numIndexed;
		      long startTime = System.currentTimeMillis();	
		      numIndexed = indexer.createIndex(DATA_DIR, new TextFileFilter());
		      long endTime = System.currentTimeMillis();
		      indexer.close();
		      System.out.println(numIndexed+" File indexed, time taken: "
		         +(endTime-startTime)+" ms");
	 
   }	   
   private  ArrayList<String>  search(String searchQuery, ArrayList<String> pathList) throws IOException, ParseException {
      searcher = new Searcher(LuceneConstants.INDEX_DIR);
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
