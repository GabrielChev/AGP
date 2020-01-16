package buisness.model;

import java.util.ArrayList;

public class Offer {
	
	private Stay proposedStay;
	private ArrayList<Excursion> listExcursion;
	
	private double totalePrice;
	
	public Offer(Stay proposedStay , ArrayList<Excursion> listExcursion) {
		this.setProposedStay(proposedStay);
		this.setProposedExcursion(listExcursion);
	}


	public ArrayList<Excursion> getProposedExcursion() {
		return listExcursion;
	}


	public void setProposedExcursion(ArrayList<Excursion> listExcursion) {
		this.listExcursion = listExcursion;
	}


	public Stay getProposedStay() {
		return proposedStay;
	}


	public void setProposedStay(Stay proposedStay) {
		this.proposedStay = proposedStay;
	}


	public double getTotalePrice() {
		return this.totalePrice = this.calculateTotalePrice();
	}
	
	double calculateTotalePrice() {
		int sumExcursionPrice = 0;
		for(int i = 0; i < listExcursion.size(); i++){
			sumExcursionPrice += this.listExcursion.get(i).getExcursionPrice();
		}			
		return this.totalePrice = this.proposedStay.getHotelPrice() + sumExcursionPrice;
	}

}
