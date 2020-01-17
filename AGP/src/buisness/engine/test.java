package buisness.engine;

import buisness.model.Search;

public class test {

	public static void main(String[] args) {
		
		
		QueryBuilder build =  new QueryBuilder(); 
		Search search = new Search(); 
		
		search.setKeyWords("Mosquée");
		search.setOfferPriceMax(50.0); 
		search.setOfferPriceMin(9.0);
		
		QueryBuilder.buildTourisiticSitesQuery(search.getKeyWords(),search.getOfferPriceMin(),search.getOfferPriceMax()); 
		
	}

}
