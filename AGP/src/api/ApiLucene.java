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

import antlr.collections.List;
import buisness.objects.*;

public class ApiLucene {

	public ApiLucene() {
		
	}
	
	 public static List sqlJoinLuceneQuery(String query) throws IOException, ParseException {
	        String withQuery = "";
	        String sqlQuery = "";
	        String[] queryDecomposed;
	        
	        queryDecomposed = query.toLowerCase().split("with ");
	        sqlQuery = queryDecomposed[0];
	        withQuery = queryDecomposed[1];

	        return SqlLuceneJoin.sqlJoinLucene(sqlQuery, withQuery);
	    }
	
	public static void addText(String text, int c) throws IOException
	{
		String path = new String("src/persistence/description/"+c);
		System.out.println(path);
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.append(text);
	     
	    writer.close();
	}
	
	
	}


