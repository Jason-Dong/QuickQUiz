import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Opens a separate menu that displays a correctly scaled image, either a
 * problem or solution image. Called from either QQMenu or TrainMenu.s
 *
 * @author Austin Lei and Jason Dong
 * @version May 28, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: docs.oracle.com for the createImageIcon method
 */
public class ImageMenu
{
    /**
     * Holds all of the GUI elements.
     */
    private static JFrame frame;


    /**
     * Constructs the menu given the problem and the boolean isProblem. If
     * isProblem is true, creates a menu with a back button and the problem's
     * problem image. Otherwise, creates a menu with a back button and the
     * problem's solution image.
     * 
     * @param prob
     *            the problem for which the images should be displayed
     * @param isProblem
     *            whether the problem image should be shown or the solution
     *            image
     */
    public ImageMenu( Problem prob, boolean isProblem )
    {
        JLabel label1;
        JButton back = new JButton( "Close" );
        back.setBounds( 5, 5, 50, 50 );

        ImageIcon icon;
        if ( isProblem )
        {
            icon = createImageIcon( prob.getProblemImage(), "image" );
        }
        else
        {
            icon = createImageIcon( prob.getSolutionImage(), "image" );
        }
        Image image = icon.getImage();
        Image newImage;
        if ( icon.getIconWidth() >= icon.getIconHeight() )
        {

            newImage = image.getScaledInstance( 680,
                680 * icon.getIconHeight() / icon.getIconWidth(),
                Image.SCALE_DEFAULT );
        }
        else
        {
            newImage = image.getScaledInstance( 680 * icon.getIconWidth() / icon.getIconHeight(),
                680,
                Image.SCALE_DEFAULT );
        }

        icon.setImage( newImage );

        label1 = new JLabel( "", icon, JLabel.CENTER );

        label1.setBounds( 60, 60, 680, 940 );
        label1.setVerticalAlignment( JLabel.TOP );
        label1.setHorizontalAlignment( JLabel.CENTER );
        back.addActionListener( new BackButtonListener() );

        frame = new JFrame( "ImageMenu" );
        frame.setBounds( 0, 0, 800, 1000 );
        frame.setDefaultCloseOperation( 0 );
        frame.setVisible( true );
        Container c = frame.getContentPane();

        c.add( label1 );
        c.add( back );

        frame.setLayout( null );
        frame.setResizable( false );
    }


    /**
     * Handles when the back button is clicked; when clicked, returns to
     * MainMenu by closing all of TypeMenu and creating a MainMenu object.
     *
     * @author Austin Lei
     * @version May 22, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

            frame.dispose();
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
        if ( path != null )
        {
            return new ImageIcon( path, description );
        }
        else
        {
            System.err.println( "Couldn't find file: " + path );
            return null;
        }
    }

}