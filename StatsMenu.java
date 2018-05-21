import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;


public class StatsMenu
{
    private Statistics stats;

    private ProblemDatabase problem;

    private JFrame frame;

    private JLabel kinematics;

    private JLabel newton;

    private JLabel energy;

    private JLabel rotation;

    private JLabel gravitation;

    private JLabel fluids;


    // percent by topic, average time per problem (array of time),

    public StatsMenu( ProblemDatabase prob, Statistics statistics )
    {
        stats = statistics;
        problem = prob;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel text = new JLabel( "Statistics Menu" );
        text.setFont( new Font( "font", Font.PLAIN, 48 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 75 );

        JLabel avgTimePerProblem = new JLabel(
            "Average Time Per Problem" );
        avgTimePerProblem.setFont( new Font( "font", Font.PLAIN, 30 ) );
        avgTimePerProblem.setHorizontalAlignment( JLabel.CENTER );
        avgTimePerProblem.setBounds( 100, 105, 600, 75 );

        kinematics = new JLabel( "Kinematics: " + stats.getTime( 0 ) );
        kinematics.setBounds( 100, 320, 100, 20 );

        newton = new JLabel( "Newton's Laws: " + stats.getTime( 1 ) );
        newton.setBounds( 200, 320, 100, 20 );

        energy = new JLabel( "Energy: " + stats.getTime( 2 ) );
        energy.setBounds( 300, 320, 100, 20 );

        rotation = new JLabel( "Rotation: " + stats.getTime( 3 ) );
        rotation.setBounds( 400, 320, 100, 20 );

        gravitation = new JLabel( "Graviation: " + stats.getTime( 4 ) );
        gravitation.setBounds( 500, 320, 100, 20 );

        fluids = new JLabel( "Fluids: " + stats.getTime( 5 ) );
        fluids.setBounds( 600, 320, 100, 20 );

        frame = new JFrame( "StatsMenu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );
        c.add( text );
        c.add( avgTimePerProblem );
        c.add( kinematics );
        c.add( newton );
        c.add( energy );
        c.add( rotation );
        c.add( gravitation );
        c.add( fluids );

        frame.setResizable( false );
        frame.setVisible( true );

    }


    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            MainMenu mainMenu = new MainMenu( problem, stats );
            frame.dispose();
        }
    }
}