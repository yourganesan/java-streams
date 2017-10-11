import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by gnatarajan on 10/11/17.
 */
public class JavaStreamsExample
{

    List<Director> directors = null;
    public static void main(String[] args)
    {
        JavaStreamsExample example = new JavaStreamsExample();
        example.init();
        example.findDirectorsWhoHasDirectedAtLeastOneMovie();
        example.findAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie();
    }

    private void init()
    {
        Director[] dirArray = new Director[]{
                new Director("Spielberg",
                        Arrays.asList(new Movie[]{new Movie("Jurassic Park", true),
                                new Movie("Terminal", false)})),

                new Director("Cameroon",
                        Arrays.asList(new Movie[]{new Movie("Avatar", false),
                                new Movie("Terminator", true)})),

                new Director("Newbie", null)
        };

        directors = Arrays.asList(dirArray);
    }

    private void findDirectorsWhoHasDirectedAtLeastOneMovie()
    {
        System.out.println("findDirectorsWhoHasDirectedAtLeastOneMovie");
        directors.stream()
                .filter(d -> d.getMovies()!=null)
                .map(Director::getName)
                .forEach(System.out::println);

    }

    private void findAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie()
    {
        System.out.println("findAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie");
        directors.stream()
                .map(Director::getMovies)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

    }
    
}
