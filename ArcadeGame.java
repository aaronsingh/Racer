import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ArcadeGame implements ActionListener              //making a class called ArcadeGame and it will be processing an action event
{

	//JPanel's used as container's for all the components to show on screen
	JFrame window;
	JPanel buttonPanel;
	JPanel RPanel;
	JPanel scorePanel;
	JLabel scoreL;
	JPanel mainPanel;
	JButton startB, stopB;
	// Declare the (integer) vairables for the hieght and width of the screen 
	int ScreenHeight = 800; 
	int ScreenWidth = 800;	
	int Score = 0;
	
	Racer r;
	FlowLayout f; //Declaring the Flowlayout to F
	
public ArcadeGame()
{
	window = new JFrame();
	mainPanel = new JPanel();
	buttonPanel = new JPanel();  //The panels will help me group all the componants together
	RPanel = new JPanel();
	scorePanel = new JPanel();
	scoreL = new JLabel ("Score:");
	startB = new JButton("Start");  // assigning the startB variable name to Start 
	stopB = new JButton("Stop");   // assigning the StopB variable name to Stop

	r = new Racer();
	f = new FlowLayout();
	
	scorePanel.add(scoreL);
	buttonPanel.add(startB);
	buttonPanel.add(stopB);
	
	window.setTitle("Racer");    
	window.setContentPane(mainPanel);
	window.setSize(ScreenWidth, ScreenHeight); // Sets the componants of the Jframe
	RPanel.add(r.getPanel());
	
	scorePanel.setLayout(f);	
	RPanel.setLayout(f);
	buttonPanel.setLayout(f);
	
	mainPanel.add(scorePanel);
	mainPanel.add(RPanel);
	mainPanel.add(buttonPanel);

	
	// The buttons are registered to the addActionListener() method so we can click the buttons
	startB.addActionListener(this); 
	stopB.addActionListener(this);
	
	//Setting all the Panels to true so I can see them in the JPanel
	window.setVisible(true);
	buttonPanel.setVisible(true);
	RPanel.setVisible(true);
	scorePanel.setVisible(true);
}
	public void play()
	{
		r.start();  // The game will start 
		
	//It will keep on updating the score on the screen
		while (true){
			r.arena.pause();
				while (r.isPlaying()){
					r.update();
						scoreL.setText("Score:" + r.getScore());
					 }
			}
	}	

public void actionPerformed(ActionEvent e) //To make the buttons work
	{
		if(e.getSource()==startB)
			r.start();
		
		if(e.getSource()==stopB)
			r.stop();
	}
	
public static void main(String args[])  //main operator
	{
		ArcadeGame a = new ArcadeGame();  
			a.play(); 
	}
} 