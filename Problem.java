/**
 * 
 * A representation of a problem, containing the pathnames to a problem and
 * solution image, the name of the problem, the problem category (with 0 being
 * kinematics, 1, newton's laws, 2, energy, 3, rotation, 4, gravitation, and 5,
 * fluids), and the char answer, a through e.
 *
 * @author Krishnakumar Bhattaram
 * @version May 23, 2018
 * @author Period: 2
 * @author Assignment: QuickQuiz
 *
 * @author Sources: none
 */
public class Problem
{
    /**
     * The pathname of the problem image
     */
    private String problemImage;

    /**
     * The pathname of the solution image
     */
    private String solutionImage;

    /**
     * The name of the problem
     */
    private String name;

    /**
     * The type of the problem
     */
    private int type;

    /**
     * The problem's answer
     */
    private char answer;


    /**
     * Constructs the Problem class, and sets the fields to the corresponding
     * parameters
     * 
     * @param probim
     *            Pathname of the problem image
     * @param solim
     *            Pathname of the solution image
     * @param nam
     *            Name of the problem
     * @param category
     *            Problem category
     * @param ans
     *            Problem's answer
     */
    public Problem( String probim, String solim, String nam, int category, char ans )
    {
        problemImage = probim;
        solutionImage = solim;
        name = nam;
        type = category;
        answer = ans;
    }


    /**
     * 
     * Accessor for the problem pathname
     * 
     * @return problem image pathname
     */
    public String getProblemImage()
    {
        return problemImage;
    }


    /**
     * 
     * Accessor for the solution pathname
     * 
     * @return solution image pathname
     */
    public String getSolutionImage()
    {
        return solutionImage;
    }


    /**
     * Accessor for the name of the problem
     * 
     * @return problem's name
     */
    public String getName()
    {
        return name;
    }


    /**
     * Accessor for the type of the problem
     * 
     * @return problem's type, with with 0 being kinematics, 1, newton's laws,
     *         2, energy, 3, rotation, 4, gravitation, and 5, fluids
     */
    public int getType()
    {
        return type;
    }


    /**
     * Accessor for the answer of the problem
     * 
     * @return problem's answer (a through e)
     */
    public char getAnswer()
    {
        return answer;
    }


    /**
     * Mutator for the problem image pathname
     * 
     * @param probim
     *            Problem image pathname
     */
    public void setProblemImage( String probim )
    {
        problemImage = probim;
    }


    /**
     * Mutator for the solution image pathname
     * 
     * @param solim
     *            Solution image pathname
     */
    public void setSolutionImage( String solim )
    {
        solutionImage = solim;
    }


    /**
     * Mutator for the problem name
     * 
     * @param nam
     *            Problem name
     */
    public void setName( String nam )
    {
        name = nam;
    }


    /**
     * Mutator for the problem category
     * 
     * @param category
     *            Problem category, with with 0 being kinematics, 1, newton's
     *            laws, 2, energy, 3, rotation, 4, gravitation, and 5, fluids
     */
    public void setType( int category )
    {
        type = category;
    }


    /**
     * Mutator for the problem answer
     * 
     * @param ans
     *            Problem answer (a through e)
     */
    public void setAnswer( char ans )
    {
        answer = ans;
    }
}