import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SolutionsMenu
{
    private static JFrame thisWindow;


    /**
     * Constructor for the SolutionsMenu class. This creates a image JLabel and
     * a text below. Additionally, it creates a back button which is centered.
     */
    public SolutionsMenu( Problem prob )
    {
        JLabel label1;
        JButton back = new JButton( "Close" );
        back.setBounds( 375, 500, 50, 50 );

        ImageIcon icon = createImageIcon( prob.getSolutionImage(), "image" );
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance( 680, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );

        label1 = new JLabel( "Solution", icon, JLabel.CENTER );

        label1.setBounds( 60, 60, 680, 340 );
        // label1.setVerticalTextPosition( JLabel.BOTTOM ); //only needed for
        // text underneath
        // label1.setHorizontalTextPosition( JLabel.CENTER ); //only needed for
        // text underneath
        back.addActionListener( new BackButtonListener() );

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
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

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

}