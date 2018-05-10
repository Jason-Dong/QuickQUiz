import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class TrainMenu
{
    private JFrame frame;

    private ProblemDatabase problem;

    private ArrayList<Problem> question;

    private char[] answers;

    private int index = 0;

    private int score;

    JLabel problemImage;


    public TrainMenu( ProblemDatabase problem )
    {
        // this.problem = problem;
        //
        // question = new ArrayList<Problem>();
        // answers = new char[25];
        //
        // index = 0;
        //
        // for (int i = 0; i < 25; i++)
        // {
        // question.add( problem.giveRandProblem() );
        // }

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton choice1 = new JButton( "A" );
        choice1.setBounds( 150, 450, 100, 50 );
        choice1.addActionListener( new AButtonListener() );

        JButton choice2 = new JButton( "B" );
        choice2.setBounds( 250, 450, 100, 50 );
        choice2.addActionListener( new BButtonListener() );

        JButton choice3 = new JButton( "C" );
        choice3.setBounds( 350, 450, 100, 50 );
        choice3.addActionListener( new CButtonListener() );

        JButton choice4 = new JButton( "D" );
        choice4.setBounds( 450, 450, 100, 50 );
        choice4.addActionListener( new DButtonListener() );

        JButton choice5 = new JButton( "E" );
        choice5.setBounds( 550, 450, 100, 50 );
        choice5.addActionListener( new EButtonListener() );

        JButton finish = new JButton( "Finish Test" );
        finish.setBounds( 250, 500, 300, 50 );
        finish.addActionListener( new FinishButtonListener() );

        JButton prevProb = new JButton( "Previous Problem" );
        prevProb.setBounds( 250, 400, 150, 50 );
        prevProb.addActionListener( new PrevButtonListener() );

        JButton nextProb = new JButton( "Next Problem" );
        nextProb.setBounds( 400, 400, 150, 50 );
        nextProb.addActionListener( new NextButtonListener() );

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

        ImageIcon icon = createImageIcon( "images/2016_1.png", "image" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        int number = index + 1;

        problemImage = new JLabel( "Problem " + number, icon, JLabel.CENTER );

        problemImage.setBounds( 60, 60, 680, 340 );
        problemImage.setVerticalTextPosition( JLabel.BOTTOM );
        problemImage.setHorizontalTextPosition( JLabel.CENTER );

        c.add( problemImage );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    private void update()
    {
        Container c = frame.getContentPane();

        // if (problemImage != null)
        // {
        // c.remove( problemImage );
        // }

        // ImageIcon icon = createImageIcon( question.get( index
        // ).getProblemImage(), "image" );
        // Image image = icon.getImage();
        // Image newImage = image.getScaledInstance( 680, 300,
        // Image.SCALE_DEFAULT );
        // icon.setImage( newImage );

        ImageIcon icon = createImageIcon( "images/2016_1.png", "image" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        int number = index + 1;

        problemImage.setText( "Problem " + number );
        problemImage.setIcon( icon );
        problemImage.setVerticalTextPosition( JLabel.BOTTOM );
        problemImage.setHorizontalTextPosition( JLabel.CENTER );
    }


    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            // problem.reset();
            MainMenu mainMenu = new MainMenu( problem );
            frame.dispose();
        }
    }


    private class AButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'A';
            index++;
            update();
        }
    }


    private class BButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'B';
            index++;
            update();
        }
    }


    private class CButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'C';
            index++;
            update();
        }
    }


    private class DButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'D';
            index++;
            update();
        }
    }


    private class EButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            answers[index] = 'E';
            index++;
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
            SolutionsMenu sol = new SolutionsMenu( problem, question.get( index ), 1 );
        }
    }


    private class FinishButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
//            for ( int i = 0; i < 25; i++ )
//            {
//                if ( question.get( i ).getAnswer() == answers[i] )
//                {
//                    score++;
//                }
//            }

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


    /**
     * Runs the GUI method.
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        TrainMenu hi = new TrainMenu( null );
    }
}
