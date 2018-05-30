/**
 * This is the initial class which starts the entire program.
 *
 * @author Jason
 * @version May 30, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class QuickQuiz
{
    /**
     * Calls the StartMenu which starts the program
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        Statistics progressKeeper = new Statistics();
        StartMenu start = new StartMenu( progressKeeper );
    }
}