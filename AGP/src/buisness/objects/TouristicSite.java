package buisness.objects;

public class TouristicSite {

		private String name;
		private String type;
		private String description;
		private double longitude;
		private double latitude;
		private double price;
		
		
		public TouristicSite(String name, String type, String description, double longitude, double latitude, double price)
		{
			this.name = name;
			this.type = type;
			this.description = description;
			this.longitude = longitude;
			this.latitude = latitude;
			this.price = price;
		}




		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
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
		
		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}
		
		@Override
		public String toString() {
			return "TouristicSite [name=" + name + ", type=" + type + ", description=" + description + ", longitude="
					+ longitude + ", latitude=" + latitude + " price" +price +"]";
		}
}
