package buisness.model;

import buisness.objects.Hotel;

public class Stay {
	
	private int stayDuration ; //number of days
	private Hotel hotel;
	
	private double hotelPrice;

	public Stay(Hotel hotel , int duration) {
		this.hotel = hotel;
		this.stayDuration = duration;
		this.hotelPrice = calculateHotelPrice();
	}
	
	double calculateHotelPrice() {
		return this.hotelPrice = this.stayDuration * this.hotel.getPrice();	
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
		return hotelPrice = this.calculateHotelPrice();
	}

}
