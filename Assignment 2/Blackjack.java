import java.util.Scanner; 
public class BlackJack { 
	public static void main (String [] args) {
		Scanner keyboard= new Scanner(System.in);
	
		System.out.println("Enter name> ");
		String name= keyboard.nextLine(); 
		System.out.print("Welcome, " + name + "!");
		System.out.print("Have fun on your first time playing Infinite Blackjack.");
		
		
		Player user= new Player(name, 0, 0, 100);
		
		System.out.print("Name:                " + name);
		System.out.print("Total Hands won             0");
		System.out.print("Money:                      0");                 
	
	}
}