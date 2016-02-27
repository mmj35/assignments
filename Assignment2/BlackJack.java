//Melody Jolly 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class Blackjack {

	public static void main(String[] args) throws IOException {
	
		Scanner keyboard= new Scanner(System.in);
	
		//Welcome the player and tell them to enter name 
		System.out.println("Enter name> ");
		String name= keyboard.nextLine(); 
		System.out.print("Welcome, " + name + "!");
		
		/*
		//Ask the user if they have played the game before
		String play;	

		System.out.println("Is this your first time playing Black Jack? Enter Y or N?");
		play=keyboard.nextLine();
		
		
			
		while((!play.equalsIgnoreCase("Y"))&&(!play.equalsIgnoreCase("N"))) {
			System.out.println("INVALID. Enter Y or N");
				play=keyboard.nextLine();
			}
		
		while(play.equalsIgnoreCase("Y")) {
			System.out.print("Have fun on your first time playing Infinite Blackjack.");	
		}	
		*/
		
		File f = new File(name+".txt");
		
		Player user= new Player(name, 0, 0, 100);
		if(f.exists()){
			user = user.loadFile(name+".txt");
		}
				
		
		System.out.println(user);
		
		String input="";
		
			while(true) {

			do{

				System.out.println("Do you want to play a hand? Yes or No?");
				input= keyboard.nextLine();

			}while(!(input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("no")));

			if(input.equalsIgnoreCase("no")) {
			// Save the player's information to a file
				user.saveFile(f);
				break;
			}else{
				System.out.printf("\nName: %20s", name);
				System.out.printf("\nMoney: %19.2f", user.getMoney());
				System.out.printf("\nHands Won: %15d\n", user.getHandsWon());
				
				ArrayList<Card>playerHand= new ArrayList<Card>();
				ArrayList<Card>dealerHand= new ArrayList<Card>();
					
			// Ask how much the player would like to bet
				System.out.println("How much would you like to bet?)");
				double bet=keyboard.nextDouble();
				System.out.println();
		
				
			// Make sure they have at least that much money (use a loop until they enter a good amount)
				while(bet>user.getMoney()||(bet<0)) {
					System.out.println("Error. Enter a valid betting amount > ");
					bet=keyboard.nextDouble();
				}
					
			
			// Deal the player two cards
				playerHand.add(new Card());
				playerHand.add(new Card());
				
			// Print their hand
				System.out.println("Cards: ");
				int numbAces=0;
				int total=0;
				for (Card card : playerHand) {
					System.out.print(card + " ");
					if(card.getValue()>=11 && card.getValue()<=13) {
					
						total=10+total;
					}else if(card.getValue()==1) {
						numbAces++;
						total=11+total;
					}else
						total=total+card.getValue();
					
					
				}
				System.out.println();
			
			// Print the score
			
			
			
			System.out.println("Score: " + getScore(total, numbAces));
			
			 

			
			// Ask if they want to hit or stay - loop until they say stay
			
			System.out.println("Do you want to hit or stay?");
			String hit=keyboard.next();
			System.out.println();
			boolean busted = false;
			int playerScore = 0;
			while(hit.equalsIgnoreCase("hit")) {
			// Hit means deal another card
				playerHand.add(new Card());
				
				System.out.println("Cards: ");
				numbAces=0;
				total=0;
				for (Card card : playerHand) {
					System.out.print(card + " ");
					if(card.getValue()>=11 && card.getValue()<=13) {
					
						total=10+total;
					}else if(card.getValue()==1) {
						numbAces++;
						total=11+total;
					}else
						total=total+card.getValue();
				}		
				playerScore = getScore(total, numbAces);
				System.out.println("Score: " + playerScore);
				
				// If they bust, break out of the loop

				if(getScore(total, numbAces) > 21){
					System.out.println("You busted!");
					// Show them how much money they lost
					System.out.println("You lost " + bet);
					user.setMoney(user.getMoney()-bet);
					busted = true;
					break;
					
				}
				
				System.out.println("Do you want to hit or stay?");
				hit=keyboard.next();
				System.out.println();
			}
			
			if(busted == false){
				System.out.println("It's now the dealer's turn");
				dealerHand.add(new Card());
				dealerHand.add(new Card());
				boolean dealerBusted = false;
				int dealerScore = 0;
				while(true){
					System.out.println("Cards: ");
					numbAces=0;
					total=0;
					for (Card card : dealerHand) {
						System.out.print(card + " ");
						if(card.getValue()>=11 && card.getValue()<=13) {
					
							total=10+total;
						}else if(card.getValue()==1) {
							numbAces++;
							total=11+total;
						}else
							total=total+card.getValue();
					}	
					dealerScore = getScore(total, numbAces);	
					System.out.println("Score: " + dealerScore);
					// Else
				// Deal the dealer two cards
				// Loop
					// If score > 21 => dealer loses
					// Else If score >= 18 dealer stays (break)
					// Else if score == 17
						// If at least one card is an ace => hit
						// Else stay (break)
					// Else hit
					if(dealerScore > 21){
						System.out.println("The dealer has busted and the player wins.");
						user.setMoney(user.getMoney()+bet);
						dealerBusted = true;
						break;
					}
					else if (dealerScore >= 18){
						System.out.println("Dealer stays");
						break;
					}
					else if (dealerScore == 17 && numbAces>0){
						System.out.println("Dealer hits");
						dealerHand.add(new Card());
					}	
					else if(dealerScore == 17){
						System.out.println("Dealer stays");
						break;
					}
					else{
						System.out.println("Dealer hits");
						dealerHand.add(new Card());
					}
					
					
				}
				// Check the scores
					// Player has 21 points and only 2 cards => player wins and gets their money + 1.5x (so 2.5x their money)
					// Dealer has higher score than player => dealer wins, player loses their money
					// Player has higher score than dealer => player wins and gets their 2x their money
					// Equal hands => draw, player keeps their money
					// In all cases, print the result and the money won/lost
				if(playerScore==21&&playerHand.size()==2){
					System.out.println("Player has blackjack! You win extra!");
					user.setMoney(user.getMoney()+bet*1.5);
				}
				else if(dealerScore > playerScore){
					System.out.println("Dealer wins. :( Better luck next time.");
					user.setMoney(user.getMoney()-bet);
				}
				else if(playerScore > dealerScore){
					System.out.println("You win!");
					user.setMoney(user.getMoney()+bet);
				}
				else{
					System.out.println("It's a draw. You keep your bet.");
				}
			
			}
			
				
			

			

				
			}
		}


	}

				
			
				
			
	private static int getScore(int points, int numAces) {
	int score = 0;

	// If there are no aces, or if score is less than 21 with aces at
	// 11 points each, then the actual score is just
	// equal to the number of points.
	
	if (numAces == 0 || points <= 21) {
	    score = points;
	} else {

	    // Otherwise, we need to check what is the BEST score is,
	    // and that gets a little complicated.  We set a placeholder
	    // -1 for best score, and a placeholder potential score.
	    // We will keep track of what the best score is, and try
	    // different potential scores against it.  Whatever is
	    // highest without going over 21 will win as the best score.
	    
	    int bestScore = -1;
	    int potentialScore = points;

	    // Loop through _number of aces_ times.  Each time, try an
	    // increasing number of aces as a 1 value instead of an
	    // 11 value (thus, subtract 10 * j from the total points
	    // value, which assumes all Aces are equal to 11 points).
	    
	    for (int j = 0; j <= numAces; j++) {
		potentialScore = (points - (10 * j));

		// For each iteration, if the potential score is
		// better than the already-best score, but it is NOT
		// over 21 (causing us to bust), then the
		// potential score should count as our new best score.
		
		if (potentialScore > bestScore && potentialScore <= 21) {
		    bestScore = potentialScore;
		}
	    }

	    // We could have busted even when all of our aces were set
	    // to one point.  In this case, we might never have gotten a
	    // valid "best" score.  But our best potential score is the closest
	    // to a best score we have, so we will replace our placeholder -1
	    // best with the best potential score we got.

	    // Otherwise, just set the score to the best score.
	    
	    if (bestScore == -1) {
		score = potentialScore;
	    } else {
		score = bestScore;
	    }
	}
	return score;
    }
}