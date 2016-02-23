public class Player {
	
		private String name;
		private int hands;
		private int handsWon;
		private double Money;
	
		public Player(String name, int hands,int handsWon,int Money) {
			this.name =name;
			this.hands=hands;
			this.handsWon=handsWon;
			this.Money=Money;	
		}
		
		public String toString() {
		
			return "\nName:   " + name + "\n"+ "hands:    " + hands + "\n" + "handsWon:    " 
							+ handsWon + "\n" + "Money:   " + Money + "\n";
						
						
		}
		 public int getHands() {
		 
		 	return hands;
		 
		 }
		 public int getHandsWon() {
		 	return handsWon;
		 }
		 public int getMoney() {
		 	return Money;
		 }
		 
		 public void setHands(int h) {
		 	hands=h;
		 }
		 public void setHandsWon(int w) {
		 	handsWon=w;
		 }
		 public void setMoney(int m) {
		 	Money=m;
		 }
		 	
	}

		
	