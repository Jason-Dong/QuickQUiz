import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import java.lang.Object;
import java.net.URL;
import java.net.URLDecoder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.io.*;
import java.awt.geom.*;

// package net.codejava.graphic;


public class SolutionsMenu extends JPanel
{
    private static JFrame thisWindow;

    private static ProblemDatabase problem;


    /**
     * Constructor for the SolutionsMenu class. This creates a image JLabel and
     * a text below.
     */
    public SolutionsMenu( ProblemDatabase probDat, int x )
    {
        JLabel label1;
        JButton back = new JButton( "Back" );
        back.setBounds( 100, 100, 100, 100 );

        ImageIcon icon = createImageIcon( "images/2016_1.png",
            "First Image" );
        Image image = icon.getImage();
        Image newImage = image
            .getScaledInstance( 750, 300, Image.SCALE_DEFAULT );
        icon.setImage( newImage );
        // Create the first label.
        label1 = new JLabel( "First Image", icon, JLabel.CENTER );
        // Set the position of its text, relative to its icon:
        label1.setVerticalTextPosition( JLabel.BOTTOM );
        label1.setHorizontalTextPosition( JLabel.CENTER );
        if ( x == 0 ) // called from QQMenu
            back.addActionListener( new BackButtonListenerQQ() );
        else // called from TrainMenu
            back.addActionListener( new BackButtonListenerTrain() );

        // Create tool tips, for the heck of it.
        // label1.setToolTipText( "Image & Text" );

        add( label1 );
        add( back );
    }


    private class BackButtonListenerQQ implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            QQMenu qqMenu = new QQMenu( problem );
            thisWindow.dispose();
        }
    }


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
     * This method creates a frame of size 800 by 600 and instantiates
     * solutionMenu to add it to the frame.
     */
    public static void createAndShowGUI()
    {
        // back.addActionListener( new BackButtonListener() );
        thisWindow = new JFrame( "SolutionsMenu" );
        thisWindow.setBounds( 0, 0, 800, 600 );
        // frame.pack();
        thisWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        thisWindow.add( new SolutionsMenu( problem, 1 ) );
        thisWindow.setVisible( true );

        // thisWindow.setLayout( null );
        // thisWindow.setResizable( false );
    }


    /**
     * Runs the GUI method.
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        createAndShowGUI();
    }
}