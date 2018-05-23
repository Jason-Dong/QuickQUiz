import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ImageMenu
{
    private static JFrame frame;


    public ImageMenu( Problem prob, boolean problem )
    {
        JLabel label1;
        JButton back = new JButton( "Close" );
        back.setBounds( 5, 5, 50, 50 );

        ImageIcon icon;
        if ( problem )
        {
            icon = createImageIcon( prob.getProblemImage(), "image" );
        }
        else
        {
            icon = createImageIcon( prob.getSolutionImage(), "image" );
        }
        Image image = icon.getImage();
        Image newImage;
        System.out.println( icon.getIconHeight() + " " + icon.getIconWidth() );
        if ( icon.getIconWidth() >= icon.getIconHeight() )
        {

            newImage = image.getScaledInstance( 680,
                680 * icon.getIconHeight() / icon.getIconWidth(),
                Image.SCALE_DEFAULT );
        }
        else
        {
            System.out.println( "hi" );
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