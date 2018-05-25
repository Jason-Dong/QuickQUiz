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
    public MainMenu( ProblemDatabase problem, Statistics statistics, JFrame frame )
    {
        this.problem = problem;
        stats = statistics;
        this.frame = frame;

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

        frame.setTitle( "Main Menu" );

        frame.add( QQMenu );
        frame.add( trainMenu );
        frame.add( addMenu );
        frame.add( removeMenu );
        frame.add( statsMenu );
        frame.add( text );
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
            frame.removeAll();
            TypeMenu typeMenu = new TypeMenu( problem, stats, frame );
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
            frame.removeAll();
            TrainMenu trainMenu = new TrainMenu( problem, stats, frame );
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
            frame.removeAll();
            AddMenu addMenu = new AddMenu( problem, stats, frame );
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
            frame.removeAll();
            RemoveMenu removeMenu = new RemoveMenu( problem, stats, frame );
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
            frame.removeAll();
            StatsMenu statsMenu = new StatsMenu( problem, stats, frame );
        }
    }

}