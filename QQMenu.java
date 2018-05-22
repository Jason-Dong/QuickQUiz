import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;


/**
 * Creates a QQMenu object. QQMenu allows the user to as many problems as
 * wanted, one at a time, and scroll back and forth between problems, of a
 * specific topic or all topics. The user clicks an answer choice for a problem,
 * which allows the user see their score, scroll back and forth between
 * problems, and see solutions for problems. At any time, the user can go back
 * to MainMenu with the back button.
 *
 * @author Austin Lei
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class QQMenu
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
     * Holds all of the problems to give when the back button is clicked.
     */
    private Stack<Problem> backStack;

    /**
     * Holds all of the problems to give when the forward button is clicked.
     */
    private Stack<Problem> forwardStack;

    /**
     * Holds the image for the problem.
     */
    private JLabel problemImage;

    /**
     * Holds the timer, which increments every second.
     */
    private JLabel timerDisplay;

    /**
     * Displays the score, updates every time score changes.
     */
    private JLabel scoreDisplay;

    /**
     * Handles the timing, making sure the timer increments every second.
     */
    private Timer timer;

    /**
     * Holds the number of seconds in the timer.
     */
    private int timerCount;

    /**
     * Holds the score; 100 points for problems solved correctly in less than 3
     * minutes, and 50 points for problems solved correctly after 3 minutes.
     */
    private int totalScore;

    /**
     * Holds the type of problems to do training; -1 denotes all types of
     * problems.
     */
    private int problemType;


    /**
     * Constructs the QQMenu; takes in the problemDatabase, Statistics, and type
     * of problem, and calls updateProblem based on these parameters.
     * 
     * @param problem
     *            the problemDatabase that holds all of the problems
     * @param type
     *            the type of problem to do; -1 denotes all types
     * @param statistics
     *            holds the statistics about the solved problems
     */
    public QQMenu( ProblemDatabase problem, int type, Statistics statistics )
    {
        this.problem = problem;
        backStack = new Stack<Problem>();
        forwardStack = new Stack<Problem>();
        problemType = type;
        stats = statistics;

        updateProblem();
    }


    /**
     * Restarts the timer and calls a new random problem of a certain type; if
     * no more problems, shows that no more problems exist and allows user to
     * exit to MainMenu through the back button. If problem exists, changes the
     * display to show the problem, shows the answer choice buttons, and creates
     * a back button for user go back to MainMenu.
     */
    private void updateProblem()
    {
        while ( !forwardStack.isEmpty() )
        {
            backStack.push( forwardStack.pop() );
        }

        if ( frame != null )
        {
            frame.dispose();
        }

        Problem prb;

        if ( problemType == -1 )
        {
            prb = problem.giveRandProblem();
        }
        else
        {
            prb = problem.giveRandProblem( problemType );
        }

        if ( prb == null )
        {
            updateFinish();
        }
        else
        {
            forwardStack.push( prb );

            JButton back = new JButton( "Back" );
            back.setBounds( 10, 10, 50, 50 );
            back.addActionListener( new BackButtonListener() );

            JButton choice1 = new JButton( "A" );
            choice1.setBounds( 150, 500, 100, 50 );
            choice1.addActionListener( new AButtonListener() );

            JButton choice2 = new JButton( "B" );
            choice2.setBounds( 250, 500, 100, 50 );
            choice2.addActionListener( new BButtonListener() );

            JButton choice3 = new JButton( "C" );
            choice3.setBounds( 350, 500, 100, 50 );
            choice3.addActionListener( new CButtonListener() );

            JButton choice4 = new JButton( "D" );
            choice4.setBounds( 450, 500, 100, 50 );
            choice4.addActionListener( new DButtonListener() );

            JButton choice5 = new JButton( "E" );
            choice5.setBounds( 550, 500, 100, 50 );
            choice5.addActionListener( new EButtonListener() );

            timerDisplay = new JLabel( "Time: 0:00" );
            timerDisplay.setFont( new Font( "font", Font.PLAIN, 18 ) );
            timerDisplay.setBounds( 650, 10, 150, 50 );
            timerDisplay.setHorizontalAlignment( JLabel.CENTER );

            scoreDisplay = new JLabel( "Score: 0" );
            scoreDisplay.setBounds( 300, 400, 200, 50 );
            scoreDisplay.setHorizontalAlignment( JLabel.CENTER );

            frame = new JFrame( "Quick Quiz Menu" );
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
            c.add( scoreDisplay );
            c.add( timerDisplay );

            ImageIcon icon = createImageIcon( forwardStack.peek().getProblemImage(), "image" );
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
            icon.setImage( newImage );

            problemImage = new JLabel( "Problem " + ( this.backStack.size() + 1 ),
                icon,
                JLabel.CENTER );
            problemImage.setFont( new Font( "font", Font.PLAIN, 18 ) );
            problemImage.setBounds( 60, 60, 680, 340 );
            problemImage.setVerticalTextPosition( JLabel.BOTTOM );
            problemImage.setHorizontalTextPosition( JLabel.CENTER );

            c.add( problemImage );

            frame.setResizable( false );
            frame.setVisible( true );

            TimerListener time = new TimerListener();
            timer = new Timer( 1000, time );
            timer.start();
        }
    }


    /**
     * Allow user to see the solutions page for a certain problem; displays the
     * image of the problem, the score, buttons to go back and forth between
     * problems, a back button, another button to see the solution, and another
     * button to see a new problem. Also adds the time used for the problem into
     * statistics.
     * 
     * @param prob
     *            the problem to display
     */
    private void updateSolutionsPage( Problem prob )
    {
        frame.dispose();
        stats.addTime( forwardStack.peek().getType(), timerCount );
        timerCount = 0;

        scoreDisplay.setText( "Score: " + totalScore );
        scoreDisplay.setBounds( 300, 400, 200, 25 );
        scoreDisplay.setHorizontalAlignment( JLabel.CENTER );

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton prevProb = new JButton( "Previous Problem" );
        prevProb.setBounds( 250, 475, 150, 25 );
        prevProb.addActionListener( new PrevButtonListener() );

        JButton nextProb = new JButton( "Next Problem" );
        nextProb.setBounds( 400, 475, 150, 25 );
        nextProb.addActionListener( new NextButtonListener() );

        JButton viewSol = new JButton( "See Solution" );
        viewSol.setBounds( 300, 450, 200, 25 );
        viewSol.addActionListener( new ViewButtonListener() );

        JButton continueButton = new JButton( "Continue to New Problem" );
        continueButton.setBounds( 300, 500, 200, 50 );
        continueButton.addActionListener( new ContinueButtonListener() );

        frame = new JFrame( "Quick Quiz Menu" );
        frame.setDefaultCloseOperation( 0 );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );
        c.add( viewSol );
        c.add( prevProb );
        c.add( nextProb );
        c.add( continueButton );
        c.add( problemImage );
        c.add( scoreDisplay );
        
        JLabel answer = new JLabel("Answer: " + forwardStack.peek().getAnswer());
        answer.setHorizontalAlignment( JLabel.CENTER );
        answer.setBounds( 200, 425, 400, 25 );

        ImageIcon icon = createImageIcon( forwardStack.peek().getProblemImage(), "image" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        problemImage.setText( "Problem " + ( backStack.size() + 1 ) );
        problemImage.setIcon( icon );
        problemImage.setVerticalTextPosition( JLabel.BOTTOM );
        problemImage.setHorizontalTextPosition( JLabel.CENTER );

        c.add( answer );
        c.add( problemImage );

        frame.setVisible( true );
        frame.setResizable( false );
    }


    /**
     * Updates the score and records the scores in statistics.
     * 
     * @param correct
     *            whether the problem was correct or not
     * @param time
     *            the time taken for the problem
     */
    private void updateScore( boolean correct, int time )
    {
        if ( correct )
        {
            stats.addScore( 1, 1, forwardStack.peek().getType() );
            if ( time <= 180 )
            {
                totalScore += 100;
            }
            else
            {
                totalScore += 50;
            }
        }
        else
        {
            stats.addScore( 0, 1, forwardStack.peek().getType() );
        }
    }


    /**
     * Automatically called when all problem of a type exhausted; gives a back
     * button for user to return to main menu.
     */
    private void updateFinish()
    {
        frame.dispose();

        frame = new JFrame( "Quick Quiz Menu" );
        frame.setDefaultCloseOperation( 0 );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel finish = new JLabel( "That's all of the problems!" );
        finish.setFont( new Font( "font", Font.PLAIN, 36 ) );
        finish.setBounds( 60, 60, 680, 340 );
        finish.setHorizontalAlignment( JLabel.CENTER );

        c.add( back );
        c.add( finish );

        frame.setVisible( true );
        frame.setResizable( false );
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timerCount++;
            int seconds = timerCount % 60;
            if ( seconds < 10 )
            {
                timerDisplay.setText( "Time: " + timerCount / 60 + ":0" + seconds );
            }
            else
            {
                timerDisplay.setText( "Time: " + timerCount / 60 + ":" + seconds );
            }
        }
    }


    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            problem.reset();
            MainMenu mainMenu = new MainMenu( problem, stats );
            frame.dispose();
        }
    }


    private class AButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timer.stop();
            updateScore( forwardStack.peek().getAnswer() == 'A', timerCount );
            updateSolutionsPage( forwardStack.peek() );
        }
    }


    private class BButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timer.stop();
            updateScore( forwardStack.peek().getAnswer() == 'B', timerCount );
            updateSolutionsPage( forwardStack.peek() );
        }
    }


    private class CButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timer.stop();
            updateScore( forwardStack.peek().getAnswer() == 'C', timerCount );
            updateSolutionsPage( forwardStack.peek() );
        }
    }


    private class DButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timer.stop();
            updateScore( forwardStack.peek().getAnswer() == 'D', timerCount );
            updateSolutionsPage( forwardStack.peek() );
        }
    }


    private class EButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timer.stop();
            updateScore( forwardStack.peek().getAnswer() == 'E', timerCount );
            updateSolutionsPage( forwardStack.peek() );
        }
    }


    private class PrevButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( !backStack.isEmpty() )
            {
                forwardStack.push( backStack.pop() );
                updateSolutionsPage( forwardStack.peek() );
            }
        }
    }


    private class NextButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( forwardStack.size() > 1 )
            {
                backStack.push( forwardStack.pop() );
                updateSolutionsPage( forwardStack.peek() );
            }
        }
    }


    private class ViewButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            SolutionsMenu sol = new SolutionsMenu( forwardStack.peek() );
        }
    }


    private class ContinueButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            updateProblem();
        }
    }


    /**
     * Method was taken from docs.oracle.com
     * 
     * @param path
     *            is the pathname of the image
     * @param description
     *            is the name of the image
     * @return ImageIcon, a fixed-size picture
     */
    protected ImageIcon createImageIcon( String path, String description )
    {
        java.net.URL imgURL = getClass().getResource( path );
        if ( imgURL != null )
        {
            return new ImageIcon( imgURL, description );
        }
        else
        {
            System.err.println( "Couldn't find file: " + path );
            return null;
        }
    }

}