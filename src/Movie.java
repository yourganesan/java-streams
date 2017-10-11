import java.util.List;

/**
 * Created by gnatarajan on 10/11/17.
 */
public class Movie
{
    private String name;
    private boolean isThriller;

    public Movie(String name, boolean isThriller)
    {
        this.name = name;
        this.isThriller = isThriller;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isThriller()
    {
        return isThriller;
    }

    public void setThriller(boolean thriller)
    {
        isThriller = thriller;
    }

    @Override
    public String toString()
    {
        return "Movie{" + "name='" + name + '\'' + ", isThriller=" + isThriller + '}';
    }
}
