package buisness.objects;

public class Hotel {
	
	private String name ;
	private String beach;
	private double price;
	private double longitude;
	private double latitude;
	private double rating;
	
	public Hotel(String name, String beach, double price, double longitude, double latitude, double rating)
	{
		this.name = name;
		this.beach = beach;
		this.price = price;
		this.longitude = longitude;
		this.latitude = latitude;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", beach=" + beach + ", price=" + price + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", rating=" + rating + "]";
	}
	
}
