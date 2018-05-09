import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SolutionsMenu extends JPanel
{
    private static JFrame thisWindow;

    private static ProblemDatabase problem;

    private static Problem prob;


    /**
     * Constructor for the SolutionsMenu class. This creates a image JLabel and
     * a text below. Additionally, it creates a back button which is centered.
     */
    public SolutionsMenu( ProblemDatabase probDat, Problem prob, int menu )
    {
        JLabel label1;
        JButton back = new JButton( "Back" );
        back.setBounds( 25, 500, 50, 50 );

        ImageIcon icon = createImageIcon( "images/2016_1.png",
            "First Image" );
        Image image = icon.getImage();
        Image newImage = image
            .getScaledInstance( 750, 250, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        label1 = new JLabel( "First Image", icon, JLabel.CENTER );

        label1.setBounds( 25, 25, 750, 250 );
        // label1.setVerticalTextPosition( JLabel.BOTTOM ); //only needed for
        // text underneath
        // label1.setHorizontalTextPosition( JLabel.CENTER ); //only needed for
        // text underneath
        if ( menu == 0 ) // called from QQMenu
            back.addActionListener( new BackButtonListenerQQ() );
        else // called from TrainMenu
            back.addActionListener( new BackButtonListenerTrain() );

        thisWindow = new JFrame( "SolutionsMenu" );
        thisWindow.setBounds( 0, 0, 800, 600 );
        thisWindow.setDefaultCloseOperation( 0 );
        thisWindow.setVisible( true );
        Container c = thisWindow.getContentPane();

        c.add( label1 );
        c.add( back );

        thisWindow.setLayout( null );
        thisWindow.setResizable( false );
    }


    /**
     * This nested class calls QQMenu, which only runs if QQMenu is calling
     * SolutionsMenu (it will create Solutions with an integer in the parameter,
     * which lets the SolutionsMenu class know which class called it (QQMenu
     * passes in a 0, and TrainMenu passes in a 1). It then creates a new
     * TrainMenu GUI window, and closes the SolutionsMenu window.
     *
     * @author jdong758
     * @version May 9, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BackButtonListenerQQ implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem );
            thisWindow.dispose();
        }
    }


    /**
     * This nested class calls TrainMenu, which only runs if TrainMenu is
     * calling SolutionsMenu (it will create Solutions with an integer in the
     * parameter, which lets the SolutionsMenu class know which class called it
     * (QQMenu passes in a 0, and TrainMenu passes in a 1). It then creates a
     * new TrainMenu GUI window, and closes the SolutionsMenu window.
     *
     * @author jdong758
     * @version May 9, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BackButtonListenerTrain implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            TrainMenu trainMenu = new TrainMenu( problem );
            thisWindow.dispose();
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
        SolutionsMenu temp = new SolutionsMenu( null, null, 0 );
    }
}