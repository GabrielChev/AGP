package buisness.engine;

import java.util.ArrayList;
import java.util.Random;

import buisness.model.CalculateDistance;
import buisness.model.Excursion;
import buisness.model.Offer;
import buisness.model.Stay;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;
import buisness.engine.ExcursionBuilder;

public class OfferBuilder {

	public OfferBuilder() {
	}
	
	public Offer buildOffer(ArrayList<TouristicSite> listKeyWordsSites, ArrayList<TouristicSite> listAllSites) {
		
		Hotel hotel = null;
		double actualLatitude = 0;
		double actualLongitude = 0;
		int siteNumber = 5; //dépend de search
		int excursionNumber = 5; //dépend de search
		int indexExcursion = 0;
		int excursionDuration = 10;
		
		int sumDistanceToHotelInExcursion;
		double lastSiteLatitude;
		double lastSiteLongitude;
		
		ArrayList<TouristicSite> listSitesInExcursion = new ArrayList<TouristicSite>();
		ArrayList<Excursion> listExcursions = new ArrayList<Excursion>();
		ArrayList<Hotel> listHotels = new ArrayList<Hotel>();
		CalculateDistance calculateDistance = new CalculateDistance();
		Random random = new Random();
		int nbRandom = 0;
		
		//Initialisation of actualLongitude and actualLatitude
		if (listKeyWordsSites != null) {
			actualLongitude = listKeyWordsSites.get(0).getLongitude();
			actualLongitude = listKeyWordsSites.get(0).getLatitude();
		}
		else {
			actualLongitude = listAllSites.get(0).getLongitude();
			actualLongitude = listAllSites.get(0).getLatitude();
		}
		
		//while we can add an excursion in the offer
		while(indexExcursion <= excursionNumber){

			int indexSite = 0;
			int sumDurationOnSite = 0;
			boolean endDuration = false;
			ArrayList<TouristicSite> listSites = null;
			
			//while we can add a site in an excursion
			while(indexSite < siteNumber && endDuration != true) {
				
				if (listKeyWordsSites != null) {
					listSites = listKeyWordsSites;
				}
				else {
					listSites = listAllSites;
				}
				TouristicSite proposedSite;
				proposedSite = calculateDistance.findNearestSite(actualLatitude, actualLongitude, listSites);
				sumDurationOnSite += proposedSite.getDuration();
				if(sumDurationOnSite < excursionDuration) {
					listSitesInExcursion.add(proposedSite);
					listSites.remove(proposedSite);
				}
				else {
					endDuration = true;
				}
				indexSite++;
			}
			Excursion proposedExcursion = new Excursion(listSitesInExcursion, null);
			listExcursions.add(proposedExcursion);
			
			lastSiteLatitude = listSites.get(listSites.size()).getLatitude();
			lastSiteLongitude = listSites.get(listSites.size()).getLongitude();
			listHotels.add(calculateDistance.findNearestHotel(lastSiteLatitude, lastSiteLongitude, listHotels));
			
			indexExcursion++;
		}
		
		//Get a random hotel in the list
		nbRandom = random.nextInt(listHotels.size());
		hotel = listHotels.get(nbRandom);
		
		Stay proposedStay = new Stay(hotel, excursionDuration);
		Offer offer = new Offer(proposedStay, listExcursions);
		return offer;
	}
}
