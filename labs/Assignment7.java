import java.util.Scanner;
import java.io.PrintWriter;
public class Assignment7 {
	public static void main(String [] args)throws Exception {
	
		Scanner keyboard= new Scanner(System.in);
	
		
		System.out.println("How big is the universe?");
		int size=keyboard.nextInt();
		
		char [] land= generateUniverse(size);
			
		
		while(true) {
		for(int x=0;x<size;x++) {
		System.out.print(land[x]);
		}
		
		System.out.println();
		
		System.out.println("Do you want to quit,advance one iteration or Save to a file?");
		String input=keyboard.nextLine();
		System.out.println();
		
		if(input.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
			
		char Numericon;
		char NumericonBaby='0';
		char NumericonChild='1';
		char NumericonAdult='2';
		
		if(input.equalsIgnoreCase("advance")) {
			for(int x=0;x<size;x++) {
				if(land[x]==NumericonBaby) {
					land[x]='1';
				}else if(land[x]==NumericonChild) {
					land[x]='2';
				}else if(land[x]==NumericonAdult) {
					if(x!=size-1) {
						if(land[x+1]=='.') {
							land[x+1]='2';
							land[x]='.';	
						}
						if(land[x+1]=='^') {
							land[x+1]='0';
							land[x]='.';
						}
						x++;
					}
				}
			}
		}
		
		if(input.equalsIgnoreCase("save")) {
			PrintWriter writer = new PrintWriter("universe.txt","UTF-8");
			int counter1=0;
			int	counter2=1;
			int counter3=2;
			for(int x=0;x<size;x++) {
				writer.print(land[x]);
					if(land[x]=='0') {
						counter1++;
					}
					if(land[x]=='1') {
						counter2++;
					}
					if(land[x]=='2') {
						counter3++;
					}
				}
				writer.println();
				writer.println("baby "+ counter1);
				writer.println("child " + counter2);
				writer.println("adult" + counter3);
				writer.close();
			}
		}
}
				
				
				
			
				
	



	private static char[] generateUniverse(int size) {
	
		char [] land= new char[size];
			
		for(int x=0;x<size;x++) {
				land[x]='.';
				
			
		}
		for(int x=5;x<size;x+=5) {
				land[x]='^';
				
		}
				
			
			char NumericonBaby='0';		
		for(int x=0; x<size;x+=7) {
				land[x]=NumericonBaby;
				
		}
			return land;			
		
		
		
	}
			
			
}