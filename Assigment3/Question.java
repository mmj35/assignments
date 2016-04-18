import java.util.ArrayList; 
public class Question {
	
	
private String Quest;

private int N;

private ArrayList<String> Answers = new ArrayList<String>();

private int K;
private int T;
private int C;

//creates constructor
public Question(String Quest) {

	this.Quest= Quest;
	
}

//adds getters and setters
public void setAnswer (String Answers) {
	this.Answers.add(Answers);
}

public void setN (int N) {
	this.N=N;
}


public void setK (int K) {
	this.K=K;
}

public void setT (int T) {

	this.T=T;
}

public void setC (int C) {
	this.C=C;
}

public String getQuestions () {
	return this.Quest;
}

public ArrayList<String> getAnswers () {
	return this.Answers;
}

public int getN () {
	return this.N;
}	

public int getK () {
	return this.K;
}
	
public int getT () {
	return this.T;
}

public int getC () {
	return this.C;
}

}