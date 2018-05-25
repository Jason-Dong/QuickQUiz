import java.io.*;
import java.util.*;


/**
 * Holds all of the physics problems that will be given. Can give random
 * problems to QQMenu and TrainMenu, and can remove or add problems into the
 * database.
 *
 * @author Austin Lei and Krishnakumar Bhattaram
 * @version May 25, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class ProblemDatabase
{
    /**
     * ArrayList of ArrayLists of the problems, with the upper ArrayList
     * corresponding to the type (0 = kinematics, 1=newton's laws, 2=energy,
     * 3=rotation, 4=gravitation, 5=fluids)
     */
    ArrayList<ArrayList<Problem>> problemListSorted;

    /**
     * ArrayList of all the Problems in random order
     */
    ArrayList<Problem> problemListUnsorted;

    /**
     * Stores all the problems that have been used.
     */
    ArrayList<Problem> usedList;


    // Kinematics, Newton's, Energy, Rotation, Gravitation, Fluids
    /**
     * Reading the file determined by pathfield, constructs all of the default
     * problems and stores them in the arrayLists, sorting them to put in the
     * sorted list and putting every problem into the unsorted list. The file
     * that the program is intended to read is problems.txt
     * 
     * @author Austin Lei
     * @param pathfield
     *            the path name of the file to read from
     */
    public ProblemDatabase( String pathfield )
    {
        problemListSorted = new ArrayList<ArrayList<Problem>>();
        problemListUnsorted = new ArrayList<Problem>();
        usedList = new ArrayList<Problem>();

        Scanner readIn = null;

        for ( int i = 0; i < 6; i++ )
        {
            problemListSorted.add( new ArrayList<Problem>() );
        }
        try
        {
            readIn = new Scanner( new File( pathfield ) );
        }
        catch ( FileNotFoundException exc )
        {
            System.out.println( "Cannot find problems file" );
            System.exit( 0 );
        }

        while ( readIn.hasNext() )
        {
            String problemImage = readIn.next();
            String solutionImage = readIn.next();
            String name = readIn.next();
            int category = readIn.nextInt();
            String answer = readIn.next();
            char ans = answer.charAt( 0 );

            Problem prob = new Problem( problemImage, solutionImage, name, category, ans );
            addProblem( prob );
        }

    }


    /**
     * Moves all of the usedList problems back unto the problemList arrayLists,
     * both unsorted and sorted. Called when QQMenu and TrainMenu are exited.
     * 
     * @author Austin Lei
     */
    public void reset()
    {

        while ( !usedList.isEmpty() )
        {
            Problem pr = usedList.get( 0 );
            usedList.remove( pr );
            problemListUnsorted.add( pr );
            problemListSorted.get( pr.getType() ).add( pr );
        }
    }


    /**
     * Finds a random problem of any type, takes it off the problemList
     * ArrayLists (both sorted and unsorted) and puts it onto the usedList, then
     * returns the problem.
     * 
     * @return a random problem of any type
     */
    public Problem giveRandProblem()
    {
        if ( problemListUnsorted.size() > 0 )
        {
            Problem prob = problemListUnsorted
                .get( (int)( Math.random() * problemListUnsorted.size() ) );
            problemListUnsorted.remove( prob );
            problemListSorted.get( prob.getType() ).remove( prob );
            usedList.add( prob );
            return prob;
        }
        return null;
    }


    /**
     * Finds a random problem of a certain type, takes it off the problemList
     * ArrayLists (both sorted and unsorted) and puts it onto the usedList, then
     * returns the problem.
     * 
     * @author Austin Lei
     * @param type
     *            the type of problems that are wanted
     * @return a random problem of a specific type
     */
    public Problem giveRandProblem( int type )
    {
        if ( problemListSorted.get( type ).size() > 0 )
        {
            Problem prob = problemListSorted.get( type )
                .get( (int)( Math.random() * problemListSorted.get( type ).size() ) );
            problemListUnsorted.remove( prob );
            problemListSorted.get( type ).remove( prob );
            usedList.add( prob );
            return prob;
        }
        return null;
    }


    /**
     * Removes problem of the given name from the arraylists. If the type is not
     * -1, checks if the found problem also matches the type. If the arraylists
     * does not contain a Problem of the name (or of name and type, if given),
     * then returns false. Otherwise, removes Problem and returns true.
     * 
     * @author Krishnakumar Bhattaram
     * @param name
     *            Name of the Problem to remove.
     * @param type
     *            Type of the problem to remove. Precondition: int from -1 to 5
     * @return whether or not the problem was removed correctly
     */
    public boolean removeProblem( String name, int type )
    {
        if ( type == -1 )
        {
            Problem toremove = null;
            for ( Problem p : problemListUnsorted )
            {
                if ( p.getName().equals( name ) )
                {
                    toremove = p;
                    break;
                }
            }

            if ( toremove == null )
            {
                return false;
            }

            problemListUnsorted.remove( toremove );
            problemListSorted.get( toremove.getType() ).remove( toremove );
            return true;
        }
        else
        {
            Problem toremove = null;
            for ( Problem p : problemListUnsorted )
            {
                if ( p.getName().equals( name ) && p.getType() == type )
                {
                    toremove = p;
                    break;
                }
            }

            if ( toremove == null )
            {
                return false;
            }

            problemListUnsorted.remove( toremove );
            problemListSorted.get( type ).remove( toremove );
            return true;
        }
    }


    /**
     * Checks if the problem to add shares a name with one in the database. If
     * it isn't, adds it to the ArrayLists that contain Problems and returns
     * true, false otherwise.
     * 
     * @author Krishnakumar Bhattaram
     * @param pr
     *            Problem to add
     * @return True if the problem is added, false if it shares a name
     */
    public boolean addProblem( Problem pr )
    {
        for ( Problem p : problemListUnsorted )
        {
            if ( p.getName().equals( pr.getName() ) )
            {
                return false;
            }
        }

        problemListSorted.get( pr.getType() ).add( pr );
        problemListUnsorted.add( pr );
        return true;
    }


    /**
     * Accessor method to all the Problems in this structure.
     * 
     * @author Krishnakumar Bhattaram
     * @return Unsorted ArrayList of all the problems in this structure
     */
    public ArrayList<Problem> giveAllProblems()
    {
        return problemListUnsorted;
    }
}