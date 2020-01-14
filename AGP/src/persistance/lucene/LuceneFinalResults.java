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
		private String query="";
		public  LuceneFinalResults(String SearchingWord , String query) throws SQLException {
			String fileSelected = "";

			LuceneQuery luceneQuery = new LuceneQuery(SearchingWord);
			 selectedFiles = luceneQuery.getPathList();
			 
			 
			 fileSelected = generateString(selectedFiles); 
			  query = query+" WHERE description IN "+fileSelected;
		
			
			this.query = query;
		
			 queryResult = mergeResult();
			 System.out.println("Lucene Search Found File : " + selectedFiles);
			 System.out.println("Query Result :  "+ queryResult);
			 
		}

		
		
		public ArrayList<String> getQueryResult() {
			return queryResult;
		}
		public void setQueryResult(ArrayList<String> queryResult) {
			this.queryResult = queryResult;
		}
		public ArrayList<String> mergeResult() throws SQLException {

			try {
				
				
				String selectAddressQuery = this.query;
				PreparedStatement preparedStatement = (PreparedStatement) JdbcConnection.getConnection().prepareStatement(selectAddressQuery);

				ResultSet result = preparedStatement.executeQuery();
				String line = "";
				int index = 1;
				while (result.next()) {
					line = result.getString("name") +";"+result.getString("type")+";"+result.getFloat("longitude")+
							";"+result.getFloat("latitude")+";"+result.getInt("id_isle");
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
			for (int i = 0 ; i< selectedFiles.size();i++) {
				if(i == selectedFiles.size()-1) {
					filesSelected += "'"+selectedFiles.get(i)+"')";
				}else {
					filesSelected += "'"+selectedFiles.get(i)+"',";
			
				}
			}	
			return filesSelected;
		}
}
