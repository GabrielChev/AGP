package buisness.engine;

import java.util.ArrayList;

import buisness.model.Excursion;
import buisness.model.Offer;
import buisness.model.Stay;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;
import buisness.engine.ExcursionBuilder;

public class OfferBuilder {

	public OfferBuilder() {
	}
	
	public OfferBuilder buildOffer (Stay proposedStay, ArrayList<TouristicSite> listKeyWordsSites, ArrayList<TouristicSite> listAllSites) {
		
		Hotel hotel;
		double actualLatitude;
		double actualLongitude;
		int siteNumber = 5; //dépend de search
		int excursionNumber = 5; //dépend de search
		int indexExcursion = 0;
		
		
		ArrayList<TouristicSite> listSites = new ArrayList<TouristicSite>();
		
		Excursion proposedExcursion = new Excursion(null, null);
		
		//Initialisation of actualLongitude and actualLatitude
		if (proposedStay.getHotel() != null) {
			hotel = proposedStay.getHotel();
			actualLongitude = hotel.getLongitude();
			actualLongitude = hotel.getLatitude();
		}
		else {
			if (listKeyWordsSites != null) {
				actualLongitude = listKeyWordsSites.get(0).getLongitude();
				actualLongitude = listKeyWordsSites.get(0).getLatitude();
			}
			else {
				actualLongitude = listAllSites.get(0).getLongitude();
				actualLongitude = listAllSites.get(0).getLatitude();
			}	
		}
		
		while(indexExcursion <= excursionNumber){
			ExcursionBuilder excursionBuilder = new ExcursionBuilder();

		}
		
		return null;
	}
	

}
