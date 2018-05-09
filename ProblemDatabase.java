import java.util.*;


public class ProblemDatabase
{
    ArrayList<ArrayList<Problem>> problemListCategories;
    ArrayList<Problem> problemListProblems;
    ArrayList<Problem> usedList;
    Problem prob;

    //Kinematics, Newton's, Energy, Rotation, Gravitation, Fluids

    public ProblemDatabase()
    {
        problemListCategories = new ArrayList<ArrayList<Problem>>();
        problemListProblems = new ArrayList<Problem>();
        problemListProblems.add( prob );
        problemListCategories.add( problemListProblems );
        
        problemList[0]
    }


    public void reset()
    {
        for (Problem x : usedList)
        {
            String type = x.getType();
            
        }
    }


    public void giveRandProblem()
    {
        
    }


    public void removeProblem()
    {

    }


    public void addProblem()
    {

    }
}
