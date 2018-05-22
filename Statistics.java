import java.io.*;
import java.util.*;


public class Statistics
{
    int[] totalProblems;

    int[] correctProblems;

    Double[] quickQuizPercents;

    int[] quickQuizTimes;


    public Statistics()
    {
        quickQuizPercents = new Double[6];
        quickQuizTimes = new int[6];

        for ( int i = 0; i < 6; i++ )
        {
            quickQuizPercents[i] = 0.0;
            quickQuizTimes[i] = 0;
        }

        totalProblems = new int[6];
        correctProblems = new int[6];
    }


    public void addTime( int category, int newTime )
    {
        quickQuizTimes[category] += newTime;
    }


    public int getTime( int category )
    {
        return quickQuizTimes[category];
    }


    public double getPercent()
    {
        int total = 0;
        int correct = 0;
        for ( int i = 0; i < 6; i++ )
        {
            correct += correctProblems[i];
            total += totalProblems[i];
        }
        if ( total != 0 )
        {
            return correct / total;
        }
        else
        {
            return 0.0;
        }
    }


    public double getPercent( int type )
    {
        if ( totalProblems[type] != 0 )
        {
            return correctProblems[type] / totalProblems[type];
        }
        else
        {
            return 0.0;
        }
    }


    public void addScore( int numCorrect, int TotalNum, int type )
    {
        correctProblems[type] += numCorrect;
        totalProblems[type] += TotalNum;
    }


    public double avgTimePerProblem( int category )
    {
        if ( totalProblems[category] != 0 )
        {
            return (double)quickQuizTimes[category]
                / totalProblems[category];
        }

        else
        {
            return 0.0;
        }
    }


    public double avgTimePerProblem()
    {
        int total = 0;
        int totProblems = 0;
        for ( int i = 0; i < 6; i++ )
        {
            total += quickQuizTimes[i];
            totProblems += totalProblems[i];
        }
        if ( totProblems != 0 )
        {
            return (double)total / totProblems;
        }
        else
        {
            return 0.0;
        }
    }

}