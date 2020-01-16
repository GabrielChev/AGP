package buisness.model;

import java.util.ArrayList;

import buisness.objects.TouristicSite;

public class CalculateDistance {
	
	double calculateDistance(double x1,double y1,double x2,double y2) {
		
		double distance = 0;
		
		distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
			
		return distance;
		
	}
	
	double calculateDistance(TouristicSite s1 , TouristicSite s2) {
		return this.calculateDistance(s1.getLatitude(), s1.getLongitude(), s2.getLatitude(), s2.getLongitude());
	}
	
	public TouristicSite findNearestSite(double latitude , double longitude , ArrayList<TouristicSite> sites) {
		
		double minDistance = 0;
		int minIndex = 0;
		double distance = minDistance;
		
		for(int i=0 ; i<sites.size(); i++) {
			distance = calculateDistance(latitude,longitude , sites.get(i).getLatitude() , sites.get(i).getLongitude());
			if(distance < minDistance) {
				minDistance = distance;
				minIndex = i;
			}
		}
		
		return sites.get(minIndex);
	}
     
}
