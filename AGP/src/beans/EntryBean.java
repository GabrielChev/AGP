package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import buisness.model.Search;
import buisness.objects.TouristicSite;

/**
 * Simulation bean controller used to collect simulation entry parameters and to
 * start the simulation.
 * 
 */


@ManagedBean
@SessionScoped
public class EntryBean {
	private Search search = new Search() ;
	private int id ;
	private String object = "hotel" ;
	
	public String search() {
       if(object.equals("hotel"))
       		{return "resultHotel";}
       if(object.equals("site"))
        	{return "resultSites";}
       if(object.equals("offer"))
        	{return "resultOffer";}
        System.out.println(object);
        return "resultSites";
    }
	
	public EntryBean() {
    	object = "hotel";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyWords() {
		return search.getKeyWords();
	}
    
    public void setKeyWords(String s) {
		search.setKeyWords(s);
	}
    
    public TouristicSite getTouristicSite() {
		return search.getTouristicSite() ;
	}
    
    public void setTouristicSite(TouristicSite s) {
		search.setTouristicSite(s);
	}
   
    
    public String getName() {
		return search.getName();
	}
    
    public void setName(String s) {
		search.setName(s);
	}
    
    public double getOfferPriceMin() {
		return search.getOfferPriceMin();
	}
    
    public void setOfferPriceMin(double priceMin) {
		search.setOfferPriceMin(priceMin);
	}
    
    public double getOfferPriceMax() {
		return search.getOfferPriceMax();
	}
    
    public void setOfferPriceMax(double priceMax) {
		search.setOfferPriceMax(priceMax);
	}
    
    public double getConfort() {
		return search.getConfort();
	}
    
    public void setConfort(double confort) {
		search.setConfort(confort);
	}
    
    public float getHotelRatingMin() {
		return search.getHotelRatingMin();
	}
    
    public void setHotelRatingMin(float priceMin) {
		search.setHotelRatingMin(priceMin);
	}
    
    public float getHotelRatingMax() {
		return search.getHotelRatingMax();
	}
    
    public void setHotelRatingMax(float priceMax) {
		search.setHotelRatingMax(priceMax);;
	}
    
    public int getDays() {
		return search.getDays();
	}
    
    public void setDays(int days) {
		search.setDays(days);
	}
	


}
