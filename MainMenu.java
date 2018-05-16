import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainMenu
{
    private JFrame frame;
    private ProblemDatabase problem;

    public MainMenu( ProblemDatabase problem )
    {
        this.problem = problem;
        
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
        c.add(statsMenu);
        c.add( text );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    private class QQButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem );
            frame.dispose();
        }
    }


    private class TrainButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            TrainMenu trainMenu = new TrainMenu( problem );
            frame.dispose();
        }
    }


    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            AddMenu addMenu = new AddMenu( problem );
            frame.dispose();
        }
    }


    private class RemoveButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            RemoveMenu removeMenu = new RemoveMenu( problem );
            frame.dispose();
        }
    }
    
    private class StatButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            StatsMenu statsMenu = new StatsMenu();
            frame.dispose();
        }
    }

}