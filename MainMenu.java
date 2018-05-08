import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainMenu extends JFrame
{
    private static JFrame thisWindow;

    private Problem x;


    public MainMenu( ProblemDatabase problem )
    {
        JButton QQMenu = new JButton( "Quick Quiz" );
        QQMenu.setBounds( 200, 150, 400, 100 );
        JButton trainMenu = new JButton( "Training" );
        trainMenu.setBounds( 200, 250, 400, 100 );
        JButton addMenu = new JButton( "Add Problems" );
        addMenu.setBounds( 200, 350, 400, 100 );
        JButton removeMenu = new JButton( "Remove Problems" );
        removeMenu.setBounds( 200, 450, 400, 100 );
        JLabel text = new JLabel( "Quick Quiz Generator" );
        text.setBounds( 200, 50, 400, 100 );

        JFrame frame = new JFrame( "MainMenu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( QQMenu );
        c.add( trainMenu );
        c.add( addMenu );
        c.add( removeMenu );
        c.add( text );

        frame.setVisible( true );
    }

}
