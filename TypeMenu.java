import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Allows the user to choose the type of problem to practice for QQMenu, then
 * makes the QQMenu.
 *
 * @author Austin Lei
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class TypeMenu
{
    /**
     * Holds all of the GUI elements.
     */
    private JFrame frame;

    /**
     * The ProblemDatabase to get all of the problems.
     */
    private ProblemDatabase problem;

    /**
     * Holds all of the problem statistics for QuickQuiz.
     */
    private Statistics stats;


    /**
     * Constructs the window for TypeMenu
     * 
     * @param problem
     *            the ProblemDatabase that holds the problems
     * @param statistics
     *            holds the statistics
     */
    public TypeMenu( ProblemDatabase problem, Statistics statistics )
    {
        this.problem = problem;
        stats = statistics;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 200, 150, 200, 50 );
        kinematics.addActionListener( new KinematicsListener() );

        JButton newton = new JButton( "Newton's Laws" );
        newton.setBounds( 400, 150, 200, 50 );
        newton.addActionListener( new NewtonListener() );

        JButton energy = new JButton( "Energy" );
        energy.setBounds( 200, 200, 200, 50 );
        energy.addActionListener( new EnergyListener() );

        JButton rotation = new JButton( "Rotation" );
        rotation.setBounds( 400, 200, 200, 50 );
        rotation.addActionListener( new RotationListener() );

        JButton gravitation = new JButton( "Gravitation" );
        gravitation.setBounds( 200, 250, 200, 50 );
        gravitation.addActionListener( new GravitationListener() );

        JButton fluids = new JButton( "Fluids" );
        fluids.setBounds( 400, 250, 200, 50 );
        fluids.addActionListener( new FluidsListener() );

        JButton all = new JButton( "All Types" );
        all.setBounds( 300, 300, 200, 50 );
        all.addActionListener( new AllListener() );

        JLabel text = new JLabel( "Choose Problem Type for Quick Quiz" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 100 );

        frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation( 0 );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );
        c.add( text );
        c.add( kinematics );
        c.add( newton );
        c.add( energy );
        c.add( rotation );
        c.add( gravitation );
        c.add( fluids );
        c.add( all );

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
     * Handles when the kinematics button is clicked; when clicked, creates a
     * QQMenu that only has kinematics problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class KinematicsListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 0, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the Newton's law button is clicked; when clicked, creates a
     * QQMenu that only has Newton's law problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class NewtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 1, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the energy button is clicked; when clicked, creates a QQMenu
     * that only has energy problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class EnergyListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 2, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the rotation button is clicked; when clicked, creates a
     * QQMenu that only has rotation problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class RotationListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 3, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the gravitation button is clicked; when clicked, creates a
     * QQMenu that only has gravitation problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class GravitationListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 4, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the fluids button is clicked; when clicked, creates a QQMenu
     * that only has fluids problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class FluidsListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, 5, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the all button is clicked; when clicked, creates a QQMenu
     * that includes all problems.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class AllListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem, -1, stats );
            frame.dispose();
        }
    }
}