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
        
        JButton kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 100, 320, 150, 20 );
        kinematics.addActionListener( new PathnameListener() );
        
        JButton newton = new JButton( "Newton's Laws" );
        newton.setBounds( 250, 320, 150, 20 );
        newton.addActionListener( new PathnameListener() );
        
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
}
    