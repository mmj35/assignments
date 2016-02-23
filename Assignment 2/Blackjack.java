import java.util.Scanner; 
public class BlackJack { 
	public static void main (String [] args) {
		Scanner keyboard= new Scanner(System.in);
	
		System.out.println("Enter name> ");
		String name= keyboard.nextLine(); 
		System.out.print("Welcome, " + name + "!");
		System.out.print("Have fun on your first time playing Infinite Blackjack.");
		
		
		Player user= new Player(name, 0, 0, 100);
		
		System.out.println(user);
		
		String input="";
		
		while(true) { 
		
			do{
		
				System.out.println("Do you want to play a hand? Yes or No?");
				input= keyboard.nextLine();
				System.out.println(input);
		
			}while(!(input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("no")));
			
			if(input.equalsIgnoreCase("no")) {
				break;
			}else{
			
			
			
			}
				
			
		}
		
		
		
	}
}