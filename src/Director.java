import java.util.List;

/**
 * Created by gnatarajan on 10/11/17.
 */
public class Director
{
    private String name;
    private List<Movie> movies;

    public Director(String name, List<Movie> movies)
    {
        this.name = name;
        this.movies = movies;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(List<Movie> movies)
    {
        this.movies = movies;
    }

    @Override
    public String toString()
    {
        return "Director{" + "name='" + name + '\'' + ", movies=" + movies + '}';
    }
}
