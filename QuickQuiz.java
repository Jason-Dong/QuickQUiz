import javax.swing.JFrame;

public class QuickQuiz
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );
        frame.setResizable( false );
        frame.setVisible( true );
        
        Statistics progressKeeper = new Statistics();
        StartMenu start = new StartMenu( progressKeeper, frame );
    }
}