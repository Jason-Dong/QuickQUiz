import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Creates a TrainMenu object. TrainMenu allows the user to practice 25 problems
 * and scroll back and forth between problems. The user chooses an answer for as
 * many as possible, then clicks finish test, which allows the user see their
 * score, scroll back and forth between problems, and see solutions for
 * problems. At any time, the user can go back to MainMenu with the back button.
 *
 * @author AustinLei
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: docs.oracle.com for the createImageIcon method
 */
public class TrainMenu
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
     * The array that holds the 25 problems.
     */
    private Problem[] question;

    /**
     * The array that holds the answers to the 25 problems.
     */
    private char[] answers;

    /**
     * Holds the image for the problem.
     */
    private JLabel problemImage;

    /**
     * Holds the current answer for a problem.
     */
    private JLabel curAns;

    /**
     * Holds the timer, which increments every second.
     */
    private JLabel timerDisplay;

    /**
     * Holds the current problem number.
     */
    private int index = 0;

    /**
     * Handles the timing, making sure the timer increments every second.
     */
    private Timer timer;

    /**
     * Holds the number of seconds in the timer.
     */
    private int timerCount;


    /**
     * Constructs the TrainMenu object; creates the problem image, timer, back
     * button, and buttons to select the answers.
     * 
     * @param problem
     *            the ProblemDatabase that holds the problems
     * @param statistics
     *            holds the statistics
     */
    public TrainMenu( ProblemDatabase problem, Statistics statistics )
    {
        this.problem = problem;
        stats = statistics;
        question = new Problem[25];
        answers = new char[25];

        index = 0;

        for ( int i = 0; i < 25; i++ )
        {
            question[i] = problem.giveRandProblem();
        }

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton choice1 = new JButton( "A" );
        choice1.setBounds( 150, 475, 100, 25 );
        choice1.addActionListener( new AButtonListener() );

        JButton choice2 = new JButton( "B" );
        choice2.setBounds( 250, 475, 100, 25 );
        choice2.addActionListener( new BButtonListener() );

        JButton choice3 = new JButton( "C" );
        choice3.setBounds( 350, 475, 100, 25 );
        choice3.addActionListener( new CButtonListener() );

        JButton choice4 = new JButton( "D" );
        choice4.setBounds( 450, 475, 100, 25 );
        choice4.addActionListener( new DButtonListener() );

        JButton choice5 = new JButton( "E" );
        choice5.setBounds( 550, 475, 100, 25 );
        choice5.addActionListener( new EButtonListener() );

        JButton finish = new JButton( "Finish Test" );
        finish.setBounds( 250, 500, 300, 50 );
        finish.addActionListener( new FinishButtonListener() );

        JButton prevProb = new JButton( "Previous Problem" );
        prevProb.setBounds( 250, 425, 150, 50 );
        prevProb.addActionListener( new PrevButtonListener() );

        JButton nextProb = new JButton( "Next Problem" );
        nextProb.setBounds( 400, 425, 150, 50 );
        nextProb.addActionListener( new NextButtonListener() );

        curAns = new JLabel( "Current Answer: " + answers[index] );
        curAns.setBounds( 200, 400, 375, 25 );
        curAns.setHorizontalAlignment( JLabel.CENTER );

        timerDisplay = new JLabel( "Time Left: 75:00" );
        timerDisplay.setFont( new Font( "font", Font.PLAIN, 18 ) );
        timerDisplay.setBounds( 630, 10, 150, 50 );
        timerDisplay.setHorizontalAlignment( JLabel.CENTER );

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
        c.add( finish );
        c.add( prevProb );
        c.add( nextProb );
        c.add( curAns );
        c.add( timerDisplay );

        ImageIcon icon = createImageIcon( question[0].getProblemImage(), "image" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        int number = index + 1;

        problemImage = new JLabel( "Problem " + number, icon, JLabel.CENTER );
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


    /**
     * Updates the frame to show the current problem given by the index.
     */
    private void update()
    {
        ImageIcon icon = createImageIcon( question[index].getProblemImage(), "image1" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        int number = index + 1;

        problemImage.setText( "Problem " + number );
        problemImage.setIcon( icon );
        problemImage.setVerticalTextPosition( JLabel.BOTTOM );
        problemImage.setHorizontalTextPosition( JLabel.CENTER );

        curAns.setText( "Current Answer: " + answers[index] );
    }


    /**
     * Updates the frame when the finish button is clicked; removes the buttons
     * to enter an answer, allowing the user only to scroll between problems to
     * see the solutions.
     */
    private void updateFinish()
    {
        int score = 0;

        timer.stop();
        stats.addTime( timerCount );

        for ( int i = 0; i < 25; i++ )
        {
            if ( question[i].getAnswer() == answers[i] )
            {
                score++;
                stats.addScore( 1, 1, question[i].getType() );
            }
            else
            {
                stats.addScore( 0, 1, question[i].getType() );
            }
        }

        frame.dispose();

        JLabel numCorrect = new JLabel( "Score: " + score + "/25" );
        numCorrect.setBounds( 350, 400, 100, 50 );
        numCorrect.setHorizontalAlignment( JLabel.CENTER );

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton prevProb = new JButton( "Previous Problem" );
        prevProb.setBounds( 250, 500, 150, 50 );
        prevProb.addActionListener( new PrevButtonListener() );

        JButton nextProb = new JButton( "Next Problem" );
        nextProb.setBounds( 400, 500, 150, 50 );
        nextProb.addActionListener( new NextButtonListener() );

        JButton viewSol = new JButton( "See Solution" );
        viewSol.setBounds( 300, 450, 200, 50 );
        viewSol.addActionListener( new ViewButtonListener() );

        frame = new JFrame( "Training Menu" );
        frame.setDefaultCloseOperation( 0 );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        index = 0;

        update();

        c.add( back );
        c.add( prevProb );
        c.add( nextProb );
        c.add( viewSol );
        c.add( problemImage );
        c.add( numCorrect );

        frame.setVisible( true );
        frame.setResizable( false );
    }


    /**
     * Deals with timing; every second, decrements the timer by one second,
     * starting at 75 minutes. When the timer reaches 0, automatically calls
     * updateFinish() to allow the user to see the problem solutions.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class TimerListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            timerCount++;
            int numSecondsLeft = 75 * 60 - timerCount;
            if ( numSecondsLeft < 0 )
            {
                updateFinish();
            }
            int seconds = numSecondsLeft % 60;
            if ( seconds < 10 )
            {
                timerDisplay.setText( "Time Left: " + numSecondsLeft / 60 + ":0" + seconds );
            }
            else
            {
                timerDisplay.setText( "Time Left: " + numSecondsLeft / 60 + ":" + seconds );
            }
        }
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
            problem.reset();
            MainMenu mainMenu = new MainMenu( problem, stats );
            frame.dispose();
        }
    }


    /**
     * Handles when the A button is clicked; when clicked, sets the answer to
     * the current problem to A and moves to the next problem, if not at the
     * last problem. If at last problem, does not move to any problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class AButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'A';
            if ( index < 24 )
            {
                index++;
            }
            update();
        }
    }


    /**
     * Handles when the B button is clicked; when clicked, sets the answer to
     * the current problem to B and moves to the next problem, if not at the
     * last problem. If at last problem, does not move to any problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'B';
            if ( index < 24 )
            {
                index++;
            }
            update();
        }
    }


    /**
     * Handles when the C button is clicked; when clicked, sets the answer to
     * the current problem to C and moves to the next problem, if not at the
     * last problem. If at last problem, does not move to any problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class CButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'C';
            if ( index < 24 )
            {
                index++;
            }
            update();
        }
    }


    /**
     * Handles when the D button is clicked; when clicked, sets the answer to
     * the current problem to D and moves to the next problem, if not at the
     * last problem. If at last problem, does not move to any problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class DButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'D';
            if ( index < 24 )
            {
                index++;
            }
            update();
        }
    }


    /**
     * Handles when the E button is clicked; when clicked, sets the answer to
     * the current problem to E and moves to the next problem, if not at the
     * last problem. If at last problem, does not move to any problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class EButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'E';
            if ( index < 24 )
            {
                index++;
            }
            update();
        }
    }


    /**
     * Handles when the previous button is clicked; when clicked, moves to the
     * previous problem, if possible. If not, does nothing.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class PrevButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( index != 0 )
            {
                index--;
                update();
            }
        }
    }


    /**
     * Handles when the next button is clicked; when clicked, moves to the next
     * problem, if possible. If not, does nothing.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class NextButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( index != 24 )
            {
                index++;
                update();
            }
        }
    }


    /**
     * Handles when the View Solutions button is clicked; when clicked, creates
     * SolutionsMenu for current problem.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class ViewButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            SolutionsMenu sol = new SolutionsMenu( question[index] );
        }
    }


    /**
     * Handles when the Finish button is clicked; when clicked, calls
     * updateFinish().
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class FinishButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            updateFinish();
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
