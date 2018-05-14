import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AddMenu
{
    private JFrame frame;
    private ProblemDatabase problem;
    private JTextField problempathfield;
    private JTextField solutionpathfield;
    private JTextField namepathfield;
    private int type;
    private JButton kinematics;
    private JButton newton;
    private JButton energy;
    private JButton rotation;
    private JButton gravitation;
    private JButton fluids;
    private JButton a;
    private JButton b;
    private JButton cp;
    private JButton d;
    private JButton e;
    private char ans;
    
    public AddMenu(ProblemDatabase problem)
    {
        this.problem = problem;
        
        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );
        
        JLabel problemtxt = new JLabel( "Problem Image Pathname" );
        problemtxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        problemtxt.setBounds( 200, 180, 500, 20 );
        problemtxt.setHorizontalAlignment( problemtxt.LEFT );
        problemtxt.setVerticalAlignment( problemtxt.TOP);
        problempathfield = new JTextField();
        problempathfield.setBounds( 200, 200, 400, 20 );
       
        JLabel solutiontxt = new JLabel( "Solution Image Pathname" );
        solutiontxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        solutiontxt.setBounds( 200, 220, 500, 20 );
        solutiontxt.setHorizontalAlignment( solutiontxt.LEFT );
        solutiontxt.setVerticalAlignment( solutiontxt.TOP);
        solutionpathfield = new JTextField();
        solutionpathfield.setBounds( 200, 240, 400, 20 );
        
        JLabel nametxt = new JLabel( "Problem Name" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 260, 500, 20 );
        nametxt.setHorizontalAlignment( nametxt.LEFT );
        nametxt.setVerticalAlignment( nametxt.TOP);
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 280, 400, 20 );
        
        JLabel typetxt = new JLabel( "Choose Problem Type" );
        typetxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        typetxt.setBounds( 200, 300, 500, 20 );
        typetxt.setHorizontalAlignment( typetxt.LEFT );
        typetxt.setVerticalAlignment(typetxt.TOP);
        
        kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 100, 320, 100, 20 );
        kinematics.addActionListener( new kinematicsListener() );
        
        newton = new JButton( "Newton's Laws" );
        newton.setBounds( 200, 320, 100, 20 );
        newton.addActionListener( new newtonListener() );
        
        energy = new JButton( "Energy" );
        energy.setBounds( 300, 320, 100, 20 );
        energy.addActionListener( new energyListener() );
        
        rotation = new JButton( "Rotation" );
        rotation.setBounds( 400, 320, 100, 20 );
        rotation.addActionListener( new rotationListener() );
        
        gravitation = new JButton( "Gravitation" );
        gravitation.setBounds( 500, 320, 100, 20 );
        gravitation.addActionListener( new gravitationListener() );
        
        fluids = new JButton( "Fluids" );
        fluids.setBounds( 600, 320, 100, 20 );
        fluids.addActionListener( new fluidsListener() );
        
        JLabel answertxt = new JLabel( "Choose Answer:" );
        answertxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        answertxt.setBounds( 200, 345, 500, 20 );
        answertxt.setHorizontalAlignment( typetxt.LEFT );
        answertxt.setVerticalAlignment(typetxt.TOP);
        
        a = new JButton( "A" );
        a.setBounds( 200, 365, 50, 20 );
        a.addActionListener( new gravitationListener() );
        
        b = new JButton( "B" );
        b.setBounds( 250, 365, 50, 20 );
        b.addActionListener( new gravitationListener() );
        
        cp = new JButton( "C" );
        cp.setBounds( 300, 365, 50, 20 );
        cp.addActionListener( new gravitationListener() );
        
        d = new JButton( "D" );
        d.setBounds( 350, 365, 50, 20 );
        d.addActionListener( new gravitationListener() );
        
        e = new JButton( "E" );
        e.setBounds( 400, 365, 50, 20 );
        e.addActionListener( new gravitationListener() );
        
        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 600, 200, 50, 20 );
        pathname.addActionListener( new PathnameListener() );
        
        JLabel text = new JLabel( "Add Problems" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( text.CENTER );
        text.setBounds( 100, 30, 600, 100 );
        
        frame = new JFrame( "Fîzîk" );
        frame.setDefaultCloseOperation(0);
        Container c = frame.getContentPane();
        frame.setLayout( null );
        frame.setBounds( 0, 0, 800, 600 );
        
        c.add( back );
        c.add(text);
        c.add(pathname);
        
        c.add(problempathfield);
        c.add(problemtxt);
        c.add(solutionpathfield);
        c.add(solutiontxt);
        c.add(namepathfield);
        c.add(nametxt);
        
        c.add(typetxt);
        c.add(kinematics);
        c.add(newton);
        c.add(energy);
        c.add(rotation);
        c.add(gravitation);
        c.add(fluids);
        
        c.add(answertxt);
        c.add(a);
        c.add(b);
        c.add(cp);
        c.add(d);
        c.add(e);
        
        frame.setResizable( false );
        frame.setVisible( true );
    }
    
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            MainMenu mainMenu = new MainMenu( problem );
            frame.dispose();
        }
    }
    
    private class PathnameListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			//problem.addProblem(problempathfield.getText());
    			//Problem toadd = new Problem()
    			problempathfield.setText("");
    			solutionpathfield.setText("");
    			namepathfield.setText("");
    		}
    }
    
    private class kinematicsListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(false);
    			newton.setEnabled(true);
    		    energy.setEnabled(true);
    		    rotation.setEnabled(true);
    		    gravitation.setEnabled(true);
    		    fluids.setEnabled(true);
    			type = 0;
    		}
    }
    
    private class newtonListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(true);
    			newton.setEnabled(false);
    		    energy.setEnabled(true);
    		    rotation.setEnabled(true);
    		    gravitation.setEnabled(true);
    		    fluids.setEnabled(true);
    			type = 1;
    		}
    }
    
    private class energyListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(true);
    			newton.setEnabled(true);
    		    energy.setEnabled(false);
    		    rotation.setEnabled(true);
    		    gravitation.setEnabled(true);
    		    fluids.setEnabled(true);
    			type = 3;
    		}
    }
    
    private class rotationListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(true);
    			newton.setEnabled(true);
    		    energy.setEnabled(true);
    		    rotation.setEnabled(false);
    		    gravitation.setEnabled(true);
    		    fluids.setEnabled(true);
    			type = 4;
    		}
    }
    
    private class gravitationListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(true);
    			newton.setEnabled(true);
    		    energy.setEnabled(true);
    		    rotation.setEnabled(true);
    		    gravitation.setEnabled(false);
    		    fluids.setEnabled(true);
    			type = 4;
    		}
    }
    
    private class fluidsListener implements ActionListener
    {
    		public void actionPerformed(ActionEvent e)
    		{
    			kinematics.setEnabled(true);
    			newton.setEnabled(true);
    		    energy.setEnabled(true);
    		    rotation.setEnabled(true);
    		    gravitation.setEnabled(true);
    		    fluids.setEnabled(false);
    			type = 5;
    		}
    }
}
    