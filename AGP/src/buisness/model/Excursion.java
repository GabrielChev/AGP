package buisness.model;

import java.util.ArrayList;

import buisness.objects.TouristicSite;

class Excursion {
	
	private ArrayList<TouristicSite> sites;
	private ArrayList<TransportOutil> transports;
	
	private double excursionPrice;
		
	//the first parameter must be the list of sites to be visited during this excursion
	//the second parameter should be the list of transports to be used during this excursion
	Excursion(ArrayList<TouristicSite> sites , ArrayList<TransportOutil> transports){
		this.sites=sites;
		this.transports = transports;	
	}

	public double getExcursionPrice() {
		return excursionPrice = this.calculateExcursionPrice() ;
	}

	double calculateExcursionPrice() {
		int i = 0;
		int j = 1;
		double dis = 0;
		
		CalculateDistanceBetweenSites cal = new CalculateDistanceBetweenSites();
		
		while(j < this.sites.size()) {
			dis = cal.calculateDistance(this.sites.get(i), this.sites.get(j));
			this.excursionPrice += dis * this.transports.get(i).getKiloMeterPrice() + this.sites.get(i).getPrice();
			i +=1;
			j+=1;	
		}
		
		return  this.excursionPrice;
		
	}
}
