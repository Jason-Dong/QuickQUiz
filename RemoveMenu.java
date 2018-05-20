import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RemoveMenu
{
    private JFrame frame;

    private ProblemDatabase problem;

    private JTextField namepathfield;

    private int type;

    private JButton kinematics;

    private JButton newton;

    private JButton energy;

    private JButton rotation;

    private JButton gravitation;

    private JButton fluids;

    private Container c;

    private JLabel warntxt;

    private JLabel newtxt;

    private JLabel notfoundtxt;
    
    private Statistics stats;


    public RemoveMenu( ProblemDatabase problem, Statistics statistics )
    {
        type = -1;
        this.problem = problem;
        stats = statistics;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel nametxt = new JLabel( "Problem to Remove Name" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 180, 500, 20 );
        nametxt.setHorizontalAlignment( JLabel.LEFT );
        nametxt.setVerticalAlignment( JLabel.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 200, 400, 20 );

        JLabel typetxt = new JLabel( "Choose Problem to Remove's Type (if known)" );
        typetxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        typetxt.setBounds( 200, 220, 500, 20 );
        typetxt.setHorizontalAlignment( JLabel.LEFT );
        typetxt.setVerticalAlignment( JLabel.TOP );

        kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 100, 240, 100, 20 );
        kinematics.addActionListener( new kinematicsListener() );

        newton = new JButton( "Newton's Laws" );
        newton.setBounds( 200, 240, 100, 20 );
        newton.addActionListener( new newtonListener() );

        energy = new JButton( "Energy" );
        energy.setBounds( 300, 240, 100, 20 );
        energy.addActionListener( new energyListener() );

        rotation = new JButton( "Rotation" );
        rotation.setBounds( 400, 240, 100, 20 );
        rotation.addActionListener( new rotationListener() );

        gravitation = new JButton( "Gravitation" );
        gravitation.setBounds( 500, 240, 100, 20 );
        gravitation.addActionListener( new gravitationListener() );

        fluids = new JButton( "Fluids" );
        fluids.setBounds( 600, 240, 100, 20 );
        fluids.addActionListener( new fluidsListener() );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 600, 200, 50, 20 );
        pathname.addActionListener( new PathnameListener() );

        JLabel text = new JLabel( "Remove Problems" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 100 );

        frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation( 0 );
        c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );

        warntxt = new JLabel( "Please complete all required fields!" );
        warntxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        warntxt.setBounds( 200, 500, 500, 20 );
        warntxt.setHorizontalAlignment( JLabel.LEFT );
        warntxt.setVerticalAlignment( JLabel.TOP );
        warntxt.setVisible( false );

        newtxt = new JLabel( "Success! Remove a new problem or return to main menu." );
        newtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        newtxt.setBounds( 200, 500, 500, 20 );
        newtxt.setHorizontalAlignment( JLabel.LEFT );
        newtxt.setVerticalAlignment( JLabel.TOP );
        newtxt.setVisible( false );

        notfoundtxt = new JLabel( "Problem not found! Please check the fields" );
        notfoundtxt.setFont( new Font( "font", Font.PLAIN, 15 ) );
        notfoundtxt.setBounds( 200, 500, 500, 20 );
        notfoundtxt.setHorizontalAlignment( JLabel.LEFT );
        notfoundtxt.setVerticalAlignment( JLabel.TOP );
        notfoundtxt.setVisible( false );

        c.add( back );
        c.add( text );
        c.add( pathname );
        c.add( warntxt );
        c.add( newtxt );
        c.add( notfoundtxt );

        c.add( namepathfield );
        c.add( nametxt );

        c.add( typetxt );
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


    private class PathnameListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( namepathfield.getText() == "" )
            {
                newtxt.setVisible( false );
                warntxt.setVisible( true );
                notfoundtxt.setVisible( false );
            }
            else
            {
                if ( !problem.removeProblem( namepathfield.getText(), type ) )
                {
                    warntxt.setVisible( false );
                    newtxt.setVisible( false );
                    notfoundtxt.setVisible( true );
                }
                else
                {
                    namepathfield.setText( "" );
                    kinematics.setEnabled( true );
                    newton.setEnabled( true );
                    energy.setEnabled( true );
                    rotation.setEnabled( true );
                    gravitation.setEnabled( true );
                    fluids.setEnabled( true );
                    type = -1;
                    warntxt.setVisible( false );
                    newtxt.setVisible( true );
                    notfoundtxt.setVisible( false );
                }
            }
        }
    }


    private class kinematicsListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( false );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            type = 0;
        }
    }


    private class newtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( true );
            newton.setEnabled( false );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            type = 1;
        }
    }


    private class energyListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( false );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            type = 3;
        }
    }


    private class rotationListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( false );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            type = 4;
        }
    }


    private class gravitationListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( false );
            fluids.setEnabled( true );
            type = 4;
        }
    }


    private class fluidsListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( false );
            type = 5;
        }
    }
}