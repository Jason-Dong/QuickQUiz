import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Creates the main menu frame, which leads to the QQMenu, TrainMenu, AddMenu,
 * RemoveMenu, and the StatsMenu.
 *
 * @author Austin Lei
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class MainMenu
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
     * Constructs the MainMenu Object, with five buttons that lead to all five
     * functionalities.
     * 
     * @param problem
     *            the ProblemDatabase that holds the problems
     * @param statistics
     *            holds the statistics
     */
    public MainMenu( ProblemDatabase problem, Statistics statistics )
    {
        this.problem = problem;
        stats = statistics;

        JButton QQMenu = new JButton( "Quick Quiz" );
        QQMenu.setBounds( 200, 125, 400, 75 );
        QQMenu.addActionListener( new QQButtonListener() );

        JButton trainMenu = new JButton( "Training" );
        trainMenu.setBounds( 200, 200, 400, 75 );
        trainMenu.addActionListener( new TrainButtonListener() );

        JButton addMenu = new JButton( "Add Problems" );
        addMenu.setBounds( 200, 275, 400, 75 );
        addMenu.addActionListener( new AddButtonListener() );

        JButton removeMenu = new JButton( "Remove Problems" );
        removeMenu.setBounds( 200, 350, 400, 75 );
        removeMenu.addActionListener( new RemoveButtonListener() );

        JButton statsMenu = new JButton( "Statistics" );
        statsMenu.setBounds( 200, 425, 400, 75 );
        statsMenu.addActionListener( new StatButtonListener() );

        JLabel text = new JLabel( "Quick Quiz Generator" );
        text.setFont( new Font( "font", Font.PLAIN, 48 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 75 );

        frame = new JFrame( "Main Menu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( QQMenu );
        c.add( trainMenu );
        c.add( addMenu );
        c.add( removeMenu );
        c.add( statsMenu );
        c.add( text );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    /**
     * Handles when the QQMenu button is clicked; when clicked, goes to QQMenu
     * by closing all of MainMenu and creating a QQMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class QQButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            TypeMenu typeMenu = new TypeMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the TrainMenu button is clicked; when clicked, goes to
     * TrainMenu by closing all of MainMenu and creating a QQMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class TrainButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            TrainMenu trainMenu = new TrainMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the AddMenu button is clicked; when clicked, goes to AddMenu
     * by closing all of MainMenu and creating a QQMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            AddMenu addMenu = new AddMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the RemoveMenu button is clicked; when clicked, goes to
     * RemoveMenu by closing all of MainMenu and creating a QQMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class RemoveButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            RemoveMenu removeMenu = new RemoveMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the StatsMenu button is clicked; when clicked, goes to
     * StatsMenu by closing all of MainMenu and creating a QQMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class StatButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            StatsMenu statsMenu = new StatsMenu( problem, stats );
            frame.dispose();
        }
    }

}