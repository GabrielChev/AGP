package api;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistance.lucene.*;
import buisness.objects.*;

public class ApiLucene {

	public ApiLucene() {
		
	}
	
	 public static  void sqlJoinLuceneQuery(String query) throws IOException, ParseException {
	        String withQuery = "";
	        String sqlQuery = "";
	        String[] queryDecomposed;
	        ArrayList<String> ListOfResults  = new ArrayList(); 
	        
	        queryDecomposed = query.split("with ");
	        sqlQuery = queryDecomposed[0];
	        withQuery = queryDecomposed[1];
	        
	        System.out.println("SQL Query : "+sqlQuery);
	        System.out.println("Words : "+ withQuery);
	        LuceneFinalResults finaleResult = new LuceneFinalResults(); 
	        try {
	        	ListOfResults = finaleResult.LuceneSearch(withQuery, sqlQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        
	        
	        
	        
		
	    }
	
	public  void addText(String text, int fileNum) throws IOException
	{
		String path = new String("src/persistence/description/"+fileNum);
		System.out.println(path);
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.append(text);
	     
	    writer.close();
	}
	
	
	}


