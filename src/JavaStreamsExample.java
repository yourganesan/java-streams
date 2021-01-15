import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by gnatarajan on 10/11/17.
 */
public class JavaStreamsExample
{
    private List<Director> directors = null;
    private Map<String, List<Movie>> directorMoviesMap = null;

    private void init()
    {
        Director[] dirArray = new Director[]{
                new Director("Spielberg",
                        Arrays.asList(new Movie("Jurassic Park", true), new Movie("Terminal", false))),

                new Director("Cameroon",
                        Arrays.asList(new Movie("Avatar", false), new Movie("Terminator", true))),

                new Director("Woody Allen",
                        Arrays.asList(
                                new Movie("Midnight in Paris", false),
                                new Movie("Annie Hall", false))),

                new Director("Newbie", null)
        };

        directors = Arrays.asList(dirArray);
        System.out.println("Input : "+ directors);
        directorMoviesMap = directors.stream()
                                .filter(d -> d.getMovies()!=null)
                                .collect(Collectors.toMap(Director::getName, Director::getMovies));
    }

    public static void main(String[] args)
    {
        JavaStreamsExample example = new JavaStreamsExample();
        example.init();
        example.runExamples();
    }

    private void runExamples()
    {
        findAllDirectorNames();
        findDirectorsWhoHasDirectedAtLeastOneMovie();
        findAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie();
        findAllMoviesOfAllDirectors();
        findAllMoviesOfADirector("Spielberg");
        findAllThrillerMoviesOfADirector("Cameroon");
        findAllDirectorsWhoHasDirectedAtLeastAThriller();
        findAllDirectorsWhoHasNotDirectedAThriller();


        convertToAMapOfDirectorAndMovieList();
    }


    private void findDirectorsWhoHasDirectedAtLeastOneMovie()
    {
        System.out.println("\nfindDirectorsWhoHasDirectedAtLeastOneMovie");
        directors.stream()
                .filter(d -> d.getMovies()!=null)
                .map(Director::getName)
                .forEach(System.out::println);

    }

    private void findAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie()
    {
        System.out.println("\nfindAllMoviesOfDirectorsWhoHasDirectedAtLeastOneMovie");
        directors.stream()
                .map(Director::getMovies)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }


    private void findAllMoviesOfAllDirectors()
    {
        System.out.println("\nfindAllMoviesOfAllDirectors");
        directors.stream()
                .map(Director::getMovies)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }

    private void findAllMoviesOfADirector(String directorName)
    {
        System.out.println("\nfindAllMoviesOfADirector : "+ directorName);
        directors.stream()
                .filter(director -> director.getName().equalsIgnoreCase(directorName))
                .map(Director::getMovies)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .forEach(System.out::println);

    }

    private void findAllThrillerMoviesOfADirector(String directorName)
    {
        System.out.println("\nfindAllThrillerMoviesOfADirector : "+ directorName);
        directors.stream()
                .filter(director -> director.getName().equalsIgnoreCase(directorName))
                .map(Director::getMovies)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Movie::isThriller)
                .forEach(System.out::println);

    }

    private void findAllDirectorNames()
    {
        System.out.println("\nfindAllDirectorNames");
        directors.stream()
                .map(Director::getName)
                .forEach(System.out::println);

    }

    private void findAllDirectorsWhoHasDirectedAtLeastAThriller()
    {
        System.out.println("\nfindAllDirectorsWhoHasDirectedAtLeastAThriller");
        directors.stream()
                .filter(d -> d.getMovies() !=null)
                .filter(d -> d.getMovies().stream().anyMatch(Movie::isThriller))
                .forEach(System.out::println);

    }

    private void findAllDirectorsWhoHasNotDirectedAThriller()
    {
        System.out.println("\nfindAllDirectorsWhoHasNotDirectedAThriller");
        directors.stream()
                .filter(d -> d.getMovies() !=null)
                .filter(d -> d.getMovies().stream().noneMatch(Movie::isThriller))
                .forEach(System.out::println);

    }

    private void convertToAMapOfDirectorAndMovieList()
    {
        System.out.println("\nconvertToAMapOfDirectorAndMovieList");
        directors.stream()
                .filter(d -> d.getMovies()!=null)
                .collect(Collectors.toMap(Director::getName, Director::getMovies))
                .entrySet()
                .forEach(System.out::println);

    }



}
