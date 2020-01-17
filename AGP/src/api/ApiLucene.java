package api;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import persistance.jdbc.JdbcPersistance;
import persistance.lucene.*;
import buisness.objects.*;

public class ApiLucene {

	public ApiLucene() {
		
	}
	
	 public static   ArrayList<TouristicSite> sqlJoinLuceneQuery(String query) throws IOException, ParseException {
	        String withQuery = "";
	        String sqlQuery = "";
	        String[] queryDecomposed;
	        ArrayList<TouristicSite> ListOfResults  = new ArrayList(); 
	        
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
			return ListOfResults;
	    	        
		
	    }
	
	public  void ModifyDescription(String text, int fileNum) throws IOException
	{
		String path = new String("src/persistence/description/"+fileNum);
		System.out.println(path);
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
	    writer.append(text);
	     
	    writer.close();
	}
	
	public void AddTouristicSite(String text) {
		
		int lastFile = new File("src/persistence/description/").list().length;
		String path = new String("src/persistence/description/"+lastFile);
		String fileName = new String(lastFile+".txt");
		
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}
		writer.close();
		
		TouristicSite t = new TouristicSite();
		t = InputNewData(text);
		JdbcPersistance persistance = new JdbcPersistance();
		try {
			persistance.insertTouristicSite(t);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public TouristicSite InputNewData(String description) {
		TouristicSite touristicSite = new  TouristicSite();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du site :");
		touristicSite.setName(sc.nextLine());
		
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Veuillez saisir le type du site :");
		touristicSite.setType((sc2.nextLine()));


	
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Veuillez saisir le prix du site :");
		touristicSite.setPrice((Integer.valueOf(sc3.nextLine())));
		
		
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Veuillez saisir la Longitude du site :");
		touristicSite.setLongitude((Integer.valueOf(sc4.nextLine())));
		
		
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Veuillez saisir la Latitude du site :");
		touristicSite.setLatitude((Integer.valueOf(sc5.nextLine())));
		
	
		touristicSite.setDescription(description);
		
		
		Scanner sc6 = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom de l'ile accueillant le site :");
		touristicSite.setIsleName(String.valueOf(sc6.nextLine()));


		Scanner sc7 = new Scanner(System.in);
		System.out.println("Veuillez saisir la durée de l'activité ou de la visite sur le site :");
		touristicSite.setDuration(Double.valueOf(sc7.nextLine()));
		
		
		
		return touristicSite ;
		
	}
	
	
	}





