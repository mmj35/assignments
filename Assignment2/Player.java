import java.io.*;
import java.util.*;
public class Player {
	
		private String name;
		private int hands;
		private int handsWon;
		private double Money;
	
		public Player(String name, int hands,int handsWon,double Money) {
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
		 public double getMoney() {
		 	return Money;
		 }
		 
		 public void setHands(int h) {
		 	hands=h;
		 }
		 public void setHandsWon(int w) {
		 	handsWon=w;
		 }
		 public void setMoney(double m) {
		 	Money=m;
		 }
		 
		 public Player loadFile(String fileName) throws FileNotFoundException {
		 //read file and store file info into variables
		 File f = new File(fileName);
		 Scanner sc = new Scanner(f);
		 
		 
		 int count=0; 
		 
		 while(sc.hasNext()) {
		 	String line= sc.nextLine();
		 
		 	if(count==0) {
		 		hands=Integer.parseInt(line);
		 	}
		 	if(count==1) {
		 		handsWon=Integer.parseInt(line);
		 	}
		 	if(count==2) {
		 		Money=Double.parseDouble(line);
		 	}
		 	count++;
		 }
		 Player p = new Player("", hands, handsWon, Money);
		 return p;
		 
		 }
		 
		 public void saveFile(File f) throws FileNotFoundException {
		 	PrintWriter w= new PrintWriter(f); 
			w.println(hands);
			w.println(handsWon);
			w.println(Money); 
			w.close();
		 }
		 
		 
}
	

		
	