import java.io.*;
import java.util.*;


public class Statistics
{
    int[] totalProblems;

    int[] correctProblems;

    int time;

    ArrayList<ArrayList<Double>> quickQuizPercents;

    public Statistics()
    {
        quickQuizPercents = new ArrayList<ArrayList<Double>>();
        
        for(int i = 0; i < 6; i++)
        {
        		quickQuizPercents.add(new ArrayList<Double>());
        }
        
        totalProblems = new int[6];
        correctProblems = new int[6];
        time = 0;
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
    		int total = 0;
    		int correct = 0;
        for(int i = 0; i < 6; i++)
        {
        		correct += correctProblems[i];
        		total += totalProblems[i];
        }
        return correct/total;
    }
    
    public double getPercent(int type)
    {
        return correctProblems[type] / totalProblems[type];
    }


    public void addScore( int numCorrect, int TotalNum, int type )
    {
        correctProblems[type] += numCorrect;
        totalProblems[type] += TotalNum;
    }


    public double avgTimePerProblem()
    {
    		int total = 0;
		for(int i = 0; i < 6; i++)
		{
			total += totalProblems[i];
		}
        return (double)time / total;
    }
    
    
}