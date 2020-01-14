package buisness.model;

public class Bus implements TransportOutil {

	private double KiloMeterPrice;
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "bus";
	}

	@Override
	public double getKiloMeterPrice() {
		// TODO Auto-generated method stub
		return this.KiloMeterPrice;
	}

	@Override
	public void setKiloMeterPrice(double kiloMeterPrice) {
		// TODO Auto-generated method stub
		this.KiloMeterPrice = kiloMeterPrice;
	}

}
