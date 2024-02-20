import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OtherUnrelatedExamples {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubles = Arrays.asList(2.5, 3.6, 4.8, 1.2, 7.4);
        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "orange", "apple", "strawberry");

        String word = "magnanimity";


        // Find the sum of all even numbers in the list
        int sumOfEvenNums = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();


        // Find the average of all doubles in the list
        double averageOfDoubles = doubles
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);


        // .chars() converts the string to an IntStream
        long occurrences = word.chars()
                .filter(c -> c == 'i')
                .count();


        // .toCharArray converts the string to a char array
        char[] chars = word.toCharArray();


        // Sort the list of fruits in descending order of length
        List<String> sortedFruitsDesc = fruits
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();


        // Check if the list of numbers contains any duplicates
        boolean hasDuplicates = numbers
                .stream()
                .distinct()
                .count() != numbers.size();


        // Find the sum of all odd numbers in the list
        int sumOfAllNums = numbers
                .stream()
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);


        // Find the longest string in the list
        String longestString = fruits
                .stream()
                .max(Comparator.comparing(String::length))
                .orElse("empty");


        // Find the most frequent string in the list
        String appearedMost = fruits
                .stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())) // transform the stream into a Map<String, Long>. (Function.identity() = convenient way to create a function that takes an argument and returns the same argument.)
                .entrySet() // get a Set view of the mappings contained in this map. Each element in the returned set is a Map.Entry
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)) // to find the entry with the maximum count. This will give you a `Map.Entry<String, Long>` representing the most frequent string and its count.
                .map(Map.Entry::getKey) // used to transform the Map.Entry<String, Long> into a String by calling getKey() on the entry.
                .orElse(null);


        // Find the average of all numbers in the list
        double avg = numbers
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);


        // Find the number of strings that start with the letter 'a'
        long wordsStartWithA = fruits
                .stream()
                .filter(s -> s.startsWith("a"))
                .count();


        // Find the largest number in the list
        int largestNum = numbers
                .stream()
                .max(Comparator.comparing(Integer::intValue))
                .get();


        // Create a list of all strings that have more than 5 characters, sorted in descending order of length
        List<String> longerThanFiveCharsDesc = fruits
                .stream()
                .filter(s -> s.length() > 5)
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();


        // Find the product of all numbers in the list
        int productOfAll = numbers
                .stream()
                .reduce((a, b) -> a * b)
                .orElse(0);


        // Concatenate all strings in the list that have more than 5 characters
        String concatAllMoreThanFiveChars = fruits
                .stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.joining(""));


        // Find the second highest number in the list
        int secondHighest = numbers
                .stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .skip(numbers.size() - 2) // skip the last element since .size() is 10, but the last index is 9
                .findFirst()
                .get();


        // Given a list of strings, find the string which has the smallest number of unique characters.
        // Function to count unique characters in a string
        Function<String, Long> countUniqueChars = str -> str.chars().distinct().count();

        // Calculate the smallest number of unique characters in any string
                long minUniqueChars = fruits.stream()
                        .map(countUniqueChars)
                        .min(Long::compare)
                        .orElse(0L);

        // Filter the list to include only strings with the smallest number of unique characters
                List<String> stringsWithLeastUniqueChars = fruits.stream()
                        .filter(str -> countUniqueChars.apply(str) == minUniqueChars)
                        .toList();

        // Print the result
                stringsWithLeastUniqueChars.forEach(System.out::println);


        // Given a list of strings, find the string with the most vowels.
        // Function to count vowels in a string
        Function<String, Long> countVowels = str -> str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiouy".contains(c.toString()))
                .count();

        // Calculate the maximum number of vowels in any string
                long maxVowels = fruits.stream()
                        .map(countVowels)
                        .max(Long::compare)
                        .orElse(0L);

        // Filter the list to include only strings with the maximum number of vowels
                List<String> stringsWithMostVowels = fruits.stream()
                        .filter(str -> countVowels.apply(str) == maxVowels)
                        .toList();

        // Print the result
                stringsWithMostVowels.forEach(System.out::println);

    }
}
