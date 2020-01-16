package buisness.model;

import buisness.objects.TouristicSite;

/**
 * Contains methods to get informations of the research on a table
 * 
 */

public class Search {

	private String keyWords;
	private String name;
	private double offerPriceMin;
	private double offerPriceMax;
	private double confort;
	private float hotelRatingMin;
	private float hotelRatingMax;
	private int days;
	private TouristicSite touristicSite ;
	

	public Search() {
		
	}
	
	/**
	 * Get hotels which match with the search criteria in order of relevance
	 * 
	 * @param keyWords
	 * @param offerPriceMin
	 * @param offerPriceMax
	 * @param hotelRaitingMin
	 * @param hotelRaitingMax
	 * 
	 * @return a list of hotel
	 */

	public Search(String keyWords, String name, double offerPriceMin, double offerPriceMax, double confort, float hotelRatingMin, float hotelRatingMax, int days) {
		this.keyWords = keyWords;
		this.name = name;
		this.offerPriceMin = offerPriceMin;
		this.offerPriceMax = offerPriceMax;
		this.confort = confort;
		this.hotelRatingMin = hotelRatingMin;
		this.hotelRatingMax = hotelRatingMax;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == "") {
			this.name = null;
		} else {
			this.name = name;
		}
	}

	public float getHotelRatingMin() {
		return hotelRatingMin;
	}

	public void setHotelRatingMin(float hotelRatingMin) {
		this.hotelRatingMin = hotelRatingMin;
	}

	public float getHotelRatingMax() {
		return hotelRatingMax;
	}

	public void setHotelRatingMax(float hotelRatingMax) {
		this.hotelRatingMax = hotelRatingMax;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		if(keyWords=="")
		{this.keyWords = null;}
		else
		{this.keyWords = keyWords;}
	}

	public double getOfferPriceMin() {
		return offerPriceMin;
	}

	public void setOfferPriceMin(double offerPriceMin) {
		this.offerPriceMin = offerPriceMin;
	}

	public double getOfferPriceMax() {
		return offerPriceMax;
	}

	public void setOfferPriceMax(double offerPriceMax) {
		this.offerPriceMax = offerPriceMax;
	}

	public double getConfort() {
		return confort;
	}

	public void setConfort(double confort) {
		this.confort = confort;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	
	public TouristicSite getTouristicSite() {
		return touristicSite;
	}

	public void setTouristicSite(TouristicSite touristicSite) {
		this.touristicSite = touristicSite;
	}



	
}