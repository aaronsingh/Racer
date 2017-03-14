import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ArcadeGame implements ActionListener              //making a class called ArcadeGame and it will be processing an action event
{
	JFrame window;
	JPanel BPanel;
	JPanel RPanel;
	JPanel SPanel;
	JLabel scoreL;
	JPanel mainPanel;
	JButton startB, stopB;
	int ScreenHeight = 800; // Declare the (integer) vairables for the hieght of the screen 
	int ScreenWidth = 800;	// Declare the (integer) vairables for the width of the screen 
	int Score = 0;
	Racer r;
	FlowLayout f;
	
public ArcadeGame()
{
	window = new JFrame();
	mainPanel = new JPanel();
	BPanel = new JPanel();  //The panels will help me group all the componants together
	RPanel = new JPanel();
	SPanel = new JPanel();
	scoreL = new JLabel ("Score:");
	startB = new JButton("Start");  // assigning the startB variable name to Start 
	stopB = new JButton("Stop");   // assigning the StopB variable name to Stop

	r = new Racer();
	f = new FlowLayout();
	
	SPanel.add(scoreL);
	BPanel.add(startB);
	BPanel.add(stopB);
	window.setTitle("Racer");    
	window.setContentPane(mainPanel);
	window.setSize(ScreenWidth, ScreenHeight); // Sets the componants of the Jframe
	RPanel.add(r.getPanel());
	SPanel.setLayout(f);	
	RPanel.setLayout(f);
	BPanel.setLayout(f);
	mainPanel.add(RPanel);
	mainPanel.add(BPanel);
	mainPanel.add(SPanel);
	
	// The buttons are registered to the addActionListener() method so we can click the buttons
	startB.addActionListener(this); 
	stopB.addActionListener(this);
	window.setVisible(true);
	BPanel.setVisible(true);
	RPanel.setVisible(true);
	SPanel.setVisible(true);
}
	public void play()
	{
	r.start();
	while (true){
		r.arena.pause();
			while (r.isPlaying()){
				r.update();
				scoreL.setText("Score:" + r.getScore());
								 }
				}
	}	

public void actionPerformed(ActionEvent e)
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