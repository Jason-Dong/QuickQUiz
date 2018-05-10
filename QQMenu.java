import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class QQMenu
{
    private JFrame frame;

    private ProblemDatabase problem;
    
    private Problem question;
    
    private int points;


    public QQMenu( ProblemDatabase problem )
    {
        this.problem = problem;
        
        points = 0;
        
        question = problem.giveRandProblem();

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JButton choice1 = new JButton( "A" );
        choice1.setBounds( 150, 500, 100, 50 );
        choice1.addActionListener( new AButtonListener() );
        
        JButton choice2 = new JButton( "B" );
        choice2.setBounds(250, 500, 100, 50 );
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

        frame.setResizable( false );
        frame.setVisible( true );
    }


    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            MainMenu mainMenu = new MainMenu( problem );
            frame.dispose();
        }
    }
    
    private class AButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (question.getAnswer() == 'A')
            {
                
            }
            else
            {
                
            }
            
            SolutionsMenu solution = new SolutionsMenu(problem, question, 0);
        }
    }
    
    private class BButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (question.getAnswer() == 'B')
            {
                
            }
            else
            {
                
            }
            
            SolutionsMenu solution = new SolutionsMenu(problem, question, 0);
        }
    }
    
    private class CButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (question.getAnswer() == 'C')
            {
                
            }
            else
            {
                
            }
            
            SolutionsMenu solution = new SolutionsMenu(problem, question, 0);
        }
    }
    
    private class DButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (question.getAnswer() == 'D')
            {
                
            }
            else
            {
                
            }
            
            SolutionsMenu solution = new SolutionsMenu(problem, question, 0);
        }
    }
    
    private class EButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if (question.getAnswer() == 'E')
            {
                
            }
            else
            {
                
            }
            
            SolutionsMenu solution = new SolutionsMenu(problem, question, 0);
        }
    }
}
