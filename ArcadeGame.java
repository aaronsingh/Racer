import javax.swing.*;

public class ArcadeGame                 //making a class called ArcadeGame
{
public static void main(String args[])  // main operator
	{
	int SCREEN_HEIGHT = 600;            // Declare the (integer) vairables for the hieght of the screen 
	int SCREEN_WIDTH = 800;             // Declare the (integer) vairables for the width of the screen 
		
    JFrame window = new JFrame(); 
    Racer r = new Racer();              //making an instance of the new racer class
    window.setTitle("Racer");
    window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    window.setContentPane(r.getPanel()); // set the componants of the Jframe
    window.setVisible(true);

    r.start();                           // Game will start

    while(r.isPlaying())                 // the game will be updating throughout
      r.update();
	
	
	}
}