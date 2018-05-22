import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;


public class StatsMenu // problem encountered: percent dividing by 0: add
                       // conditional statement in Statistics
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

    private JLabel kinematicsRight;

    private JLabel newtonRight;

    private JLabel energyRight;

    private JLabel rotationRight;

    private JLabel gravitationRight;

    private JLabel fluidsRight;


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
            "Average Time Per Problem in Seconds" );
        avgTimePerProblem.setFont( new Font( "font", Font.PLAIN, 30 ) );
        avgTimePerProblem.setHorizontalAlignment( JLabel.CENTER );
        avgTimePerProblem.setBounds( 100, 105, 600, 75 );

        JLabel avgNumRight = new JLabel(
            "Average Number of Problems Right" );
        avgNumRight.setFont( new Font( "font", Font.PLAIN, 30 ) );
        avgNumRight.setHorizontalAlignment( JLabel.CENTER );
        avgNumRight.setBounds( 100, 250, 600, 75 );

        kinematics = new JLabel( "Kinematics: " + stats.getTime( 0 ) );
        kinematics.setBounds( 100, 200, 100, 20 );

        newton = new JLabel( "Newton: " + stats.getTime( 1 ) );
        newton.setBounds( 200, 200, 100, 20 );

        energy = new JLabel( "Energy: " + stats.getTime( 2 ) );
        energy.setBounds( 300, 200, 100, 20 );

        rotation = new JLabel( "Rotation: " + stats.getTime( 3 ) );
        rotation.setBounds( 400, 200, 100, 20 );

        gravitation = new JLabel( "Gravitation: " + stats.getTime( 4 ) );
        gravitation.setBounds( 500, 200, 100, 20 );

        fluids = new JLabel( "Fluids: " + stats.getTime( 5 ) );
        fluids.setBounds( 600, 200, 100, 20 );

        kinematicsRight = new JLabel(
            "Kinematics: " + stats.getPercent( 0 ) );
        kinematicsRight.setBounds( 100, 350, 100, 20 );

        newtonRight = new JLabel( "Newton: " + stats.getPercent( 1 ) );
        newtonRight.setBounds( 200, 350, 100, 20 );

        energyRight = new JLabel( "Energy: " + stats.getPercent( 2 ) );
        energyRight.setBounds( 300, 350, 100, 20 );

        rotationRight = new JLabel( "Rotation: " + stats.getPercent( 3 ) );
        rotationRight.setBounds( 400, 350, 100, 20 );

        gravitationRight = new JLabel(
            "Graviation: " + stats.getPercent( 4 ) );
        gravitationRight.setBounds( 500, 350, 100, 20 );

        fluidsRight = new JLabel( "Fluids: " + stats.getPercent( 5 ) );
        fluidsRight.setBounds( 600, 350, 100, 20 );

        frame = new JFrame( "StatsMenu" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        c.add( back );
        c.add( text );
        c.add( avgTimePerProblem );
        c.add( avgNumRight );
        c.add( kinematics );
        c.add( newton );
        c.add( energy );
        c.add( rotation );
        c.add( gravitation );
        c.add( fluids );
        c.add( kinematicsRight );
        c.add( newtonRight );
        c.add( energyRight );
        c.add( rotationRight );
        c.add( gravitationRight );
        c.add( fluidsRight );

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