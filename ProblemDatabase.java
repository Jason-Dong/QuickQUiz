import java.util.*;
import java.io.*;


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
    // seperate text file titled problems.txt
    {
        problemListCategories = new ArrayList<ArrayList<Problem>>();
        problemListProblems = new ArrayList<Problem>();
        try
        {
            InputStream file = new FileInputStream( "problems.rtf" );
            
        }
        catch ( IOException e )
        {
            System.out.print( "Excpetion" );
        }

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


    public Problem giveRandProblem( String type )
    {
        if ( type.equals( "Kinematics" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 0 ).size() + 1 );
            usedList.add( problemListCategories.get( 0 ).get( randNum ) );
            Problem temp = problemListCategories.get( 0 ).get( randNum );
            problemListCategories.get( 0 ).remove( randNum );
            return temp;
        }

        else if ( type.equals( "Newton's Laws" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 1 ).size() + 1 );
            usedList.add( problemListCategories.get( 1 ).get( randNum ) );
            Problem temp = problemListCategories.get( 1 ).get( randNum );
            problemListCategories.get( 1 ).remove( randNum );
            return temp;
        }
        else if ( type.equals( "Energy" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 2 ).size() + 1 );
            usedList.add( problemListCategories.get( 2 ).get( randNum ) );
            Problem temp = problemListCategories.get( 2 ).get( randNum );
            problemListCategories.get( 2 ).remove( randNum );
            return temp;
        }
        else if ( type.equals( "Rotation" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 3 ).size() + 1 );
            usedList.add( problemListCategories.get( 3 ).get( randNum ) );
            Problem temp = problemListCategories.get( 3 ).get( randNum );
            problemListCategories.get( 3 ).remove( randNum );
            return temp;
        }
        else if ( type.equals( "Gravitation" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 4 ).size() + 1 );
            usedList.add( problemListCategories.get( 4 ).get( randNum ) );
            Problem temp = problemListCategories.get( 4 ).get( randNum );
            problemListCategories.get( 4 ).remove( randNum );
            return temp;
        }
        else if ( type.equals( "Fluids" ) )
        {
            int randNum = (int)( Math.random()
                * problemListCategories.get( 5 ).size() + 1 );
            usedList.add( problemListCategories.get( 5 ).get( randNum ) );
            Problem temp = problemListCategories.get( 5 ).get( randNum );
            problemListCategories.get( 5 ).remove( randNum );
            return temp;
        }
        return null;
    }


    public void removeProblem( Problem temp )
    {
        String type = temp.getType();
        if ( type.equals( "Kinematics" ) )
            problemListCategories.get( 0 ).remove( temp );
        else if ( type.equals( "Newton's Laws" ) )
            problemListCategories.get( 1 ).remove( temp );
        else if ( type.equals( "Energy" ) )
            problemListCategories.get( 2 ).remove( temp );
        else if ( type.equals( "Rotation" ) )
            problemListCategories.get( 3 ).remove( temp );
        else if ( type.equals( "Gravitation" ) )
            problemListCategories.get( 4 ).remove( temp );
        else if ( type.equals( "Fluids" ) )
            problemListCategories.get( 5 ).remove( temp );
    }


    public void addProblem( Problem temp )
    {
        String type = temp.getType();
        if ( type.equals( "Kinematics" ) )
            problemListCategories.get( 0 ).add( temp );
        else if ( type.equals( "Newton's Laws" ) )
            problemListCategories.get( 1 ).add( temp );
        else if ( type.equals( "Energy" ) )
            problemListCategories.get( 2 ).add( temp );
        else if ( type.equals( "Rotation" ) )
            problemListCategories.get( 3 ).add( temp );
        else if ( type.equals( "Gravitation" ) )
            problemListCategories.get( 4 ).add( temp );
        else if ( type.equals( "Fluids" ) )
            problemListCategories.get( 5 ).add( temp );
    }
}
