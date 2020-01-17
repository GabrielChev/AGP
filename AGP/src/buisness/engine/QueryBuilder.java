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
	private static String generateString(ArrayList<String> selectedFiles) {
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
	
	public static ArrayList<Transport> buildTransportQuery(ArrayList<TouristicSite> sites) {
		ArrayList<String> sitesName = new ArrayList<String>();
		for (int i = 0; i< sites.size();i++) {
			sitesName.add(sites.get(i).getName());
		}
		String listStringName = generateString(sitesName);
		listStringName = listStringName.replaceAll("'", "\"");
		ArrayList<Transport> transport = new ArrayList<Transport>();
		String query = "SELECT Transport.type,Transport.kilometerPrice,Transport.kilometerDuration,TouristicSite.name FROM TouristicSite,Transport WHERE Transport.id_touristicSite = TouristicSite.id_touristicSite AND TouristicSite.Name IN "+ listStringName + "";
		JdbcPersistance persistance = new JdbcPersistance();

		try {
			transport = persistance.FetchTransports(query);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return transport;
		
	}
	
	public ArrayList<Hotel> selectAllHotel(){
		ArrayList<Hotel> queryResult = new ArrayList<Hotel>();
		JdbcPersistance persistance = new JdbcPersistance();
		try {
			queryResult = persistance.FetchHotels("SELECT Hotel.name,Hotel.beach,Hotel.price,Hotel.longitude,Hotel.latitude,Hotel.rating,Isle.name As isleName"
					+ " FROM Hotel,Isle WHERE Hotel.id_isle = Isle.id_isle;");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return queryResult;
	}

}