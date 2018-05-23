import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class StartMenu
{
	/**
	 * Holds the GUI elements
	 */
    private JFrame frame;

    /**
	 * The text field for the problem name
	 */
    private JTextField namepathfield;

    /**
	 * The container of the frame
	 */
    private Container c;

    /**
	 * The text label to warn that the fields are not completed
	 */
    private JLabel warntxt;

    /**
	 * The text label to warn that the name is not in problem
	 */
    private JLabel notfoundtxt;
    
    /**
	 * The statistics from this set
	 */
    private Statistics stats;
    
    private String pathFileChooser;

    /**
     * The constructor, which makes visible the frame and adds the enter button and
     * the single text field for the pathname of the folder in which the program is located.
     * @param statistics
     * 			The statistics for this set (from QuickQuiz)
     */
    public StartMenu(Statistics statistics)
    {
        stats = statistics;
        
        JLabel nametxt = new JLabel(
            "Enter the location of the program file to begin (ex. /Users/JohnDoe/Desktop/QuickQuiz/)" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 180, 500, 20 );
        nametxt.setHorizontalAlignment( JLabel.LEFT );
        nametxt.setVerticalAlignment( JLabel.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 200, 400, 20 );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 100, 200, 50, 20 );
        pathname.addActionListener( new PathnameListener() );
        
        JButton filechooser = new JButton( "Choose File" );
        filechooser.setBounds( 500, 200, 100, 20 );
        filechooser.addActionListener( new FileListener() );

        JLabel text = new JLabel( "Welcome to Quick Quiz!" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 100 );

        frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        warntxt = new JLabel( "Please complete the required field!" );
        warntxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        warntxt.setBounds( 200, 500, 500, 20 );
        warntxt.setHorizontalAlignment( JLabel.LEFT );
        warntxt.setVerticalAlignment( JLabel.TOP );
        warntxt.setVisible( false );

        notfoundtxt = new JLabel( "File not found! Please check the fields" );
        notfoundtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        notfoundtxt.setBounds( 200, 500, 500, 20 );
        notfoundtxt.setHorizontalAlignment( JLabel.LEFT );
        notfoundtxt.setVerticalAlignment( JLabel.TOP );
        notfoundtxt.setVisible( false );

        namepathfield.setText( "/Users/JohnDoe/Desktop/QuickQuiz/" );
        c.add( text );
        c.add( pathname );
        c.add( warntxt );
        c.add( notfoundtxt );
        c.add(filechooser);

        c.add( namepathfield );
        c.add( nametxt );

        frame.setResizable( false );
        frame.setVisible( true );
    }

    /**
     * Handles when the enter button is clicked; when clicked, checks if all conditions are 
     * satisfied (if all fields are entered and all pathnames exist) and displays the appropriate
     * warnings if not. Otherwise, the frame closes itself and opens MainMenu.
     *
     * @author Krishnakumar Bhattaram
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class PathnameListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( namepathfield.getText().trim().isEmpty() )
            {
                warntxt.setVisible( true );
                notfoundtxt.setVisible( false );
                return;
            }
            else
            {
                String pathproblems = namepathfield.getText() + "ProblemFile/problems.txt";
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

                MainMenu main = new MainMenu( new ProblemDatabase( pathproblems ), stats );
                frame.dispose();

            }
        }
    }
    
    private class FileListener implements ActionListener
    {
    		public void actionPerformed( ActionEvent e)
    		{
    			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    			int returnValue = jfc.showOpenDialog(null);

    			if (returnValue == JFileChooser.APPROVE_OPTION) {
    				File selectedFile = jfc.getSelectedFile();
    				pathFileChooser = selectedFile.getAbsolutePath();
    				namepathfield.setText(pathFileChooser);
    			}
    		}
    }
}