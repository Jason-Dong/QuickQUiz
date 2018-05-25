import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


/**
 * This class is the Start Menu, which asks for the location of the directory
 * which contains the program files and the image and problem files to set the
 * space in which the code functions and accesses problems.
 *
 * @author Krishnkumar Bhattaram
 * @version May 23, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
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
     * The constructor, which makes visible the frame and adds the enter button
     * and the single text field for the pathname of the folder in which the
     * program is located.
     * 
     * @param statistics
     *            The statistics for this set (from QuickQuiz)
     */
    public StartMenu( Statistics statistics, JFrame frame )
    {
        this.frame = frame;
        c = frame.getContentPane();
        stats = statistics;

        JLabel nametxt = new JLabel(
            "Enter the directory of the program file to begin (ex. /Users/JohnDoe/Desktop/QuickQuiz)" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 180, 500, 20 );
        nametxt.setHorizontalAlignment( JLabel.LEFT );
        nametxt.setVerticalAlignment( JLabel.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 200, 400, 20 );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 600, 200, 100, 20 );
        pathname.addActionListener( new PathnameListener() );

        JButton filechooser = new JButton( "Choose Directory" );
        filechooser.setBounds( 75, 200, 125, 20 );
        filechooser.addActionListener( new FileListener() );

        JLabel text = new JLabel( "Welcome to Quick Quiz!" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 100 );
        
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

        namepathfield.setText( "/Users/JohnDoe/Desktop/QuickQuiz" );
        c.add( text );
        c.add( pathname );
        c.add( warntxt );
        c.add( notfoundtxt );
        c.add( filechooser );

        c.add( namepathfield );
        c.add( nametxt );

    }


    /**
     * Handles when the enter button is clicked; when clicked, checks if all
     * conditions are satisfied (if all fields are entered and all pathnames
     * exist) and displays the appropriate warnings if not. Otherwise, the frame
     * closes itself and opens MainMenu.
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
                String pathproblems = namepathfield.getText() + "/ProblemFile/problems.txt";
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
                
                frame.removeAll();
                MainMenu main = new MainMenu( new ProblemDatabase( pathproblems ), stats, frame );

            }
        }
    }


    /**
     * Opens the system's file explorer to allow selection of the directory
     * which contains the image files and problem set.
     *
     * @author Krishnakumar Bhattaram
     * @version May 23, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: Mykong.com
     */
    private class FileListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JFileChooser filechooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory() );
            filechooser.setDialogTitle( "Choose Directory of Program Files" );
            filechooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
            int ret = filechooser.showOpenDialog( null );

            if ( ret == JFileChooser.APPROVE_OPTION )
            {
                File file = filechooser.getSelectedFile();
                pathFileChooser = file.getAbsolutePath();
                namepathfield.setText( pathFileChooser );
            }
        }
    }
}