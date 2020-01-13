package buisness.objects;

public class Isle {

		private String name;
		
		public Isle(String name)
		{
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Isle [name=" + name + "]";
		}
		
		
}
