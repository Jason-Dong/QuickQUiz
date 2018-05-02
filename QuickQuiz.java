import javax.swing.*;


public class QuickQuiz
{
    public static void main (String[] args )
    {
        
        Problem prob = new Problem("hi", "bye", "hello", "hola", 'c');
        SolutionsMenu solutionsMenu = new SolutionsMenu(prob);
        solutionsMenu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        solutionsMenu.setBounds( 0, 0, 360, 140 );
        solutionsMenu.setVisible( true );
    }
}
