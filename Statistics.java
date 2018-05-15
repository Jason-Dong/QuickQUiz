import java.io.*;
import java.util.*;


public class Statistics
{
    int totalProblems;

    int correctProblems;

    int time;

    ArrayList<ArrayList<Float>> quickQuizPercents;

    public Statistics(int ClassCalledFrom, int TypeOfProblem, int NumCorrect, int TotalNumOfProbs)
    {
        quickQuizPercents = new ArrayList<ArrayList<Float>>();
        
        if (ClassCalledFrom == 0)
        {
            quickQuizPercents.add(Float.valueOf( (float)NumCorrect / TotalNumOfProbs ));
        }
    }
    
    public void addTime( int newTime )
    {
        time += newTime;
    }


    public int getTime()
    {
        return time;
    }


    public double getPercent()
    {
        return (double)correctProblems / (double)totalProblems;
    }


    public void addScore( int numCorrect, int TotalNum )
    {
        correctProblems += numCorrect;
        totalProblems += TotalNum;
    }


    public double avgTimePerProblem()
    {
        return (double)time / (double)totalProblems;
    }
    
    
}
