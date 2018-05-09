import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class QQMenu
{
    JFrame frame;

    ProblemDatabase problem;


    public QQMenu( ProblemDatabase problem )
    {
        this.problem = problem;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        frame = new JFrame( "Quick Quiz Menu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );

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
}
