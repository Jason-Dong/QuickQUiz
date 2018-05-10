import java.util.*;


public class ProblemDatabase
{
    ArrayList<ArrayList<Problem>> problemListCategories; // Kinematics,
                                                         // Newton's,
                                                         // Energy,
                                                         // Rotation,
                                                         // Gravitation,
                                                         // Fluids.

    ArrayList<Problem> problemListProblems;

    ArrayList<Problem> usedList;

    Problem prob;


    public ProblemDatabase()
    {
        problemListCategories = new ArrayList<ArrayList<Problem>>();
        problemListProblems = new ArrayList<Problem>();
    }


    public void reset()
    {
        for ( Problem x : usedList )
        {
            String type = x.getType();
            if ( type.equals( "Kinematics" ) )
                problemListCategories.get( 0 ).add( x );
            else if ( type.equals( "Newton's Laws" ) )
                problemListCategories.get( 1 ).add( x );
            else if ( type.equals( "Energy" ) )
                problemListCategories.get( 2 ).add( x );
            else if ( type.equals( "Rotation" ) )
                problemListCategories.get( 3 ).add( x );
            else if ( type.equals( "Gravitation" ) )
                problemListCategories.get( 4 ).add( x );
            else if ( type.equals( "Fluids" ) )
                problemListCategories.get( 5 ).add( x );
            usedList.remove( x );
        }
    }


    public Problem giveRandProblem()
    {
        return null;
    }


    public void removeProblem()
    {

    }


    public void addProblem()
    {

    }
}
