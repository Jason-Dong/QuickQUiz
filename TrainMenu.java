import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TrainMenu
{
    private JFrame frame;
   
    private ProblemDatabase problem;
    
    public TrainMenu(ProblemDatabase problem)
    {
        this.problem = problem;
        
        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );
        
        JButton choice1 = new JButton( "A" );
        choice1.setBounds( 150, 500, 100, 50 );
        
        JButton choice2 = new JButton( "B" );
        choice2.setBounds(250, 500, 100, 50 );
        
        JButton choice3 = new JButton( "C" );
        choice3.setBounds( 350, 500, 100, 50 );
        
        JButton choice4 = new JButton( "D" );
        choice4.setBounds( 450, 500, 100, 50 );
        
        JButton choice5 = new JButton( "E" );
        choice5.setBounds( 550, 500, 100, 50 );
        
        frame = new JFrame( "Training Menu" );
        frame.setDefaultCloseOperation( 0 );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );
        
        c.add( back );
        c.add( choice1 );
        c.add( choice2 );
        c.add( choice3 );
        c.add( choice4 );
        c.add( choice5 );
        
        frame.setResizable( false );
        frame.setVisible( true );
    }
    
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            MainMenu mainMenu = new MainMenu( problem );
            frame.dispose();
        }
    }
}
