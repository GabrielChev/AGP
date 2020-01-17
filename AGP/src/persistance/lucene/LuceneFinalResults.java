package persistance.lucene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mysql.jdbc.PreparedStatement;

import buisness.objects.TouristicSite;
import persistance.jdbc.JdbcConnection;
import persistance.jdbc.JdbcPersistance;
import java.sql.Connection;
import java.sql.DriverManager;

public class LuceneFinalResults {
		
		private ArrayList<String> selectedFiles =  new ArrayList<String>();
		private ArrayList<TouristicSite> queryResult =  new ArrayList<TouristicSite>();
		private ArrayList<TouristicSite> queryResultQ1 =  new ArrayList<TouristicSite>();
		private ArrayList<TouristicSite> queryResultR1 = new ArrayList<TouristicSite>();
		private String query="";
		
		
		public  LuceneFinalResults() {}
		
		
		public ArrayList<TouristicSite> LuceneSearch (String SearchingWord , String query) throws SQLException {
			
		
			
			String fileSelected = "";
			String lowerQuery = "";
			String firsrQuery = "";
			Set set = new HashSet();
			System.out.println("*** LUCENE FIRST  ***");
			long startTime = System.currentTimeMillis();	
			LuceneQuery luceneQuery = new LuceneQuery(SearchingWord);
			selectedFiles = luceneQuery.getPathList();
			 
			selectedFiles = splitFileSelected(selectedFiles);
			

			 	fileSelected = generateString(selectedFiles); 
			 	lowerQuery = query;
			 	firsrQuery = query;
			 	if (fileSelected != null) {
			 		if(lowerQuery.toLowerCase().contains("where")) {
			 			query = query+" AND description IN "+fileSelected;
			 		}else {
			 			query = query+" WHERE description IN "+fileSelected;
			 		}
			 	
					 System.out.println("query "+ query);
						
					 JdbcPersistance persistance = new JdbcPersistance();
					 try {
						queryResult = persistance.FetchTourisitcSites(firsrQuery);
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				 
				 }else {
					 System.out.println("DISCRIPTION FOLDER IS EMPTY");
				 }
			  

			 
			 System.out.println("Lucene Search Found File : " + selectedFiles);
			 System.out.println("Query Result :  "+ queryResult);
			 long endTime = System.currentTimeMillis();
			 
		      System.out.println("Time taken: "
				         +(endTime-startTime)+" ms");
		      
		      
			 System.out.println("***QUERY RESULT JOIN TO LUCENE RESULT***");
			 
			 startTime = System.currentTimeMillis();
			 
			 System.out.println("EXCUTING QUERY ...");
			 JdbcPersistance persistance = new JdbcPersistance();
			 try {
				queryResultQ1 = persistance.FetchTourisitcSites("SELECT * FROM TouristicSite where description in "+fileSelected);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			
			 System.out.println("JOIN THE RESULT OF QUERY AND LUCENE SEARCH");
			
			 endTime = System.currentTimeMillis();
		      System.out.println("Time taken: "
				         +(endTime-startTime)+" ms");
			 System.out.println("RESULT OF JOINING");
			 System.out.println(queryResultQ1);
			 
				
			return queryResultQ1;
			 
		}

		
		
		public ArrayList<TouristicSite> getQueryResult() {
			return queryResult;
		}
		public void setQueryResult(ArrayList<TouristicSite> queryResult) {
			this.queryResult = queryResult;
		}
		
		
		
		public String getQuery() {
			return query;
		}
		public void setQuery(String query) {
			this.query = query;
		}
		public  String generateString(ArrayList<String> selectedFiles) {
			String filesSelected = "(";
			if(selectedFiles.size() == 0) {
				filesSelected = null;
			}else {
				for (int i = 0 ; i< selectedFiles.size();i++) {
					if(i == selectedFiles.size()-1) {
						filesSelected += "'"+selectedFiles.get(i)+"')";
					}else {
						filesSelected += "'"+selectedFiles.get(i)+"',";
					}
				}
			}
			return filesSelected;
		}
		
		
		public ArrayList<String> splitFileSelected(ArrayList<String> fileSelected) {
			ArrayList<String> newSelectedFile = new ArrayList<String>();
			String[] str = null;
			
			for(int i=0; i < fileSelected.size();i++) {
				fileSelected.set(i, fileSelected.get(i).replaceAll("\\\\", "/"));
				str = fileSelected.get(i).split("/");
				
		
				fileSelected.set(i, str[str.length-1]);

			}
			
			return fileSelected;
		}
}
