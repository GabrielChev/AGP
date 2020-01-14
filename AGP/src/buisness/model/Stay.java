package buisness.model;

import buisness.objects.Hotel;
import buisness.objects.TouristicSite;

public class Stay {
	
	private int stayDuration ; //number of days
	private Hotel hotel;
	private TouristicSite [] touristiqueSites;
	private Transport[] transports;  //it must be transports.length() = touristiqueSites.length() - 1
	
	private double hotelPrice;
	private double excursionPrice;
	private double totalePrice;

	double calculateHotelPrice() {
		return this.hotelPrice = this.stayDuration * this.hotel.getPrice();	
	}
	
	
	double calculateExcursionPrice() {
		int i = 0;
		int j = 1;
		double dis = 0;
		
		CalculateDistanceBetweenSites cal = new CalculateDistanceBetweenSites();
		
		while(j < this.touristiqueSites.length) {
			dis = cal.calculateDistance(this.touristiqueSites[i] , this.touristiqueSites[j]);
			this.excursionPrice += dis * this.transports[i].getKiloMeterPrice() + this.touristiqueSites[i].getPrice();
			i +=1;
			j+=1;	
		}
		
		return  this.excursionPrice;
		
	}
	
	double calculateTotalePrice() {
		return this.totalePrice = this.hotelPrice + this.excursionPrice;
	}

	public int getStayDuration() {
		return stayDuration;
	}

	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public double getHotelPrice() {
		return hotelPrice;
	}


	public double getExcursionPrice() {
		return excursionPrice;
	}


	public double getTotalePrice() {
		return totalePrice;
	}

}
