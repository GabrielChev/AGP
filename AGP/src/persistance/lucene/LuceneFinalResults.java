package persistance.lucene;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;

import persistance.JdbcConnection;

public class LuceneFinalResults {
		
		private ArrayList<String> selectedFiles =  new ArrayList<String>();
		private ArrayList<String> queryResult =  new ArrayList<String>();
		private ArrayList<String> queryResultR1 = new ArrayList<String>();
		private String query="";
		public  LuceneFinalResults(String SearchingWord , String query) throws SQLException {
			String fileSelected = "";
			String lowerQuery = "";
			String firsrQuery = "";
			
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
						
						
					 queryResult = excuteResult(query);
				
				 
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
			 
			 queryResult = excuteResult(firsrQuery);
			 
			 System.out.println(queryResult);
			 System.out.println("JOIN THE RESULT OF QUERY AND LUCENE SEARCH");
			 
			 for (int i =0 ; i< queryResult.size();i++) {
				 for(int j=0; j< selectedFiles.size();j++) {
						if(queryResult.get(i).contains(selectedFiles.get(j))) {
							queryResultR1.add(queryResult.get(i));
						 }
				}

		    }
			 endTime = System.currentTimeMillis();
		      System.out.println("Time taken: "
				         +(endTime-startTime)+" ms");
			 System.out.println("RESULT OF JOINING");
			 System.out.println(queryResultR1);
			 
				
					 
			 
			 
		}

		
		
		public ArrayList<String> getQueryResult() {
			return queryResult;
		}
		public void setQueryResult(ArrayList<String> queryResult) {
			this.queryResult = queryResult;
		}
		public ArrayList<String> excuteResult(String query) throws SQLException {

			try {
				
				
				String selectAddressQuery = query;
				PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

				ResultSet result = preparedStatement.executeQuery();
				String line = "";
				while (result.next()) {
					line = result.getString("name") +";"+result.getString("type")+";"+result.getFloat("longitude")+
							";"+result.getFloat("latitude")+";"+result.getString("description")+";"+result.getInt("id_isle");
					queryResult.add(line);
			
				}
				
				preparedStatement.close();
				
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
			return queryResult;
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
