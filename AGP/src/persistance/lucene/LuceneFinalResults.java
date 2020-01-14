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
		private String query;
		public  LuceneFinalResults(String SearchingWord , String query) throws SQLException {
			this.query = query;
			
			LuceneQuery luceneQuery = new LuceneQuery(SearchingWord);
			 selectedFiles = luceneQuery.getPathList();
			 queryResult = mergeResult();
			 
		}
		public ArrayList<String> getSelectedFiles() {
			return selectedFiles;
		}
		public void setSelectedFiles(ArrayList<String> selectedFiles) {
			this.selectedFiles = selectedFiles;
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
				
					queryResult.add(result.getString(index));
					System.out.println(result.getFloat(1));
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
}
