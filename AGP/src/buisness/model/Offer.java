package buisness.model;


public class Offer {
	
	private Stay proposedStay;
	private Excursion proposedExcursion;
	
	private double totalePrice;
	
	public Offer(Stay proposedStay , Excursion proposedExcursion) {
		this.setProposedStay(proposedStay);
		this.setProposedExcursion(proposedExcursion);
		
		
	}


	public Excursion getProposedExcursion() {
		return proposedExcursion;
	}


	public void setProposedExcursion(Excursion proposedExcursion) {
		this.proposedExcursion = proposedExcursion;
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
		return this.totalePrice = this.proposedStay.getHotelPrice() + this.proposedExcursion.getExcursionPrice();
	}

}
