import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class SolutionsMenu extends JFrame
{
    private static JFrame thisWindow;

    private Problem x;
    
    public SolutionsMenu(Problem problem)
    {
        JFrame frame = new JFrame("SolutionsMenu");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //frame.getContentPane().add( yellowLabel, BorderLayout.CENTER );
        Container c = frame.getContentPane();
        c.add( new JButton("OK") );
        frame.pack();
        frame.setVisible( true );
    }
}
