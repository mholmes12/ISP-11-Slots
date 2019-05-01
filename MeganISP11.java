/*
    Megan Holmes
    Krasteva
    January 16, 2019
    This program is a virtual slot machine whih includes instructions and an administrative level. Game play includes spinning the slots
    and betting money until you are happy or have ran out! Also, come back to the game at any time and continue playing.
	The splash screen gives a brief introduction and a fun animation of rolling casino chips. It also continues to the main menu.
	The main menu displays each continue option and includes graphics of slots symbols. This also controls the program flow.

		     VARIABLES
    NAME               TYPE        DESCRIPTION
    --------------------------------------------------
    results            boolean     Stores the slot results (win or lose: true or false)
    moneyBet           int         Stores the amount the user bets each round.
    balance            int         Users balance that is added to or taken from depending on results. Balance starts at $100.
    continueChoice     char        User input in the main menu that controls program flow
    mainFont           int         Font used throughout the program
    graphicsSevenFont  int         Used in graphics needed for machine
    barGraphicsFont    int         Used in other graphics needed for machine
    winCount           int         Keeps
    userName           String      Used to access previous games and inputted in the display.


*/
import java.awt.*;
import hsa.*;
import javax.swing.JOptionPane; //imports the J pane console
import java.io.*;
import java.util.Random;

public class MeganISP11
{
    Console c;            // c is variable representation of Console
    //global variable declarations

    boolean results = false;
    int moneyBet = 0;
    int balance = 100;
    int winCount = 0;
    int lossCount = 0;
    String userName = " ";
    char continueChoice;
    Font mainFont = (new Font ("Times New Roman", 1, 20));
    Font graphicsSevenFont = (new Font ("Times New Roman", 3, 85));
    Font barGraphicsFont = (new Font ("Times New Roman", 3, 35));
    Color background = new Color (201, 235, 255);

    public MeganISP11 ()    //constructor
    {
	c = new Console ();   //creates new instance of Console for use by the class
    }


    //title method
    public void title ()
    {
	Color title = new Color (93, 12, 255); //one time variable to set the colour of the title
	c.clear (); //clears screen
	c.setColor (background);
	c.fillRect (0, 0, 640, 500);
	c.setColor (title);
	c.setFont (new Font ("Algerian", -10, 30));
	c.drawString ("Virtual Slots Machine", 145, 30);
    }


    //method to pause program
    public void pauseProgram ()
    {
	c.setColour (Color.black);
	c.setTextBackgroundColor (Color.white);
	c.setFont (mainFont);
	c.drawString ("Press any key to continue...", 210, 450);
	c.getChar ();
    }


    //This method outputs the splashScreenduction that explains the purpose of the program and has has graphics.
    //The every for loop is used to create a 3D block, and draws parallelograms.
    public void splashScreen ()
    {
	background = (new Color (252, 142, 121));
	Color middlePurple = new Color (212, 185, 229);
	Color darkPurple = new Color (153, 102, 255);
	Font splashFont = (new Font ("Times New Roman", 3, 20));
	title ();
	c.setFont (splashFont);
	c.setColour (Color.white);
	c.drawString ("Welcome to the Virtual Slot Machine!", 170, 130);
	c.drawString ("This program will allow you to try your luck at the slots!", 90, 150);
	c.drawString ("Good Luck!", 240, 170);
	//graphics
	for (int i = 0 ; i <= 760 ; i++)
	{
	    c.setColor (background);
	    c.fillOval (-120 + i, 220, 50, 50); //chip erases
	    c.fillOval (-70 + i, 270, 50, 50);
	    c.fillOval (-20 + i, 320, 50, 50);
	    c.setColor (Color.white);
	    c.fillOval (-119 + i, 220, 51, 51); //rolling chip leaving trail
	    c.setColor (middlePurple);
	    c.fillOval (-69 + i, 270, 51, 51); //rolling chip leaving trail
	    c.setColor (darkPurple);
	    c.fillOval (-19 + i, 320, 51, 51); //rolling chip leaving trail
	    c.setColor (Color.black);
	    c.fillArc (-16 + i, 323, 48, 48, 0 + i, 25); // third chip details
	    c.fillArc (-16 + i, 323, 48, 48, 40 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 80 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 120 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 160 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 200 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 240 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 280 + i, 25);
	    c.fillArc (-16 + i, 323, 48, 48, 320 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 0 + i, 25); // second chip details
	    c.fillArc (-66 + i, 273, 48, 48, 40 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 80 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 120 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 160 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 200 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 240 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 280 + i, 25);
	    c.fillArc (-66 + i, 273, 48, 48, 320 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 0 + i, 25); // first chip details
	    c.fillArc (-116 + i, 223, 48, 48, 40 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 80 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 120 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 160 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 200 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 240 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 280 + i, 25);
	    c.fillArc (-116 + i, 223, 48, 48, 320 + i, 25);
	    c.fillOval (-108 + i, 230, 31, 31); //rolling chip center
	    c.fillOval (-58 + i, 280, 31, 31); //rolling chip center
	    c.fillOval (-8 + i, 330, 31, 31); //rolling chip center
	    c.setColor (Color.white);
	    c.fillOval (-105 + i, 233, 25, 25);
	    c.setColor (middlePurple);
	    c.fillOval (-55 + i, 283, 25, 25);
	    c.setColor (darkPurple);
	    c.fillOval (-5 + i, 333, 25, 25);
	    //used to delay the animation
	    try
	    {
		Thread.sleep (8);
	    }
	    catch (Exception e)
	    {
	    }
	}
	pauseProgram ();
    }


    public void mainMenu ()
    {
	background = (new Color (255, 188, 81));
	Color stripeRed = (new Color (153, 0, 0));
	Color stripeLightPurple = (new Color (212, 185, 229));
	Color stripePurple = (new Color (71, 0, 179));
	Color barGrey = (new Color (120, 115, 122));
	Font menuFont = (new Font ("Times New Roman", 1, 22));
	title (); //clear screen and display title
	userName = " "; //reset user name
	//create pattern
	c.setColor (stripeLightPurple);
	c.fillRect (0, 460, 640, 500);
	c.setColor (stripePurple);
	c.fillRect (0, 455, 640, 10);
	c.drawLine (0, 452, 640, 452);
	c.drawLine (0, 450, 640, 450);
	c.drawLine (0, 448, 640, 448);
	c.setColour (Color.black);
	c.setFont (menuFont);
	c.drawString ("Enter an Option:", 20, 120);
	c.drawString ("New Game: n", 20, 160);
	c.drawString ("Continue Game: c", 20, 190);
	c.drawString ("Instructions: i", 20, 220);
	c.drawString ("Administrative: a", 20, 305);
	c.drawString ("Exit: e", 20, 275);
	//graphics
	c.setFont (graphicsSevenFont);
	c.setColor (Color.black);
	c.drawString ("7", 409, 239);
	c.setColor (stripeRed);
	c.drawString ("7", 405, 240);
	c.setColor (Color.black);
	//bar sign
	c.setColor (barGrey);
	c.fillRoundRect (420, 260, 150, 80, 50, 50);
	c.setFont (barGraphicsFont);
	c.setColor (background);
	c.drawString ("b a r", 460, 310);
	//draw chip
	c.setColor (Color.white);
	c.fillOval (300, 150, 100, 100);
	c.fillOval (450, 100, 100, 100);
	//draw chip details
	for (int l = 0 ; l < 340 ; l = l + 40) // move angle starting point
	    for (int i = 0 ; i < 25 ; i++) //grow angle
		for (int n = 0 ; n < 100 ; n++) //grow width and height
		{
		    c.setColor (stripePurple);
		    c.drawArc (350 - n / 2, 200 - n / 2, n, n, l, i);
		    c.setColor (Color.black);
		    c.drawArc (500 - n / 2, 150 - n / 2, n, n, l, i);
		}
	//draw chip center
	c.setColor (stripePurple);
	c.fillOval (315, 165, 70, 70);
	c.setColor (Color.black);
	c.fillOval (465, 115, 70, 70);
	c.setColor (Color.white);
	c.fillOval (322, 172, 55, 55);
	c.fillOval (472, 122, 55, 55);
	//get user continue choice
	while (true)
	{
	    continueChoice = c.getChar ();
	    /*The purpose of this conditional statement is to either let the user continue or exit the program based on their input.
	    If they input something that isn't an option, it will give an error message.*/
	    if (continueChoice == 'n' || continueChoice == 'c' || continueChoice == 'i' || continueChoice == 'a' || continueChoice == 'e')
		break;
	    else
		JOptionPane.showMessageDialog (null, "Please enter only one of the options given.", "Error", JOptionPane.ERROR_MESSAGE); //error if they don't use the prompt words
	}
    }


    public void gamePlay ()
    {
	PrintWriter output;
	String inputStr;
	char gameChoice;
	Random rand = new Random ();
	int pickedNumber = rand.nextInt (8) + 1;
	int[] randInt = new int [3];
	int[] slotSymbol = new int [10];
	Color userBar = (new Color (212, 195, 229));
	background = (new Color (150, 190, 255)); //change background color to be used in title
	title ();
	//draw slot machine
	c.setColor (Color.black);
	c.fillRect (200, 185, 250, 200);
	//draw slot machine details
	c.setColor (Color.white);
	c.drawLine (220, 205, 430, 205);
	c.drawLine (220, 275, 430, 275);
	c.drawLine (220, 205, 220, 275);
	c.drawLine (430, 205, 430, 275);
	c.drawLine (290, 205, 290, 275);
	c.drawLine (360, 205, 360, 275);
	c.drawRect (220, 335, 90, 20);
	c.drawRect (340, 335, 90, 20);
	c.fillRect (225, 295, 60, 20);
	c.fillRect (295, 295, 60, 20);
	c.fillRect (365, 295, 60, 20);
	while (true)
	{
	    if (balance <= 0 || userName.equals ("e")) //skip game play when an accesed game is already at $0, or user has chosen to exit
		break;
	    //draw user info bar that will erase scores after each spin
	    for (int i = 0 ; i < 540 ; i++)
	    {
		c.setColor (userBar);
		c.drawLine (40 + i, 420, 40 + i, 480);
	    }
	    c.setColor (Color.black);
	    c.drawRect (40, 420, 540, 60);
	    c.setTextBackgroundColor (background);
	    c.setFont (mainFont);
	    c.drawString ("Your Money: $" + balance, 60, 450); //user info
	    c.drawString ("Wins: " + winCount, 300, 450);
	    c.drawString ("Losses: " + lossCount, 475, 450);
	    c.drawString ("Press s to spin, or e to exit.", 210, 80); //prompt
	    while (true)
	    {
		gameChoice = c.getChar (); //user input for game play choice and error trap

		if (gameChoice != 's' && gameChoice != 'e')
		{
		    JOptionPane.showMessageDialog (null, "Please enter either e or s.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
		    break;
		}
	    }
	    if (gameChoice == 'e') //exit if user chooses to exit
		break;
	    c.drawString ("Enter how much money would you like to bet:", 145, 105); //prompt
	    c.drawString ("$1, $2, or $5?", 270, 130);
	    while (true)
	    {
		c.setCursor (8, 40);
		c.println (" ");
		c.setCursor (8, 40);
		inputStr = c.readLine (); //user input for amount bet and error trap
		try
		{
		    moneyBet = Integer.parseInt (inputStr);
		    if (moneyBet != 1 && moneyBet != 2 && moneyBet != 5)
			JOptionPane.showMessageDialog (null, "Please enter either 1, 2, or 5", "ERROR", JOptionPane.ERROR_MESSAGE);
		    else
			break;
		}
		catch (NumberFormatException e)
		{
		    JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    //cover last spin
	    c.fillRect (221, 206, 69, 65);  //space 1
	    c.fillRect (291, 206, 69, 65);   //space 2
	    c.fillRect (361, 206, 69, 65);   //space 3
	    for (int j = 0 ; j < 3 ; j++) //choose three random integers
	    {
		randInt [j] = rand.nextInt (pickedNumber);
		//used to delay between symbols
		try
		{
		    Thread.sleep (500);
		}
		catch (Exception e)
		{
		}
		//draw slot symbol for each reel
		if (randInt [j] == 0)
		{
		    c.setFont (graphicsSevenFont); //symbol 1 "7"
		    c.setColor (Color.red);
		    c.drawString ("7", 230 + j * 70, 270);
		}
		else if (randInt [j] == 1)
		{
		    //draw bell top
		    c.setColor (Color.yellow);
		    c.fillOval (235 + j * 70, 215, 40, 40);
		    //draw bell middle
		    c.setColor (Color.orange);
		    c.fillOval (230 + j * 70, 230, 50, 30);
		    //draw bell bottom
		    c.setColor (Color.yellow);
		    c.fillOval (230 + j * 70, 240, 50, 20);
		    //draw bell ball
		    c.setColor (Color.orange);
		    c.fillOval (248 + j * 70, 250, 15, 15);
		}
		else if (randInt [j] == 2)
		{
		    //draw orange
		    c.setColor (Color.orange);
		    c.fillOval (230 + j * 70, 220, 50, 50);
		    //draw stem
		    c.setColor (Color.green);
		    c.fillOval (255 + j * 70, 225, 5, 5);

		}
		else if (randInt [j] == 3)
		{
		    //draw plum
		    c.setColor (Color.magenta);
		    c.fillOval (225 + j * 70, 220, 59, 50);
		    //draw stem
		    c.setColor (Color.green);
		    c.drawArc (250 + j * 70, 210, 30, 30, 270, 90);
		}
		else if (randInt [j] == 4)
		{
		    //draw watermelon
		    c.setColor (Color.green);
		    c.fillOval (230 + j * 70, 220, 50, 50);
		    c.fillOval (225 + j * 70, 220, 50, 50);
		    c.fillOval (235 + j * 70, 220, 50, 50);
		    c.setColor (Color.red);
		    c.drawOval (245 + j * 70, 220, 20, 50);
		}
		else if (randInt [j] == 5)
		{
		    //draw cherries
		    c.setColor (Color.green);
		    c.drawLine (250 + j * 70, 230, 260 + j * 70, 225);
		    c.drawLine (265 + j * 70, 240, 260 + j * 70, 225);
		    c.drawLine (260 + j * 70, 225, 256 + j * 70, 210);
		    c.setColor (Color.red);
		    c.fillOval (243 + j * 70, 230, 15, 15);
		    c.fillOval (233 + j * 70, 240, 15, 15);
		    c.fillOval (258 + j * 70, 240, 15, 15);
		}
		else if (randInt [j] == 6)
		{
		    c.setColor (Color.yellow);
		    c.fillOval (230 + j * 70, 220, 50, 40);
		    c.fillOval (225 + j * 70, 235, 10, 10);
		    c.fillOval (275 + j * 70, 235, 10, 10);
		}
		else if (randInt [j] == 7)
		{
		    c.setColor (Color.white);
		    c.setFont (barGraphicsFont);
		    c.drawString ("bar", 230 + j * 70, 250);
		}
	    }
	    if (randInt [0] == randInt [1] && randInt [1] == randInt [2]) //test for matching ints
	    {
		results = true;
		winCount = winCount + 1;
	    }
	    else
	    {
		results = false;
		lossCount = lossCount + 1;
	    }
	    balance = balanceCalc (results, moneyBet, balance); //calculate balance
	    if (balance <= 0) //end if out of funds
	    {
		break;
	    }
	}
    }


    //Method to save MeganISP11.
    public void display ()
    {
	PrintWriter output;
	PrintWriter outputScores;
	String fileName;
	File scores = new File ("highScores.slots");
	Color boxBlue = (new Color (150, 190, 255));
	background = (new Color (252, 142, 121)); //change color to be used in title
	title ();
	if (!userName.equals ("e"))
	{
	    //box graphics
	    c.drawRect (130, 90, 380, 150);
	    c.setColor (boxBlue);
	    c.fillRect (130, 300, 190, 60);
	    c.setColor (Color.white);
	    c.fillRect (320, 300, 190, 60);
	    c.setColor (Color.black);
	    c.setFont (mainFont);
	    if (balance == 0) // when balance is $0
		c.drawString ("Oh No! You ran out of money!", 200, 140);
	    else
		c.drawString ("Good game! You ended with $" + balance + ".", 180, 140);
	    c.drawString ("Game Name:", 150, 335);
	    if (continueChoice == 'n') //only display if this is a new game
	    {
		c.drawString ("Before you leave, give this round a name", 150, 165);
		c.drawString ("so you can come back later!", 195, 190);
		c.drawString ("Wins: " + winCount + "     Losses: " + lossCount, 235, 215);
		c.setTextBackgroundColor (Color.white);
		c.setCursor (17, 45);
		userName = c.readLine (); //get user name
		//cover end of enter line
		c.setColor (background);
		c.fillRect (511, 310, 150, 30);
	    }
	    else
	    {
		c.drawString ("This round is still saved as", 220, 165);
		c.drawString ("" + userName, 300, 190);
		c.drawString ("Wins: " + winCount + "     Losses: " + lossCount, 235, 215);
		c.drawString ("" + userName, 350, 335);
	    }
	    fileName = userName + ".slots";
	    try
	    {
		output = new PrintWriter (new FileWriter (fileName)); //save name and balance to file
		// write data to the file
		output.println (userName);
		output.println (balance);
		output.println (winCount);
		output.println (lossCount);
		// close the stream
		output.close ();
	    }
	    catch (IOException e)
	    {
		c.println ("Please save the file as something first.");
	    }
	    try
	    {
		//establish a stream called outputFile to the file myoutdata.txt
		outputScores = new PrintWriter (new BufferedWriter (new FileWriter ("highScores.txt", true)));
		// write data to the file
		outputScores.println (userName);
		outputScores.println (balance);
		outputScores.println (winCount);
		outputScores.println (lossCount);
		// close the stream
		outputScores.close ();
	    }
	    catch (IOException e)
	    {
		System.out.println (e);
	    }
	    balance = 100; //reset initial balance
	    winCount = 0;
	    lossCount = 0;
	    pauseProgram ();
	}
    }



    public void accessGame ()
    {
	BufferedReader input;
	String inputStr = null;
	Color boxRed = (new Color (252, 142, 121));
	String fileName;
	File file;
	title (); //clear screen and display title
	//box graphics
	c.drawRect (90, 60, 460, 150);
	c.setColor (boxRed);
	c.fillRect (130, 260, 190, 60);
	c.setTextBackgroundColor (background);
	c.setColor (Color.black);
	c.setFont (mainFont);
	c.drawString ("Enter the name of the round you would like to play.", 108, 90);
	c.drawString ("Only files that exist and were created", 155, 120);
	c.drawString ("with this program can be opened", 175, 150);
	c.drawString ("If you would like to exit, press 'e'", 173, 180);
	c.drawString ("Enter Name: ", 145, 295);
	while (true)
	{
	    c.setColor (Color.white);
	    c.fillRect (320, 260, 190, 60); //draw enter bar
	    c.setCursor (15, 45);
	    c.setTextBackgroundColour (Color.white);
	    userName = c.readLine ();
	    fileName = userName + ".slots";
	    //cover enter line
	    c.setColor (background);
	    c.fillRect (511, 280, 150, 20);
	    if (userName.equals ("e")) //leave if user chooses to exit
	    {
		break;
	    }
	    else if (fileName.substring (fileName.length () - 6, fileName.length ()).equals (".slots"))
	    {
		try
		{
		    file = new File (fileName);
		    if (file.exists ())
		    {
			input = new BufferedReader (new FileReader (fileName));
			//read from file
			userName = input.readLine ();
			balance = Integer.parseInt (input.readLine ());
			winCount = Integer.parseInt (input.readLine ());
			lossCount = Integer.parseInt (input.readLine ());
			input.close ();
			c.setColor (Color.black);
			c.drawString ("Your balance is $" + balance + "!", 230, 370);
			c.drawString ("Wins: " + winCount + "   Losses: " + lossCount, 230, 395);
			if (balance <= 0)
			{
			    c.drawString ("You have no money to play with! Instead, create a new game.", 75, 420);
			    pauseProgram ();
			}
			else
			{
			    c.drawString ("Get Ready to play!", 240, 420);
			    pauseProgram (); //press any key
			}
			break;
		    }
		    else if (!(file.exists ()))
		    {
			JOptionPane.showMessageDialog (null, "That user name does not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
		catch (IOException e)
		{
		    JOptionPane.showMessageDialog (null, "Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);

		}
	    }
	}
    }


    public void instructions ()
    {
	title ();
	c.setColour (Color.black);
	c.setFont (mainFont);
	c.drawString ("Instructions", 280, 100);
	c.drawString ("1.   To play, press the 'New Game' button in the main menu, or", 15, 155);
	c.drawString ("     'Continue Game'", 15, 180);
	c.drawString ("2.   Press s to spin, and enter your bet. ", 15, 230);
	c.drawString ("      If you win, you will earn 5 times your bet.", 15, 255);
	c.drawString ("3.   Play until you have $0, or press e to exit.", 15, 305);
	c.drawString ("4.   Give your game a name if you have not already.", 15, 355);
	pauseProgram ();
    }


    public void admin ()
    {
	BufferedReader input;
	PrintWriter output;
	File file;
	String inputStr = " ";
	String password;
	String fileName = " ";
	String continueChoice = " ";
	int newBalance = 0;
	int numberOfLines = 0;
	int inputInt;
	int inputInt2 = 0;
	int[] highScore = new int [10];
	String[] highScoreNames = new String [10];
	title ();
	c.setColour (Color.black);
	c.setTextBackgroundColor (background);
	c.setFont (mainFont);
	c.drawString ("Administration", 260, 110);
	c.drawString ("Enter 'e' at any time to exit.", 210, 400);
	while (true)
	{
	    c.drawString ("Please enter the admin password, or enter e to exit.", 108, 130); //user input for admin password, error trapped
	    c.setCursor (8, 37);
	    c.println ();
	    c.setCursor (8, 37);
	    password = c.readLine ();
	    if (!password.equals ("slotsFun") && !password.equals ("e")) //includes exit option
		JOptionPane.showMessageDialog (null, "The password is incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
	    else if (password.equals ("e"))
		break;
	    else
	    {
		while (true)
		{
		    c.drawString ("Would you like to access a specific user (u) or highscores (h)?", 70, 175);
		    c.setCursor (10, 37);
		    c.println ();
		    c.setCursor (10, 37);
		    continueChoice = c.readLine ();
		    if (continueChoice.equals ("u") || continueChoice.equals ("h"))
			break;
		    else
			JOptionPane.showMessageDialog (null, "Enter u or h!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		break;
	    }
	}
	if (continueChoice.equals ("u"))
	{
	    if (password.equals ("slotsFun")) //admin access only when password is right
	    {
		while (true)
		{
		    c.drawString ("Enter a game you would like to view and edit: ", 130, 215);
		    c.setCursor (12, 37);
		    c.println ();
		    c.setCursor (12, 37);
		    userName = c.readLine (); //user input for user name
		    fileName = userName + ".slots";
		    if (userName.equals ("e"))
			break; //exit
		    try
		    {
			file = new File (fileName);
			if (file.exists ()) //check if file exists
			{
			    input = new BufferedReader (new FileReader (fileName));
			    userName = input.readLine (); //read user name
			    balance = Integer.parseInt (input.readLine ()); //read balance
			    winCount = Integer.parseInt (input.readLine ());
			    lossCount = Integer.parseInt (input.readLine ());
			    c.drawString ("User Name: " + userName, 20, 270);
			    c.drawString ("Balance is $" + balance, 20, 295); //display balance
			    input.close ();
			    break;
			}
			else if (!(file.exists ()))
			{
			    new Message ("Error! File does not exist.", "Error!");
			}
		    }
		    catch (IOException e)
		    {
			new Message ("Error! File does not exist.", "Error!");
		    }
		}
	    }
	    try
	    {
		while (!userName.equals ("e") && !password.equals ("e"))  //exit if e has been entered
		{
		    c.drawString ("Enter new balance to be saved: ", 20, 315); //prompt
		    while (true)
		    {
			c.setCursor (17, 14);
			c.println ();
			c.setCursor (17, 14);
			inputStr = c.readLine (); //read balance
			try
			{
			    if (inputStr.equals ("e"))
			    {
				newBalance = balance; //if e is entered keep balance the same
			    }
			    else
			    {
				newBalance = Integer.parseInt (inputStr);
				if (newBalance < 0)
				    JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else
				    break;
			    }

			}
			catch (NumberFormatException e)
			{
			    new Message ("Positive integers only!", "Error!");
			}
		    }
		    try
		    {
			output = new PrintWriter (new FileWriter (fileName)); //write to file selected
			//write to file
			output.println (userName);
			output.println (newBalance);
			output.println (winCount);
			output.println (lossCount);
			//end file
			output.close ();
			break;
		    }
		    catch (NumberFormatException e)
		    {
			JOptionPane.showMessageDialog (null, "Please enter a positive integer only.", "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
	    }
	    catch (IOException e)
	    {
		c.println ("Please save the file as something first.");
	    }
	}
	else if (continueChoice.equals ("h"))
	{
	    try
	    {
		file = new File ("highScores.txt");
		if (file.exists ()) //check if file exists
		{
		    input = new BufferedReader (new FileReader ("highScores.txt")); //reset BufferedReader
		    while (true)
		    {
			inputStr = input.readLine (); //read user name
			if (inputStr == null)
			    break;
			inputInt = Integer.parseInt (input.readLine ()); //read balance
			if (inputInt > highScore [1]) //if balance is larger than last balance
			{
			    highScore [4] = highScore [3]; //move all balances one place down
			    highScore [3] = highScore [2];
			    highScore [2] = highScore [1];
			    highScore [1] = highScore [0];
			    highScore [0] = inputInt;
			    highScoreNames [4] = highScoreNames [3]; //move all names one place down
			    highScoreNames [3] = highScoreNames [2];
			    highScoreNames [2] = highScoreNames [1];
			    highScoreNames [1] = highScoreNames [0];
			    highScoreNames [0] = inputStr;
			}
			balance = inputInt;
			winCount = Integer.parseInt (input.readLine ()); //hold wins and losses
			lossCount = Integer.parseInt (input.readLine ());
		    }
		    for (int i = 0 ; i < 5 ; i++)
		    {
			if (i != 4 && highScore [i] < highScore [i + 1]) //switch any wrong orders
			{
			    inputInt = highScore [i]; //store lower number
			    highScore [i] = highScore [i + 1]; //replace lower number
			    highScore [i + 1] = inputInt; //replace higher number with stored number
			}
			c.drawString ("Highscores", 20, 245);
			c.drawString ("" + (i + 1) + ". " + highScoreNames [i] + highScore [i], 20, 270 + 25 * i); //print high scores
		    }
		}
		else
		{
		    new Message ("Error! File does not exist.", "Error!");
		}
	    }
	    catch (IOException e)
	    {
		new Message ("Error! Something went wrong!", "Error!");
	    }
	}
	pauseProgram ();
    }


    private int balanceCalc (boolean results, int moneyBet, int balance)
    {
	int returnBalance = 0;
	if (results == true)
	    returnBalance = balance + (5 * moneyBet);
	else if (results == false)
	    returnBalance = balance - moneyBet;
	return returnBalance;
    }


    public void goodBye ()
    {
	title (); //clear screen and display title
	c.setColour (Color.black);
	c.drawString ("Thank you for using the ", 135, 190);
	c.drawString ("Virtual Slot Machine", 165, 230);
	c.drawString ("Program by Megan Holmes", 125, 270);
	//used to delay closing
	try
	{
	    Thread.sleep (2000);
	}
	catch (Exception e)
	{
	}
	c.close ();
    }


    public static void main (String[] args)
    {
	MeganISP11 v = new MeganISP11 ();
	//v.splashScreen ();
	while (true)
	{
	    v.mainMenu ();
	    if (v.continueChoice == 'e')
	    {
		break;
	    }
	    else if (v.continueChoice == 'n')
	    {
		v.gamePlay ();
		v.display ();
	    }
	    else if (v.continueChoice == 'c')
	    {
		v.accessGame ();
		v.gamePlay ();
		v.display ();
	    }
	    else if (v.continueChoice == 'i')
	    {
		v.instructions ();
	    }
	    else if (v.continueChoice == 'a')
	    {
		v.admin ();
	    }
	}
	v.goodBye ();
    }
} // MeganISP11 class close


