package buisness.objects;

public class Transport {

		private String type;
		private double kilometerPrice;
		private double kilometerDuration;
		
		
		public double getKilometerDuration() {
			return kilometerDuration;
		}


		public void setKilometerDuration(double kilometerDuration) {
			this.kilometerDuration = kilometerDuration;
		}


		public Transport() {}
		
		
		public Transport(String type, double kilometerPrice)
		{
			this.type = type;
			this.kilometerPrice = kilometerPrice;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public double getKilometerPrice() {
			return kilometerPrice;
		}

		public void setKilometerPrice(double kilometerPrice) {
			this.kilometerPrice = kilometerPrice;
		}

		@Override
		public String toString() {
			return "TransportWay [type=" + type + ", kilometerPrice=" + kilometerPrice + "]";
		}
		
}