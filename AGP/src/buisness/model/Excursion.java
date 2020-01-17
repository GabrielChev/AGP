package buisness.model;

import java.util.ArrayList;

import buisness.objects.TouristicSite;
import buisness.objects.Transport;

public class Excursion {
	
	private ArrayList<TouristicSite> sites;
	private ArrayList<Transport> transports;
	
	private double excursionPrice;
		
	//the first parameter must be the list of sites to be visited during this excursion
	//the second parameter should be the list of transports to be used during this excursion
	public Excursion(ArrayList<TouristicSite> sites , ArrayList<Transport> transports2){
		this.sites=sites;
		this.transports = transports2;	
	}

	public double getExcursionPrice() {
		return excursionPrice = this.calculateExcursionPrice() ;
	}

	double calculateExcursionPrice() {
		int i = 0;
		int j = 1;
		double dis = 0;
		
		CalculateDistance cal = new CalculateDistance();
		
		while(j < this.sites.size()) {
			dis = cal.calculateDistance(this.sites.get(i), this.sites.get(j));
			this.excursionPrice += dis * this.transports.get(i).getKilometerPrice() + this.sites.get(i).getPrice();
			i +=1;
			j+=1;	
		}
		
		return  this.excursionPrice;
		
	}

	public ArrayList<TouristicSite> getSites() {
		return sites;
	}

	public void setSites(ArrayList<TouristicSite> sites) {
		this.sites = sites;
	}

	public ArrayList<Transport> getTransports() {
		return transports;
	}

	public void setTransports(ArrayList<Transport> transports) {
		this.transports = transports;
	}

	public void setExcursionPrice(double excursionPrice) {
		this.excursionPrice = excursionPrice;
	}
}
