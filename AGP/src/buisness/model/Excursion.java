package buisness.model;

import java.util.List;

import buisness.objects.TouristicSite;

class Excursion {
	
	private List<TouristicSite> sites;
	private List<TransportOutil> transports;
		
	//the first parameter must be the list of sites to be visited during this excursion
	//the second parameter should be the list of transports to be used during this excursion
	Excursion(List<TouristicSite> sites , List<TransportOutil> transports){
		this.sites=sites;
		this.transports = transports;	
	}
}
