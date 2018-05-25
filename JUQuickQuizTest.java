import static org.junit.Assert.*;
import org.junit.Test;


/**
 * The JUnit class for QuickQuiz tests the ProblemDatabase class and the
 * Statistics class
 *
 * @author Jason Dong
 * @version 5/23/18
 * @author Assignment: QuickQuiz
 * 
 * @author Sources: none
 *
 */
public class JUQuickQuizTest
{
    // --Test TradeOrder
    /**
     * Quick Quiz Tests:
     * 
     */

    public Statistics tester = new Statistics();

    public String namePathField = "/Users/guest/Dropbox/workspaceAPCS/QuickQuiz/ProblemFile/problems.txt";

    public ProblemDatabase testing = new ProblemDatabase( namePathField );

    public Problem problem1 = new Problem( "probPath",
        "solutPath",
        "name",
        3,
        'C' );

    public Problem problem2 = new Problem( "probPath2",
        "solutionPath",
        "name2",
        3,
        'D' );


    @Test
    public void StatisticsConstructor()
    {
        assertNotNull( tester.quickQuizPercents );
        assertNotNull( tester.quickQuizTimes );
        assertNotNull( tester.totalProblems );
        assertNotNull( tester.correctProblems );

    }


    @Test
    public void StatisticsAddTime()
    {
        tester.addTime( 3, 2 );
        assertEquals( tester.quickQuizTimes[3], 2 );
    }


    @Test
    public void StatisticsGetTime()
    {
        tester.addTime( 3, 2 );
        assertEquals( tester.quickQuizTimes[3], 2 );
        assertEquals( tester.quickQuizTimes[0], 0 );
    }


    @Test
    public void StatisticsAddScore()
    {
        tester.addScore( 3, 4, 3 );
        assertEquals( tester.correctProblems[3], 3 );
        assertEquals( tester.totalProblems[3], 4 );
    }


    @Test
    public void StatisticsAvgTimePerProblem()
    {
        tester.addTime( 3, 2 );
        tester.addScore( 3, 4, 3 );
        assertEquals( tester.avgTimePerProblem( 3 ), 0.5, 0.1 );
        assertEquals( tester.avgTimePerProblem( 1 ), 0.0, 0.1 );
    }


    @Test
    public void StatisticsAvgTimePerProblemNoParameters()
    {
        tester.addTime( 3, 2 );
        tester.addScore( 3, 4, 3 );
        assertEquals( tester.avgTimePerProblem(), 0.5, 0.1 );
    }


    @Test
    public void ProblemDatabaseConstructor()
    {
        assertNotNull( testing.problemListSorted );
        assertNotNull( testing.problemListUnsorted );
        assertNotNull( testing.usedList );
    }


    @Test
    public void ProblemDatabaseReset()
    {
        testing.reset();
        assertEquals( testing.usedList.size(), 0 );
    }


    @Test
    public void ProblemDatabaseGiveRandProblemNoParameter()
    {
        assertNotEquals( testing.giveRandProblem(),
            testing.giveRandProblem() );
    }


    @Test
    public void ProblemDatabaseGiveRandProblem()
    {
        assertNotEquals( testing.giveRandProblem( 3 ),
            testing.giveRandProblem( 3 ) );
    }


    @Test
    public void ProblemDatabaseRemoveProblem()
    {
        testing.addProblem( problem1 );
        assertTrue( testing.removeProblem( "name", -1 ) );
        assertFalse( testing.removeProblem( "notName", -1 ) );
        
        testing.addProblem( problem2 );
        assertTrue( testing.removeProblem( "name2", 3 ) );
        testing.addProblem( problem2 );
        assertFalse( testing.removeProblem( "name223", 3 ) );
        testing.addProblem( problem2 );
        assertFalse( testing.removeProblem( "name2", 2 ) );
        testing.addProblem( problem2 );
        testing.addProblem( problem1 );
        assertTrue( testing.removeProblem( "name2", 3 ) );

    }


    @Test
    public void ProblemDatabaseAddProblem()
    {
        assertEquals( testing.addProblem( problem1 ), true );
    }


    @Test
    public void ProblemDatabaseGiveAllProblems()
    {
        assertNotNull( testing.giveAllProblems() );
    }
}
