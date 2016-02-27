import java.util.Random; 
	public class Card { 
		public static Random randomNumbers = new Random();

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
			}
			
			int valueNumb= randomNumbers.nextInt(13) + 1;
			value=valueNumb;
		}
	
	
		public String toString() {
			String toReturn = "";
			if(value==1) {
				toReturn= "a";
			}else if(value==2) {
				toReturn= "2";
			}else if(value==3) {
				toReturn= "3";
				 
			}
			else if(value==4) {
				toReturn= "4";
				 
			}
			else if(value==5) {
				toReturn= "5";
				 
			}
			else if(value==6) {
				toReturn= "6";
				 
			}
			else if(value==7) {
				toReturn= "7";
				 
			}
			else if(value==8) {
				toReturn= "8";
				 
			}
			else if(value==9) {
				toReturn= "9";
				 
			}
			else if(value==10) {
				toReturn= "t";
				 
			}
			else if(value==11) {
				toReturn= "j";
				 
			}
			else if(value==12) {
				toReturn= "q";
				 
			}
			else if(value==13) {
				toReturn+= "k";
				 
			}
			return (toReturn + suit);
			}                                  
			
			
			public int getValue() {
				
				return value;
			
			}
			
			
		}
			
		

