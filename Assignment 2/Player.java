public class Player {
	
		String name;
		int hands;
		int handsWon;
		int Money;
	
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
	}
	
		
	