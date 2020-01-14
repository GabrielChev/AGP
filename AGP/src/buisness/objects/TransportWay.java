package buisness.objects;

public class TransportWay {

		private String type;
		private double kilometerPrice;
		
		public TransportWay(String type, double kilometerPrice)
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
