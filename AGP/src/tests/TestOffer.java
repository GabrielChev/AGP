package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import buisness.model.Offer;
import buisness.model.Stay;
import buisness.objects.Hotel;
import buisness.objects.TouristicSite;
import persistance.jdbc.JdbcPersistance;
import buisness.engine.OfferBuilder;

public class TestOffer {

	@Test
	public void testOffer() throws Exception {
		OfferBuilder offerBuilder = new OfferBuilder();
		Offer offer;
		JdbcPersistance jdbc = new JdbcPersistance();
		
		ArrayList<TouristicSite> listAllSites = jdbc.FetchTourisitcSites("SELECT * from TouristicSite");
		//for (int i = 0; i < listAllSites.size(); i++){
		//	System.out.println(listAllSites.get(i));
		//}
		//ArrayList<TouristicSite> listKeyWordsSites = jdbc.FetchTourisitcSites("SELECT * FROM TouristicSite");
		//int number = 15;
		//ArrayList<Hotel> hotel;
		
		offer = offerBuilder.buildOffer(listAllSites, listAllSites);
		System.out.println(offer.getProposedExcursion().get(1).getExcursionPrice());
	}

}
