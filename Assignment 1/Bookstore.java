import java.util.Scanner; 
public class Bookstore {	
	public static void main(String [] args) {
	
	Scanner keyboard= new Scanner(System.in); 
	
	int customer;
	
	System.out.println("More customers in line? 1= yes and 2= no.");
	customer=keyboard.nextInt();
	System.out.println();
	
	if(customer==2) 
		System.exit(0);
	
	int books;
	int bookmarks;
	int bookPacks;
	int paintings;
	
	double booksCost= books * 5.00;
	double bookmarksCost= bookmarks * 1.00;
	double bookpackCost= bookpacks * 5.00;
	double paintingsbookCost= paintings * 100.00;
	
	
	System.out.println("How many books do you want to buy?");
	books= keyboard.nextInt();
	
	
	System.out.println("How many bookmarks do you want to buy?");
	bookmarks
	}

}