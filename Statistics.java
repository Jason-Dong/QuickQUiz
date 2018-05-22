import java.io.*;
import java.util.*;


public class Statistics
{
    /**
     * TotalProblems holds the total problems for each category, with the same
     * order throughout all the classes
     */
    int[] totalProblems;

    /**
     * Holds the numer of problems right for each category, with the same order
     * of categories as quickquiz
     */
    int[] correctProblems;

    /**
     * This double array holds all the percents for the different categories
     */
    Double[] quickQuizPercents;

    /**
     * This holds the times for all the different categories
     */
    int[] quickQuizTimes;


    /**
     * This constructs Statistics, initializing the quickQuizPercents to an
     * empty array of size 6 to hold the percents for each category of problems.
     * The quickQuizTimes array is initialized to an empty array also of size 6
     * to hold all of the times. All values are set to 0.0 (for
     * quickQuizPercents) or 0 (for quickQuizTimes), and totalProblems and
     * correctProblems are also initialized to empty integer arrays of size 6.
     */
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


    /**
     * Adds the time to the correct category, taking in two parameters: the time
     * to add and the category to which the time should go in.
     * 
     * @param category
     *            is the category of which the time should be added to
     * @param newTime
     *            is the increased amount of time of which should be added to
     *            the time integer array
     */
    public void addTime( int category, int newTime )
    {
        quickQuizTimes[category] += newTime;
    }


    /**
     * This returns the average amount of time spent on a category of problems,
     * which is the parameter taken in.
     * 
     * @param category
     *            is the category of the problems which the user wants to see
     *            the time of
     * @return the integer average number of seconds that the person has spent
     *         on each category of problems
     */
    public int getTime( int category )
    {
        if ( totalProblems[category] != 0 )
        {
            return quickQuizTimes[category] / totalProblems[category];
        }
        else
        {
            return 0;
        }
    }


    /**
     * TODO Write your method description here.
     * 
     * @return
     */
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
            return (double) correct / total;
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
            return (double) correctProblems[type] / totalProblems[type];
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