import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainMenu extends JFrame
{
    JFrame frame;


    public MainMenu( ProblemDatabase problem )
    {
        JButton QQMenu = new JButton( "Quick Quiz" );
        QQMenu.setBounds( 200, 150, 400, 100 );
        QQButtonListener listen1 = new QQButtonListener();
        QQMenu.addActionListener( listen1 );

        JButton trainMenu = new JButton( "Training" );
        trainMenu.setBounds( 200, 250, 400, 100 );

        JButton addMenu = new JButton( "Add Problems" );
        addMenu.setBounds( 200, 350, 400, 100 );

        JButton removeMenu = new JButton( "Remove Problems" );
        removeMenu.setBounds( 200, 450, 400, 100 );

        JLabel text = new JLabel( "Quick Quiz Generator" );
        text.setFont( new Font( "font", Font.PLAIN, 48 ) );
        text.setHorizontalAlignment( text.CENTER );
        text.setBounds( 100, 30, 600, 100 );

        frame = new JFrame( "MainMenu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( QQMenu );
        c.add( trainMenu );
        c.add( addMenu );
        c.add( removeMenu );
        c.add( text );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    private class QQButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( null );
            frame.dispose();
        }
    }


    private class TrainButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            TrainMenu trainMenu = new TrainMenu( null );
            frame.dispose();
        }
    }

    // private class AddButtonListener implements ActionListener
    // {
    // public void actionPerformed( ActionEvent e )
    // {
    // AddMenu addMenu = new AddMenu( null );
    // }
    // }
    //
    //
    // private class RemoveButtonListener implements ActionListener
    // {
    // public void actionPerformed( ActionEvent e )
    // {
    // RemoveMenu removeMenu = new RemoveMenu( null );
    // }
    // }

}
