import.java.util;
import.java.util.Random; 
	public class Card { 
			public static Random randomNumbers = new Random();

		private int cardType;
		private String suit;
		private int value;
		
		
		public Card() {
		
		int suitNumb = randomNumbers.nextInt(4);
			if(suitNumb==0) {
				suit="h";
			}
			if(suitNumb==1) {
				suit="d";
			}
			if(suitNumb==2)	{
				suit="s";
			}
			if(suitNumb==3) {
				suit="c";
			
			
		int valueNumb= randomNumbers.nextInt(10);
				value=valueNumb;
		}
	
	
		public String toString() {
			string val;
			if(cardType==1) {
				val= "a";
			}else if(cardType==2) {
				val= "2";
			}else if(cardType==3) {
				val= "k" 
			}
			return (val + suit);
			}
			
		
		}

}