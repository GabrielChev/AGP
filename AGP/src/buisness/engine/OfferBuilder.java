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
	
	public Offer buildOffer(ArrayList<TouristicSite> listKeyWordsSites, ArrayList<TouristicSite> listAllSites, ArrayList<Hotel> listAllHotels) {
		Hotel hotel = null;
		double actualLatitude = 0;
		double actualLongitude = 0;
		int siteNumber = 5; //dépend de search
		int excursionNumber = 5; //dépend de search
		int indexExcursion = 0;
		int excursionDuration = 10;
		
		int sumDistanceToHotelInExcursion;
		double lastSiteLatitude = 0;
		double lastSiteLongitude = 0;
		
		ArrayList<Excursion> listExcursions = new ArrayList<Excursion>();
		ArrayList<Hotel> listHotels = new ArrayList<Hotel>();
		CalculateDistance calculateDistance = new CalculateDistance();
		Random random = new Random();
		int nbRandom = 0;
		
		//Initialisation of actualLongitude and actualLatitude
		if (listKeyWordsSites != null) {
			actualLongitude = listKeyWordsSites.get(0).getLongitude();
			actualLatitude = listKeyWordsSites.get(0).getLatitude();
		}
		else {
			actualLongitude = listAllSites.get(0).getLongitude();
			actualLatitude = listAllSites.get(0).getLatitude();
		}
		
		//while we can add an excursion in the offer
		while(indexExcursion <= excursionNumber){

			int indexSite = 0;
			int sumDurationOnSite = 0;
			boolean endDuration = false;
			ArrayList<TouristicSite> listSites = null;
			ArrayList<TouristicSite> listSitesInExcursion = new ArrayList<TouristicSite>();
			//while we can add a site in an excursion
			while(indexSite < siteNumber && endDuration != true) {
				TouristicSite proposedSite = new TouristicSite();
				if ((listKeyWordsSites != null) && (listKeyWordsSites.size() != 0)) {
					listSites = listKeyWordsSites;
				}
				else {
					listSites = listAllSites;
				}
				if ((listSites.size() == 0)) {
					endDuration = true;
				}
				else {	
					proposedSite = calculateDistance.findNearestSite(actualLatitude, actualLongitude, listSites);
					sumDurationOnSite += proposedSite.getDuration();
				
					if(sumDurationOnSite < excursionDuration) {
						listSitesInExcursion.add(proposedSite);
						listSites.remove(proposedSite);
					}
					else {
						endDuration = true;
					}
				}
				indexSite++;
			}
			Excursion proposedExcursion = new Excursion(listSitesInExcursion, null);
			listExcursions.add(proposedExcursion);
			if (listSitesInExcursion.size() > 0) {
				lastSiteLatitude = listSitesInExcursion.get(listSitesInExcursion.size()-1).getLatitude();
				lastSiteLongitude = listSitesInExcursion.get(listSitesInExcursion.size()-1).getLongitude();
			}
			listHotels.add(calculateDistance.findNearestHotel(lastSiteLatitude, lastSiteLongitude, listAllHotels));
			
			indexExcursion++;
		}
		
		//Get a random hotel in the list
		nbRandom = random.nextInt(listHotels.size());
		hotel = listHotels.get(nbRandom);
		System.out.println(hotel.getIsleName());
		Stay proposedStay = new Stay(hotel, excursionDuration);
		Offer offer = new Offer(proposedStay, listExcursions);
		return offer;
	}
}
