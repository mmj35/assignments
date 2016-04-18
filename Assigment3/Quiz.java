import java.io.PrintWriter;
import java.util.ArrayList; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner; 
public class Quiz {
	public static void main(String [] args)throws Exception {

		//testing number of inputs
		if(args.length!=1) {
			System.out.println("You don't have the correct number of inputs");
			System.exit(0);
		}

		String fileName = args[0];

		// FileReader reads text files in the default encoding.
		FileReader fileReader = new FileReader(fileName);




		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = 
			new BufferedReader(fileReader);

		//create Array List of questions
		ArrayList<Question> Questions= new ArrayList<Question>();
		//read the file
		String line = bufferedReader.readLine();
		while(line != null) {

			Question ques = new Question(line);

			int N=Integer.parseInt(bufferedReader.readLine());

			ques.setN(N);
			for(int i=0; i<N;i++) {
				//read in all of the set answers
				ques.setAnswer(bufferedReader.readLine());

			} 

			int K =Integer.parseInt(bufferedReader.readLine());
			ques.setK(K);

			int T =Integer.parseInt(bufferedReader.readLine());
			ques.setT(T);

			int C =Integer.parseInt(bufferedReader.readLine());
			ques.setC(C);

			Questions.add(ques);
			line = bufferedReader.readLine();
		}   



		// Always close files.
		bufferedReader.close();         
		int i=0;   

		Scanner W = new Scanner(System.in);
		int Right=0;
		int Wrong=0;
		double Pct=0.0;
		for(Question q : Questions) {
			//print out questions
			System.out.println("Question " + i + " :");
			System.out.println(q.getQuestions());
			//print out answers
			System.out.println("Answers : ");
			ArrayList<String> Answers= new ArrayList<String>(q.getAnswers());
			for(int j=0;j<Answers.size();j++) {
				System.out.println(j + ": " + Answers.get(j));
			}

			//insures valid input
			int input;
			
				System.out.print("Your answer? (enter a number): ");
				input=W.nextInt();

				while(input<0||input>q.getN()) {
					//check whether person answers correctly
					System.out.print("Your answer? (enter a number): ");
					input=W.nextInt();
				}
					if (input==q.getK()) {
						q.setC(q.getC() + 1);
						Right++;

					}else
						Wrong++;

					//update number of tries
					q.setT(q.getT() + 1);
					//update index of questions
					i++;

		}
				System.out.println("Your overall performance was : ");
				System.out.println("Right " + Right);
				System.out.println("Wrong " + Wrong);
				System.out.println("Percentage " + (double)Right/(Right + Wrong) *100);

			
			int m=0; 
			double Percentage=0;
			double hardestPercentage=100;
			double easiestPercentage=0;
			int hardestIndex=0;
			int easiestIndex=0;
			for(Question x : Questions) {
				//print out questions
				System.out.println("Question " + m + " :");
				System.out.println("Right " + x.getC());
				System.out.println("Tried " + x.getT());
				Percentage=(double)x.getC()/x.getT() * 100;
				System.out.println("Percentage " + Percentage);
				
				if(Percentage<hardestPercentage) {
					hardestPercentage=Percentage;
					hardestIndex=m;
					
				}
				if(Percentage>easiestPercentage) {
					easiestPercentage=Percentage;
					easiestIndex=m;
				}
				
				
				m++;

				
			}

			System.out.println("The easiest question was:" + Questions.get(easiestIndex).getQuestions());
			System.out.println("Times Correct " + Questions.get(easiestIndex).getC());
			System.out.println("Times Tried " +Questions.get(easiestIndex).getT());
			System.out.println("Percent Correct " + easiestPercentage);
			
			

			System.out.println("The hardest question was:" + Questions.get(hardestIndex).getQuestions());
			System.out.println("Times Correct " + Questions.get(hardestIndex).getC());
			System.out.println("Times Tried " +Questions.get(hardestIndex).getT());
			System.out.println("Percent Correct " + hardestPercentage);
			
			PrintWriter w= new PrintWriter(fileName);
			for(Question q : Questions) {
				w.println(q.getQuestions());
				w.println(q.getN());
			
				ArrayList<String> Answers = new ArrayList<String>();
			
				Answers=q.getAnswers();
				
				int b;
				for(b=0;b<Answers.size();b++) {
				w.println(Answers.get(b));
				}
				w.println(q.getK());
				w.println(q.getT());
				w.println(q.getC());
				
			}
				w.close();
	}

}
