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
     * Returns the average percent for all the problems done, typically called
     * by TrainMenu. This sums the total number of problems right as well as the
     * total number of problems, then returns the correct average (after
     * checking for a dividing by 0 menu)
     * 
     * @return double percentage of problems, or 0.0 if no problems completed
     *         yet
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
            return (double)correct / total;
        }
        else
        {
            return 0.0;
        }
    }


    /**
     * Returns the percent when given the type as a parameter. This returns the
     * percent of problems right for a type of problem, and if there are no
     * problems (the index for that totalproblems is 0) then returns 0.0
     * 
     * @param type
     *            is the type of problem (categories determined previously)
     * @return double percentage right or 0.0 if no problems have been completed
     *         yet
     */
    public double getPercent( int type )
    {
        if ( totalProblems[type] != 0 )
        {
            return (double)correctProblems[type] / totalProblems[type];
        }
        else
        {
            return 0.0;
        }
    }


    /**
     * This method adds the proper number of problems correct and total number
     * of problems completed to the respective type of problem.
     * 
     * @param numCorrect
     *            is the number of problems the user correctly completed
     * @param TotalNum
     *            is the total number of problems
     * @param type
     *            is the category of problem
     */
    public void addScore( int numCorrect, int TotalNum, int type )
    {
        correctProblems[type] += numCorrect;
        totalProblems[type] += TotalNum;
    }


    /**
     * Returns the average time the user spent per problem in a specific
     * category, given by the category integer taken as a parameter. If no
     * problems have been completed, then 0.0 is returned
     * 
     * @param category
     *            is the type of problems that the average time is requested for
     * @return the average time spent per problem or 0.0 if no problems have
     *         been completed
     */
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


    /**
     * Returns the average time the user spent per problem in all the
     * categories, which means summing up the total times as well as the total
     * number of problems completed
     * 
     * @return 0.0 if no problems have been completed or the average time spent
     *         per all problems if problems have been attempted
     */
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