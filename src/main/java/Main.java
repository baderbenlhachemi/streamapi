import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("D", 8, Genre.THRILLER),
                new Movie("A", 10, Genre.ACTION),
                new Movie("C", 18, Genre.COMEDY),
                new Movie("B", 12, Genre.ACTION)
        );

        // forEach(Consumer): Executes a specified action for each element in the stream.
        movies.forEach(System.out::println);

        // map(Function): Transforms each element in the stream using a provided function.
        movies.stream()
                .map(Movie::getTitle)
                .forEach(System.out::println);

        // flatMap(Function): Flatten a stream of list of objects into a stream of objects.
        Stream<List<Integer>> myStream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        myStream.flatMap(list -> list.stream())
                .forEach(System.out::println); // 1, 2, 3, 4, 5, 6 (each number on a new line)

        // filter(Predicate): Returns a stream of elements that satisfy the given predicate.
        movies.stream()
                .filter(movie -> movie.getGenre() == Genre.ACTION)
                .forEach(System.out::println);

        // limit(long): Returns a stream of the first n elements.
        movies.stream()
                .limit(2)
                .forEach(System.out::println);

        // skip(long): Returns a stream of the remaining elements after discarding the first n elements.
        movies.stream()
                .skip(2)
                .forEach(System.out::println);

        // takeWhile(Predicate): Returns a stream of elements that satisfy the given predicate.
        movies.stream()
                .takeWhile(movie -> movie.getRating() > 10)
                .forEach(System.out::println);

        // dropWhile(Predicate): Returns a stream of the remaining elements after discarding the first elements that satisfy the given predicate.
        movies.stream()
                .dropWhile(movie -> movie.getRating() > 10)
                .forEach(System.out::println);

        // sorted(): sorts the elements of the stream in natural order.
        movies.stream()
                .sorted()
                .forEach(System.out::println);

        // sorted(Comparator): sorts the elements of the stream using the provided comparator.
        movies.stream()
                .sorted((m1, m2) -> m2.getRating() - m1.getRating())
                .forEach(System.out::println);

        // distinct(): Returns a stream of distinct elements (removes duplicates).
        Stream.of(1, 2, 3, 1, 2, 3, 4, 5)
                .distinct()
                .forEach(System.out::println); // 1, 2, 3, 4, 5 (each number on a new line)

        // Performs an action for each element in the stream without modifying its contents (useful for debugging).
        movies.stream()
                .peek(movie -> System.out.println("Before filter: " + movie))
                .filter(movie -> movie.getRating() > 10)
                .peek(movie -> System.out.println("After filter: " + movie))
                .forEach(System.out::println);

        // count(): Returns the number of elements in the stream.
        long count = movies.stream()
                .filter(movie -> movie.getRating() > 10)
                .count();

        // anyMatch(Predicate): Returns true if any element in the stream satisfies the given predicate.
        boolean anyMatch = movies.stream()
                .anyMatch(movie -> movie.getRating() > 10);

        // allMatch(Predicate): Returns true if all elements in the stream satisfy the given predicate.
        boolean allMatch = movies.stream()
                .allMatch(movie -> movie.getRating() > 10);

        // noneMatch(Predicate): Returns true if no elements in the stream satisfy the given predicate.
        boolean noneMatch = movies.stream()
                .noneMatch(movie -> movie.getRating() > 10);

        // findFirst(): Returns an Optional containing the first element in the stream, or an empty Optional if the stream is empty.
        Optional<Movie> first = movies.stream()
                .findFirst();

        // findAny(): Returns an Optional containing any element in the stream, or an empty Optional if the stream is empty.
        Optional<Movie> any = movies.stream()
                .findAny();

        // min(Comparator): Returns an Optional containing the minimum element in the stream, or an empty Optional if the stream is empty.
        Optional<Movie> min = movies.stream()
                .min((m1, m2) -> m1.getRating() - m2.getRating());

        // max(Comparator): Returns an Optional containing the maximum element in the stream, or an empty Optional if the stream is empty.
        Optional<Movie> max = movies.stream()
                .max((m1, m2) -> m1.getRating() - m2.getRating());

        // reduce(BinaryOperator): Reduces the elements of the stream to a single value using the provided binary operator.
        Optional<Integer> sumOfRatings = movies.stream()
                .map(Movie::getRating)
                .reduce(Integer::sum); // (a, b) -> a + b
        System.out.println(sumOfRatings.orElse(0));

        // reduce(T identity, BinaryOperator): Reduces the elements of the stream to a single value using the provided identity and binary operator.
        int sumOfRatingsWithIdentity = movies.stream()
                .map(Movie::getRating)
                .reduce(0, Integer::sum);

        // collect(Collector): Transforms the elements of the stream into a different form using the provided collector.
        List<Movie> actionMovies = movies.stream()
                .filter(movie -> movie.getGenre() == Genre.ACTION)
                .toList(); // [A, ACTION, 10 stars, B, ACTION, 12 stars]

        // collect(Collector): Transforms the elements of the stream into a different form using the provided collector.
        Map<String, Movie> moviesMap = movies.stream()
                .collect(Collectors.toMap(Movie::getTitle, Function.identity())); // {D=D, THRILLER, 8 stars, A=A, ACTION, 10 stars, C=C, COMEDY, 18 stars, B=B, ACTION, 12 stars}

        // collect(Supplier, BiConsumer, BiConsumer): Transforms the elements of the stream into a different form using the provided supplier, accumulator, and combiner.
        StringBuilder result = movies.stream()
                .map(Movie::getTitle)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append); // ACBD

        // collect(groupingBy): Groups the elements of the stream by a key and returns a map of the results.
        Map<Genre, Long> moviesByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting())); // {ACTION=2, THRILLER=1, COMEDY=1}

        // collect(partitioningBy): Partitions the elements of the stream into two groups according to a predicate and returns a map of the results.
        Map<Boolean, List<Movie>> moviesByRating = movies.stream()
                .collect(Collectors.partitioningBy(movie -> movie.getRating() > 10)); // {false=[D, THRILLER, 8 stars], true=[A, ACTION, 10 stars, C, COMEDY, 18 stars, B, ACTION, 12 stars]}

        // collect(joining): Joins the elements of the stream into a single string.
        String resultString = movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.joining(", ")); // A, C, B, D

    }
}
