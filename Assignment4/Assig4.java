//Melody Jolly

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

class Ballot extends JPanel
{ 
	String[] options;
	String ballotID, category, result;
	JPanel panel = new JPanel();
	JButton[] buttons;
	JLabel ballotName;
	
	public Ballot(String tempID, String tempcategory, String[] tempoptions)
	{	
		//Instantiating characteristics of separate ballots
		this.ballotID = tempID;
		this.options = tempoptions.clone();
		this.category = tempcategory;
		this.buttons = new JButton[this.options.length];
		this.ballotName = new JLabel(this.category);

		//Adds Panel to Frame
		add(this.panel);
		this.panel.setLayout(new GridLayout(this.options.length+1,1));
		//Adds Ballot Category Before buttons are added
		this.panel.add(ballotName);

		//Adds Buttons to Panel
		for(int i=0; i<this.buttons.length; i++)
		{
			this.buttons[i]=new JButton(this.options[i]);
			this.buttons[i].setName(this.options[i]);
			this.buttons[i].addActionListener(new ButtonListener());
			this.panel.add(buttons[i]);
			this.buttons[i].setEnabled(false);
		}

		this.panel.setVisible(true);

	}

	public String castVote()
	{
		for(int i=0; i<this.buttons.length;i++)
		{
			if(this.buttons[i].getForeground()==Color.RED)
			{
				result=this.buttons[i].getText() + ":1";
			}
		}
		return result;
	}
	
	//Method that Enables all Buttons
	public void enableButtons()
	{
		for(int i=0; i<buttons.length; i++)
		{
			this.buttons[i].setEnabled(true);
		}
	}

	//Action listener for Voting Buttons
	public class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			//Casts source to be a JButton to allow JButton methods to be performed on source
			JButton source = (JButton)e.getSource();
			//Changes all buttons back to black when a button is pressed
			for(int i=0; i<buttons.length;i++)
			{
				buttons[i].setForeground(Color.BLACK);
			}
			//Changes the pressed button to have red text
			source.setForeground(Color.RED);

		}
	}

}

public class Assig4 {
	//Global Ballot Array List so it can be accesed by LoginListener
	static ArrayList<Ballot> BallotArray = new ArrayList<Ballot>();
	static JButton loginbutton = new JButton("Login");
	static JButton castbutton = new JButton("Cast Vote");
	
	
	public static void main(String[] args)
	{//Beginning of Main

		//Declarations and Frame
		JFrame frame = new JFrame ("Ballot Stuff");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Login to Vote / Cast Vote Panel
		JPanel votepanel = new JPanel();
		votepanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Scanner scan = new Scanner(System.in);

		//Reads in file name
		System.out.println("Enter Name of File: ");
		String filename = scan.nextLine();
		
		//Opens files for scanners
		File votes = new File("C:\\Users\\Melody\\Workspace\\Assignment4\\src\\votes.txt");
		File file = new File("C:\\Users\\Melody\\Workspace\\Assignment4\\src\\"+filename);
		File voters = new File("C:\\Users\\Melody\\Workspace\\Assignment4\\src\\voters.txt");
	
		try
		{//Beginning of Try
			//Declaring Variables for Ballot Object Parameters
			int numballots, numvoters=0;;
			String category, ballotID,booleantempstring;

			PrintWriter write = new PrintWriter(votes);
			
			//Creates new file scanner that reads the given file
			Scanner fscan = new Scanner(file);
			Scanner counterscan = new Scanner(voters);
			Scanner voterscan = new Scanner(voters);
			//Scans Number of Ballots
			numballots = fscan.nextInt();
			String[] tempstring = new String[numballots];
			//Reads in Ballot Characteristics from File
			for(int i=0; i<numballots; i++)
			{
				fscan.useDelimiter(":");
				ballotID = fscan.next();//Reads in Ballot ID
				category = fscan.next();//Reads in Ballot Category
				fscan.reset();// Resets Delimiter
				fscan.skip(":"); //Skips last : character so it is not read into the string array
				tempstring[i] = fscan.next(); //Reads in the vote options into one string
				String[] voteoptions = tempstring[i].split(",");//Splits tempstring up into button names and adds to the voteoptions ArrayList
				BallotArray.add(new Ballot(ballotID, category, voteoptions));//Passes the string array into the ballot object
			}

			//Loop to find number of registered voters
			while(counterscan.hasNextLine())
			{
				numvoters++;
				counterscan.nextLine();
			}

			//Instantiates arrays for voter data
			boolean[] hasVoted = new boolean[numvoters];
			String[] voterID = new String[numvoters];
			String[] voterNames = new String[numvoters];

			//Loop to read in registered voters file
			for(int i=0;i<numvoters;i++)
			{
				String[] temp = voterscan.nextLine().split(":");
				voterID[i] = temp[0];//Reads in Voter ID
				voterNames[i] = temp[1];//Reads in Voter Name
				booleantempstring = temp[2]; //Reads in voted flag
				hasVoted[i]=Boolean.parseBoolean(booleantempstring);//Parses boolean from flag
			}//End of For Loop
			
			//Adds Action Listiner for Login Button
			loginbutton.addActionListener
			(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//Brings up input dialog that asks for user ID
						String ID = JOptionPane.showInputDialog("Enter Your Voter ID: ");
						for(int i=0; i<voterID.length;i++)
						{	//If entered ID is registered and has not voted
							if(ID.equals(voterID[i]) && hasVoted[i]==false)
							{
								//Enables all Buttons
								for(int j=0; j<BallotArray.size();j++)
								{
									BallotArray.get(j).enableButtons(); 
								}
								//Greets the Voter
								JOptionPane.showMessageDialog(frame, "Hello " + voterNames[i] + "\nPlease Make Your Choices");
								loginbutton.setEnabled(false); //Temporariliy disables the login button
								castbutton.setEnabled(true); //Enables the Cast Vote Button
							}
						}
					}
				}
			); //End of AddActionListener;
			
			//Adds ActionListener for Cast Vote Button
			castbutton.addActionListener
			(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JOptionPane.showMessageDialog(frame, "Your vote was recorded");
						String tempstring = null;
						for(int i=0;i<BallotArray.size();i++)
						{
							//Gets String from castVote method and writes it to votes file
							tempstring = BallotArray.get(i).castVote();
							write.println(tempstring);
						}
						write.close();
						castbutton.setEnabled(false);
						loginbutton.setEnabled(true);
					}
				}
			);//End of addActionListener
			
		}//End of Try

		//Catches file not found error
		catch(FileNotFoundException e)
		{//Beginning of Catch
			System.out.println("Error: File Not Found");
			System.exit(0);
		}//End of Catch

		for(int i=0;i<BallotArray.size();i++)
		{
			frame.add(BallotArray.get(i));
		}

		frame.add(votepanel);
		votepanel.add(loginbutton, BorderLayout.NORTH);
		castbutton.setEnabled(false);
		votepanel.add(castbutton, BorderLayout.SOUTH);

		frame.pack();
		frame.setLayout(new GridLayout(1,(BallotArray.size()+2)));
		frame.setVisible(true);

	}//End of Main

}//End of Class
