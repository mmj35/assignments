import.java.util;
import.java.util.Random; 
	public class Card { 
		Scanner keyboard= new Scanner(System.in);
		Random randomNumbers = new Random();

	
		private String suit;
		private int value;
		
		
		public Card() {
		
		int suitNumb = randomNumbers.nextInt(4);
			if(suitNumb==0) {
				suit="h;
			}
			if(suitNumb==1) {
				suit="d";
			}
			if(suitNumb==2)	{
				suit="s";
			}
			if(suitNumb==3) {
				suit="c";
			
			
		
		this.suit=suit;
		this.value=value;
		
		}
	
	


}