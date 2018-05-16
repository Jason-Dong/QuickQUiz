import java.io.*;
import java.util.*;


public class ProblemDatabase
{
    ArrayList<ArrayList<Problem>> problemListSorted;

    ArrayList<Problem> problemListUnsorted;

    ArrayList<Problem> usedList;

    Problem prob;


    // Kinematics, Newton's, Energy, Rotation, Gravitation, Fluids
    
    public ProblemDatabase(String pathfield)
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

            prob = new Problem( problemImage, solutionImage, name, category, ans );
            addProblem( prob );
        }

    }


    public void reset()
    {
        for ( Problem pr : usedList )
        {
            usedList.remove( pr );
            problemListUnsorted.add( pr );
            problemListSorted.get( pr.getType() ).add( pr );

        }
    }


    public Problem giveRandProblem()
    {
        if ( problemListUnsorted.size() > 0 )
        {
            prob = problemListUnsorted.get( (int)Math.random() * problemListUnsorted.size() );
            problemListUnsorted.remove( prob );
            problemListSorted.get( prob.getType() ).remove( prob );
            usedList.add( prob );
            return prob;
        }
        return null;
    }


    public Problem giveRandProblem( int type )
    {
        if ( problemListUnsorted.size() > 0 )
        {
            prob = problemListSorted.get( type )
                .get( (int)Math.random() * problemListSorted.get( type ).size() );
            problemListUnsorted.remove( prob );
            problemListSorted.get( type ).remove( prob );
            usedList.add( prob );
            return prob;
        }
        return null;
    }
    
    public boolean removeProblem(String name, int type)
    {
        if(type == -1)
        {
            Problem toremove = null;
            for(Problem p : problemListUnsorted)
            {
                if(p.getName().equals(name))
                {
                    toremove = p;
                    break;
                }
            }
            
            if(toremove == null)
            {
                return false;
            }
            
            problemListUnsorted.remove( toremove );
            problemListSorted.get( toremove.getType() ).remove( toremove);
            return true;
        }
        else
        {
            Problem toremove = null;
            for(Problem p : problemListUnsorted)
            {
                if(p.getName().equals(name) && p.getType() == type)
                {
                    toremove = p;
                    break;
                }
            }
            
            if(toremove == null)
            {
                return false;
            }
            
            problemListUnsorted.remove( toremove );
            problemListSorted.get( type ).remove( toremove);
            return true;
        }
    }


    public boolean addProblem( Problem pr )
    {
        for(Problem p : problemListUnsorted)
        {
            if(p.getName().equals(pr.getName()))
            {
                return false;
            }
        }
        
        problemListSorted.get( pr.getType() ).add( pr );
        problemListUnsorted.add( pr );
        return true;
    }
}