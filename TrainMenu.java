import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;


public class TrainMenu
{
    private JFrame frame;

    private ProblemDatabase problem;

    private Problem[] question;

    private char[] answers;

    private int index = 0;

    JLabel problemImage;

    private Timer timer;

    private int timerCount;

    JLabel curAns;

    JLabel timerDisplay;


    public TrainMenu( ProblemDatabase problem )
    {
        this.problem = problem;

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


    private void updateFinish()
    {
        int score = 0;

        for ( int i = 0; i < 25; i++ )
        {
            if ( question[i].getAnswer() == answers[i] )
            {
                score++;
            }
        }

        timer.stop();
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


    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            problem.reset();
            MainMenu mainMenu = new MainMenu( problem );
            frame.dispose();
        }
    }


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


    private class ViewButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            SolutionsMenu sol = new SolutionsMenu( question[index] );
        }
    }


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
