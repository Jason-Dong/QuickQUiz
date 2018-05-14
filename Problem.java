public class Problem
{
    private String problemImage;

    private String solutionImage;

    private String name;

    private int type;

    private char answer;


    public Problem( String probim, String solim, String nam, int category, char ans )
    {
        problemImage = probim;
        solutionImage = solim;
        name = nam;
        type = category;
        answer = ans;
    }


    public String getProblemImage()
    {
        return problemImage;
    }


    public String getSolutionImage()
    {
        return solutionImage;
    }


    public String getName()
    {
        return name;
    }


    public int getType()
    {
        return type;
    }


    public char getAnswer()
    {
        return answer;
    }


    public void setProblemImage( String probim )
    {
        problemImage = probim;
    }


    public void setSolutionImage( String solim )
    {
        solutionImage = solim;
    }


    public void setName( String nam )
    {
        name = nam;
    }


    public void setType( int category )
    {
        type = category;
    }


    public void setAnswer( char ans )
    {
        answer = ans;
    }
}