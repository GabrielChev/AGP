package buisness.model;

public class Transport {
	
	private String type;
	private double KiloMeterPrice;
	
	public Transport(String type , double KiloMeterPrice) {
		this.type = type;
		this.KiloMeterPrice = KiloMeterPrice;
	}
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public double getKiloMeterPrice() {
		return KiloMeterPrice;
	}

	public void setKiloMeterPrice(double kiloMeterPrice) {
		KiloMeterPrice = kiloMeterPrice;
	}

}
