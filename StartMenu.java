import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;


public class StartMenu
{
    private JFrame frame;

    private JTextField namepathfield;

    private Container c;

    private JLabel warntxt;
    
    private JLabel notfoundtxt;


    public StartMenu(  )
    {
        
        JLabel nametxt = new JLabel( "Enter the location of the program file to begin (ex. /Users/JohnDoe/Desktop/QuickQuiz/)" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 180, 500, 20 );
        nametxt.setHorizontalAlignment( nametxt.LEFT );
        nametxt.setVerticalAlignment( nametxt.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 200, 400, 20 );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 100, 200, 50, 20 );
        pathname.addActionListener( new PathnameListener() );

        JLabel text = new JLabel( "Welcome!" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( text.CENTER );
        text.setBounds( 100, 30, 600, 100 );

        frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation( 0 );
        c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        warntxt = new JLabel( "Please complete all required fields!" );
        warntxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        warntxt.setBounds( 200, 500, 500, 20 );
        warntxt.setHorizontalAlignment( warntxt.LEFT );
        warntxt.setVerticalAlignment( warntxt.TOP );
        warntxt.setVisible( false );

        notfoundtxt = new JLabel(
            "File not found! Please check the fields" );
        notfoundtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        notfoundtxt.setBounds( 200, 500, 500, 20 );
        notfoundtxt.setHorizontalAlignment( notfoundtxt.LEFT );
        notfoundtxt.setVerticalAlignment( notfoundtxt.TOP );
        notfoundtxt.setVisible( false );

        c.add( text );
        c.add( pathname );
        c.add( warntxt );
        c.add( notfoundtxt);

        c.add( namepathfield );
        c.add( nametxt );

        frame.setResizable( false );
        frame.setVisible( true );
    }



    private class PathnameListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (namepathfield.getText().trim().isEmpty())
            {
                warntxt.setVisible( true );
                notfoundtxt.setVisible( false );
                return;
            }
            else
            {
            		String pathproblems = namepathfield.getText() + "src/ProblemFile/problems.txt";
            		try
                {
            			Scanner readIn = new Scanner( new File( pathproblems ) );
                }
                catch ( FileNotFoundException exc )
                {
                    warntxt.setVisible( false );
                    notfoundtxt.setVisible( true );
                    return;
                }
            		
            		MainMenu main = new MainMenu(new ProblemDatabase(namepathfield.getText()));
            		frame.dispose();
            		
            }
        }
    }
}