import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Allows the user to remove problems, checking each field to ensure that all 
 * fields are completed and the file pathnames are valid. It also ensures that
 * nonexistent problems are not removed.
 *
 * @author Krishnakumar Bhattaram
 * @version May 19, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class RemoveMenu
{
	/**
	 * Holds the GUI elements
	 */
    private JFrame frame;

    /**
   	 * The problem database for this set
   	 */
    private ProblemDatabase problem;

    /**
	 * The text field for the problem name
	 */
    private JTextField namepathfield;

    /**
	 * Type of problem to add chosen by the buttons
	 */
    private int type;

    /**
	 * The button to select problem type as kinematics
	 */
    private JButton kinematics;

    /**
	 * The button to select problem type as newton's laws
	 */
    private JButton newton;

    /**
	 * The button to select problem type as energy
	 */
    private JButton energy;

    /**
	 * The button to select problem type as rotation
	 */
    private JButton rotation;

    /**
	 * The button to select problem type as gravitation
	 */
    private JButton gravitation;

    /**
   	 * The button to select problem type as fluids
   	 */
    private JButton fluids;

    /**
	 * The container of the frame
	 */
    private Container c;

    /**
	 * The text label to warn that the fields are not completed
	 */
    private JLabel warntxt;

    /**
	 * The text label to indicate that a problem was removed
	 */
    private JLabel newtxt;

    /**
	 * The text label to warn that the name is not in problem
	 */
    private JLabel notfoundtxt;
    
    /**
	 * The statistics from this set
	 */
    private Statistics stats;
    
    /**
     * The pane of the scroll menu
     */
    private JPanel pane;

    /**
     * The constructor, which makes visible the frame and adds the buttons and text fields
     * @param problem	
     * 			The problem database for this set
     * @param statistics
     * 			The statistics for this set
     */
    public RemoveMenu( ProblemDatabase problem, Statistics statistics, JFrame frame )
    {
        this.frame = frame;
        c = frame.getContentPane();
        type = -1;
        this.problem = problem;
        stats = statistics;

        JButton back = new JButton( "Back" );
        back.setBounds( 10, 10, 50, 50 );
        back.addActionListener( new BackButtonListener() );

        JLabel nametxt = new JLabel( "Problem to Remove's Name" );
        nametxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        nametxt.setBounds( 200, 180, 500, 20 );
        nametxt.setHorizontalAlignment( JLabel.LEFT );
        nametxt.setVerticalAlignment( JLabel.TOP );
        namepathfield = new JTextField();
        namepathfield.setBounds( 200, 200, 400, 20 );
        namepathfield.setText( "" );

        JLabel typetxt = new JLabel( "Choose Problem to Remove's Type (if known)" );
        typetxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        typetxt.setBounds( 200, 220, 500, 20 );
        typetxt.setHorizontalAlignment( JLabel.LEFT );
        typetxt.setVerticalAlignment( JLabel.TOP );

        kinematics = new JButton( "Kinematics" );
        kinematics.setBounds( 100, 240, 100, 20 );
        kinematics.addActionListener( new typeListener() );

        newton = new JButton( "Newton's Laws" );
        newton.setBounds( 200, 240, 100, 20 );
        newton.addActionListener( new typeListener() );

        energy = new JButton( "Energy" );
        energy.setBounds( 300, 240, 100, 20 );
        energy.addActionListener( new typeListener() );

        rotation = new JButton( "Rotation" );
        rotation.setBounds( 400, 240, 100, 20 );
        rotation.addActionListener( new typeListener() );

        gravitation = new JButton( "Gravitation" );
        gravitation.setBounds( 500, 240, 100, 20 );
        gravitation.addActionListener( new typeListener() );

        fluids = new JButton( "Fluids" );
        fluids.setBounds( 600, 240, 100, 20 );
        fluids.addActionListener( new typeListener() );
        
        JLabel choosetxt = new JLabel( "Or choose from the menu below" );
        choosetxt.setFont( new Font( "font", Font.PLAIN, 10 ) );
        choosetxt.setBounds( 200, 270, 500, 20 );
        choosetxt.setHorizontalAlignment( JLabel.LEFT );
        choosetxt.setVerticalAlignment( JLabel.TOP );

        JButton pathname = new JButton( "Enter" );
        pathname.setBounds( 300, 350, 200, 60 );
        pathname.addActionListener( new PathnameListener() );

        JLabel text = new JLabel( "Remove Problems" );
        text.setFont( new Font( "font", Font.PLAIN, 30 ) );
        text.setHorizontalAlignment( JLabel.CENTER );
        text.setBounds( 100, 30, 600, 100 );
        
        pane = new JPanel();
        initialize();
        JScrollPane scroll = new JScrollPane(pane);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setBounds(100, 290, 600, 50);
        
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
        
        c.add( choosetxt );
        c.add( scroll );

        frame.setResizable( false );
        frame.setVisible( true );
    }
    
    /**
     * By Krishnakumar Bhattaram
     * Adds all the problems in the problem ProblemDatabase as buttons to pane
     * and gives them the ClickedListener as an ActionListener
     */
    private void initialize()
    {
        for(Problem prob : problem.giveAllProblems())
        {
            JButton toadd = new JButton(prob.getName());
            toadd.addActionListener(new ClickedListener());
            pane.add( toadd );
        }
    }
    
    /**
     * 
     *  Handles when one of the problem buttons on the scroll menu is clicked.
     *  When the button is clicked, changes the namepathfield to display the problem
     *  name and the corresponding type is selected.
     *
     *  @author  Krishnakumar Bhattaram
     *  @version May 24, 2018
     *  @author  Period: 2
     *  @author  Assignment: QuickQuiz
     *
     *  @author  Sources: none
     */
    private class ClickedListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JButton name = (JButton)e.getSource();
            String problemname = name.getText();
            namepathfield.setText( problemname );
            Problem toRemove = null;
            for(Problem prob : problem.giveAllProblems())
            {
                if(prob.getName().equals( problemname ))
                {
                    toRemove = prob;
                    break;
                }
            }
            
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            if(toRemove == null)
            {
                warntxt.setVisible( true );
                System.out.println( "Fatal Error!" );
                return;
            }
            
            if(toRemove.getType() == 0)
            {
                kinematics.setEnabled( false );
                type = 0;
            }
            else if(toRemove.getType() == 1)
            {
                newton.setEnabled( false );
                type = 1;
            }
            else if(toRemove.getType() == 2)
            {
                energy.setEnabled( false );
                type = 2;
            }
            else if(toRemove.getType() == 3)
            {
                rotation.setEnabled( false );
                type = 3;
            }
            else if(toRemove.getType() == 4)
            {
                gravitation.setEnabled( false );
                type = 4;
            }
            else if(toRemove.getType() == 5)
            {
                fluids.setEnabled( false );
                type = 5;
            }
        }
    }
    
    /**
     * Handles when the back button is clicked; when clicked, returns to
     * MainMenu by closing all of TypeMenu and creating a MainMenu object.
     *
     * @author Austin Lei
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class BackButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            frame.removeAll();
            MainMenu mainMenu = new MainMenu( problem, stats, frame );
        }
    }
    
    /**
     * Handles when the enter button is clicked; when clicked, checks if all conditions are 
     * satisfied (if all fields are entered and all pathnames exist) and displays the appropriate
     * warnings/successes
     *
     * @author Krishnakumar Bhattaram
     * @version May 19, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class PathnameListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( namepathfield.getText().equals( "" ))
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
                    pane.removeAll();
                    initialize();
                    pane.repaint();
                    pane.revalidate();
                }
            }
        }
    }
    
    /**
     * Handles when one of the type buttons (ex. kinematics, energy, etc.)
     * are clicked; when clicked, changes the type field to match the topic chosen and
     * disables the chosen type button while enabling all other type buttons.
     *
     * @author Krishnakumar Bhattaram
     * @version May 24, 2018
     * @author Period: 2
     * @author Assignment: QuickQuiz
     *
     * @author Sources: none
     */
    private class typeListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            JButton clicked = (JButton)e.getSource();
            String name = clicked.getText();
            kinematics.setEnabled( true );
            newton.setEnabled( true );
            energy.setEnabled( true );
            rotation.setEnabled( true );
            gravitation.setEnabled( true );
            fluids.setEnabled( true );
            
            if(name == null)
            {
                warntxt.setVisible( true );
                newtxt.setVisible( false );
                notfoundtxt.setVisible( false );
                System.out.println( "Fatal Error!" );
                return;
            }
            
            if(name.equalsIgnoreCase( "Kinematics" ))
            {
                kinematics.setEnabled( false );
                type = 0;
            }
            else if(name.equalsIgnoreCase( "Newton's Laws" ))
            {
                newton.setEnabled( false );
                type = 1;
            }
            else if(name.equalsIgnoreCase( "Energy" ))
            {
                energy.setEnabled( false );
                type = 2;
            }
            else if(name.equalsIgnoreCase( "Rotation" ))
            {
                rotation.setEnabled( false );
                type = 3;
            }
            else if(name.equalsIgnoreCase( "Gravitation" ))
            {
                gravitation.setEnabled( false );
                type = 4;
            }
            else if(name.equalsIgnoreCase( "Fluids" ))
            {
                fluids.setEnabled( false );
                type = 5;
            }
        }
    }
}