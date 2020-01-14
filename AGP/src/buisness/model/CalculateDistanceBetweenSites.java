package buisness.model;

import buisness.objects.TouristicSite;

public class CalculateDistanceBetweenSites {
	
	double calculateDistance(double x1,double y1,double x2,double y2) {
		
		double distance = 0;
		
		distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
			
		return distance;
		
	}
	
	double calculateDistance(TouristicSite s1 , TouristicSite s2) {
		return this.calculateDistance(s1.getLatitude(), s1.getLongitude(), s2.getLatitude(), s2.getLongitude());
	}
     
}
