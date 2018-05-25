import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 * Allows the user to add problems, checking each field to ensure that all
 * fields are completed and the file pathnames are valid. It also ensures that
 * no two problems are added with the same name.
 *
 * @author Krishnakumar Bhattaram
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class AddMenu
{
    /**
     * Holds the GUI elements
     */
    private JFrame frame;

    /**
     * The problem database for this set
     */
    private ProblemDatabase problem;

    /**
     * The text field for the problem pathname
     */
    private JTextField problempathfield;

    /**
     * The text field for the solution pathname
     */
    private JTextField solutionpathfield;

    /**
     * The text field for the problem name
     */
    private JTextField namepathfield;

    /**
     * Type of problem to add chosen by the buttons
     */
    private int type;

    /**
     * The button to select problem type as kinematics
     */
    private JButton kinematics;

    /**
     * The button to select problem type as newton's laws
     */
    private JButton newton;

    /**
     * The button to select problem type as energy
     */
    private JButton energy;

    /**
     * The button to select problem type as rotation
     */
    private JButton rotation;

    /**
     * The button to select problem type as gravitation
     */
    private JButton gravitation;

    /**
     * The button to select problem type as fluids
     */
    private JButton fluids;

    /**
     * The button to select problem solution as 'a'
     */
    private JButton ap;

    /**
     * The button to select problem solution as 'b'
     */
    private JButton bp;

    /**
     * The button to select problem solution as 'c'
     */
    private JButton cp;

    /**
     * The button to select problem solution as 'd'
     */
    private JButton dp;

    /**
     * The button to select problem solution as 'e'
     */
    private JButton ep;

    /**
     * The answer as chosen by the buttons
     */
    private char ans;

    /**
     * The container of the frame
     */
    private Container c;

    /**
     * The text label to warn that the fields are not completed
     */
    private JLabel warntxt;

    /**
     * The text label to indicate that a new problem was added
     */
    private JLabel newtxt;

    /**
     * The text label to warn that the problem name is already used
     */
    private JLabel existtxt;

    /**
     * The text label to warn that the problem pathname doesn't exist
     */
    private JLabel probnotfoundtxt;

    /**
     * The text label to warn that the solution pathname doesn't exist
     */
    private JLabel solnotfoundtxt;

    /**
     * The statistics from the menu
     */
    private Statistics stats;


    /**
     * The constructor, which makes visible the frame and adds the buttons and
     * text fields
     * 
     * @param problem
     *            The problem database for this set
     * @param statistics
     *            The statistics for this set
     */
    public AddMenu( ProblemDatabase problem, Statistics statistics )
    {
        stats = statistics;
        ans = 'h';
        type = -1;
        this.problem = problem;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel problemtxt = new JLabel( "Problem Image Pathname" );
        problemtxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        problemtxt.setBounds( 200, 180, 500, 20 );
        problemtxt.setHorizontalAlignment( problemtxt.LEFT );
        problemtxt.setVerticalAlignment( problemtxt.TOP );
        problempathfield = new JTextField();
        problempathfield.setBounds( 200, 200, 400, 20 );

        JButton chooseproblem = new JButton( "Choose File" );
        chooseproblem.setBounds( 600, 200, 100, 20 );
        chooseproblem.addActionListener( new ProblemFileListener() );

        JLabel solutiontxt = new JLabel( "Solution Image Pathname" );
        solutiontxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        solutiontxt.setBounds( 200, 220, 500, 20 );
        solutiontxt.setHorizontalAlignment( solutiontxt.LEFT );
        solutiontxt.setVerticalAlignment( solutiontxt.TOP );
        solutionpathfield = new JTextField();
        solutionpathfield.setBounds( 200, 240, 400, 20 );

        JButton choosesolution = new JButton( "Choose File" );
        choosesolution.setBounds( 600, 240, 100, 20 );
        choosesolution.addActionListener( new SolutionFileListener() );

        JLabel nametxt = new JLabel( "Problem Name" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 260, 500, 20 );
        nametxt.setHorizontalAlignment( nametxt.LEFT );
        nametxt.setVerticalAlignment( nametxt.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 280, 400, 20 );

        JLabel typetxt = new JLabel( "Choose Problem Type" );
        typetxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        typetxt.setBounds( 200, 300, 500, 20 );
        typetxt.setHorizontalAlignment( typetxt.LEFT );
        typetxt.setVerticalAlignment( typetxt.TOP );

        kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 100, 320, 100, 20 );
        kinematics.addActionListener( new typeListener() );

        newton = new JButton( "Newton's Laws" );
        newton.setBounds( 200, 320, 100, 20 );
        newton.addActionListener( new typeListener() );

        energy = new JButton( "Energy" );
        energy.setBounds( 300, 320, 100, 20 );
        energy.addActionListener( new typeListener() );

        rotation = new JButton( "Rotation" );
        rotation.setBounds( 400, 320, 100, 20 );
        rotation.addActionListener( new typeListener() );

        gravitation = new JButton( "Gravitation" );
        gravitation.setBounds( 500, 320, 100, 20 );
        gravitation.addActionListener( new typeListener() );

        fluids = new JButton( "Fluids" );
        fluids.setBounds( 600, 320, 100, 20 );
        fluids.addActionListener( new typeListener() );

        JLabel answertxt = new JLabel( "Choose Answer:" );
        answertxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        answertxt.setBounds( 200, 345, 500, 20 );
        answertxt.setHorizontalAlignment( typetxt.LEFT );
        answertxt.setVerticalAlignment( typetxt.TOP );

        ap = new JButton( "A" );
        ap.setBounds( 200, 365, 80, 20 );
        ap.addActionListener( new answerListener() );

        bp = new JButton( "B" );
        bp.setBounds( 280, 365, 80, 20 );
        bp.addActionListener( new answerListener() );

        cp = new JButton( "C" );
        cp.setBounds( 360, 365, 80, 20 );
        cp.addActionListener( new answerListener() );

        dp = new JButton( "D" );
        dp.setBounds( 440, 365, 80, 20 );
        dp.addActionListener( new answerListener() );

        ep = new JButton( "E" );
        ep.setBounds( 520, 365, 80, 20 );
        ep.addActionListener( new answerListener() );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 300, 400, 200, 60 );
        pathname.addActionListener( new PathnameListener() );

        JLabel text = new JLabel( "Add Problems" );
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

        newtxt = new JLabel( "Success! Enter a new problem or return to main menu." );
        newtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        newtxt.setBounds( 200, 500, 500, 20 );
        newtxt.setHorizontalAlignment( warntxt.LEFT );
        newtxt.setVerticalAlignment( warntxt.TOP );
        newtxt.setVisible( false );

        existtxt = new JLabel( "Another problem already has this name!" );
        existtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        existtxt.setBounds( 200, 500, 500, 20 );
        existtxt.setHorizontalAlignment( existtxt.LEFT );
        existtxt.setVerticalAlignment( existtxt.TOP );
        existtxt.setVisible( false );

        probnotfoundtxt = new JLabel( "Problem file not found! Please check the fields" );
        probnotfoundtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        probnotfoundtxt.setBounds( 200, 500, 500, 20 );
        probnotfoundtxt.setHorizontalAlignment( JLabel.LEFT );
        probnotfoundtxt.setVerticalAlignment( JLabel.TOP );
        probnotfoundtxt.setVisible( false );

        solnotfoundtxt = new JLabel( "Solution file not found! Please check the fields" );
        solnotfoundtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        solnotfoundtxt.setBounds( 200, 500, 500, 20 );
        solnotfoundtxt.setHorizontalAlignment( JLabel.LEFT );
        solnotfoundtxt.setVerticalAlignment( JLabel.TOP );
        solnotfoundtxt.setVisible( false );

        c.add( back );
        c.add( text );
        c.add( pathname );
        c.add( warntxt );
        c.add( newtxt );
        c.add( solnotfoundtxt );
        c.add( existtxt );
        c.add( probnotfoundtxt );

        c.add( problempathfield );
        c.add( problemtxt );
        c.add( chooseproblem );
        c.add( solutionpathfield );
        c.add( solutiontxt );
        c.add( choosesolution );
        c.add( namepathfield );
        c.add( nametxt );

        c.add( typetxt );
        c.add( kinematics );
        c.add( newton );
        c.add( energy );
        c.add( rotation );
        c.add( gravitation );
        c.add( fluids );

        c.add( answertxt );
        c.add( ap );
        c.add( bp );
        c.add( cp );
        c.add( dp );
        c.add( ep );

        frame.setResizable( false );
        frame.setVisible( true );
    }


    /**
     * Handles when the back button is clicked; when clicked, returns to
     * MainMenu by closing all of TypeMenu and creating a MainMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            MainMenu mainMenu = new MainMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the enter button is clicked; when clicked, checks if all
     * conditions are satisfied (if all fields are entered and all pathnames
     * exist) and displays the appropriate warnings/successes
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
            if ( problempathfield.getText() == "" || solutionpathfield.getText() == ""
                || namepathfield.getText() == "" || ans == 'h' || type == -1 )
            {
                newtxt.setVisible( false );
                warntxt.setVisible( true );
                existtxt.setVisible( false );
                probnotfoundtxt.setVisible( false );
                solnotfoundtxt.setVisible( false );
                return;
            }

            String pathproblems = problempathfield.getText();
            String solutionpath = solutionpathfield.getText();
            try
            {
                Scanner readIn = new Scanner( new File( pathproblems ) );
            }
            catch ( FileNotFoundException exc )
            {
                newtxt.setVisible( false );
                warntxt.setVisible( false );
                existtxt.setVisible( false );
                probnotfoundtxt.setVisible( true );
                solnotfoundtxt.setVisible( false );
                return;
            }

            try
            {
                Scanner readIn = new Scanner( new File( solutionpath ) );
            }
            catch ( FileNotFoundException exc )
            {
                newtxt.setVisible( false );
                warntxt.setVisible( false );
                existtxt.setVisible( false );
                probnotfoundtxt.setVisible( false );
                solnotfoundtxt.setVisible( true );
                return;
            }

            if ( !problem.addProblem( new Problem( problempathfield
                .getText(), solutionpathfield.getText(), namepathfield.getText(), type, ans ) ) )
            {
                newtxt.setVisible( false );
                warntxt.setVisible( false );
                existtxt.setVisible( true );
                probnotfoundtxt.setVisible( false );
                solnotfoundtxt.setVisible( false );
            }
            else
            {
                problempathfield.setText( "" );
                solutionpathfield.setText( "" );
                namepathfield.setText( "" );
                kinematics.setEnabled( true );
                newton.setEnabled( true );
                energy.setEnabled( true );
                rotation.setEnabled( true );
                gravitation.setEnabled( true );
                fluids.setEnabled( true );
                ap.setEnabled( true );
                bp.setEnabled( true );
                cp.setEnabled( true );
                dp.setEnabled( true );
                ep.setEnabled( true );
                ans = 'h';
                type = -1;
                warntxt.setVisible( false );
                existtxt.setVisible( false );
                newtxt.setVisible( true );
                probnotfoundtxt.setVisible( false );
                solnotfoundtxt.setVisible( false );
            }
        }
    }


    /**
     * Handles when one of the type buttons (ex. kinematics, energy, etc.) are
     * clicked; when clicked, changes the type field to match the topic chosen
     * and disables the chosen type button while enabling all other type
     * buttons.
     *
     * @author Krishnakumar Bhattaram
     * @version May 24, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class typeListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JButton clicked = (JButton)e.getSource();
            String name = clicked.getText();
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );

            if ( name == null )
            {
                warntxt.setVisible( true );
                newtxt.setVisible( false );
                System.out.println( "Fatal Error!" );
                return;
            }

            if ( name.equalsIgnoreCase( "Kinematics" ) )
            {
                kinematics.setEnabled( false );
                type = 0;
            }
            else if ( name.equalsIgnoreCase( "Newton's Laws" ) )
            {
                newton.setEnabled( false );
                type = 1;
            }
            else if ( name.equalsIgnoreCase( "Energy" ) )
            {
                energy.setEnabled( false );
                type = 2;
            }
            else if ( name.equalsIgnoreCase( "Rotation" ) )
            {
                rotation.setEnabled( false );
                type = 3;
            }
            else if ( name.equalsIgnoreCase( "Gravitation" ) )
            {
                gravitation.setEnabled( false );
                type = 4;
            }
            else if ( name.equalsIgnoreCase( "Fluids" ) )
            {
                fluids.setEnabled( false );
                type = 5;
            }
        }
    }


    /**
     * Handles when one of the answer buttons (ex. 'A', 'B', etc.) are clicked;
     * when clicked, changes the answer field to match the topic chosen and
     * disables the chosen answer button while enabling all other answer
     * buttons.
     *
     * @author Krishnakumar Bhattaram
     * @version May 24, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class answerListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JButton clicked = (JButton)e.getSource();
            String name = clicked.getText();
            ap.setEnabled( true );
            bp.setEnabled( true );
            cp.setEnabled( true );
            dp.setEnabled( true );
            ep.setEnabled( true );

            if ( name == null )
            {
                warntxt.setVisible( true );
                newtxt.setVisible( false );
                System.out.println( "Fatal Error!" );
                return;
            }

            if ( name.equalsIgnoreCase( "A" ) )
            {
                ap.setEnabled( false );
                ans = 'A';
            }
            else if ( name.equalsIgnoreCase( "B" ) )
            {
                bp.setEnabled( false );
                ans = 'B';
            }
            else if ( name.equalsIgnoreCase( "C" ) )
            {
                cp.setEnabled( false );
                ans = 'C';
            }
            else if ( name.equalsIgnoreCase( "D" ) )
            {
                dp.setEnabled( false );
                ans = 'D';
            }
            else if ( name.equalsIgnoreCase( "E" ) )
            {
                ep.setEnabled( false );
                ans = 'E';
            }
        }
    }


    /**
     * Opens the system's file explorer to allow selection of the directory
     * which contains the image files and problem set. Only allows selection of
     * PNG files.
     *
     * @author Krishnakumar Bhattaram
     * @version May 23, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources:
     *         https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
     */
    private class ProblemFileListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JFileChooser filechooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory() );
            filechooser.setDialogTitle( "Choose Problem File" );
            filechooser.setAcceptAllFileFilterUsed( false );
            FileNameExtensionFilter types = new FileNameExtensionFilter( "PNG images", "png" );
            filechooser.addChoosableFileFilter( types );
            int ret = filechooser.showOpenDialog( null );

            if ( ret == JFileChooser.APPROVE_OPTION )
            {
                File file = filechooser.getSelectedFile();
                problempathfield.setText( file.getAbsolutePath() );
            }
        }
    }


    /**
     * Opens the system's file explorer to allow selection of the directory
     * which contains the image files and problem set. Only allows selection of
     * PNG files.
     *
     * @author Krishnakumar Bhattaram
     * @version May 23, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources:
     *         https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
     */
    private class SolutionFileListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JFileChooser filechooser = new JFileChooser(
                FileSystemView.getFileSystemView().getHomeDirectory() );
            filechooser.setDialogTitle( "Choose Solution File" );
            filechooser.setAcceptAllFileFilterUsed( false );
            FileNameExtensionFilter types = new FileNameExtensionFilter( "PNG images", "png" );
            filechooser.addChoosableFileFilter( types );
            int ret = filechooser.showOpenDialog( null );

            if ( ret == JFileChooser.APPROVE_OPTION )
            {
                File file = filechooser.getSelectedFile();
                solutionpathfield.setText( file.getAbsolutePath() );
            }
        }
    }
}