import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * The StatsMenu class is in charge of displaying the different statistics given
 * by the Statistics class in an organized manner. This class can be called from
 * either TrainMenu or QQMenu, and has a back button to return to the screen
 * this class was called from.
 *
 * @author Jason Dong
 * @version May 23, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class StatsMenu // problem encountered: percent dividing by 0: add
                       // conditional statement in Statistics
{
    /**
     * This is the statstics field for holding the Statistics variable passed in
     * as a parameter in the constructor
     */
    private Statistics stats;

    /**
     * This is the ProblemDatabase field for holding the ProblemDatabase
     * instance taken in as a parameter in the constructor.
     */
    private ProblemDatabase problem;

    /**
     * This is the overall frame for the StatsMenu window
     */
    private JFrame frame;

    /**
     * This is the label which will show the average time for the kinematics
     * problems
     */
    private JLabel kinematics;

    /**
     * This is the label which will show the average time for the newton's law
     * problems
     */
    private JLabel newton;

    /**
     * This is the label which will show the average time for all the energy
     * problems
     */
    private JLabel energy;

    /**
     * This is the label which will show the average time spent for all the
     * rotation problems
     */
    private JLabel rotation;

    /**
     * This is the label which shows the average time spent for all the
     * gravitation problems
     */
    private JLabel gravitation;

    /**
     * This is the label which shows the average time spent for all of the fluid
     * problems
     */
    private JLabel fluids;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the kinematics problems
     */
    private JLabel kinematicsRight;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the Newton's laws problems
     */
    private JLabel newtonRight;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the energy problems
     */
    private JLabel energyRight;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the rotation problems
     */
    private JLabel rotationRight;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the gravitation problems
     */
    private JLabel gravitationRight;

    /**
     * This is the label which shows the average number of problems the user got
     * right for the fluis problems
     */
    private JLabel fluidsRight;

    /**
     * This integer array shows the amount of minutes spent for each of the
     * categories of problems
     */
    private int minutes[];

    /**
     * This string simply holds the colon symbol so is easier to refer to later
     * on
     */
    private String colon;

    /**
     * This integer array shows the amount of seconds remaining after deducting
     * the correct number of minutes from it
     */
    private int remainingSeconds[];


    /**
     * This constructs a StatsMenu. This means creating the two text labels, the
     * average time per problem and average number right, as well as the
     * different displays for each of the categories for both of these
     * categories
     * 
     * @param prob
     *            is the problem database which although is not used in this
     *            class, is necessary to transfer around when called
     * @param statistics
     *            is class which contains all the information which is displayed
     *            in StatsMenu
     */
    public StatsMenu( ProblemDatabase prob, Statistics statistics )
    {
        stats = statistics;
        problem = prob;
        minutes = new int[6];
        remainingSeconds = new int[6];
        colon = ":";

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel text = new JLabel( "Statistics Menu" );
        text.setFont( new Font( "font", Font.PLAIN, 48 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 75 );

        JLabel avgTimePerProblem = new JLabel(
            "Average Time Per Problem in Seconds" );
        avgTimePerProblem.setFont( new Font( "font", Font.PLAIN, 30 ) );
        avgTimePerProblem.setHorizontalAlignment( JLabel.CENTER );
        avgTimePerProblem.setBounds( 100, 105, 600, 75 );

        JLabel avgNumRight = new JLabel(
            "Average Number of Problems Right" );
        avgNumRight.setFont( new Font( "font", Font.PLAIN, 30 ) );
        avgNumRight.setHorizontalAlignment( JLabel.CENTER );
        avgNumRight.setBounds( 100, 250, 600, 75 );

        for ( int i = 0; i < 6; i++ )
        {
            if ( stats.getTime( i ) > 60 )
            {
                minutes[i] += ( stats.getTime( i ) ) / 60;
                remainingSeconds[i] = stats.getTime( i ) - minutes[i] * 60;
            }
        }
        kinematics = new JLabel( "Kinematics: " + minutes[0] + colon
            + Math.floor( remainingSeconds[0] * 100 ) / 100 );
        kinematics.setBounds( 150, 200, 100, 20 );

        newton = new JLabel( "Newton: " + minutes[1] + colon
            + Math.floor( remainingSeconds[1] * 100 ) / 100 );
        newton.setBounds( 350, 200, 100, 20 );

        energy = new JLabel( "Energy: " + minutes[2] + colon
            + Math.floor( remainingSeconds[2] * 100 ) / 100 );
        energy.setBounds( 550, 200, 100, 20 );

        rotation = new JLabel( "Rotation: " + minutes[3] + colon
            + Math.floor( remainingSeconds[3] * 100 ) / 100 );
        rotation.setBounds( 150, 230, 100, 20 );

        gravitation = new JLabel( "Gravitation: " + minutes[4] + colon
            + Math.floor( remainingSeconds[4] * 100 ) / 100 );
        gravitation.setBounds( 350, 230, 100, 20 );

        fluids = new JLabel( "Fluids: " + minutes[5] + colon
            + Math.floor( remainingSeconds[5] * 100 ) / 100 );
        fluids.setBounds( 550, 230, 100, 20 );

        kinematicsRight = new JLabel( "Kinematics: "
            + Math.floor( stats.getPercent( 0 ) * 100 ) / 100 );
        kinematicsRight.setBounds( 150, 350, 100, 20 );

        newtonRight = new JLabel(
            "Newton: " + Math.floor( stats.getPercent( 1 ) * 100 ) / 100 );
        newtonRight.setBounds( 350, 350, 100, 20 );

        energyRight = new JLabel(
            "Energy: " + Math.floor( stats.getPercent( 2 ) * 100 ) / 100 );
        energyRight.setBounds( 550, 350, 100, 20 );

        rotationRight = new JLabel( "Rotation: "
            + Math.floor( stats.getPercent( 3 ) * 100 ) / 100 );
        rotationRight.setBounds( 150, 380, 100, 20 );

        gravitationRight = new JLabel( "Graviation: "
            + Math.floor( stats.getPercent( 4 ) * 100 ) / 100 );
        gravitationRight.setBounds( 350, 380, 100, 20 );

        fluidsRight = new JLabel(
            "Fluids: " + Math.floor( stats.getPercent( 5 ) * 100 ) / 100 );
        fluidsRight.setBounds( 550, 380, 100, 20 );

        frame = new JFrame( "StatsMenu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );
        c.add( text );
        c.add( avgTimePerProblem );
        c.add( avgNumRight );
        c.add( kinematics );
        c.add( newton );
        c.add( energy );
        c.add( rotation );
        c.add( gravitation );
        c.add( fluids );
        c.add( kinematicsRight );
        c.add( newtonRight );
        c.add( energyRight );
        c.add( rotationRight );
        c.add( gravitationRight );
        c.add( fluidsRight );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    /**
     * This class is in charge of the back button, which creates a new MainMenu
     * class (new window) and disposes of the StatsMenu window.
     *
     * @author Jason Dong
     * @version May 23, 2018
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
}