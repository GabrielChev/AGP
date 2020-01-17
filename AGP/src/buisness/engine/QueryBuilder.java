package buisness.engine;

import java.util.ArrayList;

import api.ApiLucene;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;
import buisness.objects.Transport;
import persistance.jdbc.JdbcPersistance;

public class QueryBuilder {
	
	public QueryBuilder() {}
	
	
	public static ArrayList <Hotel> buildHotelQuery(String name, double dailyPriceMin, double dailyPriceMax, float hotelRaitingMin, float hotelRaitingMax) {
		 ArrayList <Hotel> hotels = new ArrayList <Hotel>() ;
		String query = "SELECT * FROM HOTEL WHERE name = "+name+" and price > "+dailyPriceMin+" and price < "+dailyPriceMax+" and rating >"+hotelRaitingMin+" and rating < "+hotelRaitingMax+" ";
		
		JdbcPersistance persistance = new JdbcPersistance();
 
		try {
			hotels = persistance.FetchHotels(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return hotels;
		
		
	}
	
	
	public static ArrayList <TouristicSite> buildTourisiticSitesQuery(String keywords, double dailyPriceMin, double dailyPriceMax) {
		 ArrayList <TouristicSite> sites = new  ArrayList <TouristicSite>() ;
		String query = "SELECT * FROM TouristicSite where price between "+dailyPriceMin+" and "+dailyPriceMax+" with "+keywords+"";
		
		

		try {
			sites = new ApiLucene().sqlJoinLuceneQuery(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return sites;
		
		
	}
	
	
	public static ArrayList <TouristicSite> buildTourisiticSitesQueryWithoutLucene(double dailyPriceMin, double dailyPriceMax) {
		 ArrayList <TouristicSite> sites =  new ArrayList <TouristicSite>() ;
		String query = "SELECT * FROM TouristicSite where price between "+dailyPriceMin+" and "+dailyPriceMax+"";
		
		

		JdbcPersistance persistance = new JdbcPersistance();
		 
		try {
			sites = persistance.FetchTourisitcSites(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return sites;
		
		
	}
	
	public static ArrayList <Transport> buildTransportQuery(String name, double dailyPriceMin, double dailyPriceMax, float hotelRaitingMin, float hotelRaitingMax) {
		 ArrayList <Transport> transport = new ArrayList <Transport>() ;
		String query = "SELECT * FROM HOTEL WHERE name = "+name+" and price > "+dailyPriceMin+" and price < "+dailyPriceMax+" and rating >"+hotelRaitingMin+" and rating < "+hotelRaitingMax+" ";
		
		JdbcPersistance persistance = new JdbcPersistance();

		try {
			transport = persistance.FetchTransportsWays(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return transport;
		
		
	}
	}