import java.io.*;
import java.util.*;


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

    ArrayList<Problem> usedList;


    // Kinematics, Newton's, Energy, Rotation, Gravitation, Fluids
    /**
     * By Austin Lei TODO Write your method description here.
     * 
     * @param type
     * @return
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
     * By Austin Lei TODO Write your method description here.
     * 
     * @param type
     * @return
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
     * By Austin Lei TODO Write your method description here.
     * 
     * @param type
     * @return
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
     * By Austin Lei TODO Write your method description here.
     * 
     * @param type
     * @return
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
     * By Krishnakumar Bhattaram Removes problem of the given name from the
     * arraylists. If the type is not -1, checks if the found problem also
     * matches the type. If the arraylists does not contain a Problem of the
     * name (or of name and type, if given), then returns false. Otherwise,
     * removes Problem and returns true.
     * 
     * @param name
     *            Name of the Problem to remove.
     * @param type
     *            Type of the problem to remove. Precondition: int from -1 to 5
     * @return
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
     * By Krishnakumar Bhattaram Checks if the problem to add shares a name with
     * one in the database. If it isn't, adds it to the ArrayLists that contain
     * Problems and returns true, false otherwise.
     * 
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
     * By Krishnakumar Bhattaram Accessor method to all the Problems in this
     * structure.
     * 
     * @return Unsorted ArrayList of all the problems in this structure
     */
    public ArrayList<Problem> giveAllProblems()
    {
        return problemListUnsorted;
    }
}